import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenes',
})
export class ImagenesPipe implements PipeTransform {
  transform(value: string, ...args: unknown[]): string {
    let imagen = '';
    value.length > 0
      ? (imagen = value)
      : (imagen =
          'https://marketplace.canva.com/EAFrDm3ydqw/1/0/1600w/canva-presentaci%C3%B3n-noticias-telediario-corporativo-azul-rojo-Vh4S5Wt7FD4.jpg');
    return imagen;
  }
}
