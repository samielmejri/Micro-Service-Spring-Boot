import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RestApiService } from 'app/shared/rest-api.service';

@Component({
  selector: 'app-course-detail',
  templateUrl: './course-detail.component.html',
  styleUrls: ['./course-detail.component.css']
})
export class CourseDetailComponent implements OnInit {
  courseId: number | undefined;
  course: any;
  comments: string[] = [];
  newComment: string = '';

  constructor(private route: ActivatedRoute, private restApiService: RestApiService) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.courseId = +params['id'];

      // Fetch comments using the service
      this.restApiService.getAllComments().subscribe(
        comments => {
          this.comments = comments;
        },
        error => {
          console.error('Error fetching comments:', error);
        }
      );

      // TODO: Fetch course details based on courseId (if needed)
      // For simplicity, you can use a service to retrieve data from a backend or mock data
      this.course = { title: 'Course Title', description: 'course Description' };
    });
  }

  addComment() {
    // Implement the logic to add a comment if needed
  }
}
