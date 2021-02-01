let eventos;

fetch(
  "https://www.thesportsdb.com/api/v1/json/1/eventsseason.php?id=4335&s=2019-2020"
)
  .then((data) => data.json())
  .then((data) => {
    eventos = data;
  });
//console.log("Ejecución despues de la promesa");

function imprimirEquipo() {}

function buscarEquipo(equipo) {
  let golesLocal = 0;
  let golesVisitante = 0;
  temporada1920.events.forEach((partido) => {
    if (partido.strHomeTeam === equipo || partido.strAwayTeam === equipo) {
      console.log(
        `Local: ${partido.strHomeTeam} : ${partido.intHomeScore} VS Visitante: ${partido.strAwayTeam}: ${partido.intAwayScore}`
      );

      if (partido.strHomeTeam === equipo) {
        golesLocal += parseInt(partido.intHomeScore);
      } else {
        golesVisitante += parseInt(partido.intAwayScore);
      }
    }
  });

  console.log(
    `Goles Local: ${golesLocal}
      Goles Visitante: ${golesVisitante}`
  );
}
