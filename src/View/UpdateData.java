package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.util.*;

import Model.Data;
import Controller.*;

public class UpdateData extends JFrame {

    JFrame frame;
    JPanel panel1;
    JLabel LNIK;
    JTextField NIK;
    JLabel Lnama;
    JTextField nama;
    JLabel LtempatLahir;
    JTextField tempatLahir;
    JLabel LtanggalLahir;
    JDateChooser tanggalLahir;
    JLabel LjenisKelamin;
    JRadioButton rbtnPria;
    JRadioButton rbtnWanita;
    ButtonGroup rbtnGroup1;
    JLabel LgolDarah;
    JRadioButton rbtnA;
    JRadioButton rbtnB;
    JRadioButton rbtnO;
    JRadioButton rbtnAB;
    ButtonGroup rbtnGroup2;
    JLabel Lalamat;
    JTextField alamat;
    JLabel LRTRW;
    JTextField RTRW;
    JLabel Ldesa;
    JTextField desa;
    JLabel Lkecamatan;
    JTextField kecamatan;
    JLabel Lagama;
    JComboBox agama;
    JLabel Lstatus;
    JComboBox status;
    JLabel Lpekerjaan;
    JCheckBox karyawanSwasta;
    JCheckBox PNS;
    JCheckBox wiraswasta;
    JCheckBox akademisi;
    JCheckBox pengangguran;
    JLabel Lkewarganegaraan;
    JRadioButton WNA;
    JRadioButton WNI;
    ButtonGroup rbtnGroup3;
    JLabel asalNegara;
    JTextArea asalNegaraField;
    JLabel Lfoto;
    JButton foto;
    File fotoFile;
    JLabel LtandaTangan;
    JButton tandaTangan;
    File ttdFile;
    JLabel Lberlaku;
    JTextField berlaku;
    JLabel LkotaPembuatan;
    JTextField kotaPembuatan;
    JLabel LtanggalPembuatan;
    JDateChooser tanggalPembuatan;
    JButton submit;

    Object[] pilihAgama = {"Kristen", "Katolik", "Muslim", "Hindu", "Budha"}; // combobox agama
    Object[] pilihStatus = {"Belum Menikah", "Menikah", "Janda/Duda"}; // combobox status

    public UpdateData(Data ktp) {
        inputForm(ktp);
    }

    private void inputForm(Data ktp) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        final int frameWidth = 750;
        final int frameHeight = 650;

        int frameX = (screenWidth / 2) - (frameWidth / 2);
        int frameY = (screenHeight / 2) - (frameHeight / 2);

        frame = new JFrame("KTP UPDATE FORM");
        frame.setBounds(frameX, frameY, frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Penampung
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, frameWidth, frameHeight);
        add(panel1);

        // Input NIK
        LNIK = new JLabel("NIK: ");
        NIK = new JTextField();
        
        LNIK.setBounds(50, 75, 400, 25);
        NIK.setBounds(175, 75, 400, 25);

        panel1.add(LNIK);
        panel1.add(NIK);
        
        // Input Nama
        Lnama = new JLabel("Nama: ");
        nama = new JTextField();

        Lnama.setBounds(50, 100, 400, 25);
        nama.setBounds(175, 100, 400, 25);

        panel1.add(Lnama);
        panel1.add(nama);

        // Input Tempat Lahir
        LtempatLahir = new JLabel("Tempat Lahir: ");
        tempatLahir = new JTextField();

        LtempatLahir.setBounds(50, 125, 400, 25);
        tempatLahir.setBounds(175, 125, 400, 25);
        
        panel1.add(LtempatLahir);
        panel1.add(tempatLahir);

        // Input Tanggal Lahir
        LtanggalLahir = new JLabel("Tanggal Lahir: ");
        tanggalLahir = new JDateChooser();

        LtanggalLahir.setBounds(50, 150, 400, 25);
        tanggalLahir.setBounds(175, 150, 400, 25);

        panel1.add(LtanggalLahir);
        panel1.add(tanggalLahir);

