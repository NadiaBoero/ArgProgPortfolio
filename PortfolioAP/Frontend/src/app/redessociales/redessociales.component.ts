import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { TokenService } from '../servicio/token.service';

@Component({
  selector: 'app-redessociales',
  templateUrl: './redessociales.component.html',
  styleUrls: ['./redessociales.component.css']
})
export class RedessocialesComponent implements OnInit {
  isLogged = false;
  constructor(private router : Router, private tokenService: TokenService) { }

  ngOnInit(): void {
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  onLogout():void{
    this.tokenService.logOut();
    window.location.reload();
  }

  login(){
    this.router.navigate(['/login'])
  }

}

