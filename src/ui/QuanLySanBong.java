/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Entity.HoaDonChiTiet;
import Entity.SanBong;
import dao.HoaDonCTDao;
import dao.SanBongDao;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import utils.MsgBox;
import utils.XImage;

/**
 *
 * @author admin
 */
public class QuanLySanBong extends javax.swing.JInternalFrame {

    DefaultTableModel mol;
    SanBongDao dao = new SanBongDao();
    HoaDonCTDao dao2 = new HoaDonCTDao();
    int check = 0;
    int index = -1;
    static String maSan;

    /**
     * Creates new form QuanLySanBong
     */
    public QuanLySanBong() {
        initComponents();
        init();
    }

    private void init() {
        this.setFrameIcon(new ImageIcon(XImage.getAppIcon()));
        loadData();
        status();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaSan1 = new javax.swing.JTextField();
        rdo3 = new javax.swing.JRadioButton();
        rdo4 = new javax.swing.JRadioButton();
        txtGiaSan1 = new javax.swing.JTextField();
        cboTrangThai1 = new javax.swing.JComboBox<>();
        btnThem1 = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        btnFirst1 = new javax.swing.JButton();
        btnPrev1 = new javax.swing.JButton();
        btnNext1 = new javax.swing.JButton();
        btnLast1 = new javax.swing.JButton();
        btnMoi1 = new javax.swing.JButton();
        btnXemhoadon = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanBong = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();

        setClosable(true);
        setTitle("QU???N L?? S??N B??NG");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("M?? s??n b??ng:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Lo???i s??n:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Gi?? s??n:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Tr???ng th??i s??n:");

        rdo3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdo3.setSelected(true);
        rdo3.setText("S??n 7");

        rdo4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdo4.setText("S??n 9");

        cboTrangThai1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S???n s??ng", "H???t khung gi??? ?????t", "B???o tr??" }));

        btnThem1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-24_1.png"))); // NOI18N
        btnThem1.setText("Th??m");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnSua1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSua1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-pencil-24.png"))); // NOI18N
        btnSua1.setText("S???a");
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        btnXoa1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-24_1.png"))); // NOI18N
        btnXoa1.setText("X??a");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        btnFirst1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-skip-to-start-24.png"))); // NOI18N
        btnFirst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirst1ActionPerformed(evt);
            }
        });

        btnPrev1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-rewind.png"))); // NOI18N
        btnPrev1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrev1ActionPerformed(evt);
            }
        });

        btnNext1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-rewind-2.png"))); // NOI18N
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });

        btnLast1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-skip-to-start.png"))); // NOI18N
        btnLast1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast1ActionPerformed(evt);
            }
        });

        btnMoi1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMoi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-new-24.png"))); // NOI18N
        btnMoi1.setText("M???i");
        btnMoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoi1ActionPerformed(evt);
            }
        });

        btnXemhoadon.setText("Xem h??a ????n");
        btnXemhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemhoadonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaSan1)
                            .addComponent(txtMaSan1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdo3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdo4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cboTrangThai1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXemhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMoi1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(btnFirst1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrev1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(txtMaSan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdo3)
                            .addComponent(rdo4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel6)))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(txtGiaSan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel8))
                            .addComponent(cboTrangThai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXemhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnFirst1)
                                .addComponent(btnPrev1)
                                .addComponent(btnNext1)
                                .addComponent(btnLast1))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnMoi1)
                                .addComponent(btnXoa1)
                                .addComponent(btnSua1)
                                .addComponent(btnThem1)))
                        .addContainerGap())))
        );

        tabs1.addTab("C???p nh???t", jPanel2);

        tblSanBong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "M?? s??n b??ng", "Lo???i s??n b??ng", "Tr???ng th??i", "Gi?? ti???n"
            }
        ));
        tblSanBong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanBongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanBong);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "T??M KI???M", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-search-24.png"))); // NOI18N
        btnTimKiem.setText("T??M KI???M");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtTimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem)
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimKiem))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
        );

        tabs1.addTab("Danh s??ch", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        // TODO add your handling code here:
        List<SanBong> list = dao.selectAll();
        for (SanBong sb : list) {
            if (txtMaSan1.getText().equals(sb.getMaSan())) {
                check = 0;
                MsgBox.alert(this, "M?? s??n ???? t???n t???i");
                return;
            }
        }
        checkDuLieu();
        if (check == 1) {
            them();
        }
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        // TODO add your handling code here:
        checkDuLieu();
        if (check == 1) {
            sua();
        }
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        // TODO add your handling code here:
        xoa();
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void btnFirst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirst1ActionPerformed
        // TODO add your handling code here:
        this.index = 0;
        index();
        status();
    }//GEN-LAST:event_btnFirst1ActionPerformed

    private void btnPrev1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrev1ActionPerformed
        // TODO add your handling code here:
        this.index--;
        index();
        status();
    }//GEN-LAST:event_btnPrev1ActionPerformed

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        // TODO add your handling code here:
        this.index++;
        index();
        status();
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnLast1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast1ActionPerformed
        // TODO add your handling code here:
        this.index = tblSanBong.getRowCount() - 1;
        index();
        status();
    }//GEN-LAST:event_btnLast1ActionPerformed

    private void btnMoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoi1ActionPerformed
        // TODO add your handling code here:
        moi();
    }//GEN-LAST:event_btnMoi1ActionPerformed

    private void tblSanBongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanBongMouseClicked
        // TODO add your handling code here:
        click(evt);
        status();
    }//GEN-LAST:event_tblSanBongMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        timkiem();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXemhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemhoadonActionPerformed
        // TODO add your handling code here:
        BaoTri bt= new BaoTri();
        this.getDesktopPane().add(bt);
        bt.setVisible(true);
    }//GEN-LAST:event_btnXemhoadonActionPerformed

    void loadData() {
        DecimalFormat dcf= new DecimalFormat("###,###,### VN??");
        List<SanBong> list = dao.selectAll();
        mol = (DefaultTableModel) tblSanBong.getModel();
        mol.setRowCount(0);
        for (SanBong sb : list) {
            mol.addRow(new Object[]{sb.getMaSan(), sb.getLoaiSan(), sb.getTrangThaiSan(), dcf.format(sb.getGiaSan())});
        }
    }

    void moi() {
        this.index = -1;
        status();
        txtMaSan1.setText("");
        rdo3.setSelected(true);
        txtGiaSan1.setText("");
        txtTimKiem.setText("");
        cboTrangThai1.setSelectedIndex(0);
        List<SanBong> list = dao.selectAll();
        mol.setRowCount(0);
        for (SanBong sb : list) {
            mol.addRow(new Object[]{sb.getMaSan(), sb.getLoaiSan(), sb.getTrangThaiSan(), sb.getGiaSan()});
        }
    }

    void checkDuLieu() {
        if (txtMaSan1.getText().equals("")) {
            check = 0;
            MsgBox.alert(this, "Vui l??ng nh???p m?? s??n");
            return;
        } else if (txtMaSan1.getText().trim().equals("")) {
            check = 0;
            MsgBox.alert(this, "M?? s??n kh??ng ch??a kho???ng tr???ng");
            return;
        }
        if (txtGiaSan1.getText().equals("")) {
            check = 0;
            MsgBox.alert(this, "Vui l??ng nh???p gi?? s??n");
            return;
        } else if (txtGiaSan1.getText().trim().equals("")) {
            check = 0;
            MsgBox.alert(this, "Gi?? s??n kh??ng ch??a kho???ng tr???ng");
            return;
        }
        try {
            float giasan = Float.parseFloat(txtGiaSan1.getText());
        } catch (Exception e) {
            check = 0;
            MsgBox.alert(this, "Sai ?????nh d???ng gi?? s??n");
            return;
        }
        check = 1;
    }

    void them() {
        SanBong sb = new SanBong();
        sb.setMaSan(txtMaSan1.getText());
        if (rdo3.isSelected()) {
            sb.setLoaiSan("s??n 7");
        } else {
            sb.setLoaiSan("s??n 9");
        }
        sb.setGiaSan(Float.valueOf(txtGiaSan1.getText()));
        sb.setTrangThaiSan(cboTrangThai1.getSelectedItem() + "");
        try {
            dao.insert(sb);
            MsgBox.alert(this, "Th??m s??n b??ng th??nh c??ng");
            moi();
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void sua() {
        List<HoaDonChiTiet> list = dao2.selectAll();
        for (HoaDonChiTiet hdct : list) {
            if (hdct.getMaSan().equals(txtMaSan1.getText())) {
                if (MsgBox.confirm(this, "V???n c??n h??a ????n b??n trong s??n b??ng n??y. B???n ch???c ch???n mu???n c???p nh???t ch??? ?")) {
                    SanBong sb = new SanBong();
                    sb.setMaSan(txtMaSan1.getText());
                    if (rdo3.isSelected()) {
                        sb.setLoaiSan("s??n 7");
                    } else {
                        sb.setLoaiSan("s??n 9");
                    }
                    sb.setGiaSan(Float.valueOf(txtGiaSan1.getText()));
                    sb.setTrangThaiSan(cboTrangThai1.getSelectedItem() + "");
                    try {
                        dao.update(sb);
                        MsgBox.alert(this, "S???a s??n b??ng th??nh c??ng");
                        moi();
                        loadData();
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    return;
                }
            } else {
                SanBong sb = new SanBong();
                sb.setMaSan(txtMaSan1.getText());
                if (rdo3.isSelected()) {
                    sb.setLoaiSan("s??n 7");
                } else {
                    sb.setLoaiSan("s??n 9");
                }
                sb.setGiaSan(Float.valueOf(txtGiaSan1.getText()));
                sb.setTrangThaiSan(cboTrangThai1.getSelectedItem() + "");
                try {
                    dao.update(sb);
                    MsgBox.alert(this, "S???a s??n b??ng th??nh c??ng");
                    moi();
                    loadData();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    }
            }
        }
    }

    void xoa() {
        try {
            SanBong sb = dao.selectById(txtMaSan1.getText());
            if (sb != null) {
                dao.delete(sb.getMaSan());
                MsgBox.alert(this, "X??a s??n b??ng th??nh c??ng");
                moi();
                loadData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void timkiem() {
        String masan = txtTimKiem.getText();
        SanBong sb = dao.selectById(masan);
        if (sb == null) {
            loadData();
            MsgBox.alert(this, "Kh??ng t??m th???y s??n b??ng");
            return;
        } else {
            MsgBox.alert(this, "???? t??m th???y s??n");
            mol.setRowCount(0);
            mol.addRow(new Object[]{sb.getMaSan(), sb.getLoaiSan(), sb.getTrangThaiSan(), sb.getGiaSan()});
        }
    }

    void click(java.awt.event.MouseEvent evt) {
        DecimalFormat dcf= new DecimalFormat("###");
        if (evt.getClickCount() == 2) {
            this.index = tblSanBong.rowAtPoint(evt.getPoint());
            tblSanBong.setRowSelectionInterval(this.index, this.index);
            String masan = String.valueOf(tblSanBong.getValueAt(this.index, 0));
            this.maSan= masan;
            SanBong sb = dao.selectById(masan);
            txtMaSan1.setText(sb.getMaSan());
            if (sb.getLoaiSan().equals("s??n 7")) {
                rdo3.setSelected(true);
            } else {
                rdo4.setSelected(true);
            }
            txtGiaSan1.setText(dcf.format(sb.getGiaSan()));
            cboTrangThai1.setSelectedItem(sb.getTrangThaiSan());
            tabs1.setSelectedIndex(0);
        }
    }

    void index() {
        tblSanBong.setRowSelectionInterval(this.index, this.index);
        String masan = String.valueOf(tblSanBong.getValueAt(this.index, 0));
        SanBong sb = dao.selectById(masan);
        txtMaSan1.setText(sb.getMaSan());
        if (sb.getLoaiSan().equals("s??n 7")) {
            rdo3.setSelected(true);
        } else {
            rdo4.setSelected(true);
        }
        txtGiaSan1.setText(sb.getGiaSan() + "");
        cboTrangThai1.setSelectedItem(sb.getTrangThaiSan());
        tabs1.setSelectedIndex(0);
    }

    void status() {
        if (this.index == -1) {
            btnThem1.setEnabled(true);
            btnSua1.setEnabled(false);
            btnXoa1.setEnabled(false);
            btnMoi1.setEnabled(false);
            btnFirst1.setEnabled(false);
            btnPrev1.setEnabled(false);
            btnNext1.setEnabled(false);
            btnLast1.setEnabled(false);
            btnXemhoadon.setEnabled(false);
        } else if (this.index == 0) {
            btnThem1.setEnabled(false);
            btnSua1.setEnabled(true);
            btnXoa1.setEnabled(true);
            btnMoi1.setEnabled(true);
            btnFirst1.setEnabled(false);
            btnPrev1.setEnabled(false);
            btnNext1.setEnabled(true);
            btnLast1.setEnabled(true);
            btnXemhoadon.setEnabled(true);
        } else if (this.index > 0 && this.index < tblSanBong.getRowCount() - 1) {
            btnThem1.setEnabled(false);
            btnSua1.setEnabled(true);
            btnXoa1.setEnabled(true);
            btnMoi1.setEnabled(true);
            btnFirst1.setEnabled(true);
            btnPrev1.setEnabled(true);
            btnNext1.setEnabled(true);
            btnLast1.setEnabled(true);
            btnXemhoadon.setEnabled(true);
        } else if (this.index == tblSanBong.getRowCount() - 1) {
            btnThem1.setEnabled(false);
            btnSua1.setEnabled(true);
            btnXoa1.setEnabled(true);
            btnMoi1.setEnabled(true);
            btnFirst1.setEnabled(true);
            btnPrev1.setEnabled(true);
            btnNext1.setEnabled(false);
            btnLast1.setEnabled(false);
            btnXemhoadon.setEnabled(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst1;
    private javax.swing.JButton btnLast1;
    private javax.swing.JButton btnMoi1;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnPrev1;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXemhoadon;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JComboBox<String> cboTrangThai1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdo3;
    private javax.swing.JRadioButton rdo4;
    private javax.swing.JTabbedPane tabs1;
    private javax.swing.JTable tblSanBong;
    private javax.swing.JTextField txtGiaSan1;
    private javax.swing.JTextField txtMaSan1;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
