import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RestApiService } from 'app/shared/rest-api.service';

@Component({
  selector: 'app-forum-detail',
  templateUrl: './forum-detail.component.html',
  styleUrls: ['./forum-detail.component.css']
})
export class ForumDetailComponent implements OnInit {

  forumId: number | undefined;
  forum: any;
  posts: any ;
  newPost: string = '';
  title: any;
  content:any;
  username:any;

  constructor(private route: ActivatedRoute, private restApiService: RestApiService) {}

  addPost(){
    this.restApiService.addPost({title:this.title,content:this.content,username:this.username}).subscribe(
      res => console.log
    )
  }
  ngOnInit(): void {
    
    this.route.params.subscribe(params => {
     
      this.forumId = +params['id'];

      // Fetch comments using the service
      this.restApiService.getAllPostsByFormId(this.forumId).subscribe(
       
        posts => {
          console.log(posts)
          this.posts = posts;
        },
        error => {
          console.error('Error fetching posts:', error);
        }
      );
      this.restApiService.getForumById(this.forumId).subscribe(
        forum => {
          console.log(forum)
          this.forum = forum;
        },
        error => {
          console.error('Error fetching posts:', error);
        }
      );


    });
 
  }



}
