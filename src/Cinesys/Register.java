package Cinesys;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Register extends javax.swing.JFrame {
    //declare variables to store X and Y coordinate values
    int positionX = 0, positionY = 0;
    PreparedStatement ps;
    ResultSet rs;
    User nu = new User(); 
  
    public Register() {
        initComponents();
        this.setLocationRelativeTo(null); //center fom in the screen
    }
    void registerAction () {
        // Creating a new account
        nu.setFirstname(tfFirstName.getText());
        nu.setLastname(tfLastName.getText());
        nu.setUsername(tfUsername.getText());
        nu.setPassword(String.valueOf(pfPassword.getPassword()));
        nu.setRepassword(String.valueOf(pfPassword.getPassword()));
        
        if(nu.getFirstname().equals("")){
            JOptionPane.showMessageDialog(null, "Add A First Name.");
        }
        else if(nu.getLastname().equals("")){
            JOptionPane.showMessageDialog(null, "Add A Last Name.");
        }
        else if(nu.getUsername().equals("")){
            JOptionPane.showMessageDialog(null, "Add An Username.");
        }
        else if(nu.getPassword().equals("")){
            JOptionPane.showMessageDialog(null, "Add A Pssword.");
        }
        else if(!nu.getPassword().equals(nu.getRepassword())){
            JOptionPane.showMessageDialog(null, "Retype The Password Again.");
        }
        else if(checkUsername(nu.getUsername())){
             JOptionPane.showMessageDialog(null, "This Username Already Exist.");
        }
        else{
            try {
            ps = Database.connect().prepareStatement("INSERT INTO `users_acc`(`first_name`, `last_name`, `username`, `password`) VALUES (?,?,?,?)");
            
            ps.setString(1, nu.getFirstname());
            ps.setString(2, nu.getLastname());
            ps.setString(3, nu.getUsername());
            ps.setString(4, nu.getPassword());
             
             if (ps.executeUpdate() > 0){
                 JOptionPane.showMessageDialog(null, "New User Added");
             }
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    public boolean checkUsername(String username ){
        // to check if there's already an existing username created.
        boolean checkUser = false;
         
        try {
            ps = Database.connect().prepareStatement("SELECT * FROM `users_acc` WHERE `username` = ?");
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                checkUser = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checkUser;    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLabelMin = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        firstName = new javax.swing.JLabel();
        tfFirstName = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        lastName = new javax.swing.JLabel();
        tfLastName = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        username = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        password = new javax.swing.JLabel();
        pfPassword = new javax.swing.JPasswordField();
        jPanel12 = new javax.swing.JPanel();
        confirmPassword = new javax.swing.JLabel();
        pfConfirmPassword = new javax.swing.JPasswordField();
        bRegister = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        backToLogin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        JLabelMin1 = new javax.swing.JLabel();
        JLabelClose = new javax.swing.JLabel();

        JLabelMin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JLabelMin.setForeground(new java.awt.Color(51, 51, 51));
        JLabelMin.setText("−");
        JLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLabelMinMouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
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

        jPanel3.setBackground(new java.awt.Color(200, 120, 47));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 45));

        Title.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        Title.setForeground(new java.awt.Color(102, 32, 42));
        Title.setText("CREATE AN ACCOUNT");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(Title)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(Title)
                .addContainerGap())
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 5, 300, 45);

        jPanel4.setBackground(new java.awt.Color(200, 120, 47));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 260));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setLayout(new java.awt.BorderLayout());

        firstName.setBackground(new java.awt.Color(200, 120, 47));
        firstName.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        firstName.setForeground(new java.awt.Color(102, 32, 42));
        firstName.setText("First Name");
        firstName.setOpaque(true);
        jPanel6.add(firstName, java.awt.BorderLayout.PAGE_START);

        tfFirstName.setBackground(new java.awt.Color(225, 184, 120));
        tfFirstName.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        tfFirstName.setForeground(new java.awt.Color(51, 51, 51));
        tfFirstName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 2, 0, new java.awt.Color(102, 32, 42)));
        tfFirstName.setName(""); // NOI18N
        tfFirstName.setPreferredSize(new java.awt.Dimension(72, 17));
        jPanel6.add(tfFirstName, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 117, -1));

        jPanel7.setLayout(new java.awt.BorderLayout());

        lastName.setBackground(new java.awt.Color(200, 120, 47));
        lastName.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        lastName.setForeground(new java.awt.Color(102, 32, 42));
        lastName.setText("Last Name");
        lastName.setOpaque(true);
        jPanel7.add(lastName, java.awt.BorderLayout.PAGE_START);

        tfLastName.setBackground(new java.awt.Color(225, 184, 120));
        tfLastName.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        tfLastName.setForeground(new java.awt.Color(102, 32, 42));
        tfLastName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 2, 0, new java.awt.Color(102, 32, 42)));
        tfLastName.setName(""); // NOI18N
        tfLastName.setPreferredSize(new java.awt.Dimension(72, 17));
        jPanel7.add(tfLastName, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 117, -1));

        jPanel9.setLayout(new java.awt.BorderLayout());

        username.setBackground(new java.awt.Color(200, 120, 47));
        username.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        username.setForeground(new java.awt.Color(102, 32, 42));
        username.setText("Username");
        username.setOpaque(true);
        jPanel9.add(username, java.awt.BorderLayout.PAGE_START);

        tfUsername.setBackground(new java.awt.Color(225, 184, 120));
        tfUsername.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        tfUsername.setForeground(new java.awt.Color(102, 32, 42));
        tfUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 2, 0, new java.awt.Color(102, 32, 42)));
        tfUsername.setName(""); // NOI18N
        tfUsername.setPreferredSize(new java.awt.Dimension(72, 17));
        jPanel9.add(tfUsername, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 117, -1));

        jPanel10.setLayout(new java.awt.BorderLayout());

        password.setBackground(new java.awt.Color(200, 120, 47));
        password.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(102, 32, 42));
        password.setText("Password");
        password.setOpaque(true);
        jPanel10.add(password, java.awt.BorderLayout.PAGE_START);

        pfPassword.setBackground(new java.awt.Color(225, 184, 120));
        pfPassword.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        pfPassword.setForeground(new java.awt.Color(102, 32, 42));
        pfPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 2, 0, new java.awt.Color(102, 32, 42)));
        jPanel10.add(pfPassword, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 117, -1));

        jPanel12.setLayout(new java.awt.BorderLayout());

        confirmPassword.setBackground(new java.awt.Color(200, 120, 47));
        confirmPassword.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        confirmPassword.setForeground(new java.awt.Color(102, 32, 42));
        confirmPassword.setText("Confirm Password");
        confirmPassword.setOpaque(true);
        jPanel12.add(confirmPassword, java.awt.BorderLayout.PAGE_START);

        pfConfirmPassword.setBackground(new java.awt.Color(225, 184, 120));
        pfConfirmPassword.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        pfConfirmPassword.setForeground(new java.awt.Color(102, 32, 42));
        pfConfirmPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 2, 0, new java.awt.Color(102, 32, 42)));
        jPanel12.add(pfConfirmPassword, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        bRegister.setBackground(new java.awt.Color(102, 32, 42));
        bRegister.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        bRegister.setForeground(new java.awt.Color(255, 255, 255));
        bRegister.setText("Register");
        bRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegisterActionPerformed(evt);
            }
        });
        jPanel4.add(bRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jPanel1.add(jPanel4);
        jPanel4.setBounds(20, 60, 240, 260);

        jPanel5.setBackground(new java.awt.Color(200, 120, 47));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 60));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backToLogin.setFont(new java.awt.Font("Figtree Light", 0, 14)); // NOI18N
        backToLogin.setForeground(new java.awt.Color(102, 32, 42));
        backToLogin.setText("Back to login");
        backToLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backToLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backToLoginMouseClicked(evt);
            }
        });
        jPanel5.add(backToLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 89, 20));

        jPanel1.add(jPanel5);
        jPanel5.setBounds(40, 320, 190, 30);

        jPanel2.setBackground(new java.awt.Color(255, 229, 206));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cineSys150.png"))); // NOI18N
        jLabel7.setMinimumSize(new java.awt.Dimension(300, 300));
        jLabel7.setPreferredSize(new java.awt.Dimension(300, 300));
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 309, 272));

        JLabelMin1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JLabelMin1.setForeground(new java.awt.Color(102, 32, 42));
        JLabelMin1.setText("−");
        JLabelMin1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLabelMin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLabelMin1MouseClicked(evt);
            }
        });
        jPanel2.add(JLabelMin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, -10, -1, -1));

        JLabelClose.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        JLabelClose.setForeground(new java.awt.Color(102, 32, 42));
        JLabelClose.setText("×");
        JLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLabelCloseMouseClicked(evt);
            }
        });
        jPanel2.add(JLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, -10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backToLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToLoginMouseClicked
            Login login = new Login ();
            dispose ();
            login.setVisible(true);
    }//GEN-LAST:event_backToLoginMouseClicked

    private void JLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelMinMouseClicked
        // minimize the form
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_JLabelMinMouseClicked

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

    private void bRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegisterActionPerformed
        registerAction();  
    }//GEN-LAST:event_bRegisterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelClose;
    private javax.swing.JLabel JLabelMin;
    private javax.swing.JLabel JLabelMin1;
    private javax.swing.JLabel Title;
    private javax.swing.JButton bRegister;
    private javax.swing.JLabel backToLogin;
    private javax.swing.JLabel confirmPassword;
    private javax.swing.JLabel firstName;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lastName;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField pfConfirmPassword;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JTextField tfUsername;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
