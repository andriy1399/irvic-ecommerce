import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IProduct } from 'src/app/shared/interfaces/product.interface';
import { ProductService } from 'src/app/shared/services/product.service';
import { Gallery } from 'angular-gallery';
@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss'],
})
export class ProductDetailsComponent implements OnInit {
  product!: IProduct;
  activeImage = '';
  images: string[] = [];
  constructor(
    private productsService: ProductService,
    private route: ActivatedRoute,
    private gallery: Gallery
  ) {}

  ngOnInit(): void {
    this.getProduct();
  }
  private getProduct(): void {
    const productId = this.route.snapshot.paramMap.get('id') || '';
    this.productsService.getProductById(productId).subscribe((product) => {
      this.product = product;
      this.images = product.images;
      this.openImage();
    });
  }
  public showGallery(index: number): void {
    const images: string[] = [this.activeImage, ...this.images];
    const prop = {
      images: images.map((img) => ({ path: img })),
      index,
    };
    this.gallery.load(prop);
  }

  public openImage(img?: string, i?: number): void {
    if (img) {
      // this.images.splice(i || 0, 0, this.activeImage);
      this.activeImage = img;
      // this.images = this.images.filter((image) => img !== image);
    } else {
      this.activeImage = this.images[0];
      // this.images = this.images.slice(1);
    }
  }
}
