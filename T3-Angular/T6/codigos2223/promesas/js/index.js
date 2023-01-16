let urlString = "https://dummyjson.com/products";

// jdbc
// connection.createStatement().executeQuery()

fetch(urlString)
  .then((res) => res.json())
  .then((res1) => {
    console.log(res1);
  })
  .catch((err) => {
    console.log("fetch resuelta sin exito");
  })
  .finally(() => {
    console.log("Fin de la evaluacion de la promesa");
  });

// Sacar por consola la lista de productos
// (precio y nombre) del json
