import { Injectable } from '@angular/core';
import { IProduct } from '../interfaces/product.interface';

@Injectable({
  providedIn: 'root'
})
export class BasketService {

  constructor() { }

  get orders(): IProduct[] {
    return JSON.parse(localStorage.getItem('orders') || '[]');
  }

  addToBasket(product: IProduct): void {
    console.log(product);
    console.log(this.orders);
    if (this.orders.length) {
      if (this.orders.some((o) => o.id === product.id)) {
        const order = this.orders.find((o) => o.id === product.id);
        if (order) {
          order.count += product.count;
          localStorage.setItem(
            'orders',
            JSON.stringify([
              ...this.orders.map((o) => o.id === order.id ? order : o),
            ])
          );
        }
      } else {
        localStorage.setItem(
          'orders',
          JSON.stringify([...this.orders, product])
        );
      }
    } else {
      localStorage.setItem('orders', JSON.stringify([product]));
    }
  }
}
