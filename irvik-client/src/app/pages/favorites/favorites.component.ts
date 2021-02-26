import { Component, OnInit } from '@angular/core';
import { IProduct } from '../../shared/interfaces/product.interface';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.scss']
})
export class FavoritesComponent implements OnInit {
  favorites: IProduct[] = [];
  constructor() { }

  ngOnInit(): void {
  }
  public parse(str: string): number {
    if (typeof parseFloat(str) === 'number') {
      return parseFloat(str);
    } else {
      return 0;
    }
  }
  public deleteOrder(id: string | number | undefined): void {
    if (id) {
    }
  }
  public convertToSnakeCase(str: string): string {
    return str.split(' ').join('_');
  }
}
