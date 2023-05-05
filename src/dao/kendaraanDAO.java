/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author VICTUS
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
        String sql = "INSERT INTO kendaraan(id, merk, jenis, tahunPembuatan, noPlat, jumlah_penumpang, jenis_tak) "
                    + "VALUES ('" + k.getId() + "', '" + k.getMerk() + "', '"
                    + k.getJenis() + "', '" + k.getTahunPembuatan() + "', '"
                    + k.getNoPlat() + "', '" + k.getJumlah_penumpang() + "', '" +k.getJenis_tak()+"')";
        
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

        String sql = "SELECT * FROM kendaraan";
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
                            rs.getInt("jumlahPenumpang"),
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
}
