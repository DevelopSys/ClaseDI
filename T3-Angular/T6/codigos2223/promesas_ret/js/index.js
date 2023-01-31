// Promise (acepto, rechazo)
/* let promesaInicial = new Promise((res, rej) => {
  // lógica de ejecucion
  setTimeout(() => {
    let numero = Math.random() * 101;
    if (numero >= 50) {
      res(numero);
    } else {
      rej("Promesa con resultado incorrecto");
    }
  }, 5000);
}); */

// res --> then definiendo la funcion del res
// rej --> catch definiendo la funcion del rej

/* promesaInicial
  .then((ok) => {
    // resultado correcto
    console.log(`La promesa ha contestado con un resultado de ${ok}`);
  })
  .catch((err) => {
    // resultao incorrecto
    console.log(`${err}`);
  })
  .finally(() => {
    console.log("Ejecucion en cualquiera de los casos");
  }); */

/* setInterval(() => {
  console.log("Ejecucion");
}, 2000); */

// cargar en un select todas las categorias de los productos
fetch("https://dummyjson.com/products")
  .then((ok) => ok.json())
  .then((ok1) => {
    console.log(ok1);
    ok1.products.forEach((element) => {
      console.log(element.title);
    });
  })
  .catch((err) => {
    console.log("Conexion incorrecta");
  });

let selectCategorias = document.querySelector("select");
selectCategorias.addEventListener("change", (e) => {
  console.log(e.target.value);
});

fetch("https://dummyjson.com/products/categories")
  .then((ok) => ok.json())
  .then((ok1) => {
    ok1.forEach((element) => {
      selectCategorias.innerHTML += `<option>${element}<option>`;
    });
  });
