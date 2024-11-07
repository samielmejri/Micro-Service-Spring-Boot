import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

  posts = [
    {
      title: 'Post 1',
      author: 'John Doe',
      content: 'Content for Post 1'
    },
    {
      title: 'Post 2',
      author: 'Jane Smith',
      content: 'Content for Post 2'
    },
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
