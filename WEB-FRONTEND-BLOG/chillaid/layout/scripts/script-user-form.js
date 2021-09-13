function set(user){
    $("#txtName").val(user.name);
    $("#txtDate_Birth").val(user.date_Birth);
    $("#txtNacionality").val(user.nacionality);
    $("#txtMail").val(user.mail);
    $("#txtId_Users").val(user.Id_Users);
    $("#txtUser_Password").val(user.User_Password);
}

function retrieve(){       
    let txtFind = $("#txtFind").val();
    if(txtFind === "") return;

    let id = parseInt(txtFind); //Transforma el txtBuscar en un número entero
    console.log(id);
    if(isNaN(id)){
        $.ajax({        
            type: "GET", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/user/retrieve?name=" + txtFind, //Dirección para realizar la petición HTTP        
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
            url: "http://localhost:8080/user/retrieve/" + id, //Dirección para realizar la petición HTTP        
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
    let user = {
        "name" : $("#txtName").val(),
        "date_Birth" : $("#txtDate_Birth").val(),
        "nacionality" : $("#txtNacionality").val(), 
        "mail" : $("#txtMail").val(),       
        "Id_Users" : $("#txtId_Users").val(),
        "User_Password" : $("#txtUser_Password").val(),
    };
    return user;
}

function save(){
    //Crear el objeto
    var user = serializeForm();
    console.log(user);
    var requestBody = JSON.stringify(user);
    console.log(requestBody);
    //Utilizar jQuery AJAX para enviar al Backend
    if(user.Id_User == 0){
        $.ajax({        
            type: "POST", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/user/create", //Dirección para realizar la petición HTTP
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
        let id = user.Id_User;
        $.ajax({        
            type: "PUT", //Verbo de HTTP a utilizar
            url: "http://localhost:8080/user/update/" + id, //Dirección para realizar la petición HTTP
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

    $('#frmUser').on('submit', function() {
        var form = document.getElementById('frmUser');
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
