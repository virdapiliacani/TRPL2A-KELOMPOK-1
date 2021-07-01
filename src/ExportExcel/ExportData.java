/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExportExcel;

/**
 *
 * @author Kuuhaku
 */

import ExportExcel.FormExport;
import Koneksi.Koneksi;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;


public class ExportData {
    FormExport view;
    Connection con;
    
    public ExportData(FormExport view) {
         try {
            this.view = view;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    public void karyawan(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydepot_k_one","root","");
            Statement statement = con.createStatement();
            FileOutputStream fileOut;
            fileOut = new FileOutputStream("C:\\MyDepot K'One\\MyDepot K'One\\Laporan\\Laporan Karyawan.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Sheet 0");
            Row row1 = worksheet.createRow((short)0);
            row1.createCell(0).setCellValue("ID") ;
            row1.createCell(1).setCellValue("PASSWORD");
            row1.createCell(2).setCellValue("KETERANGAN");
            row1.createCell(3).setCellValue("NAMA");
            row1.createCell(4).setCellValue("NO.HP");
           
            
            Row row2 ;
            ResultSet rs = statement.executeQuery("SELECT id_k, password, keterangan , nama_k, nohp_k FROM karyawan ");
            
            while(rs.next()){
                int a = rs.getRow();
                row2 = worksheet.createRow((short)a);
                row2.createCell(0).setCellValue(rs.getString(1));
                row2.createCell(1).setCellValue(rs.getString(2));
                row2.createCell(2).setCellValue(rs.getString(3));
                row2.createCell(3).setCellValue(rs.getString(4));
                row2.createCell(4).setCellValue(rs.getString(5));
                }
                workbook.write(fileOut);
                fileOut.flush();
                fileOut.close();
                rs.close();
                statement.close();
                con.close();
                JOptionPane.showMessageDialog(null,"Export Berhasi! File Tersimpan pada Folder Laporan MyDepot K'One");
            }catch(ClassNotFoundException e){
                System.out.println(e);
            }catch(SQLException ex){
                System.out.println(ex);
            }catch(IOException ioe){
                System.out.println(ioe);
        }JOptionPane.showMessageDialog(null,"TERIMAKASIH!");
    }
    
    public void memesan(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydepot_k_one","root","");
            Statement statement = con.createStatement();
            FileOutputStream fileOut;
            fileOut = new FileOutputStream("C:\\MyDepot K'One\\MyDepot K'One\\Laporan\\Laporan Pemesanan.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Sheet 0");
            Row row1 = worksheet.createRow((short)0);
            row1.createCell(0).setCellValue("NO.PESANAN") ;
            row1.createCell(1).setCellValue("ID PELANGGAN");
            row1.createCell(2).setCellValue("ID KARYAWAN");
            row1.createCell(3).setCellValue("ID AIR");
            row1.createCell(4).setCellValue("NAMA KARYAWAN");
            row1.createCell(5).setCellValue("JUMLAH PESANAN");
            row1.createCell(6).setCellValue("TANGGAL PESANAN");
            row1.createCell(7).setCellValue("BIAYA");
            row1.createCell(8).setCellValue("DISKON");
            row1.createCell(9).setCellValue("VOUCHER");
            Row row2 ;
            ResultSet rs = statement.executeQuery("SELECT nopesanan, id_p, id_k, id_air, nama_k, jmlpesanan, tglpesanan, biaya, diskon, voucher FROM memesan ");
            
           
            while(rs.next() ){
                int a = rs.getRow();
                row2 = worksheet.createRow((short)a);
                row2.createCell(0).setCellValue(rs.getString(1));
                row2.createCell(1).setCellValue(rs.getString(2));
                row2.createCell(2).setCellValue(rs.getString(3));
                row2.createCell(3).setCellValue(rs.getString(4));
                row2.createCell(4).setCellValue(rs.getString(5));
                row2.createCell(5).setCellValue(rs.getString(6));
                row2.createCell(6).setCellValue(rs.getString(7));
                row2.createCell(7).setCellValue(rs.getString(8));
                row2.createCell(7).setCellValue(rs.getString(9));
                row2.createCell(7).setCellValue(rs.getString(10));
                
                
                }
                workbook.write(fileOut);
                fileOut.flush();
                fileOut.close();
                rs.close();
                rs.close();
                rs.close();
                statement.close();
                con.close();
                JOptionPane.showMessageDialog(null,"Export Berhasi! File Tersimpan pada Folder Laporan MyDepot K'One");
            }catch(ClassNotFoundException e){
                System.out.println(e);
            }catch(SQLException ex){
                System.out.println(ex);
            }catch(IOException ioe){
                System.out.println(ioe);
        }JOptionPane.showMessageDialog(null,"TERIMAKASIH!");
    }
    
    public void pelanggan(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydepot_k_one","root","");
            Statement statement = con.createStatement();
            FileOutputStream fileOut;
            fileOut = new FileOutputStream("C:\\MyDepot K'One\\MyDepot K'One\\Laporan\\Laporan Pelanggan.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Sheet 0");
            Row row1 = worksheet.createRow((short)0);
            row1.createCell(0).setCellValue("ALAMAT PELANGGAN") ;
            row1.createCell(1).setCellValue("ID PELANGGAN");
            row1.createCell(2).setCellValue("NAMA PELANGGAN");
            row1.createCell(3).setCellValue("NO.HP PELANGGAN");
            
            Row row2 ;
            ResultSet rs = statement.executeQuery("SELECT alamat_p, id_p, nama_p, nohp_p FROM pelanggan ");
            
           
            while(rs.next() ){
                int a = rs.getRow();
                row2 = worksheet.createRow((short)a);
                row2.createCell(0).setCellValue(rs.getString(1));
                row2.createCell(1).setCellValue(rs.getString(2));
                row2.createCell(2).setCellValue(rs.getString(3));
                row2.createCell(3).setCellValue(rs.getString(4));
                
                
                }
                workbook.write(fileOut);
                fileOut.flush();
                fileOut.close();
                rs.close();
                rs.close();
                rs.close();
                statement.close();
                con.close();
                JOptionPane.showMessageDialog(null,"Export Berhasi! File Tersimpan pada Folder Laporan MyDepot K'One");
            }catch(ClassNotFoundException e){
                System.out.println(e);
            }catch(SQLException ex){
                System.out.println(ex);
            }catch(IOException ioe){
                System.out.println(ioe);
        }JOptionPane.showMessageDialog(null,"TERIMAKASIH!");
    }
    
    
    public void viewTable1(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) view.getTabelDB().getModel();
            tabelModel.setRowCount(0);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydepot_k_one","root","");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM karyawan");
            
            while(rs.next()){
                Object[] data={
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    
                    
                };
                tabelModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void viewTable2(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) view.getTabelDB().getModel();
            tabelModel.setRowCount(0);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydepot_k_one","root","");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM memesan");
            
            while(rs.next()){
                Object[] data={
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10)
                };
                tabelModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void viewTable3(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) view.getTabelDB().getModel();
            tabelModel.setRowCount(0);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydepot_k_one","root","");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM pelanggan");
            
            while(rs.next()){
                Object[] data={
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                   
                    
                    
                };
                tabelModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExportData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
