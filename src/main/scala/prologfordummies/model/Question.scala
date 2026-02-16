package prologfordummies.model

case class Question(
    id: Int,
    question: String,
    correctAnswer: String,
    answers: List[String]
):
    def isCorrect(answer: String): Boolean =
        answer == correctAnswer

object Question:
    def create(
        id: Int,
        question: String,
        correctAnswer: String,
        answers: List[String]
    ): Either[String, Question] =
        if question.isEmpty then Left("Question cannot be empty")
        else if answers.isEmpty then Left("Answer list cannot be empty")
        else if !answers.contains(correctAnswer) then Left("Correct answer must be in the list")
        else Right(Question(id, question, correctAnswer, answers))

    

