import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DiningComponent } from './components/dining/dining.component';
import { NotFoundComponent } from './components/not-found/not-found.component';


const routes: Routes = [
  {path: "", component: DiningComponent},
  {path: "**", component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],

exports: [RouterModule]
})
export class AppRoutingModule { }
