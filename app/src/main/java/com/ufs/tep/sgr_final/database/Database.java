package com.ufs.tep.sgr_final.database;

import android.util.Log;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private Statement stmt;
    private ResultSet rs;
    private Connection conn;


    public Database() {
    }


    public String teste() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://192.168.0.100/sgr", "sgr_user", "3256");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM usuario");

            if (rs != null && rs.next())
                return rs.getString("nome");
            else
                return null;

        } catch (SQLException e) {
            return e.toString();
        } catch (IllegalAccessException e) {
            return e.getMessage() + "2";
        } catch (InstantiationException e) {
            return e.getMessage() + "3";
        } catch (ClassNotFoundException e) {
            return e.getMessage() + "4";
        } finally {
            try {
                if (rs != null) rs.close();
                rs = null;
                if (stmt != null) stmt.close();
                stmt = null;
                if (conn != null) conn.close();
                conn = null;
            } catch (SQLException e) {
            }
        }
    }
}
