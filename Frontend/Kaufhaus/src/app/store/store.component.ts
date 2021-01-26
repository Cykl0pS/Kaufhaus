import { Component, OnInit } from '@angular/core';
import { StoreService } from '../store.service';
import { Store } from '../entities';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.scss']
})

export class StoreComponent implements OnInit {
  title = 'Kaufhaus';
  public stores: Store[] = [];
  public formStore: Store = {} as Store;
  public actStore = "";
  public color: string = 'darkgrey';

  constructor(private storeService: StoreService) { }
  public selectStore(Store: Store): void {
    this.formStore = Store;
  }

  ngOnInit() {
    this.load();
    this.clearStore();
  }

  load() {
    this.storeService.getData().subscribe(data => { this.stores=data });

  }

  public deleteStore(store: Store, index: number) {
    this.stores.splice(index, 1);
    console.log(store.id)
    this.storeService.delete(store.id).subscribe(res=>{window.location.reload();});
  }

  public addStore() {
    this.stores.push(this.formStore);
    if (this.formStore.id != 0) {
      this.storeService.update(this.formStore).subscribe(res=>{this.load()});
      this.formStore.id = 0;
    }
    else {
      let id = Math.max.apply(Math, this.stores.map((o: Store) => o.id));
      this.formStore.id = id + 1;
      this.storeService.create(this.formStore).subscribe(res=>{this.load()});
    }
    window.location.reload();
  }

  getColor(store: string): string {
    if (store == this.actStore)
      return this.color;
  }

  public clearStore() {
    this.formStore = {
      id: 0,
      name:""
    }
  }
}
