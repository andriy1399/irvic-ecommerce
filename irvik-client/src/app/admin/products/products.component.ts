import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  tabsIndex: number | undefined;
  images: string[] = [];
  arrFiles: any[] = [];
  constructor() { }

  ngOnInit(): void {
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
