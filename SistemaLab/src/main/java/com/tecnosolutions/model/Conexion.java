/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnosolutions.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author omar
 */
public class Conexion {

    public Connection con = null;
    String db;
    String login;
    String pass;
    String url;
    String urlCompleta;

    public Conexion() {
        this.db = "db_muestra";
        this.login = "root";
        this.pass = "";
        this.url = "jdbc:mysql://localhost:3306/";
        this.urlCompleta = url + db;
    }

    public Connection getConexion() throws SQLException, ClassNotFoundException{
        if(con == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(this.urlCompleta, this.login, this.pass);
            } catch (ClassNotFoundException | SQLException e) {
                throw new SQLException(e.getMessage());
            }
        }
        return con;
    }
    
    public void cerrar() throws SQLException{
        if(con != null){
            con.close();
        }
    }
}
