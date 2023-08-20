import { Component } from '@angular/core';
import { Router } from '@angular/router';

export interface Product{
  id:number;
  name:string;
  price:number;
}

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {

  constructor(private route:Router){

  }

  products:Product ={
    id:1,
    name:'Iphone',
    price:12000
  }

  productdetail(pid:any,pname:any,pprice:any){

    this.route.navigateByUrl('/router/productdetail/'+pid+'/'+pname+'/'+pprice);

    // this.route.navigate(['router/productdetail']);
  }

  productdetailwithqueryparams(pid:any,pname:any,pprice:any){

    this.route.navigate(['router/productdetail',pid,pname,pprice],{queryParams:{page:1,sort:'asc',search:'iphone'},fragment:'load'});
  
  }
}
