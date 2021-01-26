import { Injectable } from '@angular/core';
import { HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { ApiService } from './api.service';
import { Product } from './entities';
import { map } from 'rxjs/operators';

@Injectable()
export class ProductService {
  constructor (
    private apiService: ApiService
  ) {}

  getData(){
    return this.apiService.get('http://127.0.0.1:3001/api/product/getProducts').pipe(map(data=>data))
  }

  create(product : Product) {
    let body = {
        name: product.name,
        price: product.price
    }
    console.log(body);
    return this.apiService.post('http://127.0.0.1:3001/api/product/addProduct', body).pipe(map(data=>data))
  }
  update(product : Product) {
    let body = {
        name: product.name,
        price: product.price
    }
    return this.apiService.put('http://127.0.0.1:3001/api/product/update/'+ product.id, body).pipe(map(data=>data))
  }

  delete(id : number){
    return this.apiService.delete('http://127.0.0.1:3001/api/product/'+ id +'/deleteProduct').pipe(map(data=>data))
  }
}