        // Input Jenis Kelamin
        LjenisKelamin = new JLabel("Jenis Kelamin: ");
        rbtnPria = new JRadioButton("Pria");
        rbtnWanita = new JRadioButton("Wanita");
        rbtnGroup1 = new ButtonGroup();

        LjenisKelamin.setBounds(50, 175, 400, 25);
        rbtnPria.setBounds(175, 175, 60, 25);
        rbtnWanita.setBounds(235, 175, 80, 25);

        panel1.add(LjenisKelamin);
        panel1.add(rbtnPria);
        panel1.add(rbtnWanita);
        rbtnGroup1.add(rbtnPria);
        rbtnGroup1.add(rbtnWanita);

        // Input Golongan Darah
        LgolDarah = new JLabel("Golongan Darah: ");
        rbtnA = new JRadioButton("A");
        rbtnB = new JRadioButton("B");
        rbtnO = new JRadioButton("O");
        rbtnAB = new JRadioButton("AB");
        rbtnGroup2 = new ButtonGroup();
        
        LgolDarah.setBounds(50, 200, 400, 25);
        rbtnA.setBounds(175, 200, 50, 25);
        rbtnB.setBounds(225, 200, 50, 25);
        rbtnO.setBounds(275, 200, 50, 25);
        rbtnAB.setBounds(325, 200, 50, 25);
        
        panel1.add(LgolDarah);
        panel1.add(rbtnA);
        panel1.add(rbtnB);
        panel1.add(rbtnO);
        panel1.add(rbtnAB);
        rbtnGroup2.add(rbtnA);
        rbtnGroup2.add(rbtnB);
        rbtnGroup2.add(rbtnO);
        rbtnGroup2.add(rbtnAB);

        // Input Alamat
        Lalamat = new JLabel("Alamat: ");
        alamat = new JTextField();

        Lalamat.setBounds(50, 225, 400, 25);
        alamat.setBounds(175, 225, 400, 25);

        panel1.add(Lalamat);
        panel1.add(alamat);

        // Input RT/RW
        LRTRW = new JLabel("RT/RW: ");
        RTRW = new JTextField();
        
        LRTRW.setBounds(50, 250, 400, 25);
        RTRW.setBounds(175, 250, 400, 25);

        panel1.add(LRTRW);
        panel1.add(RTRW);

        // Input Kel/Desa
        Ldesa = new JLabel("Kel/Desa: ");
        desa = new JTextField();
        
        Ldesa.setBounds(50, 275, 400, 25);
        desa.setBounds(175, 275, 400, 25);

        panel1.add(Ldesa);
        panel1.add(desa);

        // Input Kecamatan
        Lkecamatan = new JLabel("Kecamatan: ");
        kecamatan = new JTextField();
        
        Lkecamatan.setBounds(50, 300, 400, 25);
        kecamatan.setBounds(175, 300, 400, 25);
        
        panel1.add(Lkecamatan);
        panel1.add(kecamatan);  

        // Input Agama
        Lagama = new JLabel("Agama: ");
        agama = new JComboBox(pilihAgama);
        
        Lagama.setBounds(50, 325, 400, 25);
        agama.setBounds(175, 325, 400, 25);

        panel1.add(Lagama);
        panel1.add(agama);

        // Input Status Perkawinan
        Lstatus = new JLabel("Status Perkawinan: ");
        status = new JComboBox(pilihStatus);

        Lstatus.setBounds(50, 350, 400, 25);
        status.setBounds(175, 350, 400, 25);

        panel1.add(Lstatus);
        panel1.add(status);

        // Input Pekerjaan
        Lpekerjaan = new JLabel("Pekerjaan: ");
        karyawanSwasta = new JCheckBox("Karyawan");
        PNS = new JCheckBox("PNS");
        wiraswasta = new JCheckBox("Wiraswasta");
        akademisi = new JCheckBox("Akademisi");
        pengangguran = new JCheckBox("Pengangguran");

