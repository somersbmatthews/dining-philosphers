import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { KonvaModule } from 'ng2-konva';

@NgModule({
  declarations: [
    AppComponent, 
    AppHeader],
  imports: [
    BrowserModule,
    KonvaModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
