// clase

class ClaseEjemplo {
  // variables
  propiedadUno;
  propiedadDos;
  propiedadTres;

  /* constructor(propiedadUno, propiedadDos) {
        this.propiedadUno = propiedadUno;
        this.propiedadDos = propiedadDos;
        this.propiedadTres = []} */

  // constructores
  constructor(propiedadUno, propiedadDos, propiedadTres) {
    this.propiedadUno = propiedadUno;
    this.propiedadDos = propiedadDos;
    this.propiedadTres = propiedadTres;
  }

  mostrarDatos() {
    console.log(`Propiedad uno: ${this.propiedadUno}`);
    console.log(`Propiedad dos: ${this.propiedadDos}`);
    this.propiedadTres.forEach((element) => {
      console.log(element);
    });
  }

  // tener un metodo que permita agregar cosas a la propiedad tres
  agregarDatos(param1) {
    //if (!isNaN(param1)) {
    this.propiedadTres.push(param1);
    //}
  }

  // funciones
  set setPropiedadUno(param) {
    this.propiedadUno = param;
  }

  get getPropiedadUno() {
    return this.propiedadUno;
  }
}

/* let ejemploObjeto = new ClaseEjemplo("Propiedad uno", "Propiedad dos", [
  "param1",
  "param2",
]); */
//ejemploObjeto.agregarDatos(parseInt(Math.random() * 20));
//ejemploObjeto.agregarDatos("Ejemplo de cosa");
//ejemploObjeto.agregarDatos(true);
//ejemploObjeto.setPropiedadUno("Cambiada");

/*ejemploObjeto.setPropiedadUno = "Cambiada";
console.log(ejemploObjeto.getPropiedadUno);

ejemploObjeto.mostrarDatos();*/
