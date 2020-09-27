/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Clases.Grado_Vectores;
import Clases.Seccion_Vectores;
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
 * @author brian
 */
@WebServlet(urlPatterns = {"/ServletSeccion"})
public class ServletSeccion extends HttpServlet {
Seccion_Vectores seccion_vector = new Seccion_Vectores();
    String[][] matriz_seccion;
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
           
              String control=request.getParameter("control");
             String codigoseccion = request.getParameter("codigoseccion");
            String cantseccion = request.getParameter("cantseccion");
            
            Writer ajaxSalida =  response.getWriter(); 
            StringBuffer respuesta =  new StringBuffer();  
            
            if(control.equals("INSERT")){
                if(seccion_vector.insertarUsuario(codigoseccion, cantseccion)==true){
                  respuesta.append("1");//Respuesta o variable de control, dato insertado
                }else{
                    respuesta.append("0");//dato no insertado
                }
            }else if(control.equals("MOSTRAR")){
                for(int i=0; i<seccion_vector.obtenerUsuarios().length; i++){     
                   matriz_seccion = seccion_vector.obtenerUsuarios();
                   String fila ="";
                  if(!(matriz_seccion[i][0]==null)){//se valida si es diferente que null
                        fila= "<tr>"
                                + "<td>" + matriz_seccion[i][0] + "</td>"
                                + "<td>" + matriz_seccion[i][1] + "</td>"     
                                + "</tr>";
                        respuesta.append(fila);//devuelvo la fila generada
                    }
                 }  
            }else if(control.equals("MOSTRARSECCION")){
                for(int i=0; i<seccion_vector.obtenerUsuarios().length; i++){     
                   matriz_seccion = seccion_vector.obtenerUsuarios();
                   String fila ="";
                  if(!(matriz_seccion[i][0]==null)){//se valida si es diferente que null
                        fila= "<option>" + matriz_seccion[i][0]+"</option>";
                               
                              
                        respuesta.append(fila);//devuelvo la fila generada
                    }
                 }  
            }
            else if(control.equals("BUSCAR")){
               respuesta.append(seccion_vector.buscarUsuarioPorCodigo(codigoseccion));
            }
            else if(control.equals("ELIMINAR")){
              if(seccion_vector.eliminarUsuarioPorCodigo(codigoseccion)==true){
                  respuesta.append("1");
              }else{respuesta.append("0");}
            }else if(control.equals("CARGAR_PARA_MODIFICAR")){
               respuesta.append(seccion_vector.cargarUsuarioPorCodigo(codigoseccion));
            }
            if(control.equals("ACTUALIZAR")){
                if(seccion_vector.actualizarUsuarioPorCodigo(codigoseccion, cantseccion)==true){
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
