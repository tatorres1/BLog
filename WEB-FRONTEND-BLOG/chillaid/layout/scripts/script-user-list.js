function show(list){ 
    $("#tblUsers").empty(); //Eliminar el contenido del tbody de la tabla
    list.forEach(user => {  
        alert("31");      
        $("#tblUsers").append('<tr>'            
            + '<td>' + user.name +'</td>'
            + '<td>' + user.date_Birth +'</td>'
            + '<td>' + user.nacionality +'</td>'
            + '<td>' + user.mail +'</td>' 
            + '<td>' + user.Id_Users +'</td>'
            + '<td>' + user.User_Password +'</td>'          
            //Boton de consultar
            + '<td>'
         //   + '<button onclick="retrieve('+ creator.idCreator +')" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#mdVariedad">Consultar</button>'
            + '</td>'                        
        +'</tr>');
    });
}

function list(){
    //Utilizar jQuery AJAX para enviar al Backend
    $.ajax({        
        type: "GET", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/user/list", //Dirección para realizar la petición HTTP        
        contentType : "application/json",
        dataType : "json",
        success : function(response){
            alert("54");
            console.log(response);
            //response trae la lista de variedades como un Arreglo JSON
            show(response);
		},
		error : function(err){
            console.error(err);
		},
        complete: function(xhr, textStatus) {            
            if(xhr.status == 404){
    
                alert(xhr.responseText);
            }
            if(xhr.status == 500){
                
                alert(xhr.responseText);
            }
        }       
    });
}


$( document ).ready(function() { 
    alert("Listo");  
    list();
});