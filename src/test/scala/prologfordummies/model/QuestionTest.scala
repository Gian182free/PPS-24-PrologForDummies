package prologfordummies.model

import org.scalatest.funsuite.AnyFunSuite

class QuestionTest extends AnyFunSuite{
  test("Question deve salvare i valori correttamente") {
    val question = Question(
        id = 1,
        question = "Quanto fa 2 + 2?",
        correctAnswer = "4",
        answers = List("2", "3", "4")
    )

    assert(question.id == 1)
    assert(question.question == "Quanto fa 2 + 2?")
    assert(question.correctAnswer == "4")
    assert(question.answers == List("2", "3", "4"))
  }

  test("isCorrect dovrebbe restituire vero per la risposta corretta") {
    val question = Question(1, "Quanto fa 2 + 2?", "4", List("2", "3", "4"))
    assert(question.isCorrect("4"))
  }
  test("isCorrect dovrebbe restituire falso per la risposta sbagliata") {
    val question = Question(1, "Qual è la capitale della Francia?", "Parigi", List("Roma", "Berlino", "Parigi"))
    assert(!question.isCorrect("Rome"))
  }
  
  test("La lista delle risposte deve contenere la risposta corretta") {
    val question = Question(1, "Qual è la capitale d'Italia?", "Roma", List("Roma", "Milano", "Napoli"))
    assert(question.answers.contains(question.correctAnswer))
  }

  
}
