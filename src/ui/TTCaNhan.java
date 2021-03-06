
package ui;

import Entity.NhanVien;
import Entity.ThongTinKH;
import Entity.ThongTinNV;
import dao.ThongTinKHDao;
import dao.ThongTinNVDao;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.table.DefaultTableModel;
import utils.Auth;
import utils.MsgBox;
import utils.XImage;

/**
 *
 * @author ASUS
 */
public class TTCaNhan extends javax.swing.JDialog {
    ThongTinNVDao dao1= new ThongTinNVDao();
    ThongTinKHDao dao2= new ThongTinKHDao();
    DefaultTableModel mol;
    int index=-1;
    int x;

    /**
     * Creates new form TT_CaNhan
     */
    public TTCaNhan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    private void init(){
        this.setLocationRelativeTo(null);
        this.setIconImage(XImage.getAppIcon());
        txtHoTen.setEnabled(false);
        txtMaNguoiDung.setEnabled(false);
        load();
        
    }

    private void load() {
        mol= (DefaultTableModel)tblDanhsach.getModel();
        mol.setRowCount(0);
        if(Auth.user1!=null){
            txtMaNguoiDung.setText(Auth.user1.getMaNV());
            txtHoTen.setText(Auth.user1.getHoTen());
            List<ThongTinNV> list= dao1.selectEmail(Auth.user1.getMaNV());
            for (ThongTinNV ttnv : list) {
                mol.addRow(new Object[]{ttnv.getMaThongTin(),Auth.user1.getHoTen(),ttnv.getMaNV(),ttnv.getSoDienThoai(),ttnv.getEmail()});
            }
        }
        if(Auth.user2!=null){
            txtMaNguoiDung.setText(Auth.user2.getMaKH());
            txtHoTen.setText(Auth.user2.getHoTen());
            List<ThongTinKH> list= dao2.selectEmail(Auth.user2.getMaKH());
            for (ThongTinKH ttkh : list) {
                mol.addRow(new Object[]{ttkh.getMaThongTin(),Auth.user2.getHoTen(),ttkh.getMaKH(),ttkh.getSoDienThoai(),ttkh.getEmail()});
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        btnLayMa = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMaNguoiDung = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        txtNhapMa = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhsach = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Th??ng tin c?? nh??n");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("H??? T??n:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Email:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("S??? ??i???n tho???i:");

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtSoDienThoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnLayMa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-next-page-24.png"))); // NOI18N
        btnLayMa.setText("L???y m?? x??c nh???n");
        btnLayMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLayMaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Nh???p m?? x??c nh???n:");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-tag-24.png"))); // NOI18N
        btnThem.setText("Th??m");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-24_1.png"))); // NOI18N
        btnDong.setText("????ng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("M?? Ng?????i D??ng:");

        txtMaNguoiDung.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-pencil-24.png"))); // NOI18N
        btnSua.setText("S???a");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-24_2.png"))); // NOI18N
        btnMoi.setText("M???i");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        txtNhapMa.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        txtNhapMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhapMaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(404, 404, 404))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMaNguoiDung)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNhapMa, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLayMa, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLayMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMoi)
                            .addComponent(btnDong))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNhapMa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tabs.addTab("C???p nh???t", new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-pencil-24.png")), jPanel2); // NOI18N

        tblDanhsach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "M?? Th??ng Tin", "H??? T??n", "M?? Ng?????i D??ng", "S??? ??i???n Tho???i", "Email"
            }
        ));
        tblDanhsach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhsachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhsach);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        tabs.addTab("Danh s??ch", new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-list-24.png")), jPanel3); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        them();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        String p_sdt= "0[0-9]{9}";
        String p_email= "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(txtSoDienThoai.getText().equals("")){
            MsgBox.alert(this, "S??? ??i???n tho???i tr???ng");
            return;
        }else if(txtSoDienThoai.getText().matches(p_sdt)==false){
            MsgBox.alert(this, "S??? ??i???n tho???i kh??ng ????ng ?????nh d???ng");
            return;
        }else if(txtEmail.getText().equals("")){
            MsgBox.alert(this, "Email tr???ng");
            return;
        }else if(txtEmail.getText().matches(p_email)==false){
            MsgBox.alert(this, "Email kh??ng ????ng ?????nh d???ng");
            return;
        }else{
        sua();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        moi();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void txtNhapMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhapMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhapMaActionPerformed

    private void tblDanhsachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhsachMouseClicked
        // TODO add your handling code here:
        click(evt);
    }//GEN-LAST:event_tblDanhsachMouseClicked

    private void btnLayMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLayMaActionPerformed
        // TODO add your handling code here:
        String p_email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (txtEmail.getText().equals("")) {
            MsgBox.alert(this, "Email tr???ng");
            return;
        } else if (txtEmail.getText().matches(p_email) == false) {
            MsgBox.alert(this, "Email kh??ng ????ng ?????nh d???ng");
            return;
        } else {
            layMa();
        }
    }//GEN-LAST:event_btnLayMaActionPerformed

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
            java.util.logging.Logger.getLogger(TTCaNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TTCaNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TTCaNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TTCaNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TTCaNhan dialog = new TTCaNhan(new javax.swing.JFrame(), true);
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
    
    void sua(){
        if(Auth.user1!=null){
        String idtt= String.valueOf(tblDanhsach.getValueAt(this.index, 0));
        ThongTinNV ttnvmoi= new ThongTinNV();
        ttnvmoi.setMaThongTin(Integer.valueOf(idtt));
        ttnvmoi.setEmail(txtEmail.getText());
        ttnvmoi.setSoDienThoai(txtSoDienThoai.getText());
        ttnvmoi.setMaNV(txtMaNguoiDung.getText());
        if(txtNhapMa.getText().trim().equals(String.valueOf(this.x))){
        dao1.update(ttnvmoi);
        MsgBox.alert(this, "S???a th??nh c??ng");
        load();
        moi();
        }else{
            MsgBox.alert(this, "M?? x??c nh???n kh??ng ch??nh x??c.");
        }
        }
        if(Auth.user2!=null){
        String idtt= String.valueOf(tblDanhsach.getValueAt(this.index, 0));
        ThongTinKH ttkhmoi= new ThongTinKH();
        ttkhmoi.setMaThongTin(Integer.valueOf(idtt));
        ttkhmoi.setEmail(txtEmail.getText());
        ttkhmoi.setSoDienThoai(txtSoDienThoai.getText());
        ttkhmoi.setMaKH(txtMaNguoiDung.getText());
        if(txtNhapMa.getText().trim().equals(String.valueOf(this.x))){
        dao2.update(ttkhmoi);
        MsgBox.alert(this, "S???a th??nh c??ng");
        load();
        moi();
        }else{
            MsgBox.alert(this, "M?? x??c nh???n kh??ng ch??nh x??c.");
        }
        }
    }
    
    void them(){
        String p_sdt= "0[0-9]{9}";
        String p_email= "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(txtSoDienThoai.getText().equals("")){
            MsgBox.alert(this, "S??? ??i???n tho???i tr???ng");
            return;
        }else if(txtSoDienThoai.getText().matches(p_sdt)==false){
            MsgBox.alert(this, "S??? ??i???n tho???i kh??ng ????ng ?????nh d???ng");
            return;
        }else if(txtEmail.getText().equals("")){
            MsgBox.alert(this, "Email tr???ng");
            return;
        }else if(txtEmail.getText().matches(p_email)==false){
            MsgBox.alert(this, "Email kh??ng ????ng ?????nh d???ng");
            return;
        }else{
            if (Auth.user1 != null) {
                if (txtNhapMa.getText().trim().equals(String.valueOf(this.x))) {
                    ThongTinNV ttnvmoi = new ThongTinNV();
                    ttnvmoi.setEmail(txtEmail.getText());
                    ttnvmoi.setSoDienThoai(txtSoDienThoai.getText());
                    ttnvmoi.setMaNV(txtMaNguoiDung.getText());
                    dao1.insert(ttnvmoi);
                    MsgBox.alert(this, "Th??m th??nh c??ng");
                    load();
                    moi();
                } else {
                    MsgBox.alert(this, "M?? x??c nh???n kh??ng ch??nh x??c");
                }
            }
            if (Auth.user2 != null) {
                if (txtNhapMa.getText().trim().equals(String.valueOf(this.x))) {
                    ThongTinKH ttkhmoi = new ThongTinKH();
                    ttkhmoi.setEmail(txtEmail.getText());
                    ttkhmoi.setSoDienThoai(txtSoDienThoai.getText());
                    ttkhmoi.setMaKH(txtMaNguoiDung.getText());
                    dao2.insert(ttkhmoi);
                    MsgBox.alert(this, "Th??m th??nh c??ng");
                    load();
                    moi();
                } else {
                    MsgBox.alert(this, "M?? x??c nh???n kh??ng ch??nh x??c");
                }
            }
        }
    }
    
    void moi(){
        txtEmail.setText("");
        txtSoDienThoai.setText("");
        txtNhapMa.setText("");
    }
    
    void layMa(){
        if(Auth.user1!=null){
        List<ThongTinNV> list= dao1.selectAll();
        for (ThongTinNV ttnv : list) {
            if(txtEmail.getText().equals(ttnv.getEmail())){
                MsgBox.alert(this, "Email n??y c???a b???n ???? th??m tr?????c ????!");
                return;
            }
        }
        }
        if(Auth.user2!=null){
        List<ThongTinKH> list= dao2.selectAll();
        for (ThongTinKH ttkh : list) {
            if(txtEmail.getText().equals(ttkh.getEmail())){
                MsgBox.alert(this, "Email n??y c???a b???n ???? th??m tr?????c ????!");
                return;
            }
        }
        }
        Random rd= new Random();
        this.x= rd.nextInt(999999)+100000;
        try {
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", "587");

            String accountName = "bangnvph17685@fpt.edu.vn";
            String accountPassword = "Vanbang2002";
            Session s;
            s = Session.getInstance(p, new Authenticator() {
                @Override
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(accountName, accountPassword);
                }

            });

            Message msg = new MimeMessage(s);
            msg.setFrom(new InternetAddress(accountName));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(txtEmail.getText()));
            msg.setSubject("X??c nh???n email");
            msg.setText("M?? x??c nh???n c???a b???n l??: " + this.x + "\n H??y b???o m???t th??ng tin n??y !");

            Transport.send(msg);
            MsgBox.alert(this, "M?? x??c nh???n ???? ???????c g???i t???i email: " + txtEmail.getText());
        } catch (MessagingException ex) {
            ex.printStackTrace();
            MsgBox.alert(this, "G???i th???t b???i, b??? gi??n ??o???n");
        }
    }
    
    void click(java.awt.event.MouseEvent evt){
        if(evt.getClickCount()==2){
            this.index= tblDanhsach.rowAtPoint(evt.getPoint());
            String idtt= String.valueOf(tblDanhsach.getValueAt(this.index, 0));
            if(Auth.user1!=null){
                ThongTinNV ttnv= dao1.selectById(idtt);
                tabs.setSelectedIndex(0);
                txtHoTen.setText(Auth.user1.getHoTen());
                txtMaNguoiDung.setText(ttnv.getMaNV());
                txtSoDienThoai.setText(ttnv.getSoDienThoai());
                txtEmail.setText(ttnv.getEmail());
            }
            if(Auth.user2!=null){
                ThongTinKH ttkh= dao2.selectById(idtt);
                tabs.setSelectedIndex(0);
                txtHoTen.setText(Auth.user2.getHoTen());
                txtMaNguoiDung.setText(ttkh.getMaKH());
                txtSoDienThoai.setText(ttkh.getSoDienThoai());
                txtEmail.setText(ttkh.getEmail());
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnLayMa;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblDanhsach;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNguoiDung;
    private javax.swing.JTextField txtNhapMa;
    private javax.swing.JTextField txtSoDienThoai;
    // End of variables declaration//GEN-END:variables
}
