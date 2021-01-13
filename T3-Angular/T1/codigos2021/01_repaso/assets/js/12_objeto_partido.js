// EquipoLocal, EquipoVisitante, GolesLocales, GolesVisitante, AlineacionLocal, AlineacionVisitante
class Partido {
  equipoLocal;
  equipoVisitante;
  golesLocal;
  golesVisitante;

  constructor(local, golesLocal, visitante, visitante) {
    this.equipoLocal = local;
    this.golesLocal = golesLocal;
    this.equipoVisitante = visitante;
    this.golesVisitante = visitante;
  }

  mostrarDatos() {
    console.log(
      `${this.equipoLocal}: ${this.golesLocal} vs ${this.equipoVisitante}: ${this.golesVisitante}`
    );
  }
}
