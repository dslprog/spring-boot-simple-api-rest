async function iniciarSesion(){
    let datos = {
        email: document.getElementById("campoEmail").value,
        password: document.getElementById("campoPassword").value,
    };

    const request = await fetch('/api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    const response = await request.text();
    if( response != "KO" ){
        localStorage.token = response;
        localStorage.email = datos.email;
        location.href = "usuarios.html";
    }else{
        alert("Usuario/password incorrecto");
    }
}