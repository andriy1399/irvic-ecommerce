import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CategoriesService } from '../../shared/services/categories.service';
import { ICategory } from '../../shared/interfaces/category.interface';
import { Product } from '../../shared/models/product.model';
import { IProduct } from '../../shared/interfaces/product.interface';
import { ProductService } from '../../shared/services/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  tabsIndex: number | undefined;
  arrFiles: any[] = [];
  productGroup!: FormGroup;
  isEditing = false;
  categories: ICategory[] = [];
  constructor(
    private categoryServ: CategoriesService,
    private productServ: ProductService
  ) { }

  ngOnInit(): void {
    this.getCategories();
    this.productGroup = new FormGroup({
      category: new FormControl(null, Validators.required),
      unitId: new FormControl(null, Validators.required),
      width: new FormControl(null, Validators.required),
      hight: new FormControl(null, Validators.required),
      length: new FormControl(null, Validators.required),
      price: new FormControl(null, Validators.required),
      isDiscount: new FormControl(false),
      isAvailable: new FormControl(false),
      discount: new FormControl(null),
      titleEn: new FormControl(null, Validators.required),
      titlePl: new FormControl(null, Validators.required),
      titleUk: new FormControl(null, Validators.required),
      materialUk: new FormControl(null, Validators.required),
      materialEn: new FormControl(null, Validators.required),
      materialPl: new FormControl(null, Validators.required),
      descriptionUk: new FormControl(null, Validators.required),
      descriptionEn: new FormControl(null, Validators.required),
      descriptionPl: new FormControl(null, Validators.required),
    });
  }

  private getCategories(): void {
    this.categoryServ.getCategories().subscribe(categories => {
      this.categories = categories;
    });
  }


  public addProduct(): void {
    const { category, unitId, width, hight, length, price,
      isAvailable, discount, titleEn, titlePl, titleUk, isDiscount,
      materialPl, materialEn, materialUk, descriptionEn, descriptionUk, descriptionPl } = this.productGroup.value;
    const product: IProduct = new Product(
      category,
      unitId,
      width,
      hight,
      length,
      price,
      isAvailable,
      isDiscount,
      discount || null,
      titleEn,
      titlePl,
      titleUk,
      materialUk,
      materialEn,
      materialPl,
      descriptionUk,
      descriptionEn,
      descriptionPl,
      this.arrFiles
    );
    this.productServ.postProduct(product).subscribe(() => {
      this.productGroup.reset();
      this.arrFiles = [];
      Object.keys(this.productGroup.controls).forEach(key => {
        this.productGroup.get(key)?.setErrors(null);
      });
    });
  }

  public updateProduct(): void {

  }

  public changeIsDiscount(): void {
    const { isDiscount } = this.productGroup.value;
    if (isDiscount) {
      this.productGroup.controls.discount.enable();
    } else {
      this.productGroup.controls.discount.disable();
    }
  }


  uploadFiles(event: Event): void {
    const files = (event.target as HTMLInputElement).files;
    // tslint:disable-next-line:no-non-null-assertion
    for (let index = 0; index < files!.length; index++) {
      const reader = new FileReader();
      ((file) => {
        if (file) {
          const f = file as any;
          reader.readAsDataURL(f);
        }
        reader.onload = (e: any) => {
          this.arrFiles.push(e.target.result as string);
        };
      })(files?.item(index));

    }
  }
  public setTabs(event: number): void {
    this.tabsIndex = event;
  }
}
