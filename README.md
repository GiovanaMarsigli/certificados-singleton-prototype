# Sistema de Emissão de Certificados — Singleton + Prototype

Atividade prática de Padrões de Projeto (ADS): implementação em Java dos padrões
**Singleton** (Fila de Impressão) e **Prototype** (Certificado), simulando a
emissão de certificados de conclusão de curso pela secretaria.

## Diagrama UML

```
┌───────────────────────────────────┐        ┌───────────────────────────────────┐
│           FilaDeImpressao          │        │             Certificado             │
├───────────────────────────────────┤        ├───────────────────────────────────┤
│ - instance: FilaDeImpressao(estát.)│        │ - nomeCurso: String                 │
├───────────────────────────────────┤        │ - nomeAluno: String                 │
│ - FilaDeImpressao()                │        ├───────────────────────────────────┤
│ + getInstance(): FilaDeImpressao   │────────│ + Certificado(nomeCurso: String)    │
│ + imprimir(documento: String): void│        │ + clonar(): Certificado             │
└───────────────────────────────────┘        │ + setNomeAluno(nome: String): void  │
                                              │ + getDados(): String                │
                                              └───────────────────────────────────┘
```

## Estrutura do projeto

```
src/
 ├─ FilaDeImpressao.java   → Padrão Singleton
 ├─ Certificado.java       → Padrão Prototype
 └─ Main.java              → Classe de execução (roteiro da atividade)
```

## Como cada padrão foi implementado

### 1. Singleton — `FilaDeImpressao`
- O construtor é **privado**, então nenhuma outra classe consegue criar uma
  instância com `new FilaDeImpressao()`.
- Existe um atributo estático `instance` que guarda a única instância da classe.
- O método estático `getInstance()` verifica se a instância já existe: se não
  existir, cria; se já existir, devolve sempre a mesma. Isso garante que só
  exista **uma conexão** com a impressora central durante toda a execução do
  sistema — evitando documentos misturados ou travamentos.
- O método `imprimir(String documento)` simula o envio do certificado para a
  impressora.

### 2. Prototype — `Certificado`
- A classe implementa `Cloneable` e sobrescreve o método `clonar()`, que
  internamente chama `super.clone()` (clonagem rasa do Java).
- O construtor `Certificado(String nomeCurso)` representa a criação do
  certificado **original/padrão** — simulando o carregamento pesado da arte e
  dos dados do curso a partir do banco de dados. O `nomeAluno` começa vazio.
- A partir do certificado original, o método `clonar()` gera cópias
  independentes na memória, sem precisar repetir o carregamento pesado.
- `setNomeAluno(String nome)` personaliza cada clone com o nome de um aluno
  diferente, e `getDados()` monta a string final que será enviada para
  impressão.

## Roteiro executado em `Main.java`

1. **Preparação:** solicita a instância única de `FilaDeImpressao` via
   `getInstance()`.
2. **O molde:** cria o certificado original com `new Certificado("Análise e
   Desenvolvimento de Sistemas")`, deixando o nome do aluno em branco.
3. **A clonagem:** gera `clone1` e `clone2` a partir do certificado original
   usando `clonar()`.
4. **Personalização:** usa `setNomeAluno()` para atribuir um nome de aluno
   diferente a cada clone.
5. **Impressão:** envia `getDados()` de cada clone para `imprimir()` da fila.
6. **Validação do Prototype:** imprime no console o teste
   `clone1 == clone2`, que resulta em **`false`**, comprovando que a
   clonagem gerou dois objetos distintos e independentes na memória (não são
   a mesma referência).
7. **Validação extra do Singleton:** solicita `getInstance()` novamente e
   compara com a primeira instância (`fila == filaNovamente`), resultando em
   **`true`** — provando que sempre é reaproveitada a mesma fila de
   impressão.

## Saída esperada no console (resumida)

```
===== 6. VALIDAÇÃO DO PROTOTYPE =====
Teste de memória (clone1 == clone2): false

===== 7. VALIDAÇÃO DO SINGLETON (extra) =====
Teste de memória (fila == filaNovamente): true
```

## Como compilar e executar

Pré-requisito: Java JDK instalado (testado com JDK 21).

```bash
cd src
javac *.java
java Main
```

Alunas: Giovana Marsigli e Mariana Akemi
