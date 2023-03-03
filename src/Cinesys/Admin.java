
package Cinesys;

import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;


public class Admin extends javax.swing.JFrame {
    
    PreparedStatement ps;
    ResultSet rs;
    String filename = null;
    byte[] person_image = null;
   
    public Admin() {
        initComponents();
        Database.connect();
        movielist_load();
        tab1.setBackground(new Color(238,214,194));
        first.setVisible(true);
        second.setVisible(false);
        third.setVisible(false);
        fourth.setVisible(false);
        this.setLocationRelativeTo(null); //center fom in the screen
        
        
        
        
    }
    
     //this will display the movie list table
    void movielist_load(){
        try {
            ps = Database.connect().prepareStatement("SELECT `movieID`, `Movie Title`, `Timeslot 1`, `Timeslot 2`, `Timeslot 3` FROM `movielist` ");
            ResultSet rs = ps.executeQuery();
            movietable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tab1 = new javax.swing.JPanel();
        dashboard = new javax.swing.JLabel();
        tab2 = new javax.swing.JPanel();
        customers = new javax.swing.JLabel();
        tab3 = new javax.swing.JPanel();
        edit = new javax.swing.JLabel();
        tab4 = new javax.swing.JPanel();
        signout = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        first = new javax.swing.JPanel();
        second = new javax.swing.JPanel();
        third = new javax.swing.JPanel();
        lbl_image = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        txtmname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtts1 = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        txtts2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        movietable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtmid = new javax.swing.JTextField();
        txtts3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        fourth = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(227, 183, 120));

        tab1.setBackground(new java.awt.Color(227, 183, 120));
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        dashboard.setBackground(new java.awt.Color(255, 255, 255));
        dashboard.setFont(new java.awt.Font("Figtree Light", 0, 20)); // NOI18N
        dashboard.setForeground(new java.awt.Color(102, 32, 42));
        dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/dashboard.png"))); // NOI18N
        dashboard.setText("Dashboard");
        dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(91, 91, 91))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab2.setBackground(new java.awt.Color(227, 183, 120));
        tab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab2MouseClicked(evt);
            }
        });

        customers.setBackground(new java.awt.Color(255, 255, 255));
        customers.setFont(new java.awt.Font("Figtree Light", 0, 20)); // NOI18N
        customers.setForeground(new java.awt.Color(102, 32, 42));
        customers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/customer.png"))); // NOI18N
        customers.setText("Customers");
        customers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(customers)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customers, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab3.setBackground(new java.awt.Color(227, 183, 120));
        tab3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab3MouseClicked(evt);
            }
        });

        edit.setBackground(new java.awt.Color(255, 255, 255));
        edit.setFont(new java.awt.Font("Figtree Light", 0, 20)); // NOI18N
        edit.setForeground(new java.awt.Color(102, 32, 42));
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit screening.png"))); // NOI18N
        edit.setText("Edit screening");
        edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(56, 56, 56))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab4.setBackground(new java.awt.Color(227, 183, 120));
        tab4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab4MouseClicked(evt);
            }
        });

        signout.setBackground(new java.awt.Color(255, 255, 255));
        signout.setFont(new java.awt.Font("Figtree Light", 0, 20)); // NOI18N
        signout.setForeground(new java.awt.Color(102, 32, 42));
        signout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/signout.png"))); // NOI18N
        signout.setText("Sign out");
        signout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout tab4Layout = new javax.swing.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(signout, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(101, 101, 101))
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(signout, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 32, 42));
        jLabel5.setText("Welcome");

        jLabel6.setFont(new java.awt.Font("Figtree", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 32, 42));
        jLabel6.setText("admin");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_edit_user_80px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(110, 110, 110))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tab4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new javax.swing.OverlayLayout(jPanel2));

        first.setBackground(new java.awt.Color(238, 214, 194));

        javax.swing.GroupLayout firstLayout = new javax.swing.GroupLayout(first);
        first.setLayout(firstLayout);
        firstLayout.setHorizontalGroup(
            firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1176, Short.MAX_VALUE)
        );
        firstLayout.setVerticalGroup(
            firstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );

        jPanel2.add(first);

        second.setBackground(new java.awt.Color(233, 201, 174));

        javax.swing.GroupLayout secondLayout = new javax.swing.GroupLayout(second);
        second.setLayout(secondLayout);
        secondLayout.setHorizontalGroup(
            secondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1176, Short.MAX_VALUE)
        );
        secondLayout.setVerticalGroup(
            secondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );

        jPanel2.add(second);

        third.setBackground(new java.awt.Color(238, 214, 194));

        lbl_image.setBackground(new java.awt.Color(51, 51, 51));
        lbl_image.setForeground(new java.awt.Color(153, 51, 255));
        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/poster.png"))); // NOI18N
        lbl_image.setMaximumSize(new java.awt.Dimension(226, 355));
        lbl_image.setMinimumSize(new java.awt.Dimension(226, 355));
        lbl_image.setName(""); // NOI18N
        lbl_image.setPreferredSize(new java.awt.Dimension(226, 355));

        jLabel1.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 32, 42));
        jLabel1.setText("MovieID:");

        addButton.setBackground(new java.awt.Color(102, 32, 42));
        addButton.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add.png"))); // NOI18N
        addButton.setText("Add");
        addButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 32, 42));
        jLabel2.setText("Movie Name:");

        updateButton.setBackground(new java.awt.Color(102, 32, 42));
        updateButton.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update.png"))); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        txtmname.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 32, 42));
        jLabel3.setText("Timeslot 1:");

        txtts1.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N

        deleteButton.setBackground(new java.awt.Color(102, 32, 42));
        deleteButton.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete.png"))); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        txtts2.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 32, 42));
        jLabel4.setText("Timeslot 2:");

        movietable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        movietable.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        movietable.setForeground(new java.awt.Color(102, 32, 42));
        movietable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "movieID", "Movie Title", "timeslot 1", "timeslot 2", "timeslot 3"
            }
        ));
        movietable.setGridColor(new java.awt.Color(225, 184, 120));
        movietable.setRowHeight(25);
        movietable.setSelectionBackground(new java.awt.Color(227, 183, 120));
        movietable.getTableHeader().setReorderingAllowed(false);
        movietable.getTableHeader().setFont(new Font("Figtree Light", Font.PLAIN, 18));
        movietable.getTableHeader().setOpaque(false);
        movietable.getTableHeader().setBackground(new Color(255,229,206));
        movietable.getTableHeader().setForeground(new Color(102,32,42));
        jScrollPane1.setViewportView(movietable);

        jLabel8.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 32, 42));
        jLabel8.setText("Timeslot 3:");

        txtmid.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N

        txtts3.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N

        jButton1.setBackground(new java.awt.Color(102, 32, 42));
        jButton1.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/upload.png"))); // NOI18N
        jButton1.setText("Upload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(102, 32, 42));
        searchButton.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/transparency.png"))); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout thirdLayout = new javax.swing.GroupLayout(third);
        third.setLayout(thirdLayout);
        thirdLayout.setHorizontalGroup(
            thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thirdLayout.createSequentialGroup()
                .addGroup(thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(thirdLayout.createSequentialGroup()
                        .addGroup(thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(thirdLayout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(thirdLayout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(jButton1)))
                        .addGap(87, 87, 87)
                        .addGroup(thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(thirdLayout.createSequentialGroup()
                                    .addGroup(thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addGroup(thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel4))
                                        .addComponent(jLabel1))
                                    .addGap(100, 100, 100)
                                    .addGroup(thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(thirdLayout.createSequentialGroup()
                                            .addComponent(txtmid, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(searchButton))
                                        .addGroup(thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtmname, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtts2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtts1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtts3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thirdLayout.createSequentialGroup()
                                    .addGap(221, 221, 221)
                                    .addComponent(addButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(deleteButton)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thirdLayout.createSequentialGroup()
                                .addComponent(updateButton)
                                .addGap(65, 65, 65))))
                    .addGroup(thirdLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        thirdLayout.setVerticalGroup(
            thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thirdLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thirdLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addGroup(thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtmid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton))
                        .addGap(41, 41, 41)
                        .addGroup(thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtts1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(17, 17, 17)
                        .addGroup(thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtts2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtts3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(35, 35, 35)
                        .addGroup(thirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton)
                            .addComponent(deleteButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateButton)
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thirdLayout.createSequentialGroup()
                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)
                        .addGap(139, 139, 139))))
        );

        jPanel2.add(third);

        fourth.setBackground(new java.awt.Color(239, 220, 204));

        javax.swing.GroupLayout fourthLayout = new javax.swing.GroupLayout(fourth);
        fourth.setLayout(fourthLayout);
        fourthLayout.setHorizontalGroup(
            fourthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1176, Short.MAX_VALUE)
        );
        fourthLayout.setVerticalGroup(
            fourthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );

        jPanel2.add(fourth);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab1MouseClicked
        first.setVisible(true);
        second.setVisible(false);
        third.setVisible(false);
        fourth.setVisible(false);
        tab1.setBackground(new Color(238,214,194));
        tab2.setBackground(new Color (227,183,120));
        tab3.setBackground(new Color (227,183,120));
        tab4.setBackground(new Color (227,183,120));
       
    }//GEN-LAST:event_tab1MouseClicked

    private void tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2MouseClicked
        first.setVisible(false);
        second.setVisible(true);
        third.setVisible(false);
        fourth.setVisible(false);
        tab2.setBackground(new Color(233,201,174));
        tab1.setBackground(new Color (227,183,120));
        tab3.setBackground(new Color (227,183,120));
        tab4.setBackground(new Color (227,183,120));
    }//GEN-LAST:event_tab2MouseClicked

    private void tab3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab3MouseClicked
        third.setVisible(true);
        first.setVisible(false);
        second.setVisible(false);
        fourth.setVisible(false);
        tab3.setBackground(new Color(238,214,194));
        tab1.setBackground(new Color (227,183,120));
        tab2.setBackground(new Color (227,183,120));
        tab4.setBackground(new Color (227,183,120));
    }//GEN-LAST:event_tab3MouseClicked

    private void tab4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab4MouseClicked
        fourth.setVisible(true);
        first.setVisible(false);
        second.setVisible(false);
        third.setVisible(false);
        tab4.setBackground(new Color(239,220,204));
        tab1.setBackground(new Color (227,183,120));
        tab2.setBackground(new Color (227,183,120));
        tab3.setBackground(new Color (227,183,120));
    }//GEN-LAST:event_tab4MouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // add movie to the database
        String mname, ts1, ts2, ts3;
        mname = txtmname.getText();
        ts1 = txtts1.getText();
        ts2 = txtts2.getText();
        ts3 = txtts3.getText();

        try {
            ps = Database.connect().prepareStatement("INSERT INTO `movielist`(`Movie Title`, `Timeslot 1`, `Timeslot 2`, `Timeslot 3`, `image`) VALUES (?,?,?,?,?)");
            ps.setString(1, mname);
            ps.setString(2, ts1);
            ps.setString(3, ts2);
            ps.setString(4, ts3);
            ps.setBytes(5, person_image);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Record Added");
            movielist_load();
            txtmname.setText("");
            txtts1.setText("");
            txtts2.setText("");
            txtts3.setText("");
            txtmname.requestFocus();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        //update movie details from the table database
        String mid,mname,ts1,ts2,ts3;
        mid = txtmid.getText();
        mname = txtmname.getText();
        ts1 = txtts1.getText();
        ts2 = txtts2.getText();
        ts3 = txtts3.getText();
        try{
            ps = Database.connect().prepareStatement("UPDATE `movielist` SET `Movie Title`= ?,`Timeslot 1`= ?,`Timeslot 2`= ?,`Timeslot 3`= ?,`image`= ? WHERE `movieID` = ?");
            ps.setString(1, mname);
            ps.setString(2, ts1);
            ps.setString(3, ts2);
            ps.setString(4, ts3);
            ps.setBytes(5, person_image);
            ps.setString(6, mid);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Record Updated");
            movielist_load();
            txtmname.setText("");
            txtts1.setText("");
            txtts2.setText("");
            txtts3.setText("");
            txtmid.setText("");
            txtmname.requestFocus();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        //delete movie from the list
        String mid;
        mid = txtmid.getText();

        try{
            ps = Database.connect().prepareStatement("DELETE FROM `movielist` WHERE `movieID` = ?");
            ps.setString(1, mid);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Record Deleted");
            movielist_load();
            txtmname.setText("");
            txtts1.setText("");
            txtts2.setText("");
            txtts3.requestFocus();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lbl_image.getWidth(),lbl_image.getHeight(), Image.SCALE_SMOOTH));
        lbl_image.setIcon(imageIcon);
        try{
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum;(readNum =fis.read(buf)) != -1;){
                bos.write(buf, 0, readNum);

            }
            person_image = bos.toByteArray();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        //search and select movie from the tables
        String mid,mname,ts1,ts2,ts3;
        mid = txtmid.getText();

        try{
            ps = Database.connect().prepareStatement("SELECT `Movie Title`, `Timeslot 1`, `Timeslot 2`, `Timeslot 3`, `image` FROM `movielist` WHERE `movieID` = ?");
            ps.setString(1, mid);
            ResultSet rs = ps.executeQuery();

            if(rs.next() == true){

                mname = rs.getString(1);
                ts1 = rs.getString(2);
                ts2 = rs.getString(3);
                ts3 = rs.getString(4);
                byte[] img = rs.getBytes(5);
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lbl_image.getWidth(),lbl_image.getHeight(), Image.SCALE_SMOOTH));
                lbl_image.setIcon(imageIcon);

                txtmname.setText(mname);
                txtts1.setText(ts1);
                txtts2.setText(ts2);
                txtts3.setText(ts3);

            }
            else{
                txtmname.setText("");
                txtts1.setText("");
                txtts2.setText("");
                txtts3.setText("");
                JOptionPane.showMessageDialog(null, "Invalid Movie ID");
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel customers;
    private javax.swing.JLabel dashboard;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel edit;
    private javax.swing.JPanel first;
    private javax.swing.JPanel fourth;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JTable movietable;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel second;
    private javax.swing.JLabel signout;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JPanel third;
    private javax.swing.JTextField txtmid;
    private javax.swing.JTextField txtmname;
    private javax.swing.JTextField txtts1;
    private javax.swing.JTextField txtts2;
    private javax.swing.JTextField txtts3;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
