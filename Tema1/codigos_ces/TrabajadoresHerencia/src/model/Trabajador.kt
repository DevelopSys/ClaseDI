package model


// Trabajador() : Persona(), Junta
class Trabajador(
    nombre: String, apellido: String, dni: String,
    var salario: Int, var nPagas: Int
) : Persona(nombre, apellido, dni) {

    // nombre, apellido, dni, SALARIO,NPAGAS
    // telefono, email, SEGURO
    var seguro: Boolean = false;

    constructor(
        nombre: String, apellido: String, dni: String,
        salario: Int, nPagas: Int,seguro: Boolean, telefono: Int, correo: String,
    ) : this(nombre, apellido, dni, salario, nPagas) {
        this.seguro = seguro;
        this.telefono = telefono
        this.correoE = correo
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario : $salario")
        println("Pagas : $nPagas")
        println("Seguro : $seguro")
    }

}