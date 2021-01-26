export interface Customer {
    id:number,
    address:string,
    dateOfBirth:Date,
    firstName:string,
    lastName:string,
    zipCode:number
}

export interface Delivery {
    id:number,
    count:number,
    date:Date,
    warehouseId:number,
    productId:number
}

export interface Store {
    id:number,
    name:string,    
}

export interface Bill {
    billId:number,
    customerId:number,
    storeId:number,
    date:Date,
    productId:number
}

export interface Employee {
    id:number,
    firstName:string,
    lastName:string,
    dateOfBirth:Date,
    salary:number
}

export interface Product {
    id:number,
    name:string,
    price:number
}