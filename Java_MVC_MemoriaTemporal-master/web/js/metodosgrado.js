
function guardarVersion2(){
    $.ajax({
        url:"ServletGrado",//servlet destino 
        dataType: "html", //tipo de respuesta que se recibe del servidor
        data: "control=INSERT&"+"codigogrado="+$("#codigogrado").val()+"&descripcion="+$("#descripcion").val(),
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
        url:"ServletGrado",//pagina destino 
        dataType: "html", //tipo de respuesta
        data: "control=MOSTRAR",//datos enviados al servidor, usuario es la variable
        method:"POST",
        success: function(respuesta){
               $("#tablaGrado").html(respuesta);        
        },
        error: function(objAjax, estado, excepcion){
            alert("error en la comunicación");
        }
    });
}

function buscar(){
    $.ajax({
        url:"ServletGrado",//pagina destino 
        dataType: "html", //tipo de respuesta
        data: "control=BUSCAR&"+"codigogrado="+$("#codigogrado").val(),//datos enviados al servidor, usuario es la variable
        method:"POST",
        success: function(respuesta){
               $("#tablaSeccion").html(respuesta);        
        },
        error: function(objAjax, estado, excepcion){
            alert("error en la comunicación");
        }
    });
}

function cargar(){
    $.ajax({
        url:"ServletGrado",//pagina destino 
        dataType: "html", //tipo de respuesta
        data: "control=CARGAR_PARA_MODIFICAR&"+"codigo="+$("#codigoGrado").val(),//datos enviados al servidor, usuario es la variable
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
        url:"ServletGrado",//pagina destino 
        dataType: "html", //tipo de respuesta
        data: "control=ELIMINAR&"+"codigogrado="+$("#codigogrado").val(),//datos enviados al servidor, usuario es la variable
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
        url:"ServletGrado",//servlet destino 
        dataType: "html", //tipo de respuesta
        data: "control=ACTUALIZAR&"+"codigogrado="+$("#codigogrado").val()+"&descripcion="+$("#descripcion").val(),//datos se envían al server
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
        $("#codigogrado").val("");
        $("#descripcion").val("");
    }

        



