export class Persona{
    id?:number;
    apellido:String;
    img:String;
    nombre:String;

constructor(apellido:String, img:String, nombre:String){
  
    this.apellido=apellido;
    this.img=img;
     this.nombre=nombre;
}
}