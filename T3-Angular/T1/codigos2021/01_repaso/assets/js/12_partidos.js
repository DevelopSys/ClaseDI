// consulta desde el link todos los partidos de un equipo dado
// fetch("https://www.thesportsdb.com/api/v1/json/1/eventsseason.php?id=4335&s=2019-2020");
// Barcelona Villarreal

// funcion que obtenga un nombre y me mueste solo los partidos del nombre introducido

// al darle al input
// si no hay nada en el input salte un alert con aviso: No hay equipo introducido
// si hay equipo pero no encuentra partidos salte otro alert: No hay partidos del equipo solicitado

function mostrarPartidos(equipo) {
  if (equipo.length == 0) {
    alert("Por favor mete algo");
  } else {
    let numeroPartidos = 0;
    fetch(
      "https://www.thesportsdb.com/api/v1/json/1/eventsseason.php?id=4335&s=2019-2020"
    )
      .then((data) => data.json())
      .then((data) =>
        //console.log(data.events[1].strHomeTeam + " " + data.events[1].strAwayTeam)
        /*console.log(
                `${data.events[0].strHomeTeam}: ${data.events[0].intHomeScore} vs ${data.events[0].strAwayTeam}: ${data.events[0].intAwayScore}`
              )*/
        {
          let partidos = data.events;
          partidos.forEach((element) => {
            if (
              element.strHomeTeam == equipo ||
              element.strAwayTeam == equipo
            ) {
              numeroPartidos++;
              console.log(
                `${element.strHomeTeam}: ${element.intHomeScore} vs ${element.strAwayTeam}: ${element.intAwayScore}`
              );
            }
          });

          numeroPartidos < 1 &&
            alert("No se han encontrado partidos del equipo");
        }
      );
  }
}

let misPartidos = [];
function cargarPartidos(equipo) {
  misPartidos = [];
  if (equipo.length == 0) {
    alert("Por favor mete algo");
  } else {
    let numeroPartidos = 0;
    fetch(
      "https://www.thesportsdb.com/api/v1/json/1/eventsseason.php?id=4335&s=2019-2020"
    )
      .then((data) => data.json())
      .then((data) => {
        let partidos = data.events;
        partidos.forEach((element) => {
          if (element.strHomeTeam == equipo || element.strAwayTeam == equipo) {
            numeroPartidos++;
            let partidoIndividual = new Partido(
              element.strHomeTeam,
              element.intHomeScore,
              element.strAwayTeam,
              element.intAwayScore
            );
            misPartidos.push(partidoIndividual);
          }
        });

        numeroPartidos < 1 && alert("No se han encontrado partidos del equipo");
      });
  }
}

function mostrarCargados() {
  if (misPartidos.length > 0) {
    misPartidos.forEach((element) => {
      element.mostrarDatos();
    });
  } else {
    alert("no hay partidos cargados");
  }
}

//mostrarPartidos("Real Madrid");

// desde un input situado en el html quiero introducir un equipo y al pulsar boton muestre sus partidos en consola
