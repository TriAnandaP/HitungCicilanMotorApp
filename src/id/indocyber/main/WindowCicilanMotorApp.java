/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.indocyber.main;

import com.sun.glass.events.KeyEvent;
import entity.AnalisaKreditNasabah;
import entity.Nasabah;
import javafx.scene.text.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

//saya menambah comment

/**
 * Aplikasi pengecekan untuk permohonan kredit motor di PT Surya Anugrah Bogor. 
 * 
 * Aplikasi ini menggunakan beberapa method yang dibuat 
 * diantaranya: method getAllData(), dan noStringInputan().
 * aplikasi ini membuat beberapa member variabel yang bersifat private untuk menyimpan data yang diberikan oleh user sebelum diolah.
 * Member variabel tersebut adalah:
 * String tampungInputNama, String tampungInputNoKTP, String tampungInputJenisPekerjaan, String tampungInputNoKontak,
 * String tampungInputEmail, String tampungInputJenisKelamin, String tampungInputStatus, int inputJumlahTanggunganKonvert,
 * double inputGajiPokokKonvert, double inputPenghasilanTambahanKonvert, double inputBonusKonvert, Strung tampungInputAlamat,
 * String tampungKodePos, double inputHargaBarangKonvert, double inputUangMukaKonvert, double inputBungaKonvert dan int inputDurasiKreditKonvert
 * 
 * Adapun member variabel seperti: double totalPenghasilanNasabah, double limitKreditNasabah, double totalPokokKreditNasabah,
 * double bungaKreditNasabah, double totalKreditNasabah, double kreditNasabahPerBulan
 * @author Tri Ananda Putra
 */
public class WindowCicilanMotorApp extends javax.swing.JFrame {

    private Nasabah nasabah;
    private AnalisaKreditNasabah akn;

    private String tampungInputNama;
    private String tampungInputNoKTP;
    private String tampungInputJenisPekerjaan;
    private String tampungInputPendidikanTerakhir;
    private String tampungInputNoKontak;
    private String tampungInputEmail;
    private String tampungInputJenisKelamin;
    private String tampungInputStatus;
    private int inputJumlahTanggunganKonvert = 0;
    private double inputGajiPokokKonvert = 0.0;
    private double inputPenghasilanTambahanKonvert;
    private double inputBonusKonvert;
    private String tampungInputAlamat;
    private String tampungKodePos;
    private double inputHargaBarangKonvert;
    private double inputUangMukaKonvert;
    private double inputBungaKonvert;
    private int inputDurasiKreditKonvert;

    private double totalPenghasilanNasabah;
    private double limitKreditNasabah;
    private double totalPokokKreditNasabah;
    private double bungaKreditNasabah;
    private double totalKreditNasabah;
    private double kreditNasabahPerBulan;

    private int flag = 12; //variabel ini digunakan untuk penanda kolom-kolom yang wajib diisi

    /**
     * Creates new form WindowCicilanMotorApp
     */
    public WindowCicilanMotorApp() {
        initComponents();
        rb_Pria.setSelected(true);
        rb_Single.setSelected(true);
    }
    
    /**
     * Method getAllData digunakan untuk mengambil semua data yang diinputkan user
     * dan menyimpannya pada member variabel
     */
    private void getAllData() {
        try {
            String cekInputNama = tf_InputNama.getText();
            if (cekInputNama.equals(" -") || cekInputNama.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Kolom \"Nama Lengkap Pemohon\"  tidak boleh kosong!");
            } else {
                tampungInputNama = tf_InputNama.getText();
                flag -= 1;
            }

            String cekInputNoKTP = tf_InputKTP.getText();
            if (cekInputNoKTP.equals(" -") || cekInputNoKTP.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Kolom \"Nomor KTP\"  tidak boleh kosong!");
            } else {
                tampungInputNoKTP = tf_InputKTP.getText();
                flag -= 1;
            }

            tampungInputJenisPekerjaan = (String) cb_JenisPekerjaan.getSelectedItem();
            tampungInputPendidikanTerakhir = (String) cb_PendidikanTerakhir.getSelectedItem();

