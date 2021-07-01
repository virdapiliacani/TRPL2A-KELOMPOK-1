/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author User
 */

import Koneksi.Koneksi;
import Model.Memesan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MemesanDao {
   public static void insert(Connection con, Memesan memesan) throws SQLException{
        String sql = "insert into memesan values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, memesan.getNopesanan());
        ps.setString(2, memesan.getId_p());
        ps.setString(3, memesan.getId_k());
        ps.setString(4, memesan.getId_air());
        ps.setString(5, memesan.getNama_k());
        ps.setString(6, memesan.getNama_g());
        ps.setInt(7, memesan.getJmlpesanan());
        ps.setDate(8, memesan.getTglpesanan());
        ps.setDouble(9, memesan.getBiaya());
        ps.setInt(10, memesan.getDiskon());
        ps.setString(11, memesan.getVoucher());
        ps.executeUpdate();
    }
    public static void update(Connection con, Memesan memesan) throws SQLException{
        String sql = "update memesan set id_p=?, id_k=?,  id_g=?,"
                + "nama_k=?, nama_g=?, jmlpesanan=?, tglpesanan=?, biaya=?, diskon=?, voucher=? "
                + "where nopesanan=?" ;
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(11, memesan.getNopesanan());
        ps.setString(1, memesan.getId_p());
        ps.setString(2, memesan.getId_k());
        ps.setString(3, memesan.getId_air());
        ps.setString(4, memesan.getNama_k());
        ps.setString(5, memesan.getNama_g());
        ps.setInt(6, memesan.getJmlpesanan());
        ps.setDate(7, memesan.getTglpesanan());
        ps.setDouble(8, memesan.getBiaya());
        ps.setInt(9, memesan.getDiskon());
        ps.setString(10, memesan.getVoucher());
        ps.executeUpdate();
    }
    
    public static void delete(Connection con, Memesan memesan) throws SQLException{
        String sql = "delete from memesan where nopesanan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, memesan.getNopesanan());
        ps.executeUpdate();
    }
    
    public static Memesan getMemesan(Connection con, String nopesanan) throws SQLException{
        String sql = "Select * from memesan where nopesanan=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nopesanan);
        Memesan memesan = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            memesan = new Memesan();
            memesan.setNopesanan(rs.getInt(1));
            memesan.setId_p(rs.getString(2));
            memesan.setId_k(rs.getString(3));
            memesan.setId_air(rs.getString(4));
            memesan.setNama_k(rs.getString(5));
            memesan.setNama_g(rs.getString(6));
            memesan.setJmlpesanan(rs.getInt(7));
            memesan.setTglpesanan(rs.getDate(8));
            memesan.setBiaya(rs.getDouble(9));
            memesan.setDiskon(rs.getInt(10));
            memesan.setVoucher(rs.getString(11));
        }
        return memesan;
    }
}
