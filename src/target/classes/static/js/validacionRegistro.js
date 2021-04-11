window.onload = iniciar;


function iniciar() {
    document.getElementById("enviar").addEventListener("click", validar, false);
}

function validarNombreApellidos(){

    let nombre = document.getElementById("nombre");
    let apellidos = document.getElementById("apellidos");  

    if(nombre.value === ""){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'El campo nombre no puede estar vacío'           
          })            
        return false;
    }else if(apellidos.value === ""){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'El campo Apellidos no puede estar vacío'           
          })      
        return false;

    }

    return true;

}

function validarPassword(){

  let expPassword = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,15}$/g 
  let password = document.getElementById("password");

  if(expPassword.test(password.value)){
      return true;
  }else{
      Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'El campo Password debe de contener letras tanto en mayusculas y minusculas como caracteres numericos.El tamaño de la contraseña sea de 6 a 15 caracteres. '           
        })   
      return false;
  }


}

function validarCorreo(){
  let expCorreo = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/g

  let correo = document.getElementById("email");

  if(expCorreo.test(correo.value)){
    return true;
  }else{
    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'Dirección de correo electronico no soportado '           
    })   

    return false;
  }

}

function validar(e) {
    if (validarNombreApellidos()  && validarCorreo() && validarPassword() && confirm("Desea enviar estos datos")) {
      return true;
    } else {
      e.preventDefault();
      return false;
    }
}