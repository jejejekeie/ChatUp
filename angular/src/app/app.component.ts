import { Component } from '@angular/core';
import { trigger, transition, animate, style, query, animateChild, group } from '@angular/animations';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  animations: [
    trigger('pageTransition', [
      transition('1 => 2, 2 => 3, 3 => 1', [
        style({ position: 'relative' }),
        query(':enter, :leave', [
          style({
            position: 'absolute',
            top: 0,
            left: 0,
            width: '100%'
          })
        ]),
        query(':enter', [
          style({ opacity: 0 })
        ]),
        query(':leave', animateChild()),
        group([
          query(':leave', [
            animate('300ms ease-out', style({ opacity: 0 }))
          ]),
          query(':enter', [
            animate('300ms ease-out', style({ opacity: 1 }))
          ])
        ]),
        query(':enter', animateChild())
      ])
    ])
  ]
})
export class AppComponent {
  prepareRoute(outlet: RouterOutlet) {
    return outlet && outlet.activatedRouteData && outlet.activatedRouteData;
  }
}

