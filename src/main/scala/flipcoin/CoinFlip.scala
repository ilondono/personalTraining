package flipcoin

import scala.annotation.tailrec
import scala.io.StdIn.readLine
import scala.util.Random

object CoinFlip extends App {

  val s = GameState(0, 0)
  val r = new Random()
  mainloop(s, r)

  //@tailrec TODO
  def mainloop(gameState: GameState, random: Random) = {

    showPrompt

    val userInput = getUserInput

    userInput match {
      case "H" | "T" => {
        val coinTossResult = tossCoin(random)
        val newNumFlips = gameState.numFlips + 1

        if (userInput == coinTossResult) {
// TODO
        } else {
// TODO
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
