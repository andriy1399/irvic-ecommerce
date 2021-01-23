import {
  Component,
  OnInit,
  ElementRef,
  ViewChild,
  SimpleChanges,
  OnChanges,
  AfterContentChecked,
} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IProduct } from 'src/app/shared/interfaces/product.interface';
import { ProductService } from 'src/app/shared/services/product.service';
import { Gallery } from 'angular-gallery';
import { OwlOptions, SlidesOutputData } from 'ngx-owl-carousel-o';
@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss'],
})
export class ProductDetailsComponent implements OnInit {
  product!: IProduct;
  activeImage = '';
  images: string[] = [];
  // *for owl-carousel
  // customOptions: OwlOptions = {
  //   loop: false,
  //   mouseDrag: true,
  //   touchDrag: true,
  //   pullDrag: true,
  //   dots: true,
  //   navSpeed: 600,
  //   navText: ['&#8249', '&#8250;'],
  //   autoplay: false,
  //   startPosition: 4,
  //   responsive: {
  //     0: {
  //       items: 3,
  //     }
  //   },
  //   nav: false,
  //   margin: 10,
  // };
  // slider: any;
  // activeSlides!: SlidesOutputData;
  // imageRef!: ElementRef;
  // *for owl-carousel
  constructor(
    private productsService: ProductService,
    private route: ActivatedRoute // *for owl-carousel // private gallery: Gallery
  ) // *for owl-carousel
  {}

  ngOnInit(): void {
    this.getProduct();
  }

  private getProduct(): void {
    const productId = this.route.snapshot.paramMap.get('id') || '';
    this.productsService.getProductById(productId).subscribe((product) => {
      this.product = product;
      this.images = product.images;
      // *for owl-carousel
      // this.openImage();
      // this.slider = this.sliderImages();
      // *for owl-carousel
    });
  }

  // *for owl-carousel {
  // public showGallery(index: number): void {
  //   // const images: string[] = [this.activeImage, ...this.images];
  //   const prop = {
  //     images: this.images.map((img) => ({ path: img })),
  //     index,
  //   };
  //   this.gallery.load(prop);
  // }
  // *for owl-carousel }
  // *for owl-carousel {

  // private sliderImages(img?: string): any {
  //   let index = 0;
  //   const imagesLength = this.images.length;

  //   if (img) {
  //     index = this.images.findIndex((v) => img === v);
  //   }
  //   return {
  //     next: (): void => {
  //       if (index <= imagesLength - 2) {
  //         index++;
  //         this.activeImage = this.images[index];
  //         this.customOptions.slideBy = index;
  //         this.customOptions.startPosition = index;
  //         console.log(this.customOptions);
  //       } else {
  //         index = imagesLength - 1;
  //       }
  //     },
  //     prev: (): void => {
  //       if (index >= 1) {
  //         index--;
  //         this.activeImage = this.images[index];
  //       } else {
  //         index = 0;
  //       }
  //     },
  //     index,
  //   };
  // }
  // *for owl-carousel }

  // *for owl-carousel {
  // public openImage(img?: string, i?: number): void {
  //   if (img) {
  //     // this.images.splice(i || 0, 0, this.activeImage);
  //     this.activeImage = img;
  //     this.slider = this.sliderImages(img);
  //     // this.images = this.images.filter((image) => img !== image);
  //   } else {
  //     this.activeImage = this.images[0];
  //     // this.images = this.images.slice(1);
  //   }
  // }
  // *for owl-carousel }
}
