async function registrarUsuario(){
    let datos = {
        nombre: document.getElementById("campoNombre").value,
        apellido: document.getElementById("campoApellidos").value,
        email: document.getElementById("campoEmail").value,
        password: document.getElementById("campoPassword").value,
    };

    let rePassword = document.getElementById("campoRePassword").value;

    if( datos.password != rePassword ){
        alert("Las contraseñas no coinciden");
        return;
    }

    await fetch('/api/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
}