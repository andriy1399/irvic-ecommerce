import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { ProductTranslate } from 'src/app/shared/models/product-translate.model';
import { IProduct } from '../../shared/interfaces/product.interface';
import { BasketService } from '../../shared/services/basket.service';

@Component({
  selector: 'app-bag',
  templateUrl: './bag.component.html',
  styleUrls: ['./bag.component.scss'],
})
export class BagComponent implements OnInit {
  percent!: string;
  orders: IProduct[] = [];
  constructor(
    private basketService: BasketService,
    private translate: TranslateService
  ) {}

  ngOnInit(): void {
    this.orders = this.basketService.orders;
    setTimeout(() => {
      if (this.orders.length) {
        const translatedProducts = new ProductTranslate(
          this.orders,
          this.translate
        );
        translatedProducts.prepareToTranslate();
      }
    }, 300);
  }

  public parse(str: string): number {
    if (typeof parseFloat(str) === 'number') {
      return parseFloat(str);
    } else {
      return 0;
    }
  }
  public checkCount(order: IProduct): void {
    if (order && order.count <= 0) {
      order.count = 1;
    }
    if (order && order.count >= 10000) {
      order.count = 10000;
    }
  }
  public convertToSnakeCase(str: string): string {
    return str.split(' ').join('_');
  }
}
