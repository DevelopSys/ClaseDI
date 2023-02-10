let inputCategoria = document.querySelector("#input_categoria");
let inputNoticia = document.querySelector("#input_query");
let inputTamanio = document.querySelector("#input_size");
let botonNoticas = document.querySelector("#boton_noticias");
let botonCategorias = document.querySelector("#boton_categorias");
let resultadosCartas = document.querySelector("#resultados");

let urlCategoria =
  "https://cors-anywhere.herokuapp.com/https://content.guardianapis.com/search?api-key=fe0767e4-aab7-4908-ba72-b444332b658d&section={seccion}";

botonNoticas.addEventListener("click", (e) => {
  consultarNoticia();
});
botonCategorias.addEventListener("click", (e) => {
  consultarCategoria();
});

function consultarNoticia() {
  let query = inputNoticia.value;
  let size = inputTamanio.value;

  if (query.length > 0 && !isNaN(Number(size))) {
    resultadosCartas.innerHTML = "";
    let urlNoticia = `https://cors-anywhere.herokuapp.com/https://content.guardianapis.com/search?api-key=fe0767e4-aab7-4908-ba72-b444332b658d&q=${query}&page-size=${size}`;
    fetch(urlNoticia)
      .then((ok) => ok.json())
      .then((ok1) => {
        ok1.response.results.forEach((element) => {
          /* element.webTitle;
            element.webUrl; */
          resultadosCartas.innerHTML += `<div class="col">
          <div class="card" style="width: 18rem">
            <div class="card-body">
              <h5 class="card-title">${element.webTitle}</h5>
              <a href="${element.webUrl}" class="btn btn-primary">Ir a la web</a>
            </div>
          </div>
        </div>`;
        });
      });
  } else {
  }
}

function consultarCategoria() {
  let categoria = inputCategoria.value;

  resultadosCartas.innerHTML = "";
  let urlNoticia = `https://content.guardianapis.com/search?api-key=fe0767e4-aab7-4908-ba72-b444332b658d&section=${categoria}}`;
  fetch(urlNoticia)
    .then((ok) => ok.json())
    .then((ok1) => {
      ok1.response.results.forEach((element) => {
        /* element.webTitle;
            element.webUrl; */
        resultadosCartas.innerHTML += `<div class="col">
          <div class="card" style="width: 18rem">
            <div class="card-body">
              <h5 class="card-title">${element.webTitle}</h5>
              <a href="${element.webUrl}" class="btn btn-primary">Ir a la web</a>
            </div>
          </div>
        </div>`;
      });
    });
}
