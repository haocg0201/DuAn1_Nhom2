/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Entity.KhachHang;
import Entity.NhanVien;
import utils.Auth;
import dao.KhachHangDao;
import dao.NhanVienDao;
import java.awt.Color;
import utils.MsgBox;
import utils.XImage;

/**
 *
 * @author haoca
 */
public class DoiMatKhauJDialog extends javax.swing.JDialog {

    KhachHangDao khDAO = new KhachHangDao();
    NhanVienDao nvDAO = new NhanVienDao();
    boolean check = false;

    /**
     * Creates new form DoiMatKhauJDialog
     */
    public DoiMatKhauJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    void init() {
        //setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
        setTitle("Hệ thống Đổi mật khẩu");
        try {
            if (Auth.user1 != null) {
                txtTK.setText(Auth.user1.getMaNV());
            } else {
                txtTK.setText(Auth.user2.getMaKH());
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Chưa login, chưa có thông tin !");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    KhachHang getFormKH() {
        KhachHang kh = new KhachHang();
        kh.setMaKH(Auth.user2.getMaKH());
        kh.setMaNV("NV01");
        kh.setHoTen(Auth.user2.getHoTen());
        kh.setMatKhau(String.valueOf(txtXNMK.getPassword()));
        kh.setNgayDK(Auth.user2.getNgayDK());
        return kh;
    }

    NhanVien getFormNV() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(Auth.user1.getMaNV());
        nv.setMatKhau(new String(txtXNMK.getPassword()));
        nv.setVaiTro(Auth.user1.getVaiTro());
        nv.setHoTen(Auth.user1.getHoTen());
        nv.setDiaChi(Auth.user1.getDiaChi());
        nv.setTrangThai(Auth.user1.getTrangThai());
        return nv;
    }

    void doiMatKhau() {

        //Nhân viên
        if (Auth.user1 != null) {
            NhanVien model = getFormNV();
            try {
                nvDAO.update(model);
                System.out.println("--> " + (Object) model);
                MsgBox.alert(this, "Đổi mật khẩu thành công !");
            } catch (Exception e) {
                MsgBox.alert(this, "Đổi mật khẩu thất bại !");
                e.printStackTrace();
            }
        } else {
            //khách hàng
            KhachHang model = getFormKH();
            try {
                khDAO.update(model);
                System.out.println("--> " + (Object) model);
                MsgBox.alert(this, "Đổi mật khẩu thành công !");
            } catch (Exception e) {
                MsgBox.alert(this, "Đổi mật khẩu thất bại !");
                e.printStackTrace();
            }
        }
    }

    String passNV(String id) {
        String pass = null;
        NhanVien nv = new NhanVien();
        nv = nvDAO.selectById(id);
        pass = nv.getMatKhau();
        return pass;
    }

    String passKH(String id) {
        String pass = null;
        KhachHang kh = new KhachHang();
        kh = khDAO.selectById(id);
        pass = kh.getMatKhau();
        return pass;
    }

    void kiemTra() {
        if (txtMK.getText().length() == 0) {
            txtMK.requestFocus();
            txtMK.setBackground(Color.YELLOW);
            MsgBox.alert(this, "Chưa nhập mật khẩu");
            check = false;
            return;
        } else {
            txtMK.setBackground(Color.white);
            check = true;
        }

        if (Auth.user1 != null) {
            if (!String.valueOf(txtMK.getPassword()).equals(passNV(txtTK.getText()))) {
                txtMK.requestFocus();
                txtMK.setBackground(Color.YELLOW);
                MsgBox.alert(this, "Nhập sai mật khẩu vui lòng nhập lại !");
                check = false;
                return;
            } else {
                txtMK.setBackground(Color.white);
                check = true;
            }
        } else if (Auth.user1 == null) {
            if (!String.valueOf(txtMK.getPassword()).equals(passKH(txtTK.getText()))) {
                txtMK.requestFocus();
                txtMK.setBackground(Color.YELLOW);
                MsgBox.alert(this, "Nhập sai mật khẩu vui lòng nhập lại !");
                check = false;
                return;
            }
        } else {
            txtMK.setBackground(Color.white);
            check = true;
        }

        if (txtMKM.getText().length() == 0) {
            txtMKM.requestFocus();
            txtMKM.setBackground(Color.YELLOW);
            MsgBox.alert(this, "Chưa nhập mật khẩu mới");
            check = false;
            return;
        }else if (txtMKM.getText().equals(" ")) {
            txtMKM.requestFocus();
            txtMKM.setBackground(Color.YELLOW);
            MsgBox.alert(this, "Mật khẩu mới không chứa <space>");
            check = false;
            return;
        } else {
            txtMKM.setBackground(Color.white);
            check = true;
        }

        if (txtXNMK.getText().length() == 0) {
            txtXNMK.requestFocus();
            txtXNMK.setBackground(Color.YELLOW);
            MsgBox.alert(this, "Chưa nhập xác nhận mật khẩu mới");
            check = false;
            return;
        }else if (txtXNMK.getText().equals(" ")) {
            txtXNMK.requestFocus();
            txtXNMK.setBackground(Color.YELLOW);
            MsgBox.alert(this, "Xác nhận mật khẩu mới không chứa <space>");
            check = false;
            return;
        } else {
            txtXNMK.setBackground(Color.white);
            check = true;
        }

        if (!String.valueOf(txtMKM.getPassword()).equals(String.valueOf(txtXNMK.getPassword()))) {
            txtXNMK.setBackground(Color.YELLOW);
            txtMKM.setBackground(Color.YELLOW);
            MsgBox.alert(this, "Mật khẩu mới và mật khẩu xác nhận không khớp");
            check = false;
            return;
        } else {
            txtXNMK.setBackground(Color.white);
            txtMKM.setBackground(Color.white);
            check = true;
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnXacNhan = new javax.swing.JButton();
        btnHuyBo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTK = new javax.swing.JTextField();
        txtMK = new javax.swing.JPasswordField();
        txtMKM = new javax.swing.JPasswordField();
        txtXNMK = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Đổi mật khẩu");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên tài khoản :");

        btnXacNhan.setBackground(new java.awt.Color(153, 153, 153));
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        btnHuyBo.setBackground(new java.awt.Color(153, 153, 153));
        btnHuyBo.setText("Hủy bỏ");
        btnHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBoActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mật khẩu :");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mật khẩu mới :");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Xác nhận mật khẩu mới :");

        txtTK.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnXacNhan)
                                    .addGap(32, 32, 32)
                                    .addComponent(btnHuyBo))
                                .addComponent(txtMK)
                                .addComponent(txtMKM)
                                .addComponent(txtXNMK, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtXNMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan)
                    .addComponent(btnHuyBo))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBoActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnHuyBoActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:
        kiemTra();
        if (check == true) {
            doiMatKhau();
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

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
            java.util.logging.Logger.getLogger(DoiMatKhauJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DoiMatKhauJDialog dialog = new DoiMatKhauJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtMK;
    private javax.swing.JPasswordField txtMKM;
    private javax.swing.JTextField txtTK;
    private javax.swing.JPasswordField txtXNMK;
    // End of variables declaration//GEN-END:variables
}
