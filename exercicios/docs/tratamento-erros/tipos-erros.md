# Tipos de Erros em Java

## 1. Por que Java tem categorias de erros distintas?

Em Java, o código-fonte `.java` precisa ser **compilado** antes de ser executado. O compilador gera um arquivo `.class` com **bytecode** — uma linguagem intermediária que a JVM (Java Virtual Machine) interpreta.

Esse processo de compilação cria duas janelas de tempo diferentes em que erros podem aparecer, cada uma com características e formas de tratamento bem distintas.

```
Código .java  →  Compilação  →  Bytecode .class  →  JVM executa
                     ↑                                    ↑
              Erros de compilação               Erros em tempo de execução
```

---

## 2. Erros de Compilação (Compile-time)

São erros detectados pelo compilador **antes mesmo de o programa rodar**. Enquanto existirem, o arquivo `.class` não é gerado e o programa não pode ser executado.

**Características:**
- São os mais fáceis de encontrar e corrigir
- A IDE sublinha o problema e aponta a linha exata
- O compilador descreve o tipo de erro com precisão

**Exemplos comuns:**

| Tipo | Exemplo |
|---|---|
| Erro de sintaxe | Falta de `;` ou `}` |
| Tipo incompatível | Atribuir `String` a um `int` |
| Variável não declarada | Usar variável antes de declarar |
| Import ausente | Usar `List` sem importar `java.util.List` |
| Método inexistente | Chamar método que não existe na classe |

```java
// Exemplo — erro de compilacao: tipo incompativel
int numero = "texto"; // ERRO: incompatible types
```

---

## 3. Erros em Tempo de Execução (Runtime)

São erros que **passam pela compilação sem problemas**, mas acontecem durante o uso real do sistema — quando dados inesperados são processados ou o ambiente não está como esperado.

**Características:**
- Não são detectados pelo compilador
- Exigem testes variados para serem encontrados
- É aqui onde aplicar **validações** faz a diferença
- Quando não tratados, causam a interrupção abrupta do programa

**Exemplos comuns:**

| Situação | Erro gerado |
|---|---|
| Acessar objeto nulo | `NullPointerException` |
| Índice fora do array | `ArrayIndexOutOfBoundsException` |
| Divisão por zero | `ArithmeticException` |
| Conversão inválida de tipo | `ClassCastException` |
| Arquivo não encontrado | `FileNotFoundException` |

```java
// Exemplo — erro em tempo de execução
String nome = null;
System.out.println(nome.length()); // NullPointerException em runtime
```

---

## 4. A Hierarquia `Throwable`

Toda situação de erro ou exceção em Java é representada por uma classe que herda de **`Throwable`** — a raiz da hierarquia de erros da linguagem.

```
Throwable
├── Error                        (critico — falha da JVM)
│   ├── OutOfMemoryError
│   ├── StackOverflowError
│   └── VirtualMachineError
└── Exception                    (excecao a regra — pode ser tratada)
    ├── IOException              (checked)
    ├── SQLException             (checked)
    ├── FileNotFoundException    (checked)
    └── RuntimeException         (unchecked — em tempo de execucao)
        ├── NullPointerException
        ├── ArrayIndexOutOfBoundsException
        ├── ArithmeticException
        └── ClassCastException
```

---

### 4.1 `Error` — Crítico

Representa **falhas graves da JVM ou do sistema operacional**. São situações onde o ambiente em si está comprometido.

- Geralmente **irrecuperáveis** — o programa não consegue se recuperar
- **Não devem ser capturados** pelo programador (não use `catch (Error e)`)
- Indicam um problema de infraestrutura, não de lógica

| Classe | Causa |
|---|---|
| `OutOfMemoryError` | JVM ficou sem memória heap |
| `StackOverflowError` | Recursão infinita esgotou a pilha de chamadas |

---

### 4.2 `Exception` — Exceção à Regra

Representa **situações anormais, mas recuperáveis**. O nome é intencional: uma "exceção" é algo fora do fluxo normal, mas que pode ser previsto e tratado.

Se divide em duas categorias:

#### Checked Exceptions (Verificadas)
- O compilador **obriga** que sejam declaradas ou tratadas
- A assinatura do método deve incluir `throws NomeException`
- Indicam situações externas ao programa (I/O, banco de dados, rede)

```java
// O compilador exige tratamento para IOException
public void lerArquivo(String caminho) throws IOException {
    FileReader file = new FileReader(caminho); // pode lancar IOException
}
```

#### Unchecked Exceptions — `RuntimeException`
- O compilador **não exige** tratamento explícito
- Geralmente indicam **bugs de programação** (lógica incorreta, dados não validados)
- Tratamento é opcional, mas recomendado nos pontos críticos

```java
// ArithmeticException nao é exigida pelo compilador, mas pode ocorrer
int resultado = 10 / 0; // lancara ArithmeticException
```

---

## 5. Por que tratar exceções?

Sem tratamento, qualquer exceção não capturada **interrompe o programa** e imprime um stack trace no console — péssima experiência para o usuário.

Tratar exceções permite:

- **Continuar a execução** do programa quando possível
- **Dar feedback claro** ao usuário sobre o que aconteceu
- **Registrar o erro** (logging) para diagnóstico posterior
- **Tomar ações de recuperação** (tentar de novo, usar valor padrão, etc.)

```java
// Sem tratamento — programa quebra
int resultado = 10 / 0; // ArithmeticException: / by zero

// Com tratamento — programa continua
try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Nao e possivel dividir por zero.");
}
