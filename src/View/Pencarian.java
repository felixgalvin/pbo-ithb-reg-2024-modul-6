package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.PencarianController;
import Model.Data;

public class Pencarian extends JFrame{
    JFrame frame;

    public Pencarian(Data ktp) {
        viewKTP(ktp);
    }

    private void viewKTP(Data ktp) {
        frame = new JFrame("KTP");
        frame.setLayout(new BorderLayout());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        final int frameWidth = 800;
        final int frameHeight = 500;

        int frameX = (screenWidth / 2) - (frameWidth / 2);
        int frameY = (screenHeight / 2) - (frameHeight / 2);

        frame.setBounds(frameX, frameY, frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel utama untuk teks dan gambar
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));

        // Panel kiri untuk teks
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));

        // Membuat data KTP dengan StringBuilder
        StringBuilder data = new StringBuilder();
        data.append("<html>");
        data.append("<h2 style='text-align:center;'>PROVINSI JAKARTA</h2>");
        data.append("<h2 style='text-align:center;'>JAKARTA UTARA</h2><br>");
        data.append("<h3>NIK           : " + ktp.getNik() + "</h3><br>");
        data.append("Nama              : " + ktp.getNama() + "<br>");
        data.append("Tempat/Tgl Lahir  : " + ktp.getTempatLahir() + ", " + ktp.getTanggalLahir() + "<br>");
        data.append("Jenis Kelamin     : " + ktp.getJenisKelamin() + " &nbsp;&nbsp;&nbsp; Gol. Darah : " + ktp.getGolDarah() + "<br>");
        data.append("Alamat            : " + ktp.getAlamat() + "<br>");
        data.append("RT/RW             : " + ktp.getRtRW() + "<br>");
        data.append("Kel/Desa          : " + ktp.getKelDesa() + "<br>");
        data.append("Kecamatan         : " + ktp.getKecamatan() + "<br>");
        data.append("Agama             : " + ktp.getAgama() + "<br>");
        data.append("Status Perkawinan : " + ktp.getStatusPerkawinan() + "<br>");
        data.append("Pekerjaan         : " + ktp.getPekerjaan() + "<br>");
        data.append("Kewarganegaraan   : " + ktp.getKewarganegaraan() + "<br>");
        data.append("Berlaku Hingga    : " + ktp.getBerlakuHingga() + "<br>");
        data.append("</html>");

        JLabel textLabel = new JLabel(data.toString());
        textPanel.add(textLabel);

        // Panel kanan untuk gambar
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
        imagePanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));

        // Foto
        ImageIcon fotoIcon = new ImageIcon(ktp.getFoto().getAbsolutePath());
        Image scaledFoto = fotoIcon.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        JLabel fotoLabel = new JLabel(new ImageIcon(scaledFoto));
        fotoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Tanda tangan
        ImageIcon ttdIcon = new ImageIcon(ktp.getTandaTangan().getAbsolutePath());
        Image scaledTTD = ttdIcon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        JLabel ttdLabel = new JLabel(new ImageIcon(scaledTTD));
        ttdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel kotaTanggalLabel = new JLabel(
                "<html>" + ktp.getKotaPembuatanKTP() + "<br>" + ktp.getTanggalPembuatanKTP() + "</html>");
        kotaTanggalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Tambahkan ke panel gambar
        imagePanel.add(fotoLabel);
        imagePanel.add(Box.createVerticalStrut(20));
        imagePanel.add(ttdLabel);
        imagePanel.add(Box.createVerticalStrut(10));
        imagePanel.add(kotaTanggalLabel);

        JButton update = new JButton("Update");
        update.setBounds(100, 500, 75, 25);
        textPanel.add(update);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateData(ktp);
                frame.dispose();
            }
        });
        imagePanel.add(ttdLabel);

        JButton delete = new JButton("Delete");
        delete.setBounds(100, 500, 75, 25);
        textPanel.add(delete);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PencarianController.deleteData(ktp.getNik());
                frame.dispose();
                new MainMenu();
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(100,500,75,25);
        textPanel.add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenu();
            }
        });

        // Tambahkan panel ke main panel
        mainPanel.add(textPanel);
        mainPanel.add(imagePanel);

        // Tambahkan main panel ke frame
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
