import { Injectable } from '@angular/core';
import { HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { ApiService } from './api.service';
import { Employee } from './entities';
import { map } from 'rxjs/operators';

@Injectable()
export class EmployeeService {
  constructor (
    private apiService: ApiService
  ) {}

  getData(){
    return this.apiService.get('http://127.0.0.1:3001/api/employee/getEmployees').pipe(map(data=>data))
  }

  create(employee : Employee) {
    let body = {
        firstName:employee.firstName,
        lastName:employee.lastName,
        dateOfBirth:new Date(employee.dateOfBirth).toISOString().replace('T',' ').replace('Z','').split(' ')[0],
        salary: employee.salary
    }
    console.log(body);
    return this.apiService.post('http://127.0.0.1:3001/api/employee/addEmployee', body).pipe(map(data=>data))
  }
  update(employee : Employee) {
    let body = {
        firstName:employee.firstName,
        lastName:employee.lastName,
        dateOfBirth:new Date(employee.dateOfBirth).toISOString().replace('T',' ').replace('Z','').split(' ')[0],
        salary: employee.salary
    }
    return this.apiService.put('http://127.0.0.1:3001/api/employee/'+ employee.id + '/updateSalary', body).pipe(map(data=>data))
  }
  delete(id : number){
    return this.apiService.delete('http://127.0.0.1:3001/api/employee/'+ id +'/deleteEmployee').pipe(map(data=>data))
  }
}