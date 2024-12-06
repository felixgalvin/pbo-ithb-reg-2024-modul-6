package View;

import javax.swing.*;

import Controller.PencarianController;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JButton perekaman, pencarian, exit;
    private JPanel pesan;

    public MainMenu() {
        super("Menu");
        setSize(380, 200);
        setLocationRelativeTo(null);

        pesan = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel judulAtas = new JLabel("Pilihan Menu", SwingConstants.CENTER);
        judulAtas.setFont(new Font("Arial", Font.BOLD, 20));
        judulAtas.setAlignmentX(Component.CENTER_ALIGNMENT);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        pesan.add(judulAtas, gbc);

        // Tombol Show Menu
        perekaman = new JButton("Perekaman");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        pesan.add(perekaman, gbc);

        pencarian = new JButton("Pencarian");
        gbc.gridx = 1;
        gbc.gridy = 1;
        pesan.add(pencarian, gbc);

        exit = new JButton("Exit");
        gbc.gridx = 2;
        gbc.gridy = 1;
        pesan.add(exit, gbc);

        add(pesan);

        perekaman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormData();
                dispose();
            }
        });

        pencarian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String NIK = JOptionPane.showInputDialog("NIK yang ingin dicari");
                dispose();
                new PencarianController().showData(NIK);
                setVisible(false);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
