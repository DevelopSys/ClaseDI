let selectCategorias = document.querySelector("#select-categorias");
let botonBusqueda = document.querySelector("#boton-busqueda");
let inputResultados = document.querySelector("#input-resultados");
let productosCartas = document.querySelector("#productos-cartas");

cargarCategorias();

botonBusqueda.addEventListener("click", () => {
  cargarProductos(inputResultados.value, selectCategorias.value);
});

function cargarCategorias() {
  fetch("https://dummyjson.com/products/categories")
    .then((res) => {
      return res.json();
    })
    .then((res1) => {
      res1.forEach((element) => {
        selectCategorias.innerHTML += `<option>${element}</option>`;
      });
    });
}

function cargarProductos(numero, categoria) {
  productosCartas.innerHTML = "";
  let url = `https://dummyjson.com/products/category/${categoria}?limit=${numero}`;
  fetch(url)
    .then((res) => {
      return res.json();
    })
    .then((res1) => {
      res1.products.forEach((element) => {
        //console.log(element);
        productosCartas.innerHTML += `<div class="card m-4" style="width: 18rem">
        <img src="${element.thumbnail}" class="card-img-top" alt="${element.title}" />
        <div class="card-body">
          <h5 class="card-title">${element.title}</h5>
          <p class="card-text">
            ${element.price}
          </p>
          <div class="row">
                  <a href="#" class="btn btn-primary col">Comprar</a>
                  <a href="#" class="btn btn-success col">Ver detalle</a>
                </div>
        </div>
      </div>`;
      });
    });
}
