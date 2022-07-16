import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/interface/persona.interface';
import { PersonaService } from 'src/app/service/persona.service';



@Component({
  selector: 'app-acercade',
  templateUrl: './acercade.component.html',
  styleUrls: ['./acercade.component.css'],
})
export class AcercadeComponent implements OnInit{
  public personas!: Persona[];

  constructor(private personaService: PersonaService){}

  ngOnInit() {
    this.getPersonas();
  }

public getPersonas(): void{
  this.personaService.getPersonas().subscribe(
(response: Persona[]) =>{
  this.personas = response;
},
(error: HttpErrorResponse) =>{
  alert(error.message);
}
);
}
}