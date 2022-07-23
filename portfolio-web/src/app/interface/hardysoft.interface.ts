import { Persona } from "../interface/persona.interface";

export interface Skills {
    id: number;
    skill: string;
    porcentaje: string;
    persona: Persona;
}