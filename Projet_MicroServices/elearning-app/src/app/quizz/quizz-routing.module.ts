import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {QuizComponent} from "./quiz/quiz.component";
import {DetailsComponent} from "./details/details.component";

const routes: Routes = [
    {path: '', component: QuizComponent},
    {path: 'details/:id', component: DetailsComponent}
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class QuizzRoutingModule {
}
