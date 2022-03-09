import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagen',
})
export class ImagenPipe implements PipeTransform {
  transform(value: string, ...args: unknown[]): unknown {
    if (value.length > 0) {
      return value;
    }
    return '../../assets/images/defecto.jpg';
  }
}
