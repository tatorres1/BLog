
function show(list){ 
    console.log("show");
    $("#tblPublications").empty(); //Eliminar el contenido del tbody de la tabla
    list.forEach(publication => {       
        $("#tblPublications").append('<tr>'   
            + '<td>' + publication.id_Publication +'</td>'   
            + '<td>' + publication._Title +'</td>'  
            + '<td>' + publication.date_Publication +'</td>'  
            + '<td>' + publication.type_Publication +'</td>'
            + '<td>' + publication._Development +'</td>'
            //Boton de consultar
            + '<td>'
         //   + '<button onclick="retrieve('+ creator.idCreator +')" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#mdVariedad">Consultar</button>'
            + '</td>'                        
        +'</tr>');
    });
}

function list(){
    console.log("enisto");
    //Utilizar jQuery AJAX para enviar al Backend
    $.ajax({        
        type: "GET", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/publication/list", //Dirección para realizar la petición HTTP        
        contentType : "application/json",
        dataType : "json",
        success : function(response){
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
    list();
});