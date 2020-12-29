import { IProduct } from '../interfaces/product.interface';
export class Product implements IProduct {
  public totalPrice: number;
  public dateOfEdition: Date;
  public fullTextName: string | undefined;
  constructor(
    public category: string,
    public unitId: string,
    public width: string,
    public hight: string,
    public length: string,
    public price: number,
    public isAvailable: boolean,
    public isDiscount: boolean,
    public discount: string | null,
    public titleEn: string,
    public titlePl: string,
    public titleUk: string,
    public materialUk: string,
    public materialEn: string,
    public materialPl: string,
    public descriptionUk: string,
    public descriptionEn: string,
    public descriptionPl: string,
    public images: string[],
    public count: number = 1,
  ) {
    this.totalPrice = this.getTotalPrice();
    this.dateOfEdition = new Date();
    this.convertFullTextName();
  }

  private getTotalPrice(): number {
    if (this.discount) {
      return +(this.price - (this.price * parseFloat(this.discount)) / 100).toFixed(2);
    } else {
      return this.price;
    }
  }

  private convertFullTextName(): void {
    this.fullTextName = this.category + this.unitId
      + this.width + this.hight + this.length
      + this.descriptionEn + this.descriptionPl
      + this.descriptionUk + this.titleEn + this.titlePl + this.titleUk
      + this.materialEn + this.materialPl + this.materialUk + this.discount || '';
  }
}
