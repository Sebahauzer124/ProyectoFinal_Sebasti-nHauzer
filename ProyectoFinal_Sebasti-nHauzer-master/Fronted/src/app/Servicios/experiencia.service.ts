import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core';
import{Observable} from 'rxjs';
import {Experiencia} from '../Model/experiencia.model';

@Injectable({
  providedIn: 'root'
})
export class ExperienciaService {
  URL='http://localhost:8080/experiencia/'
  constructor(private http:HttpClient) { }

  public getExperiencia(): Observable<Experiencia[]>{
  return this.http.get<Experiencia[]>(this.URL+'all');
  }
  public addExperiencia(experiencia:Experiencia): Observable<Experiencia>{
    return this.http.post<Experiencia>(this.URL+'add',experiencia);
  }
  public editExperiencia(experiencia:Experiencia): Observable<Experiencia>{
    return this.http.put<Experiencia>(this.URL+'update',experiencia);
  }
  /* por que tiene que ser del tipo void y no Educacion*/
  public deleteExperiencia(idExp:number): Observable<void>{
    return this.http.delete<void>(this.URL+'delete/${idExp');
  }
}