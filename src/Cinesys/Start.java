
package Cinesys;


public class Start extends javax.swing.JFrame {


    public Start() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        JLabelMin1 = new javax.swing.JLabel();
        JLabelClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(238, 214, 194));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(227, 183, 120));
        jPanel1.setForeground(new java.awt.Color(227, 183, 120));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo final.png"))); // NOI18N

        updateButton.setBackground(new java.awt.Color(102, 32, 42));
        updateButton.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update.png"))); // NOI18N
        updateButton.setText("BOOK A TICKET");
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButtonMouseClicked(evt);
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

        JLabelClose.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JLabelClose.setForeground(new java.awt.Color(102, 32, 42));
        JLabelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_close_30px.png"))); // NOI18N
        JLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLabelCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(updateButton)
                        .addGap(397, 397, 397)))
                .addGap(166, 166, 166))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLabelMin1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLabelClose)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JLabelClose)
                    .addComponent(JLabelMin1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(updateButton)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JLabelMin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelMin1MouseClicked
        // minimize the page
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_JLabelMin1MouseClicked

    private void JLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelCloseMouseClicked
        //close the form
        System.exit(0);
    }//GEN-LAST:event_JLabelCloseMouseClicked

    private void updateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_updateButtonMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelClose;
    private javax.swing.JLabel JLabelMin1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
