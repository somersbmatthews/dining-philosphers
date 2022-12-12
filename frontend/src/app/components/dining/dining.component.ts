import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';


@Component({
  selector: 'app-dining',
  templateUrl: './dining.component.html',
  styleUrls: ['./dining.component.scss']
})
export class DiningComponent implements OnInit {
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

  constructor() { }

  ngOnInit(): void {
  }



  public handleClick(component: any) {
    console.log('Hello Circle', component);
  }
}
