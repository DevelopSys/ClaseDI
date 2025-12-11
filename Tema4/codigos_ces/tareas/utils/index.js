let boton = document.querySelector("#btnAgregar");
let parrafo = document.querySelector("#contenido");
boton.addEventListener("click", () => {
  let tarea1 = new tarea("Tarea 1", new Date(), "Baja");
  tarea1.mostrarDatos();
});
