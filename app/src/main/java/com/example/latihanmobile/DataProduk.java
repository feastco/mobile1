package com.example.latihanmobile;

public class DataProduk {
    private String merk;
    private String harga;
    private String foto;

    public DataProduk(String merk, String harga, String foto) {
        this.merk = merk;
        this.harga = harga;
        this.foto = foto;
    }

    public String getMerk(){return merk;}
    public String getHarga(){return harga;}
    public String getFoto(){return foto;}
    public void setMerk(String merk){this.merk=merk;}
    public void setHarga(String harga){this.harga=harga;}
    public void setFoto(String foto){this.foto=foto;}
}
