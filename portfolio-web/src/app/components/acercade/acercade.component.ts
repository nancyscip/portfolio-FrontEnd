import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/interface/persona.interface';
import { PersonaService } from 'src/app/service/persona.service';
import { NgForm } from '@angular/forms';



@Component({
  selector: 'app-acercade',
  templateUrl: './acercade.component.html',
  styleUrls: ['./acercade.component.css'],
})
export class AcercadeComponent implements OnInit{
  public personas!: Persona[]; 
  public editPersona!: Persona;
  public deletePersona!: Persona;


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
public onAddPersona(addForm: NgForm):void {
  document.getElementById('add-persona-modal')?.click();
  this.personaService.addPersona(addForm.value).subscribe(
    (response: Persona) => {
      console.log(response);
      this.getPersonas();
      addForm.reset();
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
      addForm.reset();
    }
  )
  
}
public onUpdatePersona(persona: Persona):void {
  this.personaService.updatePersona(persona).subscribe(
  (response: Persona) => {
    console.log(response);
    this.getPersonas();
    
  },
  (error: HttpErrorResponse) => {
    alert(error.message);
  }
)

}

public onDeletePersona(id: number):void {
this.personaService.deletePersona(id).subscribe(
(response: void) => {
  console.log(response);
  this.getPersonas();
  
},
(error: HttpErrorResponse) => {
  alert(error.message);
}
)

}

public onOpenModal(persona: Persona, mode: string): void {
  const container = document.getElementById('main-container');
  const button = document.createElement('button');
  button.type = 'button';
  button.style.display = 'none';
  button.setAttribute('data-toggle', 'modal');
  if (mode === 'add'){
    button.setAttribute('data-target', '#addPersonaModal');
  }
if (mode === 'edit'){
  this.editPersona = persona;
  button.setAttribute('data-target', '#editPersonaModal');
}
if (mode === 'delete'){
  this.deletePersona = persona;
  button.setAttribute('data-target', '#deletePersonaModal');
}
container?.appendChild(button);
button.click();
}
}
