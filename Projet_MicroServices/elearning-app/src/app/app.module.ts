import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router'; // Ajout de l'import pour le routage
import { HttpClientModule } from '@angular/common/http';
import {QuizzModule} from "./quizz/quizz.module";
import {QuizzRoutingModule} from "./quizz/quizz-routing.module";
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CoursComponent } from './cours/cours.component';
import { PostsComponent } from './posts/posts.component';
import { EventsComponent } from './events/events.component';
import { ForumComponent } from './forum/forum.component';
import { CourseDetailComponent } from './course-detail/course-detail.component';
import { FormsModule } from '@angular/forms';
import { ForumDetailComponent } from './forum-detail/forum-detail.component';
import { CommentsComponent } from './comments/comments.component';

const routes: Routes = [
  { path: '', component: NavbarComponent },
  { path: 'cours', component: CoursComponent },
  { path: 'posts', component: PostsComponent },
  { path: 'events', component: EventsComponent },
  {path:   'quiz',  loadChildren: () => import('./quizz/quizz.module').then(m => m.QuizzModule)},
  { path: 'forum', component: ForumComponent },
  { path: 'comment/:id', component: CommentsComponent },
  { path: 'cours/:id', component: CourseDetailComponent },
  { path: 'forum/:id', component: ForumDetailComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CoursComponent,
    PostsComponent,
    EventsComponent,
    ForumComponent,
    CourseDetailComponent,
    ForumDetailComponent,
    CommentsComponent,
  ],
  imports: [FormsModule,QuizzRoutingModule, QuizzModule, HttpClientModule, BrowserModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {
}
