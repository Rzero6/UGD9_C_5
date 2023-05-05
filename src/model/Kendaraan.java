/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author VICTUS
 */
public class Kendaraan {
    private String id;
    private String merk;
    private String jenis;
    private int tahunPembuatan;
    private String noPlat;
    private int jumlah_penumpang;
    private String jenis_tak;

    public Kendaraan(String id, String merk, String jenis, int tahunPembuatan, String noPlat, int jumlah_penumpang, String jenis_tak) {
        this.id = id;
        this.merk = merk;
        this.jenis = jenis;
        this.tahunPembuatan = tahunPembuatan;
        this.noPlat = noPlat;
        this.jumlah_penumpang = jumlah_penumpang;
        this.jenis_tak = jenis_tak;
    }

    public String getId() {
        return id;
    }

    public String getMerk() {
        return merk;
    }

    public String getJenis() {
        return jenis;
    }

    public int getTahunPembuatan() {
        return tahunPembuatan;
    }

    public String getNoPlat() {
        return noPlat;
    }

    public int getJumlah_penumpang() {
        return jumlah_penumpang;
    }

    public String getJenis_tak() {
        return jenis_tak;
    }
    
    
    public String showData(String jenis){
        if(jenis.equalsIgnoreCase("mobil")){
            return  "\nID\t : "+this.id +
                "\nMerk\t :"+ this.merk +
                "\nTahun\t : "+ this.tahunPembuatan +
                "\nNomor\t : "+ this.noPlat +
                "\nJumlah Penumpang : "+ this.jumlah_penumpang+"\n";
        }else{
            return  "\nID\t : "+this.id +
                "\nMerk\t :"+ this.merk +
                "\nTahun\t : "+ this.tahunPembuatan +
                "\nNomor\t : "+ this.noPlat +
                "\nJenis Motor : "+ this.jenis_tak+"\n";
        }
        
    }
        
}
