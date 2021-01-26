import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../entities';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})

export class ProductComponent implements OnInit {
  title = 'Kaufhaus';
  public products: Product[] = [];
  public formProduct: Product = {} as Product;
  public actProduct = "";
  public color: string = 'darkgrey';

  constructor(private productService: ProductService) { }
  public selectProduct(Product: Product): void {
    this.formProduct = Product;
  }

  ngOnInit() {
    this.load();
    this.clearProduct();
  }

  load() {
    this.productService.getData().subscribe(data => { this.products=data });

  }

  public deleteProduct(Product: Product, index: number) {
    this.products.splice(index, 1);
    console.log(Product.id)
    this.productService.delete(Product.id).subscribe(res=>{window.location.reload();});
  }

  public addProduct() {
    this.products.push(this.formProduct);
    if (this.formProduct.id != 0) {
      this.productService.update(this.formProduct).subscribe(res=>{this.load()});
      this.formProduct.id = 0;
    }
    else {
      let id = Math.max.apply(Math, this.products.map((o: Product) => o.id));
      this.formProduct.id = id + 1;
      this.productService.create(this.formProduct).subscribe(res=>{this.load()});
    }
    window.location.reload();
  }

  getColor(Product: string): string {
    if (Product == this.actProduct)
      return this.color;
  }

  public clearProduct() {
    this.formProduct = {
      id: 0,
      name:"",
      price:0
    }
  }
}
