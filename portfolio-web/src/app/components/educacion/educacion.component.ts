import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, NgForm } from '@angular/forms';
import { TokenService } from 'src/app/service/token.service';
import { Estudios } from '../../interface/educacion.interface';
import { EstudiosService } from '../../service/educacion.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  public estudios!: Estudios[];
  public editEstudios!: Estudios;
  public deleteEstudios!: Estudios;
  roles: string[] = [];
  isAdmin: boolean = false;
  
  name = new FormControl('');

  constructor(private estudiosService: EstudiosService,
    private tokenService: TokenService
    ) { }

  ngOnInit() {
    this.getEstudios();
    this.roles = this.tokenService.getAuthorities();
    this.roles.forEach( role => {
      if(role === 'ROLE_ADMIN') {
        this.isAdmin = true;
      }
    })
  }

  public getEstudios(): void {
    this.estudiosService.getEstudios().subscribe(
      (response:Estudios[]) => {
        this.estudios = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddEstudios(addForm: NgForm):void {
    document.getElementById('add-estudios-modal')?.click();
    this.estudiosService.addEstudios(addForm.value).subscribe(
      (response: Estudios) => {
        console.log(response);
        this.getEstudios();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    )
    
  }

  public onUpdateEstudio(estudio: Estudios):void {
      this.estudiosService.updateEstudios(estudio).subscribe(
      (response: Estudios) => {
        console.log(response);
        this.getEstudios();
        
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
    
  }

  public onDeleteEstudios(id: number):void {
    this.estudiosService.deleteEstudios(id).subscribe(
    (response: void) => {
      console.log(response);
      this.getEstudios();
      
    },
    (error: HttpErrorResponse) => {
      console.log(error.message);
    }
  )
  
}

  public onOpenModal(estudios: Estudios, mode: string): void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEstudiosModal');
    }
    if (mode === 'edit') {
      this.editEstudios = estudios;
      button.setAttribute('data-target', '#updateEstudiosModal');
    }
    if (mode === 'delete') {
      this.deleteEstudios = estudios;
      button.setAttribute('data-target', '#deleteEstudiosModal');
    }
    container?.appendChild(button);
    button.click();
  }
}