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

let urlProductos = "https://dummyjson.com/products/category/";
let selectCategorias = document.querySelector("select");
let filaCartas = document.querySelector(".row .row");

selectCategorias.addEventListener("change", (e) => {
  consultarProductos(e.target.value);
});

function consultarProductos(categoria) {
  filaCartas.innerHTML = "";
  fetch(urlProductos + categoria)
    .then((ok) => {
      console.log(ok);
      return ok.json();
    })
    .then((ok1) => {
      ok1.products.forEach((element) => {
        //console.log(element.title);
        // pintar cada carta en el innerHTML de la row
        filaCartas.innerHTML += `<div class="col">
              <div class="card" style="width: 18rem">
                <img src="${element.images[0]}" class="card-img-top" alt="..." />
                <div class="card-body">
                  <h5 class="card-title">${element.title}</h5>
                  <h6 class="card-title">${element.price}</h6>
                  <p class="card-text">
                   ${element.description}
                  </p>
                  <button class="btn btn-primary">Agregar a carrito</button>
                </div>
              </div>
            </div>`;
      });
    })
    .catch((err) => {
      alert("Conexion incorrecta");
    });
}

fetch("https://dummyjson.com/products/categories")
  .then((ok) => ok.json())
  .then((ok1) => {
    ok1.forEach((element) => {
      selectCategorias.innerHTML += `<option>${element}</option>`;
    });
  });
