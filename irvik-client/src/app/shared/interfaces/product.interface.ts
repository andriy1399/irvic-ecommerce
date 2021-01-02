export interface IProduct {
  category: string;
  unitId: string;
  width: string;
  height: string;
  length: string;
  price: number;
  isAvailable: boolean;
  isDiscount: boolean;
  discount: string | null;
  totalPrice: number;
  titleEn: string;
  titlePl: string;
  titleUk: string;
  materialUk: string;
  materialPl: string;
  materialEn: string;
  descriptionEn: string;
  descriptionPl: string;
  descriptionUk: string;
  images: string[];
  dateOfEdition: Date;
  count: number;
  id?: string | number;
}
