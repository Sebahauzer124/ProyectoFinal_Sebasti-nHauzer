import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core';
import{Observable} from 'rxjs';
import { Educacion } from '../Model/educacion.model';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {
  URL='http://localhost:8080/educacion/'
  constructor(private http:HttpClient) { }

  public getEducacion(): Observable<Educacion[]>{
  return this.http.get<Educacion[]>(this.URL+'traer');
  }
  public addEducacion(educacion:Educacion): Observable<Educacion>{
    return this.http.post<Educacion>(this.URL+'crear',educacion);
  }
  public editEducacion(educacion:Educacion): Observable<Educacion>{
    return this.http.put<Educacion>(this.URL+'editar/${idEdu}',educacion);
  }
  /* por que tiene que ser del tipo void y no Educacion*/
  public deleteEducacion(idEdu:number): Observable<void>{
    return this.http.delete<void>(this.URL+'borrar/${idEdu}');
  }
}