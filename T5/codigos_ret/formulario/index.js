let inputNombre = document.querySelector("#input-nombre");
let inputEdad = document.querySelector("#input-edad");
let inputFecha = document.querySelector("#input-fecha");
let selectOpcion = document.querySelector("#select-opcion");
let boton = document.querySelector("#boton-enviar");

boton.addEventListener("click", () => {
  console.log(inputNombre.value);
  console.log(inputEdad.value);
  let fecha = new Date(inputFecha.value);
  console.log(new Date(inputFecha.value));
  let seleccionado = document.querySelector("input[type='radio']:checked");
  //console.log(seleccionado.id);

  seleccionado.id == "radio-masculino"
    ? console.log("seleccionado masculino")
    : console.log("Seleccionado femenino");
  //
});
