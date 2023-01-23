// Accion a ejecutar con respuesta en futuro
// resuelta --> hay exito --> then
// rechazada --> no ho hay existo --> catch
// Asincronia --> ejecuciones paralelas
// Promise((res,rej)=>{})
// fetch(url).then().catch()
/* let promesaPropia = new Promise((res, rej) => {
  // logica de la promesa --> conecta con la url y obten las cabeceras
  setTimeout(() => {
    let numero = Math.random() * 101;
    if (numero >= 50) {
      res(numero);
    } else {
      rej("No se puede consultar, promesa rechazada");
    }
  }, 5000);
});

promesaPropia
  .then((exito) => {
    exito > 80
      ? console.log("Muchas posibilidades")
      : console.log("Posibilidades bajas");

    console.log(exito);
    return 7;
  })
  .then((exito1) => {
    console.log("Respuesta de la promesa encadenada" + exito1);
    // un numero
    // uno de los dos string
    // la promesa propies
    // nada
    // la promesa anterior
    return 10;
  })
  .then((exito2) => {})
  .catch((err) => {
    console.log(err);
  });

// 78 --> No se puede consultar, promesa rechazada
// promesa
//console.log(promesa);
 */

window.addEventListener("load", () => {
  document.querySelector("#boton").addEventListener("click", () => {});
});

fetch("https://jsonplaceholder.typicode.com/todos")
  .then((exito) => {
    return exito.json();

    //json
    //cabeceras
    //undefined
    //promesa
  })
  .then((exito1) => {
    /* exito1.forEach((element) => {
      console.log(element.title);
      console.log(element.completed);
    }); */
  })
  .catch((err) => {
    console.log(err);
  });
