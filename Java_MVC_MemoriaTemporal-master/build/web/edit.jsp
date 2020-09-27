<!DOCTYPE html>
<html>
    <head>
        <title>ejemplo Edit</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="estilos.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/metodosjs.js"></script>
        <script type="text/javascript">
         $(function(){             
             $("#eliminar").on("click", function(){ 
                 eliminar();
             })
             
              $("#modificar").on("click", function(){ 
                 modificar();
             })

             $("#buscar").on("click", function(){
                     buscar();
                     cargar();
                })
              
           /*  $("#btnEnviar").on( "click", function(evento){
                 evento.preventDefault();
                 validarInformacion();
             } )*/
           
         })   
            
        </script>
    </head>
    <body>
        <div class="divEncabezado">
            
            <a href="index.html" id="editPage">
                 <div class="btnHome" id="home">  
                 </div>
            </a>
            
            
            <a href="edit.jsp" id="editPage">
                <div class="btnEdit" id="edit">
                </div>
            </a>
            
        </div>
        
        <div class="logDivTitulo">
            <h2 class="h2">
                Modificar alumnos Programación II
            </h2>
        </div>
        <div class="divtotal">
            <form name="formulario1" id="form1" action="SERVLET2" method="POST">
                <div class="seccionIzquierda">
                    <div class="elementoForm">
                         <input type="text" name="codigo" placeholder="Codigo Alumno" id="codigo" style="width: 60%; float: left;"> 
                           <input type="button" name="buscar" value="Buscar" id="buscar" style="width: 30%; float: left; margin: 0px; padding: 0px; margin-left: 3px;">
                    </div>
                    
                    <aside class="asideLeft">
                        <table style="width: 100%; min-height:  40%; border-bottom: 1px solid blue;">
                            <thead>
                                <tr>
                                    <th>Codigo</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                 </tr>
                            </thead>
                            <tbody id="tablaAlumnos" class="tablaAlumnos" >
                            </tbody>
                        </table>
                    </aside>
                    
                     <aside class="asideLeft" id="aside2">
                        
                    </aside>
                        
                     <div class="botonIzquierda">
                           <input type="button" name="Eliminar" value="Eliminar" id="eliminar"><br>
                     </div>
                     <div class="botonDerecha">
                           <input type="button" name="modificar" value="Modificar" id="modificar"><br>
                     </div>
                 </div>
                <div class="seccionDerecha" id="tablaDerecha">

                </div>
            </form>
            
            
            <div style="width: 100%; min-height: 50px; float: left;">
                <div class="divrespuesta" style="height: 100px;" id="respuesta">
                    <div class="exito" id="exito">
                        Guardado Exitosamente
                    </div>
                    <div class="error" id="MensajeError">
                    Error al insertar
                    </div>
                </div>                
            </div>
        </div>   
       
        
        
    </body>
</html>
