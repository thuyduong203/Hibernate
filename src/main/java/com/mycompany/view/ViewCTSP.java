/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.view;

import com.mycompany.customModel.ChiTietSPCustomModel;
import com.mycompany.domainModel.ChiTietSP;
import com.mycompany.domainModel.DongSP;
import com.mycompany.domainModel.MauSac;
import com.mycompany.domainModel.NSX;
import com.mycompany.domainModel.SanPham;
import com.mycompany.service.impl.ChiTietSanPhamServiceImpl;
import com.mycompany.service.impl.DongSPServiceImpl;
import com.mycompany.service.impl.MauSacServiceImpl;
import com.mycompany.service.impl.NSXServiceImpl;
import com.mycompany.service.impl.SanPhamServiceImpl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duongntt
 */
public class ViewCTSP extends javax.swing.JFrame {

    private DefaultComboBoxModel dcbmIDSP = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmIDNsx = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmIDMauSac = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcbmIDDongSP = new DefaultComboBoxModel();
    private DefaultTableModel dtmChiTietSP = new DefaultTableModel();
    private List<ChiTietSP> listChiTietSP = new ArrayList<>();
    private List<SanPham> listSP = new ArrayList<>();
    private List<NSX> listNSX = new ArrayList<>();
    private List<MauSac> listMauSac = new ArrayList<>();
    private List<DongSP> listDongSp = new ArrayList<>();
    private ChiTietSanPhamServiceImpl chiTietSanPhamServiceImpl = new ChiTietSanPhamServiceImpl();
    private DongSPServiceImpl dongSPServiceImpl = new DongSPServiceImpl();
    private MauSacServiceImpl mauSacServiceImpl = new MauSacServiceImpl();
    private NSXServiceImpl nSXServiceImpl = new NSXServiceImpl();
    private SanPhamServiceImpl sanPhamServiceImpl = new SanPhamServiceImpl();
    private List<ChiTietSPCustomModel> listCTSPCustom = new ArrayList<>();

    public ViewCTSP() {
        initComponents();
        cbbIdSP.setModel(dcbmIDSP);
        cbbIdNsx.setModel(dcbmIDNsx);
        cbbIDMauSac.setModel(dcbmIDMauSac);
        cbbIDDongSP.setModel(dcbmIDDongSP);
        tblChiTietSP.setModel(dtmChiTietSP);
        String headers[] = {"Id CTSP", "Tên SP", "Tên NSX", "Màu sắc", "Tên dòng SP", "Năm BH", "Mô tả", "SL tồn", "Giá Nhập", "Giá Bán"};
        dtmChiTietSP.setColumnIdentifiers(headers);
        loadCbb();
        listChiTietSP = chiTietSanPhamServiceImpl.getAll();
        listCTSPCustom = chiTietSanPhamServiceImpl.getAllCustom();
        showData(listCTSPCustom);
    }

    private void showData(List<ChiTietSPCustomModel> listCTSPShow) {
        dtmChiTietSP.setRowCount(0);
        for (ChiTietSPCustomModel chiTietSPCustomModel : listCTSPShow) {
            dtmChiTietSP.addRow(chiTietSPCustomModel.toDataRow());
        }
    }

    private void loadCbb() {
        listSP = sanPhamServiceImpl.getAll();
        listNSX = nSXServiceImpl.getAll();
        listMauSac = mauSacServiceImpl.getAll();
        listDongSp = dongSPServiceImpl.getAll();
        for (SanPham sanPham : listSP) {
            dcbmIDSP.addElement(sanPham.getIdSP());
        }
        for (NSX nsx : listNSX) {
            dcbmIDNsx.addElement(nsx.getIdNSX());
        }
        for (MauSac mauSac : listMauSac) {
            dcbmIDMauSac.addElement(mauSac.getIdMauSac());
        }
        for (DongSP dongSP : listDongSp) {
            dcbmIDDongSP.addElement(dongSP.getIdDongSP());
        }
    }

    private ChiTietSP newChiTietSP() {
        String idSP = cbbIdSP.getSelectedItem().toString();
        String idNSX = cbbIdNsx.getSelectedItem().toString();
        String idMauSac = cbbIDMauSac.getSelectedItem().toString();
        String idDongSP = cbbIDDongSP.getSelectedItem().toString();
        SanPham sanPham = new SanPham();
        sanPham.setIdSP(idSP);
        NSX nsx = new NSX(idNSX);
        MauSac mauSac = new MauSac(idMauSac);
        DongSP dongSP = new DongSP(idDongSP);
        String moTa = txtMoTa.getText();
        int namBH = Integer.valueOf(txtNamBH.getText());
        int soLuongTon = Integer.valueOf(txtSLTon.getText());
        double giaNhap1 = Double.valueOf(txtGiaNhap.getText());
        BigDecimal giaNhap = BigDecimal.valueOf(giaNhap1);
        double giaBan1 = Double.valueOf(txtGiaBan.getText());
        BigDecimal giaBan = BigDecimal.valueOf(giaBan1);
        ChiTietSP chiTietSP = new ChiTietSP(dongSP, giaBan, giaNhap, mauSac, moTa, namBH, nsx, sanPham, soLuongTon);
        return chiTietSP;
    }

