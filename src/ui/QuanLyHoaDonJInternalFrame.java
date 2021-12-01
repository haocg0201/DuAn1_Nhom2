/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Entity.HoaDon;
import dao.HoaDonDao;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import utils.Auth;
import utils.MsgBox;
import utils.XDate;
import utils.XImage;

/**
 *
 * @author haoca
 */
public class QuanLyHoaDonJInternalFrame extends javax.swing.JInternalFrame {
    HoaDonDao hdDAO = new HoaDonDao();
    int row = -1;
    boolean check = false;
    
    /**
     * Creates new form QuanLyHoaDonJInternalFrame
     */
    public QuanLyHoaDonJInternalFrame() {
        initComponents();
        init();
    }
    
    void init() {
        this.setFrameIcon(new ImageIcon(XImage.getAppIcon()));
        setTitle("HỆ THỐNG QUẢN LÝ HÓA ĐƠN");
        this.fillTableDanhSach();
    }

    void fillTableDanhSach() {
        DefaultTableModel model = (DefaultTableModel) tblDanhSach.getModel();
        model.setRowCount(0);
        String ten = txtTimKiem.getText().trim();
        List<HoaDon> lst;
        try {
            if (ten.length() != 0) {
                lst = (List<HoaDon>) hdDAO.selectByIdNew(ten);
            } else {
                lst = hdDAO.selectAll();
            }
            for (HoaDon x : lst) {
                model.addRow(new Object[]{
                    x.getMaHD(),
                    x.getHoTenKH(),
                    x.getSoDienThoai(),
                    x.getEmail(),
                    x.getGiamGia(),
                    x.getTongTien(),
                    x.getNgayThanhToan(),
                    x.getTrangThaiHD(),
                    x.getTrangThaiTT()});
                System.out.println(x.toString() + "\n");
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
            MsgBox.alert(this, "Không có thông tin");
        }
    }
    
//    String getMaKH(String IDHD) {
//        String maKH = null;
//        try {
//            List<HoaDon> lst;
//            lst =  (List<HoaDon>) hdDAO.selectById(IDHD);
//            maKH = lst.get(0).getMaKH();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(maKH);
//        return maKH; 
//    }

    void capNhat() {
        HoaDon model = getForm();
        try {
            hdDAO.update(model);
            this.fillTableDanhSach();
            System.out.println("->" + (Object) model);
            MsgBox.alert(this, "Cập nhật thành công");
            fillTableDanhSach();
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bạn ( lỗi : " + e + ")");
            e.printStackTrace();
        }
    }
    
    String maKH(String id){
        String maKH = null;
        HoaDon hd = new HoaDon();
        hd = hdDAO.selectById(id);
        maKH = hd.getMaKH();
        return maKH;
    }

    HoaDon getForm() {
        this.row = 0;
        HoaDon hd = new HoaDon();
        hd.setMaHD(txtMaHoaDon.getText());
        hd.setHoTenKH(txtTenKH.getText());
        hd.setSoDienThoai(txtSDT.getText().trim());
        hd.setEmail(txtEmail.getText());
        if (rdo0.isSelected()) {
            hd.setGiamGia(0);
        } else if (rdo5.isSelected()) {
            hd.setGiamGia(5);
        } else if (rdo15.isSelected()) {
            hd.setGiamGia(15);
        } else {
            hd.setGiamGia(20);
        }
        hd.setTongTien(Float.parseFloat(txtTongTien.getText()));
        if(maKH(txtMaHoaDon.getText()) == null){
            hd.setMaKH("KHbot");
        }else{
            hd.setMaKH(maKH(txtMaHoaDon.getText()));
        }        
        hd.setMaNV(Auth.user1.getMaNV());
        hd.setAnhDatCoc(lblAnh.getText());
        if (rdoCho.isSelected()) {
            hd.setTrangThaiHD(1);
        } else if (rdoDa.isSelected()) {
            hd.setTrangThaiHD(2);
        } else {
            hd.setTrangThaiHD(3);
        }
        if (rdoChoThanhToan.isSelected()) {
            hd.setTrangThaiTT(1);
        } else {
            hd.setTrangThaiTT(2);
        }
        hd.setNgayThanhToan(XDate.now());
        return hd;
    }

    void setForm(HoaDon hd) {
        try {
            txtMaHoaDon.setText(hd.getMaHD());
            txtTenKH.setText(hd.getHoTenKH());
            txtSDT.setText(hd.getSoDienThoai().trim());
            txtEmail.setText(hd.getEmail());
            txtTongTien.setText(hd.getTongTien() + "");
            if (hd.getGiamGia() == 0) {
                rdo0.setSelected(true);
            } else if (hd.getGiamGia() == 5) {
                rdo5.setSelected(true);
            } else if (hd.getGiamGia() == 15) {
                rdo15.setSelected(true);
            } else {
                rdo20.setSelected(true);
            }
            if (hd.getTrangThaiHD() == 1) {
                rdoCho.setSelected(true);
            } else if (hd.getTrangThaiHD() == 2) {
                rdoDa.setSelected(true);
            } else {
                rdoHuy.setSelected(true);
            }
            if (hd.getTrangThaiTT() == 1) {
                rdoChoThanhToan.setSelected(true);
            } else {
                rdoDaThanhToan.setSelected(true);
            }
            lblAnh.setIcon(XImage.read(hd.getAnhDatCoc()));
            lblAnh.setText(hd.getAnhDatCoc());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void clearForm() {
        txtMaHoaDon.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        txtTenKH.setText("");
        txtTongTien.setText("");
        rdo0.setSelected(true);
        rdoCho.setSelected(true);
        rdoChoThanhToan.setSelected(true);
        this.updateStatus();
        row = -1;
        updateStatus();
    }

    void edit() {
        try {
            String maHD = (String) tblDanhSach.getValueAt(this.row, 0);
            HoaDon nh = hdDAO.selectById(maHD);
            if (nh != null) {
                setForm(nh);
                updateStatus();
                tabs.setSelectedIndex(1);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn CSDL !" + e);
            e.printStackTrace();
        }
    }

    void dau() {
        row = 0;
        edit();
    }

    void cuoi() {
        row = tblDanhSach.getRowCount() - 1;
        edit();
    }

    void lui() {
        if (row > 0) {
            row--;
            edit();
        }
    }

    void tien() {
        if (row < tblDanhSach.getRowCount() - 1) {
            row++;
            edit();
        }
    }

    void updateStatus() {
        boolean edit = this.row >= 0;
        boolean dau = this.row == 0;
        boolean cuoi = this.row == tblDanhSach.getRowCount() - 1;

        // khi insert thi except to update and delate
        //btnCapNhat.setEnabled(!edit);
        btnDau.setEnabled(edit && !dau);
        btnLui.setEnabled(edit && !dau);
        btnTien.setEnabled(edit && !cuoi);
        btnCuoi.setEnabled(edit && !cuoi);
    }

    void check() {
        String email_regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String sdt_regex = "[0-9]+";
        if (txtMaHoaDon.getText().length() == 0) {
            txtMaHoaDon.requestFocus();
            txtMaHoaDon.setBackground(Color.YELLOW);
            MsgBox.alert(this, "Không để trống mã hóa đơn");
            check = false;
            return;
        } else if (txtMaHoaDon.getText().length() > 20) {
            txtMaHoaDon.requestFocus();
            txtMaHoaDon.setBackground(Color.YELLOW);
            MsgBox.alert(this, "mã hóa đơn cho phép tối đa 20 ký tự");
            check = false;
            return;
        } else {
            txtMaHoaDon.setBackground(Color.white);
            check = true;
        }

        if (txtTenKH.getText().equals("")) {
            txtTenKH.requestFocus();
            txtTenKH.setBackground(Color.YELLOW);
            MsgBox.alert(this, "họ tên đang để trống");
            check = false;
            return;
        } else {
            txtTenKH.setBackground(Color.white);
            check = true;
        }
        
        if (txtSDT.getText().equals("")) {
            txtSDT.requestFocus();
            txtSDT.setBackground(Color.YELLOW);
            MsgBox.alert(this, "Số điện thoại không được để trống ");
            check = false;
            return;
        } else if (!txtSDT.getText().matches(sdt_regex)) {
            txtSDT.requestFocus();
            txtSDT.setBackground(Color.YELLOW);
            MsgBox.alert(this, "Số điện thoại không đúng định dạng( ký tự số )");
            check = false;
            return;
        } else if (txtSDT.getText().length() < 10 || txtSDT.getText().length() > 11) {
            txtSDT.requestFocus();
            txtSDT.setBackground(Color.YELLOW);
            MsgBox.alert(this, "Độ dài số điện thoại cho phép");
            check = false;
            return;
        } else {
            txtSDT.setBackground(Color.white);
            check = true;
        }

        if (txtEmail.getText().length() == 0) {
            txtEmail.requestFocus();
            txtEmail.setBackground(Color.YELLOW);
            MsgBox.alert(this, "Email đang để trống");
            check = false;
            return;
        } else if (!txtEmail.getText().matches(email_regex)) {
            txtEmail.requestFocus();
            txtEmail.setBackground(Color.YELLOW);
            MsgBox.alert(this, "Email bạn vừa nhập không đúng định dạng");
            check = false;
        } else {
            txtEmail.setBackground(Color.white);
            check = true;
        }
        
        if(txtTongTien.getText().length() == 0){
            txtTongTien.requestFocus();
            txtTongTien.setBackground(Color.YELLOW);
            MsgBox.alert(this, "Đang để trống số điện thoại");
            check = false;
            return ;
        }else{
            txtTongTien.setBackground(Color.YELLOW);
            check = true;
        }
        
        try {
            float tien = Float.parseFloat(txtTongTien.getText());  
            System.out.println(tien);
            txtTongTien.setBackground(Color.YELLOW);
            check = true;
        } catch (Exception e) {
            txtTongTien.requestFocus();
            txtTongTien.setBackground(Color.YELLOW);
            MsgBox.alert(this, "Chỉ nhập ký tự số");
            check = false;
            return ;
        }  
             
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        rdo0 = new javax.swing.JRadioButton();
        rdo5 = new javax.swing.JRadioButton();
        rdo15 = new javax.swing.JRadioButton();
        rdo20 = new javax.swing.JRadioButton();
        txtTongTien = new javax.swing.JTextField();
        rdoCho = new javax.swing.JRadioButton();
        rdoDa = new javax.swing.JRadioButton();
        rdoHuy = new javax.swing.JRadioButton();
        rdoChoThanhToan = new javax.swing.JRadioButton();
        rdoDaThanhToan = new javax.swing.JRadioButton();
        btnDau = new javax.swing.JButton();
        btnLui = new javax.swing.JButton();
        btnTien = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        btnMoHoaDonCT = new javax.swing.JButton();

        setClosable(true);

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Tên khách hàng", "Số điện thoại", "Email", "Giảm giá", "Tổng tiền", "Ngày thanh toán", "Trạng thái HĐ", "Trạng thái TT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDanhSachMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSach);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiem)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tabs.addTab("Danh sách hóa đơn", jPanel1);

        lblAnh.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Mã hóa đơn");

        jLabel3.setText("Tên khách hàng");

        jLabel4.setText("Số điện thoại");

        jLabel5.setText("Email");

        jLabel6.setText("Giảm giá");

        jLabel7.setText("Tổng tiền");

        jLabel8.setText("Trạng thái hóa đơn");

        jLabel9.setText("Trạng thái thanh toán");

        txtMaHoaDon.setEditable(false);
        txtMaHoaDon.setBackground(new java.awt.Color(204, 204, 204));

        buttonGroup1.add(rdo0);
        rdo0.setText("0%");

        buttonGroup1.add(rdo5);
        rdo5.setText("5%");

        buttonGroup1.add(rdo15);
        rdo15.setText("15%");

        buttonGroup1.add(rdo20);
        rdo20.setText("20%");

        buttonGroup2.add(rdoCho);
        rdoCho.setText("Chờ xác nhận");

        buttonGroup2.add(rdoDa);
        rdoDa.setText("Đã xác nhận");

        buttonGroup2.add(rdoHuy);
        rdoHuy.setText("Đã hủy");

        buttonGroup3.add(rdoChoThanhToan);
        rdoChoThanhToan.setText("Chờ thanh toán");

        buttonGroup3.add(rdoDaThanhToan);
        rdoDaThanhToan.setText("Đã thanh toán");

        btnDau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-skip-to-start-24.png"))); // NOI18N
        btnDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauActionPerformed(evt);
            }
        });

