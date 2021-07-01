/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import Dao.MemesanDao;
import Dao.PelangganDao;
import Form.Form_CRUD;
import Form.Form_Caridata;
import Form.Form_Laporan;
import java.lang.Double;
import Form.Form_Input;
import Koneksi.Koneksi;
import Model.Memesan;
import Model.Pelanggan;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RessM
 */

public class MemesanController {


    Form_Input view;
    Form_Caridata viewc;
    Form_CRUD viewd;
    Memesan memesan;
    Pelanggan pelanggan;
    PelangganDao pelanggandao;
    MemesanDao memesandao;
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    Koneksi server;
    public MemesanController(Form_Input view) {
        try {
            this.view = view;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
            clearForm();
            isiCbo_IdGalonman();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KaryawanController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public MemesanController(Form_Caridata view) {
        try {
            this.viewc = view;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KaryawanController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public MemesanController(Form_CRUD view) {
        try {
            this.viewd = view;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KaryawanController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void deleteMemesan() {
        try {
            MemesanDao.update(con, memesan);
            PelangganDao.update(con, pelanggan);
            JOptionPane.showMessageDialog(viewd, "Data Sudah di Hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(viewd, "Error " +e);
        }
    }
    
    public void clearForm(){
        view.getTxt_idpelanggan().setText("");
        view.getTxt_namapelanggan().setText("");
        view.getTxt_alamat().setText("");
        view.getTxt_nohppelanggan().setText("");
        view.getTxt_pesanan().setText("");
        view.getTxt_biaya().setText("");
        view.getTxt_diskon().setText("");
        view.getTxt_total().setText("");
        view.getCbo_voucher().setSelectedItem(1);
        view.getCbo_idgalonman().setSelectedItem(1);
        view.getTxt_namagalonman().setText("");
    }
    public void clearForm1(){
        viewd.getTxt_idpelanggan().setText("");
        viewd.getTxt_namapelanggan().setText("");
        viewd.getTxt_alamat().setText("");
        viewd.getTxt_nohppelanggan().setText("");
        viewd.getTxt_pesanan().setText("");
        viewd.getTxt_biaya().setText("");
        viewd.getTxt_diskon().setText("");
        viewd.getTxt_total().setText("");
        viewd.getCbo_voucher().setSelectedItem(1);
        viewd.getCbo_idgalonman().setSelectedItem(0);
        viewd.getTxt_namagalonman().setText("");
        viewd.getTxt_idkaryawan().setText("");
        viewd.getTxt_namakaryawan().setText("");
        viewd.getTxt_nopesan().setText("");
    }
    public void isiComboK(){
        view.getCbo_idgalonman().removeAllItems();
        view.getCbo_idgalonman().addItem("");
        view.getCbo_idgalonman().addItem("");
    }
    
    public boolean NohpCheck(){
        try{
            String nohp = view.getTxt_nohppelanggan().getText();
            memesan = memesandao.getMemesan(con,nohp);
            if(memesan == null) return true;
        }catch (SQLException ex) {
            Logger.getLogger(KaryawanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void KirimP(){
        pelanggan = new Pelanggan();
        pelanggan.setNama_p(view.getTxt_namapelanggan().getText());
        pelanggan.setAlamat_p(view.getTxt_alamat().getText());
        pelanggan.setNohp_p(view.getTxt_nohppelanggan().getText());
        pelanggan.setId_p(view.getTxt_idpelanggan().getText());
        try {
            PelangganDao.insert(con, pelanggan);
            JOptionPane.showMessageDialog(view, "Entri Data Pelanggan Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error "+ex.getMessage()); 
        }
    }
    public void KirimM(){
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        memesan = new Memesan();
        memesan.setId_p(view.getTxt_idpelanggan().getText());
        memesan.setJmlpesanan(Integer.parseInt(view.getTxt_pesanan().getText()));
        memesan.setBiaya(Double.parseDouble(view.getTxt_total().getText()));
        memesan.setDiskon(Integer.parseInt(view.getTxt_diskon().getText()));
        memesan.setVoucher(view.getCbo_voucher().getSelectedItem().toString());
        memesan.setNama_k(view.getTxt_Nama().getText());
        memesan.setNama_g(view.getTxt_namagalonman().getText());
        memesan.setId_k(view.getTxt_Id().getText());
        memesan.setId_air(view.getCbo_idgalonman().getSelectedItem().toString());
        memesan.setTglpesanan(sqlDate);
        try {
            MemesanDao.insert(con, memesan);
            JOptionPane.showMessageDialog(view, "Entri Data Memesan Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error "+ex.getMessage()); 
        }
    }
    public void UpdateM(){
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        memesan = new Memesan();
        memesan.setNopesanan(Integer.parseInt(viewd.getTxt_nopesan().getText()));
        memesan.setId_p(viewd.getTxt_idpelanggan().getText());
        memesan.setJmlpesanan(Integer.parseInt(viewd.getTxt_pesanan().getText()));
        memesan.setBiaya(Double.parseDouble(viewd.getTxt_total().getText()));
        memesan.setDiskon(Integer.parseInt(viewd.getTxt_diskon().getText()));
        memesan.setVoucher(viewd.getCbo_voucher().getSelectedItem().toString());
        memesan.setNama_k(viewd.getTxt_namakaryawan().getText());
        memesan.setNama_g(viewd.getTxt_namagalonman().getText());
        memesan.setId_k(viewd.getTxt_idkaryawan().getText());
        memesan.setId_air(viewd.getCbo_idgalonman().getSelectedItem().toString());
        memesan.setTglpesanan(sqlDate);
        try {
            MemesanDao.update(con, memesan);
            JOptionPane.showMessageDialog(view, "Update Data Memesan Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error "+ex.getMessage()); 
        }
    }
    public void UpdateP(){
        pelanggan = new Pelanggan();
        pelanggan.setAlamat_p(viewd.getTxt_alamat().getText());
        pelanggan.setId_p(viewd.getTxt_idpelanggan().getText());
        pelanggan.setNama_p(viewd.getTxt_namapelanggan().getText());
        pelanggan.setNohp_p(viewd.getTxt_nohppelanggan().getText());
        try {
            PelangganDao.update(con, pelanggan);
            JOptionPane.showMessageDialog(view, "Update Data Pelanggan Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error "+ex.getMessage()); 
        }
    }
    public void DeleteM()
    {
        try {
            MemesanDao.delete(con, memesan);
            JOptionPane.showMessageDialog(viewd, "Data Memesan Sudah di Hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(viewd, "Error " +e);
        }
        
    }
    public void DeleteP()
    {
        try {
            PelangganDao.delete(con, pelanggan);
            JOptionPane.showMessageDialog(viewd, "Data Pelanggan Sudah di Hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(viewd, "Error " +e);
        }
        
    }
    public void getPelanggan(){
        String kodeCari=(String) viewd.getTxt_idpelanggan().getText();
        try{
            pelanggan = new Pelanggan();
            pelanggan = PelangganDao.getPelanggan(con, kodeCari);
            
            if(pelanggan != null){
                viewd.getTxt_idpelanggan().setText(pelanggan.getId_p());
                viewd.getTxt_namapelanggan().setText(pelanggan.getNama_p());
                viewd.getTxt_alamat().setText(pelanggan.getAlamat_p());
                viewd.getTxt_nohppelanggan().setText(pelanggan.getNohp_p());
            }
            else{
                JOptionPane.showMessageDialog(view, "Data Tidak ditemukan");
            }
        }
        catch(SQLException | HeadlessException e){
        }
    }
    public void onMouseClickTablePelanggan() throws SQLException{
        String kode = viewd.getTabelPelanggan().getValueAt(viewd.getTabelPelanggan().getSelectedRow(), 0).toString();
        try{
            pelanggan = new Pelanggan();
            pelanggan = PelangganDao.getPelanggan(con, kode);;
            viewd.getTxt_idpelanggan().setText(pelanggan.getId_p());
            viewd.getTxt_namapelanggan().setText(pelanggan.getNama_p());
            viewd.getTxt_alamat().setText(pelanggan.getAlamat_p());
            viewd.getTxt_nohppelanggan().setText(pelanggan.getNohp_p());
        }catch(SQLException e){
            Logger.getLogger(MemesanController.class.getName()).log(Level.SEVERE, "Eror");
        }
    }
    public void onMouseClickMemesan() throws SQLException{
        String kode = viewd.getTabelMemesan().getValueAt(viewd.getTabelMemesan().getSelectedRow(), 0).toString();
        try{
            memesan = new Memesan();
            memesan = MemesanDao.getMemesan(con, kode);;
            viewd.getTxt_nopesan().setText(String.valueOf(memesan.getNopesanan()));
            viewd.getTxt_idpelanggan().setText(memesan.getId_p());
            viewd.getTxt_idkaryawan().setText(memesan.getId_k());
            viewd.getCbo_idgalonman().setSelectedItem(memesan.getId_air());
            viewd.getTxt_namakaryawan().setText(memesan.getNama_k());
            viewd.getTxt_namagalonman().setText(memesan.getNama_g());
            viewd.getTxt_pesanan().setText(String.valueOf(memesan.getJmlpesanan()));
            viewd.getTxt_diskon().setText(String.valueOf(memesan.getDiskon()));
            viewd.getCbo_voucher().setSelectedItem(memesan.getVoucher());
        }catch(SQLException e){
            Logger.getLogger(MemesanController.class.getName()).log(Level.SEVERE, "Eror");
        }
    }
    public void isiCbo_IdGalonman(){
        view.getCbo_idgalonman().removeAllItems();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from karyawan WHERE keterangan='Galonman'");
            while (rs.next()) {                
                view.getCbo_idgalonman().addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemesanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void isiCbo_IdGalonmanC(){
        viewd.getCbo_idgalonman().removeAllItems();
        try {
            ResultSet rs = con.createStatement().executeQuery("select * from karyawan WHERE keterangan='Galonman'");
            while (rs.next()) {                
                viewd.getCbo_idgalonman().addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemesanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getIdgalonman(){
        String[] s = view.getCbo_idgalonman().getSelectedItem().toString().split("-");
        return s[0];
    }
    
   /* public void onMouseClickTabel(){
        MemesanDao dao = new MemesanDao();
        
        String nopesanan = view.getTable().getValueAt(view,getTable().getSelectedRow(),0).toString();
        String id_p = view.getTable().getValueAt(view,getTable().getSelectedRow(),0).toString();
        String id_k = view.getTable().getValueAt(view,getTable().getSelectedRow(),0).toString();
        String nama_k = view.getTable().getValueAt(view,getTable().getSelectedRow(),0).toString();
        Integer jmlpesanan = view.getTable().getValueAt(view,getTable().getSelectedRow(),0).toInt();
        Date tglpesanan = view.getTable().getValueAt(view,getTable().getSelectedRow(),0).toDate();
        String nopesanan = view.getTable().getValueAt(view,getTable().getSelectedRow(),0).toString();
        String nopesanan = view.getTable().getValueAt(view,getTable().getSelectedRow(),0).toString();
        
        
    }*/
    
}