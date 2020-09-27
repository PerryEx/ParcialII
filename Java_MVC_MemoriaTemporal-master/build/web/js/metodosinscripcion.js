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

function mostrardos(){
    $.ajax({
        url:"SERVLET2",//pagina destino 
        dataType: "html", //tipo de respuesta
        data: "control=MOSTRARDATOS",//datos enviados al servidor, usuario es la variable
        method:"POST",
        success: function(respuesta){
               $("#opciones").html(respuesta);        
        },
        error: function(objAjax, estado, excepcion){
            alert("error en la comunicación");
        }
    });
}


