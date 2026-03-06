# Pilha de Execução e Stack Trace em Java

## Conceito

A **pilha de execução** (call stack) é a estrutura que a JVM utiliza para controlar quais métodos estão sendo executados em um determinado momento.

Ela funciona como uma pilha real — **LIFO** (Last In, First Out):

- Cada vez que um método é chamado, ele é **adicionado ao topo** da pilha.
- Quando o método termina, ele é **removido do topo** da pilha.
- O método abaixo retoma a execução de onde parou.

### Estado da pilha

```
| metodC  |  ← topo (em execução)
| metodB  |
| metodA  |
| main    |  ← base
```

Quando `metodC` termina:

```
| metodB  |  ← topo (retoma execução)
| metodA  |
| main    |
```

---

## Exemplo de Pilha de Execução

### Código

```java
public class ExemploPilha {

    public static void main(String[] args) {
        System.out.println("Início do main");
        metodA();
        System.out.println("Fim do main");
    }

    static void metodA() {
        System.out.println("Início do metodA");
        metodB();
        System.out.println("Fim do metodA");
    }

    static void metodB() {
        System.out.println("Início do metodB");
        metodC();
        System.out.println("Fim do metodB");
    }

    static void metodC() {
        System.out.println("Executando metodC");
    }
}
```

### Fluxo de chamadas

```
main → metodA → metodB → metodC
```

### Estado da pilha em cada momento

```
Passo 1: main chamado
| main    |

Passo 2: main chama metodA
| metodA  |
| main    |

Passo 3: metodA chama metodB
| metodB  |
| metodA  |
| main    |

Passo 4: metodB chama metodC
| metodC  |
| metodB  |
| metodA  |
| main    |

Passo 5: metodC termina
| metodB  |
| metodA  |
| main    |

Passo 6: metodB termina
| metodA  |
| main    |

Passo 7: metodA termina
| main    |
```

### Saída no console

```
Início do main
Início do metodA
Início do metodB
Executando metodC
Fim do metodB
Fim do metodA
Fim do main
```

---

## O que é Stack Trace

O **stack trace** é a representação do estado da pilha de execução **no momento em que uma exceção ocorreu**.

Ele mostra a sequência completa de chamadas de métodos que levou até o erro, incluindo:

- Nome da **classe**
- Nome do **método**
- Nome do **arquivo** `.java`
- **Número da linha** onde ocorreu o problema

### Exemplo

Adicionando um erro intencional em `metodC`:

```java
static void metodC() {
    String texto = null;
    System.out.println(texto.length()); // NullPointerException
}
```

### Stack trace gerado no console

```
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "texto" is null
    at ExemploPilha.metodC(ExemploPilha.java:22)
    at ExemploPilha.metodB(ExemploPilha.java:16)
    at ExemploPilha.metodA(ExemploPilha.java:10)
    at ExemploPilha.main(ExemploPilha.java:4)
```

### Estrutura de uma linha do stack trace

```
at NomeDaClasse.nomeDoMetodo(NomeDoArquivo.java:numeroLinha)
```

Exemplo:

```
at ExemploPilha.metodC(ExemploPilha.java:22)
    ↑               ↑          ↑            ↑
  Classe         Método     Arquivo       Linha
```

---

## Como Interpretar o Stack Trace

O stack trace é lido de **baixo para cima** para entender a origem do problema.

### Stack trace do exemplo

```
at ExemploPilha.metodC(ExemploPilha.java:22)  ← onde o erro aconteceu
at ExemploPilha.metodB(ExemploPilha.java:16)  ← quem chamou metodC
at ExemploPilha.metodA(ExemploPilha.java:10)  ← quem chamou metodB
at ExemploPilha.main(ExemploPilha.java:4)     ← ponto de entrada
```

### Passo a passo para interpretar

**1. Leia a primeira linha** — ela informa o tipo da exceção e a mensagem:

```
java.lang.NullPointerException: Cannot invoke "String.length()" because "texto" is null
```

**2. Encontre o seu código no trace** — ignore linhas de bibliotecas externas (java.util, java.lang, frameworks):

```
at ExemploPilha.metodC(ExemploPilha.java:22)  ← seu código
at ExemploPilha.metodB(ExemploPilha.java:16)  ← seu código
at sun.reflect.NativeMethodAccessorImpl...    ← biblioteca (ignorar)
```

**3. Vá até a linha indicada** — abra o arquivo e a linha apontada para ver o código que causou o erro.

---

## Dica Importante

Ao encontrar um erro, a tendência é entrar em pânico com a quantidade de texto no console.

**Tenha paciência.**

> Leia o stack trace de **baixo para cima**. A linha mais acima mostra *onde* o erro aconteceu. As linhas abaixo mostram *como* o programa chegou até lá. Geralmente os erros estão diretamente ligados às informações presentes no stack trace — elas já apontam o caminho para a solução.