    private void fill(int index, List<ChiTietSP> listCTSP) {
        ChiTietSP chiTietSP = listCTSP.get(index);
        cbbIdSP.setSelectedItem(chiTietSP.getSanPham().getIdSP());
        cbbIdNsx.setSelectedItem(chiTietSP.getNsx().getIdNSX());
        cbbIDMauSac.setSelectedItem(chiTietSP.getMauSac().getIdMauSac());
        cbbIDDongSP.setSelectedItem(chiTietSP.getDongSP().getIdDongSP());
        txtMoTa.setText(chiTietSP.getMoTa());
        txtNamBH.setText(String.valueOf(chiTietSP.getNamBH()));
        txtSLTon.setText(String.valueOf(chiTietSP.getSoLuongTon()));
        txtGiaNhap.setText(String.valueOf(chiTietSP.getGiaNhap()));
        txtGiaBan.setText(String.valueOf(chiTietSP.getGiaBan()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbbIdSP = new javax.swing.JComboBox<>();
        cbbIdNsx = new javax.swing.JComboBox<>();
        cbbIDMauSac = new javax.swing.JComboBox<>();
        cbbIDDongSP = new javax.swing.JComboBox<>();
        txtMoTa = new javax.swing.JTextField();
        txtSLTon = new javax.swing.JTextField();
        txtNamBH = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChiTietSP = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("CHI TIẾT SẢN PHẨM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        jLabel2.setText("Id SP:");

        jLabel3.setText("ID NSX:");

        jLabel4.setText("ID Màu sắc:");

        jLabel5.setText("ID Dòng SP:");

        jLabel6.setText("Mô tả:");

        jLabel7.setText("Giá nhập:");

        jLabel8.setText("SL tồn:");

        jLabel9.setText("Giá bán:");

        jLabel10.setText("Năm BH:");

        cbbIdSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbIdNsx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbIDMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbIDDongSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMoTa)
                    .addComponent(txtSLTon)
                    .addComponent(txtNamBH)
                    .addComponent(cbbIdSP, 0, 298, Short.MAX_VALUE)
                    .addComponent(cbbIdNsx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(97, 97, 97)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbIDMauSac, 0, 259, Short.MAX_VALUE)
                            .addComponent(cbbIDDongSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(cbbIdSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbIDMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(cbbIdNsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbIDDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSLTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tblChiTietSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblChiTietSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChiTietSP);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Chi tiết sản phẩm: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btnThem))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97)
                        .addComponent(btnSua)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(btnXoa)
                                .addGap(104, 104, 104)
                                .addComponent(btnClear))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(447, 447, 447)
                                .addComponent(btnThoat)))
                        .addContainerGap(202, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(25, 25, 25))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(269, 269, 269))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnThoat)
                    .addComponent(btnClear)
                    .addComponent(btnSua))
                .addGap(20, 20, 20)
                .addComponent(jLabel11)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        cbbIDDongSP.setSelectedIndex(0);
        cbbIDMauSac.setSelectedIndex(0);
        cbbIdNsx.setSelectedIndex(0);
        cbbIdSP.setSelectedIndex(0);
        txtMoTa.setText("");
        txtNamBH.setText("");
        txtSLTon.setText("");
        txtGiaNhap.setText("");
        txtGiaBan.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ChiTietSP chiTietSP = newChiTietSP();
        JOptionPane.showMessageDialog(this, chiTietSanPhamServiceImpl.add(chiTietSP));
        listChiTietSP = chiTietSanPhamServiceImpl.getAll();
        listCTSPCustom = chiTietSanPhamServiceImpl.getAllCustom();
        showData(listCTSPCustom);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int index = tblChiTietSP.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "?");
        } else {
            String idCTSp = listChiTietSP.get(index).getIdCTSP();
            JOptionPane.showMessageDialog(this, chiTietSanPhamServiceImpl.delete(idCTSp));
//            listChiTietSP = chiTietSanPhamServiceImpl.getAll();
//            showData(listChiTietSP);
            listCTSPCustom = chiTietSanPhamServiceImpl.getAllCustom();
            showData(listCTSPCustom);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int index = tblChiTietSP.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "?");
        } else {
            String id = listChiTietSP.get(index).getIdCTSP();
            ChiTietSP chiTietSP = newChiTietSP();
            JOptionPane.showMessageDialog(this, chiTietSanPhamServiceImpl.update(chiTietSP, id));
//            listChiTietSP = chiTietSanPhamServiceImpl.getAll();
//            showData(listChiTietSP);
            listCTSPCustom = chiTietSanPhamServiceImpl.getAllCustom();
            showData(listCTSPCustom);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblChiTietSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietSPMouseClicked
        int index = tblChiTietSP.getSelectedRow();
        fill(index, listChiTietSP);
    }//GEN-LAST:event_tblChiTietSPMouseClicked

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
            java.util.logging.Logger.getLogger(ViewCTSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCTSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCTSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCTSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ViewCTSP().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbIDDongSP;
    private javax.swing.JComboBox<String> cbbIDMauSac;
    private javax.swing.JComboBox<String> cbbIdNsx;
    private javax.swing.JComboBox<String> cbbIdSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblChiTietSP;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtNamBH;
    private javax.swing.JTextField txtSLTon;
    // End of variables declaration//GEN-END:variables
}
