import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { CommonModule } from '@angular/common';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './customers/customers.component';
import { CustomerService } from './customer.service';
import { DeliveryService } from './delivery.service';
import { StoreService } from './store.service';
import { BillService } from './bill.service';
import { EmployeeService } from './employee.service';
import { ProductService } from './product.service';
import { ApiService } from './api.service';
import { DeliveryComponent } from './delivery/delivery.component';
import { BillComponent } from './bill/bill.component';
import { EmployeeComponent } from './employee/employee.component';
import { StoreComponent } from './store/store.component';
import { ProductComponent } from './product/product.component';
 
@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    DeliveryComponent,
    BillComponent,
    EmployeeComponent,
    StoreComponent,
    ProductComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([])
  ],
  providers: [ApiService, CustomerService, DeliveryService, StoreService, BillService, EmployeeService, ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
