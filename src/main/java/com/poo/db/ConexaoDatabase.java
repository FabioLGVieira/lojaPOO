package com.poo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 15/05/2020 22:01
 * @author Fabio
 */
public class ConexaoDatabase {

    static {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConexao() throws SQLException {
        String dbURL = "jdbc:derby://localhost:1527/PERFUMARIA;create=true";
        String user = "PERFUMARIA";
        String password = "PERFUMARIA";
        return DriverManager.getConnection(dbURL, user, password);
    }    
}
