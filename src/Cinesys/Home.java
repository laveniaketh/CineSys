
package Cinesys;

import java.awt.Color;


public class Home extends javax.swing.JFrame {


    public Home() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        logoPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        movieTab = new javax.swing.JPanel();
        selectMovie = new javax.swing.JLabel();
        confirmationTab = new javax.swing.JPanel();
        confirmation = new javax.swing.JLabel();
        doneTab = new javax.swing.JPanel();
        done = new javax.swing.JLabel();
        Pages = new javax.swing.JPanel();
        moviePage = new javax.swing.JPanel();
        confirmationPage = new javax.swing.JPanel();
        donePage = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Menu.setBackground(new java.awt.Color(255, 204, 102));

        logoPanel.setBackground(new java.awt.Color(255, 204, 102));
        logoPanel.setPreferredSize(new java.awt.Dimension(200, 100));
        logoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/rsz_logo_transparent.png"))); // NOI18N
        logoPanel.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 100));

        movieTab.setBackground(new java.awt.Color(200, 120, 47));
        movieTab.setPreferredSize(new java.awt.Dimension(150, 25));
        movieTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                movieTabMouseClicked(evt);
            }
        });

        selectMovie.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        selectMovie.setForeground(new java.awt.Color(65, 35, 10));
        selectMovie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectMovie.setText("Select Movie");

        javax.swing.GroupLayout movieTabLayout = new javax.swing.GroupLayout(movieTab);
        movieTab.setLayout(movieTabLayout);
        movieTabLayout.setHorizontalGroup(
            movieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectMovie, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        movieTabLayout.setVerticalGroup(
            movieTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(selectMovie, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        confirmationTab.setBackground(new java.awt.Color(200, 120, 47));
        confirmationTab.setPreferredSize(new java.awt.Dimension(150, 25));
        confirmationTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmationTabMouseClicked(evt);
            }
        });

        confirmation.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        confirmation.setForeground(new java.awt.Color(65, 35, 10));
        confirmation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        confirmation.setText("Confirmation");

        javax.swing.GroupLayout confirmationTabLayout = new javax.swing.GroupLayout(confirmationTab);
        confirmationTab.setLayout(confirmationTabLayout);
        confirmationTabLayout.setHorizontalGroup(
            confirmationTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmation, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        confirmationTabLayout.setVerticalGroup(
            confirmationTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmation, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        doneTab.setBackground(new java.awt.Color(200, 120, 47));
        doneTab.setPreferredSize(new java.awt.Dimension(150, 25));
        doneTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doneTabMouseClicked(evt);
            }
        });

        done.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        done.setForeground(new java.awt.Color(65, 35, 10));
        done.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        done.setText("Done");

        javax.swing.GroupLayout doneTabLayout = new javax.swing.GroupLayout(doneTab);
        doneTab.setLayout(doneTabLayout);
        doneTabLayout.setHorizontalGroup(
            doneTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(done, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        doneTabLayout.setVerticalGroup(
            doneTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(done, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(logoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(movieTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmationTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doneTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doneTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmationTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(movieTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Pages.setBackground(new java.awt.Color(249, 235, 196));
        Pages.setPreferredSize(new java.awt.Dimension(700, 300));

        moviePage.setBackground(new java.awt.Color(249, 235, 196));

        javax.swing.GroupLayout moviePageLayout = new javax.swing.GroupLayout(moviePage);
        moviePage.setLayout(moviePageLayout);
        moviePageLayout.setHorizontalGroup(
            moviePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        moviePageLayout.setVerticalGroup(
            moviePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        confirmationPage.setBackground(new java.awt.Color(249, 235, 196));

        javax.swing.GroupLayout confirmationPageLayout = new javax.swing.GroupLayout(confirmationPage);
        confirmationPage.setLayout(confirmationPageLayout);
        confirmationPageLayout.setHorizontalGroup(
            confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );
        confirmationPageLayout.setVerticalGroup(
            confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        donePage.setBackground(new java.awt.Color(249, 235, 196));

        javax.swing.GroupLayout donePageLayout = new javax.swing.GroupLayout(donePage);
        donePage.setLayout(donePageLayout);
        donePageLayout.setHorizontalGroup(
            donePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        donePageLayout.setVerticalGroup(
            donePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PagesLayout = new javax.swing.GroupLayout(Pages);
        Pages.setLayout(PagesLayout);
        PagesLayout.setHorizontalGroup(
            PagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(moviePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PagesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(confirmationPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(PagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PagesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(donePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        PagesLayout.setVerticalGroup(
            PagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(moviePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PagesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(confirmationPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(PagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PagesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(donePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Pages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Pages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void movieTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movieTabMouseClicked
        movieTab.setBackground(new Color(249,235,196));
        confirmationTab.setBackground(new Color(200,120,47));
        doneTab.setBackground(new Color(200,120,47));
        
        moviePage.setVisible(true);
        confirmationPage.setVisible(false);
        donePage.setVisible(false);
    }//GEN-LAST:event_movieTabMouseClicked

    private void confirmationTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmationTabMouseClicked
        confirmationTab.setBackground(new Color(249,235,196));
        movieTab.setBackground(new Color(200,120,47));
        doneTab.setBackground(new Color(200,120,47));
        
        moviePage.setVisible(false);
        confirmationPage.setVisible(true);
        donePage.setVisible(false);
    }//GEN-LAST:event_confirmationTabMouseClicked

    private void doneTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneTabMouseClicked
        doneTab.setBackground(new Color(249,235,196));
        movieTab.setBackground(new Color(200,120,47));
        confirmationTab.setBackground(new Color(200,120,47));
        
        moviePage.setVisible(false);
        confirmationPage.setVisible(false);
        donePage.setVisible(true);
    }//GEN-LAST:event_doneTabMouseClicked


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
    private javax.swing.JLabel confirmation;
    private javax.swing.JPanel confirmationPage;
    private javax.swing.JPanel confirmationTab;
    private javax.swing.JLabel done;
    private javax.swing.JPanel donePage;
    private javax.swing.JPanel doneTab;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPanel moviePage;
    private javax.swing.JPanel movieTab;
    private javax.swing.JLabel selectMovie;
    // End of variables declaration//GEN-END:variables
}
