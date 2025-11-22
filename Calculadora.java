// Importar as bibliotecas necessárias para criar a interface gráfica
import javax.swing.*; // Biblioteca para criar janelas e botões
import java.awt.*; // Biblioteca para organizar os componentes na janela
import java.awt.event.*; // Biblioteca para responder aos cliques nos botões

/**
 * Classe principal da Calculadora
 * Esta é uma calculadora simples que faz operações básicas: +, -, *, /
 */
public class Calculadora extends JFrame implements ActionListener {
    
    // Variáveis para armazenar os números e a operação
    private double numero1 = 0; // Primeiro número da operação
    private double numero2 = 0; // Segundo número da operação
    private String operacao = ""; // Operação escolhida (+, -, *, /)
    
    // Componentes da interface gráfica
    private JTextField display; // Campo de texto onde aparecem os números
    private JButton[] botoesNumeros; // Array com os botões dos números 0-9
    private JButton botaoMais, botaoMenos, botaoVezes, botaoDivisao; // Botões das operações
    private JButton botaoIgual, botaoLimpar, botaoPonto; // Botões de igual, limpar e ponto decimal
    
    /**
     * Construtor da Calculadora
     * Aqui configuramos a janela e criamos todos os componentes
     */
    public Calculadora() {
        // Configurar a janela principal
        setTitle("Calculadora Simples"); // Título da janela
        setSize(300, 400); // Tamanho da janela (largura, altura)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fechar programa ao clicar no X
        setResizable(false); // Não permitir redimensionar a janela
        setLocationRelativeTo(null); // Centralizar a janela no ecrã
        
        // Criar o painel principal com layout especial
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout()); // Organizar em regiões (topo, centro, etc)
        
        // Criar o display (campo de texto) no topo
        display = new JTextField("0"); // Começar com zero
        display.setEditable(false); // Não permitir escrever diretamente
        display.setFont(new Font("Arial", Font.BOLD, 24)); // Letra grande e negrito
        display.setHorizontalAlignment(JTextField.RIGHT); // Alinhar números à direita
        display.setPreferredSize(new Dimension(280, 50)); // Tamanho do display
        painelPrincipal.add(display, BorderLayout.NORTH); // Colocar no topo
        
        // Criar o painel dos botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(5, 4, 5, 5)); // 5 linhas, 4 colunas, espaçamento de 5
        
        // Criar os botões dos números (0 a 9)
        botoesNumeros = new JButton[10];
        for (int i = 0; i < 10; i++) {
            botoesNumeros[i] = new JButton(String.valueOf(i)); // Criar botão com número
            botoesNumeros[i].setFont(new Font("Arial", Font.BOLD, 18)); // Definir tamanho da letra
            botoesNumeros[i].addActionListener(this); // Adicionar listener para responder ao clique
        }
        
        // Criar os botões das operações
        botaoMais = new JButton("+");
        botaoMenos = new JButton("-");
        botaoVezes = new JButton("X");
        botaoDivisao = new JButton("/");
        botaoIgual = new JButton("=");
        botaoLimpar = new JButton("C");
        botaoPonto = new JButton(".");
        
        // Configurar a aparência dos botões de operação
        JButton[] botoesOperacao = {botaoMais, botaoMenos, botaoVezes, botaoDivisao, 
                                     botaoIgual, botaoLimpar, botaoPonto};
        for (JButton botao : botoesOperacao) {
            botao.setFont(new Font("Arial", Font.BOLD, 18));
            botao.addActionListener(this); // Adicionar listener para responder ao clique
        }
        
        // Cor especial para o botão de limpar (vermelho)
        botaoLimpar.setBackground(new Color(255, 100, 100));
        // Cor especial para o botão de igual (verde)
        botaoIgual.setBackground(new Color(100, 255, 100));
        
