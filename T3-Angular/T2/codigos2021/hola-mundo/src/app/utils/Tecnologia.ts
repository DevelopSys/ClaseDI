export class Tecnologia {
    nombre: string;
    descricion: string ;
    imagen: string;

    constructor(nombre: string, descripcion: string, imagen: string) {
        this.descricion = descripcion;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    get getNombre(){
        return this.nombre
    }

    set setNombre(nombre:string){
        this.nombre = nombre;
    }
}
