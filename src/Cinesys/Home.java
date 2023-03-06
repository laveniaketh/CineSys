
package Cinesys;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.print.*;


public class Home extends javax.swing.JFrame {
    
    PreparedStatement ps;
    ResultSet rs;
   String mname = "";
   String mtime = "";
   String seatList = "";
   int price = 200;
   ArrayList <String> movieList = new ArrayList();
   int tcktqty;
   String[] seatsSelect;
   String snum;
   int clickseat = 0;
   boolean checkseat = true;

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
    
    void setTime(String mt){
        this.mtime = mt;
    }
    
    public String getTime(){
        return mtime;
    }
    
   void setSeat(String snum){
        this.snum = snum;
    }
   
   String getSeat(){
       return snum;
   }
    
    void setTicketQty(int tqty){
        this.tcktqty = tqty;
    }
    
    public int getTicketQty(){
       return tcktqty;
   }
    
    void setSelectedSeat(String st){
        this.seatList = st;
    }
    
    public String getSelectedSeat(){
         return seatList;
    }
    
    void displaySelectMoviePanel(){
        //display movie panel at the home page
        movieTab.setBackground(new Color(249,235,196));
        confirmationTab.setBackground(new Color(200,120,47));
        doneTab.setBackground(new Color(200,120,47));
        movieSelectPage.setVisible(false);
        moviePage.setVisible(true);
        confirmationPage.setVisible(false);
        donePage.setVisible(false);
    }
    
    void displayConfirmationPanel(){
        //display confirmation panel at the home page
        confirmationTab.setBackground(new Color(249,235,196));
        movieTab.setBackground(new Color(200,120,47));
        doneTab.setBackground(new Color(200,120,47));
        movieSelectPage.setVisible(false);
        moviePage.setVisible(false);
        confirmationPage.setVisible(true);
        donePage.setVisible(false);
    }
    
    void displayDonePanel(){
        //display done panel at the home page
        doneTab.setBackground(new Color(249,235,196));
        movieTab.setBackground(new Color(200,120,47));
        confirmationTab.setBackground(new Color(200,120,47));
        movieSelectPage.setVisible(false);
        moviePage.setVisible(false);
        confirmationPage.setVisible(false);
        donePage.setVisible(true);
    }
    
    void displaySelectedMovie(){
        //display poster of the selected movie at the movieselectpanel
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
        receipttxt.setText(receipttxt.getText()+ "MOVIE : " + getMovie()+ "\n");
        receipttxt.setText(receipttxt.getText()+ "TIME  : " + getTime()+ "\n");
        receipttxt.setText(receipttxt.getText()+ "SEAT  : " + getSelectedSeat() + "\n");
        receipttxt.setText(receipttxt.getText()+ "\n");
        receipttxt.setText(receipttxt.getText()+ "---------------------------------------\n");
        receipttxt.setText(receipttxt.getText()+ "\n");
        receipttxt.setText(receipttxt.getText()+ "                                               " + price + "\n");
        receipttxt.setText(receipttxt.getText()+ "                                           x   " + getTicketQty()+ "\n");
        receipttxt.setText(receipttxt.getText()+ "                                       --------------\n");
        receipttxt.setText(receipttxt.getText()+ "TOTAL  :                                " + (price * getTicketQty()));
           
    }
    
