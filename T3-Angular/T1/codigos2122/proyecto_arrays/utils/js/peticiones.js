/*let promesa = new Promise((res, rej) => {
  // lo que pasa en la ejecucion
  setTimeout(() => {
    let numero1 = 10;
    let numero2 = 30;
    if (numero1 + numero2 > 50) {
      res(1);
    } else {
      rej(2);
    }
  }, 5000);
});

setInterval(() => {
  console.log("Ejecutando");
}, 1000);

promesa
  .then(
    (res) => {
      console.log("Constestacion OK " + res);
    },
    (rej) => {
      console.log("Constestacion fail " + rej);
    }
  )
  .catch((err) => {});*/

let url = "https://randomuser.me/api/?results=10";
fetch(url)
  .then(
    (res) => {
      return res.json();
    },
    (rej) => {}
  )
  .then(
    (res) => {
        /*res.results.forEach(element => {
            console.log(`${element.name.title} ${element.name.first} ${element.name.last}`);
        });*/

        recorrerNombres(res.resultado)

        // "Miss Myryam Cuppen" 
    },
    (rej) => {}
  );

  function recorrerNombres(resultado) {
    resultado.forEach(element => {
        console.log(`${element.name.title} ${element.name.first} ${element.name.last}`);
    });;
  }
