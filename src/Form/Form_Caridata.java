/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.KaryawanController;
import Controller.MemesanController;
import Koneksi.Koneksi;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import Model.Karyawan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class Form_Caridata extends javax.swing.JFrame {


    /**
     * Creates new form Form_MenuUtama
     */
    
    KaryawanController controller;
    MemesanController controllerM;
    String id;
    public Form_Caridata() {
        initComponents();
        panel_bground2.setBackground(new Color(27,22,22,127));
        paneljudul_table.setBackground(new Color(0,204,255,204));
        table.setDefaultRenderer(Object.class, new table_warna(new Color(0,204,255,229), new Color(0,204,255,178)));
        LebarKolom();
        table.setRowHeight(40);
        controllerM = new MemesanController(this);
        tableMemesan();
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public JButton getBtn_edit() {
        return btn_edit;
    }

    public JButton getBtn_laporan() {
        return btn_laporan;
    }

    public JButton getBtn_input() {
        return btn_input;
    }
    
    private void tableMemesan(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No pesanan");
        model.addColumn("Id Pelanggan");
        model.addColumn("Id Karyawan");
        model.addColumn("Nama Pelanggan");
        model.addColumn("Alamat Pelanggan");
        model.addColumn("Nama Karyawan");
        model.addColumn("Jumlah Pesanan");
        model.addColumn("Vourcher");
        model.addColumn("Tgl Pesanan");
        model.addColumn("Biaya");
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getKoneksi();
            String sql = "SELECT memesan.nopesanan, memesan.id_p, memesan.id_k, "
                    + "pelanggan.nama_p, pelanggan.alamat_p, memesan.nama_k, "
                    + "memesan.jmlpesanan, memesan.voucher, memesan.tglpesanan, "
                    + "memesan.biaya FROM memesan memesan INNER JOIN pelanggan "
                    + "pelanggan ON memesan.id_p=pelanggan.id_p "
                    + "ORDER BY memesan.tglpesanan DESC;";
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
                    rs.getString(10)
                });
            }
            table.setModel(model);
        } catch(Exception e){
            System.out.println("Error => "+e);
        }
    }
    private void tableCariMemesan()
    {
        id=txt_idpelanggan.getText();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No pesanan");
        model.addColumn("Id Pelanggan");
        model.addColumn("Id Karyawan");
        model.addColumn("Nama Pelanggan");
        model.addColumn("Alamat Pelanggan");
        model.addColumn("Nama Karyawan");
        model.addColumn("Jumlah Pesanan");
        model.addColumn("Vourcher");
        model.addColumn("Tgl Pesanan");
        model.addColumn("Biaya");
        try{
            Koneksi k = new Koneksi();
            Connection con = k.getKoneksi();
            String sql = "SELECT memesan.nopesanan, memesan.id_p, memesan.id_k, "
                    + "pelanggan.nama_p, pelanggan.alamat_p, memesan.nama_k, "
                    + "memesan.jmlpesanan, memesan.voucher, memesan.tglpesanan, "
                    + "memesan.biaya FROM memesan memesan INNER JOIN pelanggan "
                    + "pelanggan ON memesan.id_p=pelanggan.id_p "
                    + "WHERE memesan.id_p='"+id+"' "
                    + "ORDER BY memesan.tglpesanan DESC;";
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
                    rs.getString(10)
                });
            }
            table.setModel(model);
        } catch(Exception e){
            System.out.println("Error => "+e);
        }
    }
    public void LebarKolom(){ 
        TableColumn column;
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = table.getColumnModel().getColumn(0); 
        column.setPreferredWidth(122);
        column = table.getColumnModel().getColumn(1); 
        column.setPreferredWidth(117); 
        column = table.getColumnModel().getColumn(2); 
        column.setPreferredWidth(118); 
        column = table.getColumnModel().getColumn(3); 
        column.setPreferredWidth(118); 
        column = table.getColumnModel().getColumn(4); 
        column.setPreferredWidth(117);
        column = table.getColumnModel().getColumn(5); 
        column.setPreferredWidth(118); 
        column = table.getColumnModel().getColumn(6); 
        column.setPreferredWidth(107); 
        column = table.getColumnModel().getColumn(7); 
        column.setPreferredWidth(128); 
        column = table.getColumnModel().getColumn(8); 
        column.setPreferredWidth(118); 
    }
    
    public javax.swing.JTextField getTxt_Id(){
        return txt_Id;
    }
    
    public javax.swing.JTextField getTxt_Nama(){
        return txt_Nama;
    }
    
    public javax.swing.JTextField getTxt_Hp(){
        return txt_Hp;
    }
    
    public javax.swing.JTable getTable(){
        return table;
    }
    
    public javax.swing.JTextField getTxtId(){
        return txt_idpelanggan;
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
        panel_judul = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panel_menu = new javax.swing.JPanel();
        jLabel_nohp = new javax.swing.JLabel();
        jLabel_id = new javax.swing.JLabel();
        jLabel_nama = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        btn_caridata = new javax.swing.JButton();
        btn_laporan = new javax.swing.JButton();
        btn_menuutama = new javax.swing.JButton();
        btn_input = new javax.swing.JButton();
        txt_Id = new javax.swing.JTextField();
        txt_Nama = new javax.swing.JTextField();
        txt_Hp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel_idpelanggan = new javax.swing.JLabel();
        txt_idpelanggan = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        panel_bground2 = new javax.swing.JPanel();
        paneljudul_table = new javax.swing.JPanel();
        judultable_id = new javax.swing.JLabel();
        judultable_idk = new javax.swing.JLabel();
        judultable_idgalonman = new javax.swing.JLabel();
        judultable_nama = new javax.swing.JLabel();
        judultable_jmlpesanan = new javax.swing.JLabel();
        judultable_diskon = new javax.swing.JLabel();
        judultable_voucher = new javax.swing.JLabel();
        judultable_tglpesanan = new javax.swing.JLabel();
        judultable_jmlpembayaran = new javax.swing.JLabel();
        judultable_nama1 = new javax.swing.JLabel();
        judultable_nama2 = new javax.swing.JLabel();
        table = new javax.swing.JTable();
        btn_edit = new javax.swing.JButton();
        panel_galon = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        panel_judul.setPreferredSize(new java.awt.Dimension(1440, 115));
        panel_judul.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CARI DATA");
        panel_judul.add(jLabel1);
        jLabel1.setBounds(400, 30, 679, 60);

        jPanel1.add(panel_judul);
        panel_judul.setBounds(0, 0, 1478, 115);

        panel_menu.setBackground(new java.awt.Color(48, 179, 235));
        panel_menu.setLayout(null);

        jLabel_nohp.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel_nohp.setText("NO HP :");
        panel_menu.add(jLabel_nohp);
        jLabel_nohp.setBounds(30, 230, 101, 45);

        jLabel_id.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel_id.setText("ID :");
        panel_menu.add(jLabel_id);
        jLabel_id.setBounds(30, 130, 101, 45);

        jLabel_nama.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel_nama.setText("NAMA :");
        panel_menu.add(jLabel_nama);
        jLabel_nama.setBounds(30, 180, 101, 45);

        btn_logout.setBackground(new java.awt.Color(227, 247, 255));
        btn_logout.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btn_logout.setText("LOGOUT");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        panel_menu.add(btn_logout);
        btn_logout.setBounds(80, 640, 200, 50);

        btn_caridata.setBackground(new java.awt.Color(227, 247, 255));
        btn_caridata.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btn_caridata.setText("CARI DATA");
        btn_caridata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_caridataActionPerformed(evt);
            }
        });
        panel_menu.add(btn_caridata);
        btn_caridata.setBounds(80, 400, 200, 50);

        btn_laporan.setBackground(new java.awt.Color(227, 247, 255));
        btn_laporan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btn_laporan.setText("LAPORAN");
        btn_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporanActionPerformed(evt);
            }
        });
        panel_menu.add(btn_laporan);
        btn_laporan.setBounds(80, 560, 200, 50);

        btn_menuutama.setBackground(new java.awt.Color(227, 247, 255));
        btn_menuutama.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btn_menuutama.setText("MENU UTAMA");
        btn_menuutama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuutamaActionPerformed(evt);
            }
        });
        panel_menu.add(btn_menuutama);
        btn_menuutama.setBounds(80, 320, 200, 50);

        btn_input.setBackground(new java.awt.Color(227, 247, 255));
        btn_input.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btn_input.setText("INPUT");
        btn_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inputActionPerformed(evt);
            }
        });
        panel_menu.add(btn_input);
        btn_input.setBounds(80, 480, 200, 50);

        txt_Id.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        panel_menu.add(txt_Id);
        txt_Id.setBounds(160, 130, 180, 45);

        txt_Nama.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        panel_menu.add(txt_Nama);
        txt_Nama.setBounds(160, 180, 180, 45);

        txt_Hp.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        panel_menu.add(txt_Hp);
        txt_Hp.setBounds(160, 230, 180, 45);

        jLabel3.setText("jLabel4");
        panel_menu.add(jLabel3);
        jLabel3.setBounds(244, 252, 60, 30);

        jLabel4.setText("jLabel4");
        panel_menu.add(jLabel4);
        jLabel4.setBounds(180, 200, 51, 20);

        jPanel1.add(panel_menu);
        panel_menu.setBounds(0, 2, 359, 1020);

        jLabel_idpelanggan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel_idpelanggan.setText("ID PELANGGAN :");
        jPanel1.add(jLabel_idpelanggan);
        jLabel_idpelanggan.setBounds(391, 212, 228, 47);

        txt_idpelanggan.setBackground(new java.awt.Color(196, 196, 196));
        txt_idpelanggan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txt_idpelanggan);
        txt_idpelanggan.setBounds(651, 216, 377, 45);

        btn_cari.setBackground(new java.awt.Color(196, 196, 196));
        btn_cari.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btn_cari.setText("CARI");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cari);
        btn_cari.setBounds(1060, 216, 135, 45);

        panel_bground2.setBackground(new java.awt.Color(255, 255, 255));
        panel_bground2.setLayout(null);

        paneljudul_table.setLayout(null);

        judultable_id.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        judultable_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judultable_id.setText("No Pesanan");
        paneljudul_table.add(judultable_id);
        judultable_id.setBounds(0, 0, 110, 57);

        judultable_idk.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        judultable_idk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judultable_idk.setText("ID Pelanggan");
        judultable_idk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paneljudul_table.add(judultable_idk);
        judultable_idk.setBounds(90, 0, 120, 57);

        judultable_idgalonman.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        judultable_idgalonman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judultable_idgalonman.setText("ID Karyawan");
        judultable_idgalonman.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paneljudul_table.add(judultable_idgalonman);
        judultable_idgalonman.setBounds(190, 0, 120, 57);

        judultable_nama.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        judultable_nama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judultable_nama.setText("Alamat Pelanggan");
        judultable_nama.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paneljudul_table.add(judultable_nama);
        judultable_nama.setBounds(400, 0, 120, 57);

        judultable_jmlpesanan.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        judultable_jmlpesanan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judultable_jmlpesanan.setText("Nama Karyawan");
        judultable_jmlpesanan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paneljudul_table.add(judultable_jmlpesanan);
        judultable_jmlpesanan.setBounds(510, 0, 100, 57);

        judultable_diskon.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        judultable_diskon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judultable_diskon.setText("Jumlah Pesanan");
        judultable_diskon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paneljudul_table.add(judultable_diskon);
        judultable_diskon.setBounds(620, 0, 100, 57);

        judultable_voucher.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        judultable_voucher.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judultable_voucher.setText("Voucher");
        judultable_voucher.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paneljudul_table.add(judultable_voucher);
        judultable_voucher.setBounds(730, 0, 70, 57);

        judultable_tglpesanan.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        judultable_tglpesanan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judultable_tglpesanan.setText("Tanggal Pesanan");
        judultable_tglpesanan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paneljudul_table.add(judultable_tglpesanan);
        judultable_tglpesanan.setBounds(798, 0, 110, 57);

        judultable_jmlpembayaran.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        judultable_jmlpembayaran.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judultable_jmlpembayaran.setText("Jumlah Pembayaran");
        judultable_jmlpembayaran.setToolTipText("");
        judultable_jmlpembayaran.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paneljudul_table.add(judultable_jmlpembayaran);
        judultable_jmlpembayaran.setBounds(900, 0, 120, 57);

        judultable_nama1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        judultable_nama1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judultable_nama1.setText("Nama Pelanggan");
        judultable_nama1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paneljudul_table.add(judultable_nama1);
        judultable_nama1.setBounds(290, 0, 120, 57);

        judultable_nama2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        judultable_nama2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judultable_nama2.setText("Nama Pelanggan");
        judultable_nama2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paneljudul_table.add(judultable_nama2);
        judultable_nama2.setBounds(290, 0, 120, 57);

        panel_bground2.add(paneljudul_table);
        paneljudul_table.setBounds(0, 180, 1020, 57);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Pelanggan", "ID Karyawan", "ID Galonman", "Nama Pelanggan", "Jumlah Pesanan", "Diskon", "Voucher", "Tanggal Pesanan", "Jumlah Pembayaran"
            }
        ));
        table.setGridColor(new java.awt.Color(0, 0, 0));
        panel_bground2.add(table);
        table.setBounds(0, 240, 1020, 280);

        btn_edit.setBackground(new java.awt.Color(48, 179, 235));
        btn_edit.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        btn_edit.setText("EDIT");
        btn_edit.setBorder(null);
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        panel_bground2.add(btn_edit);
        btn_edit.setBounds(300, 540, 200, 50);

        jPanel1.add(panel_bground2);
        panel_bground2.setBounds(358, 113, 1082, 911);

        panel_galon.setMinimumSize(new java.awt.Dimension(893, 861));
        panel_galon.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/GALON.jpg"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(893, 163));
        jLabel2.setRequestFocusEnabled(false);
        jLabel2.setVerifyInputWhenFocusTarget(false);
        panel_galon.add(jLabel2);
        jLabel2.setBounds(0, 0, 893, 861);

        jPanel1.add(panel_galon);
        panel_galon.setBounds(431, 163, 893, 861);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1392, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1414, 776));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inputActionPerformed
        // TODO add your handling code here:
        
          // new Form_Input().show();
