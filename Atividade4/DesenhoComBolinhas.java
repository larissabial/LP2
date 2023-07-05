package lp2.Atividade4;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class DesenhoComBolinhas {
    private ArrayList<Point> pontos = new ArrayList<>();
    private JFrame frame;

    public void criarGUI() {
        frame = new JFrame("Desenho com Bolinhas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DesenhoPanel desenhoPanel = new DesenhoPanel();
        frame.getContentPane().add(desenhoPanel, BorderLayout.CENTER);

        BolinhaMouseListener bolinhaMouseListener = new BolinhaMouseListener();
        desenhoPanel.addMouseListener(bolinhaMouseListener);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    private class DesenhoPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Point ponto : pontos) {
                g.setColor(Color.BLUE);
                g.fillOval(ponto.x, ponto.y, 20, 20);
            }
            for (int i = 0; i < pontos.size() - 1; i++) {
                Point ponto1 = pontos.get(i);
                Point ponto2 = pontos.get(i + 1);
                g.setColor(Color.RED);
                g.drawLine(ponto1.x + 10, ponto1.y + 10, ponto2.x + 10, ponto2.y + 10);
            }
        }
    }

    private class BolinhaMouseListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            pontos.add(e.getPoint());
            frame.repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DesenhoComBolinhas desenho = new DesenhoComBolinhas();
            desenho.criarGUI();
        });
    }
}

