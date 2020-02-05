/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.view;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import uangkuapplication.main.UangkuApplication;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uangkuapplication.entity.EntityTransaksi;
import uangkuapplication.error.KategoriException;
import uangkuapplication.event.TransaksiListener;
import uangkuapplication.model.ModelTransaksi;
import uangkuapplication.controller.TransaksiController;
import uangkuapplication.model.ModelTablePemasukan;
import uangkuapplication.model.ModelTablePengeluaran;

import org.knowm.xchart.XChartPanel;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.PieSeries.PieSeriesRenderStyle;
import org.knowm.xchart.style.PieStyler.AnnotationType;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import uangkuapplication.database.UangkuDatabase;
import uangkuapplication.model.ModelTableRencana;
import uangkuapplication.model.ModelTableTerbayar;
import uangkuapplication.service.ITransaksi;

import uangkuapplication.service.IXChart;
/**
 *
 * @author Kyoto
 */
public class MainFrame extends javax.swing.JFrame implements IXChart<PieChart,XYChart>, TransaksiListener,ListSelectionListener {
    private static MainFrame instance = null;
    
    
    
    PemasukanFrame frameMasuk;
    public ModelTablePemasukan tablePemasukanModel;
    public ModelTablePengeluaran tablePengeluaranModel;
    public ModelTableRencana tableRencanaModel;
    public ModelTableTerbayar tableTerbayarModel;
    private ModelTableRencana modelTableRencana;
    private Color color;
    private Color[] colorSet;
    
    /**
     * Creates new form MainFrame
     */
    private TransaksiController controller;
    private ModelTransaksi model;
    private IXChart<PieChart, XYChart> xChart;
    private PieChart pemasukanChart;
    
    private PieChart pengeluaranChart;
    private XYChart totalChart;
    
    private static String name;
    
    private List<EntityTransaksi> areaChartList;
    private List<Date> dateAreaChartListMasuk;
    private List<Integer> nominalAreaChartListMasuk;
    private List<Date> dateAreaChartListKeluar;
    private List<Integer> nominalAreaChartListKeluar;
    
    private List<EntityTransaksi> donutChartList;
    private List<String> donutChartKategoriListMasuk;
    private List<Integer> donutChartNominalListMasuk;
    private List<String> donutChartKategoriListKeluar;
    private List<Integer> donutChartNominalListKeluar;
    
    JPanel pemasukanChartPanel;
    JPanel pengeluaranChartPanel;
    JPanel totalChartPanel;
    private MainFrame(String name) {
        initComponents();
        
        color = new Color(255,229,153);
        colorSet = new Color[] { new Color(51,255,51,153), new Color(235,87,87, 153)};
        model = new ModelTransaksi();
        model.setListener(this);

        controller = new TransaksiController();
        controller.setModel(model);
        areaChartList = new ArrayList<EntityTransaksi>();
        donutChartList = new ArrayList<EntityTransaksi>();
        dateAreaChartListMasuk = new ArrayList<Date>();
        nominalAreaChartListMasuk = new ArrayList<Integer>();
        dateAreaChartListKeluar = new ArrayList<Date>();
        nominalAreaChartListKeluar = new ArrayList<Integer>();
        donutChartKategoriListMasuk = new ArrayList<String>();
        donutChartNominalListMasuk = new ArrayList<Integer>();
        donutChartKategoriListKeluar = new ArrayList<String>();
        donutChartNominalListKeluar = new ArrayList<Integer>();
        
        modelTableRencana = new ModelTableRencana();
        tableRencana.setModel(modelTableRencana);
        
        
        
        //tablePemasukanModel = new ModelTablePemasukan();
        //tablePengeluaranModel = new ModelTablePengeluaran();
        
        //tablePemasukan.getSelectionModel().addListSelectionListener(PemasukanFrame.getInstance());
        //tablePengeluaran.getSelectionModel().addListSelectionListener(PengeluaranFrame.getInstance());
        
        
        //tablePemasukan.setModel(PemasukanFrame.getInstance().modelTable);
        //tablePengeluaran.setModel(tablePengeluaranModel);
        
        
        
        this.name = name;
        txtNama.setText(name);
        
        txtPemasukan.setText(String.valueOf(controller.getTotalPemasukan()));
        txtPengeluaran.setText(String.valueOf(controller.getTotalPengeluaran()));
        txtTotal.setText(String.valueOf(controller.getUangSekarang(UangkuApplication.UserID)));
       

             

        
        //new SwingWrapper<PieChart>(pemasukanChart).displayChart();
        //txtPemasukan.setText(totalPemasukan);
    }

