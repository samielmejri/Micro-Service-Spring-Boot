import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {QuizzRoutingModule} from './quizz-routing.module';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {QuizComponent} from "./quiz/quiz.component";
import { DetailsComponent } from './details/details.component';


@NgModule({
    declarations: [
        QuizComponent,
        DetailsComponent
    ],
    imports: [
        HttpClientModule,
        FormsModule,
        CommonModule,
        QuizzRoutingModule
    ]
})
export class QuizzModule {
}
