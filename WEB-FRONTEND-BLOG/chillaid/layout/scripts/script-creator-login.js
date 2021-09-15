function serializeForm() {
    let creator = {
        "id_Creators" : $("#txtid_Creators").val(),
        "creator_Password" : $("#txtPassword").val(),
    };
    return creator;
}

function login() {
    //Crear el objeto y seralizo el form compuesto por idCreator y password
    var creator = serializeForm();
    console.log(creator);
    var requestBody = JSON.stringify(creator);//preparola peticion paraformary que reciba el back
    console.log(requestBody);
    //Utilizar jQuery AJAX para enviar al Backendexit
    $.ajax({
        type: "POST", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/creator/login", //Dirección para realizar la petición HTTP
        data: requestBody, //El contenido Body de la petición HTTP                
        contentType: "application/json",
        crossDomain: true,
        dataType: "json",
        //complete setermina de realizar la peticion al back, independiemente delresultado se EJECUTA la funcion
        //SOLO COD DE STATUS donde se verifica mediante if
        complete: function (response) {
            //CODIGOS HTTP DE ERROR PRINCIPALES
            if (response.status == 200)//redireccina a la pagina
                window.location.replace("creator-create.html");
            if (response.status == 401)//no autorizada
                alert("INCORRECT PASSWORD");
            if (response.status == 404)//no encontrado
                alert("NOT FOUND");
            if(response.status ==500)//internal server error
            alert("Problemas del servidor, intente mas tarde");

        }

    });
}