//Ejecutar función en el evento click
document.getElementById("btn_open").addEventListener("click", open_close_menu);

//Declaramos variables
var side_menu = document.getElementById("menu_side");
var btn_open = document.getElementById("btn_open");
var body = document.getElementById("body");

//Evento para mostrar y ocultar menú
function open_close_menu() {
    body.classList.toggle("body_move");
    side_menu.classList.toggle("menu__side_move");
}

//Si el ancho de la página es menor a 760px, ocultará el menú al recargar la página

if (window.innerWidth < 760) {

    body.classList.add("body_move");
    side_menu.classList.add("menu__side_move");
}

//Haciendo el menú responsive(adaptable)

window.addEventListener("resize", function() {

    if (window.innerWidth > 760) {

        body.classList.remove("body_move");
        side_menu.classList.remove("menu__side_move");
    }

    if (window.innerWidth < 760) {

        body.classList.add("body_move");
        side_menu.classList.add("menu__side_move");
    }

});

//funció de registre de usuari

function register() {
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function() {
        if (http.readyState == 4 && http.status == 200) {
            alert("Enviado");
        }
    }

    http.open("POST", "http://localhost:8080/login/Usuari", true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.send("usuari=" + document.getElementById("usuari").value + "&&password=" + document.getElementById("password").value + "&&email=" + document.getElementById("email").value);

}

function pulsar() {
    document.getElementById("Buscador")
}

var usuariolog;
// Funció per agregar un producte a la base de dades
// Funciona
function uno() {
    let http;
    http = new XMLHttpRequest;
    let usuario = sessionStorage.getItem("usuario");
    http.onreadystatechange = function() {
        if (http.readyState == 4 && http.status == 200) {
            alert(this.responseText);
        }
    }

    http.open("POST", "http://51.38.227.73:8080/GAI/Producte", true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.send("usuario=" + usuario +
        "&&pname=" + document.getElementById("pname").value +
        "&&pdescription=" + document.getElementById("pdescription").value +
        "&&pquantity=" + document.getElementById("pquantity").value +
        "&&x=" + document.getElementById("x").value +
        "&&y=" + document.getElementById("y").value +
        "&&pestanteria=" + document.getElementById("pestanteria").value +
        "&&ppasillo=" + document.getElementById("ppasillo").value
    );
}

// Funció per eliminar un producte de una estanteria en concret (sencer)
// Funciona
function dos() {
    let http;
    http = new XMLHttpRequest;
    let usuario = sessionStorage.getItem("usuario");

    http.onreadystatechange = function() {
        if (http.readyState == 4 && http.status == 200) {
            alert("Producto eliminat");
        }
    }

    http.open("POST", "http://51.38.227.73:8080/GAI/deleteProduct", true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.send("usuario=" + usuario +
        "&&pasillo=" + document.getElementById("delPPasillo").value +
        "&&estanteria=" + document.getElementById("delPEstanteria").value +
        "&&producto=" + document.getElementById("delPID").value);
}

// Funcions per mostrar el resultat de mostrar estanteria
// Post de mostrar estanteria
// Funciona
function tres() {
    var http;
    http = new XMLHttpRequest;
    let usuario = sessionStorage.getItem("usuario");
    http.onreadystatechange = function() {
        if (http.readyState == 4 && http.status == 200) {
            document.getElementById("respuesta").innerHTML = http.responseText;
        }
    }

    http.open("POST", "http://51.38.227.73:8080/GAI/Estanteria", true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.send("usuario=" + usuario + "&&pasillo=" + document.getElementById("npasillo").value + "&&estanteria=" + document.getElementById("nestanteria").value);
}

// Funcions per mostrar un pasillo
// Post de mostrar pasillo
// Mostra els productes que hi ha a un pasillo
// Funciona
function quatre() {
    var http;
    http = new XMLHttpRequest;
    let usuario = sessionStorage.getItem("usuario");
    http.onreadystatechange = function() {
        if (http.readyState == 4 && http.status == 200) {
            document.getElementById("respuesta").innerHTML = http.responseText;
        }
    }

    http.open("POST", "http://51.38.227.73:8080/GAI/Pasillo", true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.send("usuario=" + usuario + "&&pasillo=" + document.getElementById("mostrarPasillo").value)
}

// Funció per cercar un producte per coincidència de nom
// Mètode post que envia el value del formulari 
// Si el servlet retorna algo, això se veu reflexat al element amb id "respuesta"
// Funciona
function cinc() {
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function() {
        if (http.readyState == 4 && http.status == 200) {
            document.getElementById("respuesta").innerHTML = http.responseText;
        }
    }
    http.open("POST", "http://51.38.227.73:8080/GAI/buscarProducto", true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.send("productoN=" + document.getElementById("busqueda").value);
}

// Funció per afegir un pasillo
// Mètode post que envia la ID / número de pasillo
// Funciona
function sis() {
    var http;
    http = new XMLHttpRequest;
    let usuario = sessionStorage.getItem("usuario");
    http.onreadystatechange = function() {
        if (http.readyState == 4 && http.status == 200) {
            alert("Estanteria añadida");
        }
    }
    http.open("POST", "http://51.38.227.73:8080/GAI/addPasillo", true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.send("usuario=" + usuario +
        "&&almacen=" + document.getElementById("addPAlmacen").value +
        "&&numero=" + document.getElementById("numPer").value);
}

// Funció per eliminar un pasillo
// Mètode post que enviar "pasillo" i "almacen"
// Funciona
function set() {
    var http;
    http = new XMLHttpRequest;
    let usuario = sessionStorage.getItem("usuario");
    http.onreadystatechange = function() {
        if (http.readyState == 4 && http.status == 200) {
            alert("Pasillo eliminado");
        }
    }
    http.open("POST", "http://51.38.227.73:8080/GAI/deletePasillo", true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.send("usuario=" + usuario +
        "&&pasillo=" + document.getElementById("deletePasillo").value +
        "&&almacen=" + document.getElementById("deletePAlmacen").value);
}

// Funció per afegir estanteries
// Mètode post que enviarà almacen i pasillo
// 
function vuit() {
    var http;
    http = new XMLHttpRequest;
    let usuario = sessionStorage.getItem("usuario");
    http.onreadystatechange = function() {
        if (http.readyState == 4 && http.status == 200) {
            alert("Pasillo añadido");
        }
    }
    http.open("POST", "http://51.38.227.73:8080/GAI/addEstanteria", true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.send("usuario=" + usuario +
        "&&pasillo=" + document.getElementById("addEstanteriaP").value +
        "&&almacen=" + document.getElementById("addEstanteriaA").value +
        "&&altura=" + document.getElementById("altura").value +
        "&&anchura=" + document.getElementById("anchura").value);
}

// Funció per eliminar estanteries
// Mètode post que enviarà almacen, pasillo i estanteria
//
function nou() {
    var http;
    http = new XMLHttpRequest;
    let usuario = sessionStorage.getItem("usuario");
    http.onreadystatechange = function() {
        if (http.readyState == 4 && http.status == 200) {
            alert("Estanteria eliminada");
        }
    }
    http.open("POST", "http://51.38.227.73:8080/GAI/DeleteEstanteria", true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.send("usuario=" + usuario +
        "&&pasillo=" + document.getElementById("delEstanteriaP").value +
        "&&almacen=" + document.getElementById("delEstanteriaA").value +
        "&&estanteria=" + document.getElementById("delEstanteriaE").value);
}

// Funció per modificar la quantitat de un producte
// Mètode post que enviarà Id del producte i la quantitat
//
function deu() {
    var http;
    http = new XMLHttpRequest;
    let usuario = sessionStorage.getItem("usuario");
    http.onreadystatechange = function() {
        if (http.readyState == 4 && http.status == 200) {
            alert("Producto modificado");
        }
    }
    http.open("POST", "http://51.38.227.73:8080/GAI/modProduct", true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.send("usuario=" + usuario +
        "&&idProducto=" + document.getElementById("idProducto").value +
        "&&nombre=" + document.getElementById("nuevoNombre").value +
        "&&cantidad=" + document.getElementById("cantidadNueva").value);
}

// Mètode per iniciar sessió
// Envia l'usuari i la contrasenya
// Java sessions a nes java, que aquest comprova si l'usuari existeix dins la BBDD
// Funciona
function login() {
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function() {
        if (http.readyState == 4 && http.status == 200) {
            document.getElementById("holaaa").innerHTML = http.responseText;
            usuariolog = http.responseText;
            sessionStorage.setItem("usuario", usuariolog);
            location.reload();
        }
    }
    http.open("POST", "http://51.38.227.73:8080/GAI/UsuarioLogin", true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.send("usuario=" + document.getElementById("usuario").value + "&&password=" + document.getElementById("password").value);
}

// Per mantenir es nom de usuari dins de javascript inclus si se recarrega la pagina
window.onload = function() {
    document.getElementById("holaaa").innerHTML = sessionStorage.getItem("usuario");
}

// Logout
function logout() {
    sessionStorage.removeItem("usuario");
    location.reload();
}

function registreTreballadors() {
    let usuario = sessionStorage.getItem("usuario");
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function() {
        if (http.readyState == 4 && http.status == 200) {
            alert("Usuari registrat correctament")
        }
    }

    http.open("POST", "http://51.38.227.73:8080/GAI/registreTreballador", true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    http.send("usuario=" + usuario +
        "&&username=" + document.getElementById("username").value +
        "&&password=" + document.getElementById("password").value +
        "&&almacen=" + document.getElementById("almacen").value +
        "&&nombre=" + document.getElementById("nombre").value +
        "&&apellidos=" + document.getElementById("apellidos").value +
        "&&rango=" + document.getElementById("rango").value);

}