//            Karyawan k = controller.onClickBtnLogin();
           /* Form_Input f = new Form_Input();
           
            f.setVisible(true);
            f.toFront();
            f.getTxt_Id().setText(k.getId_k());
            f.getTxt_Id().setEditable(false);
            f.getTxt_Nama().setText(k.getNama_k());
            f.getTxt_Nama().setEditable(false);
            f.getTxt_Hp().setText(k.getNohp_k());
            f.getTxt_Hp().setEditable(false);*/
            
            Form_Input f = new Form_Input();
            f.setVisible(true);
            f.toFront();
            f.getTxt_Id().setText(getTxt_Id().getText());
            f.getTxt_Id().setEditable(false);
            f.getTxt_Nama().setText(getTxt_Nama().getText());
            f.getTxt_Nama().setEditable(false);
            f.getTxt_Hp().setText(getTxt_Hp().getText());
            f.getTxt_Hp().setEditable(false);
            f.getjLabel6().setText(getjLabel3().getText());
            f.getjLabel7().setText(getjLabel4().getText());
            if(f.getjLabel7().getText().equalsIgnoreCase("Tersedia")){
                f.getBtn_input().setEnabled(true);   
            }
            else
            {
                f.getBtn_input().setEnabled(false);
            }
            if(f.getjLabel6().getText().equalsIgnoreCase("Owner"))
            {
                f.getBtn_laporan().setEnabled(true);
            }
            else{
                f.getBtn_laporan().setEnabled(false);
            }
            dispose();
            
    }//GEN-LAST:event_btn_inputActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
        
        int response = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar ?", "LOGOUT", JOptionPane.YES_NO_OPTION);
            
        if(response == JOptionPane.YES_OPTION){
            Form_Login l = new Form_Login();
            if(getjLabel4().getText().equalsIgnoreCase("Tersedia")){
                l.getKeterangan().setText("Tersedia");
            }
            else
            {
                l.getKeterangan().setText("Tidak tersedia");
            }
            l.setVisible(true);
        }
        dispose();

    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_menuutamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuutamaActionPerformed
        // TODO add your handling code here:
        Form_MenuUtama f = new Form_MenuUtama();
            f.setVisible(true);
            f.toFront();
            f.getTxt_Id().setText(getTxt_Id().getText());
            f.getTxt_Id().setEditable(false);
            f.getTxt_Nama().setText(getTxt_Nama().getText());
            f.getTxt_Nama().setEditable(false);
            f.getTxt_Hp().setText(getTxt_Hp().getText());
            f.getTxt_Hp().setEditable(false);
            f.getjLabel3().setText(getjLabel3().getText());
            f.getTxt_statusair().setText(getjLabel4().getText());
            if(f.getTxt_statusair().getText().equalsIgnoreCase("Tersedia")){
                f.getBtn_input().setEnabled(true);   
            }
            else
            {
                f.getBtn_input().setEnabled(false);
            }
            if(f.getjLabel3().getText().equalsIgnoreCase("Owner"))
            {
                f.getBtn_laporan().setEnabled(true);
            }
            else{
                f.getBtn_laporan().setEnabled(false);
            }
            dispose();
    }//GEN-LAST:event_btn_menuutamaActionPerformed

    private void btn_caridataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_caridataActionPerformed
        // TODO add your handling code here:
