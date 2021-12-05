// Call the dataTables jQuery plugin
$(document).ready(async function () {
  await cargarUsuarios();
  $('#tablaUsuarios').DataTable();
});

function getRestHeaders(){
  return {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': localStorage.token
  }
}

async function cargarUsuarios(){
  const response = await fetch('/api/usuarios', {
    method: 'GET',
    headers: getRestHeaders()
  });
  const usuarios = await response.json();

  let html = "";
  for (const usuario of usuarios) {
    let botonEliminar = '<a onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>';
    html += "<tr><td>"+usuario.id+"</td>\n" +
        "<td>"+usuario.nombre+"</td>\n" +
        "<td>"+usuario.email+"</td>\n" +
        "<td>"+usuario.telefono+"</td>\n" +
        "<td>"+ botonEliminar +"</td>" +
        "</tr>";
  }
  document.querySelector("#tablaUsuarios tbody").innerHTML = html;
}

async function eliminarUsuario(id){
  if( confirm("¿Estás seguro?") ){
    await fetch('/api/usuario/' + id,{
      method: 'DELETE',
      headers: getRestHeaders()
    });
    location.reload();
  }
}