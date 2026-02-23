import { Pipe, PipeTransform } from '@angular/core';
import { Tarea } from '../model/tarea';

@Pipe({
  name: 'imagenes',
})
export class ImagenesPipe implements PipeTransform {
  transform(value: number, ...args: unknown[]): string {
    switch (value) {
      case 1:
        return 'https://img.icons8.com/color/1200/low-priority.jpg';
      case 2:
        return 'https://img.icons8.com/color/1200/medium-priority.jpg';
      case 3:
        return 'https://www.svgrepo.com/show/474865/high-priority.svg';
      default:
        return 'null';
    }
  }
}