//        Form_Caridata f = new Form_Caridata();
//            f.setVisible(true);
//            f.toFront();
//            f.getTxt_Id().setText(getTxt_Id().getText());
//            f.getTxt_Id().setEditable(false);
//            f.getTxt_Nama().setText(getTxt_Nama().getText());
//            f.getTxt_Nama().setEditable(false);
//            f.getTxt_Hp().setText(getTxt_Hp().getText());
//            f.getTxt_Hp().setEditable(false);
//            f.getjLabel3().setText(getjLabel3().getText());
//            if(getjLabel3().getText().equals("Owner")){
//                f.getBtn_edit().setEnabled(true);
//                f.getBtn_input().setEnabled(true);
//                f.getBtn_laporan().setEnabled(true);
//                f.getjLabel4().setText(getjLabel4().getText());
//            }
//            else{
//                f.getBtn_edit().setEnabled(false);
//                f.getBtn_input().setEnabled(false);
//                f.getBtn_laporan().setEnabled(false);
//                f.getjLabel4().setText(getjLabel4().getText());
//            }
//            dispose();
    }//GEN-LAST:event_btn_caridataActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        Form_CRUD f = new Form_CRUD();
        f.setVisible(true);
        f.getjLabel7().setText(getjLabel3().getText());
        f.getjLabel8().setText(getjLabel4().getText());
        f.getTxt_Id().setText(getTxt_Id().getText());
        f.getTxt_Nama().setText(getTxt_Nama().getText());
        f.getTxt_Hp().setText(getTxt_Hp().getText());
        dispose();
        
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
       
        tableCariMemesan();
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanActionPerformed
       Form_Laporan f = new Form_Laporan();
       f.setVisible(true);
       f.getjLabel4().setText(getjLabel3().getText());
       f.getjLabel2().setText(getjLabel4().getText());
       f.getTxt_Id().setText(getTxt_Id().getText());
       f.getTxt_Id().setEditable(false);
       f.getTxt_Nama().setText(getTxt_Nama().getText());
       f.getTxt_Nama().setEditable(false);
       f.getTxt_Hp().setText(getTxt_Hp().getText());
       f.getTxt_Hp().setEditable(false);
       dispose();
    }//GEN-LAST:event_btn_laporanActionPerformed

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
                new Form_Caridata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_caridata;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_input;
    private javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_menuutama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_id;
    private javax.swing.JLabel jLabel_idpelanggan;
    private javax.swing.JLabel jLabel_nama;
    private javax.swing.JLabel jLabel_nohp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel judultable_diskon;
    private javax.swing.JLabel judultable_id;
    private javax.swing.JLabel judultable_idgalonman;
    private javax.swing.JLabel judultable_idk;
    private javax.swing.JLabel judultable_jmlpembayaran;
    private javax.swing.JLabel judultable_jmlpesanan;
    private javax.swing.JLabel judultable_nama;
    private javax.swing.JLabel judultable_nama1;
    private javax.swing.JLabel judultable_nama2;
    private javax.swing.JLabel judultable_tglpesanan;
    private javax.swing.JLabel judultable_voucher;
    private javax.swing.JPanel panel_bground2;
    private javax.swing.JPanel panel_galon;
    private javax.swing.JPanel panel_judul;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JPanel paneljudul_table;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_Hp;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txt_Nama;
    private javax.swing.JTextField txt_idpelanggan;
    // End of variables declaration//GEN-END:variables
}
