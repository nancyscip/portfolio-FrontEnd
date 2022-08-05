import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EastereggComponent } from './components/easteregg/easteregg.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { LogoApComponent } from './components/logo-ap/logo-ap.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'easteregg', component: EastereggComponent}
]

@NgModule({
  exports: [RouterModule]
})
export class AppRoutingModule { }
