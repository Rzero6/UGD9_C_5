/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.kendaraanDAO;
import java.util.List;
import model.Kendaraan;

public class KendaraanControl {
    private kendaraanDAO dDao = new kendaraanDAO();
    
    public void insertDataKendaraan(Kendaraan k){
        dDao.insertKendaraan(k);
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
        Kendaraan k = null;
        k = dDao.searchKendaraan(id);
        return k;
    }
    
    public void updateDataKendaraan(Kendaraan k, String id){
        dDao.updateKendaraan(k, id);
    }
    
    public void deleteKendaraan(String id){
        dDao.deleteKendaraan(id);
    }
}