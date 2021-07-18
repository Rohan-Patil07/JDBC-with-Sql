import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
   static final String DB_URL = "jdbc:mysql://localhost:3306/student";
   static final String USER = "Rohan";
   static final String PASS = "codeblind";

   public static void main(String[] args) {
    // Open a connection
    try{
    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
    PreparedStatement stmt = conn.prepareStatement("select * from STUDENT where marks>?");

    //init values
    stmt.setInt(1,60);

    ResultSet rs = stmt.executeQuery();

    // Extract data from result set
    while (rs.next()) {
        // Retrieve by column name
        System.out.println("");
        System.out.println("USN: " + rs.getString("USN"));
        System.out.println("Student Name: " + rs.getString("SNAME"));
        System.out.println("Gender: " + rs.getString("GENDER"));
        System.out.println("Marks: " + rs.getString("MARKS"));
        System.out.println("");
     }
     rs.close();
    }
     catch (SQLException e) {
       e.printStackTrace();
    } 
 }
}