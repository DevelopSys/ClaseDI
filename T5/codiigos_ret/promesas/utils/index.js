// genera un numero,
// si es >5 resolver de forma OK
// si es menor que 5 resuelves mal

/* let intervalo = setInterval(() => {
  console.log("Ejecutando de forma intervalo");
}, 500); */

let boton = document.querySelector("#btnBuscar");
let input = document.querySelector("#inputPalabra");
let div = document.querySelector("#divResultado");

let palabras = ["programacion", "js", "sistemas", "base datos", "diccionario"];

/* let busqueda = new Promise((res, rej) => {
  setTimeout(() => {
    let aleatorio = Math.random() * 11;
    if (aleatorio < 5) {
      rej("Numero pequeño");
    } else {
      res(aleatorio);
    }
  }, 5000);
}); */

boton.addEventListener("click", () => {
  let busqueda = new Promise((res, rej) => {
    setTimeout(() => {
      // string || undefined
      let encontrado = palabras.find((item) => {
        return item == input.value;
      });
      if (encontrado != undefined) {
        res(encontrado);
      } else {
        rej("elemento no encontrado");
      }
    }, 5000);
  });
  busqueda
    .then((ok) => {
      div.innerHTML = `<span>El elemento se ha encontrado ${ok}}</span>`;
      // console.log(`Elemento encontrado con valor ${ok}`);
      setTimeout(() => {
        div.innerHTML = "";
      }, 5000);
    })
    .catch((err) => {
      div.innerHTML = `<span>No encontrado</span>`;
      // console.log(`${err}`);
    });
});

/* busqueda
  .then((res) => {
    console.log("Promesa resuelta correctamente");
    console.log(`El numero generado es ${res}`);
    // clearInterval(intervalo);
  })
  .catch((rej) => {
    console.log(rej);
  }); */
