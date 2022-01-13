let input = document.querySelector("#input-numero");
let select = document.querySelector("#select-genero");
let boton = document.querySelector("#boton-filtro");

boton.addEventListener("click", (e) => {
  let genero = select.value;
  let numero = input.value;
  let url = `https://randomuser.me/api/?results=${numero}&gender=${genero}`;
  fetch(url)
    .then((res) => {
      return res.json();
    })
    .then((res) => {
      res.results.forEach((element) => {
        // pìnto la carta y la agrego a
        console.log("ejemplo");
        let contenedor = document.querySelector("#contenedor-cartas");
        contenedor +=
        contenedor.innerHTML +
          `<div class="col">
          <div class="card" style="width: 18rem;">
              <img src="..." class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                <a href="#" class="btn btn-primary">Go somewhere</a>
              </div>
            </div>
      </div>`;
      });
    });
});
