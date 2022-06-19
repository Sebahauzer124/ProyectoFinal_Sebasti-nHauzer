import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/Model/persona.model';
import { PersonaService } from 'src/app/Servicios/persona.service';
@Component({
  selector: 'app-acercade',
  templateUrl: './acercade.component.html',
  styleUrls: ['./acercade.component.css']
})
export class AcercadeComponent implements OnInit {
persona: Persona = new Persona("","","","","");
  constructor(public personaService:PersonaService) { }

  ngOnInit(): void {
    this.personaService.getPersona().subscribe(data=> (this.persona=data))
  }

}
