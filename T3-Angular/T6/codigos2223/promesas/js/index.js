//let urlStringProductos = "https://dummyjson.com/products";
let urlStringProductos = "https://dummyjson.com/products/category/";
let urlStringCategorias = "https://dummyjson.com/products/categories";
let rowCartas = document.querySelector(".row");

let selectCategorias = document.querySelector("select");
let botonFiltro = document.querySelector("button");

cargarCategorias();
botonFiltro.addEventListener("click", (e) => {
  let categoria = selectCategorias.value;
  cargarProductos(categoria);
});

function cargarProductos(categoria) {
  /* https://dummyjson.com/products/search?q=categoria */

  // https://dummyjson.com/products/search?q=Smartphone
  // https://dummyjson.com/products/search?q=Laptop

  /* categoria =
    categoria.charAt(0).toLocaleUpperCase() +
    categoria.substring(1, categoria.length - 1); */
  console.log(urlStringProductos + categoria);
  borrarProdiuctos();
  fetch(urlStringProductos + categoria)
    .then((res) => {
      return res.json();
    })
    .then((res1) => {
      res1.products.forEach((item) => {
        // title
        // description
        // images[0]
        // price
        rowCartas.innerHTML += `<div class="col">
          <div class="card" style="width: 18rem">
            <img src="${item.images[0]}" class="card-img-top" alt="..." />
            <div class="card-body">
              <h5 class="card-title">${item.title}</h5>
              <p class="card-text">
                ${item.description}
              </p>
              <h6>${item.price}</h6>
            </div>
          </div>
        </div>`;
      });
    })
    .catch((err) => {});
}
function cargarCategorias() {
  fetch(urlStringCategorias)
    .then((res) => {
      return res.json();
    })
    .then((res1) => {
      res1.forEach((element) => {
        selectCategorias.innerHTML += `<option value="${element}">${element}</option>`;
      });
    })
    .catch((err) => {
      console.log(`Error en la promesa ${err}`);
    });
}
function borrarProdiuctos() {
  rowCartas.innerHTML = "";
}

// jdbc
// connection.createStatement().executeQuery()
/* fetch(urlString)
  .then((res) => res.json())
  .then((res1) => {
    res1.products.forEach((item) => {
      console.log(`${item.title} ${item.price}`);
    });
  })
  .catch((err) => {
    console.log("fetch resuelta sin exito");
  })
  .finally(() => {
    console.log("Fin de la evaluacion de la promesa");
  }); */
// Sacar por consola la lista de productos
// (precio y nombre) del json
