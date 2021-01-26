import { Component, OnInit } from '@angular/core';
import { BillService } from '../bill.service';
import { Bill } from '../entities';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.scss']
})

export class BillComponent implements OnInit {
  public bills: Bill[] = [];
  public formBill: Bill = {} as Bill;
  public actBill = "";
  public color: string = 'darkgrey';

  constructor(private billService: BillService) { }
  public selectBill(Bill: Bill): void {
    this.formBill = Bill;
  }

  ngOnInit() {
    this.load();
    this.clearBill();
  }

  load() {
    this.billService.getData().subscribe(data => { this.bills=data });
    //this.customers = this.customerService.getData().pipe(map(data=>data));
  }

  public addBill() {
    this.bills.push(this.formBill);
    if (this.formBill.billId != 0) {
      this.billService.update(this.formBill).subscribe(res=>{this.load()});
      this.formBill.billId = 0;
    }
    else {
      let id = Math.max.apply(Math, this.bills.map((o: Bill) => o.billId));
      this.formBill.billId = id + 1;
      this.billService.create(this.formBill).subscribe(res=>{this.load()});
    }
    window.location.reload();
  }

  getColor(bill: string): string {
    if (bill == this.actBill)
      return this.color;
  }

  public clearBill() {
    this.formBill = {
      billId:0,
      customerId:0,
      storeId:0,
      date:new Date(),
      productId:0
    }
  }
}
