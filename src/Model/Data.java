package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Data {
    private String nik;
    private String nama;
    private String tempatLahir;
    private String tanggalLahir;
    private String jenisKelamin;
    private String golDarah;
    private String alamat;
    private String rtRW;
    private String kelDesa;
    private String kecamatan;
    private String agama;
    private String statusPerkawinan;
    private String pekerjaan;
    private String kewarganegaraan;
    private File foto;
    private File tandaTangan;
    private String berlakuHingga;
    private String kotaPembuatanKTP;
    private String tanggalPembuatanKTP;

    public Data() {
    }

    public Data(String nik, String nama, String tempatLahir, String tanggalLahir, String jenisKelamin,
            String golDarah, String alamat, String rtRW, String kelDesa, String kecamatan, String agama,
            String statusPerkawinan, String pekerjaan, String kewarganegaraan, File foto, File tandaTangan,
            String berlakuHingga, String kotaPembuatanKTP, String tanggalPembuatanKTP) {
        this.nik = nik;
        this.nama = nama;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.golDarah = golDarah;
        this.alamat = alamat;
        this.rtRW = rtRW;
        this.kelDesa = kelDesa;
        this.kecamatan = kecamatan;
        this.agama = agama;
        this.statusPerkawinan = statusPerkawinan;
        this.pekerjaan = pekerjaan;
        this.kewarganegaraan = kewarganegaraan;
        this.foto = foto;
        this.tandaTangan = tandaTangan;
        this.berlakuHingga = berlakuHingga;
        this.kotaPembuatanKTP = kotaPembuatanKTP;
        this.tanggalPembuatanKTP = tanggalPembuatanKTP;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getGolDarah() {
        return golDarah;
    }

    public void setGolDarah(String golDarah) {
        this.golDarah = golDarah;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getRtRW() {
        return rtRW;
    }

    public void setRtRW(String rtRW) {
        this.rtRW = rtRW;
    }

    public String getKelDesa() {
        return kelDesa;
    }

    public void setKelDesa(String kelDesa) {
        this.kelDesa = kelDesa;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getStatusPerkawinan() {
        return statusPerkawinan;
    }

    public void setStatusPerkawinan(String statusPerkawinan) {
        this.statusPerkawinan = statusPerkawinan;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        pekerjaan = pekerjaan;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public File getFoto() {
        return foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }

    public File getTandaTangan() {
        return tandaTangan;
    }

    public void setTandaTangan(File tandaTangan) {
        this.tandaTangan = tandaTangan;
    }

    public String getBerlakuHingga() {
        return berlakuHingga;
    }

    public void setBerlakuHingga(String berlakuHingga) {
        this.berlakuHingga = berlakuHingga;
    }

    public String getKotaPembuatanKTP() {
        return kotaPembuatanKTP;
    }

    public void setKotaPembuatanKTP(String kotaPembuatanKTP) {
        this.kotaPembuatanKTP = kotaPembuatanKTP;
    }

    public String getTanggalPembuatanKTP() {
        return tanggalPembuatanKTP;
    }

    public void setTanggalPembuatanKTP(String tanggalPembuatanKTP) {
        this.tanggalPembuatanKTP = tanggalPembuatanKTP;
    }  
    
    public static boolean insertData(Data data) {
        String query = "INSERT INTO data (nik, nama, tempatLahir, tanggalLahir, jenisKelamin, golDarah, alamat, rtRW, kelDesa, kecamatan, agama, statusPerkawinan, pekerjaan, kewarganegaraan, foto, tandaTangan, berlakuHingga, kotaPembuatanKTP, tanggalPembuatanKTP) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement st = con.prepareStatement(query)) {
                    System.out.println("Data berhasil ditambahkan.");
            st.setString(1, data.getNik());
            st.setString(2, data.getNama());
            st.setString(3, data.getTempatLahir());
            st.setString(4, data.getTanggalLahir());
            st.setString(5, data.getJenisKelamin());
            st.setString(6, data.getGolDarah());
            st.setString(7, data.getAlamat());
            st.setString(8, data.getRtRW());
            st.setString(9, data.getKelDesa());
            st.setString(10, data.getKecamatan());
            st.setString(11, data.getAgama());
            st.setString(12, data.getStatusPerkawinan());
            st.setString(13, data.getPekerjaan());
            st.setString(14, data.getKewarganegaraan());
            st.setBlob(15, new FileInputStream(data.getFoto())); 
            st.setBlob(16, new FileInputStream(data.getTandaTangan())); 
            st.setString(17, data.getBerlakuHingga());
            st.setString(18, data.getKotaPembuatanKTP());
            st.setString(19, data.getTanggalPembuatanKTP());

            int rowsInserted = st.executeUpdate();
            return rowsInserted > 0;

        } catch (Exception ex) {
            System.out.println("Terjadi kesalahan saat Menyimpan Data: " + ex.getMessage());
            return false;
        }
    }

    public static Data getData(String NIK) {
        Data dataUser = null;
        String query = "SELECT * FROM data WHERE nik = ?";

        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement st = con.prepareStatement(query)) {

            st.setString(1, NIK);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    dataUser = new Data();
                    dataUser.setNik(rs.getString("nik"));
                    dataUser.setNama(rs.getString("nama"));
                    dataUser.setTempatLahir(rs.getString("tempatLahir"));
                    dataUser.setTanggalLahir(rs.getString("tanggalLahir"));
                    dataUser.setJenisKelamin(rs.getString("jenisKelamin"));
                    dataUser.setGolDarah(rs.getString("golDarah"));
                    dataUser.setAlamat(rs.getString("alamat"));
                    dataUser.setRtRW(rs.getString("rtRW"));
                    dataUser.setKelDesa(rs.getString("kelDesa"));
                    dataUser.setKecamatan(rs.getString("kecamatan"));
                    dataUser.setAgama(rs.getString("agama"));
                    dataUser.setStatusPerkawinan(rs.getString("statusPerkawinan"));
                    dataUser.setPekerjaan(rs.getString("pekerjaan"));
                    dataUser.setKewarganegaraan(rs.getString("kewarganegaraan"));
                    dataUser.setBerlakuHingga(rs.getString("berlakuHingga"));
                    dataUser.setKotaPembuatanKTP(rs.getString("kotaPembuatanKTP"));
                    dataUser.setTanggalPembuatanKTP(rs.getString("tanggalPembuatanKtp"));

                    // Retrieve foto
                    InputStream fotoInputStream = rs.getBinaryStream("foto");
                    if (fotoInputStream != null) {
                        File fotoFile = new File("foto_" + NIK + ".jpg");
                        try (FileOutputStream fotoOutputStream = new FileOutputStream(fotoFile)) {
                            byte[] buffer = new byte[1024];
                            int bytesRead;
                            while ((bytesRead = fotoInputStream.read(buffer)) != -1) {
                                fotoOutputStream.write(buffer, 0, bytesRead);
                            }
                        }
                        dataUser.setFoto(fotoFile);
                    }

                    // Retrieve tanda tangan
                    InputStream tandaTanganInputStream = rs.getBinaryStream("tandaTangan");
                    if (tandaTanganInputStream != null) {
                        File tandaTanganFile = new File("ttd_" + NIK + ".jpg");
                        try (FileOutputStream tandaTanganOutputStream = new FileOutputStream(tandaTanganFile)) {
                            byte[] buffer = new byte[1024];
                            int bytesRead;
                            while ((bytesRead = tandaTanganInputStream.read(buffer)) != -1) {
                                tandaTanganOutputStream.write(buffer, 0, bytesRead);
                            }
                        }
                        dataUser.setTandaTangan(tandaTanganFile);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return dataUser;
    }

    public static boolean deleteData(String NIK) {
        String query = "DELETE FROM data where nik = ?";

        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement st = con.prepareStatement(query)) {

            st.setString(1, NIK);
            int rowDeleted = st.executeUpdate();
            return rowDeleted > 0;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
    }

    public static boolean UpdateData(Data lama, Data baru) {
        String query = "UPDATE data set(" + lama.nik + ", "+ lama.nama + ", " + lama.tempatLahir + ", " + lama.tanggalLahir + ", " + lama.jenisKelamin + ", " + lama.golDarah + "," + lama.alamat + "," + lama.rtRW + "," + lama.kelDesa + "," + lama.kecamatan + "," + lama.agama+ "," +lama.statusPerkawinan+ "," +lama.pekerjaan+ "," +lama.kewarganegaraan+ "," +lama.foto+ "," +lama.tandaTangan+ "," + lama.berlakuHingga+ "," + lama.kotaPembuatanKTP+ "," + lama.tanggalPembuatanKTP + ") "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement st = con.prepareStatement(query)) {
                    System.out.println("Data berhasil diupdate.");
            st.setString(1, baru.getNik());
            st.setString(2, baru.getNama());
            st.setString(3, baru.getTempatLahir());
            st.setString(4, baru.getTanggalLahir());
            st.setString(5, baru.getJenisKelamin());
            st.setString(6, baru.getGolDarah());
            st.setString(7, baru.getAlamat());
            st.setString(8, baru.getRtRW());
            st.setString(9, baru.getKelDesa());
            st.setString(10, baru.getKecamatan());
            st.setString(11, baru.getAgama());
            st.setString(12, baru.getStatusPerkawinan());
            st.setString(13, baru.getPekerjaan());
            st.setString(14, baru.getKewarganegaraan());
            st.setBlob(15, new FileInputStream(baru.getFoto())); 
            st.setBlob(16, new FileInputStream(baru.getTandaTangan())); 
            st.setString(17, baru.getBerlakuHingga());
            st.setString(18, baru.getKotaPembuatanKTP());
            st.setString(19, baru.getTanggalPembuatanKTP());

            int rowsInserted = st.executeUpdate();
            return rowsInserted > 0;

        } catch (Exception ex) {
            System.out.println("Terjadi kesalahan saat Mengupdate Data: " + ex.getMessage());
            return false;
        }
    }
}