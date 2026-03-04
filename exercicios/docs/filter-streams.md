# Filter na API de Stream do Java

O **`filter`** na API de **Stream do Java** é usado para **filtrar elementos** com base em uma condição (predicado).

Ele recebe uma **expressão lambda** que retorna `true` ou `false`:
- Se retornar **true**, o elemento permanece na stream.
- Se retornar **false**, o elemento é descartado.

---

## Exemplo com Stream de Inteiros

Sequência:

```
3 - 2 - 4 - 7 - 8 - 7 - 6 - 1
```

### Critério (lambda):

```java
n -> n % 2 == 0
```

### Código:

```java
List<Integer> numeros = List.of(3, 2, 4, 7, 8, 7, 6, 1);

List<Integer> pares = numeros.stream()
    .filter(n -> n % 2 == 0)
    .toList();

System.out.println(pares);
```

### Resultado:

```
2 - 4 - 8 - 6
```

---

## Exemplo com Stream de Objetos

Suponha objetos com **nome e preço**:

```
A => 1200
B => 2356
C => 30
D => 97
```

### Critério (lambda):

```java
p -> p.getPreco() >= 1000
```

### Código:

```java
List<Produto> produtos = List.of(
    new Produto("A", 1200),
    new Produto("B", 2356),
    new Produto("C", 30),
    new Produto("D", 97)
);

List<Produto> caros = produtos.stream()
    .filter(p -> p.getPreco() >= 1000)
    .toList();
```

### Resultado:

```
A => 1200
B => 2356
```

---

## Resumo Final

- `filter()` é uma **operação intermediária** da Stream.
- Recebe um **Predicate<T>** (função que retorna boolean).
- Não modifica a coleção original.
- Retorna uma nova Stream apenas com os elementos que atendem à condição.

> Filter serve para selecionar elementos de uma stream com base em uma condição lógica.