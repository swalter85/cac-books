function validarForm() {
    
    const email = document.getElementById("email").value;
    
    const password = document.getElementById("password").value;
    
    const tituloFormulario = document.getElementById("tituloFormulario").textContent;

    const emailError = document.getElementById("emailError");

    const passwordError = document.getElementById("passwordError");

    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    
    let valid = true;

    
    if (!emailPattern.test(email)) {
        emailError.style.display = "block";
        valid = false;
    } else {
        emailError.style.display = "none";
    }

   
    if (password.length < 6) {
        passwordError.style.display = "block";
        valid = false;
    } else {
        passwordError.style.display = "none";
    }

    if (tituloFormulario === "Registro"){
        const nombre = document.getElementById("nombre").value;
    
        const apellido = document.getElementById("apellido").value;

        const terminos = document.getElementById("terminos-condiciones").checked

        const nombreError = document.getElementById("nombreError");

        const apellidoError = document.getElementById("apellidoError");

        const terminosError = document.getElementById("terminosError");

        if (nombre.length < 2) {
            nombreError.style.display = "block";
            valid = false;
        } else {
            nombreError.style.display = "none";
        }
        if (apellido.length < 2) {
            apellidoError.style.display = "block";
            valid = false;
        } else {
            apellidoError.style.display = "none";
        }
        if (!terminos){
            terminosError.style.display = "block";
            valid = false;
        }else{
            terminosError.style.display = "none";
        }
    }

    return valid;
}