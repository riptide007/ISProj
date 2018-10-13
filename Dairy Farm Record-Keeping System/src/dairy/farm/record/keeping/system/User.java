package dairy.farm.record.keeping.system;



import dairy.farm.record.keeping.system.DBConnect;
import dairy.farm.record.keeping.system.HasherSha1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class User  {
    

    String uname;
    String password;
    String CPassword;
    boolean isCorrect;

    DBConnect db = new DBConnect();//db instance
    Connection myCon = db.myConnect(); //db connection instance
    HasherSha1 jk = new HasherSha1(); //hashing class instance
    
    public User(){
        
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCPassword() {
        return CPassword;
    }

    public void setCPassword(String CPassword) {
        this.CPassword = CPassword;
    }

    public boolean isIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
    
    public void clear(){
        setCPassword(null);
        setUname(null);
        setPassword(null);
    }
    
    public void login() throws SQLException{
         

    Statement statement = myCon.createStatement();
    
    String SQL = "SELECT uname, password FROM user WHERE uname = '" + getUname()
            + "' AND password = '" + jk.encryptPassword(getPassword()) + "';";

    ResultSet resultSet = statement.executeQuery(SQL);
    while (resultSet.next()) {
        if (getUname().equals(resultSet.getString("uname")) && jk.encryptPassword(getPassword()).equals(resultSet.getString("password"))) {
         setIsCorrect(true);
         
        } else{
            setIsCorrect(false);
        }
    }

    }
    
    public void saveUser() throws SQLException{
          Statement s = null;
         //creates an instance of the DBConnect class
         
         if(myCon!=null){
         System.out.println(myCon);
         s = myCon.createStatement();
         
                    String sql = "INSERT INTO user "
                            + "(uname,password) "
                            + "VALUES ('" + getUname() + "','"
                            + jk.encryptPassword(getCPassword())+ "') ";
                    s.execute(sql);
                    clear();
     }

    }
    
}
