import { Component, OnInit } from '@angular/core';
import { Educacion } from 'src/app/Model/educacion.model';
import { EducacionService } from 'src/app/Servicios/educacion.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  public educacion:Educacion[]=[];
   public editEducation:Educacion| undefined;
  public  deleteEducation:Educacion|undefined;

  constructor(private educationService: EducacionService) { }

  ngOnInit(): void {
    this.getEducation();
  }
public getEducation():void{
this.educationService.getEducacion().subscribe({
  next: (response:Educacion[])=>{
    this.educacion=response;
  },
  
  error:(error:HttpErrorResponse)=>{
    alert(error.message);
  }
})
}
public onOpenModal(mode:String, educacion?: Educacion):void{
  const container=document.getElementById('main-container');
  const button=document.createElement('button');
  button.style.display='none';
  button.setAttribute('data-toggle','modal');
  if(mode==='add'){
    button.setAttribute('data-target','#addEducationModal');}
    else if (mode==='delete'){
      this.deleteEducation=educacion;
      button.setAttribute('data-target','#deleteEducationModal');
    }else if (mode==='edit'){
      this.editEducation=educacion;
      button.setAttribute('data-target','#editEducationModal');
    }
    
    container?.appendChild(button);
  button.click();

  }
  
  public onAddEducation(addForm:NgForm):void{
    document.getElementById('add-education-form')?.click();
    this.educationService.addEducacion(addForm.value).subscribe({
      next:(response:Educacion)=>{
        
      console.log(response);
      this.getEducation();
      addForm.resetForm();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
      }
      })

  }
  public onUpdateEducation(educacion:Educacion){
    this.editEducation=educacion;
    document.getElementById('add-education-form')?.click();
    this.educationService.editEducacion(educacion).subscribe({
      next:(response:Educacion)=>{
        
      console.log(response);
      this.getEducation();
     
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      
      }

      })

  }

  public onDeleteEducation(idEdu:number):void{
    
    this.educationService.deleteEducacion(idEdu).subscribe({
      next:(response:void)=>{
        
      console.log(response);
      this.getEducation();
     
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      
      }

      })

  }
}

