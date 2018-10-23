package dairy.farm.record.keeping.system;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class User  {
    
int userid;
    String uname;
    String password;
    String CPassword;
    String isCorrect;

    DBConnect db = new DBConnect();//db instance
    Connection myCon = db.myConnect(); //db connection instance
    HasherSha1 jk = new HasherSha1(); //hashing class instance
    
    public User(){
        
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public String isIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }

   
    
    public void clear(){
        setCPassword(null);
        setUname(null);
        setPassword(null);
    }
    
    public void login() throws SQLException{
         PreparedStatement statement=null;

          
    
    String SQL = "SELECT uname, password FROM user WHERE uname = '" + getUname()
            + "' AND password = '" + jk.encryptPassword(getPassword()) + "';";
statement = (PreparedStatement) myCon.prepareStatement(SQL);
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
        if (getUname().equals(resultSet.getString("uname")) && jk.encryptPassword(getPassword()).equals(resultSet.getString("password"))) {
            setIsCorrect("true");
        } else{
          setIsCorrect("false");
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