            String cekInputNoKontak = tf_InputNomorKontak.getText();
            if (cekInputNoKontak.equals(" -") || cekInputNoKontak.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Kolom \"Nomor Kontak\"  tidak boleh kosong!");
            } else {
                tampungInputNoKontak = tf_InputNomorKontak.getText();
                flag -= 1;
            }

            String cekInputEmail = tf_InputEmail.getText();
            if (cekInputEmail.equals(" -") || cekInputEmail.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Kolom \"Alamat Email\"  tidak boleh kosong!");
            } else {
                tampungInputEmail = tf_InputEmail.getText();
                flag -= 1;
            }

            if (rb_Pria.isSelected()) {
                tampungInputJenisKelamin = rb_Pria.getText();
            } else {
                tampungInputJenisKelamin = rb_Wanita.getText();
            }

            if (rb_Single.isSelected()) {
                tampungInputStatus = rb_Single.getText();
            } else {
                tampungInputStatus = rb_Menikah.getText();
            }

            String tampungInputJumlahTanggunganString = tf_InputJumlahTanggungan.getText();
            if (tampungInputJumlahTanggunganString.equals(" -") || tampungInputJumlahTanggunganString.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Kolom \"Jumlah Tanggungan Pemohon\"  tidak boleh kosong!");
            } else {
                inputJumlahTanggunganKonvert = Integer.parseInt(tampungInputJumlahTanggunganString);
                flag -= 1;
            }

            String tampungInputGajiPokokString = tf_InputGajiPokok.getText();
            if (tampungInputGajiPokokString.equals(" -") || tampungInputGajiPokokString.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Kolom \"Gaji Pokok\"  tidak boleh kosong!");

            } else {
                inputGajiPokokKonvert = Double.parseDouble(tampungInputGajiPokokString);
                flag -= 1;
            }

            String tampungInputPenghasilanTambahanString = tf_InputPenghasilanTambahan.getText();
            if (tampungInputPenghasilanTambahanString.equals(" -") || tampungInputPenghasilanTambahanString.equals("")) {
                tampungInputPenghasilanTambahanString = "0.0";
                inputPenghasilanTambahanKonvert = Double.parseDouble(tampungInputPenghasilanTambahanString);
            } else {
                inputPenghasilanTambahanKonvert = Double.parseDouble(tampungInputPenghasilanTambahanString);
            }

            String tampungInputBonusString = tf_InputBonus.getText();
            if (tampungInputBonusString.equals(" -") || tampungInputBonusString.equals("")) {
                tampungInputBonusString = "0.0";
                inputBonusKonvert = Double.parseDouble(tampungInputBonusString);
            } else {
                inputBonusKonvert = Double.parseDouble(tampungInputBonusString);
            }

            String cekInputAlamat = ta_InputAlamat.getText();
            if (cekInputAlamat.equals(" -") || cekInputAlamat.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Kolom \"Alamat Rumah Tinggal\"  tidak boleh kosong!");
            } else {
                tampungInputAlamat = ta_InputAlamat.getText();
                flag -= 1;
            }

            String cekInputKodePos = tf_InputKodePOS.getText();
            if (cekInputKodePos.equals(" -") || cekInputKodePos.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Kolom \"Kode Pos\"  tidak boleh kosong!");
            } else {
                tampungKodePos = tf_InputKodePOS.getText();
                flag -= 1;
            }

            String tampungInputHargaBarangString = tf_InputHargaBarang.getText();
            if (tampungInputHargaBarangString.equals(" -") || tampungInputHargaBarangString.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Kolom \"Harga Barang\"  tidak boleh kosong!");
            } else {
                inputHargaBarangKonvert = Double.parseDouble(tampungInputHargaBarangString);
                flag -= 1;
            }

            String tampungInputUangMukaString = tf_InputUangMuka.getText();
            if (tampungInputUangMukaString.equals(" -") || tampungInputUangMukaString.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Kolom \"Uang Muka\"  tidak boleh kosong!");
            } else {
                inputUangMukaKonvert = Double.parseDouble(tampungInputUangMukaString);
                flag -= 1;
            }

            String tampungInputBungaString = tf_InputBungaTahun.getText();
            if (tampungInputBungaString.equals(" -") || tampungInputBungaString.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Kolom \"Bunga/Tahun\"  tidak boleh kosong!");
            } else {
                inputBungaKonvert = Double.parseDouble(tampungInputBungaString);
                flag -= 1;
            }

            String tampungInputDurasiKreditString = tf_InputDurasiKredit.getText();
            if (tampungInputDurasiKreditString.equals(" -") || tampungInputDurasiKreditString.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Kolom \"Durasi Kredit\"  tidak boleh kosong!");
            } else {
                inputDurasiKreditKonvert = Integer.parseInt(tampungInputDurasiKreditString);
                flag -= 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Masukkan harus angka!");
        }
    }
    
    /**
     * Method noStringInputan digunakan dalam proses penginputan data agar data sesuai dengan tipe datanya,
     * dalam hal ini karakter selain angka dilarang
     * @parameter evt 
     */
    private void noStringInputan(java.awt.event.KeyEvent evt){
        char inputan = evt.getKeyChar();
        if(!((inputan >= '0') && (inputan <= '9') || (inputan==KeyEvent.VK_BACKSPACE) || (inputan==KeyEvent.VK_DELETE))){
            getToolkit().beep();
            evt.consume();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        containerPanelTitle = new javax.swing.JPanel();
        containerTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        logo = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        containerScroll = new javax.swing.JPanel();
        dataNasabah = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tf_InputNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_InputKTP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rb_Pria = new javax.swing.JRadioButton();
        rb_Wanita = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        tf_InputNomorKontak = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rb_Single = new javax.swing.JRadioButton();
        rb_Menikah = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        tf_InputJumlahTanggungan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tf_InputGajiPokok = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tf_InputPenghasilanTambahan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tf_InputBonus = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cb_PendidikanTerakhir = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        tf_InputEmail = new javax.swing.JTextField();
        cb_JenisPekerjaan = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        tf_InputKodePOS = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_InputAlamat = new javax.swing.JTextArea();
        dataKredit = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        tf_InputHargaBarang = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tf_InputUangMuka = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tf_InputBungaTahun = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tf_InputDurasiKredit = new javax.swing.JTextField();
        hitungKredit = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        hasilLimit = new javax.swing.JLabel();
        btn_HitungKreditLimit = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        hasilKreditBulan = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ta_HasilValidasi = new javax.swing.JTextArea();
        btn_Validasi = new javax.swing.JButton();
        picHasilValidasi = new javax.swing.JLabel();
        btn_Clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Permohonan Nasabah Kredit Motor");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        containerPanelTitle.setBackground(new java.awt.Color(255, 255, 255));
        containerPanelTitle.setToolTipText("");

        containerTitle.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Aplikasi Permohonan Nasabah Kredit Motor");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/indocyber/pic/LOGO.png"))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("PT. SURYA ANUGRAH BOGOR");

        javax.swing.GroupLayout containerTitleLayout = new javax.swing.GroupLayout(containerTitle);
        containerTitle.setLayout(containerTitleLayout);
        containerTitleLayout.setHorizontalGroup(
            containerTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerTitleLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addGroup(containerTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
                .addGap(82, 82, 82)
                .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );
        containerTitleLayout.setVerticalGroup(
            containerTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(containerTitleLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout containerPanelTitleLayout = new javax.swing.GroupLayout(containerPanelTitle);
        containerPanelTitle.setLayout(containerPanelTitleLayout);
        containerPanelTitleLayout.setHorizontalGroup(
            containerPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerPanelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(containerTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        containerPanelTitleLayout.setVerticalGroup(
            containerPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerPanelTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(containerTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setAutoscrolls(true);

        containerScroll.setBackground(new java.awt.Color(255, 255, 255));

        dataNasabah.setBackground(new java.awt.Color(255, 255, 255));
        dataNasabah.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true), "Data Nasabah", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 153, 153))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Nama Lengkap Pemohon");

        tf_InputNama.setText(" -");
        tf_InputNama.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tf_InputNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_InputNamaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nomor KTP");

        tf_InputKTP.setText(" -");
        tf_InputKTP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_InputKTPKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Jenis Pekerjaan");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Jenis Kelamin");

        buttonGroup1.add(rb_Pria);
        rb_Pria.setText("Pria");
        rb_Pria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_PriaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_Wanita);
        rb_Wanita.setText("Wanita");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Nomor Kontak");

        tf_InputNomorKontak.setText(" -");
        tf_InputNomorKontak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_InputNomorKontakActionPerformed(evt);
            }
        });
        tf_InputNomorKontak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_InputNomorKontakKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Status");

        buttonGroup2.add(rb_Single);
        rb_Single.setText("Single");

        buttonGroup2.add(rb_Menikah);
        rb_Menikah.setText("Menikah");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Jumlah Tanggungan (Anak-anak & Istri)");

        tf_InputJumlahTanggungan.setText(" -");
        tf_InputJumlahTanggungan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_InputJumlahTanggunganKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Gaji Pokok (Rp)");

        tf_InputGajiPokok.setText(" -");
        tf_InputGajiPokok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_InputGajiPokokActionPerformed(evt);
            }
        });
        tf_InputGajiPokok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_InputGajiPokokKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Penghasilan Tambahan (Rp)");

        tf_InputPenghasilanTambahan.setText(" -");
        tf_InputPenghasilanTambahan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_InputPenghasilanTambahanKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Bonus (Rp)");

        tf_InputBonus.setText(" -");
        tf_InputBonus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_InputBonusKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Alamat Rumah Tinggal");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Pendidikan Terakhir");

        cb_PendidikanTerakhir.setBackground(new java.awt.Color(0, 153, 153));
        cb_PendidikanTerakhir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SMP/MTS", "SMA/K/MA", "D1", "D2", "D3", "D4", "S1", "S2", "S3" }));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Alamat Email");

        tf_InputEmail.setText(" - ");

        cb_JenisPekerjaan.setBackground(new java.awt.Color(0, 153, 153));
        cb_JenisPekerjaan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PNS", "Karyawan Swasta", "Karyawan BUMN", "TNI/POLRI", "Wiraswasta", "Wirausaha", "Buruh" }));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Kode Pos");

        tf_InputKodePOS.setText(" -");
        tf_InputKodePOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_InputKodePOSActionPerformed(evt);
            }
        });
        tf_InputKodePOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_InputKodePOSKeyTyped(evt);
            }
        });

        ta_InputAlamat.setColumns(20);
        ta_InputAlamat.setRows(5);
        ta_InputAlamat.setText(" -");
        jScrollPane1.setViewportView(ta_InputAlamat);

        javax.swing.GroupLayout dataNasabahLayout = new javax.swing.GroupLayout(dataNasabah);
        dataNasabah.setLayout(dataNasabahLayout);
        dataNasabahLayout.setHorizontalGroup(
            dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataNasabahLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataNasabahLayout.createSequentialGroup()
                        .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addGroup(dataNasabahLayout.createSequentialGroup()
                                .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tf_InputKTP, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_InputNama)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(22, 22, 22)))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataNasabahLayout.createSequentialGroup()
                        .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_JenisPekerjaan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_PendidikanTerakhir, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_InputNomorKontak, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_InputEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(74, 74, 74)))
                .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_InputBonus)
                    .addComponent(tf_InputPenghasilanTambahan)
                    .addGroup(dataNasabahLayout.createSequentialGroup()
                        .addComponent(rb_Single, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(rb_Menikah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(80, 80, 80))
                    .addGroup(dataNasabahLayout.createSequentialGroup()
                        .addComponent(rb_Pria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(rb_Wanita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(80, 80, 80))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_InputGajiPokok)
                    .addGroup(dataNasabahLayout.createSequentialGroup()
                        .addComponent(tf_InputJumlahTanggungan)
                        .addGap(188, 188, 188))
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dataNasabahLayout.createSequentialGroup()
                        .addComponent(tf_InputKodePOS, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                        .addGap(145, 145, 145))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                .addContainerGap())
        );
        dataNasabahLayout.setVerticalGroup(
            dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataNasabahLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataNasabahLayout.createSequentialGroup()
                        .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_InputNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rb_Pria)
                            .addComponent(rb_Wanita))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_InputKTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rb_Single)
                            .addComponent(rb_Menikah)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel16))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_InputJumlahTanggungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_JenisPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_InputKodePOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_InputGajiPokok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_PendidikanTerakhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_InputPenghasilanTambahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_InputNomorKontak, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataNasabahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_InputBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_InputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        dataKredit.setBackground(new java.awt.Color(255, 255, 255));
        dataKredit.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true), "Data Kredit", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 153, 153))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Harga Barang (Rp)");

        tf_InputHargaBarang.setText(" -");
        tf_InputHargaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_InputHargaBarangKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Uang Muka (Rp)");

        tf_InputUangMuka.setText(" -");
        tf_InputUangMuka.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_InputUangMukaKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Bunga/Tahun (%)");

        tf_InputBungaTahun.setText(" -");
        tf_InputBungaTahun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_InputBungaTahunKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Durasi Kredit (Bulan)");

        tf_InputDurasiKredit.setText(" -");
        tf_InputDurasiKredit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_InputDurasiKreditKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout dataKreditLayout = new javax.swing.GroupLayout(dataKredit);
        dataKredit.setLayout(dataKreditLayout);
        dataKreditLayout.setHorizontalGroup(
            dataKreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataKreditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataKreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_InputHargaBarang)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_InputUangMuka)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addGroup(dataKreditLayout.createSequentialGroup()
                        .addGroup(dataKreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_InputBungaTahun, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(tf_InputDurasiKredit, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                        .addGap(172, 172, 172)))
                .addContainerGap())
        );
        dataKreditLayout.setVerticalGroup(
            dataKreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataKreditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_InputHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_InputUangMuka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_InputBungaTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_InputDurasiKredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        hitungKredit.setBackground(new java.awt.Color(255, 255, 255));
        hitungKredit.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true), "Hitung Kredit", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 153, 153))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Limit");

        hasilLimit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hasilLimit.setText("0,-");

        btn_HitungKreditLimit.setBackground(new java.awt.Color(0, 204, 153));
        btn_HitungKreditLimit.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btn_HitungKreditLimit.setText("Hitung");
        btn_HitungKreditLimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HitungKreditLimitActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Kredit (Bulan)");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Rp");

        hasilKreditBulan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        hasilKreditBulan.setText("0,-");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Rp");

        javax.swing.GroupLayout hitungKreditLayout = new javax.swing.GroupLayout(hitungKredit);
        hitungKredit.setLayout(hitungKreditLayout);
        hitungKreditLayout.setHorizontalGroup(
            hitungKreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hitungKreditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hitungKreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(hitungKreditLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hasilKreditBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_HitungKreditLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(hitungKreditLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hasilLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        hitungKreditLayout.setVerticalGroup(
            hitungKreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hitungKreditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hitungKreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hasilLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hitungKreditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hasilKreditBulan)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addComponent(btn_HitungKreditLimit)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true), "Hasil Validasi", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 153, 153))); // NOI18N

        ta_HasilValidasi.setEditable(false);
        ta_HasilValidasi.setBackground(new java.awt.Color(240, 240, 240));
        ta_HasilValidasi.setColumns(20);
        ta_HasilValidasi.setRows(5);
        ta_HasilValidasi.setText("Mohon isikan data dengan lengkap.");
        jScrollPane3.setViewportView(ta_HasilValidasi);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_Validasi.setBackground(new java.awt.Color(0, 204, 153));
        btn_Validasi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Validasi.setText("Cek Validasi");
        btn_Validasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ValidasiActionPerformed(evt);
            }
        });

        btn_Clear.setBackground(new java.awt.Color(0, 204, 153));
        btn_Clear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Clear.setText("Clear");
        btn_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Validasi, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(picHasilValidasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Clear, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btn_Validasi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(picHasilValidasi, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout containerScrollLayout = new javax.swing.GroupLayout(containerScroll);
        containerScroll.setLayout(containerScrollLayout);
        containerScrollLayout.setHorizontalGroup(
            containerScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerScrollLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataNasabah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(containerScrollLayout.createSequentialGroup()
                        .addComponent(dataKredit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(hitungKredit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(285, 285, 285))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        containerScrollLayout.setVerticalGroup(
            containerScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerScrollLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(dataNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(containerScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataKredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hitungKredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(containerScroll);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(containerPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(containerPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_InputGajiPokokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_InputGajiPokokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_InputGajiPokokActionPerformed

    private void tf_InputNomorKontakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_InputNomorKontakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_InputNomorKontakActionPerformed

    private void rb_PriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_PriaActionPerformed

    }//GEN-LAST:event_rb_PriaActionPerformed

    private void tf_InputNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_InputNamaActionPerformed
    
    }//GEN-LAST:event_tf_InputNamaActionPerformed

    private void btn_HitungKreditLimitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HitungKreditLimitActionPerformed
        try {
            getAllData();
            nasabah = new Nasabah(tampungInputNama,
                    tampungInputNoKTP,
                    tampungInputJenisKelamin,
                    tampungInputNoKontak,
                    tampungInputAlamat,
                    tampungInputStatus,
                    inputJumlahTanggunganKonvert,
                    tampungInputJenisPekerjaan,
                    tampungInputPendidikanTerakhir,
                    tampungInputEmail,
                    tampungKodePos,
                    inputGajiPokokKonvert,
                    inputPenghasilanTambahanKonvert,
                    inputBonusKonvert);

            akn = new AnalisaKreditNasabah(inputHargaBarangKonvert, inputUangMukaKonvert, inputBungaKonvert, inputDurasiKreditKonvert);

            totalPenghasilanNasabah = nasabah.totalPenghasilan();
            limitKreditNasabah = akn.hitungLimitKredit(totalPenghasilanNasabah, inputJumlahTanggunganKonvert);
            totalPokokKreditNasabah = akn.hitungPokokKredit();
            bungaKreditNasabah = akn.hitungBungaKredit();
            totalKreditNasabah = akn.hitungTotalKredit();
            kreditNasabahPerBulan = akn.hitungKreditPerBulan();

            if (flag > 0) {
            
            } else {
                hasilLimit.setText(String.valueOf((int) limitKreditNasabah) + ",-");
                hasilKreditBulan.setText(String.valueOf((int) kreditNasabahPerBulan) + ",-");
                flag = 12;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "ERORR! Cek kembali inputan");
        }
    }//GEN-LAST:event_btn_HitungKreditLimitActionPerformed

    private void btn_ValidasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ValidasiActionPerformed
        try {
            if (limitKreditNasabah == 0.0 && kreditNasabahPerBulan == 0.0 && flag > 0) {
                JOptionPane.showMessageDialog(rootPane, "ERROR! Cek kembali inputan!");
            } else {
                if (limitKreditNasabah > kreditNasabahPerBulan) {
                    ta_HasilValidasi.setText("Hasil permohonan nasabah kredit motor dengan identitas... \n"
                            + "\n\tNama                                       : " + nasabah.getNama()
                            + "\n\tNomor KTP                             : " + nasabah.getNoKTP()
                            + "\n\tJenis Kelamin                        : " + nasabah.getjKelamin()
                            + "\n\tNomor Kontak                        : " + nasabah.getKontakHP()
                            + "\n\tAlamat Email                          : " + nasabah.getEmail()
                            + "\n\tAlamat Rumah Tinggal        : " + nasabah.getAlamat()
                            + "\n\tPenghasilan Setiap Bulan  : Rp " + (int) totalPenghasilanNasabah + ",-"
                            + "\n\nadalah \"DISETUJUI\".");
                    ImageIcon newIcon = new ImageIcon("src/id/indocyber/pic/check.png");
                    picHasilValidasi.setIcon(newIcon);
                } else {
                    ta_HasilValidasi.setText("Hasil permohonan nasabah kredit motor dengan identitas... \n"
                            + "\n\tNama                                       : " + nasabah.getNama()
                            + "\n\tNomor KTP                             : " + nasabah.getNoKTP()
                            + "\n\tJenis Kelamin                        : " + nasabah.getjKelamin()
                            + "\n\tNomor Kontak                        : " + nasabah.getKontakHP()
                            + "\n\tAlamat Email                          : " + nasabah.getEmail()
                            + "\n\tAlamat Rumah Tinggal        : " + nasabah.getAlamat()
                            + "\n\tPenghasilan Setiap Bulan  : Rp " + (int) totalPenghasilanNasabah + ",-"
                            + "\n\nadalah \"DITOLAK\".");
                    ImageIcon newIcon = new ImageIcon("src/id/indocyber/pic/cancel.png");
                    picHasilValidasi.setIcon(newIcon);
                }
                flag = 12;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "ERROR! Cek kembali inputan");
        }
    }//GEN-LAST:event_btn_ValidasiActionPerformed

    private void tf_InputKodePOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_InputKodePOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_InputKodePOSActionPerformed

    private void tf_InputKTPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_InputKTPKeyTyped
        noStringInputan(evt);
    }//GEN-LAST:event_tf_InputKTPKeyTyped

    private void tf_InputNomorKontakKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_InputNomorKontakKeyTyped
        noStringInputan(evt);
    }//GEN-LAST:event_tf_InputNomorKontakKeyTyped

    private void tf_InputJumlahTanggunganKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_InputJumlahTanggunganKeyTyped
        noStringInputan(evt);
    }//GEN-LAST:event_tf_InputJumlahTanggunganKeyTyped

    private void tf_InputGajiPokokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_InputGajiPokokKeyTyped
        noStringInputan(evt);
    }//GEN-LAST:event_tf_InputGajiPokokKeyTyped

    private void tf_InputPenghasilanTambahanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_InputPenghasilanTambahanKeyTyped
        noStringInputan(evt);
    }//GEN-LAST:event_tf_InputPenghasilanTambahanKeyTyped

    private void tf_InputBonusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_InputBonusKeyTyped
        noStringInputan(evt);
    }//GEN-LAST:event_tf_InputBonusKeyTyped

    private void tf_InputKodePOSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_InputKodePOSKeyTyped
        noStringInputan(evt);
    }//GEN-LAST:event_tf_InputKodePOSKeyTyped

    private void tf_InputHargaBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_InputHargaBarangKeyTyped
        noStringInputan(evt);
    }//GEN-LAST:event_tf_InputHargaBarangKeyTyped

    private void tf_InputUangMukaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_InputUangMukaKeyTyped
        noStringInputan(evt);
    }//GEN-LAST:event_tf_InputUangMukaKeyTyped

    private void tf_InputBungaTahunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_InputBungaTahunKeyTyped
        noStringInputan(evt);
    }//GEN-LAST:event_tf_InputBungaTahunKeyTyped

    private void tf_InputDurasiKreditKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_InputDurasiKreditKeyTyped
        noStringInputan(evt);
    }//GEN-LAST:event_tf_InputDurasiKreditKeyTyped

    private void btn_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearActionPerformed
        tf_InputNama.setText(" -");
        tf_InputKTP.setText(" -");
        tf_InputNomorKontak.setText(" -");
        tf_InputBonus.setText(" -");
        tf_InputBungaTahun.setText(" -");
        tf_InputDurasiKredit.setText(" -");
        tf_InputEmail.setText(" -");
        tf_InputGajiPokok.setText(" -");
        tf_InputHargaBarang.setText(" -");
        tf_InputJumlahTanggungan.setText(" -");
        tf_InputKodePOS.setText(" -");
        tf_InputPenghasilanTambahan.setText(" -");
        tf_InputUangMuka.setText(" -");
        ta_HasilValidasi.setText("Mohon isikan data dengan lengkap.");
        ta_InputAlamat.setText(" -");
        rb_Pria.setSelected(true);
        rb_Single.setSelected(true);
        hasilLimit.setText("0,-");
        hasilKreditBulan.setText("0,-");
        cb_JenisPekerjaan.setSelectedItem("PNS");
        cb_PendidikanTerakhir.setSelectedItem("SMP/MTS");
        ImageIcon newIcon = new ImageIcon();
        picHasilValidasi.setIcon(newIcon);
    }//GEN-LAST:event_btn_ClearActionPerformed

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
            java.util.logging.Logger.getLogger(WindowCicilanMotorApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowCicilanMotorApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowCicilanMotorApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowCicilanMotorApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowCicilanMotorApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Clear;
    private javax.swing.JButton btn_HitungKreditLimit;
    private javax.swing.JButton btn_Validasi;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cb_JenisPekerjaan;
    private javax.swing.JComboBox<String> cb_PendidikanTerakhir;
    private javax.swing.JPanel containerPanelTitle;
    private javax.swing.JPanel containerScroll;
    private javax.swing.JPanel containerTitle;
    private javax.swing.JPanel dataKredit;
    private javax.swing.JPanel dataNasabah;
    private javax.swing.JLabel hasilKreditBulan;
    private javax.swing.JLabel hasilLimit;
    private javax.swing.JPanel hitungKredit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel picHasilValidasi;
    private javax.swing.JRadioButton rb_Menikah;
    private javax.swing.JRadioButton rb_Pria;
    private javax.swing.JRadioButton rb_Single;
    private javax.swing.JRadioButton rb_Wanita;
    private javax.swing.JTextArea ta_HasilValidasi;
    private javax.swing.JTextArea ta_InputAlamat;
    private javax.swing.JTextField tf_InputBonus;
    private javax.swing.JTextField tf_InputBungaTahun;
    private javax.swing.JTextField tf_InputDurasiKredit;
    private javax.swing.JTextField tf_InputEmail;
    private javax.swing.JTextField tf_InputGajiPokok;
    private javax.swing.JTextField tf_InputHargaBarang;
    private javax.swing.JTextField tf_InputJumlahTanggungan;
    private javax.swing.JTextField tf_InputKTP;
    private javax.swing.JTextField tf_InputKodePOS;
    private javax.swing.JTextField tf_InputNama;
    private javax.swing.JTextField tf_InputNomorKontak;
    private javax.swing.JTextField tf_InputPenghasilanTambahan;
    private javax.swing.JTextField tf_InputUangMuka;
    // End of variables declaration//GEN-END:variables
}
