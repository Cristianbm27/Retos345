var itemActualizar

function registro(){

    var elemento={
        name: $("#name").val(),
        description: $("#description").val()
    }
    var dataToSend=JSON.stringify(elemento);
    
    $.ajax({
        dataType: 'json',
        data: dataToSend,
        url:"http://localhost:8080/api/Category/save",
        type: 'POST',
        contentType: "application/JSON",

        success:function(response){
            //console.log(response);
            obtener();
            
            alert("Ejecutado con éxito");

            limpiarinput();
        },

        error:function(jqXHR, textStatus, errorThrown){

        }

    });

}

function obtener(){

    $.ajax({
        dataType: 'json',
        url:"http://localhost:8080/api/Category/all",
        type: 'GET',

        success:function(response){

            console.log(response)

            var misitems = response;

            limpiartabla();

            for (i = 0; i < misitems.length; i++) {
                console.log(misitems[i].id);
                $("#items").append("<tr>");

                $("#items").append("<td>" + misitems[i].name + "</td>");

                $("#items").append("<td>" + misitems[i].description + "</td>");

                $("#items").append('<td><button onclick="eliminar(' + misitems[i].id + ')">Eliminar</button></td>');

                $("#items").append('<td><button onclick="obtenerItemEspecifico(' + misitems[i].id + ')">Detalle</button></td>');

                $("#items").append("<tr>");
            }

        },

        error:function(jqXHR, textStatus, errorThrown){

        }

    });
}

function eliminar(idElemento){
    
    var elemento={
        id: idElemento  
    }

    var dataToSend=JSON.stringify(elemento);
    
    $.ajax({
        dataType: 'json',
        data: dataToSend,
        url:"http://localhost:8080/api/Category/"+ idElemento,
        type: 'DELETE',
        contentType:"application/JSON",

        success:function(response){
            console.log(response);
            
            obtener();
        },

        error:function(jqXHR, textStatus, errorThrown){

        }

    });


}

function obtenerItemEspecifico(idItem) {

    $.ajax({
        dataType: 'json',
        url:"http://localhost:8080/api/Category/"+idItem,
        type: 'GET',

        success:function(response){

            console.log(response);
            var item=response;
            
            $("#name").val(item.name),
            $("#description").val(item.description);
            itemActualizar=item.id
        },

        error:function(jqXHR, textStatus, errorThrown){

        }

    });
}

function actualizarItem() {
    
    var elemento={
        id:itemActualizar,
        name: $("#name").val(),
        description: $("#description").val()
    }

    var dataToSend=JSON.stringify(elemento);

    $.ajax({
        dataType: 'json',
        data:dataToSend,
        contentType:'application/json',
        url:"http://localhost:8080/api/Category/update",
        type: 'PUT',

        success:function(response){

            console.log(response);

            obtener();

            alert("Actualizado con éxito");

            limpiarinput();
        },

        error:function(jqXHR, textStatus, errorThrown){

        }

    });
}

/**Limpia la tabla de registros */
function limpiartabla(){
    $("tbody").children().remove()
    
    $("#items").append("<tr>");

    $("#items").append("<td> Nombre </td>");
    $("#items").append("<td>Descripción</td>");  
    $("#items").append("<tr>");

}
function limpiarinput(){
    $("#name").val(""),
    $("#description").val("");
}