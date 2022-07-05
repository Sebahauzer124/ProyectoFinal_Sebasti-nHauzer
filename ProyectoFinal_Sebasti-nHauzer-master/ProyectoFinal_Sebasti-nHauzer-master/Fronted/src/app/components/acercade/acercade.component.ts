import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/Model/persona.model';
import { PersonaService } from 'src/app/Servicios/persona.service';
@Component({
  selector: 'app-acercade',
  templateUrl: './acercade.component.html',
  styleUrls: ['./acercade.component.css']
})
export class AcercadeComponent implements OnInit {
persona:any;
  constructor(public personaService:PersonaService) { }

  ngOnInit(): void {
    this.personaService.getPersona().subscribe(data=>{
      console.log("Datos personales" + JSON.stringify(data));
      this.persona = data;
    }); 

    
  }
public getPersona(){
  this.personaService.getPersona().subscribe({
    next:(response:Persona)=>{
      this.persona=response;
    },
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
    }
  })
}
}
