import { Component, Injectable, OnInit } from '@angular/core';
import { DeliveryService } from '../delivery.service';
import { Delivery } from '../entities';

@Component({
  selector: 'app-delivery',
  templateUrl: './delivery.component.html',
  styleUrls: ['./delivery.component.scss']
})

export class DeliveryComponent implements OnInit {
  public deliveries: Delivery[] = [];
  public formDelivery: Delivery = {} as Delivery;
  public actDelivery = "";
  public color: string = 'darkgrey';

  constructor(private deliveryService: DeliveryService) { }
  public selectDelivery(Delivery: Delivery): void {
    this.formDelivery = Delivery;
  }

  ngOnInit() {
    this.load();
    this.clearDelivery();
  }

  load() {
    this.deliveryService.getData().subscribe(data => this.deliveries = data);
  }

  public addDelivery() {
    console.dir(this.deliveries);
    this.deliveries.push();
    if (this.formDelivery.id != 0) {
      this.deliveryService.update(this.formDelivery).subscribe(res=>{this.load()});
      this.formDelivery.id = 0;
    }
    else {
      let id = Math.max.apply(Math, this.deliveries.map((o: Delivery) => o.id));
      this.formDelivery.id = id + 1;
      this.deliveryService.create(this.formDelivery).subscribe(res=>{this.load()});
    }
    window.location.reload();
  }

  getColor(delivery: string): string {
    if (delivery == this.actDelivery)
      return this.color;
  }

  public clearDelivery() {
    this.formDelivery = {
        id:0,
        count:0,
        date:new Date(),
        warehouseId:0,
        productId:0
    }
  }
}