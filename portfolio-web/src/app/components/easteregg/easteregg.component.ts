import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-easteregg',
  templateUrl: './easteregg.component.html',
  styleUrls: ['./easteregg.component.css']
})
export class EastereggComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
easteregg(){
  this.router.navigate(['/easteregg'])
}
}
