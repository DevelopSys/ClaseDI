let elementos = document.querySelectorAll("div.container#containerPrincipal");
//console.log(elementos);
let elemento = document.querySelector("#inputCol1");
//console.log(elemento.value);

function botonPulsado(valorInput) {
  //console.log("El boton uno ha sido pulsado");
  //let valor = document.querySelector("#inputCol1").value;
  console.log(valorInput.value);
}

// funcionalidad para que al pulsar un input salga
// por consola lo que hay escrito en el input

function inputPulsado(evento) {
  //console.log(document.querySelector("#inputCol2").value);
  console.log(evento.target.value);
}
