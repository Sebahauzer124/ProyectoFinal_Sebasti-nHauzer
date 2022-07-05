import { Component, OnInit } from '@angular/core';
import { Experiencia } from 'src/app/Model/experiencia.model';

import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { ExperienciaService } from 'src/app/Servicios/experiencia.service';

@Component({
  selector: 'app-elab',
  templateUrl: './elab.component.html',
  styleUrls: ['./elab.component.css']
})
export class ElabComponent implements OnInit {


    public experiencia:Experiencia[]=[];
     public editExperiencia:Experiencia| undefined;
    public  deleteExperiencia:Experiencia|undefined;
  
    constructor(private experienciaService: ExperienciaService) { }
  
    ngOnInit(): void {
      this.getExperiencia();
    }
  public getExperiencia():void{
  this.experienciaService.getExperiencia().subscribe({
    next: (response:Experiencia[])=>{
      this.experiencia=response;
    },
    
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
    }
  })
  }
  public onOpenModal(mode:String, experiencia?: Experiencia):void{
    const container=document.getElementById('main-container');
    const button=document.createElement('button');
    button.style.display='none';
    button.setAttribute('data-toggle','modal');
    if(mode==='add'){
      button.setAttribute('data-target','#addExperienciaModal');}
      else if (mode==='delete'){
        this.deleteExperiencia=experiencia;
        button.setAttribute('data-target','#deleteExperienciaModal');
      }else if (mode==='edit'){
        this.editExperiencia=experiencia;
        button.setAttribute('data-target','#editExperienciaModal');
      }
      
      container?.appendChild(button);
    button.click();
  
    }
    
    public onAddExperiencia(addForm:NgForm):void{
      document.getElementById('add-experiencia-form')?.click();
      this.experienciaService.addExperiencia(addForm.value).subscribe({
        next:(response:Experiencia)=>{
          
        console.log(response);
        this.getExperiencia();
        addForm.resetForm();
        },
        error:(error:HttpErrorResponse)=>{
          alert(error.message);
          addForm.reset();
        }
        })
  
    }
    public onUpdateExperiencia(experiencia:Experiencia){
      this.editExperiencia=experiencia;
      document.getElementById('add-experiencia-form')?.click();
      this.experienciaService.editExperiencia(experiencia).subscribe({
        next:(response:Experiencia)=>{
          
        console.log(response);
        this.getExperiencia();
       
        },
        error:(error:HttpErrorResponse)=>{
          alert(error.message);
        
        }
  
        })
  
    }
  
    public onDeleteExperiencia(idExp:number):void{
      
      this.experienciaService.deleteExperiencia(idExp).subscribe({
        next:(response:void)=>{
          
        console.log(response);
        this.getExperiencia();
       
        },
        error:(error:HttpErrorResponse)=>{
          alert(error.message);
        
        }
  
        })
  
    }
  }


