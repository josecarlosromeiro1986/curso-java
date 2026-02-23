# Java Streams — Guia Completo

## 1. Build (Criação da Stream)

Uma Stream sempre nasce de uma fonte de dados.

### De uma Collection

```java
List<String> nomes = List.of("Ana", "João", "Carlos");
Stream<String> stream = nomes.stream();
```

### De um Array

```java
Stream<Integer> numeros = Arrays.stream(new Integer[]{1, 2, 3});
```

### De Valores Diretos

```java
Stream<String> s = Stream.of("A", "B", "C");
```

### Stream Infinita

```java
Stream<Integer> infinitos = Stream.iterate(0, n -> n + 1);
```

---

## 2. Operações Intermediárias

São operações que transformam a stream.
São lazy (não executam até existir operação terminal).
Sempre retornam outra Stream.

### filter()

Filtra elementos.

```java
nomes.stream()
     .filter(nome -> nome.startsWith("A"));
```

**Quando usar:**

* Filtrar usuários ativos
* Pedidos pagos
* Produtos com estoque

---

### map()

Transforma elementos.

```java
nomes.stream()
     .map(String::toUpperCase);
```

**Quando usar:**

* Converter entidade para DTO
* Extrair um campo específico
* Transformar tipos

---

### sorted()

Ordena elementos.

```java
nomes.stream()
     .sorted();
```

Com Comparator:

```java
.sorted(Comparator.comparing(String::length))
```

**Quando usar:**

* Ranking
* Listagem ordenada
* Relatórios

---

### distinct()

Remove duplicados.

```java
.stream().distinct();
```

---

### limit() e skip()

Paginação simples:

```java
.stream()
.skip(10)
.limit(10);
```

---

## 3. Operações Terminais

Disparam a execução da stream.
Sem operação terminal, nada acontece.

---

### forEach()

```java
.stream().forEach(System.out::println);
```

---

### collect()

A mais utilizada.

```java
List<String> resultado =
    nomes.stream()
         .filter(n -> n.length() > 3)
         .collect(Collectors.toList());
```

**Quando usar:**

* Retornar lista filtrada
* Agrupar dados
* Transformar em Map

---

### count()

```java
long total = nomes.stream().count();
```

---

### reduce()

Redução personalizada.

```java
int soma = List.of(1,2,3)
               .stream()
               .reduce(0, Integer::sum);
```

---

### findFirst() e anyMatch()

```java
.stream().anyMatch(n -> n.equals("Ana"));
```

**Quando usar:**

* Verificar existência
* Regras de negócio
* Validações

---

## 4. Streams Ordenadas vs Não Ordenadas

### Streams Ordenadas

Mantêm a ordem da fonte quando vêm de:

* List
* Array
* LinkedHashSet

```java
List.of(3,1,2).stream()
              .forEach(System.out::print);
// Saída: 3 1 2
```

---

### Streams Não Ordenadas

Quando vêm de:

* HashSet
* HashMap

A ordem não é garantida.

```java
Set<Integer> set = new HashSet<>(List.of(3,1,2));
set.stream().forEach(System.out::print);
// Ordem imprevisível
```

---

### unordered()

Pode melhorar performance em stream paralela quando ordem não importa.

```java
.stream().unordered();
```

---

## 5. Streams Paralelas

Permitem processamento paralelo.

```java
nomes.parallelStream()
     .forEach(System.out::println);
```

Ou:

```java
.stream().parallel();
```

---

### Quando usar stream paralela

Use quando:

* Processamento é pesado
* Lista é grande
* Operações são independentes

Exemplo:

```java
List<Integer> numeros = IntStream.range(1, 1_000_000)
                                 .boxed()
                                 .toList();

long total = numeros.parallelStream()
                    .filter(n -> n % 2 == 0)
                    .count();
```

---

### Quando não usar

* Operações com I/O (banco, API)
* Pequenas coleções
* Quando precisa manter ordem
* Quando usa estado mutável compartilhado

---

## 6. Exemplos Reais de Backend

### Filtrar usuários ativos

```java
usuarios.stream()
        .filter(Usuario::isAtivo)
        .collect(Collectors.toList());
```

---

### Converter entidade para DTO

```java
pedidos.stream()
       .map(PedidoDTO::new)
       .collect(Collectors.toList());
```

---

### Agrupar por categoria

```java
produtos.stream()
        .collect(Collectors.groupingBy(Produto::getCategoria));
```

---

### Somar valores

```java
double total = pedidos.stream()
                      .mapToDouble(Pedido::getValor)
                      .sum();
```

---

## Estrutura Mental

Uma Stream funciona como um pipeline:

```
Fonte → Operações Intermediárias → Operação Terminal
```

Exemplo completo:

```java
List<String> resultado =
    nomes.stream()
         .filter(n -> n.length() > 3)
         .map(String::toUpperCase)
         .sorted()
         .collect(Collectors.toList());
```
