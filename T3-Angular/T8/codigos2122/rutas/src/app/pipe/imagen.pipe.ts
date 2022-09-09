import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagen'
})
export class ImagenPipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): unknown {

    if (value.includes('dam')){
      return "https://previews.123rf.com/images/binaryproject/binaryproject1510/binaryproject151000013/46909438-code-de-programmation-du-programme-plateforme-multi-apps-site-sensible.jpg"

    } else if(value.includes('daw')){
      return "https://indexdesarrollo.com/wp-content/uploads/2017/11/aprender-programacion-web.jpg"
    }

    return "https://www.mailjet.com/wp-content/uploads/2019/11/big-data-definition.jpeg";
  }

}
