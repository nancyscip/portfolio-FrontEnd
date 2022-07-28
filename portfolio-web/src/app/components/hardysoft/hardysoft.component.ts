import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { SkillService } from 'src/app/service/hardysoft.service';
import { TokenService } from 'src/app/service/token.service';
import { Skill } from '../../interface/hardysoft.interface';
import { CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-hardysoft',
  templateUrl: './hardysoft.component.html',
  styleUrls: ['./hardysoft.component.css']
})
export class HardysoftComponent implements OnInit {

  public skills!: Skill[];
  public editSkill!: Skill;
  public deleteSkill!: Skill;
  roles: string[] = [];
  isAdmin = false;

  constructor(
    private skillService: SkillService,
    private tokenService: TokenService
  ) { }

  isloged = () => this.tokenService.loggedIn();

  ngOnInit(): void {
    this.getSkills();

    this.roles = this.tokenService.getAuthorities();
    this.roles.forEach(role => {
      if (role === 'ROLE_ADMIN') {
        this.isAdmin = true;
      }
    });
  }

  public getSkills(): void {
    this.skillService.getSkills().subscribe({
      next: (response: Skill[]) =>{
        this.skills = response;
      },
      error: (error: HttpErrorResponse) =>{
        alert(error.message);
      }
  });
  }

  public onAddSkill(addForm: NgForm): void {
    document.getElementById("add-skill-form")!.click();
    this.skillService.addSkill(addForm.value).subscribe({
      next: (response: Skill) => {
        console.log(response);
        this.getSkills();
        addForm.reset();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    });
  }

  public onEditSkill(skill: Skill): void {
    this.skillService.updateSkill(skill).subscribe({
      next: (response: Skill) => {
        console.log(response);
        this.getSkills();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }

  public onDeleteSkill(skillId: number): void {
    this.skillService.deleteSkill(skillId).subscribe({
      next: (response: void) => {
        console.log(response);
        this.getSkills();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }

  public onOpenModal(skill: Skill, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none'
    button.setAttribute('data-bs-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-bs-target', '#addSkillModal');
    }
    if (mode === 'edit') {
      this.editSkill = skill;
      button.setAttribute('data-bs-target', '#editSkillModal');
    }
    if (mode === 'delete') {
      this.deleteSkill = skill;
      button.setAttribute('data-bs-target', '#deleteSkillModal');
    }
    container?.appendChild(button);
    button.click();
  }


}