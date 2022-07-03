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
  return this.http.get<Educacion[]>(this.URL+'all');
  }
  public addEducacion(educacion:Educacion): Observable<Educacion>{
    return this.http.post<Educacion>(this.URL+'add',educacion);
  }
  public editEducacion(educacion:Educacion): Observable<Educacion>{
    return this.http.put<Educacion>(this.URL+'update',educacion);
  }
  /* por que tiene que ser del tipo void y no Educacion*/
  public deleteEducacion(idEdu:number): Observable<void>{
    return this.http.delete<void>(this.URL+'delete/${idEdu}');
  }
}