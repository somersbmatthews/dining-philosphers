import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
//import { of } from 'rxjs/Observable';

// @Component({
//   selector: 'app-root',
//   template: `
//     <ko-stage [config]="configStage">
//       <ko-layer>
//         <ko-circle [config]="configCircle" (click)="handleClick($event)"></ko-circle>
//       </ko-layer>
//     </ko-stage>`
//     //styleUrls: ['./app.component.scss']
// })
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
class AppComponent {
 
  public configStage: Observable<any> = of({
    width: 200,
    height: 200
  });
  public configCircle: Observable<any> = of({
    x: 100,
    y: 100,
    radius: 70,
    fill: 'red',
    stroke: 'black',
    strokeWidth: 4
  });

  public handleClick(component: any) {
    console.log('Hello Circle', component);
  }
}



