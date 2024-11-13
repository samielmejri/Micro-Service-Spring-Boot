import { Component, OnInit } from '@angular/core';
import { RestApiService } from 'app/shared/rest-api.service';

@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {

  forums: any = [];
  titre: any;
  description:any;

  loadForum() {
    
    this.restApi.get("/forum/getForums").subscribe((data: {}) => {
      console.log(data,"string forum data")
      this.forums = data;
    });
  }

  constructor(public restApi: RestApiService) { }
 
  addForum(){
    console.log(this.titre)
    console.log(this.description)
    this.restApi.add("/forum/addForum", {titre:this.titre ,description:this.description}).subscribe(
      res =>  console.log(res)
    )
  }
  ngOnInit(): void {
    this.loadForum();

  }

}
