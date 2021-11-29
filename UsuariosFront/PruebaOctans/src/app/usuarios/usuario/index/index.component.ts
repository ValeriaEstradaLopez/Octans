import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { UsuarioService } from '../../servicio/usuario.service';

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
@ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;
  constructor(private usuarioService: UsuarioService,
    private fb: FormBuilder) { }

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
