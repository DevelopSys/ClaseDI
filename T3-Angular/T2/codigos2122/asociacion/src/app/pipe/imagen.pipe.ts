import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagen'
})
export class ImagenPipe implements PipeTransform {

  transform(value: any, ...args: unknown[]): unknown {

    // ejecuto la transformacion y te retorno un valor
    if (value.length == 0){
      return "https://media.istockphoto.com/vectors/kids-learn-coding-on-laptops-in-school-vector-id1093952582?s=170667a"
    } else {
      return value;
    }
  }

}
