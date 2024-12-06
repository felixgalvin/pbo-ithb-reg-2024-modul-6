package View;

import java.awt.*;
import javax.swing.*;
import Model.Data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewKTP extends JFrame{
    static JFrame frame;

    public ViewKTP(Data ktp) {
        viewKTP(ktp);
    }

    private void viewKTP(Data ktp) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        
        final int frameWidth = 700;
        final int frameHeight = 550;
        
        int frameX = (screenWidth / 2) - (frameWidth / 2);
        int frameY = (screenHeight / 2) - (frameHeight / 2);
        
        frame = new JFrame("KTP OUTPUT FORM");
        frame.setLayout(new GridLayout(1, 2));
        frame.setBounds(frameX, frameY, frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel for Images
        JPanel gambarPanel = new JPanel();
        gambarPanel.setLayout(new BoxLayout(gambarPanel, BoxLayout.Y_AXIS));
        gambarPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));

        // Scaled Photo
        ImageIcon ktpImage = new ImageIcon(ktp.getFoto().getAbsolutePath());
        Image scaledFoto = ktpImage.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledFoto));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Scaled Signature
        ImageIcon tandImageIcon = new ImageIcon(ktp.getTandaTangan().getAbsolutePath());
        Image scaledTTD = tandImageIcon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        JLabel imageLabel2 = new JLabel(new ImageIcon(scaledTTD));
        imageLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel kotaTanggalLabel = new JLabel(
                "<html>" + ktp.getKotaPembuatanKTP() + "<br>" + ktp.getTanggalPembuatanKTP() + "</html>");
        kotaTanggalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        gambarPanel.add(imageLabel);
        gambarPanel.add(Box.createVerticalStrut(20));
        gambarPanel.add(imageLabel2);
        gambarPanel.add(Box.createVerticalStrut(20));
        gambarPanel.add(kotaTanggalLabel);

        // Panel for Text Information
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(null);

        StringBuilder hasil = new StringBuilder();
        hasil.append("<html>");
        hasil.append("<h2>Provinsi DKI JAKARTA</h2>");
        hasil.append("<h2>JAKARTA UTARA</h2>");
        hasil.append("<h3>NIK           : " + ktp.getNik() + "</h3><br>");
        hasil.append("Nama              : " + ktp.getNama() + "<br>");
        hasil.append("Tempat Lahir      : " + ktp.getTempatLahir() + "<br>");
        hasil.append("Tanggal Lahir     : " + ktp.getTanggalLahir() + "<br>");
        hasil.append("Jenis Kelamin     : " + ktp.getJenisKelamin() + "<br>");
        hasil.append("Golongan Darah    : " + ktp.getGolDarah() + "<br>");
        hasil.append("Alamat            : " + ktp.getAlamat() + "<br>");
        hasil.append("Rt/RW             : " + ktp.getRtRW() + "<br>");
        hasil.append("Kel/Desa          : " + ktp.getKelDesa() + "<br>");
        hasil.append("Kecamatan         : " + ktp.getRtRW() + "<br>");
        hasil.append("Agama             : " + ktp.getAgama() + "<br>");
        hasil.append("Status Perkawinan : " + ktp.getStatusPerkawinan() + "<br>");
        hasil.append("Pekerjaan         : " + ktp.getPekerjaan() + "<br>");
        hasil.append("Kewarganegaraan   : " + ktp.getKewarganegaraan() + "<br>");
        hasil.append("Berlaku Hingga    : " + ktp.getBerlakuHingga() + "<br>");
        hasil.append("</html>");

        JLabel result = new JLabel(hasil.toString());
        result.setBounds(20, 20, 800, 500); 
        inputPanel.add(result);

        JButton back = new JButton("Back");
        back.setBounds(100,500,75,25);
        inputPanel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenu();
            }
        });

        // Adding Panels to Frame
        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(gambarPanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}