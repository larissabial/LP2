package lp2.Atividade6;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class JogoDaVelha implements ActionListener {
    private JFrame frame;
    private JButton[] buttons;
    private JButton resetButton;
    private JLabel messageLabel;
    private ImageIcon xIcon;
    private ImageIcon oIcon;
    private boolean isPlayerX = true;

    public JogoDaVelha() {
        frame = new JFrame("Jogo da Velha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));

        buttons = new JButton[9];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }

        resetButton = new JButton("Resetar");
        resetButton.addActionListener(this);

        messageLabel = new JLabel("Vez do Jogador X");

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(resetButton, BorderLayout.SOUTH);
        frame.add(messageLabel, BorderLayout.NORTH);

        xIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("x.png")));
        oIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("o.png")));

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (clickedButton == resetButton) {
            reiniciarJogo();
        } else {
            if (clickedButton.getIcon() == null) {
                if (isPlayerX) {
                    clickedButton.setIcon(xIcon);
                    clickedButton.setDisabledIcon(xIcon);
                    messageLabel.setText("Vez do Jogador O");
                    playAudio("audio_x.wav");
                } else {
                    clickedButton.setIcon(oIcon);
                    clickedButton.setDisabledIcon(oIcon);
                    messageLabel.setText("Vez do Jogador X");
                    playAudio("audio_o.wav");
                }
                isPlayerX = !isPlayerX;
                clickedButton.setEnabled(false);
                verificarVitoria();
            }
        }
    }

    private void reiniciarJogo() {
        for (JButton button : buttons) {
            button.setIcon(null);
            button.setEnabled(true);
        }
        isPlayerX = true;
        messageLabel.setText("Vez do Jogador X");
    }

    private void verificarVitoria() {
        String[][] board = new String[3][3];

        for (int i = 0; i < buttons.length; i++) {
            int row = i / 3;
            int col = i % 3;
            if (buttons[i].getIcon() == xIcon) {
                board[row][col] = "X";
            } else if (buttons[i].getIcon() == oIcon) {
                board[row][col] = "O";
            } else {
                board[row][col] = "";
            }
        }

        // Verificar linhas
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].isEmpty() && board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
                JOptionPane.showMessageDialog(frame, "Vitória do Jogador " + board[i][0]);
                reiniciarJogo();
                return;
            }
        }

        // Verificar colunas
        for (int i = 0; i < 3; i++) {
            if (!board[0][i].isEmpty() && board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) {
                JOptionPane.showMessageDialog(frame, "Vitória do Jogador " + board[0][i]);
                reiniciarJogo();
                return;
            }
        }

        // Verificar diagonais
        if (!board[0][0].isEmpty() && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
            JOptionPane.showMessageDialog(frame, "Vitória do Jogador " + board[0][0]);
            reiniciarJogo();
            return;
        }

        if (!board[0][2].isEmpty() && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) {
            JOptionPane.showMessageDialog(frame, "Vitória do Jogador " + board[0][2]);
            reiniciarJogo();
            return;
        }

        // Verificar empate
        boolean isDraw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].isEmpty()) {
                    isDraw = false;
                    break;
                }
            }
        }

        if (isDraw) {
            JOptionPane.showMessageDialog(frame, "Empate");
            reiniciarJogo();
        }
    }

    private void playAudio(String audioFile) {
        try {
            var audioInputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getResource(audioFile)));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JogoDaVelha();
        });
    }
}

