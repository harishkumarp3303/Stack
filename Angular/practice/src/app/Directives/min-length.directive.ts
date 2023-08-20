import { Directive, Input } from '@angular/core';
import { NG_VALIDATORS, Validator, AbstractControl, ValidationErrors } from '@angular/forms';

@Directive({
  selector: '[appMinLength][ngModel]',
  providers: [
    { provide: NG_VALIDATORS, useExisting: MinLengthDirective, multi: true }
  ]
})
export class MinLengthDirective implements Validator {
  @Input() appMinLength: number =0;

  validate(control: AbstractControl): ValidationErrors | null {
    const value: string = control.value;
    if (value && value.length < this.appMinLength) {
      return { 'appMinLength': true };
    }
    return null;
  }
}
