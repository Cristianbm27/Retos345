var itemActualizar

function registro(){

    var elemento={
        name: $("#name").val(),
        email: $("#email").val(),
        age: $("#age").val(),
        password: $('#password').val()
    }
    var dataToSend=JSON.stringify(elemento);
    console.log(elemento);
    $.ajax({
        dataType: 'json',
        data: dataToSend,
        url:"http://localhost:8080/api/Client/save",
        type: 'POST',
        contentType: "application/JSON",

        success:function(response){
            console.log(response)
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
        url:"http://localhost:8080/api/Client/all",
        type: 'GET',

        success:function(response){

            var misitems=response;
            
            limpiartabla();

            for (i=0; i<misitems.length;i++){
                console.log(misitems[i].idClient);
                $("#items").append("<tr>");

                $("#items").append("<td>"+misitems[i].name+"</td>");

                $("#items").append("<td>"+misitems[i].email+"</td>");

                $("#items").append("<td>"+misitems[i].age+"</td>");

                $("#items").append("<td>"+misitems[i].password+"</td>");

                $("#items").append('<td><button onclick="eliminar('+misitems[i].idClient+')">Eliminar</button></td>');

                $("#items").append('<td><button onclick="obtenerItemEspecifico('+misitems[i].idClient+')">Detalle</button></td>');
                
                $("#items").append("<tr>");
            }
            
        },

        error:function(jqXHR, textStatus, errorThrown){

        }

    });
}

function eliminar(idElemento){
    
    var elemento={
        idClient: idElemento
    }

    var dataToSend=JSON.stringify(elemento);
    
    $.ajax({
        dataType: 'json',
        data: dataToSend,
        url:"http://localhost:8080/api/Client/"+idElemento,
        type: 'DELETE',
        contentType:'application/JSON',

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
        url:"http://localhost:8080/api/Client/"+idItem,
        type: 'GET',

        success:function(response){

            console.log(response.idClient);
            var item=response;
            
            $("#name").val(item.name),
            $("#email").val(item.email),
            $("#age").val(item.age),
            $('#password').val(item.password);
            
            itemActualizar=item.idClient
        },

        error:function(jqXHR, textStatus, errorThrown){

        }

    });
}

function actualizarItem() {
    console.log(itemActualizar);
    var elemento={
        idClient: itemActualizar,
        name: $("#name").val(),
        email: $("#email").val(),
        age: $("#age").val(),
        password: $('#password').val()
    }

    var dataToSend=JSON.stringify(elemento);

    $.ajax({
        dataType: 'json',
        data:dataToSend,
        contentType:'application/JSON',
        url:"http://localhost:8080/api/Client/update",
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

function limpiartabla(){
    $("tbody").children().remove()
    
    $("#items").append("<tr>");

    $("#items").append("<td> Nombre </td>");
    $("#items").append("<td>Email</td>");
    $("#items").append("<td>Edad</td>");
    $("#items").append("<td>Contraseña</td>");    
    $("#items").append("<tr>");

}

function limpiarinput(){
    $("#name").val(""),
    $("#email").val(""),
    $("#age").val(""),
    $("#password").val("");

}