# Exceção Checada e Não Checada em Java

## Conceito

Em Java, toda exceção tratável herda de **`Exception`**.

Dentro dessa hierarquia existem duas categorias com comportamentos bem diferentes:

```
Exception
├── Checked Exception       (verificada pelo compilador)
│   ├── IOException
│   ├── SQLException
│   └── FileNotFoundException
└── RuntimeException        (não verificada)
    ├── NullPointerException
    ├── ArithmeticException
    └── ArrayIndexOutOfBoundsException
```

A principal diferença é: **o compilador exige tratamento para Checked, mas não para RuntimeException.**

---

## Exceção Checada (Checked)

Uma exceção **checada** é verificada pelo compilador em tempo de compilação.

Isso significa que, se um método pode lançar uma exceção checada, o programador é **obrigado** a fazer uma das duas coisas:

### Opção 1 — Tratar com `try/catch`

Capturar e tratar a exceção diretamente no método.

```java
static void executar() {
    try {
        geraErro2();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
```

### Opção 2 — Propagar com `throws`

Passar a responsabilidade para o método que chamou este, declarando `throws` na assinatura.

```java
// Este método avisa: "posso lançar Exception, quem me chamar que trate"
static void executar() throws Exception {
    geraErro2();
}
```

O método que chamar `executar()` então precisará tratar ou propagar novamente.

### Lançando uma exceção checada

```java
// throws Exception na assinatura é OBRIGATÓRIO
static void geraErro2() throws Exception {
    throw new Exception("Ocorreu um erro bem legal #02!");
}
```

Sem o `throws Exception`, o código **não compila**.

---

## Exceção Não Checada (RuntimeException)

Uma exceção **não checada** herda de `RuntimeException`.

O compilador **não exige** nenhum tratamento. O código compila e executa normalmente — a exceção só aparece se realmente ocorrer em tempo de execução.

### Lançando uma exceção não checada

```java
// Nenhum throws na assinatura — compilador não exige
static void geraErro1() {
    throw new RuntimeException("Ocorreu um erro bem legal #01!");
}
```

### Tratamento opcional — só no `main`

Como o compilador não exige, é possível tratar somente onde for necessário — por exemplo, apenas no `main` — sem precisar declarar `throws` em todos os métodos da cadeia.

```java
public static void main(String[] args) {
    try {
        geraErro1(); // o tratamento fica apenas aqui
    } catch (RuntimeException e) {
        System.out.println(e.getMessage());
    }
}
```

---

## Exemplo Completo

Baseado em `ChecadaVsNaoChecada.java`:

```java
package excecao;

public class ChecadaVsNaoChecada {

    public static void main(String[] args) {

        // Tratando exceção NÃO checada
        try {
            geraErro1();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Tratando exceção CHECADA
        try {
            geraErro2();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Fim :)");
    }

    // Exceção NÃO checada — sem throws na assinatura
    static void geraErro1() {
        throw new RuntimeException("Ocorreu um erro bem legal #01!");
    }

    // Exceção CHECADA — throws Exception obrigatório
    static void geraErro2() throws Exception {
        throw new Exception("Ocorreu um erro bem legal #02!");
    }
}
```

### Fluxo de execução

```
main
 ├── chama geraErro1()  →  lança RuntimeException  →  capturado no catch
 ├── chama geraErro2()  →  lança Exception          →  capturado no catch
 └── imprime "Fim :)"
```

### Saída no console

```
Ocorreu um erro bem legal #01!
Ocorreu um erro bem legal #02!
Fim :)
```

---

## Resumo

| | Checked | Unchecked (RuntimeException) |
|---|---|---|
| **Herda de** | `Exception` | `RuntimeException` |
| **Compilador exige tratamento?** | Sim | Não |
| **`throws` na assinatura** | Obrigatório se não usar try/catch | Opcional |
| **Quando tratar** | Sempre — em todos os métodos da cadeia | Opcional — pode ser só no main |
| **Exemplos** | `IOException`, `SQLException` | `NullPointerException`, `ArithmeticException` |
| **Quando usar** | Situações externas (I/O, banco, rede) | Erros de lógica / programação |

> Para **checked exceptions**, o compilador te obriga a pensar no erro — isso é intencional para situações fora do seu controle. Para **RuntimeException**, o tratamento é opcional, mas recomendado nos pontos onde o erro é previsível.
