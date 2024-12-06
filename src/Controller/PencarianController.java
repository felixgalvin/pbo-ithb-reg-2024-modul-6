package Controller;

import javax.swing.JOptionPane;

import Model.Data;
import View.MainMenu;
import View.Pencarian;

public class PencarianController {
    public boolean showData(String NIK){
        Data dataPenduduk = Data.getData(NIK);
        if (dataPenduduk == null) {
            JOptionPane.showMessageDialog(null, "Data Tidak ditemukan", "Hasil Pencarian", 1);
            return false;
        } else {
            new Pencarian(dataPenduduk);
        }
        return false;
    }

    public static void cekInsert(Data KTP) {
        if (Data.insertData(KTP)) {
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan", "Hasil Insert", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan", "Hasil Insert", 1);
        }
    }

    public static void deleteData(String NIK){
        if (Data.deleteData(NIK)) {
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus", "Status data", 0);
        } else {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus", "Status data", 0);
        }
        new MainMenu();
    }

    public static void updateData(String NIK){
        if (Data.deleteData(NIK)) {
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate", "Status data", 0);
        } else {
            JOptionPane.showMessageDialog(null, "Data Gagal DiUpdate", "Status data", 0);
        }
        new MainMenu();
    }
}
