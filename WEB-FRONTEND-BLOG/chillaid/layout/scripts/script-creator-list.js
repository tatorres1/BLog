function retrieve(id) {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/creator/retrieve/" +id,
        contentType: "application/json",
        dataType: "json",
        success : function(response){
            console.log(response);    
            //La response contiene el objeto de tipo usuario
            let creator = response;    
            $("#lblName").html(creator.name);
            $("#spdate_Birth").html(creator.date_Birth);
            $("#spNacionality").html(creator.nacionality);
            $("#spMail").html(creator.mail);
            $("#spid_Creators").html(creator.id_Creators);
            $("#spPassword").html(creator.creator_Password);
            $("#txtid_Creator").val(creator.id_Creator); //Setter
            //let valor = $("#txtIdVariedad").val(); //Getter
		},
		error : function(err){
			console.error(err);
		}
    });
}


function show(list){ 
    $("#tblCreators").empty(); //Eliminar el contenido del tbody de la tabla
    list.forEach(creator => {        
        $("#tblCreators").append('<tr>' 
        + '<td>' + creator.id_Creator +'</td>'
            + '<td>' + creator.name +'</td>'
            + '<td>' + creator.date_Birth +'</td>'
            + '<td>' + creator.nacionality +'</td>'
            + '<td>' + creator.mail +'</td>' 
            + '<td>' + creator.id_Creators +'</td>'
            + '<td>' + creator.creator_Password +'</td>'          
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
        url: "http://localhost:8080/creator/list", //Dirección para realizar la petición HTTP        
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

function del(){
    let id = $("#tblCreators").val();
    $.ajax({        
        type: "DELETE", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/create/delete/" + id, //Dirección para realizar la petición HTTP        
        contentType : "application/json",        
        success : function(response){
            console.log(response);                            
		},
		error : function(err){
			console.error(err);
		},
        complete : function(xhr, textStatus){
            if(xhr.status == 200)
            {
                alert(xhr.responseText);
                list();         
            }            
        }
    });
}

$( document ).ready(function() {  
    list();
    $("#btnDelete").click(function(){        
        del();
    });
});