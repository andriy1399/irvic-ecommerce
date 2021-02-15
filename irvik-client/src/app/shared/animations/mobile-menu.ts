import { trigger, transition, query, animate, style } from '@angular/animations';
export const mobileMenu = trigger('mobileMenu', [
  transition('void => *', [
    query('.mobile-menu__menu', [
      style({right: '-300px'}),
      animate('300ms ease', style({
        right: '0'
      })),
    ])
  ]),
  transition('* => void', [
    query('.mobile-menu__menu', [
      style({right: '0px'}),
      animate('300ms ease', style({
        right: '-300px'
      })),
    ])
  ])
]);
