function serializeForm() {
    let user = {
        "id_Users": $("#txtId_Users").val(),
        "user_Password": $("#txtUser_Password").val(),
    };
    return user;
}

function login() {
    //Crear el objeto y seralizo el form compuesto por iduser y password
    var user = serializeForm();
    console.log(user);
    var requestBody = JSON.stringify(user);//preparola peticion paraformary que reciba el back
    console.log(requestBody);
    //Utilizar jQuery AJAX para enviar al Backendexit
    $.ajax({
        type: "POST", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/user/login", //Dirección para realizar la petición HTTP
        data: requestBody, //El contenido Body de la petición HTTP                
        contentType: "application/json",
        crossDomain: true,
        dataType: "json",
        //complete setermina de realizar la peticion al back, independiemente delresultado se EJECUTA la funcion
        //SOLO COD DE STATUS donde se verifica mediante if
        complete: function (response) {
            //CODIGOS HTTP DE ERROR PRINCIPALES
            if (response.status == 200)//redireccina a la pagina
                window.location.replace("user-read.html");
            if (response.status == 401)//no autorizada
                alert("401 NOT AUTHORIZED");
            if (response.status == 404)//no encontrado
                alert("404 NOT FOUND");
            if(response.status ==500)//internal server error
            alert("Problemas del servidor, intente mas tarde");

        }

    });
}