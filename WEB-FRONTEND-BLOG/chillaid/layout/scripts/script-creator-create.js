function set(publication){
    console.log("setea");
    $("#txtId_Publication").val(publication.id_Publication);
    $("#txt_Title").val(publication._Title);
    $("#txtDate_Publication").val(publication.date_Publication);
    $("#txtTypeP").val(publication.type_Publication);
    $("#txtDevelopment").val(publication._Development);
}

function retrieve(){       
    let txtFind = $("#txtFind").val();
    if(txtFind === "") return;

    let id = parseInt(txtFind); //Transforma el txtBuscar en un número entero
    console.log(id);
    if(isNaN(id)){
        $.ajax({        
            type: "GET", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/publication/retrieve?name=" + txtFind, //Dirección para realizar la petición HTTP        
            contentType : "application/json",
            dataType : "json",
            success : function(response){
                console.log(response);    
                //El response contiene el objeto Variedad consultado
                set(response);                            
		    },
		    error : function(err){
			    console.error(err);
		    },
            complete : function(xhr, textStatus){
                if(xhr.status == 404)
                {
                    alert(xhr.responseText);                    
                }
            }
        });
    }
    else{
        $.ajax({        
            type: "GET", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/publication/retrieve/" + id, //Dirección para realizar la petición HTTP        
            contentType : "application/json",
            dataType : "json",
            success : function(response){
                console.log(response);    
                //El response contiene el objeto Variedad consultado
                set(response);                            
		    },
		    error : function(err){
			    console.error(err);
		    },
            complete : function(xhr, textStatus){
                if(xhr.status == 404)
                {
                    alert(xhr.responseText);                    
                }
            }
        });
    }
}

function serializeForm(){
    console.log("serializo");
    let publication =  {
        "id_Publication":$("#txtId_Publication").val(),
        "_Title":$("#txt_Title").val(),
        "date_Publication":$("#txtDate_Publication").val(),
        "type_Publication":$("#txtTypeP").val(),
        "_Development":$("#txtDevelopment").val(),
        
    };
    return publication;
}

function save(){
    console.log("guarda");
    //Crear el objeto
    var publication = serializeForm();
    console.log(publication);
    var requestBody = JSON.stringify(publication);
    console.log(requestBody);
    //Utilizar jQuery AJAX para enviar al Backendexit
    if(publication.id_Publication == 0){
        $.ajax({        
            type: "POST", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/publication/create", //Dirección para realizar la petición HTTP
            data: requestBody, //El contenido Body de la petición HTTP                
            contentType : "application/json",
            crossDomain: true,
            dataType: "json",
            success : function(response){
                console.log(response);                
		    },
		    error : function(err){
			    console.error(err);
		    }            
        });
    }
    else{
        //Update
        let id = publication.id_Publication;
        $.ajax({        
            type: "PUT", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/publication/update/" + id, //Dirección para realizar la petición HTTP
            data: requestBody, //El contenido Body de la petición HTTP                
            contentType : "application/json",
            crossDomain: true,
            dataType: "json",
            success : function(response){
                console.log(response);             
		    },
		    error : function(err){
			    console.error(err);
		    }            
        });
    }
}

$(function() {       
console.log("formulario");
    $('#frmPublication').on('submit', function() {
        var form = document.getElementById('frmPublication');
        var a = form.checkValidity();
        console.log(a);
        if(a){
            save();
        }
    });


    $("#btnFind").click(function(){        
        retrieve();
    });    
});
