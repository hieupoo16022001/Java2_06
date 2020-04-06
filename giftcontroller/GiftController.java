package giftcontroller;
import giftmodel.Gift;

import javax.management.StandardEmitterMBean;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GiftController {
ArrayList<Gift> list = new ArrayList<>();
Scanner scanner = new Scanner(System.in);

public void selectBook(){
    try(
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/giftshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "root","");
                Statement stmt =  conn.createStatement();
            ){
        String strSelect = "select * from books";
        System.out.println("the SQL statement is: " + strSelect + "\n");
        ResultSet rset = stmt.executeQuery(strSelect);

        while (rset.next()){
            System.out.println(rset.getInt("id") + ","
            + rset.getString("name") + ","
                    + rset.getDouble("price") + ","
                    + rset.getInt("qty"));
        }
    } catch (SQLException ex){
        ex.printStackTrace();
    }
}

    public void InsertGift(Gift gift){
    try(    Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/giftshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
            "root","");
             Statement stmt = conn.createStatement();
            ){
                    //insert
        String sqlInsert = "insert into books values (" + gift.getId() + "," + gift.getName() + "," + gift.getPrice() + "," + gift.getQty() + ")";
    System.out.println("The SQL statement is: " + sqlInsert + "\n");
    int countInsert = stmt.executeUpdate(sqlInsert);
    System.out.println(countInsert + "Record insert.\n");

} catch (SQLException ex){
        ex.printStackTrace();
    }
}

    public void DeleteGift(int id){
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/giftshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root","");
                Statement stmt = conn.createStatement();
                ){
            String sqlDelete = "DELETE FROM books WHERE id = " + id ;
            System.out.println("The SQL statement is:" + sqlDelete + "\n");
            int countDelete = stmt.executeUpdate(sqlDelete);
            System.out.println(countDelete + " Record Delete.\n");
        } catch (SQLException ex){
            ex.printStackTrace();
        }
}
}


