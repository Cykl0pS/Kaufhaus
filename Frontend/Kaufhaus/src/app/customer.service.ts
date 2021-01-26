import { Injectable } from '@angular/core';
import { HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { ApiService } from './api.service';
import { Customer } from './entities';
import { map } from 'rxjs/operators';

@Injectable()
export class CustomerService {
  constructor (
    private apiService: ApiService
  ) {}

  getData(){
    return this.apiService.get('http://127.0.0.1:3001/api/customer/getCustomers').pipe(map(data=>data))
  }

  create(customer : Customer) {
    let body = {
        dateOfBirth:new Date(customer.dateOfBirth).toISOString().replace('T',' ').replace('Z','').split(' ')[0],
        firstName:customer.firstName,
        lastName:customer.lastName,
        address:customer.address,
        zipCode:customer.zipCode
    }
    console.log(body);
    return this.apiService.post('http://127.0.0.1:3001/api/customer/addCustomer', body).pipe(map(data=>data))
  }
  update(customer : Customer) {
    let body = {
        firstName:customer.firstName,
        lastName:customer.lastName,
        dateOfBirth:customer.dateOfBirth,
        address:customer.address,
        zipCode:customer.zipCode
    }
    return this.apiService.put('http://127.0.0.1:3001/api/customer/'+ customer.id + '/updateCustomer', body).pipe(map(data=>data))
  }

  delete(id : number){
    return this.apiService.delete('http://127.0.0.1:3001/api/customer/'+ id + '/deleteCustomer').pipe(map(data=>data))
  }
}