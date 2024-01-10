let boton = document.querySelector("button");
let span = document.querySelector("span");
let inputResultados = document.querySelector("#input-resultados");
let listaMasculina = document.querySelector("#lista-masculina");
let listaFemenina = document.querySelector("#lista-femenina");
let contador = 0;
/* ejecuta algo pasados ms */
setTimeout(() => {
  console.log("Ejecucion postergada");
}, 5000);

boton.addEventListener("click", (e) => {
  /* setInterval(() => {
    contador++;
    span.innerHTML = contador;
  }, 1000); */
  let numeroResultados = inputResultados.value;
  consultarUsuarios(numeroResultados);
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

function consultarUsuarios(numero) {
  // https://randomuser.me/api/?results=50
  listaFemenina.innerHTML = "";
  // listaFemenina.removeChild()
  listaMasculina.innerHTML = "";
  fetch("https://randomuser.me/api/?results=" + numero)
    .then((res) => {
      if (res.ok) {
        // pasar a json
        return res.json();
      }
    })
    .then((res1) => {
      res1.results.forEach((element, index) => {
        setTimeout(function () {
          //listaMasculina.innerHTML += `<li class="list-group-item animate__animated animate__bounceInUp">${element.name.first} ${element.name.last}</li>`;
          let nodo = document.createElement("li");
          nodo.textContent = `${element.name.first} ${element.name.last}`;
          nodo.className =
            "list-group-item animate__animated animate__bounceInUp";
          if (element.gender == "female") {
            listaFemenina.appendChild(nodo);
          } else {
            listaMasculina.appendChild(nodo);
          }
        }, index * 500);
      });
      /* res1.results.forEach((element) => {
        if (element.gender == "female") {
          //console.log(element.name.first + " " + element.name.last);

          listaFemenina.innerHTML += `<li class='list-group-item animate__animated animate__bounceInUp'>${element.name.first} ${element.name.last}</li>`;
        } else {
          listaMasculina.innerHTML += `<li class='list-group-item animate__animated animate__bounceInUp'>${element.name.first} ${element.name.last}</li>`;
        }
      }); */
      // console.log(res1.results);
      // sacar los nombre de todos los usuarios (nombre - apellido)
    })
    .catch((err) => {});
}

var sleep = function (ms) {
  return new Promise((resolve) => setTimeout(resolve, ms));
};

//consultarUsuarios();
