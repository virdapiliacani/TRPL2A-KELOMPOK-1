/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.MemesanController;
import Koneksi.Koneksi;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author USER
 */
public class Form_CRUD extends javax.swing.JFrame {
    MemesanController controllerM;

    /**
     * Creates new form Form_MenuUtama
     */
    Connection con;
    Statement stat;
    ResultSet rs;
    public Form_CRUD() {
        initComponents();
        //panel_galon.setBackground(new Color(225,225,225,255));
        controllerM = new MemesanController(this);
        tablePelanggan();
        tableMemesan();
        txt_nopesan.setEnabled(false);
        controllerM.isiCbo_IdGalonmanC();
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public JButton getBtn_delete() {
        return btn_delete;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }
    
    private void tablePelanggan(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id Pelanggan");
        model.addColumn("Nama Pelanggan");
        model.addColumn("ALamat Pelanggan");
        model.addColumn("No. HP");
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getKoneksi();
            String sql = "Select * from pelanggan";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[] {
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(1),
                    rs.getString(4)
                });
            }
            TabelPelanggan.setModel(model);
        } catch(Exception e){
            System.out.println("Error => "+e);
        }
    }
    
    private void tableMemesan(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No Pesanan");
        model.addColumn("Id Pelanggan");
        model.addColumn("Id Karyawan");
        model.addColumn("Id Galonman");
        model.addColumn("Nama Karyawan");
        model.addColumn("Nama Galonman");
        model.addColumn("Jumlah Pesanan");
        model.addColumn("Tgl Pesanan");
        model.addColumn("Biaya");
        model.addColumn("Diskon");
        model.addColumn("Vourcher");
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getKoneksi();
            String sql = "Select * from memesan";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11)
                });
            }
            TabelMemesan.setModel(model);
        } catch(Exception e){
            System.out.println("Error => "+e);
        }
    }
    public javax.swing.JTextField getTxt_idpelanggan(){
        return txt_idpelanggan;
    }
    
    public javax.swing.JTextField getTxt_namapelanggan(){
        return txt_namapelanggan;
    }
    
    public javax.swing.JTextField getTxt_alamat(){
        return txt_alamat;
    }
    
    public javax.swing.JTextField getTxt_nohppelanggan(){
        return txt_nohppelanggan;  
    }
    
    public javax.swing.JTextField getTxt_pesanan(){
        return txt_pesanan;
    }
    
    public javax.swing.JTextField getTxt_biaya(){
        return txt_biaya;
    }
    
    public javax.swing.JTextField getTxt_namagalonman(){
        return txt_namagalonman;
    }
    
    public JComboBox<String> getCbo_idgalonman() {
        return cbo_idgalonman;
    } 

    public JTextField getTxt_total() {
        return txt_total;
    }

    public JTextField getTxt_diskon() {
        return txt_diskon;
    }

    public JComboBox<String> getCbo_voucher() {
        return cbo_voucher;
    }

    public JTextField getTxt_idkaryawan() {
        return txt_idkaryawan;
    }

    public JTextField getTxt_nopesan() {
        return txt_nopesan;
    }

    public JTextField getTxt_namakaryawan() {
        return txt_namakaryawan;
    }

    public JTable getTabelMemesan() {
        return TabelMemesan;
    }

    public JTable getTabelPelanggan() {
        return TabelPelanggan;
    }

    public JTextField getTxt_Hp() {
        return txt_Hp;
    }

    public JTextField getTxt_Id() {
        return txt_Id;
    }

    public JTextField getTxt_Nama() {
        return txt_Nama;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel_biaya = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel_pesanan = new javax.swing.JLabel();
        jLabel_nohppelanggan = new javax.swing.JLabel();
        jLabel_alamat = new javax.swing.JLabel();
        jLabel_namapelanggan = new javax.swing.JLabel();
        jLabel_idpelanggan = new javax.swing.JLabel();
        txt_idkaryawan = new javax.swing.JTextField();
        txt_namapelanggan = new javax.swing.JTextField();
        txt_alamat = new javax.swing.JTextField();
        txt_nohppelanggan = new javax.swing.JTextField();
        txt_pesanan = new javax.swing.JTextField();
        txt_diskon = new javax.swing.JTextField();
        txt_biaya = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        cbo_voucher = new javax.swing.JComboBox<>();
        cbo_idgalonman = new javax.swing.JComboBox<>();
        txt_namagalonman = new javax.swing.JTextField();
        jLabel_namagalonman = new javax.swing.JLabel();
        jLabel_idgalonman = new javax.swing.JLabel();
        btn_batalkan = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelMemesan = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelPelanggan = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txt_idpelanggan = new javax.swing.JTextField();
        jLabel_idpelanggan1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_idpelanggan2 = new javax.swing.JLabel();
        txt_nopesan = new javax.swing.JTextField();
        jLabel_idpelanggan3 = new javax.swing.JLabel();
        txt_namakaryawan = new javax.swing.JTextField();
        btn_home = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_Id = new javax.swing.JTextField();
        txt_Nama = new javax.swing.JTextField();
        txt_Hp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel4.setText("VOUCHER :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 560, 200, 32);

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel3.setText("Total Biaya :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 500, 190, 32);

        jLabel_biaya.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel_biaya.setText("BIAYA :");
        jPanel1.add(jLabel_biaya);
        jLabel_biaya.setBounds(30, 450, 228, 47);

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel5.setText("DISKON :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 410, 110, 32);

        jLabel_pesanan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel_pesanan.setText("PESANAN :");
        jPanel1.add(jLabel_pesanan);
        jLabel_pesanan.setBounds(30, 350, 228, 47);

        jLabel_nohppelanggan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel_nohppelanggan.setText("NO HP :");
        jPanel1.add(jLabel_nohppelanggan);
        jLabel_nohppelanggan.setBounds(30, 160, 228, 47);

        jLabel_alamat.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel_alamat.setText("ALAMAT :");
        jPanel1.add(jLabel_alamat);
        jLabel_alamat.setBounds(30, 110, 228, 47);

        jLabel_namapelanggan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel_namapelanggan.setText("NAMA PELANGGAN :");
        jPanel1.add(jLabel_namapelanggan);
        jLabel_namapelanggan.setBounds(30, 60, 234, 47);

        jLabel_idpelanggan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel_idpelanggan.setText("ID Karyawan :");
        jPanel1.add(jLabel_idpelanggan);
        jLabel_idpelanggan.setBounds(30, 250, 228, 40);

        txt_idkaryawan.setBackground(new java.awt.Color(196, 196, 196));
        txt_idkaryawan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txt_idkaryawan);
        txt_idkaryawan.setBounds(320, 260, 380, 40);

        txt_namapelanggan.setBackground(new java.awt.Color(196, 196, 196));
        txt_namapelanggan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txt_namapelanggan);
        txt_namapelanggan.setBounds(320, 60, 377, 40);

        txt_alamat.setBackground(new java.awt.Color(196, 196, 196));
        txt_alamat.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txt_alamat);
        txt_alamat.setBounds(320, 110, 377, 40);

        txt_nohppelanggan.setBackground(new java.awt.Color(196, 196, 196));
        txt_nohppelanggan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txt_nohppelanggan);
        txt_nohppelanggan.setBounds(320, 160, 377, 40);

        txt_pesanan.setBackground(new java.awt.Color(196, 196, 196));
        txt_pesanan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txt_pesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pesananActionPerformed(evt);
            }
        });
        txt_pesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pesananKeyTyped(evt);
            }
        });
        jPanel1.add(txt_pesanan);
        txt_pesanan.setBounds(320, 360, 377, 30);

        txt_diskon.setBackground(new java.awt.Color(196, 196, 196));
        txt_diskon.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txt_diskon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_diskonActionPerformed(evt);
            }
        });
        txt_diskon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_diskonKeyPressed(evt);
            }
        });
        jPanel1.add(txt_diskon);
        txt_diskon.setBounds(320, 400, 377, 40);

        txt_biaya.setBackground(new java.awt.Color(196, 196, 196));
        jPanel1.add(txt_biaya);
        txt_biaya.setBounds(320, 450, 380, 40);

        txt_total.setBackground(new java.awt.Color(196, 196, 196));
        jPanel1.add(txt_total);
        txt_total.setBounds(320, 500, 380, 40);

        cbo_voucher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Gelas", "Piring", "Kipas", "Sendok" }));
        jPanel1.add(cbo_voucher);
        cbo_voucher.setBounds(320, 550, 380, 40);

        cbo_idgalonman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_idgalonman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_idgalonmanMouseClicked(evt);
            }
        });
        cbo_idgalonman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_idgalonmanActionPerformed(evt);
            }
        });
        jPanel1.add(cbo_idgalonman);
        cbo_idgalonman.setBounds(320, 600, 380, 40);

        txt_namagalonman.setBackground(new java.awt.Color(196, 196, 196));
        txt_namagalonman.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txt_namagalonman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namagalonmanActionPerformed(evt);
            }
        });
        jPanel1.add(txt_namagalonman);
        txt_namagalonman.setBounds(320, 650, 380, 40);

        jLabel_namagalonman.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel_namagalonman.setText("NAMA GALONMAN :");
        jPanel1.add(jLabel_namagalonman);
        jLabel_namagalonman.setBounds(30, 650, 228, 47);

        jLabel_idgalonman.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel_idgalonman.setText("ID GALONMAN :");
        jPanel1.add(jLabel_idgalonman);
        jLabel_idgalonman.setBounds(30, 600, 228, 47);

        btn_batalkan.setBackground(new java.awt.Color(255, 0, 0));
        btn_batalkan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btn_batalkan.setText("BATALKAN");
        btn_batalkan.setBorder(null);
        btn_batalkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalkanActionPerformed(evt);
            }
        });
        jPanel1.add(btn_batalkan);
        btn_batalkan.setBounds(1030, 570, 200, 50);

        btn_delete.setBackground(new java.awt.Color(0, 255, 25));
        btn_delete.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btn_delete.setText("DELETE");
        btn_delete.setBorder(null);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_delete);
        btn_delete.setBounds(770, 640, 200, 50);

        btn_edit.setBackground(new java.awt.Color(0, 255, 25));
        btn_edit.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btn_edit.setText("SIMPAN");
        btn_edit.setBorder(null);
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        jPanel1.add(btn_edit);
        btn_edit.setBounds(770, 570, 200, 50);

        TabelMemesan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TabelMemesan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelMemesanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelMemesan);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(760, 310, 480, 80);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Tabel Memesan");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(850, 240, 270, 44);

        TabelPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TabelPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPelangganMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelPelanggan);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(760, 130, 470, 110);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setText("Tabel Pelanggan");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(870, 70, 270, 44);

        txt_idpelanggan.setBackground(new java.awt.Color(196, 196, 196));
        txt_idpelanggan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txt_idpelanggan);
        txt_idpelanggan.setBounds(320, 10, 377, 40);

        jLabel_idpelanggan1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel_idpelanggan1.setText("ID PELANGGAN :");
        jPanel1.add(jLabel_idpelanggan1);
        jLabel_idpelanggan1.setBounds(30, 0, 228, 47);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDIT");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(940, 10, 160, 40);

        jLabel_idpelanggan2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel_idpelanggan2.setText("No. Pesanan :");
        jPanel1.add(jLabel_idpelanggan2);
        jLabel_idpelanggan2.setBounds(30, 200, 228, 47);

        txt_nopesan.setBackground(new java.awt.Color(196, 196, 196));
        txt_nopesan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txt_nopesan);
        txt_nopesan.setBounds(320, 210, 380, 40);

        jLabel_idpelanggan3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel_idpelanggan3.setText("Nama Karyawan :");
        jPanel1.add(jLabel_idpelanggan3);
        jLabel_idpelanggan3.setBounds(30, 300, 228, 47);

        txt_namakaryawan.setBackground(new java.awt.Color(196, 196, 196));
        txt_namakaryawan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txt_namakaryawan);
        txt_namakaryawan.setBounds(320, 310, 380, 40);

        btn_home.setBackground(new java.awt.Color(255, 0, 0));
        btn_home.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btn_home.setText("HOME");
        btn_home.setBorder(null);
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_home);
        btn_home.setBounds(1030, 640, 200, 50);

        jLabel7.setText("jLabel4");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(790, 650, 41, 16);

        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(320, 10, 41, 16);

        txt_Id.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txt_Id);
        txt_Id.setBounds(320, 10, 180, 45);

        txt_Nama.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txt_Nama);
        txt_Nama.setBounds(320, 60, 180, 45);

        txt_Hp.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txt_Hp);
        txt_Hp.setBounds(320, 110, 180, 45);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1280, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_pesananKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesananKeyTyped
        // TODO add your handling code here:
        try{
            int x = Integer.parseInt(getTxt_pesanan().getText());
            int biaya = x*5000;
            getTxt_biaya().setText(biaya + "");
        }
        catch(NumberFormatException e){}

    }//GEN-LAST:event_txt_pesananKeyTyped

    private void txt_diskonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_diskonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_diskonActionPerformed

    private void txt_diskonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_diskonKeyPressed
        try{
            int diskon = Integer.parseInt(getTxt_diskon().getText());
            int biaya = Integer.parseInt(getTxt_biaya().getText());
            int total = biaya-diskon;
            getTxt_total().setText(total + "");
        }
        catch(NumberFormatException e){}
    }//GEN-LAST:event_txt_diskonKeyPressed

    private void cbo_idgalonmanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_idgalonmanMouseClicked
        String id= cbo_idgalonman.getSelectedItem().toString();
        if(id.equals("G001"))
        {
            txt_namagalonman.setText("Randi");
        }
        else
        {
            txt_namagalonman.setText("Dani");
        }
    }//GEN-LAST:event_cbo_idgalonmanMouseClicked

    private void cbo_idgalonmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_idgalonmanActionPerformed

    }//GEN-LAST:event_cbo_idgalonmanActionPerformed

    private void btn_batalkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalkanActionPerformed
        // TODO add your handling code here:

        int response = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus ?", "DELETE", JOptionPane.YES_NO_OPTION);

        if(response == JOptionPane.YES_OPTION){
            controllerM.clearForm1();
        }
        else if(response==JOptionPane.NO_OPTION){
            // Isi fungsinya disini ...
        }

    }//GEN-LAST:event_btn_batalkanActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus ?", "DELETE", JOptionPane.YES_NO_OPTION);

        if(response == JOptionPane.YES_OPTION){
            controllerM.DeleteM();
            tableMemesan();
            controllerM.DeleteP();
            tablePelanggan();
            controllerM.clearForm1();
        }
        else if(response==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(this, "Hapus Data dibatalkan");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        controllerM.UpdateP();
        tablePelanggan();
        controllerM.UpdateM();
        tableMemesan();
        controllerM.clearForm1();
    }//GEN-LAST:event_btn_editActionPerformed

    private void txt_pesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesananActionPerformed

    private void txt_namagalonmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namagalonmanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namagalonmanActionPerformed

    private void TabelPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPelangganMouseClicked
        try {
            controllerM.onMouseClickTablePelanggan();
        } catch (SQLException ex) {
            Logger.getLogger(Form_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TabelPelangganMouseClicked

    private void TabelMemesanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMemesanMouseClicked
        try {
            controllerM.onMouseClickMemesan();
        } catch (SQLException ex) {
            Logger.getLogger(Form_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TabelMemesanMouseClicked

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
       Form_MenuUtama f = new Form_MenuUtama();
            f.setVisible(true);
            f.toFront();
            f.getTxt_Id().setText(getTxt_Id().getText());
            f.getTxt_Id().setEditable(false);
            f.getTxt_Nama().setText(getTxt_Nama().getText());
            f.getTxt_Nama().setEditable(false);
            f.getTxt_Hp().setText(getTxt_Hp().getText());
            f.getTxt_Hp().setEditable(false);
            f.getjLabel3().setText(getjLabel7().getText());
            f.getTxt_statusair().setText(getjLabel8().getText());
            if(f.getTxt_statusair().getText().equalsIgnoreCase("Tersedia")){
                f.getBtn_input().setEnabled(true);
            }
            else
            {
                f.getBtn_input().setEnabled(false);
            }
            if(getjLabel7().getText().equalsIgnoreCase("Owner"))
            {
                f.getBtn_laporan().setEnabled(true);
            }
            else{
                f.getBtn_laporan().setEnabled(false);
            }
            dispose();
    }//GEN-LAST:event_btn_homeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_CRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelMemesan;
    private javax.swing.JTable TabelPelanggan;
    private javax.swing.JButton btn_batalkan;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_home;
    private javax.swing.JComboBox<String> cbo_idgalonman;
    private javax.swing.JComboBox<String> cbo_voucher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_alamat;
    private javax.swing.JLabel jLabel_biaya;
    private javax.swing.JLabel jLabel_idgalonman;
    private javax.swing.JLabel jLabel_idpelanggan;
    private javax.swing.JLabel jLabel_idpelanggan1;
    private javax.swing.JLabel jLabel_idpelanggan2;
    private javax.swing.JLabel jLabel_idpelanggan3;
    private javax.swing.JLabel jLabel_namagalonman;
    private javax.swing.JLabel jLabel_namapelanggan;
    private javax.swing.JLabel jLabel_nohppelanggan;
    private javax.swing.JLabel jLabel_pesanan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txt_Hp;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txt_Nama;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_biaya;
    private javax.swing.JTextField txt_diskon;
    private javax.swing.JTextField txt_idkaryawan;
    private javax.swing.JTextField txt_idpelanggan;
    private javax.swing.JTextField txt_namagalonman;
    private javax.swing.JTextField txt_namakaryawan;
    private javax.swing.JTextField txt_namapelanggan;
    private javax.swing.JTextField txt_nohppelanggan;
    private javax.swing.JTextField txt_nopesan;
    private javax.swing.JTextField txt_pesanan;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
