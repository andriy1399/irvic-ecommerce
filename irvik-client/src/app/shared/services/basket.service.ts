import { Injectable } from '@angular/core';
import { IProduct } from '../interfaces/product.interface';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class BasketService {
  basketTotalPrice = new Subject<number>();
  count = new Subject();
  constructor() {}

  get orders(): IProduct[] {
    return JSON.parse(localStorage.getItem('orders') || '[]');
  }

  addToBasket(product: IProduct): void {
    if (this.orders.length) {
      if (this.orders.some((o) => o.id === product.id)) {
        const order = this.orders.find((o) => o.id === product.id);
        if (order) {
          order.count += product.count;
          if (product.discount && product.discountPercent) {
            const priceWithDiscount =
              product.price -
              (product.price * parseFloat(product.discountPercent)) / 100;
            order.totalPrice = priceWithDiscount * order.count;
          } else {
            order.totalPrice = order.price * order.count;
          }
          localStorage.setItem(
            'orders',
            JSON.stringify([
              ...this.orders.map((o) => (o.id === order.id ? order : o)),
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
      if (product.discount && product.discountPercent) {
        const priceWithDiscount =
          product.price -
          (product.price * parseFloat(product.discountPercent)) / 100;
        product.totalPrice = priceWithDiscount * product.count;
      } else {
        product.totalPrice = product.price * product.count;
      }
      localStorage.setItem('orders', JSON.stringify([product]));
    }
    this.basketTotalPrice.next(this.sumPriceOfOrders());
  }

  public sumPriceOfOrders(): number {
    if (this.orders.length) {
      return this.orders.reduce((acc, o) => acc + o.totalPrice, 0);
    }
    return 0;
  }
}
