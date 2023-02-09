window.addEventListener("load", (e) => {
  console.log("pagina cargada");
  let inputNombre = document.querySelector("#input_nombre");
  console.log(inputNombre);
});

let url = "https://jsonplaceholder.typicode.com/posts";

const arrayPosts = [];
let contador = 0;

fetch(url)
  .then((ok) => {
    if (ok.status == 200) {
      return ok.json();
    } else {
      console.log("Conexion correcta, url no codificada");
    }
  })
  .then((ok1) => {
    //console.log(ok1);
    ok1.forEach((element) => {
      const post = {
        title: element.title,
        body: element.body,
      };
      arrayPosts.push(post);
      //console.log(arrayPosts);
    });
  })
  .catch((err) => {
    console.log("La conexion no se ha podido producir");
  })
  .finally(() => {
    console.log(arrayPosts.length);
  });

/* arrayPosts.forEach((element) => {
  console.log(element);
}); */
