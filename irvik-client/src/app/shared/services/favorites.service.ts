import { Injectable } from '@angular/core';
import { IProduct } from '../interfaces/product.interface';

@Injectable({
  providedIn: 'root',
})
export class FavoritesService {
  constructor() {}
  private get favorites(): IProduct[] {
    return JSON.parse(localStorage.getItem('favorites') || '[]');
  }
  addToFavorites(product: IProduct): void {
    if (this.favorites.some((v) => v.id === product.id)) {
      localStorage.setItem('favorites', JSON.stringify(this.favorites));
    } else {
      localStorage.setItem(
        'favorites',
        JSON.stringify([...this.favorites, product])
      );
    }
  }

  getStringOfIds(): (string | number | undefined)[] {
    return this.convertIdsToString();
  }

  private convertIdsToString(): (string | number | undefined)[] {
    return this.favorites.map((v) => v.id);
  }

  deleteFavorite(product: IProduct): void {
    localStorage.setItem(
      'favorites',
      JSON.stringify(this.favorites.filter((v) => v.id !== product.id))
    );
  }

  getFavorites(): IProduct[] {
    return this.favorites;
  }
}
