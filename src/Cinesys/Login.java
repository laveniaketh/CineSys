package Cinesys;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {
    //declare variables to store x and y coordinate values
    int positionX = 0, positionY = 0;
    PreparedStatement ps;
     ResultSet rs;
   
    User ou = new OldUser();
    
       void loginAction(){
           ou.setUsername(tfusername.getText());
           ou.setPassword(tfpassword.getText());
        try {
            ps = Database.connect().prepareStatement("SELECT * FROM `users_acc` WHERE `username` =? AND `password` =?");
            ps.setString(1, ou.getUsername());
            ps.setString(2, ou.getPassword());

            rs = ps.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "You are Logged-in!");
                    dispose();
                    sample s = new sample();
                    s.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                }
        } catch (SQLException ex) {
            Logger.getLogger(OldUser.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null); //center fom in the screen
       
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        tfusername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfpassword = new javax.swing.JPasswordField();
        showpass = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        registerLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        JLabelMin1 = new javax.swing.JLabel();
        JLabelClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(570, 300));
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(200, 120, 47));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 400));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(225, 184, 120));
        jPanel3.setPreferredSize(new java.awt.Dimension(280, 100));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 32, 42));
        jLabel1.setText("Welcome To CineSys");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 20, 268, 32));

        jLabel6.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 32, 42));
        jLabel6.setText("Login to your account!");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 58, 146, -1));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 5, 280, 100);

        jPanel4.setBackground(new java.awt.Color(225, 184, 120));
        jPanel4.setPreferredSize(new java.awt.Dimension(280, 170));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setLayout(new java.awt.BorderLayout());
        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, -1));

        jPanel7.setLayout(new java.awt.BorderLayout());
        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 58, 36, -1));

        tfusername.setBackground(new java.awt.Color(225, 184, 120));
        tfusername.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        tfusername.setForeground(new java.awt.Color(153, 153, 153));
        tfusername.setText("Enter Username");
        tfusername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 2, 0, new java.awt.Color(102, 32, 42)));
        tfusername.setName(""); // NOI18N
        tfusername.setPreferredSize(new java.awt.Dimension(72, 17));
        tfusername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfusernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfusernameFocusLost(evt);
            }
        });
        jPanel4.add(tfusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 37, 254, 25));

        jLabel2.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 32, 42));
        jLabel2.setText("Username:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 32, 42));
        jLabel3.setText("Password:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 80, -1));

        tfpassword.setBackground(new java.awt.Color(225, 184, 120));
        tfpassword.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        tfpassword.setForeground(new java.awt.Color(153, 153, 153));
        tfpassword.setText("Enter Password");
        tfpassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 2, 0, new java.awt.Color(102, 32, 42)));
        tfpassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfpasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfpasswordFocusLost(evt);
            }
        });
        jPanel4.add(tfpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 96, 254, 26));

        showpass.setBackground(new java.awt.Color(225, 184, 120));
        showpass.setFont(new java.awt.Font("Figtree Light", 0, 12)); // NOI18N
        showpass.setForeground(new java.awt.Color(102, 32, 42));
        showpass.setText("Show password?");
        showpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpassActionPerformed(evt);
            }
        });
        jPanel4.add(showpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 128, -1, -1));

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 110, 280, 170);

        jPanel5.setBackground(new java.awt.Color(225, 184, 120));
        jPanel5.setPreferredSize(new java.awt.Dimension(280, 130));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginButton.setBackground(new java.awt.Color(102, 32, 42));
        loginButton.setFont(new java.awt.Font("Figtree Light", 1, 12)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");
        loginButton.setBorder(new javax.swing.border.MatteBorder(null));
        loginButton.setPreferredSize(new java.awt.Dimension(50, 22));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel5.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 15, 234, 32));

        registerLabel.setFont(new java.awt.Font("Figtree Light", 0, 12)); // NOI18N
        registerLabel.setText("Don't have an account yet? Register here.");
        registerLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        registerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerLabelMouseClicked(evt);
            }
        });
        jPanel5.add(registerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jPanel1.add(jPanel5);
        jPanel5.setBounds(10, 290, 280, 100);

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setBackground(new java.awt.Color(255, 229, 206));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cineSys150.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 290, 140));

        JLabelMin1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JLabelMin1.setForeground(new java.awt.Color(102, 32, 42));
        JLabelMin1.setText("−");
        JLabelMin1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLabelMin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLabelMin1MouseClicked(evt);
            }
        });
        jPanel2.add(JLabelMin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 0, -1, 16));

        JLabelClose.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JLabelClose.setForeground(new java.awt.Color(102, 32, 42));
        JLabelClose.setText("×");
        JLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLabelCloseMouseClicked(evt);
            }
        });
        jPanel2.add(JLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 0, -1, 16));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfusernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfusernameFocusGained
         ou.setUsername(tfusername.getText());
        if (ou.getUsername().equals("Enter Username")){
            tfusername.setText("");
            tfusername.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_tfusernameFocusGained

    private void tfusernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfusernameFocusLost
        ou.setUsername(tfusername.getText());
        if (ou.getUsername().equals("")){
            tfusername.setText("Enter Username");
            tfusername.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_tfusernameFocusLost

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        loginAction();
    }//GEN-LAST:event_loginButtonActionPerformed

    private void tfpasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfpasswordFocusGained
         ou.setPassword(tfpassword.getText());
        if (ou.getPassword().equals("Enter Password")){
            tfpassword.setText("");
            tfpassword.requestFocus();
            tfpassword.setEchoChar('•');
            tfpassword.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_tfpasswordFocusGained

    private void tfpasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfpasswordFocusLost
             ou.setPassword(tfpassword.getText());
        if (ou.getPassword().equals("")){
            tfpassword.setText("Enter Password");
            tfpassword.setEchoChar('\u0000');
            tfpassword.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_tfpasswordFocusLost

    private void showpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpassActionPerformed
        if(showpass.isSelected ())
            tfpassword.setEchoChar((char)0);
        else
            tfpassword.setEchoChar('*');
    }//GEN-LAST:event_showpassActionPerformed

    private void registerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerLabelMouseClicked
        //proceeds to register
        Register reg = new Register ();
        dispose();
        reg.setVisible(true); 
    }//GEN-LAST:event_registerLabelMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // get x and y coordinate values
        positionX = evt.getX();
        positionX = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // set jframe location and make it movable
        setLocation(evt.getXOnScreen()-positionX, evt.getYOnScreen()-positionY);
    }//GEN-LAST:event_formMouseDragged

    private void JLabelMin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelMin1MouseClicked
        // minimize the page
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_JLabelMin1MouseClicked

    private void JLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelCloseMouseClicked
        //close the form
        System.exit(0);
    }//GEN-LAST:event_JLabelCloseMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelClose;
    private javax.swing.JLabel JLabelMin1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JCheckBox showpass;
    private javax.swing.JPasswordField tfpassword;
    private javax.swing.JTextField tfusername;
    // End of variables declaration//GEN-END:variables
}

