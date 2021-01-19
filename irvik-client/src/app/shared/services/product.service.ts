import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IProduct } from '../interfaces/product.interface';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  // private url = 'http://localhost:3000/products';
  private url = 'http://localhost:8080/api/test/products';
  private getProductsUrl = 'http://localhost:8080/api/products';
  constructor(private http: HttpClient) {}

  // getProducts(): Observable<IProduct[]> {
  //   return this.http.get<IProduct[]>(this.url);
  // }
  // postProduct(body: IProduct): Observable<IProduct> {
  //   return this.http.post<IProduct>(this.url, body);

  // }
  // updateProduct(body: IProduct): Observable<IProduct> {
  //   return this.http.put<IProduct>(`${this.url}/${body.id}`, body);

  // }
  // deleteProduct(id: number | string): Observable<void> {
  //   return this.http.delete<void>(`${this.url}/${id}`);
  // }


  getProducts(): Observable<IProduct[]> {
    return this.http.get<IProduct[]>(this.getProductsUrl);
  }
  postProduct(body: IProduct): Observable<IProduct> {
    return this.http.post<IProduct>(this.url, body, {
      headers: {
        Authorization: 'testToken',
      },
    });
  }
  updateProduct(body: IProduct): Observable<IProduct> {
    return this.http.put<IProduct>(`${this.url}/${body.id}`, body, {
      headers: {
        Authorization: 'testToken',
      },
    });
  }
  deleteProduct(id: number | string): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`, {
      headers: {
        Authorization: 'testToken',
      },
    });
  }
}
