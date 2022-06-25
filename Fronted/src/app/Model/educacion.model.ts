export class Educacion{
    idEdu?:number;
    tituloEdu:string;
    fechaEdu:string;
    descEdu:string;
    imagenEdu:string;
    
    constructor(tituloEdu:string, fechaEdu:string, descEdu:string, imagenEdu:string){
  
        this.tituloEdu=tituloEdu;
        this.fechaEdu=fechaEdu;
         this.descEdu=descEdu;
         this.imagenEdu=imagenEdu;

    }
    }