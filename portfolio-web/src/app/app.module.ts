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
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { createPopper } from '@popperjs/core/lib/popper-lite.js';
import { LoginComponent } from './components/login/login.component';
import { LoginService} from './login.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';


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
  ],
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    NgCircleProgressModule.forRoot({}),
    HttpClientModule, 
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }


imports: [
    
]


 