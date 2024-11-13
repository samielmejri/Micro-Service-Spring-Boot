import {Component, OnInit} from '@angular/core';
import {Quiz} from "../../shared/quizz";
import {RestApiService} from "../../shared/rest-api.service";
import {Router} from '@angular/router';

@Component({
    selector: 'app-quiz',
    templateUrl: './quiz.component.html',
    styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

    quizzes: Quiz[] = [];

    loadQuizz() {
        return this.restApi.get<Quiz>("/quiz/").subscribe((data) => {
            console.log(data)
            this.quizzes = data;
        })
    }

    deleteQuiz(id: number) {
        return this.restApi.delete<Quiz>("/quiz", id).subscribe(e => e);
    }

    async goToDetails(id: number) {
        await this.route.navigate(["details", id]);
    }

    constructor(public restApi: RestApiService, private route: Router) {
    }

    ngOnInit(): void {
        this.loadQuizz()

    }


}
