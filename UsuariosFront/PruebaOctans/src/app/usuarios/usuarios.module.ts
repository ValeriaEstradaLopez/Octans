import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsuariosRoutingModule } from './usuarios-routing.module';
import { DialogOverviewExampleDialog, IndexComponent } from './usuario/index/index.component';
import {MatTableModule} from '@angular/material/table';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldControl, MatFormFieldModule } from '@angular/material/form-field';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';
import { BrowserModule } from '@angular/platform-browser';


@NgModule({
  declarations: [
    IndexComponent,
    DialogOverviewExampleDialog
  ],
  imports: [
    
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    UsuariosRoutingModule, 
    MatTableModule,
    ReactiveFormsModule, 
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    MatDialogModule
  ],
  exports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule, MatFormFieldModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class UsuariosModule { }
