/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Aroniaina Saotra
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class Connexion {
    private final static String URL = "jdbc:postgresql://localhost:5432/contenu" ;
    private final static String USER = "postgres" ;
    private final static String PASSWORD = "sarobidy" ;
    public static Connection getConnection()throws Exception
    {
        Connection connect = null ;
        try {
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            return connect ;
        }
        catch (SQLException limit){
            System.out.println(limit.getMessage());
        }
        return null;
    }
    }
