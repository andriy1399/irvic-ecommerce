import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { CategoriesService } from '../../shared/services/categories.service';
import { LoginService } from '../../shared/services/login.service';
import { BasketService } from '../../shared/services/basket.service';
import { mobileMenu } from '../../shared/animations/mobile-menu';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
  animations: [mobileMenu],
})
export class HeaderComponent implements OnInit {
  isAuth = false;
  basketTotalPrice = 0;
  mobileMenuOpen = false;
  constructor(
    public translate: TranslateService,
    private categoriesServ: CategoriesService,
    public loginService: LoginService,
    private basketService: BasketService
  ) {}

  ngOnInit(): void {
    const lang = localStorage.getItem('lang') || 'pl';
    this.translate.use(lang);
    this.translate.setDefaultLang(lang);
    this.changeLang(null, lang);
    if (localStorage.getItem('token')) {
      this.isAuth = this.loginService.isAuthenticated();
    }
    this.loginService.isAuth.subscribe((bol) => (this.isAuth = bol));
    this.basketTotalPrice = this.basketService.sumPriceOfOrders();
    this.basketService.basketTotalPrice.subscribe(
      (price) => (this.basketTotalPrice = price)
    );
  }
  changeLang(e: Event | null, language?: string): void {
    let lang;
    if (e) {
      lang = (e.target as HTMLInputElement).value;
    } else {
      lang = language;
    }
    if (lang) {
      this.translate.use(lang);
      localStorage.setItem('lang', lang);
    }
    this.categoriesServ.lang.next(lang);
    if (e) {
      window.location.reload();
    }
  }

  closeMobileMenu(event: Event): void {
    const isClickOnShadow = (event.target as HTMLElement).className
      .split(' ')
      .some((v) => v === 'mobile-menu');
    if (isClickOnShadow) {
      document.body.style.overflow = 'auto';
      this.mobileMenuOpen = false;
    }
  }
  closeMobileMenuBtn(): void {
    document.body.style.overflow = 'auto';
    this.mobileMenuOpen = false;
  }
  openMobileMenu(): void {
    document.body.style.overflow = 'hidden';
    this.mobileMenuOpen = true;
  }
}
