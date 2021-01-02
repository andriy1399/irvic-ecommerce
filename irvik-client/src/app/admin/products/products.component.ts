import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CategoriesService } from '../../shared/services/categories.service';
import { ICategory } from '../../shared/interfaces/category.interface';
import { Product } from '../../shared/models/product.model';
import { IProduct } from '../../shared/interfaces/product.interface';
import { ProductService } from '../../shared/services/product.service';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({ height: '0px', minHeight: '0' })),
      state('expanded', style({ height: '*' })),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class ProductsComponent implements OnInit, AfterViewInit {
  tabsIndex: number | undefined;
  arrFiles: any[] = [];
  productGroup!: FormGroup;
  isEditing = false;
  categories: ICategory[] = [];
  isGotProduct = false;
  products!: MatTableDataSource<IProduct>;
  columnsToDisplay = ['image', 'titleUk', 'price', 'unitId', 'edit', 'delete'];
  expandedElement!: IProduct | null;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  editingProductId: string | number | undefined;
  constructor(
    private categoryServ: CategoriesService,
    private productServ: ProductService
  ) { }

  ngOnInit(): void {
    this.getCategories();
    this.getProducts();
    this.productGroup = new FormGroup({
      category: new FormControl(null, Validators.required),
      unitId: new FormControl(null, Validators.required),
      width: new FormControl(null, Validators.required),
      height: new FormControl(null, Validators.required),
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
  ngAfterViewInit(): void {
    if (this.isGotProduct) {
      this.products.paginator = this.paginator || null;
    }
  }
  private getCategories(): void {
    this.categoryServ.getCategories().subscribe(categories => {
      this.categories = categories;
    });
  }

  private getProducts(): void {
    this.productServ.getProducts().subscribe(products => {
      this.products = new MatTableDataSource<IProduct>(products);
      this.isGotProduct = true;
    }, err => console.log(err), () => {
      this.products.paginator = this.paginator || null;
    });
  }

  public addProduct(): void {
    const { category, unitId, width, height, length, price,
      isAvailable, discount, titleEn, titlePl, titleUk, isDiscount,
      materialPl, materialEn, materialUk, descriptionEn, descriptionUk, descriptionPl } = this.productGroup.value;
    const product: IProduct = new Product(
      category,
      unitId,
      width,
      height,
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
    const { category, unitId, width, height, length, price,
      isAvailable, discount, titleEn, titlePl, titleUk, isDiscount,
      materialPl, materialEn, materialUk, descriptionEn, descriptionUk, descriptionPl } = this.productGroup.value;
    const product: IProduct = new Product(
      category,
      unitId,
      width,
      height,
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
    this.productServ.updateProduct({ ...product, id: this.editingProductId }).subscribe(() => {
      this.productGroup.reset();
      this.arrFiles = [];
      this.isEditing = false;
      Object.keys(this.productGroup.controls).forEach(key => {
        this.productGroup.get(key)?.setErrors(null);
      });
      this.getProducts();
    });

  }

  public deleteProduct(id: number): void {
    this.productServ.deleteProduct(id).subscribe(() => {
      this.getProducts();
    });
  }

  public editProduct(product: IProduct): void {
    console.log('sdd');
    this.productGroup.setValue({
      unitId: product.unitId,
      category: product.category,
      titleEn: product.titleEn,
      titleUk: product.titleUk,
      titlePl: product.titlePl,
      descriptionPl: product.descriptionPl,
      descriptionUk: product.descriptionUk,
      descriptionEn: product.descriptionEn,
      materialEn: product.materialEn,
      materialPl: product.materialPl,
      materialUk: product.materialUk,
      price: product.price,
      discount: product.isDiscount ? product.discount : '',
      isDiscount: product.isDiscount,
      isAvailable: product.isAvailable,
      width: product.width,
      length: product.length,
      height: product.height
    });

    this.isEditing = true;
    this.editingProductId = product.id;
    this.arrFiles = product.images;

    this.tabsIndex = 0;
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
