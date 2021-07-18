import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPreparedStatement {
   static final String DB_URL = "jdbc:mysql://localhost:3306/student";
   static final String USER = "Rohan";
   static final String PASS = "codeblind";
   static final String QUERY = "SELECT USN, SNAME, PHONE, GENDER,Marks FROM STUDENT";
   static final String INSERT_SQL = "INSERT INTO STUDENT" + " (USN, SNAME, PHONE, GENDER,Marks) VALUES " + " (?, ?, ?, ?,?)";

   public static void main(String[] args) {
      // Open a connection
      try{
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         PreparedStatement stmt = conn.prepareStatement(INSERT_SQL);
      		      
         // Bind values into the parameters.
         stmt.setString(1, "2JI18CS035"); 
         stmt.setString(2, "ROHAN");
         stmt.setInt(3, 545854585);
         stmt.setString(4, "M");
         stmt.setInt(5,100);

        // Let us update age of the record with ID = 102;
         int rows = stmt.executeUpdate();
         System.out.println("Rows impacted : " + rows );

         // Let us select all the records and display them.
         ResultSet rs = stmt.executeQuery(QUERY);		      

         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.println("");
            System.out.println("USN: " + rs.getString("USN"));
            System.out.println("Student Name: " + rs.getString("SNAME"));
            // System.out.println(", Student Phone No.: " + rs.getInt("PHONE"));
            System.out.println("Gender: " + rs.getString("GENDER"));
            System.out.println("Marks: " + rs.getString("Marks"));
            System.out.println("");
         }
         rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}