    public JLabel getTxtNama() {
        return txtNama;
    }

    public void setTxtNama(JLabel txtNama) {
        this.txtNama = txtNama;
    }
    
    
    
   
    public static MainFrame getInstance(String name){
        if (instance == null)
        {
            instance = new MainFrame(name);
        }
        return instance;
    }

    public JLabel getTxtMonth() {
        return txtMonth;
    }

    public void setTxtMonth(JLabel txtMonth) {
        this.txtMonth = txtMonth;
    }

    public JLabel getTxtPemasukan() {
        return txtPemasukan;
    }

    public JTable getTablePemasukan() {
        return tablePemasukan;
    }

    public void setTablePemasukan(JTable tablePemasukan) {
        this.tablePemasukan = tablePemasukan;
    }

    public void setTablePengeluaran(JTable tablePengeluaran) {
        this.tablePengeluaran = tablePengeluaran;
    }
    

    public JTable getTablePengeluaran() {
        return tablePengeluaran;
    }

    public JTable getTableRencana() {
        return tableRencana;
    }

    public void setTableRencana(JTable tableRencana) {
        this.tableRencana = tableRencana;
    }

    public JTable getTableTerbayar() {
        return tableTerbayar;
    }

    public void setTableTerbayar(JTable tableTerbayar) {
        this.tableTerbayar = tableTerbayar;
    }
    

    public JLabel getTxtPengeluaran() {
        return txtPengeluaran;
    }

    public JLabel getTxtTotal() {
        return txtTotal;
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
        mainPanel = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNama = new javax.swing.JLabel();
        pengeluaranBtn = new javax.swing.JButton();
        pemasukanBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtPemasukan = new javax.swing.JLabel();
        txtPengeluaran = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePengeluaran = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePemasukan = new javax.swing.JTable();
        reportPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TotalPanel = new javax.swing.JPanel();
        PengeluaranPanel = new javax.swing.JPanel();
        PemasukanPanel = new javax.swing.JPanel();
        txtMonth = new javax.swing.JLabel();
        planningPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRencana = new javax.swing.JTable();
        btnBayarAng = new javax.swing.JButton();
        btnUbahAng = new javax.swing.JButton();
        btnHapusAng = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTerbayar = new javax.swing.JTable();
        btnTambahRe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        homeBtn = new javax.swing.JButton();
        planningBtn = new javax.swing.JButton();
        reportBtn = new javax.swing.JButton();
        addCategoryBtn = new javax.swing.JButton();
        profileBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(280, 100));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setPreferredSize(new java.awt.Dimension(520, 100));
        mainPanel.setLayout(new java.awt.CardLayout());

        homePanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(38, 50, 56));
        jLabel2.setText("Selamat datang,");

        txtNama.setFont(new java.awt.Font("Lato", 0, 36)); // NOI18N
        txtNama.setForeground(new java.awt.Color(38, 50, 56));
        txtNama.setText("Nama");

        pengeluaranBtn.setBackground(new java.awt.Color(255, 229, 153));
        pengeluaranBtn.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
        pengeluaranBtn.setForeground(new java.awt.Color(246, 62, 94));
        pengeluaranBtn.setText("Tambah Pengeluaran");
        pengeluaranBtn.setBorder(null);
        pengeluaranBtn.setBorderPainted(false);
        pengeluaranBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pengeluaranBtnActionPerformed(evt);
            }
        });

        pemasukanBtn.setBackground(new java.awt.Color(255, 229, 153));
        pemasukanBtn.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
        pemasukanBtn.setForeground(new java.awt.Color(38, 50, 56));
        pemasukanBtn.setText("Tambah Pemasukan");
        pemasukanBtn.setBorder(null);
        pemasukanBtn.setBorderPainted(false);
        pemasukanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pemasukanBtnActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 229, 153));

        jLabel8.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(38, 50, 56));
        jLabel8.setText("UANGKU");

        txtTotal.setFont(new java.awt.Font("Lato", 0, 36)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(38, 50, 56));
        txtTotal.setText("Rp 574000");

        jSeparator1.setBackground(new java.awt.Color(38, 50, 56));

        txtPemasukan.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        txtPemasukan.setForeground(new java.awt.Color(47, 128, 237));
        txtPemasukan.setText("600000");

        txtPengeluaran.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        txtPengeluaran.setForeground(new java.awt.Color(246, 61, 94));
        txtPengeluaran.setText("26000");

        jLabel14.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(38, 50, 56));
        jLabel14.setText("Pengeluaran");

        jLabel12.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(38, 50, 56));
        jLabel12.setText("Pemasukan");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPengeluaran))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 82, Short.MAX_VALUE)
                        .addComponent(txtTotal))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPemasukan)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPemasukan)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPengeluaran)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 229, 153));
        jPanel6.setPreferredSize(new java.awt.Dimension(270, 200));

        jLabel9.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(38, 50, 56));
        jLabel9.setText("Pengeluaran");

        tablePengeluaran.setBackground(new java.awt.Color(255, 229, 153));
        tablePengeluaran.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePengeluaran.setFocusable(false);
        tablePengeluaran.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(tablePengeluaran);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(183, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(170, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(36, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jPanel7.setBackground(new java.awt.Color(255, 229, 153));
        jPanel7.setPreferredSize(new java.awt.Dimension(270, 200));

        jLabel10.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(38, 50, 56));
        jLabel10.setText("Pemasukan");

        tablePemasukan.setBackground(new java.awt.Color(255, 229, 153));
        tablePemasukan.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePemasukan.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(tablePemasukan);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 172, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pemasukanBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pengeluaranBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(txtNama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                        .addComponent(pemasukanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pengeluaranBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)))
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        mainPanel.add(homePanel, "card2");

        reportPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jLabel4.setText("Laporan keuangan");

        TotalPanel.setBackground(new java.awt.Color(255, 229, 153));
        TotalPanel.setPreferredSize(new java.awt.Dimension(559, 200));
        TotalPanel.setLayout(new javax.swing.BoxLayout(TotalPanel, javax.swing.BoxLayout.LINE_AXIS));

        PengeluaranPanel.setBackground(new java.awt.Color(255, 229, 153));
        PengeluaranPanel.setPreferredSize(new java.awt.Dimension(270, 200));
        PengeluaranPanel.setLayout(new javax.swing.BoxLayout(PengeluaranPanel, javax.swing.BoxLayout.LINE_AXIS));

        PemasukanPanel.setBackground(new java.awt.Color(255, 229, 153));
        PemasukanPanel.setPreferredSize(new java.awt.Dimension(270, 200));
        PemasukanPanel.setLayout(new javax.swing.BoxLayout(PemasukanPanel, javax.swing.BoxLayout.LINE_AXIS));

        txtMonth.setFont(new java.awt.Font("Lato", 0, 36)); // NOI18N
        txtMonth.setForeground(new java.awt.Color(38, 50, 56));
        txtMonth.setText("Januari, 2020");

        javax.swing.GroupLayout reportPanelLayout = new javax.swing.GroupLayout(reportPanel);
        reportPanel.setLayout(reportPanelLayout);
        reportPanelLayout.setHorizontalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TotalPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(reportPanelLayout.createSequentialGroup()
                        .addComponent(PengeluaranPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PemasukanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(reportPanelLayout.createSequentialGroup()
                        .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtMonth))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        reportPanelLayout.setVerticalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMonth)
                .addGap(23, 23, 23)
                .addComponent(TotalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PengeluaranPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PemasukanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        mainPanel.add(reportPanel, "card3");

        planningPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jLabel5.setText("Perencanaan anggaran");

        jPanel3.setBackground(new java.awt.Color(255, 229, 153));

        jLabel6.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(38, 50, 56));
        jLabel6.setText("Rencana");

        tableRencana.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Jumlah", "Tanggal", "Keterangan"
            }
        ));
        jScrollPane1.setViewportView(tableRencana);

        btnBayarAng.setBackground(new java.awt.Color(255, 255, 255));
        btnBayarAng.setText("Bayar");
        btnBayarAng.setBorder(null);
        btnBayarAng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarAngActionPerformed(evt);
            }
        });

        btnUbahAng.setBackground(new java.awt.Color(255, 255, 255));
        btnUbahAng.setText("Ubah");
        btnUbahAng.setBorder(null);
        btnUbahAng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahAngActionPerformed(evt);
            }
        });

        btnHapusAng.setBackground(new java.awt.Color(255, 255, 255));
        btnHapusAng.setText("Hapus");
        btnHapusAng.setBorder(null);
        btnHapusAng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusAngActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnBayarAng, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUbahAng, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapusAng, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHapusAng, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBayarAng, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUbahAng, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 229, 153));

        jLabel7.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(38, 50, 56));
        jLabel7.setText("Terbayarkan");

        tableTerbayar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Jumlah", "Tanggal", "Keterangan"
            }
        ));
        jScrollPane2.setViewportView(tableTerbayar);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        btnTambahRe.setBackground(new java.awt.Color(255, 229, 153));
        btnTambahRe.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
        btnTambahRe.setForeground(new java.awt.Color(38, 50, 56));
        btnTambahRe.setText("Tambah Rencana/Tagihan");
        btnTambahRe.setBorder(null);
        btnTambahRe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahReActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout planningPanelLayout = new javax.swing.GroupLayout(planningPanel);
        planningPanel.setLayout(planningPanelLayout);
        planningPanelLayout.setHorizontalGroup(
            planningPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planningPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(planningPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(planningPanelLayout.createSequentialGroup()
                        .addGroup(planningPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTambahRe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 268, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        planningPanelLayout.setVerticalGroup(
            planningPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planningPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(btnTambahRe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(planningPanel, "card4");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uangkuapplication/view/assets/Group 1.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        homeBtn.setBackground(new java.awt.Color(255, 229, 153));
        homeBtn.setFont(new java.awt.Font("Lato", 1, 11)); // NOI18N
        homeBtn.setForeground(new java.awt.Color(38, 50, 56));
        homeBtn.setText("Beranda");
        homeBtn.setBorder(null);
        homeBtn.setBorderPainted(false);
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        planningBtn.setBackground(new java.awt.Color(255, 229, 153));
        planningBtn.setFont(new java.awt.Font("Lato", 1, 11)); // NOI18N
        planningBtn.setForeground(new java.awt.Color(38, 50, 56));
        planningBtn.setText("Perencanaan");
        planningBtn.setBorder(null);
        planningBtn.setBorderPainted(false);
        planningBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planningBtnActionPerformed(evt);
            }
        });

        reportBtn.setBackground(new java.awt.Color(255, 229, 153));
        reportBtn.setFont(new java.awt.Font("Lato", 1, 11)); // NOI18N
        reportBtn.setForeground(new java.awt.Color(38, 50, 56));
        reportBtn.setText("Laporan");
        reportBtn.setBorder(null);
        reportBtn.setBorderPainted(false);
        reportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportBtnActionPerformed(evt);
            }
        });

        addCategoryBtn.setBackground(new java.awt.Color(255, 229, 153));
        addCategoryBtn.setFont(new java.awt.Font("Lato", 1, 11)); // NOI18N
        addCategoryBtn.setForeground(new java.awt.Color(38, 50, 56));
        addCategoryBtn.setText("Kategori");
        addCategoryBtn.setBorder(null);
        addCategoryBtn.setBorderPainted(false);
        addCategoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategoryBtnActionPerformed(evt);
            }
        });

        profileBtn.setBackground(new java.awt.Color(255, 229, 153));
        profileBtn.setFont(new java.awt.Font("Lato", 1, 11)); // NOI18N
        profileBtn.setForeground(new java.awt.Color(38, 50, 56));
        profileBtn.setText("Ubah profil");
        profileBtn.setBorder(null);
        profileBtn.setBorderPainted(false);
        profileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBtnActionPerformed(evt);
            }
        });

        logoutBtn.setBackground(new java.awt.Color(235, 87, 87));
        logoutBtn.setFont(new java.awt.Font("Lato", 1, 11)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Keluar");
        logoutBtn.setBorder(null);
        logoutBtn.setBorderPainted(false);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(planningBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reportBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addCategoryBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(profileBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(planningBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addCategoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(homePanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_homeBtnActionPerformed

    private void planningBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planningBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(planningPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_planningBtnActionPerformed

    private void reportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        
        donutChartList.clear();
        donutChartKategoriListMasuk.clear();
        donutChartNominalListMasuk.clear();
        donutChartKategoriListKeluar.clear();
        donutChartNominalListKeluar.clear();        
        
        areaChartList.clear();
        dateAreaChartListMasuk.clear();
        nominalAreaChartListMasuk.clear();
        dateAreaChartListKeluar.clear();
        nominalAreaChartListKeluar.clear();
        
        donutChartList = controller.getDonutChartData();
        areaChartList = controller.getAreaChartData();
        
        if(!donutChartList.isEmpty())
        for(int i = 0; i < donutChartList.size(); i++){
            if(donutChartList.get(i).getJenis_transaksi().equals("Masuk")){
                donutChartKategoriListMasuk.add(donutChartList.get(i).getKategori());
                donutChartNominalListMasuk.add(donutChartList.get(i).getNominal());
            }else{
                donutChartKategoriListKeluar.add(donutChartList.get(i).getKategori());
                donutChartNominalListKeluar.add(donutChartList.get(i).getNominal());
            }
        }
        
        if(!areaChartList.isEmpty()){
        for(int i = 0; i < areaChartList.size(); i++){
            if(areaChartList.get(i).getJenis_transaksi().equals("Masuk")){
                dateAreaChartListMasuk.add(areaChartList.get(i).getTgl_transaksi());
                nominalAreaChartListMasuk.add(areaChartList.get(i).getNominal());
            }else{
                dateAreaChartListKeluar.add(areaChartList.get(i).getTgl_transaksi());
                nominalAreaChartListKeluar.add(areaChartList.get(i).getNominal());
            }
        }
        txtMonth.setText(StringMonth(
                new java.util.Date(areaChartList.get(0).getTgl_transaksi().getTime()).getMonth()
                )+ ", "+
                areaChartList.get(0).getTgl_transaksi().toLocalDate().getYear()
        );
        }
        
        
        
        
// 
        
        xChart = this;
        pemasukanChart = xChart.getPemasukanChart();
        pengeluaranChart = xChart.getPengeluaranChart();
        pemasukanChartPanel = new XChartPanel(pemasukanChart);
        PemasukanPanel.removeAll();
        PemasukanPanel.add(pemasukanChartPanel);
        PemasukanPanel.validate();
        
        
        pengeluaranChartPanel = new XChartPanel(pengeluaranChart);
        PengeluaranPanel.removeAll();
        PengeluaranPanel.add(pengeluaranChartPanel);
        PengeluaranPanel.revalidate();
        
        totalChart = xChart.getTotalChart();
        totalChartPanel = new XChartPanel(totalChart);
        TotalPanel.removeAll();
        TotalPanel.add(totalChartPanel);
        TotalPanel.validate();
         
      //PemasukanPanel.add(pemasukanChartPanel);
      //PemasukanPanel.validate();
        mainPanel.add(reportPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
        //TotalPanel.validate();
    }//GEN-LAST:event_reportBtnActionPerformed

    String StringMonth(int m){
        switch(m){
            case 0 : return "Januari";
            case 1 : return "Februari";
            case 2 : return "Maret";
            case 3 : return "April";
            case 4 : return "Mei";
            case 5 : return "Juni";
            case 6 : return "Juli";
            case 7 : return "Agustus";
            case 8 : return "September";
            case 9 : return "Oktober";
            case 10 : return "November";
            case 11 : return "Desember";
        }
        return "";
    }
    private void addCategoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCategoryBtnActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    KategoriFrame kategori = new KategoriFrame();
                    kategori.loadDatabase();
                    kategori.setVisible(true);
                } catch (SQLException e) {
                } catch (KategoriException ex) {
                    java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }//GEN-LAST:event_addCategoryBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        UangkuApplication.prefs.remove("UserFullName");
        UangkuApplication.prefs.remove("isLoggedIn");
        UangkuApplication.prefs.remove("UserID");
        UangkuApplication.prefs.remove("Uang");
        LoginFrame login = new LoginFrame();
        this.setVisible(false);
        
        
        instance = null;
        PemasukanFrame.getInstance().deleteInstance();
        PengeluaranFrame.getInstance().deleteInstance();
        AnggaranFrame.getInstance().deleteInstance();
        
        
        
        
        
        
        login.setVisible(true);
        
        
        
        
        
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void pengeluaranBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pengeluaranBtnActionPerformed
        // TODO add your handling code here:
        PengeluaranFrame.getInstance().setVisible(true);
    }//GEN-LAST:event_pengeluaranBtnActionPerformed

    private void pemasukanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pemasukanBtnActionPerformed
        // TODO add your handling code here:

        PemasukanFrame.getInstance().setVisible(true);
    }//GEN-LAST:event_pemasukanBtnActionPerformed

    private void profileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBtnActionPerformed
        // TODO add your handling code here:
        ProfilFrame profil = new ProfilFrame();
        profil.setVisible(true);
    }//GEN-LAST:event_profileBtnActionPerformed

    private void btnTambahReActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahReActionPerformed
        // TODO add your handling code here:
        AnggaranFrame.getInstance().setVisible(true);
    }//GEN-LAST:event_btnTambahReActionPerformed

    private void btnUbahAngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahAngActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbahAngActionPerformed

    private void btnBayarAngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarAngActionPerformed
        // TODO add your handling code here:
        AnggaranFrame.getInstance().controller.updateRencana(AnggaranFrame.getInstance());
        
        
        AnggaranFrame.getInstance().modelTableRencana.remove(tableRencana.getSelectedRow());
        //AnggaranFrame.getInstance().modelTableTerbayar.add(tableRencana.getSelectedRow());

    }//GEN-LAST:event_btnBayarAngActionPerformed

    private void btnHapusAngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusAngActionPerformed
        // TODO add your handling code here:
        AnggaranFrame.getInstance().controller.deleteRencana(AnggaranFrame.getInstance());
        AnggaranFrame.getInstance().modelTableRencana.remove(tableRencana.getSelectedRow());
    }//GEN-LAST:event_btnHapusAngActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()  {
                
                new MainFrame(name).setVisible(true);
                
                
                
                
                
           }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PemasukanPanel;
    private javax.swing.JPanel PengeluaranPanel;
    private javax.swing.JPanel TotalPanel;
    private javax.swing.JButton addCategoryBtn;
    private javax.swing.JButton btnBayarAng;
    private javax.swing.JButton btnHapusAng;
    private javax.swing.JButton btnTambahRe;
    private javax.swing.JButton btnUbahAng;
    private javax.swing.JButton homeBtn;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton pemasukanBtn;
    private javax.swing.JButton pengeluaranBtn;
    private javax.swing.JButton planningBtn;
    private javax.swing.JPanel planningPanel;
    private javax.swing.JButton profileBtn;
    private javax.swing.JButton reportBtn;
    private javax.swing.JPanel reportPanel;
    private javax.swing.JTable tablePemasukan;
    private javax.swing.JTable tablePengeluaran;
    private javax.swing.JTable tableRencana;
    private javax.swing.JTable tableTerbayar;
    private javax.swing.JLabel txtMonth;
    private javax.swing.JLabel txtNama;
    private javax.swing.JLabel txtPemasukan;
    private javax.swing.JLabel txtPengeluaran;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        JOptionPane.showMessageDialog(null, "Select");
        throw new UnsupportedOperationException("Select Siapa."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onChange(ModelTransaksi model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onInsert(EntityTransaksi transaksi) {
        
        throw new UnsupportedOperationException("Not Supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onUpdate(EntityTransaksi transaksi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PieChart getPemasukanChart() {
        // Create Chart
        PieChart chart = createDonutChart();
        chart.setTitle("Pemasukan");
        // Series
//        chart.addSeries("Makan", 10);
//        chart.addSeries("Tidur", 22);
 //       chart.addSeries("Mandi", 21);
// 


        for(int i = 0; i<donutChartKategoriListMasuk.size(); i++){
            chart.addSeries(donutChartKategoriListMasuk.get(i), donutChartNominalListMasuk.get(i));
        }

        return chart;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public PieChart getPengeluaranChart() {
        // Create Chart
        PieChart chart = createDonutChart();
        chart.setTitle("Pengeluaran");
        
        // Series
        //chart.addSeries("Makan", 9);
        //chart.addSeries("Tidur", 10);
        //chart.addSeries("Mandi", 34);

        for(int i = 0; i<donutChartKategoriListKeluar.size(); i++){
            chart.addSeries(donutChartKategoriListKeluar.get(i), donutChartNominalListKeluar.get(i));
        }
       

        return chart;
    }

    @Override
    public XYChart getTotalChart() {
        
        // Create Chart
        XYChart chart = createTotalChart();

        // Customize Chart

        // Series
//        List<Date> xData = new ArrayList<Date>();
//        List<Double> yData = new ArrayList<Double>();
//
//
//        DateFormat sdf = new SimpleDateFormat("MM-dd");
//        Date date = null;
//        for (int i = 1; i <= 14; i++) {
//
//          xData.add(date);
//          yData.add(Math.random() * i / -100000000);
//        }
        if(dateAreaChartListMasuk.size() > 0 && dateAreaChartListKeluar.size() > 0){
            chart.addSeries("Pemasukan", dateAreaChartListMasuk, nominalAreaChartListMasuk);
            chart.addSeries("Pengeluaran", dateAreaChartListKeluar, nominalAreaChartListKeluar);
        }
        return chart;
    }
    

    public XYChart createTotalChart(){
        // Create Chart
        XYChart chart =
            new XYChartBuilder()
                .width(559)
                .height(200)
                .title("Pemasukan dan Pengeluaran per Bulan")
                .xAxisTitle("Tanggal")
                .yAxisTitle("Jumlah")
                .build();

        // Customize Chart
        //chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
        chart.getStyler().setLegendVisible(false);
        
        chart.getStyler().setAxisTitlesVisible(false);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);
        chart.getStyler().setPlotBorderVisible(false);
        chart.getStyler().setPlotBackgroundColor(color);
        chart.getStyler().setChartBackgroundColor(color);
        chart.getStyler().setSeriesColors(colorSet);
        return chart;
    }
    
    public PieChart createDonutChart(){
        PieChart chart =
            new PieChartBuilder().width(270).height(200).build();
        //chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSE);
        //chart.getStyler().setLegendLayout(Styler.LegendLayout.Horizontal);

        // Customize Chart color [255,229,153]
        chart.getStyler().setLegendVisible(false);
        
        chart.getStyler().setAnnotationType(AnnotationType.Label);
        chart.getStyler().setAnnotationDistance(1.2);
        chart.getStyler().setPlotBorderVisible(false);
        chart.getStyler().setPlotBackgroundColor(color);
        chart.getStyler().setChartBackgroundColor(color);
        chart.getStyler().setPlotContentSize(.80);
        
        chart.getStyler().setDefaultSeriesRenderStyle(PieSeriesRenderStyle.Donut);
        //chart.getStyler().setCircular(false);
        return chart;
    }
    
 

    
}
