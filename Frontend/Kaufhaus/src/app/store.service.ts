import { Injectable } from '@angular/core';
import { HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { ApiService } from './api.service';
import { Store } from './entities';
import { map } from 'rxjs/operators';

@Injectable()
export class StoreService {
  constructor (
    private apiService: ApiService
  ) {}

  getData(){
    return this.apiService.get('http://127.0.0.1:3001/api/Store/getStores').pipe(map(data=>data))
  }

  create(store : Store) {
    let body = {
        name: store.name
    }
    console.log(body);
    return this.apiService.post('http://127.0.0.1:3001/api/Store/addStore', body).pipe(map(data=>data))
  }
  update(store : Store) {
    let body = {
        name: store.name
    }
    return this.apiService.put('http://127.0.0.1:3001/api/Store/update/'+ store.id, body).pipe(map(data=>data))
  }

  delete(id : number){
    return this.apiService.delete('http://127.0.0.1:3001/api/Store/'+ id +'/deleteStore').pipe(map(data=>data))
  }
}