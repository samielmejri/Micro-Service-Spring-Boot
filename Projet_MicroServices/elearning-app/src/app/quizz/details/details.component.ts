import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Quiz} from "../../shared/quizz";
import {RestApiService} from "../../shared/rest-api.service";

@Component({
    selector: 'app-details',
    templateUrl: './details.component.html',
    styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
    id = 0;
    quiz: Quiz = {} as Quiz;

    constructor(private activatedRoute: ActivatedRoute, private restApi: RestApiService) {
    }

    loadQuizz() {
        return this.restApi.getById<Quiz>("/quiz", this.id).subscribe(e => this.quiz = e);

    }

    getQuizId() {
        this.activatedRoute.params.subscribe(p => {
                this.id = +p['id']
            }
        )
    }

    ngOnInit(): void {
        this.getQuizId();
        this.loadQuizz();
    }

    submitTentative() {

    }
}
