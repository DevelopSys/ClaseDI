/*
acciones que se ejecutan y tardan
*/
/*
let promesa = new Promise(function (resolve, reject) {
  let numero = 6;
  if (numero > 0) {
    // la promesa se resuleve bien
    resolve();
  } else {
    // la promesa no se resuelve bien
    reject();
  }
});
// promesa.then() ejecutado cuando la promesa ha termiando con resultado correcto
// promesa.catch() ejecutado cuando la promesa ha terminado con un resultado incorrecto

promesa
  .then(
    function () {
      // se ejecuta cuando se ha cumplido el resolve
    },
    function () {
      // se ejecunta cuando ha cumplido el reject
    }
  )
  .catch(function () {
    // se ejecuta cuando ha ocurrido algun problema o la promesa no contesta
  });


let promesaFlecha = new Promise((resolve, reject) => {
  let numero = 6;
  /*if (numero > 0) {
    resolve();
  } else {
    reject();
  }
  // condicion ? valor_true : valor_false
  // condicion && valor_true

  numero > 0 ? resolve("acierto", 1) : reject("fallo", 5);
  //numero > 0 && resolve();
});

promesaFlecha
  .then(
    (mensaje, numero) =>
      console.log(
        "ejecutado correctamente con mensaje " + mensaje + " y numero " + numero
      ),
    (mensaje, numero) => console.log("ejecutado con reject")
  )
  .catch(() => console.log("ejecutado con error"));
*/

fetch(
  //"https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=Spain"
  "https://www.thesportsdb.com/api/v1/json/1/eventsseason.php?id=4335&s=2019-2020"
)
  .then((data) => {
    return data.json();
  })
  .then((data) => {
    console.log(data.events);
  });
/*.then((dataJson) => {
    console.log(dataJson);
    let equipos = dataJson.teams;
    equipos.forEach(({ strTeam, intFormedYear }) => {
      //console.log(equipo);
      console.log(`Nombre: ${strTeam} Fundacion: ${intFormedYear}`);
    });
  })
  .catch(() => {
    console.log("conexion en el tratamiento");
  });*/
