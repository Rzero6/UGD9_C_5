/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
package javax.swing;
/**
 * Nama : Reynold Kunarto 
 * NPM : 210711015
 * 
 * Nama : Febiola Ika Putri Wibowo
 * NPM : 210711023
 */

import javax.swing.JOptionPane;
import model.Kendaraan;
import control.KendaraanControl;
import Exception.IdKendaraanException;
import Exception.InputKosongException;
import Exception.JenisKendaraanException;
import java.awt.Image;
import javax.swing.ImageIcon;

public class KendaraanView extends javax.swing.JFrame {
    private String jenis;

    /**
     * Creates new form KendaraanView
     */
    
    private KendaraanControl kendaraanControl;
    String action = null;
    
    public KendaraanView() {
        initComponents();
        setComponent(false);
        setEditDeleteBtn(false);
        setLogo();
        kendaraanControl = new KendaraanControl();
        showKendaraan();
    }
    public void setLogo(){
        ImageIcon icon = new ImageIcon("src\\assets\\logo.png");
        Image img = icon.getImage();
        Image imgscale = img.getScaledInstance(logoLabel.getWidth(), logoLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleIcon = new ImageIcon(imgscale);
        logoLabel.setIcon(scaleIcon);
    }
    public void setComponent(boolean value) {
        merkInput.setEnabled(value);
        tahunInput.setEnabled(value);
        noPlatInput.setEnabled(value);
        
        setEnableRadio(value);
        
        btnSave.setEnabled(value);
        btnCancel.setEnabled(value);
        
        motorInput.setEnabled(value);
        mobilInput.setEnabled(value);
        
    }

    public void setEditDeleteBtn(boolean value) {
        btnEdit.setEnabled(value);
        btnDelete.setEnabled(value);
    }
    
    public void setSelectRadio(boolean value){
        mobilRBtn.setSelected(value);
        motorRBtn.setSelected(value);
    }
    
    public void setEnableRadio(boolean value){
        mobilRBtn.setEnabled(value);
        motorRBtn.setEnabled(value);
        penumpangLabel.setEnabled(value);
        takLabel.setEnabled(value);
    }

    public void clearText() {
        idInput.setText("Pilih Mobil atau Motor");
        merkInput.setText("");
        tahunInput.setText("");
        noPlatInput.setText("");
        
        motorInput.setText("");
        mobilInput.setText("");
        
        txtSearch.setText("cari berdasarkan id");
    }
    
    public void showKendaraan(){
        showDataTextAreaMotor.setText(kendaraanControl.showDataKendaraan("motor"));
        showDataTextAreaMobil.setText(kendaraanControl.showDataKendaraan("mobil"));
    }
    
    public void inputKosongException(int i) throws InputKosongException{
        if(i==1){
            if(merkInput.getText().isEmpty() || idInput.getText().isEmpty() 
                    || tahunInput.getText().isEmpty()
                    || noPlatInput.getText().isEmpty()) {
                throw new InputKosongException();
            }
        }else{
            if(motorInput.getText().isEmpty() && mobilInput.getText().isEmpty()){
                throw new InputKosongException();
            }
        }
        
    }
    
    public void idKendaraanException() throws IdKendaraanException {
        if(idInput.getText().length() < 5 || idInput.getText().length() > 8){
            throw new IdKendaraanException();
        }
    }
    
    public void jenisKendaraanException() throws JenisKendaraanException {
        if(buttonGroupJenis.isSelected(null)){
            throw new JenisKendaraanException();
        }
    }
    
    public void idGen(String jenis){
        String mobil = "MBL-";
        String motor = "MTR-";
        String idmobil;
        String idmotor;
        String temp;
        int i;

        if(jenis.equals("Mobil")){
            if(kendaraanControl.getLasKendaraan(jenis)==null){
                i=1;
                idmobil = mobil + i;
            }else{
                temp = kendaraanControl.getLasKendaraan(jenis).getId();
                i = Integer.parseInt(temp.replaceAll("[^\\d]", ""))+1;
                idmobil=mobil+i;
                while(kendaraanControl.searchKendaraan(idmobil)!=null){
                    i++;
                    idmobil=mobil+i;
                }
            }
            
            //method masukin id mobil ke data mobil
            idInput.setText(idmobil);
        }else{
            if(kendaraanControl.getLasKendaraan(jenis)==null){
                i=1;
                idmotor = motor + i;
            }else{
                temp = kendaraanControl.getLasKendaraan(jenis).getId();
                i = Integer.parseInt(temp.replaceAll("[^\\d]", ""))+1;
                idmotor=motor+i;
                while(kendaraanControl.searchKendaraan(idmotor)!=null){
                    i++;
                    idmotor=motor+i;
                }
            }
            
            //method masukin idmotor ke data motor
            idInput.setText(idmotor);
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

        buttonGroupJenis = new javax.swing.ButtonGroup();
        allPanel = new javax.swing.JPanel();
        actionPanel = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        headerPanel = new javax.swing.JPanel();
        titleContent = new javax.swing.JLabel();
        kelompokLabel = new javax.swing.JLabel();
        npm1Label = new javax.swing.JLabel();
        npm2Label = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        containerLabel = new javax.swing.JPanel();
        containerInputId = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        containerInputMerk = new javax.swing.JPanel();
        merkLabel = new javax.swing.JLabel();
        merkInput = new javax.swing.JTextField();
        containerInputTahun = new javax.swing.JPanel();
        tahunLabel = new javax.swing.JLabel();
        tahunInput = new javax.swing.JTextField();
        containerInputNoPlat = new javax.swing.JPanel();
        noPlatLabel = new javax.swing.JLabel();
        noPlatInput = new javax.swing.JTextField();
        containerOptionMobil = new javax.swing.JPanel();
        mobilRBtn = new javax.swing.JRadioButton();
        mobilInput = new javax.swing.JTextField();
        penumpangLabel = new javax.swing.JLabel();
        showDataPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        showDataTextAreaMobil = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        showDataTextAreaMotor = new javax.swing.JTextArea();
        containerOptionMotor = new javax.swing.JPanel();
        motorRBtn = new javax.swing.JRadioButton();
        motorInput = new javax.swing.JTextField();
        takLabel = new javax.swing.JLabel();
        mobilLabel = new javax.swing.JLabel();
        motorLabel = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 0));
        setPreferredSize(new java.awt.Dimension(760, 660));

        allPanel.setBackground(new java.awt.Color(0, 204, 255));
        allPanel.setForeground(new java.awt.Color(255, 255, 255));

        actionPanel.setBackground(new java.awt.Color(255, 255, 51));
        actionPanel.setForeground(new java.awt.Color(0, 0, 0));

        btnDelete.setBackground(new java.awt.Color(255, 0, 51));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtSearch.setBackground(new java.awt.Color(255, 255, 255));
        txtSearch.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(153, 153, 153));
        txtSearch.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSearch.setText("cari berdasarkan id");
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(51, 51, 255));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Cari");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 153, 51));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Ubah");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 204, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Tambah");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout actionPanelLayout = new javax.swing.GroupLayout(actionPanel);
        actionPanel.setLayout(actionPanelLayout);
        actionPanelLayout.setHorizontalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        actionPanelLayout.setVerticalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addContainerGap())
        );

        headerPanel.setBackground(new java.awt.Color(255, 255, 86));

        titleContent.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleContent.setForeground(new java.awt.Color(0, 0, 0));
        titleContent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleContent.setText("RENTAL KENDARAAN NEGARA");

        kelompokLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        kelompokLabel.setForeground(new java.awt.Color(0, 0, 0));
        kelompokLabel.setText("Kelompok 5");

        npm1Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        npm1Label.setForeground(new java.awt.Color(0, 0, 0));
        npm1Label.setText("210711015");

        npm2Label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        npm2Label.setForeground(new java.awt.Color(0, 0, 0));
        npm2Label.setText("210711023");

        logoLabel.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 8)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("By Lala Autos");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kelompokLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(npm1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(npm2Label)
                .addGap(45, 45, 45)
                .addComponent(titleContent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                        .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        headerPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {npm1Label, npm2Label});

        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleContent)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(kelompokLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(npm1Label)
                            .addComponent(npm2Label)))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout allPanelLayout = new javax.swing.GroupLayout(allPanel);
        allPanel.setLayout(allPanelLayout);
        allPanelLayout.setHorizontalGroup(
            allPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(allPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        allPanelLayout.setVerticalGroup(
            allPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(actionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        containerLabel.setBackground(new java.awt.Color(255, 255, 255));
        containerLabel.setForeground(new java.awt.Color(0, 0, 0));
        containerLabel.setPreferredSize(new java.awt.Dimension(1280, 720));

        containerInputId.setBackground(new java.awt.Color(255, 255, 255));
        containerInputId.setPreferredSize(new java.awt.Dimension(300, 65));

        idLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        idLabel.setForeground(new java.awt.Color(0, 0, 0));
        idLabel.setText("ID Kendaraan");

        idInput.setBackground(new java.awt.Color(255, 255, 255));
        idInput.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        idInput.setForeground(new java.awt.Color(51, 51, 51));
        idInput.setText("Pilih Mobil atau Motor");
        idInput.setEnabled(false);
        idInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerInputIdLayout = new javax.swing.GroupLayout(containerInputId);
        containerInputId.setLayout(containerInputIdLayout);
        containerInputIdLayout.setHorizontalGroup(
            containerInputIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerInputIdLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(containerInputIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerInputIdLayout.createSequentialGroup()
                        .addComponent(idLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(idInput, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                .addContainerGap())
        );
        containerInputIdLayout.setVerticalGroup(
            containerInputIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerInputIdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        containerInputMerk.setBackground(new java.awt.Color(255, 255, 255));
        containerInputMerk.setForeground(new java.awt.Color(0, 0, 0));
        containerInputMerk.setPreferredSize(new java.awt.Dimension(300, 65));

        merkLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        merkLabel.setForeground(new java.awt.Color(0, 0, 0));
        merkLabel.setText("Merk");

        merkInput.setBackground(new java.awt.Color(255, 255, 255));
        merkInput.setForeground(new java.awt.Color(0, 0, 0));
        merkInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                merkInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerInputMerkLayout = new javax.swing.GroupLayout(containerInputMerk);
        containerInputMerk.setLayout(containerInputMerkLayout);
        containerInputMerkLayout.setHorizontalGroup(
            containerInputMerkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerInputMerkLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(containerInputMerkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerInputMerkLayout.createSequentialGroup()
                        .addComponent(merkLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(merkInput, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                .addContainerGap())
        );
        containerInputMerkLayout.setVerticalGroup(
            containerInputMerkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerInputMerkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(merkLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(merkInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        containerInputTahun.setBackground(new java.awt.Color(255, 255, 255));
        containerInputTahun.setForeground(new java.awt.Color(0, 0, 0));
        containerInputTahun.setPreferredSize(new java.awt.Dimension(300, 65));

        tahunLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tahunLabel.setForeground(new java.awt.Color(0, 0, 0));
        tahunLabel.setText("Tahun Pembuatan");

        tahunInput.setBackground(new java.awt.Color(255, 255, 255));
        tahunInput.setForeground(new java.awt.Color(0, 0, 0));
        tahunInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahunInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerInputTahunLayout = new javax.swing.GroupLayout(containerInputTahun);
        containerInputTahun.setLayout(containerInputTahunLayout);
        containerInputTahunLayout.setHorizontalGroup(
            containerInputTahunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerInputTahunLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(containerInputTahunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerInputTahunLayout.createSequentialGroup()
                        .addComponent(tahunLabel)
                        .addGap(0, 180, Short.MAX_VALUE))
                    .addComponent(tahunInput))
                .addContainerGap())
        );
        containerInputTahunLayout.setVerticalGroup(
            containerInputTahunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerInputTahunLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tahunLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tahunInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        containerInputNoPlat.setBackground(new java.awt.Color(255, 255, 255));
        containerInputNoPlat.setForeground(new java.awt.Color(0, 0, 0));
        containerInputNoPlat.setPreferredSize(new java.awt.Dimension(300, 65));

        noPlatLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        noPlatLabel.setForeground(new java.awt.Color(0, 0, 0));
        noPlatLabel.setText("No Plat");

        noPlatInput.setBackground(new java.awt.Color(255, 255, 255));
        noPlatInput.setForeground(new java.awt.Color(0, 0, 0));
        noPlatInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noPlatInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerInputNoPlatLayout = new javax.swing.GroupLayout(containerInputNoPlat);
        containerInputNoPlat.setLayout(containerInputNoPlatLayout);
        containerInputNoPlatLayout.setHorizontalGroup(
            containerInputNoPlatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerInputNoPlatLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(containerInputNoPlatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerInputNoPlatLayout.createSequentialGroup()
                        .addComponent(noPlatLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(noPlatInput, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                .addContainerGap())
        );
        containerInputNoPlatLayout.setVerticalGroup(
            containerInputNoPlatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerInputNoPlatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(noPlatLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noPlatInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        containerOptionMobil.setBackground(new java.awt.Color(255, 255, 255));
        containerOptionMobil.setForeground(new java.awt.Color(0, 0, 0));

        buttonGroupJenis.add(mobilRBtn);
        mobilRBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mobilRBtn.setForeground(new java.awt.Color(0, 0, 0));
        mobilRBtn.setText("Mobil");
        mobilRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobilRBtnActionPerformed(evt);
            }
        });

        mobilInput.setBackground(new java.awt.Color(255, 255, 255));
        mobilInput.setForeground(new java.awt.Color(0, 0, 0));
        mobilInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobilInputActionPerformed(evt);
            }
        });

        penumpangLabel.setForeground(new java.awt.Color(102, 102, 102));
        penumpangLabel.setText("Jumlah Penumpang");

        javax.swing.GroupLayout containerOptionMobilLayout = new javax.swing.GroupLayout(containerOptionMobil);
        containerOptionMobil.setLayout(containerOptionMobilLayout);
        containerOptionMobilLayout.setHorizontalGroup(
            containerOptionMobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerOptionMobilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerOptionMobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mobilInput)
                    .addGroup(containerOptionMobilLayout.createSequentialGroup()
                        .addGroup(containerOptionMobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mobilRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(penumpangLabel))
                        .addGap(0, 138, Short.MAX_VALUE)))
                .addContainerGap())
        );
        containerOptionMobilLayout.setVerticalGroup(
            containerOptionMobilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerOptionMobilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mobilRBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(penumpangLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mobilInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        showDataPanel.setBackground(new java.awt.Color(255, 255, 255));

        showDataTextAreaMobil.setEditable(false);
        showDataTextAreaMobil.setBackground(new java.awt.Color(204, 204, 204));
        showDataTextAreaMobil.setColumns(20);
        showDataTextAreaMobil.setRows(5);
        jScrollPane3.setViewportView(showDataTextAreaMobil);

        showDataTextAreaMotor.setEditable(false);
        showDataTextAreaMotor.setBackground(new java.awt.Color(204, 204, 204));
        showDataTextAreaMotor.setColumns(20);
        showDataTextAreaMotor.setRows(5);
        showDataTextAreaMotor.setPreferredSize(null);
        jScrollPane1.setViewportView(showDataTextAreaMotor);

        javax.swing.GroupLayout showDataPanelLayout = new javax.swing.GroupLayout(showDataPanel);
        showDataPanel.setLayout(showDataPanelLayout);
        showDataPanelLayout.setHorizontalGroup(
            showDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        showDataPanelLayout.setVerticalGroup(
            showDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );

        containerOptionMotor.setBackground(new java.awt.Color(255, 255, 255));
        containerOptionMotor.setForeground(new java.awt.Color(0, 0, 0));

        buttonGroupJenis.add(motorRBtn);
        motorRBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        motorRBtn.setForeground(new java.awt.Color(0, 0, 0));
        motorRBtn.setText("Motor");
        motorRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motorRBtnActionPerformed(evt);
            }
        });

        motorInput.setBackground(new java.awt.Color(255, 255, 255));
        motorInput.setForeground(new java.awt.Color(0, 0, 0));
        motorInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motorInputActionPerformed(evt);
            }
        });

        takLabel.setForeground(new java.awt.Color(102, 102, 102));
        takLabel.setText("Jenis Tak");

        javax.swing.GroupLayout containerOptionMotorLayout = new javax.swing.GroupLayout(containerOptionMotor);
        containerOptionMotor.setLayout(containerOptionMotorLayout);
        containerOptionMotorLayout.setHorizontalGroup(
            containerOptionMotorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerOptionMotorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerOptionMotorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(motorInput)
                    .addGroup(containerOptionMotorLayout.createSequentialGroup()
                        .addGroup(containerOptionMotorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(motorRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(takLabel))
                        .addGap(0, 170, Short.MAX_VALUE)))
                .addContainerGap())
        );
        containerOptionMotorLayout.setVerticalGroup(
            containerOptionMotorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerOptionMotorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(motorRBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(takLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(motorInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        mobilLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mobilLabel.setForeground(new java.awt.Color(0, 0, 0));
        mobilLabel.setText("Data Mobil");

        motorLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        motorLabel.setForeground(new java.awt.Color(0, 0, 0));
        motorLabel.setText("Data Motor");

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Batal");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 204, 0));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerLabelLayout = new javax.swing.GroupLayout(containerLabel);
        containerLabel.setLayout(containerLabelLayout);
        containerLabelLayout.setHorizontalGroup(
            containerLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLabelLayout.createSequentialGroup()
                .addGroup(containerLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLabelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(containerLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(containerInputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(containerInputMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(containerInputTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(containerInputNoPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(containerLabelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(mobilLabel)))
                        .addGap(75, 75, 75)
                        .addGroup(containerLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(motorLabel)
                            .addComponent(containerOptionMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(containerOptionMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(containerLabelLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancel))))
                    .addComponent(showDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        containerLabelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {containerInputId, containerInputMerk, containerInputNoPlat, containerInputTahun});

        containerLabelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancel, btnSave});

        containerLabelLayout.setVerticalGroup(
            containerLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLabelLayout.createSequentialGroup()
                        .addComponent(containerInputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(containerInputMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(containerInputTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(containerInputNoPlat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(containerLabelLayout.createSequentialGroup()
                        .addComponent(containerOptionMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(containerOptionMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(containerLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnCancel))))
                .addGap(10, 10, 10)
                .addGroup(containerLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobilLabel)
                    .addComponent(motorLabel))
                .addGap(10, 10, 10)
                .addComponent(showDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        containerLabelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {containerInputId, containerInputMerk, containerInputNoPlat, containerInputTahun});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(allPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(containerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(allPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(containerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        setComponent(true);
        motorInput.setEnabled(false);
        mobilInput.setEnabled(false);
        setEnableRadio(true);
        clearText();
        txtSearch.setText("cari berdasarkan id");
        action = "Tambah";
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        setComponent(true);
        if(mobilRBtn.isSelected()){
            motorInput.setEnabled(false);
            mobilInput.setEnabled(true);
        }else{
            motorInput.setEnabled(true);
            mobilInput.setEnabled(false);
        }
        
        idInput.setEnabled(false);
        setEnableRadio(false);
        
        action = "Ubah";
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int getAnswer = JOptionPane.showConfirmDialog(rootPane, "Apakah yakin ingin menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (getAnswer == JOptionPane.YES_OPTION){
                try{
                    kendaraanControl.deleteKendaraan(idInput.getText());
                    clearText();
                    showKendaraan();
                    buttonGroupJenis.clearSelection();
                    setEditDeleteBtn(false);
                    JOptionPane.showMessageDialog(null, "Data Berhasil dihapus!");
                    
                }catch (Exception e){
                    System.out.println("Error : "+ e.getMessage());
                } 
        }else{
            JOptionPane.showMessageDialog(null,"Data tidak jadi dihapus");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        setEditDeleteBtn(true);
        setComponent(false);
        setSelectRadio(false);
        try{
            Kendaraan kendaraan = kendaraanControl.searchKendaraan(txtSearch.getText());
            if(kendaraan == null){
                setEditDeleteBtn(false);
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan", "konfirmasi", JOptionPane.DEFAULT_OPTION);
            }else{
                
                clearText();
                setEnableRadio(false);
                if(kendaraan.getJenis().equalsIgnoreCase("mobil")){
                    mobilRBtn.setSelected(true);
                    idInput.setText(kendaraan.getId());
                    merkInput.setText(kendaraan.getMerk());
                    tahunInput.setText(Integer.toString(kendaraan.getTahunPembuatan()));
                    noPlatInput.setText(kendaraan.getNoPlat());
                    mobilInput.setText(Integer.toString(kendaraan.getJumlah_penumpang()));
                }else{
                    motorRBtn.setSelected(true);
                    idInput.setText(kendaraan.getId());
                    merkInput.setText(kendaraan.getMerk());
                    tahunInput.setText(Integer.toString(kendaraan.getTahunPembuatan()));
                    noPlatInput.setText(kendaraan.getNoPlat());
                    motorInput.setText(kendaraan.getJenis_tak());
                }
            }
        }catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setComponent(false);
        setEditDeleteBtn(false);
        setEnableRadio(false);
        buttonGroupJenis.clearSelection();
        clearText();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
                try{
                        
                        inputKosongException(1);
                        jenisKendaraanException();
                        idKendaraanException();
                        inputKosongException(2);
                        if(mobilRBtn.isSelected()){
                            jenis = "mobil";
                        }else{
                            jenis = "motor";
                        }
                        Kendaraan k = null;
                        
                        if(jenis.equalsIgnoreCase("mobil")){
                            k = new Kendaraan(idInput.getText(),
                                merkInput.getText(),jenis , 
                                Integer.parseInt(tahunInput.getText()), 
                                noPlatInput.getText(), 
                                Integer.parseInt(mobilInput.getText()), 
                                null);
                        }else if(jenis.equalsIgnoreCase("motor")){
                            k = new Kendaraan(idInput.getText(),
                                merkInput.getText(),jenis , 
                                Integer.parseInt(tahunInput.getText()), 
                                noPlatInput.getText(), 
                                0, 
                                motorInput.getText());
                        }
                        
                        
                        if(action.equals("Tambah")){
                                kendaraanControl.insertDataKendaraan(k);
                            }else{
                                kendaraanControl.updateDataKendaraan(k,idInput.getText());
                            }
                        clearText();
                        showKendaraan();
                        setComponent(false);
                        setEditDeleteBtn(false);
                        buttonGroupJenis.clearSelection();
                    }catch(JenisKendaraanException e){
                        JOptionPane.showMessageDialog(this, e.message());
                    }catch(InputKosongException e){
                        JOptionPane.showMessageDialog(this, e.message());
                    }catch(IdKendaraanException e){
                        JOptionPane.showMessageDialog(this, e.message());
                    }catch(NumberFormatException nfe){
                        JOptionPane.showMessageDialog(this, "Input harus angka bilangan bulat!");
                    }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void motorInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motorInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motorInputActionPerformed

    private void motorRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motorRBtnActionPerformed
        // TODO add your handling code here:
        motorRBtn.setEnabled(true);
        motorInput.setEnabled(true);
        mobilInput.setEnabled(false);
        mobilInput.setText("");
        jenis = "Motor";
        idGen(jenis);
    }//GEN-LAST:event_motorRBtnActionPerformed

    private void mobilInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobilInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobilInputActionPerformed

    private void mobilRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobilRBtnActionPerformed
        // TODO add your handling code here:
        mobilRBtn.setEnabled(true);
        mobilInput.setEnabled(true);
        motorInput.setEnabled(false);
        motorInput.setText("");
        jenis = "Mobil";
        idGen(jenis);
    }//GEN-LAST:event_mobilRBtnActionPerformed

    private void noPlatInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noPlatInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noPlatInputActionPerformed

    private void tahunInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahunInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tahunInputActionPerformed

    private void merkInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_merkInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_merkInputActionPerformed

    private void idInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idInputActionPerformed

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        // TODO add your handling code here:
        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchMouseClicked

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
            java.util.logging.Logger.getLogger(KendaraanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KendaraanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KendaraanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KendaraanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KendaraanView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JPanel allPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroupJenis;
    private javax.swing.JPanel containerInputId;
    private javax.swing.JPanel containerInputMerk;
    private javax.swing.JPanel containerInputNoPlat;
    private javax.swing.JPanel containerInputTahun;
    private javax.swing.JPanel containerLabel;
    private javax.swing.JPanel containerOptionMobil;
    private javax.swing.JPanel containerOptionMotor;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel kelompokLabel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JTextField merkInput;
    private javax.swing.JLabel merkLabel;
    private javax.swing.JTextField mobilInput;
    private javax.swing.JLabel mobilLabel;
    private javax.swing.JRadioButton mobilRBtn;
    private javax.swing.JTextField motorInput;
    private javax.swing.JLabel motorLabel;
    private javax.swing.JRadioButton motorRBtn;
    private javax.swing.JTextField noPlatInput;
    private javax.swing.JLabel noPlatLabel;
    private javax.swing.JLabel npm1Label;
    private javax.swing.JLabel npm2Label;
    private javax.swing.JLabel penumpangLabel;
    private javax.swing.JPanel showDataPanel;
    private javax.swing.JTextArea showDataTextAreaMobil;
    private javax.swing.JTextArea showDataTextAreaMotor;
    private javax.swing.JTextField tahunInput;
    private javax.swing.JLabel tahunLabel;
    private javax.swing.JLabel takLabel;
    private javax.swing.JLabel titleContent;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
