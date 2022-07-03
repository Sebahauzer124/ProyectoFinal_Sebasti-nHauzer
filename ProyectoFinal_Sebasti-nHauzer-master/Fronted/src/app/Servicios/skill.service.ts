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
  URL='http://localhost:8080/skill/'
  constructor(private http:HttpClient) { }

  public getSkill(): Observable<Skill[]>{
  return this.http.get<Skill[]>(this.URL+'all');
  }
  public addSkill(skill:Skill): Observable<Skill>{
    return this.http.post<Skill>(this.URL+'add',skill);
  }
  public editSkill(skill:Skill): Observable<Skill>{
    return this.http.put<Skill>(this.URL+'update',skill);
  }
  /* por que tiene que ser del tipo void y no Educacion*/
  public deleteSkill(idSkill:number): Observable<void>{
    return this.http.delete<void>(this.URL+'delete/${idSkill}');
  }
}

