import { Component, OnInit } from '@angular/core';
import { RestApiService } from 'app/shared/rest-api.service';

@Component({
  selector: 'app-cours',
  templateUrl: './cours.component.html',
  styleUrls: ['./cours.component.css'],
})
export class CoursComponent implements OnInit {
  cours: any = [];

  loadCours() {
    return this.restApi.get('/cours/coursall').subscribe((data: {}) => {
      this.cours = data;
    });
  }

  constructor(public restApi: RestApiService) {}

  ngOnInit(): void {
    this.loadCours();
  }
}


