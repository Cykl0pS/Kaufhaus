import { Injectable } from '@angular/core';
import { HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { ApiService } from './api.service';
import { Bill } from './entities';
import { map } from 'rxjs/operators';

@Injectable()
export class BillService {
  constructor (
    private apiService: ApiService
  ) {}

  getData(){
    return this.apiService.get('http://127.0.0.1:3001/api/bill/getBill').pipe(map(data=>data))
  }

  create(bill : Bill) {
    let body = {
        customerId:bill.customerId,
        storeId:bill.storeId,
        date:new Date(bill.date).toISOString().replace('T',' ').replace('Z','').split(' ')[0],
        productId:bill.productId
    }
    console.log(body);
    return this.apiService.post('http://127.0.0.1:3001/api/bill/addBill', body).pipe(map(data=>data))
  }
  update(bill : Bill) {
    let body = {
        customerId:bill.customerId,
        storeId:bill.storeId,
        date:new Date(bill.date).toISOString().replace('T',' ').replace('Z','').split(' ')[0],
        productId:bill.productId
    }
    return this.apiService.put('http://127.0.0.1:3001/api/classes/update/'+ bill.billId, body).pipe(map(data=>data))
  }
}