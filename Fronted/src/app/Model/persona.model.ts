export class Persona{
    id?:number;
    apellido:String;
    img:String;
    nombre:String;
    acercaDe:String;
    titulo:String;

constructor(apellido:String, img:String, nombre:String, acercaDe:String,titulo:String){
  
    this.apellido=apellido;
    this.img=img;
     this.nombre=nombre;
     this.acercaDe=acercaDe;
     this.titulo=titulo;
}
}