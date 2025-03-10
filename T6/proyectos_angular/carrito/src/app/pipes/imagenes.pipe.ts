import { Pipe, PipeTransform } from '@angular/core';
import { Producto } from '../model/clases';

@Pipe({
  name: 'imagenes',
  standalone: false,
})
export class ImagenesPipe implements PipeTransform {
  transform(value: Producto, ...args: unknown[]): string {
    switch (value.categoria) {
      case 'pescado':
        return 'https://esenciadelmar.es/wp-content/uploads/2023/08/formas-cocinar-pescado-1200x700.jpg';

      case 'lacteo':
        return 'https://media.istockphoto.com/id/544807136/es/foto/varios-productos-lácteos-frescos.jpg?s=612x612&w=0&k=20&c=WOsMuZpOo9VNgH6vN1gW4dGdgazGDWX1fDqr-bBezxc=';

      case 'vegetal':
        return 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEDKwH_K9SV-IJAOhIRMFR9JYPzsgExSdK_Q&s';

      case 'carne':
        return 'https://media.gettyimages.com/id/132020365/es/foto/bistec-aislado-en-blanco.jpg?s=612x612&w=gi&k=20&c=HA6jlOwxPh7ep1q9_aJ0ooAxhgrOSLzQZxhpGWD3lLs=';

      default:
        return 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrm45IT7TPDizgfnHZXQPDqLqTyIxJBt0D4Q&s';
    }
  }
}
