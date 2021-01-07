import { Component, OnInit } from '@angular/core';
import { CategoriesService } from '../../shared/services/categories.service';
import { ICategory } from '../../shared/interfaces/category.interface';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.scss']
})
export class StoreComponent implements OnInit {
  categories: ICategory[] = [];
  constructor(
    private categoriesServ: CategoriesService,
    private translate: TranslateService
  ) { }

  ngOnInit(): void {
    this.getCategories();
    setTimeout(() => {
      this.translate.setDefaultLang(localStorage.getItem('lang') || 'pl');
    }, 100);
    // this.categoriesServ.lang.subscribe(lan => {
    //   this.translate.setDefaultLang(lan);
    // });
  }

  getCategories(): void {
    this.categoriesServ.getCategories().subscribe(categories => {
      this.categories = categories;
      this.categoryForTranslate(categories);
    });
  }
  public convertToSnakeCase(str: string): string {
    return str.split(' ').join('_');
  }

  private categoryForTranslate(data: ICategory[]): void {
    const enCategories = new Map(data.map(v => ([[v.categoryEn.split(' ').join('_')], v.categoryEn])));
    const ukCategories = new Map(data.map(v => ([[v.categoryEn.split(' ').join('_')], v.categoryUk])));
    const plCategories = new Map(data.map(v => ([[v.categoryEn.split(' ').join('_')], v.categoryPl])));
    this.translate.setTranslation('en', {
      categories: Object.fromEntries(enCategories)
    }, true);
    this.translate.setTranslation('uk', {
      categories: Object.fromEntries(ukCategories)
    }, true);
    this.translate.setTranslation('pl', {
      categories: Object.fromEntries(plCategories)
    }, true);
  }
}
