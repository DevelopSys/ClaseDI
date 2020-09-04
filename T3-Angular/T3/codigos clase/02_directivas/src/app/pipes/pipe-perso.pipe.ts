import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pipePerso',
})
export class PipePersoPipe implements PipeTransform {
  transform(value: unknown, ...args: unknown[]): unknown {
    if (!value) {
      return 'assets/images/ciudad.jpg';
    } else {
      return value;
    }
  }
}
