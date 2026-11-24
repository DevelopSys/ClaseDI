import { KeyValuePipe } from '@angular/common';
import { Component, Input } from '@angular/core';
import { AbstractControl, ValidationErrors } from '@angular/forms';
import { getGlobalErrorMessage } from 'app/common/error-handler.injectable';


@Component({
  selector: 'app-input-errors',
  templateUrl: './input-errors.component.html',
  imports: [KeyValuePipe]
})
export class InputErrorsComponent {

  @Input()
  errors?: ValidationErrors|null;

  @Input()
  showErrors = false;

  isString(value: any): boolean {
    return typeof value === 'string';
  }

  getMessage(key: string, details?: any) {
    const globalErrorMessage = getGlobalErrorMessage(key, details);
    return globalErrorMessage || key;
  }

}
