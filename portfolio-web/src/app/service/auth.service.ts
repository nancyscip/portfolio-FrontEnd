import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { JwtDTO } from '../interface/jwt-dto';
import { LoginUsuario } from '../interface/login-usuario';
import { NuevoUsuario } from '../interface/nuevo-usuario';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  url = environment.apiAuthUrl;;



  constructor(private httpClient: HttpClient) { }

  public nuevo(nuevoUsuario: NuevoUsuario): Observable<any>{
    return this.httpClient.post<any>(this.url + 'nuevo', nuevoUsuario);
    
  }

  public login(loginUsuario: LoginUsuario): Observable<JwtDTO>{
    return this.httpClient.post<JwtDTO>(this.url + 'login', loginUsuario);
    
  }
}
