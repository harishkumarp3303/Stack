import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'titlecase',
  
})
export class TitlecasePipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): unknown {

    let x:string =value.toLowerCase().charAt(0).toUpperCase() + value.toLowerCase().slice(1);
    
    return x;
  }

}
