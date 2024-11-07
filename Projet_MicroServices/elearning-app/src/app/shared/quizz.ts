export interface Quiz {
    id: number;
    nom: string;
    description: string;
    duree: string;
    questions: Question[];
    tentatives: Tentative[];

}

export interface Question {
    id: number;
    text: string;
    point: number;
    choix_multiple: boolean;
    quizz_id: number;
    options: Option[];
}

export interface Option {
    id: number;
    text: string;
    is_correct: boolean;
    question_id: number;
}

export interface Tentative {
    id: number;
    date_fin: string;
    score: number;
    date_debut: string;
    quizz_id: number;
}
