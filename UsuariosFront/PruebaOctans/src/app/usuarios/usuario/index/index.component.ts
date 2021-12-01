
import { Component, Inject, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { UsuarioService } from '../../servicio/usuario.service';
export interface DialogData {
  nombre: string;
  rol:any;
activo:String;
}
@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {

usuarios:any=[];
filtroForm: FormGroup;
displayedColumns: string[] = ['Nombre', 'Rol', 'Activo', 'Acciones'];
dataSource: MatTableDataSource<Object>;
nombre:String;
rol:any;
activo:String;
usuario:String;
roles:any=[];
@ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;
  constructor(private usuarioService: UsuarioService,
    private fb: FormBuilder,
    public dialog: MatDialog) { 
      
    }

    openDialog(): void {
      const dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
        width: '250px',
        data: {nombre: this.nombre, rol: this.rol, activo:this.activo},
      });
  
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed',result);
        this.usuario = result;
       
      
      });
    }
  ngOnInit(): void {
    this.getUsuarios();
    this.filtroFormControls();
  }
  
  filtroFormControls(){
    this.filtroForm= this.fb.group({
      nombre:[''],
    })
  }
getUsuarios()
{
this.usuarioService.getUsuarios().subscribe(res=>{
  console.log(res);
this.usuarios=res;
  this.dataSource = new MatTableDataSource(this.usuarios);
 
  this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
});
}

resetFilters(){
  this.filtroForm.get('nombre').reset();
}
buscarFiltros(){
  let nombre= this.filtroForm.value.nombre;

  this.usuarioService.getUsuarioNombre(nombre).subscribe(
    res=>{console.log(res)}
  );
}
}
@Component({

  styleUrls: ['./index.component.scss'],
  template: `<h1 mat-dialog-title>Crear Usuario</h1>
  <div mat-dialog-content>
   
     
        <label>Nombre</label>
        <input type="text" [(ngModel)]="data.nombre" placeholder="Ex. Pizza" >
      
      <h4>Estado del usuario</h4>
         
            <label>¿Está activo?</label>
            <select [(ngModel)]="data.activo" required>
              <option value="S">Sí</option>
              <option value="N">No</option>
            </select>

           
         
            <label>Rol del usuario</label>
            <select  [(ngModel)]="data.rol" required>
              <option  value="1">Administrador</option>
              <option  value="2">Auxiliar</option>
              <option  value="3">Auditor</option>
                          </select>
         
  </div>
  <div mat-dialog-actions>
    <button mat-button (click)="onNoClick()">Cancelar</button>
    <button mat-button [mat-dialog-close]="data"  cdkFocusInitial>Crear</button>
  </div>`
  
})
export class DialogOverviewExampleDialog {
  constructor(
    private usuarioService: UsuarioService,
    public dialogRef: MatDialogRef<DialogOverviewExampleDialog>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
 
}
