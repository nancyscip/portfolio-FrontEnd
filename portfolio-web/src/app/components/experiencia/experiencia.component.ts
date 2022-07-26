import { Component, OnInit } from '@angular/core';
import { ExperienciaService } from 'src/app/service/experiencia.service';
import { Experiencia } from 'src/app/interface/experiencia.interface';
import { HttpErrorResponse } from '@angular/common/http';
import { TokenService } from 'src/app/service/token.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {

  public experiencias: Experiencia[] = [];
  public editExperiencia!: Experiencia;
  public deleteExperiencia!: Experiencia;
  roles: string[] = [];
  isAdmin = false;

  constructor(
    private experienciaService: ExperienciaService,
    private tokenService: TokenService
  ) { }

  ngOnInit(): void {
    this.getExperiencias();

    this.roles = this.tokenService.getAuthorities();
    this.roles.forEach(role => {
      if (role === 'ROLE_ADMIN') {
        this.isAdmin = true;
      }
    });
  }

  public getExperiencias(): void {
    this.experienciaService.getExperiencias().subscribe({
      next: (response: Experiencia[]) => {
        this.experiencias = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }

  public onAddExperiencia(addForm: NgForm): void {
    document.getElementById("add-experiencia-form")!.click();
    this.experienciaService.addExperiencia(addForm.value).subscribe({
      next: (response: Experiencia) => {
        console.log(response);
        this.getExperiencias();
        addForm.reset();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    });
  }

  public onEditExperiencia(experiencia: Experiencia): void {
    this.experienciaService.updateExperiencia(experiencia).subscribe({
      next: (response: Experiencia) => {
        console.log(response);
        this.getExperiencias();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }

  public onDeleteExperiencia(experienciaId: number): void {
    this.experienciaService.deleteExperiencia(experienciaId).subscribe({
      next: (response: void) => {
        console.log(response);
        this.getExperiencias();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }

  public onOpenModal(experiencia: Experiencia, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none'
    button.setAttribute('data-bs-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-bs-target', '#addExperienceModal');
    }
    if (mode === 'edit') {
      this.editExperiencia = experiencia;
      button.setAttribute('data-bs-target', '#editExperienceModal');
    }
    if (mode === 'delete') {
      this.deleteExperiencia = experiencia;
      button.setAttribute('data-bs-target', '#deleteExperienceModal');
    }
    container?.appendChild(button);
    button.click();
  }
}