async function obtencionDatos() {
  let datos = await fetch("https://dummyjson.com/products");
  let respuesta = await datos.json();
  console.log(respuesta);
}

obtencionDatos();

/* 
fetch("https://dummyjson.com/products")
  .then((ok) => {
    return ok.json();
  })
  .then((ok1) => {
    ok1.products.forEach((element) => {
      console.log(element.title);
    });
  })
  .catch((fail) => {}); */
