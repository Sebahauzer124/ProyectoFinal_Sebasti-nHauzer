import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import{Observable} from 'rxjs';
import {Experiencia} from '../Model/experiencia.model';
import { Skill } from '../Model/skill.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SkillService {
 private apiServerUrl=environment.apiBaseUrl;
  constructor(private http:HttpClient) { }

  public getSkill(): Observable<Skill[]>{
  return this.http.get<Skill[]>(`$(this.apiServerUrl)/all`);
  }
  public addSkill(skill:Skill): Observable<Skill>{
    return this.http.post<Skill>(`$(this.apiServerUrl)/skill/add`,skill);
  }
  public editSkill(skill:Skill): Observable<Skill>{
    return this.http.put<Skill>(`$(this.apiServerUrl)/skill/edit`,skill);
  }
  /* por que tiene que ser del tipo void y no Educacion*/
  public deleteSkill(idSkill:number): Observable<void>{
    return this.http.delete<void>(`$(this.apiServerUrl)/skill/delete/${idSkill}`);
  }
}

