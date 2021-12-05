/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import Entity.HoaDon;
import dao.HoaDonDao;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import utils.MsgBox;
import utils.XImage;

/**
 *
 * @author ASUS
 */
public class DatCoc extends javax.swing.JInternalFrame {

    /**
     * Creates new form DatCoc
     */
    public DatCoc() {
        initComponents();
        init();
    }

    JFileChooser fileChooser = new JFileChooser();

    void init() {
        this.setFrameIcon(new ImageIcon(XImage.getAppIcon()));
    }

    void chonAnh() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            XImage.save(file);
            ImageIcon icon = new ImageIcon(XImage.read(file.getName()).getImage().getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), 5));
            lblHinh.setIcon(icon);
            lblHinh.setToolTipText(file.getName());
        }
    }

    HoaDonDao dao = new HoaDonDao();

    void timKiem() {
        String email = txtEmail.getText();
        String p_email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        List<HoaDon> list = dao.selectByEmail(email);
        if (txtEmail.getText().equals("")) {
            MsgBox.alert(this, "Email trống");
            return;
        } else if (txtEmail.getText().matches(p_email) == false) {
            MsgBox.alert(this, "Email không đúng định dạng");
            return;
        } else if(list.size() > 0){
            DefaultTableModel mol = (DefaultTableModel) tblHoaDon.getModel();
            mol.setRowCount(0);
            for (HoaDon x : list) {
                mol.addRow(new Object[]{x.getMaHD(), x.getHoTenKH(), x.getEmail(), x.getSoDienThoai(), x.getTongTien()});
            }
        }else{
            MsgBox.alert(this, "Email không tồn tại.");
        }
    }

    
    void xoaForm() {
        lblHinh.getToolTipText();
    }

    void xacNhan(){
        String mahd = (String) tblHoaDon.getValueAt(index, 0);
        HoaDon hd = dao.selectById(mahd);
        hd.setAnhDatCoc(lblHinh.getToolTipText());
        dao.update(hd);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHinh = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnDatCoc = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnXemHoaDon = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btn = new javax.swing.JButton();

        setClosable(true);
        setTitle("Đặt cọc");

        lblHinh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Chọn ảnh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnDatCoc.setText("Đặt cọc");
        btnDatCoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatCocActionPerformed(evt);
            }
        });

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnXemHoaDon.setText("Nhập email:");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Họ tên", "Email", "Số điện thoại", "Tổng tiền"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        btn.setText("Xem hóa đơn");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jButton1)
                .addGap(304, 304, 304)
                .addComponent(btnDatCoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMoi)
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnXemHoaDon, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnXemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMoi)
                        .addComponent(btnDatCoc)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        chonAnh();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDatCocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatCocActionPerformed
        // TODO add your handling code here:
        if (index == -1) {
            MsgBox.alert(this, "Vui lòng chọn hóa đơn để đặt cọc.");
        } else if (lblHinh.getToolTipText() == null) {
            MsgBox.alert(this, "Vui lòng chọn ảnh đặt cọc.");
        } else {
            xacNhan();
            MsgBox.alert(this, "Đặt cọc thành công. Chờ xử lý.");
        }
    }//GEN-LAST:event_btnDatCocActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        xoaForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        // TODO add your handling code here:r
        timKiem();
    }//GEN-LAST:event_btnActionPerformed

    int index = -1;
    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:      
       index = tblHoaDon.getSelectedRow();
        String mahd = (String) tblHoaDon.getValueAt(index, 0);
        HoaDon hd = dao.selectById(mahd);
        if (hd.getAnhDatCoc() == null) {
            float x1 = Float.parseFloat(tblHoaDon.getValueAt(index, 4) + "");
            float tiencoc = Float.parseFloat(String.valueOf(x1 * 40 / 100));
            MsgBox.alert(this, "Số tiền quý khách cần đặt cọc là:" + " " + tiencoc);
            lblHinh.setIcon(new ImageIcon(hd.getAnhDatCoc()));
        }else{
            lblHinh.setIcon(XImage.read(hd.getAnhDatCoc()));
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JButton btnDatCoc;
    private javax.swing.JButton btnMoi;
    private javax.swing.JLabel btnXemHoaDon;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
