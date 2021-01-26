import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Customer } from '../entities';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-customer',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.scss']
})

export class CustomerComponent implements OnInit {
  title = 'Kaufhaus';
  public customers: Customer[] = [];
  public formCustomer: Customer = {} as Customer;
  public actCustomer = "";
  public color: string = 'darkgrey';

  constructor(private customerService: CustomerService) { }
  public selectCustomer(Customer: Customer): void {
    this.formCustomer = Customer;
  }

  ngOnInit() {
    this.load();
    this.clearCustomer();
  }

  load() {
    this.customerService.getData().subscribe(data => { this.customers=data });
    //this.customers = this.customerService.getData().pipe(map(data=>data));
  }

  public deleteCustomer(customer: Customer, index: number) {
    this.customers.splice(index, 1);
    console.log(customer.id)
    this.customerService.delete(customer.id).subscribe(res=>{window.location.reload();});
  }

  public addCustomer() {
    this.customers.push(this.formCustomer);
    if (this.formCustomer.id != 0) {
      this.customerService.update(this.formCustomer).subscribe(res=>{this.load()});
      this.formCustomer.id = 0;
    }
    else {
      let id = Math.max.apply(Math, this.customers.map((o: Customer) => o.id));
      this.formCustomer.id = id + 1;
      this.customerService.create(this.formCustomer).subscribe(res=>{this.load()});
    }
    window.location.reload();
  }

  getColor(customer: string): string {
    if (customer == this.actCustomer)
      return this.color;
  }

  public clearCustomer() {
    this.formCustomer = {
      id: 0,
      firstName: '',
      lastName: '',
      dateOfBirth: new Date(),
      address: '',
      zipCode: 0
    }
  }
}