    void reserveSeat(){
         // to disable seats that are already reserved/book
        String reserveSeat;
        String rmovie = getMovie();
        String rtime = (String) timeslotComboBox.getSelectedItem();
  
  
        try {
            ps = Database.connect().prepareStatement(" SELECT `Seat No.` FROM `customerlist` WHERE `Movie Title` = ? AND `Time` = ?");
            ps.setString(1, rmovie);
            ps.setString(2, rtime);
            rs = ps.executeQuery();
            while(rs.next() == true){
                reserveSeat = rs.getString(1);
                switch (reserveSeat) {
                    case "S1":
                        S1.setEnabled(false);
                        break;
                    case "S2":
                        S2.setEnabled(false);
                        break;
                    case "S3":
                        S3.setEnabled(false);
                        break;
                    case "S4":
                        S4.setEnabled(false);
                        break;
                    case "S5":
                        S5.setEnabled(false);
                        break;
                    case "S6":
                        S6.setEnabled(false);
                        break;
                    case "S7":
                        S7.setEnabled(false);
                        break;
                    case "S8":
                        S8.setEnabled(false);
                        break;
                    case "S9":
                        S9.setEnabled(false);
                        break;
                    case "S10":
                        S10.setEnabled(false);
                        break;
                    case "S11":
                        S11.setEnabled(false);
                        break;
                    case "S12":
                        S12.setEnabled(false);
                        break;
                    case "S13":
                        S13.setEnabled(false);
                        break;
                    case "S14":
                        S14.setEnabled(false);
                        break;
                    case "S15":
                        S15.setEnabled(false);
                        break;
                    case "S16":
                        S16.setEnabled(false);
                        break;
                    case "S17":
                        S17.setEnabled(false);
                        break;
                    case "S18":
                        S18.setEnabled(false);
                        break;
                    case "S19":
                        S19.setEnabled(false);
                        break;
                    case "S20":
                        S20.setEnabled(false);
                        break;
                    case "S21":
                        S21.setEnabled(false);
                        break;
                    case "S22":
                        S22.setEnabled(false);
                        break;
                    case "S23":
                        S23.setEnabled(false);
                        break;
                    case "S24":
                        S24.setEnabled(false);
                        break;
                    case "S25":
                        S25.setEnabled(false);
                        break;
                    case "S26":
                        S26.setEnabled(false);
                        break;
                    case "S27":
                        S27.setEnabled(false);
                        break;
                    case "S28":
                        S28.setEnabled(false);
                        break;
                    case "S29":
                        S29.setEnabled(false);
                        break;
                    case "S30":
                        S30.setEnabled(false);
                        break;
                    case "S31":
                        S31.setEnabled(false);
                        break;
                    case "S32":
                        S32.setEnabled(false);
                        break;
                    case "S33":
                        S33.setEnabled(false);
                        break;
                    case "S34":
                        S34.setEnabled(false);
                        break;
                    case "S35":
                        S35.setEnabled(false);
                        break;
                    case "S36":
                        S36.setEnabled(false);
                        break;
                    case "S37":
                        S37.setEnabled(false);
                        break;
                    case "S38":
                        S38.setEnabled(false);
                        break;
                    case "S39":
                        S39.setEnabled(false);
                        break;
                    case "S40":
                        S40.setEnabled(false);
                        break;
                    case "S41":
                        S41.setEnabled(false);
                        break;
                    case "S42":
                        S42.setEnabled(false);
                        break;
                    case "S43":
                        S43.setEnabled(false);
                        break;
                    case "S44":
                        S44.setEnabled(false);
                        break;
                    case "S45":
                        S45.setEnabled(false);
                        break;
                    case "S46":
                        S46.setEnabled(false);
                        break;
                    case "S47":
                        S47.setEnabled(false);
                        break;
                    case "S48":
                        S48.setEnabled(false);
                        break;
                    case "S49":
                        S49.setEnabled(false);
                        break;
                    case "S50":
                        S50.setEnabled(false);
                        break;
                    case "S51":
                        S51.setEnabled(false);
                        break;
                    case "S52":
                        S52.setEnabled(false);
                        break;
                    case "S53":
                        S53.setEnabled(false);
                        break;
                    case "S54":
                        S54.setEnabled(false);
                        break;
                    case "S55":
                        S55.setEnabled(false);
                        break;
                    case "S56":
                        S56.setEnabled(false);
                        break;
                    case "S57":
                        S57.setEnabled(false);
                        break;
                    case "S58":
                        S58.setEnabled(false);
                        break;
                    case "S59":
                        S59.setEnabled(false);
                        break;
                    case "S60":
                        S60.setEnabled(false);
                        break;
                    case "S61":
                        S61.setEnabled(false);
                        break;
                    case "S62":
                        S62.setEnabled(false);
                        break;
                    case "S63":
                        S63.setEnabled(false);
                        break;
                    case "S64":
                        S64.setEnabled(false);
                        break;
                    case "S65":
                        S65.setEnabled(false);
                        break;
                    case "S66":
                        S66.setEnabled(false);
                        break;
                    case "S67":
                        S67.setEnabled(false);
                        break;
                    case "S68":
                        S68.setEnabled(false);
                        break;
                    case "S69":
                        S69.setEnabled(false);
                        break;
                    case "S70":
                        S70.setEnabled(false);
                        break;
                    case "S71":
                        S71.setEnabled(false);
                        break;
                    case "S72":
                        S72.setEnabled(false);
                        break;
                    case "S73":
                        S73.setEnabled(false);
                        break;
                    case "S74":
                        S74.setEnabled(false);
                        break;
                    default:
                        setEnabled(true);
                        break;
                }
            

                }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

     }
    
    void insertSelectionToDatabase(){
        //send users booked info to database
        for(int i = 0; i < tcktqty; i++){
            String s = seatsSelect[i];
            String selectedMovie = getMovie();
           String selectedTime = (String) timeslotComboBox.getSelectedItem();
            int tq = i;
            try {
                ps = Database.connect().prepareStatement("INSERT INTO `customerlist`(`Movie Title`, `Time`, `Seat No.`) VALUES (?,?,?)");
                ps.setString(1, selectedMovie);
                ps.setString(2, selectedTime);
                ps.setString(3, s);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }JOptionPane.showMessageDialog(null,"Record Added");
    }
    
    void seatLimiter(){
        // will tell the user if theyre already exceeded seat selection
        if(clickseat == tcktqty){
            JOptionPane.showMessageDialog(null, "already exceeded seat selection");
            checkseat = false; 
        }else  checkseat = true; 
    }
    
    void enableAllButtons(){
        //to enable all buttons for resetting
        S1.setEnabled(true);
        S2.setEnabled(true);
        S3.setEnabled(true);
        S4.setEnabled(true);
        S5.setEnabled(true);
        S6.setEnabled(true);
        S7.setEnabled(true);
        S8.setEnabled(true);
        S9.setEnabled(true);
        S10.setEnabled(true);
        S11.setEnabled(true);
        S12.setEnabled(true);
        S13.setEnabled(true);
        S14.setEnabled(true);
        S15.setEnabled(true);
        S16.setEnabled(true);
        S17.setEnabled(true);
        S18.setEnabled(true);
        S19.setEnabled(true);
        S20.setEnabled(true);
        S21.setEnabled(true);
        S22.setEnabled(true);
        S23.setEnabled(true);
        S24.setEnabled(true);
        S25.setEnabled(true);
        S26.setEnabled(true);
        S27.setEnabled(true);
        S28.setEnabled(true);
        S29.setEnabled(true);
        S30.setEnabled(true);
        S31.setEnabled(true);
        S32.setEnabled(true);
        S33.setEnabled(true);
        S34.setEnabled(true);
        S35.setEnabled(true);
        S36.setEnabled(true);
        S37.setEnabled(true);
        S38.setEnabled(true);
        S39.setEnabled(true);
        S40.setEnabled(true);
        S41.setEnabled(true);
        S42.setEnabled(true);
        S43.setEnabled(true);
        S44.setEnabled(true);
        S45.setEnabled(true);
        S46.setEnabled(true);
        S47.setEnabled(true);
        S48.setEnabled(true);
        S49.setEnabled(true);
        S50.setEnabled(true);
        S51.setEnabled(true);
        S52.setEnabled(true);
        S53.setEnabled(true);
        S54.setEnabled(true);
        S55.setEnabled(true);
        S56.setEnabled(true);
        S57.setEnabled(true);
        S58.setEnabled(true);
        S59.setEnabled(true);
        S60.setEnabled(true);
        S61.setEnabled(true);
        S62.setEnabled(true);
        S63.setEnabled(true);
        S64.setEnabled(true);
        S65.setEnabled(true);
        S66.setEnabled(true);
        S67.setEnabled(true);
        S68.setEnabled(true);
        S69.setEnabled(true);
        S70.setEnabled(true);
        S71.setEnabled(true);
        S72.setEnabled(true);
        S73.setEnabled(true);
        S74.setEnabled(true);
    }
     
    void displayTimeSlot(){
        // display timeslot of the selected movie at the combobox
        timeslotComboBox.removeAllItems();
        String ts1,ts2,ts3;
        try {
            ps = Database.connect().prepareStatement("SELECT `Timeslot 1`, `Timeslot 2`, `Timeslot 3` FROM `movielist` WHERE `Movie Title` = ?");
            ps.setString(1, getMovie());
            rs = ps.executeQuery();
            while(rs.next()){
                ts1 = rs.getString(1);
                ts2 = rs.getString(2);
                ts3 = rs.getString(3);
                    
                timeslotComboBox.addItem(ts1);
                timeslotComboBox.addItem(ts2);
                timeslotComboBox.addItem(ts3);
                   
            }
                
        } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }       
               
    }
    
    void displaySummary(){
        //display summary at the confirmation panel

            for(int i = 0; i <tcktqty ; i++){
                String s = seatsSelect[i];
                seatList += s + " ";               
        }seatselectlbl.setText(seatList);
        setSelectedSeat(seatList);
         movielbl.setText(getMovie()); 
         timelbl.setText(getTime());
         setTicketQty(tcktqty);
         ticketnumlbl.setText(String.valueOf(getTicketQty()));
    }
  
    void displayPayment(){
         ticketnumlbl1.setText(String.valueOf(getTicketQty()));
         pricelbl.setText("200 php");
         int total = 200 * getTicketQty();
         totalpricelbl.setText(String.valueOf(total));
                 
         
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
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        timeslotComboBox = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        ticketqtytxt = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        S1 = new javax.swing.JButton();
        S2 = new javax.swing.JButton();
        S3 = new javax.swing.JButton();
        S4 = new javax.swing.JButton();
        S5 = new javax.swing.JButton();
        S6 = new javax.swing.JButton();
        S7 = new javax.swing.JButton();
        S8 = new javax.swing.JButton();
        S9 = new javax.swing.JButton();
        S10 = new javax.swing.JButton();
        S11 = new javax.swing.JButton();
        S12 = new javax.swing.JButton();
        S13 = new javax.swing.JButton();
        S14 = new javax.swing.JButton();
        S15 = new javax.swing.JButton();
        S16 = new javax.swing.JButton();
        S17 = new javax.swing.JButton();
        S18 = new javax.swing.JButton();
        S19 = new javax.swing.JButton();
        S20 = new javax.swing.JButton();
        S21 = new javax.swing.JButton();
        S22 = new javax.swing.JButton();
        S23 = new javax.swing.JButton();
        S24 = new javax.swing.JButton();
        S25 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        S26 = new javax.swing.JButton();
        S27 = new javax.swing.JButton();
        S28 = new javax.swing.JButton();
        S29 = new javax.swing.JButton();
        S30 = new javax.swing.JButton();
        S31 = new javax.swing.JButton();
        S32 = new javax.swing.JButton();
        S33 = new javax.swing.JButton();
        S34 = new javax.swing.JButton();
        S35 = new javax.swing.JButton();
        S36 = new javax.swing.JButton();
        S37 = new javax.swing.JButton();
        S38 = new javax.swing.JButton();
        S39 = new javax.swing.JButton();
        S40 = new javax.swing.JButton();
        S41 = new javax.swing.JButton();
        S42 = new javax.swing.JButton();
        S43 = new javax.swing.JButton();
        S44 = new javax.swing.JButton();
        S45 = new javax.swing.JButton();
        S46 = new javax.swing.JButton();
        S47 = new javax.swing.JButton();
        S48 = new javax.swing.JButton();
        S49 = new javax.swing.JButton();
        S50 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        S51 = new javax.swing.JButton();
        S52 = new javax.swing.JButton();
        S53 = new javax.swing.JButton();
        S54 = new javax.swing.JButton();
        S55 = new javax.swing.JButton();
        S56 = new javax.swing.JButton();
        S57 = new javax.swing.JButton();
        S58 = new javax.swing.JButton();
        S59 = new javax.swing.JButton();
        S60 = new javax.swing.JButton();
        S61 = new javax.swing.JButton();
        S62 = new javax.swing.JButton();
        S63 = new javax.swing.JButton();
        S64 = new javax.swing.JButton();
        S65 = new javax.swing.JButton();
        S66 = new javax.swing.JButton();
        S67 = new javax.swing.JButton();
        S68 = new javax.swing.JButton();
        S69 = new javax.swing.JButton();
        S70 = new javax.swing.JButton();
        S71 = new javax.swing.JButton();
        S72 = new javax.swing.JButton();
        S73 = new javax.swing.JButton();
        S74 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        resetMoviePageB = new javax.swing.JButton();
        confirmationPage = new javax.swing.JPanel();
        mselectposterlbl = new javax.swing.JLabel();
        confirmConfirmationPageB = new javax.swing.JButton();
        backConfirmationPageB = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        movielbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        timelbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ticketnumlbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        seatselectlbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        ticketnumlbl1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pricelbl = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        totalpricelbl = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        donePage = new javax.swing.JPanel();
        printDonePageB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        receipttxt = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        backToHomeB = new javax.swing.JLabel();

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

        jPanel4.setBackground(new java.awt.Color(249, 235, 196));
        jPanel4.setLayout(new java.awt.GridLayout(2, 2, 0, 25));

        jLabel24.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 32, 42));
        jLabel24.setText("Select Time :");
        jPanel4.add(jLabel24);

