import { Component, DoCheck, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Person } from 'src/app/HttpnObservables/HttpService.service';
import { Product } from '../product/product.component';

@Component({
  selector: 'app-productdetail',
  templateUrl: './productdetail.component.html',
  styleUrls: ['./productdetail.component.css']
})
export class ProductdetailComponent implements OnInit,DoCheck{
  constructor(private aroute: ActivatedRoute) { }
  ngDoCheck(): void {
    // this.product.id=this.aroute.snapshot.params['id']
    // this.product.name=this.aroute.snapshot.params['name']
    // this.product.price=this.aroute.snapshot.params['price']
  }

  product:Product ={
    id:0,
    name:'',
    price:0,
  }
  queryparamers:any
  fragments:any
  ngOnInit(): void {
    //  Retrieving Route Parameters
    this.product.id=this.aroute.snapshot.params['id']
    this.product.name=this.aroute.snapshot.params['name']
    this.product.price=this.aroute.snapshot.params['price']

    // Another Way of Retrieving Route Parameters using subscribe
    // Subscribing to Route Parameters
    this.aroute.params.subscribe((data:Params)=>{

      this.product.id=data['id']
      this.product.name=data['name']
      this.product.price=data['price']
      console.log(data)
      console.log(this.product)
      console.log(this.product.id)
      console.log(this.product.name)
      console.log(this.product.price)


    
    })

    // Retrieving Query Parameters
    this.queryparamers=this.aroute.snapshot.queryParams
    this.fragments=this.aroute.snapshot.fragment
  }

}
