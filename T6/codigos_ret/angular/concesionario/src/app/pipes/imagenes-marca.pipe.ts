import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenesMarca'
})
export class ImagenesMarcaPipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): unknown {
    switch (value.toLowerCase()) {
      case "ford":
        return "https://c0.klipartz.com/pngpicture/354/87/gratis-png-ford-logo-ford-motor-company-car-ford-ikon-ford-f-series-ford-logo-thumbnail.png";
        break;
    
        case "audi":
          return "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/Audi_logo_detail.svg/288px-Audi_logo_detail.svg.png";
        break;

        case "peugeot":
          return "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Peugeot_Logo.svg/320px-Peugeot_Logo.svg.png";
        break;
      default:

      return "https://images.vexels.com/media/users/3/145585/isolated/preview/0cc4204c88694175095d6bda24efb714-vista-lateral-del-coche-de-la-ciudad.png";
        break;
    }
    
    
  }

}
