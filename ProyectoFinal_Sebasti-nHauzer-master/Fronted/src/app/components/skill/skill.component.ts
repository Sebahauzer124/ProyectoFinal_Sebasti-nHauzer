import { Component, OnInit } from '@angular/core';
import { Skill } from 'src/app/Model/skill.model';
import { SkillService } from 'src/app/Servicios/skill.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-skill',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.css']
})
export class SkillComponent implements OnInit {
  public skill:Skill[]=[];
   public editSkill:Skill| undefined;
  public  deleteSkill:Skill|undefined;
  constructor(private skillService: SkillService) { }

  ngOnInit(): void {
    this.getSkill();}


public getSkill():void{
  this.skillService.getSkill().subscribe({
    next: (response:Skill[])=>{
      this.skill=response;
    },
    
    error:(error:HttpErrorResponse)=>{
      alert(error.message);
    }
  })
  }
  public onOpenModal(mode:String, skill?: Skill):void{
    const container=document.getElementById('main-container');
    const button=document.createElement('button');
    button.style.display='none';
    button.setAttribute('data-toggle','modal');
    if(mode==='add'){
      button.setAttribute('data-target','#addSkillModal');}
      else if (mode==='delete'){
        this.deleteSkill=skill;
        button.setAttribute('data-target','#deleteSkillModal');
      }else if (mode==='edit'){
        this.editSkill=skill;
        button.setAttribute('data-target','#editSkillModal');
      }
      
      container?.appendChild(button);
    button.click();
  
    }
    
    public onAddSkill(addForm:NgForm):void{
      document.getElementById('add-skill-form')?.click();
      this.skillService.addSkill(addForm.value).subscribe({
        next:(response:Skill)=>{
          
        console.log(response);
        this.getSkill();
        addForm.resetForm();
        },
        error:(error:HttpErrorResponse)=>{
          alert(error.message);
          addForm.reset();
        }
        })
  
    }
    public onUpdateSkill(skill:Skill){
      this.editSkill=skill;
      document.getElementById('add-skill-form')?.click();
      this.skillService.editSkill(skill).subscribe({
        next:(response:Skill)=>{
          
        console.log(response);
        this.getSkill();
       
        },
        error:(error:HttpErrorResponse)=>{
          alert(error.message);
        
        }
  
        })
  
    }
  
    public onDeleteSkill(idSkill:number):void{
      
      this.skillService.deleteSkill(idSkill).subscribe({
        next:(response:void)=>{
          
        console.log(response);
        this.getSkill();
       
        },
        error:(error:HttpErrorResponse)=>{
          alert(error.message);
        
        }
  
        })
  
    }
  
}
  
