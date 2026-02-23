# Transformando Dados com `map()` e Lambda Expression em Java Streams

## 1. Conceito

O método `map()` é uma operação intermediária da API de Streams.

Ele transforma cada elemento da stream em outro elemento, aplicando uma função.

Assinatura simplificada:

```java
<R> Stream<R> map(Function<? super T, ? extends R> mapper)
```

* Recebe uma função
* Retorna uma nova Stream com os elementos transformados
* Não altera a coleção original
* É lazy (executa apenas quando existe operação terminal)

---

## 2. Transformando Array de Números

### Exemplo 1 — Dobrar valores

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploMapNumeros {

    public static void main(String[] args) {

        int[] numeros = {1, 2, 3, 4, 5};

        List<Integer> resultado =
            Arrays.stream(numeros)
                  .map(n -> n * 2)
                  .boxed()
                  .collect(Collectors.toList());

        System.out.println(resultado);
    }
}
```

Fluxo:

```
Array → Stream → map → collect
```

Transformação aplicada:

```
1 → 2
2 → 4
3 → 6
4 → 8
5 → 10
```

---

### Exemplo 2 — Converter número em String

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploNumeroParaString {

    public static void main(String[] args) {

        Integer[] numeros = {10, 20, 30};

        List<String> resultado =
            Arrays.stream(numeros)
                  .map(n -> "Valor: " + n)
                  .collect(Collectors.toList());

        System.out.println(resultado);
    }
}
```

Transformação:

```
10 → "Valor: 10"
20 → "Valor: 20"
30 → "Valor: 30"
```

---

## 3. Transformando Lista de Objetos

### Classe de exemplo

```java
public class Produto {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
```

---

### Exemplo 1 — Extrair apenas um atributo

```java
import java.util.List;
import java.util.stream.Collectors;

public class ExemploObjetoMap {

    public static void main(String[] args) {

        List<Produto> produtos = List.of(
            new Produto("Notebook", 3500),
            new Produto("Mouse", 150),
            new Produto("Teclado", 300)
        );

        List<String> nomes =
            produtos.stream()
                    .map(produto -> produto.getNome())
                    .collect(Collectors.toList());

        System.out.println(nomes);
    }
}
```

Transformação:

```
Produto → nome (String)
```

---

### Exemplo 2 — Aplicar aumento de preço

```java
List<Double> precosComAumento =
    produtos.stream()
            .map(p -> p.getPreco() * 1.10)
            .collect(Collectors.toList());
```

Transformação:

```
Produto → novo valor com 10% de aumento
```

---

### Exemplo 3 — Converter Objeto para DTO

DTO:

```java
public class ProdutoDTO {

    private String nome;
    private double preco;

    public ProdutoDTO(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}
```

Uso do map:

```java
List<ProdutoDTO> dtos =
    produtos.stream()
            .map(p -> new ProdutoDTO(p.getNome(), p.getPreco()))
            .collect(Collectors.toList());
```

Transformação:

```
Produto → ProdutoDTO
```

Esse é um uso muito comum em backend.

---

## 4. Exemplo Completo de Pipeline

```java
List<String> resultado =
    produtos.stream()
            .filter(p -> p.getPreco() > 200)
            .map(p -> p.getNome().toUpperCase())
            .sorted()
            .collect(Collectors.toList());
```

Pipeline:

```
Fonte → filter → map → sorted → collect
```

---

## 5. Quando Usar map()

Use `map()` quando precisar:

* Converter tipo (Integer → String)
* Extrair campo de objeto
* Criar DTO
* Aplicar cálculo
* Transformar dados antes de retornar resposta de API

---

## 6. Estrutura Mental

Cada elemento passa por uma função:

```
Elemento Original → Função Lambda → Novo Elemento
```

Exemplo simples:

```java
.map(n -> n * 2)
```

`n` é o elemento atual
`n * 2` é o novo valor gerado

O resultado é uma nova Stream contendo os elementos transformados.
