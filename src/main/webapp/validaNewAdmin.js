var codigo = document.getElementById('codigo');
var dpi = document.getElementById('dpi');
var nombre = document.getElementById('nombre');
var password = document.getElementById('password');

function valida(form) {
    if (document.forma.codigo.value === null)
        alert("falta introducir el codigo");
    else {
        if (document.forma.nombre.value === "")
            alert("falta introducir el nombre");
        else {
            if (document.forma.dpi.value === "")
                alert("falta introducir el dpi");
            else {
                if (document.forma.password.value === "")
                    alert("falta introducir el password");
                else
                    form.submit();
            }
        }
    }
}

