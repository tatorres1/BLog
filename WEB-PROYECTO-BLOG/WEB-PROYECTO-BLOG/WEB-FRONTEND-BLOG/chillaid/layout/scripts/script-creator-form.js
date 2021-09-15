function set(creator){
  //  $("txtid_Creator").val(creator.id_Creator);
    $("#txtName").val(creator.name);
    $("#txtDate_Birth").val(creator.date_Birth);
    $("#txtNacionality").val(creator.nacionality);
    $("#txtMail").val(creator.mail);
    $("#txtid_Creators").val(creator.id_Creators);
    $("#txtPassword").val(creator.creator_Password);
}

function retrieve(){       
    let txtFind = $("#txtFind").val();
    if(txtFind === "") return;

    let id = parseInt(txtFind); //Transforma el txtBuscar en un número entero
    console.log(id);
    if(isNaN(id)){
        $.ajax({        
            type: "GET", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/creator/retrieve?name=" + txtFind, //Dirección para realizar la petición HTTP        
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
            url: "http://localhost:8080/creator/retrieve/" + id, //Dirección para realizar la petición HTTP        
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
    let creator = {
        //"id_Creator":parseInt($("txtid_Creator").val()),
      "name" : $("#txtName").val(),
        "date_Birth" : $("#txtDate_Birth").val(),
        "nacionality" : $("#txtNacionality").val(), 
        "mail" : $("#txtMail").val(),       
        "id_Creators" : $("#txtid_Creators").val(),
        "creator_Password" : $("#txtPassword").val(),
    };
    return creator;
}

function save(){
    //Crear el objeto
    alert("SE GUARDA");
    var creator = serializeForm();
    console.log(creator);
    var requestBody = JSON.stringify(creator);
    console.log(requestBody);
    //Utilizar jQuery AJAX para enviar al Backend
    $.ajax({        
        type: "POST", //Verbo de HTTP a utilizar
        url: "http://localhost:8080/creator/create", //Dirección para realizar la petición HTTP
        data: requestBody, //El contenido Body de la petición HTTP                
        contentType : "application/json",
        crossDomain: true,
        dataType: "json",
        success : function(response){
            console.log(response);
            alert("SE GUARDA LINEA 93");                
        },
        error : function(err){
            console.error(err);
            alert("SE GUARDA LINEA 97");
        }            
    });
}

$(function() {       

    $('#frmCreator').on('submit', function() {
        var form = document.getElementById('frmCreator');
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
