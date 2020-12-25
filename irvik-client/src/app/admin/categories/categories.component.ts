import { Component, OnInit } from '@angular/core';
import { CategoriesService } from '../../shared/services/categories.service';
import { ICategory } from '../../shared/interfaces/category.interface';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.scss']
})
export class CategoriesComponent implements OnInit {
  nameUk = '';
  namePl = '';
  nameEn = '';
  categories: ICategory[] = [];
  constructor(
    private categoriesServ: CategoriesService,
    private translate: TranslateService
  ) { }

  ngOnInit(): void {
    this.getCategories();
    this.translate.setDefaultLang(localStorage.getItem('lang') || 'pl');
    this.categoriesServ.lang.subscribe(lan => {
      this.translate.setDefaultLang(lan);
    });
  }

  addCategory(): void {
    if (this.checkForm()) {
      const category: ICategory = {
        categoryEn: this.nameEn,
        categoryPl: this.namePl,
        categoryUk: this.nameUk
      };

      this.categoriesServ.postCategory(category).subscribe(() => {
        this.clearForm();
        this.getCategories();
      });
    }
  }

  getCategories(): void {
    this.categoriesServ.getCategories().subscribe(data => {
      this.categories = data;
      const enCategories = new Map(data.map(v => ([[v.categoryEn.split(' ').join('_')], v.categoryEn])));
      const ukCategories = new Map(data.map(v => ([[v.categoryEn.split(' ').join('_')], v.categoryUk]))) ;
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

    });
  }

  public convertToSnakeCase(str: string): string {
    return str.split(' ').join('_');
  }

  private clearForm(): void {
    this.nameEn = '';
    this.namePl = '';
    this.nameUk = '';
  }
  private checkForm(): boolean {
    return this.nameEn.trim() && this.namePl.trim() && this.nameUk.trim() ? true : false;
  }
}
