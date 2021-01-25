import { Component, OnInit, ElementRef } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IProduct } from 'src/app/shared/interfaces/product.interface';
import { ProductService } from 'src/app/shared/services/product.service';
import { Gallery } from 'angular-gallery';
import { OwlOptions, SlidesOutputData } from 'ngx-owl-carousel-o';
import { ProductTranslate } from 'src/app/shared/models/product-translate.model';
import { TranslateService } from '@ngx-translate/core';
@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss'],
})
export class ProductDetailsComponent implements OnInit {
  product!: IProduct;
  activeImage = '';
  images: string[] = [];
  isDisabledPrevArrow = false;
  isDisabledNextArrow = false;
  title = '';
  customOptions: OwlOptions = {
    loop: false,
    mouseDrag: true,
    touchDrag: true,
    pullDrag: true,
    dots: true,
    navSpeed: 600,
    navText: ['&#8249', '&#8250;'],
    autoplay: false,
    startPosition: 0,

    responsive: {
      0: {
        items: 3,
      },
    },
    nav: false,
    margin: 10,
  };
  slider: any;
  products: IProduct[] = [];
  constructor(
    private productsService: ProductService,
    private route: ActivatedRoute,
    private gallery: Gallery,
    private translate: TranslateService
  ) {}

  ngOnInit(): void {
    this.getProduct();
    this.getProducts();
    setTimeout(() => {
      this.translate.setDefaultLang(localStorage.getItem('lang') || 'pl');
    }, 100);
  }
  private getProducts(): void {
    this.productsService.getProducts().subscribe((products) => {
      this.products = products;
      const translatedProducts = new ProductTranslate(
        products,
        this.translate
      );
      translatedProducts.prepareToTranslate();
    });
  }

  private getProduct(): void {
    const productId = this.route.snapshot.paramMap.get('id') || '';
    this.productsService.getProductById(productId).subscribe((product) => {
      this.product = product;
      this.images = product.images;
      this.openImage();
      this.slider = this.sliderImages();
      this.isDisabledPrevArrow = true;
    });
  }

  public showGallery(index: number): void {
    const prop = {
      images: this.images.map((img) => ({ path: img })),
      index,
    };
    this.gallery.load(prop);
  }

  private sliderImages(img?: string): any {
    let index = 0;
    const imagesLength = this.images.length;

    if (img) {
      index = this.images.findIndex((v) => img === v);
      if (index === imagesLength - 1) {
        this.isDisabledNextArrow = true;
        this.isDisabledPrevArrow = false;
      } else if (index === 0) {
        this.isDisabledPrevArrow = true;
        this.isDisabledNextArrow = false;
      } else {
        this.isDisabledNextArrow = false;
        this.isDisabledPrevArrow = false;
      }
    }
    return {
      next: (): void => {
        if (index <= imagesLength - 2) {
          index++;
          this.activeImage = this.images[index];
          this.customOptions.slideBy = index;
          this.customOptions.startPosition = index;
          this.isDisabledNextArrow = false;
          this.isDisabledPrevArrow = false;
        } else {
          index = imagesLength - 1;
        }
        if (index === imagesLength - 1) {
          this.isDisabledNextArrow = true;
        }
      },
      prev: (): void => {
        if (index >= 1) {
          index--;
          this.activeImage = this.images[index];
          this.isDisabledPrevArrow = false;
          this.isDisabledNextArrow = false;
        } else {
          this.isDisabledPrevArrow = true;
          index = 0;
        }
        if (index === 0) {
          this.isDisabledPrevArrow = true;
        }
      },
      index,
    };
  }

  public openImage(img?: string): void {
    if (img) {
      this.activeImage = img;
      this.slider = this.sliderImages(img);
    } else {
      this.activeImage = this.images[0];
    }
  }

  public convertToSnakeCase(str: string): string {
    return str.split(' ').join('_');
  }

  public parse(str: string): number {
    if (typeof parseFloat(str) === 'number') {
      return  parseFloat(str);
    } else {
      return 0;
    }
  }

  public checkCount(): void {
    if (this.product.count <= 0) {
      this.product.count = 1;
    }
  }
}
