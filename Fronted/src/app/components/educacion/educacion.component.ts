import { Component, OnInit } from '@angular/core';
import { Educacion } from 'src/app/Model/educacion.model';
import { EducacionService } from 'src/app/Servicios/educacion.service';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  public educacion:Educacion[]=[];
  constructor(private educationService: EducacionService) { }

  ngOnInit(): void {
    this.getEducation();
  }
public getEducation():void{
this.educationService.getEducacion().subscribe({
  next: (Response:Educacion[])=>{
    this.educacion=Response;
  },
  
  error:(error:HttpErrorResponse)=>{
    alert(error.message);
  }
})
}
}
