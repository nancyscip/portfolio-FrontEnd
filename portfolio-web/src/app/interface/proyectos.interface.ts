import { Persona } from "../interface/persona.interface";

export interface Proyecto {
    id: number;
    nombre: string;
    descripcion: string;
    fecha: string;
    img: string;
    github: string;
    proyecto: string;
    persona: Persona;
}