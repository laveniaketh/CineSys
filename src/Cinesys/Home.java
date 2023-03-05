
package Cinesys;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.print.*;


public class Home extends javax.swing.JFrame {
    
    PreparedStatement ps;
    ResultSet rs;
    String mname = "";
    ArrayList <String> movieList = new ArrayList();

    public Home() {
        initComponents();
        displayMovieSelectPanel();
        displayMoviePosters();
        displaySelectedMovie();
        
        
        
    }
    
    void allMoviesToArray(){
            try {
                ps = Database.connect().prepareStatement("SELECT * FROM `movielist`");
                rs = ps.executeQuery();
                while(rs.next()){
                 movieList.add(rs.getString("Movie Title"));  
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }
    
    void displayMovieSelectPanel(){
        //the movie select panel that will display first
        movieTab.setBackground(new Color(249,235,196));
        confirmationTab.setBackground(new Color(200,120,47));
        doneTab.setBackground(new Color(200,120,47));
        movieSelectPage.setVisible(true);
        moviePage.setVisible(false);
        confirmationPage.setVisible(false);
        donePage.setVisible(false);
    }
    
    void displayMoviePosters(){
        allMoviesToArray();
        for(int i = 0 ; i < movieList.size(); i++){
            mname = movieList.get(i);
            try {
                ps = Database.connect().prepareStatement("SELECT `image` FROM `movielist` WHERE `Movie Title`=?");
                ps.setString(1, mname);
                rs = ps.executeQuery();
                while(rs.next()){
                    if(i == 0){
                            byte[] img = rs.getBytes(1);
                            ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(movie1B.getWidth(),movie1B.getHeight(), Image.SCALE_SMOOTH));
                            movie1B.setIcon(imageIcon);
                        }
                    else if ( i == 1){
                            byte[] img = rs.getBytes(1);
                            ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(movie2B.getWidth(),movie2B.getHeight(), Image.SCALE_SMOOTH));
                            movie2B.setIcon(imageIcon);   
                        }
                    else if (i ==2){
                            byte[] img = rs.getBytes(1);
                            ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(movie3B.getWidth(),movie3B.getHeight(), Image.SCALE_SMOOTH));
                            movie3B.setIcon(imageIcon);  
                        }
                    else if( i == 3){
                            byte[] img = rs.getBytes(1);
                            ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(movie4B.getWidth(),movie4B.getHeight(), Image.SCALE_SMOOTH));
                            movie4B.setIcon(imageIcon);  
                        }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    void setMovie(String mn){
        this.mname = mn;
        
    }
    
    public String getMovie() {
        return mname;
    }
    
    void displayMoviePanel(){
        movieTab.setBackground(new Color(249,235,196));
        confirmationTab.setBackground(new Color(200,120,47));
        doneTab.setBackground(new Color(200,120,47));
        movieSelectPage.setVisible(false);
        moviePage.setVisible(true);
        confirmationPage.setVisible(false);
        donePage.setVisible(false);
    }
    
    void displayConfirmationPanel(){
        confirmationTab.setBackground(new Color(249,235,196));
        movieTab.setBackground(new Color(200,120,47));
        doneTab.setBackground(new Color(200,120,47));
        movieSelectPage.setVisible(false);
        moviePage.setVisible(false);
        confirmationPage.setVisible(true);
        donePage.setVisible(false);
    }
    
    void displayDonePanel(){
        doneTab.setBackground(new Color(249,235,196));
        movieTab.setBackground(new Color(200,120,47));
        confirmationTab.setBackground(new Color(200,120,47));
        movieSelectPage.setVisible(false);
        moviePage.setVisible(false);
        confirmationPage.setVisible(false);
        donePage.setVisible(true);
    }
    
    void displaySelectedMovie(){
        try {
            mname = getMovie();
            ps = Database.connect().prepareStatement("SELECT `image` FROM `movielist` WHERE `Movie Title`=?");
             ps.setString(1, mname);
             rs = ps.executeQuery();
             if(rs.next()){
                byte[] img = rs.getBytes(1);
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(mselectposterlbl.getWidth(),mselectposterlbl.getHeight(), Image.SCALE_SMOOTH));
                mselectposterlbl.setIcon(imageIcon);
             }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }
    
    void generateReceipt(){
        //to generate receipt
        receipttxt.setText(receipttxt.getText()+ "---------------------------------------\n");
        receipttxt.setText(receipttxt.getText()+ "                        CINESYS              \n");
        receipttxt.setText(receipttxt.getText()+ "CineSys Inc.                           \n");
        receipttxt.setText(receipttxt.getText()+ "Davao City, Philippines                \n");
        receipttxt.setText(receipttxt.getText()+ "---------------------------------------\n");
        receipttxt.setText(receipttxt.getText()+ "                        RECEIPT              \n");
        receipttxt.setText(receipttxt.getText()+ "MOVIE     :\n");
        receipttxt.setText(receipttxt.getText()+ "TIME      :\n");
        receipttxt.setText(receipttxt.getText()+ "TICKETID  :\n");
        receipttxt.setText(receipttxt.getText()+ "SEAT      :\n");
        receipttxt.setText(receipttxt.getText()+ "\n");
        receipttxt.setText(receipttxt.getText()+ "---------------------------------------\n");
        receipttxt.setText(receipttxt.getText()+ "\n");
        receipttxt.setText(receipttxt.getText()+ "\n");
        receipttxt.setText(receipttxt.getText()+ "                                       --------------\n");
        receipttxt.setText(receipttxt.getText()+ "TOTAL  :\n");
        
        
        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        movieTab = new javax.swing.JPanel();
        selectMovie = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        confirmationTab = new javax.swing.JPanel();
        confirmation = new javax.swing.JLabel();
        doneTab = new javax.swing.JPanel();
        done = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        JLabelClose = new javax.swing.JLabel();
        JLabelMin1 = new javax.swing.JLabel();
        Pages = new javax.swing.JPanel();
        movieSelectPage = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        movie1B = new javax.swing.JButton();
        movie2B = new javax.swing.JButton();
        movie3B = new javax.swing.JButton();
        movie4B = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        moviePage = new javax.swing.JPanel();
        backMoviePageB = new javax.swing.JButton();
        nextMoviePageB = new javax.swing.JButton();
        confirmationPage = new javax.swing.JPanel();
        mselectposterlbl = new javax.swing.JLabel();
        confirmConfirmationPageB = new javax.swing.JButton();
        backConfirmationPageB = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        donePage = new javax.swing.JPanel();
        printDonePageB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        receipttxt = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Menu.setBackground(new java.awt.Color(255, 204, 102));

        movieTab.setBackground(new java.awt.Color(200, 120, 47));
        movieTab.setPreferredSize(new java.awt.Dimension(150, 25));

        selectMovie.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        selectMovie.setForeground(new java.awt.Color(102, 32, 42));
        selectMovie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectMovie.setText("Select Movie");
        selectMovie.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout movieTabLayout = new javax.swing.GroupLayout(movieTab);
        movieTab.setLayout(movieTabLayout);
        movieTabLayout.setHorizontalGroup(
            movieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, movieTabLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(selectMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        movieTabLayout.setVerticalGroup(
            movieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, movieTabLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(selectMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cineSys150.png"))); // NOI18N

        confirmationTab.setBackground(new java.awt.Color(200, 120, 47));
        confirmationTab.setPreferredSize(new java.awt.Dimension(150, 25));

        confirmation.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        confirmation.setForeground(new java.awt.Color(102, 32, 42));
        confirmation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        confirmation.setText("Confirmation");
        confirmation.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout confirmationTabLayout = new javax.swing.GroupLayout(confirmationTab);
        confirmationTab.setLayout(confirmationTabLayout);
        confirmationTabLayout.setHorizontalGroup(
            confirmationTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmation, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );
        confirmationTabLayout.setVerticalGroup(
            confirmationTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        doneTab.setBackground(new java.awt.Color(200, 120, 47));
        doneTab.setPreferredSize(new java.awt.Dimension(150, 25));

        done.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        done.setForeground(new java.awt.Color(102, 32, 42));
        done.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        done.setText("Done");
        done.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout doneTabLayout = new javax.swing.GroupLayout(doneTab);
        doneTab.setLayout(doneTabLayout);
        doneTabLayout.setHorizontalGroup(
            doneTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(done, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
        );
        doneTabLayout.setVerticalGroup(
            doneTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(done, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel23.setFont(new java.awt.Font("Figtree Light", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 32, 42));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/admin.png"))); // NOI18N
        jLabel23.setText("Admin");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        JLabelClose.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JLabelClose.setForeground(new java.awt.Color(102, 32, 42));
        JLabelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_close_30px.png"))); // NOI18N
        JLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLabelCloseMouseClicked(evt);
            }
        });

        JLabelMin1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JLabelMin1.setForeground(new java.awt.Color(102, 32, 42));
        JLabelMin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_subtract_30px.png"))); // NOI18N
        JLabelMin1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLabelMin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLabelMin1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                        .addComponent(movieTab, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(confirmationTab, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(doneTab, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel23)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                        .addComponent(JLabelMin1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLabelClose)
                        .addContainerGap())))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(doneTab, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addComponent(confirmationTab, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addComponent(movieTab, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JLabelClose)
                                    .addComponent(JLabelMin1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                                .addGap(0, 10, Short.MAX_VALUE)
                                .addComponent(jLabel13)))
                        .addContainerGap())))
        );

        Pages.setBackground(new java.awt.Color(249, 235, 196));
        Pages.setPreferredSize(new java.awt.Dimension(700, 300));
        Pages.setLayout(new javax.swing.OverlayLayout(Pages));

        movieSelectPage.setBackground(new java.awt.Color(249, 235, 196));

        jPanel1.setBackground(new java.awt.Color(249, 235, 196));
        jPanel1.setLayout(new java.awt.GridLayout(1, 4, 40, 0));

        movie1B.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        movie1B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                movie1BMouseClicked(evt);
            }
        });
        jPanel1.add(movie1B);

        movie2B.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        movie2B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                movie2BMouseClicked(evt);
            }
        });
        jPanel1.add(movie2B);

        movie3B.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        movie3B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                movie3BMouseClicked(evt);
            }
        });
        jPanel1.add(movie3B);

        movie4B.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        movie4B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                movie4BMouseClicked(evt);
            }
        });
        jPanel1.add(movie4B);

        jLabel1.setFont(new java.awt.Font("Figtree", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 32, 42));
        jLabel1.setText("Select a Movie");

        javax.swing.GroupLayout movieSelectPageLayout = new javax.swing.GroupLayout(movieSelectPage);
        movieSelectPage.setLayout(movieSelectPageLayout);
        movieSelectPageLayout.setHorizontalGroup(
            movieSelectPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(movieSelectPageLayout.createSequentialGroup()
                .addGroup(movieSelectPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(movieSelectPageLayout.createSequentialGroup()
                        .addGap(518, 518, 518)
                        .addComponent(jLabel1))
                    .addGroup(movieSelectPageLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        movieSelectPageLayout.setVerticalGroup(
            movieSelectPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(movieSelectPageLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Pages.add(movieSelectPage);

        moviePage.setBackground(new java.awt.Color(249, 235, 196));

        backMoviePageB.setBackground(new java.awt.Color(102, 32, 42));
        backMoviePageB.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        backMoviePageB.setForeground(new java.awt.Color(255, 255, 255));
        backMoviePageB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        backMoviePageB.setText("Back");
        backMoviePageB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMoviePageBMouseClicked(evt);
            }
        });

        nextMoviePageB.setBackground(new java.awt.Color(102, 32, 42));
        nextMoviePageB.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        nextMoviePageB.setForeground(new java.awt.Color(255, 255, 255));
        nextMoviePageB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/next.png"))); // NOI18N
        nextMoviePageB.setText("Next");
        nextMoviePageB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMoviePageBMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout moviePageLayout = new javax.swing.GroupLayout(moviePage);
        moviePage.setLayout(moviePageLayout);
        moviePageLayout.setHorizontalGroup(
            moviePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moviePageLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(backMoviePageB)
                .addGap(194, 194, 194)
                .addComponent(nextMoviePageB)
                .addContainerGap(765, Short.MAX_VALUE))
        );
        moviePageLayout.setVerticalGroup(
            moviePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moviePageLayout.createSequentialGroup()
                .addGap(454, 454, 454)
                .addGroup(moviePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backMoviePageB)
                    .addComponent(nextMoviePageB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Pages.add(moviePage);

        confirmationPage.setBackground(new java.awt.Color(249, 235, 196));

        mselectposterlbl.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        mselectposterlbl.setForeground(new java.awt.Color(102, 32, 42));
        mselectposterlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/movie-poster.png"))); // NOI18N

        confirmConfirmationPageB.setBackground(new java.awt.Color(102, 32, 42));
        confirmConfirmationPageB.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        confirmConfirmationPageB.setForeground(new java.awt.Color(255, 255, 255));
        confirmConfirmationPageB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/confirm.png"))); // NOI18N
        confirmConfirmationPageB.setText("Confirm");
        confirmConfirmationPageB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmConfirmationPageBMouseClicked(evt);
            }
        });

        backConfirmationPageB.setBackground(new java.awt.Color(102, 32, 42));
        backConfirmationPageB.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        backConfirmationPageB.setForeground(new java.awt.Color(255, 255, 255));
        backConfirmationPageB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        backConfirmationPageB.setText("Back");
        backConfirmationPageB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backConfirmationPageBMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setLayout(new java.awt.GridLayout(4, 2, 35, 40));

        jLabel2.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 32, 42));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Movie :");
        jPanel2.add(jLabel2);

        jLabel5.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 32, 42));
        jLabel5.setText("jLabel5");
        jPanel2.add(jLabel5);

        jLabel4.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 32, 42));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Time :");
        jPanel2.add(jLabel4);

        jLabel6.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 32, 42));
        jLabel6.setText("jLabel6");
        jPanel2.add(jLabel6);

        jLabel3.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 32, 42));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("No. of Tickets :");
        jPanel2.add(jLabel3);

        jLabel7.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 32, 42));
        jLabel7.setText("jLabel7");
        jPanel2.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 32, 42));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Selected seat(s):");
        jPanel2.add(jLabel8);

        jLabel10.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 32, 42));
        jLabel10.setText("jLabel7");
        jPanel2.add(jLabel10);

        jLabel9.setFont(new java.awt.Font("Figtree", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 32, 42));
        jLabel9.setText("Payment Details");

        jPanel3.setBackground(new java.awt.Color(255, 204, 102));
        jPanel3.setLayout(new java.awt.GridLayout(3, 2, 35, 40));

        jLabel15.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 32, 42));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("No. of Tickets :");
        jPanel3.add(jLabel15);

        jLabel12.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 32, 42));
        jLabel12.setText("jLabel5");
        jPanel3.add(jLabel12);

        jLabel17.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 32, 42));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Price :");
        jPanel3.add(jLabel17);

        jLabel16.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 32, 42));
        jLabel16.setText("jLabel7");
        jPanel3.add(jLabel16);

        jLabel11.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 32, 42));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Total :");
        jPanel3.add(jLabel11);

        jLabel18.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 32, 42));
        jLabel18.setText("jLabel7");
        jPanel3.add(jLabel18);

        jLabel19.setFont(new java.awt.Font("Figtree", 0, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 32, 42));
        jLabel19.setText("Summary");

        javax.swing.GroupLayout confirmationPageLayout = new javax.swing.GroupLayout(confirmationPage);
        confirmationPage.setLayout(confirmationPageLayout);
        confirmationPageLayout.setHorizontalGroup(
            confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmationPageLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mselectposterlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backConfirmationPageB))
                .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(confirmationPageLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(confirmationPageLayout.createSequentialGroup()
                                .addGap(365, 365, 365)
                                .addComponent(confirmConfirmationPageB))
                            .addGroup(confirmationPageLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(93, 93, 93))
                    .addGroup(confirmationPageLayout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(181, 181, 181))))
        );
        confirmationPageLayout.setVerticalGroup(
            confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmationPageLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(confirmationPageLayout.createSequentialGroup()
                        .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(mselectposterlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(confirmationPageLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(confirmConfirmationPageB))
                    .addGroup(confirmationPageLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(backConfirmationPageB)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Pages.add(confirmationPage);

        donePage.setBackground(new java.awt.Color(249, 235, 196));

        printDonePageB.setBackground(new java.awt.Color(102, 32, 42));
        printDonePageB.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        printDonePageB.setForeground(new java.awt.Color(255, 255, 255));
        printDonePageB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/printer.png"))); // NOI18N
        printDonePageB.setText("PRINT RECEIPT");
        printDonePageB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printDonePageBMouseClicked(evt);
            }
        });

        receipttxt.setColumns(20);
        receipttxt.setFont(new java.awt.Font("Figtree Light", 0, 18)); // NOI18N
        receipttxt.setRows(5);
        jScrollPane1.setViewportView(receipttxt);

        jLabel14.setFont(new java.awt.Font("Figtree", 0, 48)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 32, 42));
        jLabel14.setText("BOOKED SUCESSFULLY!");

        jLabel20.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 32, 42));
        jLabel20.setText("Thank you and come again");

        jLabel21.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 32, 42));
        jLabel21.setText("Please proceed to the cinema cashier");

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clapperboard.png"))); // NOI18N

        javax.swing.GroupLayout donePageLayout = new javax.swing.GroupLayout(donePage);
        donePage.setLayout(donePageLayout);
        donePageLayout.setHorizontalGroup(
            donePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(donePageLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel22)
                .addGroup(donePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(donePageLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(donePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, donePageLayout.createSequentialGroup()
                                .addGroup(donePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(donePageLayout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel21))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, donePageLayout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addComponent(jLabel20)))
                                .addGap(93, 93, 93))))
                    .addGroup(donePageLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(printDonePageB)))
                .addGap(78, 78, 78)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        donePageLayout.setVerticalGroup(
            donePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(donePageLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(donePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(donePageLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, donePageLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(printDonePageB)
                        .addGap(101, 101, 101)))
                .addContainerGap(479, Short.MAX_VALUE))
        );

        Pages.add(donePage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Pages, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Pages, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void movie1BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movie1BMouseClicked
        // TODO add your handling code here:
         allMoviesToArray();
         mname = movieList.get(0);
         setMovie(mname);
         displayMoviePanel();
         
        
    }//GEN-LAST:event_movie1BMouseClicked

    private void movie2BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movie2BMouseClicked
        // TODO add your handling code here:
        allMoviesToArray();
        mname = movieList.get(1);
        setMovie(mname);
        displayMoviePanel();

        
    }//GEN-LAST:event_movie2BMouseClicked

    private void movie3BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movie3BMouseClicked
        // TODO add your handling code here:
        allMoviesToArray();
        mname = movieList.get(2);
        setMovie(mname);
        displayMoviePanel();
        
    }//GEN-LAST:event_movie3BMouseClicked

    private void movie4BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movie4BMouseClicked
        // TODO add your handling code here:
        allMoviesToArray();
        mname = movieList.get(3);
        setMovie(mname);
        displayMoviePanel();
        
    }//GEN-LAST:event_movie4BMouseClicked

    private void backMoviePageBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMoviePageBMouseClicked
        // TODO add your handling code here:
        displayMovieSelectPanel();
    }//GEN-LAST:event_backMoviePageBMouseClicked

    private void nextMoviePageBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMoviePageBMouseClicked
        // TODO add your handling code here:
        displayConfirmationPanel();
        displaySelectedMovie();
    }//GEN-LAST:event_nextMoviePageBMouseClicked

    private void confirmConfirmationPageBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmConfirmationPageBMouseClicked
        // TODO add your handling code here:
        displayDonePanel();
        generateReceipt();
    }//GEN-LAST:event_confirmConfirmationPageBMouseClicked

    private void backConfirmationPageBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backConfirmationPageBMouseClicked
        // TODO add your handling code here:
        displayMoviePanel();
        
    }//GEN-LAST:event_backConfirmationPageBMouseClicked

    private void printDonePageBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printDonePageBMouseClicked
        try {
            // TODO add your handling code here:
            receipttxt.print();
            //System.exit(0);
        } catch (PrinterException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printDonePageBMouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        //opens the login/register page before proceeding to the admin page
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void JLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelCloseMouseClicked
        //close the form
        System.exit(0);
    }//GEN-LAST:event_JLabelCloseMouseClicked

    private void JLabelMin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelMin1MouseClicked
        // minimize the page
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_JLabelMin1MouseClicked


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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelClose;
    private javax.swing.JLabel JLabelMin1;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Pages;
    private javax.swing.JButton backConfirmationPageB;
    private javax.swing.JButton backMoviePageB;
    private javax.swing.JButton confirmConfirmationPageB;
    private javax.swing.JLabel confirmation;
    private javax.swing.JPanel confirmationPage;
    private javax.swing.JPanel confirmationTab;
    private javax.swing.JLabel done;
    private javax.swing.JPanel donePage;
    private javax.swing.JPanel doneTab;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton movie1B;
    private javax.swing.JButton movie2B;
    private javax.swing.JButton movie3B;
    private javax.swing.JButton movie4B;
    private javax.swing.JPanel moviePage;
    private javax.swing.JPanel movieSelectPage;
    private javax.swing.JPanel movieTab;
    private javax.swing.JLabel mselectposterlbl;
    private javax.swing.JButton nextMoviePageB;
    private javax.swing.JButton printDonePageB;
    private javax.swing.JTextArea receipttxt;
    private javax.swing.JLabel selectMovie;
    // End of variables declaration//GEN-END:variables
}
