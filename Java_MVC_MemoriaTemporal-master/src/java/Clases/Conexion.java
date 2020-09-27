/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author CB090828
 */
public class Conexion {
    private String url="jdbc:oracle:thin:@localhost:1521:XE";//url de nuestro odbc
    private String usuario="DESARROLLOWEB";
    private String clave="jp2017"; 
    private Connection conexion=null;
    //private PreparedStatement pr=null;
    
    public Connection conectar(){   
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            conexion=DriverManager.getConnection( url, usuario,clave);
        }  catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {   
           ex.printStackTrace();
        }  
       
        return conexion;
        
    }
}
