import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/interface/persona.interface';
import { PersonaService } from 'src/app/service/persona.service';
import { FormControl, NgForm } from '@angular/forms';
import { TokenService } from 'src/app/service/token.service';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-acercade',
  templateUrl: './acercade.component.html',
  styleUrls: ['./acercade.component.css'],
})
export class AcercadeComponent implements OnInit{
  public personas: Persona[] = []; 
  public editPersona: Persona | undefined;
  public deletePersona!: Persona;
  roles!: string[];
  isAdmin: boolean = false;

  name = new FormControl('');

  constructor(private personaService: PersonaService,
  private tokenService: TokenService
  ){}

  ngOnInit() {
    this.getPersonas();
    this.roles = this.tokenService.getAuthorities();
    this.roles.forEach(role => {
      if (role === 'ROLE_ADMIN') {
        this.isAdmin = true;
      }
    });
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
public onEditPersona(persona: Persona):void {
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

public onDeletePersona(personaId: number):void {
this.personaService.deletePersona(personaId).subscribe(
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
  button.setAttribute('data-target', '#updatePersonaModal');
}
if (mode === 'delete'){
  this.deletePersona = persona;
  button.setAttribute('data-target', '#deletePersonaModal');
}
container?.appendChild(button);
button.click();
}
}
