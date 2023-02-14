var alumno = /** @class */ (function () {
    function alumno(nombre, apellido, dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    alumno.prototype.mostrarDatos = function () {
        console.log("Nombre: ".concat(this.nombre));
        console.log("Apellido: ".concat(this.apellido));
        console.log("DNI: ".concat(this.dni));
    };
    Object.defineProperty(alumno.prototype, "getNombre", {
        get: function () {
            return this.nombre;
        },
        enumerable: false,
        configurable: true
    });
    return alumno;
}());
var alumnoObjeto = new alumno("Borja", "Martin", "123123A");
var alumnoIntefaz = {
    nombre: "Borja",
    apellido: "Martin",
    dni: "123123A"
};
var alumnos = [];
alumnos.push(alumnoObjeto);
//alumnoObjeto.mostrarDatos();
//console.log(alumnoObjeto.getNombre);
var nombre = "asd";
var edad;
var experiencia;
var asignaturas;
console.log("El valor del nombre es: ".concat(nombre));
function sumar(param1, param2) {
    console.log("La suma de ".concat(param1, " y ").concat(param2, " es ").concat(param1 + param1));
}
function parametrosOptativos(param1, param2, param3) {
    if (param3 === void 0) { param3 = 0; }
    console.log("los paramentros son ".concat(param1, "  ").concat(param2, "  ").concat(param3));
}
function funcionParamentrosMulti(param1, param2) {
    var param = [];
    for (var _i = 2; _i < arguments.length; _i++) {
        param[_i - 2] = arguments[_i];
    }
    console.log("los paramentros son ".concat(param1, "  ").concat(param2));
    param.length > 0 &&
        param.forEach(function (element) {
            console.log(element);
        });
}
//sumar(3, 4);
//parametrosOptativos("uno", "dos");
//parametrosOptativos("uno", "dos", 8);
funcionParamentrosMulti("uno", 2);
funcionParamentrosMulti("uno", 2, 4, 5, 6, 7, 8, 9, 234, 234, 234, 2, false, true, "hola");
