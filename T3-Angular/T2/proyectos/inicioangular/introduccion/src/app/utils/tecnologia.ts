export class Tecnologia {

    private titulo: string;
    private descripcion: string;
    private imagen: string;

    constructor(titulo: string, descripcion: string, imagen: string) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    getTitulo(): string {
        return this.titulo;
    }

    getImagen(): string {
        return this.imagen;
    }

    getDescripcion(): string {
        return this.descripcion;
    }
}