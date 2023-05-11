/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Nama : Reynold Kunarto 
 * NPM : 210711015
 * 
 * Nama : Febiola Ika Putri Wibowo
 * NPM : 210711023
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
            return  "ID\t\t : "+this.id +
                "\nMerk\t\t : "+ this.merk +
                "\nTahun\t\t : "+ this.tahunPembuatan +
                "\nNomor\t\t : "+ this.noPlat +
                "\nJumlah Penumpang\t : "+ this.jumlah_penumpang+"\n\n===========================================\n\n";
        }else{
            return  "ID\t : "+this.id +
                "\nMerk\t : "+ this.merk +
                "\nTahun\t : "+ this.tahunPembuatan +
                "\nNomor\t : "+ this.noPlat +
                "\nJenis Tak\t : "+ this.jenis_tak+"\n\n===========================================\n\n";
        }
        
    }
        
}
