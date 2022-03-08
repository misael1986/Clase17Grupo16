/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unbosque.clase17grupo16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class Modelo {

    Modelo() {
    }

    //----CREAR LA CONEXIÓN A LA BASE DE DATOS--------
    private Connection ConectarBD() {
        // SQLite connection string
        String url = "jdbc:sqlite:datos.db";//RUTA DINAMICA

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Error al Conectar: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public String[] leerCiudades() {

        String[] result = null;

        String sql = "select * from ciudades";
        String sql2 = "select count(id) as numero from ciudades;";
        try {
            Connection conn = this.ConectarBD();

            Statement stmt = conn.createStatement();//Preparar Consulta -> Abrir la tabla
            ResultSet rs = stmt.executeQuery(sql);//QUERY es para cuando trae datos

            Statement stmtCant = conn.createStatement();//Preparar Consulta -> Abrir la tabla
            ResultSet rsCant = stmtCant.executeQuery(sql2);//QUERY es para cuando trae datos

            int numero = rsCant.getInt("numero");

            //System.out.println("Cantidad: "+numero);
            result = new String[numero];
            int posicion = 0;
            while (rs.next()) {
                result[posicion] = rs.getString("nombre");
                //System.out.println(result[posicion]);
                posicion++;
            }
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return result;

    }

    public int guardar(String nom) {

        int exito = 0;
        String consulta = "insert into ciudades (nombre) values (?)";

        try {
            Connection conn = this.ConectarBD();
            PreparedStatement prstm = conn.prepareStatement(consulta);
            prstm.setString(1, nom);
            prstm.executeUpdate();
            exito = 1;

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return exito;

    }

}
