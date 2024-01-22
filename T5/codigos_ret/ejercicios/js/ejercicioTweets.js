let boton = document.querySelector("#boton-enviar");
let contador = document.querySelector("#contador-palabras");
let inputMensaje = document.querySelector("#input-mensaje");
let lista = document.querySelector("#lista-mensajes");

boton.addEventListener("click", () => {
  lista.innerHTML += `<li class='list-group-item'>${inputMensaje.value}</li>`;
  inputMensaje.value = "";
});

inputMensaje.addEventListener("keyup", (e) => {
  console.log(e.key);
  contador.innerHTML = `${e.target.value.length}/255`;
});
