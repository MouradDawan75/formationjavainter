package designspatterns.structure.facade;

import java.sql.Connection;

import static designspatterns.structure.facade.FacadeHelper.ReportType.PDF;

/**
 * Classe qui décrit le rôle du pattern Facade
 * Propose en sortie des méthodes qui répondent aux besoins métiers
 */
public class FacadeHelper {

    public static enum DbType{
        MYSQL,
        ORACLE
    }

    public static enum ReportType{
        HTML,
        PDF
    }


    public static void generateReport(DbType dbType, ReportType reportType, String tableName){

        Connection cnx = null;
        switch (dbType){
            case MYSQL:
                cnx = MySqlHelper.getMySqlConnection();
                MySqlHelper mySqlHelper = new MySqlHelper();
                switch (reportType) {
                    case PDF:
                        mySqlHelper.generateMySqlPdfReport(tableName, cnx);
                        break;
                    case HTML:
                        mySqlHelper.generateMySqlHtmlReport(tableName, cnx);
                        break;
                }
                break;

            case ORACLE:
                cnx = OracleHelper.getOracleConnection();
                OracleHelper oracleHelper = new OracleHelper();
                switch (reportType) {
                    case PDF:
                        oracleHelper.generateOraclePdfReport(tableName, cnx);
                        break;

                    case HTML:
                            oracleHelper.generateOracleHtmlReport(tableName, cnx);
                        break;
                }

                break;
        }
    }
}
