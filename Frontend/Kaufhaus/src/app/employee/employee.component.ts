import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../entities';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})

export class EmployeeComponent implements OnInit {
  public employees: Employee[] = [];
  public formEmployee: Employee = {} as Employee;
  public actEmployee = "";
  public color: string = 'darkgrey';

  constructor(private employeeService: EmployeeService) { }
  public selectEmployee(Employee: Employee): void {
    this.formEmployee = Employee;
  }

  ngOnInit() {
    this.load();
    this.clearEmployee();
  }

  load() {
    this.employeeService.getData().subscribe(data => { this.employees=data });

  }

  public deleteEmployee(employee: Employee, index: number) {
    this.employees.splice(index, 1);
    console.log(employee.id)
    this.employeeService.delete(employee.id).subscribe(res=>{window.location.reload();});
  }

  public addEmployee() {
    this.employees.push(this.formEmployee);
    if (this.formEmployee.id != 0) {
      this.employeeService.update(this.formEmployee).subscribe(res=>{this.load()});
      this.formEmployee.id = 0;
    }
    else {
      let id = Math.max.apply(Math, this.employees.map((o: Employee) => o.id));
      this.formEmployee.id = id + 1;
      this.employeeService.create(this.formEmployee).subscribe(res=>{this.load()});
    }
    window.location.reload();
  }

  public updateSalary() {
    this.employeeService.update(this.formEmployee).subscribe(res=>{this.load()});
    this.formEmployee.id = 0;
  }

  getColor(clazz: string): string {
    if (clazz == this.actEmployee)
      return this.color;
  }

  public clearEmployee() {
    this.formEmployee = {
    id: 0,
    firstName: '',
    lastName:'',
    dateOfBirth:new Date,
    salary: 0 
        } 
    }
}