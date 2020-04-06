    package InsertANDdelete;
import java.sql.*;

public class JdbcInsertTest {
    public static void main(String[] args) {
        try(
           Connection conn = DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/ebookshop?allowPublickeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                   "root","");
    Statement stmt = conn.createStatement();
                ){
            String sqlDelete = "delete from books where id >= 3000 and id < 4000";
            System.out.println("The SQL statements is " + sqlDelete + "/n");
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + "record delete.\n");

            //insert a record
            String sqlInsert = "insert into books value(3001, 'Gone Fishing', 'Kumar',11.11,11)";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + "record inserted.\n");

            //Insert multiple records
        sqlInsert = "insert into books values"
                + "(3002,'Gone Fishing 2', 'Kumar', 22.22, 22),"
                + "(3003, 'Gone Fishing 3', 'Kumar', 33.33, 33),";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

            //Insert a partial records
            sqlInsert = "insert into books (id,title,author) values (3004, 'Fishing 101', 'Kumar')";
            System.out.println("The SQL statements is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + "record Inserted.\n");

            //Delete books where id > 8000;
            sqlDelete = "delete books where id > 8000";
            System.out.println("The SQl statements is: " + sqlDelete + "\n");
            int countDelete = stmt.executeUpdate(sqlDelete);
            System.out.println(countDelete + "record delete.\n");

            sqlInsert = "insert into books values"
                    +"(8001,'Java Core','Dang Kim Thi',15.55,55),"
                    +"(8002,'Java Advanced','James Gosling',25.55,55),";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

            sqlInsert = "innset into books(id,title,author) values(2001,'Java JDBC MySQL','Thi Dk')";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + "record Insert.\n");

            //Issue a Sellect to check the changes
            String strSelect = "select * from books";
            System.out.println("The SQl statement is: " + strSelect + "\n" );
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                System.out.println(rset.getInt("id") + ","
                + rset.getString("author") + ","
                        + rset.getString("title") + ","
                        + rset.getDouble("price") + ","
                        + rset.getInt("qty"));
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