        timeslotComboBox.setBackground(new java.awt.Color(227, 183, 120));
        timeslotComboBox.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        timeslotComboBox.setForeground(new java.awt.Color(102, 32, 42));
        timeslotComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        timeslotComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                timeslotComboBoxItemStateChanged(evt);
            }
        });
        jPanel4.add(timeslotComboBox);

        jLabel25.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 32, 42));
        jLabel25.setText("Ticket Qty :");
        jPanel4.add(jLabel25);

        ticketqtytxt.setBackground(new java.awt.Color(255, 255, 255));
        ticketqtytxt.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        ticketqtytxt.setForeground(new java.awt.Color(102, 32, 42));
        ticketqtytxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ticketqtytxtKeyReleased(evt);
            }
        });
        jPanel4.add(ticketqtytxt);

        jPanel5.setBackground(new java.awt.Color(249, 235, 196));
        jPanel5.setLayout(new java.awt.GridLayout(5, 5, 10, 10));

        S1.setText("1");
        S1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S1ActionPerformed(evt);
            }
        });
        jPanel5.add(S1);

        S2.setText("2");
        S2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S2ActionPerformed(evt);
            }
        });
        jPanel5.add(S2);

        S3.setText("3");
        S3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S3ActionPerformed(evt);
            }
        });
        jPanel5.add(S3);

        S4.setText("4");
        S4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S4ActionPerformed(evt);
            }
        });
        jPanel5.add(S4);

        S5.setText("5");
        S5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S5ActionPerformed(evt);
            }
        });
        jPanel5.add(S5);

        S6.setText("6");
        S6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S6ActionPerformed(evt);
            }
        });
        jPanel5.add(S6);

        S7.setText("7");
        S7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S7ActionPerformed(evt);
            }
        });
        jPanel5.add(S7);

        S8.setText("8");
        S8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S8ActionPerformed(evt);
            }
        });
        jPanel5.add(S8);

        S9.setText("9");
        S9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S9ActionPerformed(evt);
            }
        });
        jPanel5.add(S9);

        S10.setText("10");
        S10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S10ActionPerformed(evt);
            }
        });
        jPanel5.add(S10);

        S11.setText("11");
        S11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S11ActionPerformed(evt);
            }
        });
        jPanel5.add(S11);

        S12.setText("12");
        S12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S12ActionPerformed(evt);
            }
        });
        jPanel5.add(S12);

        S13.setText("13");
        S13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S13ActionPerformed(evt);
            }
        });
        jPanel5.add(S13);

        S14.setText("14");
        S14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S14ActionPerformed(evt);
            }
        });
        jPanel5.add(S14);

        S15.setText("15");
        S15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S15ActionPerformed(evt);
            }
        });
        jPanel5.add(S15);

        S16.setText("16");
        S16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S16ActionPerformed(evt);
            }
        });
        jPanel5.add(S16);

        S17.setText("17");
        S17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S17ActionPerformed(evt);
            }
        });
        jPanel5.add(S17);

        S18.setText("18");
        S18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S18ActionPerformed(evt);
            }
        });
        jPanel5.add(S18);

        S19.setText("19");
        S19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S19ActionPerformed(evt);
            }
        });
        jPanel5.add(S19);

        S20.setText("20");
        S20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S20ActionPerformed(evt);
            }
        });
        jPanel5.add(S20);

        S21.setText("21");
        S21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S21ActionPerformed(evt);
            }
        });
        jPanel5.add(S21);

        S22.setText("22");
        S22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S22ActionPerformed(evt);
            }
        });
        jPanel5.add(S22);

        S23.setText("23");
        S23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S23ActionPerformed(evt);
            }
        });
        jPanel5.add(S23);

        S24.setText("24");
        S24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S24ActionPerformed(evt);
            }
        });
        jPanel5.add(S24);

        S25.setText("25");
        S25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S25ActionPerformed(evt);
            }
        });
        jPanel5.add(S25);

        jPanel6.setBackground(new java.awt.Color(249, 235, 196));
        jPanel6.setLayout(new java.awt.GridLayout(5, 5, 10, 10));

        S26.setText("26");
        S26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S26ActionPerformed(evt);
            }
        });
        jPanel6.add(S26);

        S27.setText("27");
        S27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S27ActionPerformed(evt);
            }
        });
        jPanel6.add(S27);

        S28.setText("28");
        S28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S28ActionPerformed(evt);
            }
        });
        jPanel6.add(S28);

        S29.setText("29");
        S29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S29ActionPerformed(evt);
            }
        });
        jPanel6.add(S29);

        S30.setText("30");
        S30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S30ActionPerformed(evt);
            }
        });
        jPanel6.add(S30);

        S31.setText("31");
        S31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S31ActionPerformed(evt);
            }
        });
        jPanel6.add(S31);

        S32.setText("32");
        S32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S32ActionPerformed(evt);
            }
        });
        jPanel6.add(S32);

        S33.setText("33");
        S33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S33ActionPerformed(evt);
            }
        });
        jPanel6.add(S33);

        S34.setText("34");
        S34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S34ActionPerformed(evt);
            }
        });
        jPanel6.add(S34);

        S35.setText("35");
        S35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S35ActionPerformed(evt);
            }
        });
        jPanel6.add(S35);

        S36.setText("36");
        S36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S36ActionPerformed(evt);
            }
        });
        jPanel6.add(S36);

        S37.setText("37");
        S37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S37ActionPerformed(evt);
            }
        });
        jPanel6.add(S37);

        S38.setText("38");
        S38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S38ActionPerformed(evt);
            }
        });
        jPanel6.add(S38);

        S39.setText("39");
        S39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S39ActionPerformed(evt);
            }
        });
        jPanel6.add(S39);

        S40.setText("40");
        S40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S40ActionPerformed(evt);
            }
        });
        jPanel6.add(S40);

        S41.setText("41");
        S41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S41ActionPerformed(evt);
            }
        });
        jPanel6.add(S41);

        S42.setText("42");
        S42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S42ActionPerformed(evt);
            }
        });
        jPanel6.add(S42);

        S43.setText("43");
        S43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S43ActionPerformed(evt);
            }
        });
        jPanel6.add(S43);

        S44.setText("44");
        S44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S44ActionPerformed(evt);
            }
        });
        jPanel6.add(S44);

        S45.setText("45");
        S45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S45ActionPerformed(evt);
            }
        });
        jPanel6.add(S45);

        S46.setText("46");
        S46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S46ActionPerformed(evt);
            }
        });
        jPanel6.add(S46);

        S47.setText("47");
        S47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S47ActionPerformed(evt);
            }
        });
        jPanel6.add(S47);

        S48.setText("48");
        S48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S48ActionPerformed(evt);
            }
        });
        jPanel6.add(S48);

        S49.setText("49");
        S49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S49ActionPerformed(evt);
            }
        });
        jPanel6.add(S49);

        S50.setText("50");
        S50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S50ActionPerformed(evt);
            }
        });
        jPanel6.add(S50);

        jPanel7.setBackground(new java.awt.Color(249, 235, 196));
        jPanel7.setLayout(new java.awt.GridLayout(4, 6, 10, 10));

        S51.setText("51");
        S51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S51ActionPerformed(evt);
            }
        });
        jPanel7.add(S51);

        S52.setText("52");
        S52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S52ActionPerformed(evt);
            }
        });
        jPanel7.add(S52);

        S53.setText("53");
        S53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S53ActionPerformed(evt);
            }
        });
        jPanel7.add(S53);

        S54.setText("54");
        S54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S54ActionPerformed(evt);
            }
        });
        jPanel7.add(S54);

        S55.setText("55");
        S55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S55ActionPerformed(evt);
            }
        });
        jPanel7.add(S55);

        S56.setText("56");
        S56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S56ActionPerformed(evt);
            }
        });
        jPanel7.add(S56);

        S57.setText("57");
        S57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S57ActionPerformed(evt);
            }
        });
        jPanel7.add(S57);

        S58.setText("58");
        S58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S58ActionPerformed(evt);
            }
        });
        jPanel7.add(S58);

        S59.setText("59");
        S59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S59ActionPerformed(evt);
            }
        });
        jPanel7.add(S59);

        S60.setText("60");
        S60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S60ActionPerformed(evt);
            }
        });
        jPanel7.add(S60);

        S61.setText("61");
        S61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S61ActionPerformed(evt);
            }
        });
        jPanel7.add(S61);

        S62.setText("62");
        S62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S62ActionPerformed(evt);
            }
        });
        jPanel7.add(S62);

        S63.setText("63");
        S63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S63ActionPerformed(evt);
            }
        });
        jPanel7.add(S63);

        S64.setText("64");
        S64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S64ActionPerformed(evt);
            }
        });
        jPanel7.add(S64);

        S65.setText("65");
        S65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S65ActionPerformed(evt);
            }
        });
        jPanel7.add(S65);

        S66.setText("66");
        S66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S66ActionPerformed(evt);
            }
        });
        jPanel7.add(S66);

        S67.setText("67");
        S67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S67ActionPerformed(evt);
            }
        });
        jPanel7.add(S67);

        S68.setText("68");
        S68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S68ActionPerformed(evt);
            }
        });
        jPanel7.add(S68);

        S69.setText("69");
        S69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S69ActionPerformed(evt);
            }
        });
        jPanel7.add(S69);

        S70.setText("70");
        S70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S70ActionPerformed(evt);
            }
        });
        jPanel7.add(S70);

        S71.setText("71");
        S71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S71ActionPerformed(evt);
            }
        });
        jPanel7.add(S71);

        S72.setText("72");
        S72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S72ActionPerformed(evt);
            }
        });
        jPanel7.add(S72);

        S73.setText("73");
        S73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S73ActionPerformed(evt);
            }
        });
        jPanel7.add(S73);

        S74.setText("74");
        S74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S74ActionPerformed(evt);
            }
        });
        jPanel7.add(S74);

        jPanel8.setBackground(new java.awt.Color(102, 32, 42));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        resetMoviePageB.setBackground(new java.awt.Color(102, 32, 42));
        resetMoviePageB.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        resetMoviePageB.setForeground(new java.awt.Color(255, 255, 255));
        resetMoviePageB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/reset.png"))); // NOI18N
        resetMoviePageB.setText("Reset Selected Seat");
        resetMoviePageB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMoviePageBMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout moviePageLayout = new javax.swing.GroupLayout(moviePage);
        moviePage.setLayout(moviePageLayout);
        moviePageLayout.setHorizontalGroup(
            moviePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moviePageLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(backMoviePageB)
                .addGap(98, 98, 98)
                .addComponent(nextMoviePageB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(254, 254, 254))
            .addGroup(moviePageLayout.createSequentialGroup()
                .addGroup(moviePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(moviePageLayout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(resetMoviePageB))
                    .addGroup(moviePageLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(98, 98, 98)
                .addGroup(moviePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(moviePageLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        moviePageLayout.setVerticalGroup(
            moviePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moviePageLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(moviePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(moviePageLayout.createSequentialGroup()
                        .addGroup(moviePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, moviePageLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resetMoviePageB)
                        .addGap(51, 51, 51)))
                .addGroup(moviePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(moviePageLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(moviePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backMoviePageB)
                        .addComponent(nextMoviePageB)))
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
        backConfirmationPageB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backConfirmationPageBActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setLayout(new java.awt.GridLayout(4, 2));

        jLabel2.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 32, 42));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Movie :");
        jPanel2.add(jLabel2);

        movielbl.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        movielbl.setForeground(new java.awt.Color(102, 32, 42));
        jPanel2.add(movielbl);

        jLabel4.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 32, 42));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Time :");
        jPanel2.add(jLabel4);

        timelbl.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        timelbl.setForeground(new java.awt.Color(102, 32, 42));
        jPanel2.add(timelbl);

        jLabel3.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 32, 42));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("No. of Tickets :");
        jPanel2.add(jLabel3);

        ticketnumlbl.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        ticketnumlbl.setForeground(new java.awt.Color(102, 32, 42));
        jPanel2.add(ticketnumlbl);

        jLabel8.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 32, 42));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Selected seat(s):");
        jPanel2.add(jLabel8);

        seatselectlbl.setFont(new java.awt.Font("Figtree Light", 0, 12)); // NOI18N
        seatselectlbl.setForeground(new java.awt.Color(102, 32, 42));
        jPanel2.add(seatselectlbl);

        jLabel9.setFont(new java.awt.Font("Figtree", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 32, 42));
        jLabel9.setText("Payment Details");

        jPanel3.setBackground(new java.awt.Color(255, 204, 102));
        jPanel3.setLayout(new java.awt.GridLayout(3, 2));

        jLabel15.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 32, 42));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("No. of Tickets :");
        jPanel3.add(jLabel15);

        ticketnumlbl1.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        ticketnumlbl1.setForeground(new java.awt.Color(102, 32, 42));
        jPanel3.add(ticketnumlbl1);

        jLabel17.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 32, 42));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Price :");
        jPanel3.add(jLabel17);

        pricelbl.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        pricelbl.setForeground(new java.awt.Color(102, 32, 42));
        jPanel3.add(pricelbl);

        jLabel11.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 32, 42));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Total :");
        jPanel3.add(jLabel11);

        totalpricelbl.setFont(new java.awt.Font("Figtree Light", 0, 24)); // NOI18N
        totalpricelbl.setForeground(new java.awt.Color(102, 32, 42));
        jPanel3.add(totalpricelbl);

        jLabel19.setFont(new java.awt.Font("Figtree", 0, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 32, 42));
        jLabel19.setText("Summary");

        javax.swing.GroupLayout confirmationPageLayout = new javax.swing.GroupLayout(confirmationPage);
        confirmationPage.setLayout(confirmationPageLayout);
        confirmationPageLayout.setHorizontalGroup(
            confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmationPageLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(mselectposterlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(confirmationPageLayout.createSequentialGroup()
                        .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(confirmationPageLayout.createSequentialGroup()
                                .addGap(299, 299, 299)
                                .addComponent(backConfirmationPageB))
                            .addGroup(confirmationPageLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(69, 69, 69)
                        .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmConfirmationPageB))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(confirmationPageLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(198, 198, 198))))
        );
        confirmationPageLayout.setVerticalGroup(
            confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmationPageLayout.createSequentialGroup()
                .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(confirmationPageLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(mselectposterlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(confirmationPageLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87)
                        .addGroup(confirmationPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(confirmConfirmationPageB)
                            .addComponent(backConfirmationPageB))))
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

        backToHomeB.setFont(new java.awt.Font("Figtree", 0, 24)); // NOI18N
        backToHomeB.setForeground(new java.awt.Color(102, 32, 42));
        backToHomeB.setText("Back to Home");
        backToHomeB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backToHomeB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backToHomeBMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout donePageLayout = new javax.swing.GroupLayout(donePage);
        donePage.setLayout(donePageLayout);
        donePageLayout.setHorizontalGroup(
            donePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(donePageLayout.createSequentialGroup()
                .addGroup(donePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, donePageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backToHomeB)
                        .addGap(305, 305, 305)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(26, 26, 26)
                        .addComponent(backToHomeB)
                        .addGap(32, 32, 32)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
         displayTimeSlot();
         displaySelectMoviePanel();
        
         
        
    }//GEN-LAST:event_movie1BMouseClicked

    private void movie2BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movie2BMouseClicked
        // TODO add your handling code here:
        allMoviesToArray();
        mname = movieList.get(1);
        setMovie(mname);
        displayTimeSlot();
        displaySelectMoviePanel();


        
    }//GEN-LAST:event_movie2BMouseClicked

    private void movie3BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movie3BMouseClicked
        // TODO add your handling code here:
        allMoviesToArray();
        mname = movieList.get(2);
        setMovie(mname);
        displayTimeSlot();
        displaySelectMoviePanel();

        
    }//GEN-LAST:event_movie3BMouseClicked

    private void movie4BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movie4BMouseClicked
        // TODO add your handling code here:
        allMoviesToArray();
        mname = movieList.get(3);
        setMovie(mname);
        displayTimeSlot();
        displaySelectMoviePanel();

        
    }//GEN-LAST:event_movie4BMouseClicked

    private void backMoviePageBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMoviePageBMouseClicked
        // TODO add your handling code here:
        enableAllButtons();
        displayMovieSelectPanel();
    }//GEN-LAST:event_backMoviePageBMouseClicked

    private void nextMoviePageBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMoviePageBMouseClicked
        // TODO add your handling code here:
        if(clickseat < tcktqty){//tells the user if they still lack seat selection
            JOptionPane.showMessageDialog(null, "pls select " + (tcktqty - clickseat)+ " more seat(s)" );
        }else{
            mtime = (String) timeslotComboBox.getSelectedItem();
            setTime(mtime);
            displayConfirmationPanel();
            displaySelectedMovie();
            displaySummary();
            displayPayment();
            
        }
        
    }//GEN-LAST:event_nextMoviePageBMouseClicked

    private void confirmConfirmationPageBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmConfirmationPageBMouseClicked
        // TODO add your handling code here:
        insertSelectionToDatabase();
        displayDonePanel();
        generateReceipt();
    }//GEN-LAST:event_confirmConfirmationPageBMouseClicked

    private void backConfirmationPageBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backConfirmationPageBMouseClicked
        // TODO add your handling code here:
        clickseat = 0;
        enableAllButtons();
        reserveSeat();
        displaySelectMoviePanel();
        
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
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void JLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelCloseMouseClicked
        //close the form
        System.exit(0);
    }//GEN-LAST:event_JLabelCloseMouseClicked

    private void JLabelMin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabelMin1MouseClicked
        // minimize the page
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_JLabelMin1MouseClicked

    private void backToHomeBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToHomeBMouseClicked
        // TODO add your handling code here:
        dispose();
        new Start().setVisible(true);
    }//GEN-LAST:event_backToHomeBMouseClicked

    private void timeslotComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_timeslotComboBoxItemStateChanged
        //disable reserve seats
        enableAllButtons();
        if(evt.getStateChange() == ItemEvent.SELECTED ){
            reserveSeat();
        }
    }//GEN-LAST:event_timeslotComboBoxItemStateChanged

    private void S1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S1ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S1";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S1.setEnabled(false);
        }
    }//GEN-LAST:event_S1ActionPerformed

    private void S2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S2ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S2";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S2.setEnabled(false);
        }
    }//GEN-LAST:event_S2ActionPerformed

    private void S3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S3ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S3";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S3.setEnabled(false);
        }
    }//GEN-LAST:event_S3ActionPerformed

    private void S4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S4ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S4";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S4.setEnabled(false);
        }
    }//GEN-LAST:event_S4ActionPerformed

    private void S5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S5ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S5";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S5.setEnabled(false);
        }
    }//GEN-LAST:event_S5ActionPerformed

    private void S6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S6ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S6";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S6.setEnabled(false);
        }
    }//GEN-LAST:event_S6ActionPerformed

    private void S7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S7ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S7";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S7.setEnabled(false);
        }
    }//GEN-LAST:event_S7ActionPerformed

    private void S8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S8ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S8";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S8.setEnabled(false);
        }
    }//GEN-LAST:event_S8ActionPerformed

    private void S9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S9ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S9";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S9.setEnabled(false);
        }
    }//GEN-LAST:event_S9ActionPerformed

    private void S10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S10ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S10";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S10.setEnabled(false);
        }
    }//GEN-LAST:event_S10ActionPerformed

    private void S11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S11ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S11";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S11.setEnabled(false);
        }
    }//GEN-LAST:event_S11ActionPerformed

    private void S12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S12ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S12";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S12.setEnabled(false);
        }
    }//GEN-LAST:event_S12ActionPerformed

    private void S13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S13ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S13";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S13.setEnabled(false);
        }
    }//GEN-LAST:event_S13ActionPerformed

    private void S14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S14ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S14";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S14.setEnabled(false);
        }
    }//GEN-LAST:event_S14ActionPerformed

    private void S15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S15ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S15";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S15.setEnabled(false);
        }
    }//GEN-LAST:event_S15ActionPerformed

    private void S16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S16ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S16";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S16.setEnabled(false);
        }
    }//GEN-LAST:event_S16ActionPerformed

    private void S17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S17ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S17";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S17.setEnabled(false);
        }
    }//GEN-LAST:event_S17ActionPerformed

    private void S18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S18ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S18";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S18.setEnabled(false);
        }
    }//GEN-LAST:event_S18ActionPerformed

    private void S19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S19ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S19";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S19.setEnabled(false);
        }
    }//GEN-LAST:event_S19ActionPerformed

    private void S20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S20ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S20";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S20.setEnabled(false);
        }
    }//GEN-LAST:event_S20ActionPerformed

    private void S21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S21ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S21";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S21.setEnabled(false);
        }
    }//GEN-LAST:event_S21ActionPerformed

    private void S22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S22ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S22";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S22.setEnabled(false);
        }
    }//GEN-LAST:event_S22ActionPerformed

    private void S23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S23ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S23";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S23.setEnabled(false);
        }
    }//GEN-LAST:event_S23ActionPerformed

    private void S24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S24ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S24";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S24.setEnabled(false);
        }
    }//GEN-LAST:event_S24ActionPerformed

    private void S25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S25ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S25";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S25.setEnabled(false);
        }
    }//GEN-LAST:event_S25ActionPerformed

    private void S26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S26ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S26";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S26.setEnabled(false);
        }
    }//GEN-LAST:event_S26ActionPerformed

    private void S27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S27ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S27";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S27.setEnabled(false);
        }
    }//GEN-LAST:event_S27ActionPerformed

    private void S28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S28ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S28";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S28.setEnabled(false);
        }
    }//GEN-LAST:event_S28ActionPerformed

    private void S29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S29ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S29";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S29.setEnabled(false);
        }
    }//GEN-LAST:event_S29ActionPerformed

    private void S30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S30ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S30";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S30.setEnabled(false);
        }
    }//GEN-LAST:event_S30ActionPerformed

    private void S31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S31ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S31";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S31.setEnabled(false);
        }
    }//GEN-LAST:event_S31ActionPerformed

    private void S32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S32ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S32";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S32.setEnabled(false);
        }
    }//GEN-LAST:event_S32ActionPerformed

    private void S33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S33ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S33";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S33.setEnabled(false);
        }
    }//GEN-LAST:event_S33ActionPerformed

    private void S34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S34ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S34";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S34.setEnabled(false);
        }
    }//GEN-LAST:event_S34ActionPerformed

    private void S35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S35ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S35";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S35.setEnabled(false);
        }
    }//GEN-LAST:event_S35ActionPerformed

    private void S36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S36ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S36";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S36.setEnabled(false);
        }
    }//GEN-LAST:event_S36ActionPerformed

    private void S37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S37ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S37";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S37.setEnabled(false);
        }
    }//GEN-LAST:event_S37ActionPerformed

    private void S38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S38ActionPerformed
       // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S38";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S38.setEnabled(false);
        }
    }//GEN-LAST:event_S38ActionPerformed

    private void S39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S39ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S39";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S39.setEnabled(false);
        }
    }//GEN-LAST:event_S39ActionPerformed

    private void S40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S40ActionPerformed
       // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S40";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S40.setEnabled(false);
        }
    }//GEN-LAST:event_S40ActionPerformed

    private void S41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S41ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S41";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S41.setEnabled(false);
        }
    }//GEN-LAST:event_S41ActionPerformed

    private void S42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S42ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S42";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S42.setEnabled(false);
        }
    }//GEN-LAST:event_S42ActionPerformed

    private void S43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S43ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S43";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S43.setEnabled(false);
        }
    }//GEN-LAST:event_S43ActionPerformed

    private void S44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S44ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S44";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S44.setEnabled(false);
        }
    }//GEN-LAST:event_S44ActionPerformed

    private void S45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S45ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S45";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S45.setEnabled(false);
        }
    }//GEN-LAST:event_S45ActionPerformed

    private void S46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S46ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S46";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S46.setEnabled(false);
        }
    }//GEN-LAST:event_S46ActionPerformed

    private void S47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S47ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S47";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S47.setEnabled(false);
        }
    }//GEN-LAST:event_S47ActionPerformed

    private void S48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S48ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S48";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S48.setEnabled(false);
        }
    }//GEN-LAST:event_S48ActionPerformed

    private void S49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S49ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S49";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S49.setEnabled(false);
        }
    }//GEN-LAST:event_S49ActionPerformed

    private void S50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S50ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S50";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S50.setEnabled(false);
        }
    }//GEN-LAST:event_S50ActionPerformed

    private void S51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S51ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S51";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S51.setEnabled(false);
        }
    }//GEN-LAST:event_S51ActionPerformed

    private void S52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S52ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S52";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S52.setEnabled(false);
        }
    }//GEN-LAST:event_S52ActionPerformed

    private void S53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S53ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S53";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S53.setEnabled(false);
        }
    }//GEN-LAST:event_S53ActionPerformed

    private void S54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S54ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S54";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S54.setEnabled(false);
        }
    }//GEN-LAST:event_S54ActionPerformed

    private void S55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S55ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S55";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S55.setEnabled(false);
        }
    }//GEN-LAST:event_S55ActionPerformed

    private void S56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S56ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S56";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S56.setEnabled(false);
        }
    }//GEN-LAST:event_S56ActionPerformed

    private void S57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S57ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S57";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S57.setEnabled(false);
        }
    }//GEN-LAST:event_S57ActionPerformed

    private void S58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S58ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S58";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S58.setEnabled(false);
        }
    }//GEN-LAST:event_S58ActionPerformed

    private void S59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S59ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S59";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S59.setEnabled(false);
        }
    }//GEN-LAST:event_S59ActionPerformed

    private void S60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S60ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S60";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S60.setEnabled(false);
        }
    }//GEN-LAST:event_S60ActionPerformed

    private void S61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S61ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S61";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S61.setEnabled(false);
        }
    }//GEN-LAST:event_S61ActionPerformed

    private void S62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S62ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S62";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S62.setEnabled(false);
        }
    }//GEN-LAST:event_S62ActionPerformed

    private void S63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S63ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S63";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S63.setEnabled(false);
        }
    }//GEN-LAST:event_S63ActionPerformed

    private void S64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S64ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S64";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S64.setEnabled(false);
        }
    }//GEN-LAST:event_S64ActionPerformed

    private void S65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S65ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S65";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S65.setEnabled(false);
        }
    }//GEN-LAST:event_S65ActionPerformed

    private void S66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S66ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S66";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S66.setEnabled(false);
        }
    }//GEN-LAST:event_S66ActionPerformed

    private void S67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S67ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S67";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S67.setEnabled(false);
        }
    }//GEN-LAST:event_S67ActionPerformed

    private void S68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S68ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S68";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S68.setEnabled(false);
        }
    }//GEN-LAST:event_S68ActionPerformed

    private void S69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S69ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S69";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S69.setEnabled(false);
        }
    }//GEN-LAST:event_S69ActionPerformed

    private void S70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S70ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S70";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S70.setEnabled(false);
        }
    }//GEN-LAST:event_S70ActionPerformed

    private void S71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S71ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S71";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S71.setEnabled(false);
        }
    }//GEN-LAST:event_S71ActionPerformed

    private void S72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S72ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S72";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S72.setEnabled(false);
        }
    }//GEN-LAST:event_S72ActionPerformed

    private void S73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S73ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S73";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S73.setEnabled(false);
        }
    }//GEN-LAST:event_S73ActionPerformed

    private void S74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S74ActionPerformed
        // disable the button if clicked and get the selected seat no
        seatLimiter();
        if(checkseat){
            clickseat++;
            snum = "S74";
            setSeat(snum);
            seatsSelect[clickseat - 1] = getSeat();
            S74.setEnabled(false);
        }
    }//GEN-LAST:event_S74ActionPerformed

    private void resetMoviePageBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMoviePageBMouseClicked
        // reset selected seats
        clickseat = 0;
        enableAllButtons();
        reserveSeat();
        
    }//GEN-LAST:event_resetMoviePageBMouseClicked

    private void ticketqtytxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ticketqtytxtKeyReleased
        // TODO add your handling code here:
        if(ticketqtytxt.getText().length()>0){
        tcktqty = Integer.parseInt(ticketqtytxt.getText());
        seatsSelect = new String[tcktqty];
;
        }
    }//GEN-LAST:event_ticketqtytxtKeyReleased

    private void backConfirmationPageBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backConfirmationPageBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backConfirmationPageBActionPerformed


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
    private javax.swing.JButton S1;
    private javax.swing.JButton S10;
    private javax.swing.JButton S11;
    private javax.swing.JButton S12;
    private javax.swing.JButton S13;
    private javax.swing.JButton S14;
    private javax.swing.JButton S15;
    private javax.swing.JButton S16;
    private javax.swing.JButton S17;
    private javax.swing.JButton S18;
    private javax.swing.JButton S19;
    private javax.swing.JButton S2;
    private javax.swing.JButton S20;
    private javax.swing.JButton S21;
    private javax.swing.JButton S22;
    private javax.swing.JButton S23;
    private javax.swing.JButton S24;
    private javax.swing.JButton S25;
    private javax.swing.JButton S26;
    private javax.swing.JButton S27;
    private javax.swing.JButton S28;
    private javax.swing.JButton S29;
    private javax.swing.JButton S3;
    private javax.swing.JButton S30;
    private javax.swing.JButton S31;
    private javax.swing.JButton S32;
    private javax.swing.JButton S33;
    private javax.swing.JButton S34;
    private javax.swing.JButton S35;
    private javax.swing.JButton S36;
    private javax.swing.JButton S37;
    private javax.swing.JButton S38;
    private javax.swing.JButton S39;
    private javax.swing.JButton S4;
    private javax.swing.JButton S40;
    private javax.swing.JButton S41;
    private javax.swing.JButton S42;
    private javax.swing.JButton S43;
    private javax.swing.JButton S44;
    private javax.swing.JButton S45;
    private javax.swing.JButton S46;
    private javax.swing.JButton S47;
    private javax.swing.JButton S48;
    private javax.swing.JButton S49;
    private javax.swing.JButton S5;
    private javax.swing.JButton S50;
    private javax.swing.JButton S51;
    private javax.swing.JButton S52;
    private javax.swing.JButton S53;
    private javax.swing.JButton S54;
    private javax.swing.JButton S55;
    private javax.swing.JButton S56;
    private javax.swing.JButton S57;
    private javax.swing.JButton S58;
    private javax.swing.JButton S59;
    private javax.swing.JButton S6;
    private javax.swing.JButton S60;
    private javax.swing.JButton S61;
    private javax.swing.JButton S62;
    private javax.swing.JButton S63;
    private javax.swing.JButton S64;
    private javax.swing.JButton S65;
    private javax.swing.JButton S66;
    private javax.swing.JButton S67;
    private javax.swing.JButton S68;
    private javax.swing.JButton S69;
    private javax.swing.JButton S7;
    private javax.swing.JButton S70;
    private javax.swing.JButton S71;
    private javax.swing.JButton S72;
    private javax.swing.JButton S73;
    private javax.swing.JButton S74;
    private javax.swing.JButton S8;
    private javax.swing.JButton S9;
    private javax.swing.JButton backConfirmationPageB;
    private javax.swing.JButton backMoviePageB;
    private javax.swing.JLabel backToHomeB;
    private javax.swing.JButton confirmConfirmationPageB;
    private javax.swing.JLabel confirmation;
    private javax.swing.JPanel confirmationPage;
    private javax.swing.JPanel confirmationTab;
    private javax.swing.JLabel done;
    private javax.swing.JPanel donePage;
    private javax.swing.JPanel doneTab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton movie1B;
    private javax.swing.JButton movie2B;
    private javax.swing.JButton movie3B;
    private javax.swing.JButton movie4B;
    private javax.swing.JPanel moviePage;
    private javax.swing.JPanel movieSelectPage;
    private javax.swing.JPanel movieTab;
    private javax.swing.JLabel movielbl;
    private javax.swing.JLabel mselectposterlbl;
    private javax.swing.JButton nextMoviePageB;
    private javax.swing.JLabel pricelbl;
    private javax.swing.JButton printDonePageB;
    private javax.swing.JTextArea receipttxt;
    private javax.swing.JButton resetMoviePageB;
    private javax.swing.JLabel seatselectlbl;
    private javax.swing.JLabel selectMovie;
    private javax.swing.JLabel ticketnumlbl;
    private javax.swing.JLabel ticketnumlbl1;
    private javax.swing.JTextField ticketqtytxt;
    private javax.swing.JLabel timelbl;
    private javax.swing.JComboBox<String> timeslotComboBox;
    private javax.swing.JLabel totalpricelbl;
    // End of variables declaration//GEN-END:variables
}
