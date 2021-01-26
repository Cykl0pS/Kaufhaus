import { Injectable } from '@angular/core';
import { HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { ApiService } from './api.service';
import { Delivery } from './entities';
import { map } from 'rxjs/operators';

@Injectable()
export class DeliveryService {
  constructor (
    private apiService: ApiService
  ) {}

  getData(){
    return this.apiService.get('http://127.0.0.1:3001/api/delivery/getDeliveries').pipe(map(data=>data))
  }

  create(delivery : Delivery) {
    let body = {
        count:delivery.count,
        date:new Date(delivery.date).toISOString().replace('T',' ').replace('Z','').split(' ')[0],                               
        warehouseId:delivery.warehouseId,
        productId:delivery.productId
    }
    return this.apiService.post('http://127.0.0.1:3001/api/delivery/addDelivery', body).pipe(map(data=>data))
  }
  update(delivery : Delivery) {
    let body = {
        count:delivery.count,
        date:new Date(delivery.date).toISOString().replace('T',' ').replace('Z','').split(' ')[0],                               
        warehouseId:delivery.warehouseId,
        productId:delivery.productId
    }
    return this.apiService.put('http://127.0.0.1:3001/api/delivery/update/'+ delivery.id, body).pipe(map(data=>data))
  }
}