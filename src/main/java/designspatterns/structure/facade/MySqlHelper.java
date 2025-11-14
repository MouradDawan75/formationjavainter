package designspatterns.structure.facade;

import java.sql.Connection;

public class MySqlHelper {

    public static Connection getMySqlConnection(){
        return null;
    }

    public void generateMySqlHtmlReport(String tableName, Connection cnx){
        //logic
        System.out.println("MySql HTML report generated...........");
    }

    public void generateMySqlPdfReport(String tableName, Connection cnx){
        //logic
        System.out.println("MySql PDF report generated...........");
    }
}
