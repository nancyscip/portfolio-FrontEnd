import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { BannerComponent } from './components/banner/banner.component';
import { AcercadeComponent } from './components/acercade/acercade.component';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
import { EducacionComponent } from './components/educacion/educacion.component';
import { HardysoftComponent } from './components/hardysoft/hardysoft.component';
import { LogoApComponent } from './components/logo-ap/logo-ap.component';
import { ProyectosComponent } from './components/proyectos/proyectos.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { PersonaService } from './service/persona.service';
import { HomeComponent } from './components/home/home.component';
import { EastereggComponent } from './components/easter-egg/easter-egg.component';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    BannerComponent,
    AcercadeComponent,
    ExperienciaComponent,
    EducacionComponent,
    HardysoftComponent,
    LogoApComponent,
    ProyectosComponent,
    LoginComponent,
    HomeComponent,
    EastereggComponent,
  ],
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    NgCircleProgressModule.forRoot({}),
    HttpClientModule, 
    FormsModule,
 
  
  ],
  providers: [
  PersonaService],
 
  bootstrap: [AppComponent]
})
export class AppModule { }


imports: [
    
]


 