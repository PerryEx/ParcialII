function guardar(){
    $.ajax({
        url:"SERVLET2",//servlet destino 
        dataType: "html", //tipo de respuesta
        data: "control=INSERT&"+$("#form1").serialize(),//datos se envían al server
        method:"POST",
        success: function(respuesta){
            if(respuesta=1){ 
                mostrarMensajeExitoso();
                ocultarMensajeExitoso();
            limpiarFormulario();    
            }else{
                mostrarMensajeError();
                ocultarMensajeError();
            }
        },
        error: function(objAjax, estado, excepcion){
            alert("error en la comunicación");
        }
    });
 }
 
function guardarVersion2(){
    $.ajax({
        url:"SERVLET2",//servlet destino 
        dataType: "html", //tipo de respuesta que se recibe del servidor
        data: "control=INSERT&"+"codigo="+$("#codigo").val()+"&nombre="+$("#nombre").val()+"&apellido="+$("#apellido").val()
        +"&direccion="+$("#direccion").val()+"&fechanacimiento="+$("#fechanacimiento").val()+"&correoelectronico="+$("#correoelectronico").val()
        +"&telefono="+$("#telefono").val()+"&opciones="+$("#opciones").val()+"&opcionesseccion="+$("#opcionesseccion").val(),//datos se envían al server
        method:"POST",//GET
        success: function(respuesta){
            if(respuesta=1){ 
                mostrarMensajeExitoso();
                ocultarMensajeExitoso();
                limpiarFormulario();    
                mostrar();
            }else{
                mostrarMensajeError();
                ocultarMensajeError();
            }
        },
        error: function(objAjax, estado, excepcion){
            alert("error en la comunicación");
        }
    });
 }
 
 function mostrar(){
    $.ajax({
        url:"SERVLET2",//pagina destino 
        dataType: "html", //tipo de respuesta
        data: "control=MOSTRAR",//datos enviados al servidor, usuario es la variable
        method:"POST",
        success: function(respuesta){
               $("#tablaAlumnos").html(respuesta);        
        },
        error: function(objAjax, estado, excepcion){
            alert("error en la comunicación");
        }
    });
}
function mostrarGrado(){
    $.ajax({
        url:"ServletGrado",//pagina destino 
        dataType: "html", //tipo de respuesta
        data: "control=MOSTRARGRADO",//datos enviados al servidor, usuario es la variable
        method:"POST",
        success: function(respuesta){
               $("#opciones").html(respuesta);        
        },
        error: function(objAjax, estado, excepcion){
            alert("error en la comunicación");
        }
    });
}

function mostrarseccion(){
    $.ajax({
        url:"ServletSeccion",//pagina destino 
        dataType: "html", //tipo de respuesta
        data: "control=MOSTRARSECCION",//datos enviados al servidor, usuario es la variable
        method:"POST",
        success: function(respuesta){
               $("#opcionesseccion").html(respuesta);        
        },
        error: function(objAjax, estado, excepcion){
            alert("error en la comunicación");
        }
    });
}


function buscar(){
    $.ajax({
        url:"SERVLET2",//pagina destino 
        dataType: "html", //tipo de respuesta
        data: "control=BUSCAR&"+"codigo="+$("#codigo").val(),//datos enviados al servidor, usuario es la variable
        method:"POST",
        success: function(respuesta){
               $("#tablaAlumnos").html(respuesta);        
        },
        error: function(objAjax, estado, excepcion){
            alert("error en la comunicación");
        }
    });
}

function cargar(){
    $.ajax({
        url:"SERVLET2",//pagina destino 
        dataType: "html", //tipo de respuesta
        data: "control=CARGAR_PARA_MODIFICAR&"+"codigo="+$("#codigo").val(),//datos enviados al servidor, usuario es la variable
        method:"POST",
        success: function(respuesta){
               $("#aside2").html(respuesta);        
        },
        error: function(objAjax, estado, excepcion){
            alert("error en la comunicación");
        }
    });
}

function eliminar(){
    $.ajax({
        url:"SERVLET2",//pagina destino 
        dataType: "html", //tipo de respuesta
        data: "control=ELIMINAR&"+"codigo="+$("#codigo").val(),//datos enviados al servidor, usuario es la variable
        method:"POST",
        success: function(respuesta){
            if(respuesta=1){ 
                mostrarMensajeExitoso();
                ocultarMensajeExitoso();   
            }else{
                mostrarMensajeError();
                ocultarMensajeError();
            }      
        },
        error: function(objAjax, estado, excepcion){
            alert("error en la comunicación");
        }
    });
}

function modificar(){
    $.ajax({
        url:"SERVLET2",//servlet destino 
        dataType: "html", //tipo de respuesta
        data: "control=ACTUALIZAR&"+"codigo="+$("#codigo").val()+"&nombre="+$("#nombre").val()+"&apellido="+$("#apellido").val(),//datos se envían al server
        method:"POST",
        success: function(respuesta){
            if(respuesta=1){ 
                mostrarMensajeExitoso();
                ocultarMensajeExitoso();
            limpiarFormulario();    
            }else{
                mostrarMensajeError();
                ocultarMensajeError();
            }
        },
        error: function(objAjax, estado, excepcion){
            alert("error en la comunicación");
        }
    });
 }
 
 function mostrarMensajeExitoso(){
     $("#exito").fadeIn(300);
 }
 
 function ocultarMensajeExitoso(){
     setTimeout(function() {
        $("#exito").fadeOut(500);
       },1500);
 }
 
 function mostrarMensajeError(){
     $("#MensajeError").fadeIn(300);
 }
 
 function ocultarMensajeError(){
     setTimeout(function() {
        $("#MensajeError").fadeOut(500);
       },1500);
 }

function limpiarFormulario(){
        $("#codigo").val("");
        $("#nombre").val("");
        $("#apellido").val("");
        $("#direccion").val("");
         $("#opciones").val("");
}

