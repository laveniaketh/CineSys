
package Cinesys;

public class User {
     
    
    private String firstname,lastname,username,password,repassword;
    
    void setFirstname(String fn){
        this.firstname = fn;
    }
    void setLastname(String ln){
        this.lastname = ln;
    }
    void setUsername(String un){
        this.username = un;   
    }
    void setPassword(String pw){
        this.password = pw;
    }
    void setRepassword(String rpw){
        this.repassword = rpw;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getRepassword() {
        return repassword;
    }
    
    
    
    
    
    
 
}
