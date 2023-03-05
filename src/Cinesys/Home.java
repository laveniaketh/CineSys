
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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        movieTab = new javax.swing.JPanel();
        selectMovie = new javax.swing.JLabel();
        confirmationTab = new javax.swing.JPanel();
        confirmation = new javax.swing.JLabel();
        doneTab = new javax.swing.JPanel();
        done = new javax.swing.JLabel();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        donePage = new javax.swing.JPanel();
        confirmConfirmationPageB1 = new javax.swing.JButton();

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

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(movieTab, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmationTab, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(doneTab, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addGap(0, 90, Short.MAX_VALUE)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(doneTab, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(confirmationTab, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(movieTab, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))
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
                .addContainerGap(126, Short.MAX_VALUE))
        );
        movieSelectPageLayout.setVerticalGroup(
            movieSelectPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(movieSelectPageLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
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
                .addGap(177, 177, 177)
                .addComponent(backMoviePageB)
                .addGap(194, 194, 194)
                .addComponent(nextMoviePageB)
                .addContainerGap(776, Short.MAX_VALUE))
        );
        moviePageLayout.setVerticalGroup(
            moviePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moviePageLayout.createSequentialGroup()
                .addContainerGap(372, Short.MAX_VALUE)
                .addGroup(moviePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backMoviePageB)
                    .addComponent(nextMoviePageB))
                .addGap(260, 260, 260))
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

        jLabel2.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 32, 42));
        jLabel2.setText("Time");

        jLabel4.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 32, 42));
        jLabel4.setText("Number of Tickets");

        javax.swing.GroupLayout confirmationPageLayout = new javax.swing.GroupLayout(confirmationPage);
        confirmationPage.setLayout(confirmationPageLayout);
        confirmationPageLayout.setHorizontalGroup(
            confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmationPageLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(mselectposterlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(confirmationPageLayout.createSequentialGroup()
                        .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(confirmationPageLayout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(backConfirmationPageB))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmationPageLayout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(119, 119, 119)
                        .addComponent(confirmConfirmationPageB))
                    .addGroup(confirmationPageLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(475, Short.MAX_VALUE))
        );
        confirmationPageLayout.setVerticalGroup(
            confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmationPageLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backConfirmationPageB)
                    .addComponent(confirmConfirmationPageB))
                .addGap(175, 175, 175))
            .addGroup(confirmationPageLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(mselectposterlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        Pages.add(confirmationPage);

        donePage.setBackground(new java.awt.Color(249, 235, 196));

        confirmConfirmationPageB1.setBackground(new java.awt.Color(102, 32, 42));
        confirmConfirmationPageB1.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        confirmConfirmationPageB1.setForeground(new java.awt.Color(255, 255, 255));
        confirmConfirmationPageB1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/printer.png"))); // NOI18N
        confirmConfirmationPageB1.setText("PRINT");
        confirmConfirmationPageB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmConfirmationPageB1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout donePageLayout = new javax.swing.GroupLayout(donePage);
        donePage.setLayout(donePageLayout);
        donePageLayout.setHorizontalGroup(
            donePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
            .addGroup(donePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(donePageLayout.createSequentialGroup()
                    .addGap(610, 610, 610)
                    .addComponent(confirmConfirmationPageB1)
                    .addContainerGap(631, Short.MAX_VALUE)))
        );
        donePageLayout.setVerticalGroup(
            donePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
            .addGroup(donePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(donePageLayout.createSequentialGroup()
                    .addGap(316, 316, 316)
                    .addComponent(confirmConfirmationPageB1)
                    .addContainerGap(316, Short.MAX_VALUE)))
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
                .addComponent(Pages, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE))
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
    }//GEN-LAST:event_confirmConfirmationPageBMouseClicked

    private void backConfirmationPageBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backConfirmationPageBMouseClicked
        // TODO add your handling code here:
        displayMoviePanel();
    }//GEN-LAST:event_backConfirmationPageBMouseClicked

    private void confirmConfirmationPageB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmConfirmationPageB1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_confirmConfirmationPageB1MouseClicked


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
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Pages;
    private javax.swing.JButton backConfirmationPageB;
    private javax.swing.JButton backMoviePageB;
    private javax.swing.JButton confirmConfirmationPageB;
    private javax.swing.JButton confirmConfirmationPageB1;
    private javax.swing.JLabel confirmation;
    private javax.swing.JPanel confirmationPage;
    private javax.swing.JPanel confirmationTab;
    private javax.swing.JLabel done;
    private javax.swing.JPanel donePage;
    private javax.swing.JPanel doneTab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton movie1B;
    private javax.swing.JButton movie2B;
    private javax.swing.JButton movie3B;
    private javax.swing.JButton movie4B;
    private javax.swing.JPanel moviePage;
    private javax.swing.JPanel movieSelectPage;
    private javax.swing.JPanel movieTab;
    private javax.swing.JLabel mselectposterlbl;
    private javax.swing.JButton nextMoviePageB;
    private javax.swing.JLabel selectMovie;
    // End of variables declaration//GEN-END:variables
}
