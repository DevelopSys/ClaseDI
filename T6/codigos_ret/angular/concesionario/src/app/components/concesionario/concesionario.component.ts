import { Component } from '@angular/core';
import { Coche } from '../../model/coche';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-concesionario',
  templateUrl: './concesionario.component.html',
  styleUrl: './concesionario.component.css',
})
export class ConcesionarioComponent {

  marcaBuscar: string = ""
  precioBuscar: string = ""
  marca: string = '';
  modelo: string = '';
  matricula: string = '';
  cv: number = 0;
  cc: number = 0;
  precio: number = 0;
  motor: string = '';
  titulo = "Formulario de búsqueda"
  imagenDefecto = "https://img.freepik.com/psd-premium/coche-moderno-sobre-fondo-transparente-representacion-3d-ilustracion_494250-31500.jpg"

  coches: Coche[] = [];
  cochesFiltrados: Coche[] = [];

  cambioAccesiorio(accesorio: string) {
    console.log(accesorio);
    
    }

  realizarBusqueda(){
    
    let filtro: Coche[] = this.coches.filter((element: Coche)=>{
      return element.getMarca == this.marcaBuscar && element.getPrecio 
      >= Number(this.precioBuscar)
   })

   Swal.fire({
    position: 'center',
    icon: 'success',
    title: `El numero de resultados obtenidos es de ${filtro.length}`,
    showConfirmButton: false,
    timer: 1500,
  });

    this.cochesFiltrados =  filtro;
  }

  agregarCoche() {
    if (
      this.marca.length > 0 &&
      this.modelo.length > 0 &&
      this.matricula.length > 0 &&
      this.precio > 0 &&
      this.cc > 0 &&
      this.cc > 0
    ) {
      this.coches.push(
        new Coche(
          this.marca,
          this.modelo,
          this.matricula,
          this.cv,
          this.cc,
          this.precio,
          this.motor
        )
      );

      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Coche añadido con exito',
        showConfirmButton: false,
        timer: 1500,
      });

      this.limpiarDatos();
    } else {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'No hay datos suficientes',
      });
    }
  }
  limpiarDatos() {
    this.marca = '';
    this.modelo = '';
    this.matricula = '';
    this.cc = 0;
    this.cv = 0;
    this.precio = 0;
    this.motor = '';
  }

}


/* Modificar el comportamiendo del formulario para
- al añadir un coche, se puede añadir accesorios. Para ello, seleccionar el accesorio
en un select y darle al boton add accesorio (se indicará el nº de accesorios del coche)
- En el caso de agregar un accesorio que ya tenga el coche, saltará un aviso
- En la lista de filtro, aparecerá una carta por cada resultado, donde además de los fatos anteriores
se agergará una lista con sus accesorios
- En el caso de tener 5 accesorios su precio se incrementa en 1000€
- En la carta, el precio aparecerá con un simbolo de € (utilizar el pipe currency)

*/