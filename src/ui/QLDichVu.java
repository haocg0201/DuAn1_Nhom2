/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Entity.DichVu;
import Entity.HoaDonChiTiet;
import dao.DichVuDao;
import dao.HoaDonCTDao;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import utils.MsgBox;

/**
 *
 * @author admin
 */
public class QLDichVu extends javax.swing.JInternalFrame {
    DichVuDao dao= new DichVuDao();
    DefaultTableModel mol;
    int index= -1;

    /**
     * Creates new form QuanLyDichVu
     */
    public QLDichVu() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaDV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGiaTien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTenDV = new javax.swing.JTextField();
        rdo1 = new javax.swing.JRadioButton();
        rdo2 = new javax.swing.JRadioButton();
        btnSua = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhsach = new javax.swing.JTable();

        setClosable(true);
        setTitle("DỊCH VỤ");

        jLabel1.setText("Mã dịch vụ:");

        jLabel2.setText("Tên dịch vụ:");

        jLabel3.setText("Số lượng:");

        jLabel5.setText("Giá tiền:");

        jLabel6.setText("Trạng thái: ");

        buttonGroup1.add(rdo1);
        rdo1.setText("Sẵn sàng");

        buttonGroup1.add(rdo2);
        rdo2.setText("Đã hủy");

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua.setText("Cập nhật");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaDV)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdo1)
                        .addGap(18, 18, 18)
                        .addComponent(rdo2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTenDV)
                    .addComponent(txtSoLuong)
                    .addComponent(txtGiaTien))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(rdo1)
                        .addComponent(rdo2))
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tabs.addTab("Cập nhật", jPanel2);

        tblDanhsach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Giá tiền", "Trạng thái DV"
            }
        ));
        tblDanhsach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhsachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhsach);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );

        tabs.addTab("Danh sách", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        sua();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblDanhsachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhsachMouseClicked
        // TODO add your handling code here:
        click(evt);
    }//GEN-LAST:event_tblDanhsachMouseClicked

    void init(){
        txtMaDV.setEnabled(false);
        txtTenDV.setEnabled(false);
        txtSoLuong.setEnabled(false);
        txtGiaTien.setEnabled(false);
        loadData();
        tabs.setSelectedIndex(1);
    }
    
    void loadData(){
        mol= (DefaultTableModel)tblDanhsach.getModel();
        mol.setRowCount(0);
        List<DichVu> list= dao.selectByIdHDCT(QLHoaDonChiTiet.maHDCT);
        for (DichVu dv : list) {
            mol.addRow(new Object[]{dv.getMaDV(),dv.getTenDV(),dv.getSoLuong(),dv.getGiaTien(),dv.getTrangThaiDichVu() == true ? "Sẵn sàng" : "Đã hủy"});
        }
    }
    
    
    void click(java.awt.event.MouseEvent evt){
        if(evt.getClickCount()==2){
            this.index= tblDanhsach.rowAtPoint(evt.getPoint());
            tblDanhsach.setRowSelectionInterval(this.index, this.index);
            int madv= Integer.valueOf(tblDanhsach.getValueAt(this.index, 0)+"");
            DichVu dv= dao.selectById(madv);
            txtMaDV.setText(dv.getMaDV()+"");
            txtTenDV.setText(dv.getTenDV());
            txtSoLuong.setText(dv.getSoLuong()+"");
            txtGiaTien.setText(dv.getGiaTien()+"");
            if(dv.getTrangThaiDichVu()==true){
                rdo1.setSelected(true);
            }else{
                rdo2.setSelected(true);
            }
            tabs.setSelectedIndex(0);
        }
    }
    
    HoaDonCTDao hdctDao = new HoaDonCTDao();
    
    void moi(){
        txtGiaTien.setText("");
        txtMaDV.setText("");
        txtSoLuong.setText("");
        txtTenDV.setText("");
        rdo1.setSelected(true);
    }
    
    void sua(){
        int madv= Integer.valueOf(tblDanhsach.getValueAt(this.index, 0)+"");
        DichVu dv= dao.selectById(madv);
        if(rdo1.isSelected()){
            dv.setTrangThaiDichVu(true);
        }else{
            dv.setTrangThaiDichVu(false);
            HoaDonChiTiet hdct = hdctDao.selectById(dv.getMaHDCT());
            hdct.setGiaTien(hdct.getGiaTien()- (Float.valueOf(txtGiaTien.getText())*Float.valueOf(txtSoLuong.getText())));
            hdctDao.update(hdct);
        }
        dao.update(dv);
        moi();
        loadData();
        MsgBox.alert(this, "Sửa dịch vụ thành công");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdo1;
    private javax.swing.JRadioButton rdo2;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblDanhsach;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtMaDV;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenDV;
    // End of variables declaration//GEN-END:variables
}
