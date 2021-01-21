import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IProduct } from 'src/app/shared/interfaces/product.interface';
import { ProductService } from 'src/app/shared/services/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss']
})
export class ProductDetailsComponent implements OnInit {
  product!: IProduct;
  constructor(
    private productsService: ProductService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.getProduct();
  }
  private getProduct(): void {
    const productId = this.route.snapshot.paramMap.get('id') || '';
    this.productsService.getProductById(productId)
      .subscribe(product => {
        this.product = product;
        console.log(product);
      });
  }
}
