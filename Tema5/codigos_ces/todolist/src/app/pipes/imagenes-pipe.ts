import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenes',
  standalone: false,
})
export class ImagenesPipe implements PipeTransform {
  transform(value: number, ...args: unknown[]): string {
    switch (value) {
      case 1:
        return 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSALhRXZWLqbz0CjyoiAAsWWPLEnCrUY114Bw&s';

      case 2:
        return 'https://img.icons8.com/color/1200/medium-priority.jpg';
      case 3:
        return 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnKYoeK-Qo2xTgTYITWqLbmriXi-QhhjVA-Q&s';
    }

    return 'https://t4.ftcdn.net/jpg/16/71/95/89/360_F_1671958984_wi1gDwRJ4UgT0tpjmp6BpHujKzbaAGI7.jpg';
  }
}
