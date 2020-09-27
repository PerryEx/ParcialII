/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Clases.Conexion;
import Clases.Grado_Vectores;
import Clases.Usuario;
import Clases.Usuario_Vectores;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CB090828
 */
@WebServlet(urlPatterns = {"/SERVLET2"})
public class SERVLET2 extends HttpServlet {
Usuario_Vectores usuario_vector = new Usuario_Vectores(); 

String[][] matriz_usuarios;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Obtenemos los valores de las variables del metodo POST
            
            String control=request.getParameter("control");
            String codigo=request.getParameter("codigo");
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String direccion=request.getParameter("direccion");
            String fechanacimiento=request.getParameter("fechanacimiento");
            String correo=request.getParameter("correoelectronico");
            String telefono=request.getParameter("telefono");
            String grado = request.getParameter("opciones");
            String seccion = request.getParameter("opcionesseccion");
            
        
            
            Writer ajaxSalida =  response.getWriter(); 
            StringBuffer respuesta =  new StringBuffer();            
            
            if(control.equals("INSERT")){
                if(usuario_vector.insertarUsuario(codigo, nombre, apellido, direccion, fechanacimiento,
                                                  correo, telefono, grado, seccion)==true){
                  respuesta.append("1");//Respuesta o variable de control, dato insertado
                }else{
                    respuesta.append("0");//dato no insertado
                }
            }else if(control.equals("MOSTRAR")){
                for(int i=0; i<usuario_vector.obtenerUsuarios().length; i++){     
                   matriz_usuarios = usuario_vector.obtenerUsuarios();
                   String fila ="";
                  if(!(matriz_usuarios[i][0]==null)){//se valida si es diferente que null
                        fila= "<tr>"
                                + "<td>" + matriz_usuarios[i][0] + "</td>"
                                + "<td>" + matriz_usuarios[i][1] + "</td>"
                                + "<td>" + matriz_usuarios[i][2] +"</td>"
                                + "<td>" + matriz_usuarios[i][3] + "</td>"
                                + "<td>" + matriz_usuarios[i][4] + "</td>"
                                + "<td>" + matriz_usuarios[i][5] + "</td>"
                                + "<td>" + matriz_usuarios[i][6] + "</td>"
                                 + "<td>" + matriz_usuarios[i][7] + "</td>"
                                 + "<td>" + matriz_usuarios[i][8] + "</td>"
                                + "</tr>";
                        respuesta.append(fila);//devuelvo la fila generada
                    }
                 }  
            }else if(control.equals("MOSTRARDATOS")){
                for(int i=0; i<usuario_vector.obtenerUsuarios().length; i++){     
                   matriz_usuarios = usuario_vector.obtenerUsuarios();
                   String fila ="";
                  if(!(matriz_usuarios[i][0]==null)){//se valida si es diferente que null
                        fila= 
                                  "<option>" + matriz_usuarios[i][0] + "</option>"
                                + "<option>" + matriz_usuarios[i][1] + "</option>"
                                + "<option>" + matriz_usuarios[i][2] + "</option>"
                                + "<option>" + matriz_usuarios[i][3] + "</option>"
                                + "<option>" + matriz_usuarios[i][4] + "</option>"
                                + "<option>" + matriz_usuarios[i][5] + "</option>"
                                + "<option>" + matriz_usuarios[i][6] + "</option>";
                                
                        respuesta.append(fila);//devuelvo la fila generada
                    }
                 }  
            }
            else if(control.equals("BUSCAR")){
               respuesta.append(usuario_vector.buscarUsuarioPorCodigo(codigo));
            }
            else if(control.equals("ELIMINAR")){
              if(usuario_vector.eliminarUsuarioPorCodigo(codigo)==true){
                  respuesta.append("1");
              }else{respuesta.append("0");}
            }else if(control.equals("CARGAR_PARA_MODIFICAR")){
               respuesta.append(usuario_vector.cargarUsuarioPorCodigo(codigo));
            }
            if(control.equals("ACTUALIZAR")){
                if(usuario_vector.actualizarUsuarioPorCodigo(codigo, nombre, apellido)==true){
                  respuesta.append("1");
              }else{respuesta.append("0");}
            }
  
            ajaxSalida.write(respuesta.toString());
            ajaxSalida.flush();
            ajaxSalida.close(); 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
