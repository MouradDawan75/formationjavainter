package designspatterns.structure.facade;

import java.sql.Connection;

public class OracleHelper {

    public static Connection getOracleConnection(){
        return null;
    }

    public void generateOracleHtmlReport(String tableName, Connection cnx){
        //logic
        System.out.println("Oracle HTML report generated...........");
    }

    public void generateOraclePdfReport(String tableName, Connection cnx){
        //logic
        System.out.println("Oracle PDF report generated...........");
    }
}
