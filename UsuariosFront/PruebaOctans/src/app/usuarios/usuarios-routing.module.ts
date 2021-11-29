import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './usuario/index/index.component';

const routes: Routes = [
  {
    path:'list',
    component:IndexComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes),
  CommonModule],
  exports: [RouterModule]
})
export class UsuariosRoutingModule { }
