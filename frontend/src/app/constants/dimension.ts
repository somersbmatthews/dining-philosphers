import { Observable } from "rxjs"

export class Dimensions{
    configStage$: Observable<any>;
    stage:any
    constructor(private configStage: Observable<any>){
        this.configStage$ = configStage;
        this.configStage$.subscribe(configStage=>{
            this.stage.width = configStage.width;
            this.stage.height = configStage.height;
            console.log("This is stage.");
            console.log(this.stage);
        })
    }
    getStageWidth=()=>this.stage.width;
    getStageHeight=()=>this.stage.height;
}
