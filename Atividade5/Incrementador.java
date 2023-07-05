package lp2.Atividade5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Incrementador {
    private int valor = 0;
    private JFrame frame;
    private JLabel valorLabel;

    public void criarGUI() {
        frame = new JFrame("Incrementador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(3, 1));

        valorLabel = new JLabel("Valor: " + valor);
        valorLabel.setHorizontalAlignment(JLabel.CENTER);
        painel.add(valorLabel);

        JButton incrementarButton = new JButton("Incrementar");
        incrementarButton.addActionListener(new IncrementarListener());
        painel.add(incrementarButton);

        JButton zerarButton = new JButton("Zerar");
        zerarButton.addActionListener(new ZerarListener());
        painel.add(zerarButton);

        frame.getContentPane().add(painel);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }

    private class IncrementarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            valor++;
            valorLabel.setText("Valor: " + valor);
        }
    }

    private class ZerarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            valor = 0;
            valorLabel.setText("Valor: " + valor);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Incrementador incrementador = new Incrementador();
            incrementador.criarGUI();
        });
    }
}
