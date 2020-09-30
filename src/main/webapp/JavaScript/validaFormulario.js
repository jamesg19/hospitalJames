/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
