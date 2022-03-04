import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'personalizado',
})
export class PersonalizadoPipe implements PipeTransform {
  transform(value: string, ...args: unknown[]): unknown {
    switch (value.toLowerCase()) {
      case 'js':
        if (args[0] === 2) {
          value = 'webs dinámicas especiales';
        } else {
          value = 'webs dinámicas normales';
        }
        break;
      case 'html':
        value = 'web estáticas';
        break;
      default:
        value = 'tecnologia desconocida';
        break;
    }

    return value;
  }
}