        Lpekerjaan.setBounds(50, 375, 400, 25);
        karyawanSwasta.setBounds(175, 375, 100, 25);
        PNS.setBounds(275, 375, 100, 25);
        wiraswasta.setBounds(375, 375, 100, 25);
        akademisi.setBounds(475, 375, 100, 25);
        pengangguran.setBounds(575, 375, 100, 25);
        
        panel1.add(Lpekerjaan);
        panel1.add(karyawanSwasta);
        panel1.add(PNS);
        panel1.add(wiraswasta);
        panel1.add(akademisi);
        panel1.add(pengangguran);

        pengangguran.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (pengangguran.isSelected()) {
                    karyawanSwasta.setEnabled(false);
                    PNS.setEnabled(false);
                    wiraswasta.setEnabled(false);
                    akademisi.setEnabled(false);

                    karyawanSwasta.setSelected(false);
                    PNS.setSelected(false);
                    wiraswasta.setSelected(false);
                    akademisi.setSelected(false);

                } else {
                    karyawanSwasta.setEnabled(true);
                    PNS.setEnabled(true);
                    wiraswasta.setEnabled(true);
                    akademisi.setEnabled(true);
                }
            }
        });

        // Input Kewarganegaraan
        Lkewarganegaraan = new JLabel("Kewarganegaraan: ");
        WNA = new JRadioButton("WNA");
        WNI = new JRadioButton("WNI");
        rbtnGroup3 = new ButtonGroup();
        
        Lkewarganegaraan.setBounds(50, 400, 400, 25);
        WNA.setBounds(175, 400, 100, 25);
        WNI.setBounds(275, 400, 100, 25);

        panel1.add(Lkewarganegaraan);
        panel1.add(WNA);
        panel1.add(WNI);
        rbtnGroup3.add(WNA);
        rbtnGroup3.add(WNI);

        asalNegara = new JLabel("Negara Asal: ");
        asalNegaraField = new JTextArea();
        asalNegara.setBounds(375, 400, 400, 25);
        asalNegaraField.setBounds(475, 400, 180, 25);
        asalNegara.setVisible(false);
        asalNegaraField.setVisible(false);

        WNA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asalNegara.setVisible(true);
                asalNegaraField.setVisible(true);
            }
        });

        panel1.add(asalNegara);
        panel1.add(asalNegaraField);

        // Input Foto
        Lfoto = new JLabel("Foto: ");
        foto = new JButton("Upload Photo");

        Lfoto.setBounds(50, 425, 400, 25);
        foto.setBounds(175, 425, 400, 25);
        
        panel1.add(Lfoto);
        panel1.add(foto);

        foto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    fotoFile = fileChooser.getSelectedFile();
                }
            }
        });

        // Input Tanda Tangan
        LtandaTangan = new JLabel("Tanda Tangan: ");
        tandaTangan = new JButton("Upload Tanda Tangan");

        LtandaTangan.setBounds(50, 450, 400, 25);
        tandaTangan.setBounds(175, 450, 400, 25);

        panel1.add(LtandaTangan);
        panel1.add(tandaTangan);

        tandaTangan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    ttdFile = fileChooser.getSelectedFile();
                }
            }
        });

        // Input Berlaku Hingga 
        Lberlaku = new JLabel("Berlaku hingga: ");
        berlaku = new JTextField();

        Lberlaku.setBounds(50, 475, 400, 25);
        berlaku.setBounds(175, 475, 400, 25);

        panel1.add(Lberlaku);
        panel1.add(berlaku); 

        // Input Kota Pembuatan KTP
        LkotaPembuatan = new JLabel("Kota Pembuatan KTP: ");
        kotaPembuatan = new JTextField();

        LkotaPembuatan.setBounds(50, 500, 400, 25);
        kotaPembuatan.setBounds(175, 500, 400, 25);
        
        panel1.add(LkotaPembuatan);
        panel1.add(kotaPembuatan); 

        // Input Tanggal Pembuatan KTP
        LtanggalPembuatan = new JLabel("Tggl Pembuatan KTP: ");
        tanggalPembuatan = new JDateChooser();

        LtanggalPembuatan.setBounds(50, 525, 400, 25);
        tanggalPembuatan.setBounds(175, 525, 400, 25);

        panel1.add(LtanggalPembuatan);
        panel1.add(tanggalPembuatan);

        // SUBMIT
        submit = new JButton("Submit");
        submit.setBounds(50 , 550, 500, 25);
        panel1.add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namaOutput = nama.getText();
                String nikKTP = NIK.getText();
                String tempatLahirOutput = tempatLahir.getText();
                Date tglLahirOutput = (Date) tanggalLahir.getDate();
                LocalDate tanggalLahirlocalDate = tglLahirOutput.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
                String tanggalLahirlocalDateFormatted = tanggalLahirlocalDate
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                String jenisKelaminOutput;
                if (rbtnPria.isSelected()) {
                jenisKelaminOutput = "Pria";
                } else {
                jenisKelaminOutput = "Wanita";
                }

                String golDarahOutput = FormControllers.cekGolDarah(rbtnA, rbtnB, rbtnO, rbtnAB);
                String alamatOutput = alamat.getText();
                String rtRWOutput = RTRW.getText();
                String kelDesaOutput = desa.getText();
                String kecamatanOutput = kecamatan.getText();

                String agamaOutput;
                if (agama.getSelectedItem() != null) {
                agamaOutput = agama.getSelectedItem().toString();
                } else {
                agamaOutput = "";
                }

                String statusKawinOutput = (status.getSelectedItem() != null)
                ? status.getSelectedItem().toString()
                : "";

                String pekerjaanOutput = FormControllers.cekPekerjaan(karyawanSwasta, PNS,
                wiraswasta, akademisi,
                pengangguran);

                String kewarganegaraanOutput;
                if (WNA.isSelected()) {
                String wargaNegaraAsal = asalNegara.getText();
                kewarganegaraanOutput = "WNA " + wargaNegaraAsal;
                } else {
                kewarganegaraanOutput = "WNI";
                }
                String berlakuHinggaOutput = berlaku.getText();

                String kotaPembuatanOutput = kotaPembuatan.getText();

                Date tglPembuatanKTP = tanggalPembuatan.getDate();
                LocalDate tglPembuatanLocalDate = tglPembuatanKTP.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
                String tglPembuatanFormatted =
                tglPembuatanLocalDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                if (nikKTP.isEmpty() || namaOutput.isEmpty() || tempatLahirOutput.isEmpty()
                        || tanggalLahirlocalDateFormatted == null ||
                        jenisKelaminOutput.isEmpty() || golDarahOutput.isEmpty() || agamaOutput.isEmpty()
                        || statusKawinOutput.isEmpty() || pekerjaanOutput.isEmpty() ||
                        alamatOutput.isEmpty() || rtRWOutput.isEmpty() || kelDesaOutput.isEmpty()
                        || kecamatanOutput.isEmpty() ||
                        kewarganegaraanOutput.isEmpty() || berlakuHinggaOutput.isEmpty()
                        || kotaPembuatanOutput.isEmpty() ||
                        tglPembuatanFormatted == null || fotoFile == null || ttdFile == null) {
                    JOptionPane.showMessageDialog(null, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    Data KTP = new Data(
                            nikKTP,
                            namaOutput,
                            tempatLahirOutput,
                            tanggalLahirlocalDateFormatted,
                            jenisKelaminOutput,
                            golDarahOutput,
                            alamatOutput,
                            rtRWOutput,
                            kelDesaOutput,
                            kecamatanOutput,
                            agamaOutput,
                            statusKawinOutput,
                            pekerjaanOutput,
                            kewarganegaraanOutput,
                            fotoFile,
                            ttdFile,
                            berlakuHinggaOutput,
                            kotaPembuatanOutput,
                            tglPembuatanFormatted);
                    Data.UpdateData(ktp, KTP);
                    new ViewKTP(KTP);
                    frame.dispose();
                }
            }
        });

        frame.add(panel1);
        frame.setVisible(true);
    }
}
