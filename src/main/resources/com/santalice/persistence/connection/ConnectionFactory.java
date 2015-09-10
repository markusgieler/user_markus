/**
 * 
 * @author Markus Ribeiro Gieler
 * @date 16 Apr 2015
 * @version 0.1beta
 * This class is a connection factory for 3 databases,
 * Oracle, MySql, PostgreSql,
 * however it can be updated for supplying connectivity for more databases
 * like firebird, IBMdb, SQL Server etc
 */
package com.santalice.persistence.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author markus
 */
public class ConnectionFactory {

    public static Connection getOracleConnection() {
        String ORACLE_DRIVER   = "oracle.jdbc.driver.OracleDriver";
        String ORACLE_HOST     = "oracleserver"; // virtual machine debian com db oracle 12c
        String ORACLE_PORT     = "1521"; 
        String ORACLE_INSTANCE = "db"; // virtual machine debian com db oracle 12c
        String ORACLE_URL      = "jdbc:oracle:thin:@"+ORACLE_HOST+":"+ORACLE_PORT+":"+ORACLE_INSTANCE;
        String ORACLE_USERNAME = "santalice";
        String ORACLE_PASSWORD = "santalice";          
        try {
            Class.forName(ORACLE_DRIVER);
            return DriverManager.getConnection(ORACLE_URL,ORACLE_USERNAME,ORACLE_PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Error SQLException on ConnectionFactory", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Error ClassNotFoundException on ConnectionFactory", ex);
        }     
    }
    
    public static Connection getMysqlConnection() {
        String MYSQL_DRIVER   = "com.mysql.jdbc.Driver";
        String MYSQL_HOST     = "localhost"; // virtual machine debian com db oracle 12c
        String MYSQL_DATABASE = "DB_NAME";
        String MYSQL_URL      = "jdbc:mysql://"+MYSQL_HOST+"/"+MYSQL_DATABASE;
        String MYSQL_USERNAME = "root";
        String MYSQL_PASSWORD = "jble100";
        try {
            Class.forName(MYSQL_DRIVER);
            return DriverManager.getConnection(MYSQL_URL,MYSQL_USERNAME,MYSQL_PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Error SQLException on ConnectionFactory", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Error ClassNotFoundException on ConnectionFactory", ex);
        }
    }
    
    public static Connection getPostgresqlConnection() {
        String POSTGRESQL_DRIVER   = "org.postgresql.Driver";
        String POSTGRESQL_HOST     = "oracleserver"; // virtual machine debian com db oracle 12c
        String POSTGRESQL_PORT     = "5432";  
        String POSTGRESQL_DATABASE = "postgres";  
        String POSTGRESQL_URL      = "jdbc:postgresql://"+POSTGRESQL_HOST+":"+POSTGRESQL_PORT+"/"+POSTGRESQL_DATABASE;
        String POSTGRESQL_USERNAME = "postgres";
        String POSTGRESQL_PASSWORD = "jble100"; 
        try {
            Class.forName(POSTGRESQL_DRIVER);
            return DriverManager.getConnection(POSTGRESQL_URL,POSTGRESQL_USERNAME,POSTGRESQL_PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Error SQLException on ConnectionFactory", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Error ClassNotFoundException on ConnectionFactory", ex);
        }     
    }
}