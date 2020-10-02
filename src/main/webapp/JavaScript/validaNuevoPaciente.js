            function valida(form) {            
                if(document.forma.codigo.value ===''){
                    alert("falta introducir el codigo"),
                    form.cancelFormSubmission();
                    
            }else{                 
                    if(document.forma.dpi.value ===''){ 
                        alert("falta introducir el dpi"),
                        form.cancelFormSubmission();
                }else{
                        if(document.forma.nombre.value ===''){
                            form.cancelFormSubmission(),
                            alert("falta introducir el nombre");       
                    }else{ 
                            if(document.forma.password.value ===''){
                                form.cancelFormSubmission(),
                                alert("falta introducir el password");
                            
                        }else{ 
                                alert("Informacion enviada");
                                form.submit();
                        }
                    }
                }          
            }
        }