# Resumo Final — Módulo Stream API

## 1. Introdução

A **Stream API** foi introduzida no Java 8 e oferece uma forma funcional e declarativa de processar sequências de dados. Uma Stream não é uma estrutura de dados — ela processa elementos de uma fonte (Collection, array, gerador) através de um **pipeline** de operações.

```
fonte → [ op. intermediária → op. intermediária → ... ] → op. terminal
```

**Diferença entre Stream e Collection:**
- Collection armazena dados; Stream processa dados
- Stream é **lazy**: operações intermediárias só são executadas quando uma operação terminal é invocada
- Stream pode ser consumida apenas uma vez

---

## 2. Criando Streams

```java
// Stream.of() — valores diretos
Stream<String> s1 = Stream.of("Java", "Lua", "JS");

// Stream.of() / Arrays.stream() — de array
String[] langs = { "Python", "Go", "Rust" };
Stream.of(langs).forEach(System.out::println);
Arrays.stream(langs).forEach(System.out::println);

// Intervalo de array
Arrays.stream(langs, 1, 3).forEach(System.out::println); // Go, Rust

// De Collection
List<String> lista = Arrays.asList("C", "PHP", "Kotlin");
lista.stream().forEach(System.out::println);

// Stream paralela
lista.parallelStream().forEach(System.out::println);

// Streams infinitas (cuidado: usar com limit())
Stream.iterate(0, n -> n + 1).limit(10).forEach(System.out::println);
Stream.generate(() -> "a").limit(5).forEach(System.out::println);
```

---

## 3. Operações Intermediárias

Operações intermediárias retornam uma nova Stream e são **lazy** — formam o pipeline mas não executam até que uma operação terminal seja chamada.

### 3.1 `map()` — Transformação

Transforma cada elemento aplicando uma função. A assinatura é `map(Function<T, R>)`.

```java
List<String> marcas = Arrays.asList("BMW ", "Audi ", "Honda ");

// Transformação simples
marcas.stream()
    .map(m -> m.toUpperCase())
    .forEach(System.out::print); // BMW  AUDI  HONDA

// Composição de múltiplos map()
UnaryOperator<String> primeiraLetra = n -> n.charAt(0) + "";

marcas.stream()
    .map(Utilitarios.maiuscula)   // "BMW ", "AUDI ", "HONDA "
    .map(primeiraLetra)           // "B", "A", "H"
    .map(Utilitarios::grito)      // "B!!! ", "A!!! ", "H!!! "
    .forEach(System.out::print);
```

**Desafio (DesafioMap):** converter inteiros para binário, inverter e voltar para inteiro:

```java
List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

UnaryOperator<String> inverter = s -> new StringBuilder(s).reverse().toString();
Function<String, Integer> binarioParaInt = s -> Integer.parseInt(s, 2);

nums.stream()
    .map(Integer::toBinaryString) // 6 => "110"
    .map(inverter)                // "110" => "011"
    .map(binarioParaInt)          // "011" => 3
    .forEach(System.out::println);
```

---

### 3.2 `filter()` — Filtragem

Seleciona elementos que satisfazem um `Predicate<T>` (lambda que retorna `boolean`).

```java
List<Aluno> alunos = Arrays.asList(...);

Predicate<Aluno> aprovado = a -> a.nota >= 7;
Function<Aluno, String> saudacao = a -> "Parabéns " + a.nome + "! Você foi aprovado(a)!";

alunos.stream()
    .filter(aprovado)
    .map(saudacao)
    .forEach(System.out::println);
```

**Múltiplos filtros encadeados** (DesafioFilter — produtos em super promoção):

```java
Predicate<Produto> superpromocao = p -> p.desconto >= 0.30;
Predicate<Produto> freteGratis   = p -> p.valorFrete == 0;
Predicate<Produto> precoRelevante = p -> p.preco >= 300;

produtos.stream()
    .filter(superpromocao)
    .filter(freteGratis)
    .filter(precoRelevante)
    .map(p -> "Aproveite! " + p.nome + " por R$" + p.preco)
    .forEach(System.out::println);
```

**Filtro de gamers por liga:**

```java
Predicate<Gamer> ligaOuro  = g -> g.pontos >= 1000;
Predicate<Gamer> ligaPrata = g -> g.pontos >= 500 && g.pontos < 1000;
Predicate<Gamer> maisde100 = g -> g.qtdPartidas > 100;

// Liga ouro com mais de 100 jogos
gamers.stream()
    .filter(ligaOuro)
    .filter(maisde100)
    .forEach(...);
```

---

### 3.3 `distinct()`, `skip()`, `limit()`, `takeWhile()`

```java
List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5 /*duplicados*/, ...);

// distinct() — remove duplicatas (requer equals/hashCode corretos na classe)
alunos.stream()
    .distinct()
    .forEach(System.out::println);

// skip(n) — pula os primeiros N elementos
// limit(n) — limita a N elementos
alunos.stream()
    .distinct()
    .skip(2)
    .limit(2)
    .forEach(System.out::println);

// takeWhile(predicate) — pega elementos enquanto a condição for verdadeira (Java 9+)
Predicate<Aluno> aprovado = a -> a.nota >= 7;

alunos.stream()
    .distinct()
    .skip(2)
    .takeWhile(aprovado)
    .forEach(System.out::println);
```

