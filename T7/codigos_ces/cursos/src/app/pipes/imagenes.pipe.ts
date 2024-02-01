import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenes',
})
export class ImagenesPipe implements PipeTransform {
  transform(value: string, ...args: unknown[]): unknown {
    if (value.length > 0) {
      return value;
    } else {
      return 'https://www.shutterstock.com/image-vector/colorful-icon-set-education-school-260nw-1796576092.jpg';
    }
  }
}
