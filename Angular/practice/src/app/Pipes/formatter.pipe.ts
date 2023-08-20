import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'formatter'
})
export class FormatterPipe implements PipeTransform {

  transform(value: string, ...args: string[]): unknown {
    // console.log(value)
    // console.log(args)
    if(args[0]=='uppercase'){
      return value.toUpperCase();
    }else{
      return value.toLowerCase();
    }
    return null;
  }

}
