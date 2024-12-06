package Controller;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class FormControllers {
    public static String cekGolDarah(JRadioButton golA, JRadioButton golB, JRadioButton golO, JRadioButton golAB) {
        String golDarah = "";
        if (golA.isSelected()) {
            golDarah = "A";
        } else if (golB.isSelected()) {
            golDarah = "B";
        } else if (golO.isSelected()) {
            golDarah = "O";
        } else {
            golDarah = "AB";
        }
        return golDarah;
    }
    
    public static String cekPekerjaan(JCheckBox karyawan, JCheckBox pns, JCheckBox wiraswatsa, JCheckBox akademisi, JCheckBox penganguran){
        String pekerjaan = "";
        if (penganguran.isSelected()) {
            return "Pengangguran, ";
        } else if (karyawan.isSelected()){
            pekerjaan += "Karyawan, ";
        } else if (pns.isSelected()){
            pekerjaan += "PNS, ";
        } else if (wiraswatsa.isSelected()){
            pekerjaan += "Wiraswasta, ";
        } else {
            pekerjaan += "Akademisi";
        }

        pekerjaan = pekerjaan.substring(0, pekerjaan.length()-2);
        return pekerjaan;
    }
}
