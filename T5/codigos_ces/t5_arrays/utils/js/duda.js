let boton = document.querySelector("button");

let personas = [
  { nombre: "borja", apellido: "martin" },
  { nombre: "rebeca", apellido: "de diego" },
];

let editarPersona = {
  handle: function (event) {
    alert(`Editando datos de la persona ${personas[0].nombre}`);
  },
};

boton.addEventListener("click", (e) => {
  editarPersona.handle(e);
});
