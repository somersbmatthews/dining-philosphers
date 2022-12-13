import { Component, OnInit, ViewChild } from '@angular/core';
import { Stage, stages } from 'konva/lib/Stage';
import { KonvaComponent } from 'ng2-konva';
import { Observable, of } from 'rxjs';
import { DiningStage } from 'src/app/constants/stage';


@Component({
  selector: 'app-dining',
  templateUrl: './dining.component.html',
  styleUrls: ['./dining.component.scss']
})
export class DiningComponent implements OnInit {
  height = window.innerHeight
  width = window.innerWidth
  stage: DiningStage = {
    width: window.innerWidth,
    height: window.innerHeight
  }
  position = {
    centerCirclePosition:

  }
  //  @ViewChild('stage') konvaObject: KonvaComponent | undefined;


  // @ViewChild('layer') layer: KonvaComponent;
  // @ViewChild('dragLayer') dragLayer: KonvaComponent;
  // var stage = new Konva.Stage({
  //   container: 'container',
  //   // first just set set as is
  //   width: sceneWidth,
  //   height: sceneHeight,
  // });
  public stageConfig: Observable<any> = of({
    width: this.width,
    height: this.height
  });

  public configCenterCircle: Observable<any> = of({
    x: this.stage.width / 3,
    y: 325,
    radius: 70,
    fill: 'blue',
    stroke: 'black',
    strokeWidth: 4
  });
  public configCircle: Observable<any> = of({
    x: 150,
    y: 150,
    radius: 70,
    fill: 'white',
    stroke: 'black',
    strokeWidth: 4
  });
  public configCircle2: Observable<any> = of({
    x: 500,
    y: 150,
    radius: 70,
    fill: 'white',
    stroke: 'black',
    strokeWidth: 4
  });
  public configCircle3: Observable<any> = of({
    x: 325,
    y: 550,
    radius: 70,
    fill: 'white',
    stroke: 'black',
    strokeWidth: 4
  });
  public configCircle4: Observable<any> = of({
    x: 100,
    y: 400,
    radius: 70,
    fill: 'white',
    stroke: 'black',
    strokeWidth: 4
  });
  public configCircle5: Observable<any> = of({
    x: 550,
    y: 400,
    radius: 70,
    fill: 'white',
    stroke: 'black',
    strokeWidth: 4
  });

  constructor() {

  }

  ngOnInit(): void {

  }



  public handleClick(component: any) {
    console.log('Hello Circle', component);
  }
}