> `distinct()` depende de `equals()` e `hashCode()` implementados corretamente na classe do elemento.

---

## 4. Operações Terminais

Operações terminais **consomem** a Stream e disparam a execução do pipeline.

### 4.1 `reduce()` — Redução

Transforma todos os elementos em um único resultado acumulado.

**Variação 1 — Sem valor inicial (retorna `Optional`):**

```java
BinaryOperator<Integer> soma = (ac, n) -> ac + n;

// Com parallelStream
int total = nums.parallelStream().reduce(soma).get();

// Com filter antes do reduce
nums.stream()
    .filter(n -> n > 5)
    .reduce(soma)
    .ifPresent(System.out::println);
```

**Variação 2 — Com valor inicial:**

```java
Integer total = nums.stream().reduce(100, soma); // começa do 100
```

**Variação 3 — Com combinador (para streams paralelas com tipo diferente):**

```java
BiFunction<Media, Double, Media> calcularMedia = (media, nota) -> media.adicionar(nota);
BinaryOperator<Media> combinarMedia = (m1, m2) -> Media.combinar(m1, m2);

Media media = alunos.stream()
    .filter(aprovado)
    .map(a -> a.nota)
    .reduce(new Media(), calcularMedia, combinarMedia);

System.out.println("Media da turma: " + media.getValor());
```

---

### 4.2 `allMatch()`, `anyMatch()`, `noneMatch()` — Correspondência

Verificam se elementos da Stream satisfazem um predicado. Retornam `boolean`.

```java
Predicate<Aluno> aprovado  = a -> a.nota >= 7;
Predicate<Aluno> reprovado = aprovado.negate(); // inverte o predicado

alunos.stream().allMatch(aprovado);   // true se TODOS satisfazem
alunos.stream().anyMatch(aprovado);   // true se AO MENOS UM satisfaz
alunos.stream().noneMatch(reprovado); // true se NENHUM satisfaz
```

---

### 4.3 `min()` e `max()`

Encontram o elemento mínimo ou máximo com base em um `Comparator`. Retornam `Optional`.

```java
Comparator<Aluno> porNota = (a1, a2) -> Double.compare(a1.nota, a2.nota);

// Aluno com maior nota
alunos.stream().max(porNota).get();

// Aluno com menor nota
alunos.stream().min(porNota).get();
```

---

### 4.4 Outros terminais

| Terminal | Descrição |
|---|---|
| `forEach(Consumer)` | Executa ação para cada elemento |
| `collect(Collector)` | Coleta elementos em uma Collection |
| `count()` | Conta o número de elementos |
| `findFirst()` | Retorna o primeiro elemento (Optional) |

---

## 5. Classes de suporte do módulo

| Classe | Atributos principais | Uso |
|---|---|---|
| `Aluno` | `nome`, `nota`, `bomComportamento` | Filter, Reduce, Match, MinMax |
| `Gamer` | `pontos`, `nick`, `qtdPartidas` | DesafioFilter (ligas) |
| `Produto` | `nome`, `preco`, `desconto`, `valorFrete` | DesafioFilterResolucao |
| `Media` | `total`, `quantidade` | Reduce3 (média com combinador) |
| `Utilitarios` | `maiuscula`, `primeiraLetra`, `grito()` | Map (composição de funções) |

> `Aluno` implementa `equals()` e `hashCode()` para permitir o uso correto de `distinct()`.

---

## 6. Desafios do módulo

### DesafioMap — Pipeline de transformação binária
Converte inteiros para binário, inverte a string e converte de volta.
- Classes: `DesafioMap.java`, `DesafioMapResolucao.java`
- Técnica: composição de `Function`, `UnaryOperator` e Method References (`Integer::toBinaryString`)

### DesafioFilter — Filtros múltiplos encadeados
- `DesafioFilter.java`: filtra gamers por liga (ouro/prata/bronze) e por quantidade de partidas
- `DesafioFilterResolucao.java`: filtra produtos por desconto, frete grátis e preço mínimo

### Reduce3 — Média com reduce de três parâmetros
Usa a variação completa de `reduce()` com `BiFunction` (acumulador) e `BinaryOperator` (combinador) para calcular a média de alunos aprovados.
- Classes: `Reduce3.java`, `Media.java`, `MediaTeste.java`

---

## 7. Boas práticas e dicas

- **Lazy evaluation:** operações intermediárias não executam sozinhas; sempre encerre o pipeline com uma operação terminal.
- **parallelStream:** use apenas para coleções grandes e operações CPU-bound sem efeitos colaterais. Para coleções pequenas, o overhead de paralelização não compensa.
- **distinct() exige equals/hashCode:** implemente corretamente na classe dos elementos, caso contrário duplicatas não serão detectadas.
- **Encadeamento:** combine operações para criar pipelines expressivos e legíveis, evitando loops imperativos.
- **Optional:** operações terminais como `reduce()` sem valor inicial, `findFirst()`, `min()` e `max()` retornam `Optional` — use `.get()`, `.ifPresent()` ou `.orElse()` adequadamente.
- **Imutabilidade:** prefira lambdas sem efeitos colaterais, especialmente com streams paralelas.
