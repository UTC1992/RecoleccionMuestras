/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnosolutions.services;
import java.sql.*;
/**
 *
 * @author omar
 */
public class ConexionDB {

    public static Connection con = null;
    
    public ConexionDB() {
    }
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if(con == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_muestra", "root", "");
            } catch (Exception e) {
                throw new SQLException(e);
            }
        }
        return con;
    }
    
    public static void cerrar() throws SQLException{
        if(con != null){
            con.close();
        }
    }
}
