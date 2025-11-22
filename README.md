# Calculadora Simples em Java

## Descrição
Este é um projeto de uma calculadora simples com interface gráfica (GUI) feita em Java usando Swing.
A calculadora realiza as operações matemáticas básicas: adição (+), subtração (-), multiplicação (×) e divisão (÷).

## Funcionalidades
- Interface gráfica intuitiva e fácil de usar
- Botões numéricos de 0 a 9
- Operações básicas: +, -, ×, ÷
- Botão de limpar (C) para resetar a calculadora
- Suporte para números decimais (botão .)
- Proteção contra divisão por zero
- Código totalmente comentado em português

## Como compilar
Para compilar o programa, execute no terminal:
```bash
javac Calculadora.java
```

## Como executar
Após compilar, execute o programa com:
```bash
java Calculadora
```

## Como usar a Calculadora
1. Clique nos botões numéricos para inserir números
2. Clique numa operação (+, -, ×, ÷)
3. Insira o segundo número
4. Clique no botão "=" para ver o resultado
5. Use o botão "C" para limpar e começar uma nova operação

## Estrutura do Código
O código está organizado numa única classe `Calculadora` que:
- Estende `JFrame` para criar a janela
- Implementa `ActionListener` para responder aos cliques nos botões
- Contém todos os componentes da interface (botões, display)
- Possui métodos para realizar os cálculos

## Comentários
Todo o código está comentado em português para facilitar a compreensão, adequado para estudantes do ensino secundário.