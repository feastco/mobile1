package com.example.latihanmobile;

public class DataMahasiswa84 {
    private String nim;
    private String nama;
    private String foto;

    public DataMahasiswa84(String nim, String nama, String foto) {
        this.nim = nim;
        this.nama = nama;
        this.foto = foto;
    }

    public String getNim(){return nim;}
    public String getNama(){return nama;}
    public String getFoto(){return foto;}
    public void setNim(String nim){this.nim=nim;}
    public void setNama(String nama){this.nama=nama;}
    public void setFoto(String foto){this.foto=foto;}
}
