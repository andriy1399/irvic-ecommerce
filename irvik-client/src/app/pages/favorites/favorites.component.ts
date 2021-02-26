import { Component, OnInit } from '@angular/core';
import { IProduct } from '../../shared/interfaces/product.interface';
import { FavoritesService } from '../../shared/services/favorites.service';
import { TranslateService } from '@ngx-translate/core';
import { ProductTranslate } from '../../shared/models/product-translate.model';
import { BasketService } from 'src/app/shared/services/basket.service';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.scss'],
})
export class FavoritesComponent implements OnInit {
  favorites: IProduct[] = [];
  constructor(
    private favoritesService: FavoritesService,
    private translate: TranslateService,
    private basketService: BasketService
  ) {}

  ngOnInit(): void {
    this.getFavorites();
    setTimeout(() => {
      if (this.favorites.length) {
        const translatedProducts = new ProductTranslate(
          this.favorites,
          this.translate
        );
        translatedProducts.prepareToTranslate();
      }
    }, 300);
  }
  private getFavorites(): void {
    this.favorites = this.favoritesService.getFavorites();
  }
  public deleteFavorite(favorite: IProduct): void {
    this.favoritesService.deleteFavorite(favorite);
    this.getFavorites();
  }
  public parse(str: string): number {
    if (typeof parseFloat(str) === 'number') {
      return parseFloat(str);
    } else {
      return 0;
    }
  }
  public addToBasket(favorite: IProduct): void {
    this.basketService.addToBasket(favorite);
  }
  public convertToSnakeCase(str: string): string {
    return str.split(' ').join('_');
  }
}
