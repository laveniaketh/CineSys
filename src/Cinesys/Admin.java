package Cinesys;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        dashboardP.setVisible(true);
        customersP.setVisible(false);
        editscreeningP.setVisible(false);
        this.setLocationRelativeTo(null); //center fom in the screen
        nowShowingPosters();
        try {
            ps = Database.connect().prepareStatement("SELECT * FROM `movielist`");
            rs = ps.executeQuery();
                while(rs.next()){
                    movielistcbbox.addItem(rs.getString("Movie Title")); 
                }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        try {
            // to count and display number of tickets sold
            ps = Database.connect().prepareStatement("SELECT COUNT(`Ticket No.`) FROM customerlist;");
            rs = ps.executeQuery();
            if(rs.next()){
                int rowCount = rs.getInt("COUNT(`Ticket No.`)");
                ticketlbl.setText(Integer. toString(rowCount));
                
                //to calculate and display the total sales;
                int total = (rowCount * 200);
                lbltotalsales.setText(Integer. toString(total));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    void nowShowingPosters(){
        //show movie posters at the dashboard
        ArrayList <String> movieList = new ArrayList();
        try {
            ps = Database.connect().prepareStatement("SELECT * FROM `movielist`");
            rs = ps.executeQuery();
            while(rs.next()){
                movieList.add(rs.getString("Movie Title"));  
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        String mname = "";
        for(int i = 0 ; i < movieList.size(); i++){
            mname = movieList.get(i);
                try {
                    ps = Database.connect().prepareStatement("SELECT `image` FROM `movielist` WHERE `Movie Title`=?");
                    ps.setString(1, mname);
                    rs = ps.executeQuery();
                    while(rs.next() == true){
                        if(i == 0){
                            byte[] img = rs.getBytes(1);
                            ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblposter1.getWidth(),lblposter1.getHeight(), Image.SCALE_SMOOTH));
                            lblposter1.setIcon(imageIcon);
                        }else if ( i == 1){
                            byte[] img = rs.getBytes(1);
                            ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblposter2.getWidth(),lblposter2.getHeight(), Image.SCALE_SMOOTH));
                            lblposter2.setIcon(imageIcon);   
                        }else if (i ==2){
                            byte[] img = rs.getBytes(1);
                            ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblposter3.getWidth(),lblposter3.getHeight(), Image.SCALE_SMOOTH));
                            lblposter3.setIcon(imageIcon);  
                        }else if( i == 3){
                            byte[] img = rs.getBytes(1);
                            ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblposter4.getWidth(),lblposter4.getHeight(), Image.SCALE_SMOOTH));
                            lblposter4.setIcon(imageIcon);  
                        }
                        
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
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
    
    //this will display the customer list table
    void customerlist_load (){
        try {
            ps = Database.connect().prepareStatement("SELECT * FROM `customerlist`");
            ResultSet rs = ps.executeQuery();
            customertable.setModel(DbUtils.resultSetToTableModel(rs));
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
        dashboardP = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbltotalsales = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ticketlbl = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblposter1 = new javax.swing.JLabel();
        lblposter2 = new javax.swing.JLabel();
        lblposter3 = new javax.swing.JLabel();
        lblposter4 = new javax.swing.JLabel();
        customersP = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        customertable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        movielistcbbox = new javax.swing.JComboBox<>();
        timelistcbbox = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        editscreeningP = new javax.swing.JPanel();
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
        uploadB = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();

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

        dashboardP.setBackground(new java.awt.Color(238, 214, 194));

        jPanel3.setBackground(new java.awt.Color(227, 183, 120));
        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        lbltotalsales.setFont(new java.awt.Font("Figtree", 1, 48)); // NOI18N
        lbltotalsales.setForeground(new java.awt.Color(102, 32, 42));
        lbltotalsales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lbltotalsales);

        jLabel10.setFont(new java.awt.Font("Figtree", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 32, 42));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("TOTAL SALES");
        jPanel3.add(jLabel10);

        jPanel4.setBackground(new java.awt.Color(227, 183, 120));
        jPanel4.setLayout(new java.awt.GridLayout(2, 0));

        ticketlbl.setFont(new java.awt.Font("Figtree", 1, 48)); // NOI18N
        ticketlbl.setForeground(new java.awt.Color(102, 32, 42));
        ticketlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(ticketlbl);

        jLabel15.setFont(new java.awt.Font("Figtree", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 32, 42));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("NUMBER OF TICKETS SOLD");
        jPanel4.add(jLabel15);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/dollar.png"))); // NOI18N

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ticket.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Figtree", 1, 48)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 32, 42));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("NOW SHOWING");

        jPanel5.setBackground(new java.awt.Color(238, 214, 194));
        jPanel5.setLayout(new java.awt.GridLayout(1, 4, 20, 20));

        lblposter1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(lblposter1);

        lblposter2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(lblposter2);

        lblposter3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(lblposter3);

        lblposter4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(lblposter4);

        javax.swing.GroupLayout dashboardPLayout = new javax.swing.GroupLayout(dashboardP);
        dashboardP.setLayout(dashboardPLayout);
        dashboardPLayout.setHorizontalGroup(
            dashboardPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPLayout.createSequentialGroup()
                .addGroup(dashboardPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashboardPLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel16)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(jLabel13)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dashboardPLayout.createSequentialGroup()
                        .addGap(374, 374, 374)
                        .addComponent(jLabel17))
                    .addGroup(dashboardPLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        dashboardPLayout.setVerticalGroup(
            dashboardPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(dashboardPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dashboardPLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(27, 27, 27)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jPanel2.add(dashboardP);

        customersP.setBackground(new java.awt.Color(238, 214, 194));

        customertable.setBackground(new java.awt.Color(255, 255, 255));
        customertable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        customertable.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        customertable.setForeground(new java.awt.Color(102, 32, 42));
        customertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        customertable.setGridColor(new java.awt.Color(225, 184, 120));
        customertable.setRowHeight(25);
        customertable.setSelectionBackground(new java.awt.Color(227, 183, 120));
        customertable.getTableHeader().setReorderingAllowed(false);
        customertable.getTableHeader().setFont(new Font("Figtree Light", Font.PLAIN, 18));
        customertable.getTableHeader().setOpaque(false);
        customertable.getTableHeader().setBackground(new Color(255,229,206));
        customertable.getTableHeader().setForeground(new Color(102,32,42));
        jScrollPane3.setViewportView(customertable);

        jLabel11.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 32, 42));
        jLabel11.setText("Movie Name:");

        movielistcbbox.setBackground(new java.awt.Color(227, 183, 120));
        movielistcbbox.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        movielistcbbox.setForeground(new java.awt.Color(102, 32, 42));
        movielistcbbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "All Movies" }));
        movielistcbbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                movielistcbboxItemStateChanged(evt);
            }
        });
        movielistcbbox.setForeground(new java.awt.Color(102, 32, 42));

        timelistcbbox.setBackground(new java.awt.Color(227, 183, 120));
        timelistcbbox.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        timelistcbbox.setForeground(new java.awt.Color(102, 32, 42));
        timelistcbbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                timelistcbboxItemStateChanged(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 32, 42));
        jLabel12.setText("Time:");

        javax.swing.GroupLayout customersPLayout = new javax.swing.GroupLayout(customersP);
        customersP.setLayout(customersPLayout);
        customersPLayout.setHorizontalGroup(
            customersPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(customersPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(customersPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(movielistcbbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timelistcbbox, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(182, 182, 182))
        );
        customersPLayout.setVerticalGroup(
            customersPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customersPLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customersPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(customersPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movielistcbbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(36, 36, 36)
                .addGroup(customersPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timelistcbbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(319, 319, 319))
        );

        jPanel2.add(customersP);

        editscreeningP.setBackground(new java.awt.Color(238, 214, 194));

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

        movietable.setBackground(new java.awt.Color(255, 255, 255));
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

        uploadB.setBackground(new java.awt.Color(102, 32, 42));
        uploadB.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        uploadB.setForeground(new java.awt.Color(255, 255, 255));
        uploadB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/upload.png"))); // NOI18N
        uploadB.setText("Upload");
        uploadB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBActionPerformed(evt);
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

        javax.swing.GroupLayout editscreeningPLayout = new javax.swing.GroupLayout(editscreeningP);
        editscreeningP.setLayout(editscreeningPLayout);
        editscreeningPLayout.setHorizontalGroup(
            editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editscreeningPLayout.createSequentialGroup()
                .addGroup(editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editscreeningPLayout.createSequentialGroup()
                        .addGroup(editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editscreeningPLayout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(editscreeningPLayout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(uploadB)))
                        .addGap(87, 87, 87)
                        .addGroup(editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(editscreeningPLayout.createSequentialGroup()
                                    .addGroup(editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addGroup(editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel4))
                                        .addComponent(jLabel1))
                                    .addGap(100, 100, 100)
                                    .addGroup(editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(editscreeningPLayout.createSequentialGroup()
                                            .addComponent(txtmid, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(searchButton))
                                        .addGroup(editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtmname, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtts2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtts1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtts3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editscreeningPLayout.createSequentialGroup()
                                    .addGap(221, 221, 221)
                                    .addComponent(addButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(deleteButton)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editscreeningPLayout.createSequentialGroup()
                                .addComponent(updateButton)
                                .addGap(65, 65, 65))))
                    .addGroup(editscreeningPLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        editscreeningPLayout.setVerticalGroup(
            editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editscreeningPLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editscreeningPLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addGroup(editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtmid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton))
                        .addGap(41, 41, 41)
                        .addGroup(editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtts1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(17, 17, 17)
                        .addGroup(editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtts2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtts3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(35, 35, 35)
                        .addGroup(editscreeningPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton)
                            .addComponent(deleteButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateButton)
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editscreeningPLayout.createSequentialGroup()
                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(uploadB)
                        .addGap(139, 139, 139))))
        );

        jPanel2.add(editscreeningP);

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
        dashboardP.setVisible(true);
        customersP.setVisible(false);
        editscreeningP.setVisible(false);
        tab1.setBackground(new Color(238,214,194));
        tab2.setBackground(new Color (227,183,120));
        tab3.setBackground(new Color (227,183,120));
        tab4.setBackground(new Color (227,183,120));
       
    }//GEN-LAST:event_tab1MouseClicked

    private void tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2MouseClicked
        dashboardP.setVisible(false);
        customersP.setVisible(true);
        editscreeningP.setVisible(false);
        tab2.setBackground(new Color(238,214,194));
        tab1.setBackground(new Color (227,183,120));
        tab3.setBackground(new Color (227,183,120));
        tab4.setBackground(new Color (227,183,120));
    }//GEN-LAST:event_tab2MouseClicked

    private void tab3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab3MouseClicked
        editscreeningP.setVisible(true);
        dashboardP.setVisible(false);
        customersP.setVisible(false);
        tab3.setBackground(new Color(238,214,194));
        tab1.setBackground(new Color (227,183,120));
        tab2.setBackground(new Color (227,183,120));
        tab4.setBackground(new Color (227,183,120));
    }//GEN-LAST:event_tab3MouseClicked

    private void tab4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab4MouseClicked
        //to close the admin page
        this.setVisible(false);
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
        
        
        try {
            ps = Database.connect().prepareStatement("SELECT `image` FROM `movielist` WHERE `Movie Title`= ?");
            ps.setString(1, mname);
            rs = ps.executeQuery();
             if(rs.next() == true){
                 byte[] img = rs.getBytes(1);
                 ImageIcon imageIcon4 = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblposter4.getWidth(),lblposter4.getHeight(), Image.SCALE_SMOOTH));
                lblposter4.setIcon(imageIcon4);
                try{
                    ps = Database.connect().prepareStatement("UPDATE `movielist` SET `Movie Title`= ?,`Timeslot 1`= ?,`Timeslot 2`= ?,`Timeslot 3`= ?,`image`= ? WHERE `movieID` = ?");
                    ps.setString(1, mname);
                    ps.setString(2, ts1);
                    ps.setString(3, ts2);
                    ps.setString(4, ts3);
                    ps.setBytes(5, img);
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
                
             }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
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

    private void uploadBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadBActionPerformed
        //to choose and upload movie posters
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
    }//GEN-LAST:event_uploadBActionPerformed

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

    private void movielistcbboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_movielistcbboxItemStateChanged
        // TODO add your handling code here:
        timelistcbbox.removeAllItems();
        if(evt.getStateChange() == ItemEvent.SELECTED ){

            String selectedMovie = (String) movielistcbbox.getSelectedItem();
            if(selectedMovie.equals("All Movies")){
                customerlist_load();

            }else{

                String ts1,ts2,ts3;
                try {
                    ps = Database.connect().prepareStatement("SELECT `Timeslot 1`, `Timeslot 2`, `Timeslot 3`, `image` FROM `movielist` WHERE `Movie Title` = ?");
                    ps.setString(1, selectedMovie);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        ts1 = rs.getString(1);
                        ts2 = rs.getString(2);
                        ts3 = rs.getString(3);

                        timelistcbbox.addItem(ts1);
                        timelistcbbox.addItem(ts2);
                        timelistcbbox.addItem(ts3);

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }

        }
    }//GEN-LAST:event_movielistcbboxItemStateChanged

    private void timelistcbboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_timelistcbboxItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED ){
            String rmovie = (String) movielistcbbox.getSelectedItem();
            String rtime = (String) timelistcbbox.getSelectedItem();

            
            try {
                ps = Database.connect().prepareStatement("SELECT * FROM `customerlist` WHERE `Movie Ttile`= ? AND `Time` = ?");
                ps.setString(1, rmovie);
                ps.setString(2, rtime);

                ResultSet rs = ps.executeQuery();
                customertable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
                
            
        }
    }//GEN-LAST:event_timelistcbboxItemStateChanged


    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel customers;
    private javax.swing.JPanel customersP;
    private javax.swing.JTable customertable;
    private javax.swing.JLabel dashboard;
    private javax.swing.JPanel dashboardP;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel edit;
    private javax.swing.JPanel editscreeningP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lblposter1;
    private javax.swing.JLabel lblposter2;
    private javax.swing.JLabel lblposter3;
    private javax.swing.JLabel lblposter4;
    private javax.swing.JLabel lbltotalsales;
    private javax.swing.JComboBox<String> movielistcbbox;
    private javax.swing.JTable movietable;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel signout;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JLabel ticketlbl;
    private javax.swing.JComboBox<String> timelistcbbox;
    private javax.swing.JTextField txtmid;
    private javax.swing.JTextField txtmname;
    private javax.swing.JTextField txtts1;
    private javax.swing.JTextField txtts2;
    private javax.swing.JTextField txtts3;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton uploadB;
    // End of variables declaration//GEN-END:variables
}
