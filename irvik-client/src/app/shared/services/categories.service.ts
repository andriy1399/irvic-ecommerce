import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { ICategory } from '../interfaces/category.interface';

@Injectable({
  providedIn: 'root'
})
export class CategoriesService {
  private url = 'http://localhost:3000/categories';
  public lang = new Subject<string>();
  constructor(
    private http: HttpClient
  ) { }

  getCategories(): Observable<ICategory[]> {
    return this.http.get<ICategory[]>(this.url);
  }
  postCategory(body: ICategory): Observable<ICategory> {
    return this.http.post<ICategory>(this.url, body);
  }
  updateCategory(body: ICategory): Observable<ICategory> {
    return this.http.put<ICategory>(`${this.url}/${body.id}`, body);
  }
  deleteCategory(id: number | string): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
