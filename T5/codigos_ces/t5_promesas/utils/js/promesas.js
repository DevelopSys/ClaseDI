let boton = document.querySelector("button");
let span = document.querySelector("span");
let listaMasculina = document.querySelector("#lista-masculina");
let listaFemenina = document.querySelector("#lista-femenina");
let contador = 0;
/* ejecuta algo pasados ms */
setTimeout(() => {
  console.log("Ejecucion postergada");
}, 5000);

boton.addEventListener("click", (e) => {
  setInterval(() => {
    contador++;
    span.innerHTML = contador;
  }, 1000);
});

let promesa = new Promise((res, rej) => {
  setTimeout(() => {
    let aleatorio = Math.random() * 11;
    if (aleatorio >= 5) {
      // correcta
      res(aleatorio);
    } else {
      // incorrecta
      rej("Fallo en la promesa, numero pequeño");
    }
  }, 4000);
});

promesa
  .then((res) => res)
  .then((res1) => {
    console.log(res1 * 2);
  })
  .catch((err) => {
    console.log(err);
  });

function consultarUsuarios() {
  // https://randomuser.me/api/?results=50
  fetch("https://randomuser.me/api/?results=50")
    .then((res) => {
      if (res.ok) {
        // pasar a json
        return res.json();
      }
    })
    .then((res1) => {
      res1.results.forEach((element) => {
        if (element.gender == "female") {
          //console.log(element.name.first + " " + element.name.last);
          listaFemenina.innerHTML += `<li class='list-group-item'>${element.name.first} ${element.name.last}</li>`;
        } else {
          listaMasculina.innerHTML += `<li class='list-group-item'>${element.name.first} ${element.name.last}</li>`;
        }
      });
      // console.log(res1.results);
      // sacar los nombre de todos los usuarios (nombre - apellido)
    })
    .catch((err) => {});
}

consultarUsuarios();
