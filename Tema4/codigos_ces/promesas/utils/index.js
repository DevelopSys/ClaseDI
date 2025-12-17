fetch(
  "https://www.thesportsdb.com/api/v1/json/123/search_all_teams.php?s=Soccer&c=Italy"
)
  .then((res) => {
    return res.json();
  })
  .then((res1) => {
    res1.teams.forEach((element) => {
      console.log(element.strTeam);
    });
  })
  .catch((rej) => {
    console.log("Conexion incorrecta");
  });
