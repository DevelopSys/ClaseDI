/* let promesa = new Promise((resolve, reject) => {
  // el cuerpo de la promesa -> lo que quieres ejecutar y puede salir bien o mal
  // vamos a generar un aleatorio entre 0-10
  // sale bien 5-10
  // sale mal 0-4.99
  setTimeout(() => {
    let aleatorio = Math.random() * 11;
    if (aleatorio >= 5) {
      // ha salido bien
      resolve(aleatorio);
    } else {
      // ha salido mal
      reject("El numero es demasiado pequeño");
    }
  }, 5000);
}); */

//resolucionPromesa();

// cuando termines, dime que hago
/* setInterval(() => {
  console.log("Ejecucion en intervalo");
}, 1000);

async function resolucionPromesa() {
  let resultado = await promesa;
  let resultadoDuplicado = await resultado;
  console.log(resultadoDuplicado);
}
 */
/* promesa
  .then((res) => {
    console.log(`El parametro generado es ${res}`);
    return res;
  })
  .then((res1) => {
    setTimeout(() => {
      console.log("Ejecucion de la segunda promesa: " + res1 * 2);
    }, 5000);
  })
  .catch((err) => {
    console.log(`El error es: ${err}`);
  }); */

// METODO DE CONEXION SEA DIFERENTE A GET y NECESITE PARAMS
fetch("https://dummyjson.com/users")
  .then((res) => res.json())
  .then((res1) => {
    // nombre y apellido de todos los usuarios
    //console.log(res1.users);
    res1.users.forEach((element) => {
      console.log(element.firstName + " " + element.lastName);
    });
  });
