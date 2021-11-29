import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { IndexComponent } from './usuarios/usuario/index/index.component';

const routes: Routes = [
 
  {
      path: 'index',
      loadChildren: () =>
        import('./usuarios/usuarios.module').then((m) => m.UsuariosModule),
    }
  
  
];


@NgModule({
  imports: [RouterModule.forRoot(routes),],
  exports: [RouterModule]
})
export class AppRoutingModule { }
