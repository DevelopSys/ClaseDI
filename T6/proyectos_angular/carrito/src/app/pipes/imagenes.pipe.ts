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
        return 'null';
        break;

      case 'lacteo':
        return 'null';
        break;
      case 'vegetal':
        return 'null';
        break;
      case 'carne':
        return 'null';
        break;

      default:
        return 'null';
        break;
    }
  }
}
