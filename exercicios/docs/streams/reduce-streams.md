# Reduce no Java (Stream API)

## Conceito

O método `reduce` da Stream API do Java é usado para transformar uma sequência de elementos em um único resultado.

Ele reduz vários dados em apenas um, como por exemplo:

- Somar números
- Multiplicar valores
- Concatenar Strings
- Encontrar maior ou menor valor

---

## Exemplo com Stream de Inteiros

Sequência:

7 - 3 - 4 - 2 - 8 - 1 - 2 - 8

### Acumulador inicial

acumulador = 0

### Operação reduce

```java
reduce((acumulador, n) -> acumulador + n)
```

### Passo a passo

```
(0, 7)  -> 0 + 7  = 7
(7, 3)  -> 7 + 3  = 10
(10, 4) -> 10 + 4 = 14
(14, 2) -> 14 + 2 = 16
...
```

O processo continua até o último elemento.

---

## Código Completo

```java
import java.util.Arrays;
import java.util.List;

public class ExemploReduce {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(7, 3, 4, 2, 8, 1, 2, 8);

        int soma = numeros.stream()
                          .reduce(0, (acumulador, n) -> acumulador + n);

        System.out.println("Soma: " + soma);
    }
}
```

---

## Estrutura do reduce

### 1) Com valor inicial

```java
reduce(valorInicial, acumulador)
```

Exemplo:

```java
.reduce(0, Integer::sum)
```

---

### 2) Sem valor inicial (retorna Optional)

```java
reduce(acumulador)
```

Exemplo:

```java
.reduce((a, b) -> a + b)
```

Retorno:

```
Optional<Integer>
```

---

### 3) Com acumulador e combinador (usado em parallelStream)

```java
reduce(valorInicial, acumulador, combinador)
```

Usado principalmente quando a stream é paralela.

---

## Resumo

- Percorre todos os elementos da stream
- Usa um acumulador para armazenar o resultado parcial
- Retorna um único valor final
- Muito utilizado em programação funcional no Java