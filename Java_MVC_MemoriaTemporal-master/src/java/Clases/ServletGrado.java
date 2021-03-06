/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

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
@WebServlet(name = "ServletGrado", urlPatterns = {"/ServletGrado"})
public class ServletGrado extends HttpServlet {
    Grado_Vectores grado_vector = new Grado_Vectores();
    String[][] matriz_grado;
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
             String codigogrado = request.getParameter("codigogrado");
            String descripcion = request.getParameter("descripcion");
            
            Writer ajaxSalida =  response.getWriter(); 
            StringBuffer respuesta =  new StringBuffer();  
            
            if(control.equals("INSERT")){
                if(grado_vector.insertarUsuario(codigogrado, descripcion)==true){
                  respuesta.append("1");//Respuesta o variable de control, dato insertado
                }else{
                    respuesta.append("0");//dato no insertado
                }
            }else if(control.equals("MOSTRAR")){
                for(int i=0; i<grado_vector.obtenerUsuarios().length; i++){     
                   matriz_grado = grado_vector.obtenerUsuarios();
                   String fila ="";
                  if(!(matriz_grado[i][0]==null)){//se valida si es diferente que null
                        fila= "<tr>"
                                + "<td>" + matriz_grado[i][0] + "</td>"
                                + "<td>" + matriz_grado[i][1] + "</td>"     
                                + "</tr>";
                        respuesta.append(fila);//devuelvo la fila generada
                    }
                 }  
            }else if(control.equals("MOSTRARGRADO")){
                for(int i=0; i<grado_vector.obtenerUsuarios().length; i++){     
                   matriz_grado = grado_vector.obtenerUsuarios();
                   String fila ="";
                  if(!(matriz_grado[i][0]==null)){//se valida si es diferente que null
                        fila=  "<option>" + matriz_grado[i][0] + "</option>"
                                ;
                              
                              
                        respuesta.append(fila);//devuelvo la fila generada
                    }
                 }  
            }
            else if(control.equals("BUSCAR")){
               respuesta.append(grado_vector.buscarUsuarioPorCodigo(codigogrado));
            }
            else if(control.equals("ELIMINAR")){
              if(grado_vector.eliminarUsuarioPorCodigo(codigogrado)==true){
                  respuesta.append("1");
              }else{respuesta.append("0");}
            }else if(control.equals("CARGAR_PARA_MODIFICAR")){
               respuesta.append(grado_vector.cargarUsuarioPorCodigo(codigogrado));
            }
            if(control.equals("ACTUALIZAR")){
                if(grado_vector.actualizarUsuarioPorCodigo(codigogrado, descripcion)==true){
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
