/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 * Nama : Reynold Kunarto 
 * NPM : 210711015
 * 
 * Nama : Febiola Ika Putri Wibowo
 * NPM : 210711023
 */
import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Kendaraan;

public class kendaraanDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertKendaraan(Kendaraan k){
        con = dbCon.makeConnection();
        String sql;
        if(k.getJenis().equalsIgnoreCase("mobil")){
            sql = "INSERT INTO kendaraan(id, merk, jenis, tahunPembuatan, noPlat, jumlah_penumpang, jenis_tak) "
                    + "VALUES ('" + k.getId() + "', '" + k.getMerk() + "', '"
                    + k.getJenis() + "', '" + k.getTahunPembuatan() + "', '"
                    + k.getNoPlat() + "', '" + k.getJumlah_penumpang() + "', NULL)";
        }else{
            sql = "INSERT INTO kendaraan(id, merk, jenis, tahunPembuatan, noPlat, jumlah_penumpang, jenis_tak) "
                    + "VALUES ('" + k.getId() + "', '" + k.getMerk() + "', '"
                    + k.getJenis() + "', '" + k.getTahunPembuatan() + "', '"
                    + k.getNoPlat() + "', 0, '" +k.getJenis_tak()+"')";
        }
        System.out.println("Adding Kendaraan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added "+result+" Kendaraan");
        }catch(Exception e){
            System.out.println("Error adding Kendaraan...");
            System.out.println("e");
        }
        dbCon.closeConnection();
    }
    
    public List<Kendaraan> showKendaraan(String jenis){
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM kendaraan WHERE jenis = '"+jenis+"'";
        
        System.out.println("Mengambil data kendaraan...");
        
        List<Kendaraan> list = new ArrayList();

        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if(rs!=null){
                while(rs.next()){
                    Kendaraan k = new Kendaraan(
                            rs.getString("id"),
                            rs.getString("merk"),
                            rs.getString("jenis"),
                            rs.getInt("tahunPembuatan"),
                            rs.getString("noPlat"),
                            rs.getInt("jumlah_penumpang"),
                            rs.getString("jenis_tak")
                    );
                    list.add(k);
                }
            }
            rs.close();
            statement.close();
        }catch (Exception e){
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    public Kendaraan searchKendaraan(String id) {

        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM kendaraan WHERE id = '"
                + id + "'";

        System.out.println("Searching Kendaraan...");
        
        Kendaraan k = null;
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null) {
                while (rs.next()) {
                    k = new Kendaraan(
                            rs.getString("id"),
                            rs.getString("merk"),
                            rs.getString("jenis"),
                            rs.getInt("tahunPembuatan"),
                            rs.getString("noPlat"),
                            rs.getInt("jumlah_penumpang"),
                            rs.getString("jenis_tak"));
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return k;
    }
    
    public void updateKendaraan(Kendaraan k, String id) {

        con = dbCon.makeConnection();
        String sql;
        if(id.contains("MBL-")){
           sql = "UPDATE kendaraan SET merk = '" + k.getMerk()+ "', "
                + "tahunPembuatan = '" + k.getTahunPembuatan() + "', "
                + "jumlah_penumpang = '" + k.getJumlah_penumpang() + "', "
                + "noPlat = '" + k.getNoPlat() + "' "
                + "WHERE id = '" + id + "'"; 
        }else{
           sql = "UPDATE kendaraan SET merk = '" + k.getMerk()+ "', "
                + "tahunPembuatan = '" + k.getTahunPembuatan() + "', "
                + "jenis_tak = '" + k.getJenis_tak() + "', "
                + "noPlat = '" + k.getNoPlat() + "' "
                + "WHERE id = '" + id + "'";  
        }
        
        
        System.out.println("Editing Kendaraan...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Kendaraan " + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Kendaraan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }
    
    public void deleteKendaraan(String id) {

        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM kendaraan WHERE id = '" + id + "'";

        System.out.println("Deleting Kendaraan...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Kendaraan " + id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Kendaraan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }
    
    public Kendaraan getLastData(String jenis){
        con = dbCon.makeConnection();
        String jenisCode;
        if(jenis.equals("Mobil")){
            jenisCode = "MBL-";
        }else{
            jenisCode = "MTR-";
        }
        String sql = "SELECT * FROM kendaraan WHERE id LIKE '"+jenisCode+"%' ORDER BY id DESC LIMIT 1";
        Kendaraan k = null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                    k = new Kendaraan(
                            rs.getString("id"),
                            rs.getString("merk"),
                            rs.getString("jenis"),
                            rs.getInt("tahunPembuatan"),
                            rs.getString("noPlat"),
                            rs.getInt("jumlah_penumpang"),
                            rs.getString("jenis_tak"));
            }
            rs.close();
            statement.close();
        }catch (Exception e){
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return k;
    }
}