        // Organizar os botões no painel (como numa calculadora real)
        // Linha 1: C, ÷, ×, -
        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoDivisao);
        painelBotoes.add(botaoVezes);
        painelBotoes.add(botaoMenos);
        
        // Linha 2: 7, 8, 9, +
        painelBotoes.add(botoesNumeros[7]);
        painelBotoes.add(botoesNumeros[8]);
        painelBotoes.add(botoesNumeros[9]);
        painelBotoes.add(botaoMais);
        
        // Linha 3: 4, 5, 6
        painelBotoes.add(botoesNumeros[4]);
        painelBotoes.add(botoesNumeros[5]);
        painelBotoes.add(botoesNumeros[6]);
        painelBotoes.add(new JLabel("")); // Espaço vazio
        
        // Linha 4: 1, 2, 3
        painelBotoes.add(botoesNumeros[1]);
        painelBotoes.add(botoesNumeros[2]);
        painelBotoes.add(botoesNumeros[3]);
        painelBotoes.add(new JLabel("")); // Espaço vazio
        
        // Linha 5: 0, ., =
        painelBotoes.add(botoesNumeros[0]);
        painelBotoes.add(botaoPonto);
        painelBotoes.add(botaoIgual);
        painelBotoes.add(new JLabel("")); // Espaço vazio
        
        // Adicionar o painel de botões ao painel principal
        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);
        
        // Adicionar o painel principal à janela
        add(painelPrincipal);
    }
    
    /**
     * Método chamado quando um botão é clicado
     * @param e Evento que contém informação sobre o botão clicado
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Obter o texto do botão que foi clicado
        String comando = e.getActionCommand();
        
        // Verificar se foi clicado um número (0 a 9)
        if (comando.matches("[0-9]")) {
            // Se o display mostrar "0" ou uma operação, substituir pelo número clicado
            if (display.getText().equals("0") || 
                display.getText().equals("+") || 
                display.getText().equals("-") || 
                display.getText().equals("X") || 
                display.getText().equals("/")) {
                display.setText(comando);
            } else {
                // Caso contrário, adicionar o número ao final
                display.setText(display.getText() + comando);
            }
        }
        // Verificar se foi clicado o ponto decimal
        else if (comando.equals(".")) {
            // Se o display mostrar uma operação, começar novo número com "0."
            if (display.getText().equals("+") || 
                display.getText().equals("-") || 
                display.getText().equals("X") || 
                display.getText().equals("/")) {
                display.setText("0.");
            } else if (!display.getText().contains(".")) {
                // Só adicionar o ponto se ainda não existir um no display
                display.setText(display.getText() + ".");
            }
        }
        // Verificar se foi clicada uma operação (+, -, X, /)
        else if (comando.equals("+") || comando.equals("-") || 
                 comando.equals("X") || comando.equals("/")) {
            // Guardar o primeiro número
            numero1 = Double.parseDouble(display.getText());
            // Guardar a operação escolhida
            operacao = comando;
            // Mostrar a operação no display
            display.setText(comando);
        }
        // Verificar se foi clicado o botão de igual
        else if (comando.equals("=")) {
            // Verificar se o display contém um número válido
            String displayText = display.getText();
            if (!displayText.equals("+") && !displayText.equals("-") && 
                !displayText.equals("X") && !displayText.equals("/")) {
                // Guardar o segundo número
                numero2 = Double.parseDouble(displayText);
                // Calcular o resultado conforme a operação
                double resultado = 0;
            
            switch (operacao) {
                case "+": // Soma
                    resultado = numero1 + numero2;
                    break;
                case "-": // Subtração
                    resultado = numero1 - numero2;
                    break;
                case "X": // Multiplicação
                    resultado = numero1 * numero2;
                    break;
                case "/": // Divisão
                    // Verificar se não estamos a dividir por zero
                    if (numero2 != 0) {
                        resultado = numero1 / numero2;
                    } else {
                        // Mostrar mensagem de erro
                        JOptionPane.showMessageDialog(this, 
                            "Não é possível dividir por zero!", 
                            "Erro", 
                            JOptionPane.ERROR_MESSAGE);
                        limparCalculadora();
                        return; // Sair do método sem fazer mais nada
                    }
                    break;
            }
            
            // Mostrar o resultado no display
            // Se o resultado for um número inteiro, não mostrar casas decimais
            if (resultado == (int) resultado) {
                display.setText(String.valueOf((int) resultado));
            } else {
                display.setText(String.valueOf(resultado));
            }
            
            // Resetar as variáveis
            operacao = "";
            }
        }
        // Verificar se foi clicado o botão de limpar
        else if (comando.equals("C")) {
            limparCalculadora();
        }
    }
    
    /**
     * Método para limpar a calculadora
     * Reinicia todas as variáveis e o display
     */
    private void limparCalculadora() {
        display.setText("0"); // Voltar o display a zero
        numero1 = 0; // Limpar o primeiro número
        numero2 = 0; // Limpar o segundo número
        operacao = ""; // Limpar a operação
    }
    
    /**
     * Método principal - ponto de entrada do programa
     * @param args Argumentos da linha de comandos (não usado)
     */
    public static void main(String[] args) {
        // Usar o estilo visual do sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Se não conseguir, usar o estilo padrão do Java
            e.printStackTrace();
        }
        
        // Criar e mostrar a calculadora
        // SwingUtilities.invokeLater garante que a interface é criada na thread correta
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Calculadora calc = new Calculadora(); // Criar nova calculadora
                calc.setVisible(true); // Tornar a janela visível
            }
        });
    }
}
