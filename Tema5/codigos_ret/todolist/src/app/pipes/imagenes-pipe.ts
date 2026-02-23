import { Pipe, PipeTransform } from '@angular/core';
import { Tarea } from '../model/tarea';

@Pipe({
  name: 'imagenes',
})
export class ImagenesPipe implements PipeTransform {
  transform(value: Tarea, ...args: unknown[]): unknown {
    return null;
  }
}
