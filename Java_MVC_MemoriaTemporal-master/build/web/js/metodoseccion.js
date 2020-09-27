function guardarVersion2(){
    $.ajax({
        url:"ServletSeccion",//servlet destino 
        dataType: "html", //tipo de respuesta que se recibe del servidor
        data: "control=INSERT&"+"codigoseccion="+$("#codigoseccion").val()+"&cantseccion="+$("#cantseccion").val(),
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
        url:"ServletSeccion",//pagina destino 
        dataType: "html", //tipo de respuesta
        data: "control=MOSTRAR",//datos enviados al servidor, usuario es la variable
        method:"POST",
        success: function(respuesta){
               $("#tablaSeccion").html(respuesta);        
        },
        error: function(objAjax, estado, excepcion){
            alert("error en la comunicación");
        }
    });
}

function buscar(){
    $.ajax({
        url:"ServletSeccion",//pagina destino 
        dataType: "html", //tipo de respuesta
        data: "control=BUSCAR&"+"codigoseccion="+$("#codigoseccion").val(),//datos enviados al servidor, usuario es la variable
        method:"POST",
        success: function(respuesta){
               $("#tablaGrado").html(respuesta);        
        },
        error: function(objAjax, estado, excepcion){
            alert("error en la comunicación");
        }
    });
}

function cargar(){
    $.ajax({
        url:"ServletSeccion",//pagina destino 
        dataType: "html", //tipo de respuesta
        data: "control=CARGAR_PARA_MODIFICAR&"+"codigo="+$("#codigoseccion").val(),//datos enviados al servidor, usuario es la variable
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
        url:"ServletSeccion",//pagina destino 
        dataType: "html", //tipo de respuesta
        data: "control=ELIMINAR&"+"codigoseccion="+$("#codigoseccion").val(),//datos enviados al servidor, usuario es la variable
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
        url:"ServletSeccion",//servlet destino 
        dataType: "html", //tipo de respuesta
        data: "control=ACTUALIZAR&"+"codigoseccion="+$("#codigoseccion").val()+"&cantseccion="+$("#cantseccion").val(),//datos se envían al server
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
        $("#codigoseccion").val("");
        $("#cantseccion").val("");
    }

        






