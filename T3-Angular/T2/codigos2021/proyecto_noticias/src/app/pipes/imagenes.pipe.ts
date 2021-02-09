import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenes'
})
export class ImagenesPipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): string {
    

    if (value.length > 0){
      return value
    }

    
    return 'assets/images/news_photo.jpg';
  }

}
