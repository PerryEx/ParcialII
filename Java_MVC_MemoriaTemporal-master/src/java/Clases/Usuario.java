
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
    private Conexion conn;
    private Connection cn;
    private PreparedStatement prstmt = null;
    private ResultSet result = null;
    
    public Usuario(){
        conn= new Conexion();
        cn=conn.conectar();
    }
  
    public void insert(String codigo, String estado, StringBuffer salida){
        String sql = "INSERT INTO ESTUDIANTE(CARNE, NOMBRE) ";
             sql += " VALUES( ?,?)"; 
        try{
            prstmt = cn.prepareStatement(sql); 
            prstmt.setString(1, codigo);
            prstmt.setString(2, estado);
             int resultado = prstmt.executeUpdate(); 
                if(resultado > 0){
                    salida.append("1");
                }else{
                    salida.append("0");
                }
        }catch(SQLException e){
            String error = e.getMessage();  
            if(error.indexOf("ORA-00001") != -1){
                salida.append("ORA-00001");
            }else{
                salida.append(error);
            }
        }
    
    }
    
    public void consultarRegistros(StringBuffer respuesta){   
        String sql="select * from ESTUDIANTE";
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();            
            respuesta.append("<table id=\"tabla_elementos\" border='1' class=\"tabla-1\">");
            respuesta.append("<thead>");  
            //respuesta.append("<center><h5 >").append(" Registros Existentes  ").append("</tr></center>");
            respuesta.append("<tr id=\"trprincipal\" >");
            respuesta.append("<td style=\"width:100px;\">").append("CARNE").append("</td>");//titulo de la columna
            respuesta.append("<td style=\"width:340px;\">").append("NOMBRE").append("</td>");//titulo de la column
            respuesta.append("</tr>");
            respuesta.append("</thead>");
            if (result!=null){
                while (result.next()){
                respuesta.append("<tr>");
                 respuesta.append("<td >").append(result.getString("CARNE")).append("</td>");
                respuesta.append("<td >").append(result.getString("NOMBRE")).append("</td>");
               // respuesta.append("<td id=\"").append(index).append("_1\"  ondblclick=\"edit(this.id);\">").append(result.getString("DESCRIPCION")).append("</td>");
                respuesta.append("</tr>");
                }
            }else{
                respuesta.append("error al consultar");
            }
            respuesta.append("</table>");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