        btnLui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-rewind_1.png"))); // NOI18N
        btnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiActionPerformed(evt);
            }
        });

        btnTien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-rewind-2.png"))); // NOI18N
        btnTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTienActionPerformed(evt);
            }
        });

        btnCuoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-skip-to-start.png"))); // NOI18N
        btnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiActionPerformed(evt);
            }
        });

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-pencil-24.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-24_1.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit_2.png"))); // NOI18N
        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        btnMoHoaDonCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-next-page-24.png"))); // NOI18N
        btnMoHoaDonCT.setText("Mở hóa đơn chi tiết");
        btnMoHoaDonCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoHoaDonCTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaHoaDon))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenKH))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSDT))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail)
                            .addComponent(txtTongTien)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(rdo0)
                                .addGap(18, 18, 18)
                                .addComponent(rdo5)
                                .addGap(18, 18, 18)
                                .addComponent(rdo15)
                                .addGap(18, 18, 18)
                                .addComponent(rdo20)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoCho)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdoHuy))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDau)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCapNhat)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 36, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnMoHoaDonCT, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnMoi)
                                            .addComponent(btnLui))
                                        .addGap(101, 101, 101)
                                        .addComponent(btnTien)
                                        .addGap(66, 66, 66)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(btnCuoi)
                                        .addGap(12, 12, 12))
                                    .addComponent(btnDong, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoChoThanhToan)
                                .addGap(88, 88, 88)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdoDaThanhToan)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdoDa)
                                        .addGap(95, 95, 95)))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdo0)
                    .addComponent(rdo5)
                    .addComponent(rdo15)
                    .addComponent(rdo20))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rdoCho)
                    .addComponent(rdoDa)
                    .addComponent(rdoHuy))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rdoChoThanhToan)
                    .addComponent(rdoDaThanhToan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTien)
                            .addComponent(btnCuoi)
                            .addComponent(btnLui, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCapNhat)
                                .addComponent(btnMoi))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnDong)
                                .addComponent(btnMoHoaDonCT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnDau))
                .addGap(0, 7, Short.MAX_VALUE))
            .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabs.addTab("Cập nhật", jPanel2);

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

    private void btnDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauActionPerformed
        // TODO add your handling code here:
        dau();
    }//GEN-LAST:event_btnDauActionPerformed

    private void btnLuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuiActionPerformed
        // TODO add your handling code here:
        lui();
    }//GEN-LAST:event_btnLuiActionPerformed

    private void btnTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTienActionPerformed
        // TODO add your handling code here:
        tien();
    }//GEN-LAST:event_btnTienActionPerformed

    private void btnCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiActionPerformed
        // TODO add your handling code here:
        cuoi();
    }//GEN-LAST:event_btnCuoiActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        check();
        if(check == true){
            capNhat();
            fillTableDanhSach();
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        fillTableDanhSach();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblDanhSachMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.row = tblDanhSach.rowAtPoint(evt.getPoint());
            edit();
        }
    }//GEN-LAST:event_tblDanhSachMousePressed

    private void btnMoHoaDonCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoHoaDonCTActionPerformed
        // TODO add your handling code here:
        QLHoaDonChiTiet ql = new QLHoaDonChiTiet();
        ql.setVisible(true);
        this.getDesktopPane().add(ql);
        this.dispose();
    }//GEN-LAST:event_btnMoHoaDonCTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDau;
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnLui;
    private javax.swing.JButton btnMoHoaDonCT;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnTien;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
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
    private javax.swing.JLabel lblAnh;
    private javax.swing.JRadioButton rdo0;
    private javax.swing.JRadioButton rdo15;
    private javax.swing.JRadioButton rdo20;
    private javax.swing.JRadioButton rdo5;
    private javax.swing.JRadioButton rdoCho;
    private javax.swing.JRadioButton rdoChoThanhToan;
    private javax.swing.JRadioButton rdoDa;
    private javax.swing.JRadioButton rdoDaThanhToan;
    private javax.swing.JRadioButton rdoHuy;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
