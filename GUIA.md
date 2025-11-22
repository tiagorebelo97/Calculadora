# Guia da Calculadora - Estrutura do Código

## Vista Geral
A calculadora tem 3 partes principais:

### 1. Variáveis de Estado
```
numero1     - Primeiro número da operação
numero2     - Segundo número da operação  
operacao    - Operação escolhida (+, -, X, /)
```

### 2. Componentes Visuais
```
display           - Campo de texto que mostra os números
botoesNumeros[]   - Array com 10 botões (0-9)
botaoMais         - Botão de adição (+)
botaoMenos        - Botão de subtração (-)
botaoVezes        - Botão de multiplicação (X)
botaoDivisao      - Botão de divisão (/)
botaoIgual        - Botão para calcular resultado (=)
botaoLimpar       - Botão para resetar (C)
botaoPonto        - Botão para números decimais (.)
```

### 3. Métodos Principais

#### `Calculadora()` - Construtor
- Cria a janela
- Configura o display
- Cria todos os botões
- Organiza tudo no ecrã

#### `actionPerformed(ActionEvent e)` - Responde aos cliques
- Quando clicas num número → adiciona ao display
- Quando clicas numa operação → guarda o número e a operação
- Quando clicas no "=" → faz o cálculo e mostra o resultado
- Quando clicas no "C" → limpa tudo

#### `limparCalculadora()` - Limpa tudo
- Volta o display a "0"
- Limpa os números guardados
- Limpa a operação escolhida

#### `main()` - Inicia o programa
- Cria a calculadora
- Mostra a janela

## Como Funciona uma Operação

### Exemplo: 5 + 3 = 8

1. **Clicas no "5"**
   - Display mostra: "5"

2. **Clicas no "+"**
   - numero1 = 5
   - operacao = "+"
   - Display mostra: "+"

3. **Clicas no "3"**
   - Display mostra: "3"

4. **Clicas no "="**
   - numero2 = 3
   - Cálculo: 5 + 3 = 8
   - Display mostra: "8"

## Layout dos Botões

```
┌─────────────────────────────┐
│        Display: 0           │
├───────┬───────┬───────┬─────┤
│   C   │   /   │   X   │  -  │
├───────┼───────┼───────┼─────┤
│   7   │   8   │   9   │  +  │
├───────┼───────┼───────┼─────┤
│   4   │   5   │   6   │     │
├───────┼───────┼───────┼─────┤
│   1   │   2   │   3   │     │
├───────┼───────┼───────┼─────┤
│   0   │   .   │   =   │     │
└───────┴───────┴───────┴─────┘
```

## Conceitos Java Usados

### Bibliotecas (import)
- `javax.swing.*` - Para criar janelas e botões
- `java.awt.*` - Para organizar componentes
- `java.awt.event.*` - Para responder a eventos (cliques)

### Classe
- `public class Calculadora extends JFrame` - A nossa calculadora é uma janela

### Interface
- `implements ActionListener` - Para responder aos cliques nos botões

### Variáveis
- `private double numero1` - Variável privada para guardar números
- `private JButton botao` - Variável para guardar um botão

### Métodos
- `public void actionPerformed()` - Método que é chamado ao clicar
- `private void limparCalculadora()` - Método auxiliar privado

### Construtor
- `public Calculadora()` - Método especial que cria o objeto

### Eventos
- `addActionListener(this)` - Regista que queremos ser notificados dos cliques

## Dicas para Modificar o Código

1. **Mudar cores:**
   - Procura `setBackground(new Color(...))`
   - Usa valores RGB: `new Color(R, G, B)`

2. **Mudar tamanho da janela:**
   - Procura `setSize(300, 400)`
   - Primeiro valor = largura, segundo = altura

3. **Mudar tamanho das letras:**
   - Procura `new Font("Arial", Font.BOLD, 24)`
   - Último número é o tamanho

4. **Adicionar mais operações:**
   - Cria um novo botão (ex: botaoRaiz)
   - Adiciona ao painel
   - Adiciona lógica no actionPerformed()

## Possíveis Melhorias Futuras

- [ ] Adicionar operação de percentagem (%)
- [ ] Adicionar memória (M+, M-, MR, MC)
- [ ] Adicionar raiz quadrada (√)
- [ ] Adicionar potência (x²)
- [ ] Histórico de operações
- [ ] Atalhos de teclado
