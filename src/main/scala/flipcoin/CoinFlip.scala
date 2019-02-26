package flipcoin

import scala.annotation.tailrec
import scala.io.StdIn.readLine
import scala.util.Random

object CoinFlip extends App {

  val s = GameState(0, 0)
  val r = new Random()
  mainloop(s, r)

  @tailrec
  def mainloop(gameState: GameState, random: Random): Unit = {

    showPrompt

    val userInput = getUserInput

    userInput match {
      case "H" | "T" => {
        val coinTossResult = tossCoin(random)
        val newNumFlips = gameState.numFlips + 1

        (userInput == coinTossResult) match {

          case true => {
            val newCorrectGuesses = gameState.numCorrectGuesses + 1
            val newState = gameState.copy(newNumFlips, newCorrectGuesses)
            printGameState(printableResult(coinTossResult), newState)
            mainloop(newState, random)
          }

          case false => {
            val newState = gameState.copy(newNumFlips, gameState.numCorrectGuesses)
            printGameState(printableResult(coinTossResult), newState)
            mainloop(newState, random)
          }

        }
      }

      case _ => {
        printGameOver
        printGameState(gameState)
      }

    }
  }



  def showPrompt: Unit = {
    println("\n(H)eads, (T)ails, or (Q)uit: ")
  }

  def getUserInput = readLine.trim.toUpperCase

  def printableResult(flip: String) = {

    flip match {
      case "H" => "Heads"
      case "T" => "Tails"
    }
  }

  def printGameState(printableResult: String, gameState: GameState): Unit = {
    println(s"The result was $printableResult")
    printGameState(gameState)
  }

  def printGameState(gameState: GameState): Unit = {
    println(s"#Flips: ${gameState.numFlips}, #Correct: ${gameState.numCorrectGuesses}")
  }

  def printGameOver = println("\n===   GAME OVER   ===")

  def tossCoin(r: Random) = {

    val i = r.nextInt(2)

    i match {
      case 0 => "H"
      case 1 => "T"
    }
  }

}
