import { Pipe, PipeTransform } from '@angular/core';
import { Post } from '../model/interfeces';

@Pipe({
  name: 'imagenes',
  standalone: false,
})
export class ImagenesPipe implements PipeTransform {
  transform(value: Post, ...args: string[]): string {
    if (
      value.tags.find((item) => {
        return item == 'magical';
      }) != undefined
    ) {
      return 'https://m.media-amazon.com/images/I/71TetpMWhpL._AC_UF894,1000_QL80_.jpg';
    } else if (
      value.tags.find((item) => {
        return item == 'crime';
      }) != undefined
    ) {
      return 'https://www.shutterstock.com/shutterstock/photos/2238349149/display_1500/stock-photo-magnifier-fingerprint-blood-drops-microscope-map-and-police-form-vintage-background-on-the-2238349149.jpg';
    } else if (
      value.tags.find((item) => {
        return item == 'mystery';
      }) != undefined
    ) {
      return 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCAZNz3aVbWkURecR5C2p9zrQrkYTbG6JC4g&s';
    } else {
      return 'https://i.pinimg.com/736x/65/92/50/6592501b8e2b4a0afc21c73b30426e5e.jpg';
    }
  }
}

// magical
// crime
// english
// mystery
// resto
