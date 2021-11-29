import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
const API_URL="http://localhost:8888/api/"
@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http :HttpClient) { }

    getUsuarios(){
      return this.http.get(API_URL+ "users/all");
    }
    getUsuarioNombre(nombre:string){
      return this.http.get(API_URL+ `users/name/${nombre}`);
    }
}
