/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 * Nama : Reynold Kunarto 
 * NPM : 210711015
 * 
 * Nama : Febiola Ika Putri Wibowo
 * NPM : 210711023
 */

import dao.kendaraanDAO;
import java.util.List;
import model.Kendaraan;

public class KendaraanControl {
    private kendaraanDAO dDao = new kendaraanDAO();
    
    public void insertDataKendaraan(Kendaraan k){
        dDao.insertKendaraan(k);
    }
    
    public int getDataCount(String jenis){
        List<Kendaraan> dataKendaraan = dDao.showKendaraan(jenis);
        return dataKendaraan.size();
    }
    
    public Kendaraan getLasKendaraan(String jenis){
        return dDao.getLastData(jenis);
    }
    
    public String showDataKendaraan(String jenis){
        List<Kendaraan> dataKendaraan = dDao.showKendaraan(jenis);
        String kendaraanString = "";
        for(int i=0; i<dataKendaraan.size(); i++){
            kendaraanString = kendaraanString + dataKendaraan.get(i).showData(jenis);
        }
        return kendaraanString;
    }
    
    public Kendaraan searchKendaraan(String id){
        return dDao.searchKendaraan(id);
    }
    
    public void updateDataKendaraan(Kendaraan k, String id){
        dDao.updateKendaraan(k, id);
    }
    
    public void deleteKendaraan(String id){
        dDao.deleteKendaraan(id);
    }
}
