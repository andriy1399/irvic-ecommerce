import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(
    public translate: TranslateService
  ) { }

  ngOnInit(): void {
    const lang = localStorage.getItem('lang') || 'pl';
    this.translate.use(lang);
    this.changeLang(null, lang);
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
  }
}
