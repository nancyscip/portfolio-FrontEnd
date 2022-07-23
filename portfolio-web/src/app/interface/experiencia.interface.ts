import { Persona } from "../interface/persona.interface";

export interface Experiencia {
    id: number;
    cargo: string;
    nombre_empresa: string;
    fecha_inicio: string;
    fecha_fin: string;
    es_trabajo_actual: boolean;
    descripcion: string;
    persona: Persona;
}