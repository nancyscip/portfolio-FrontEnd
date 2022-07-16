export class Persona {
    id: number;
    nombre: String;
    apellido: String;
    titulo: String;
    domicilio: String;
    telefono: String;
    correo: String;
    sobre_mi: String;
    img: String;



constructor(id: number, nombre: String, apellido: String, titulo: String, domicilio: String, telefono: String, correo: String, sobre_mi: String, img: String)
   {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.titulo = titulo;
    this.domicilio = domicilio;
    this.telefono = telefono;
    this.correo = correo;
    this.sobre_mi = sobre_mi;
    this.img = img;
    


   }

}