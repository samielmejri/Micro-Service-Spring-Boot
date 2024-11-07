import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RestApiService } from 'app/shared/rest-api.service';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {
 
  postId: any | undefined;
  post: any;
  comments: any ;
  newComment: string = '';

  constructor(private route: ActivatedRoute, private restApiService: RestApiService) {}

  ngOnInit(): void {
    
    this.route.params.subscribe(params => {
     
      this.postId = params['id'];

      // Fetch comments using the service
      this.restApiService.getAllCommentsByPostId(this.postId).subscribe(
       
        comments => {
          console.log(comments,"comment")
          this.comments = comments;
        },
        error => {
          console.error('Error fetching comments:', error);
        }
      );
      this.restApiService.getPostById(this.postId).subscribe(
        post => {
          console.log(post, "post")
          this.post = this.post;
        },
        error => {
          console.error('Error fetching posts:', error);
        }
      );


    });
  }



}