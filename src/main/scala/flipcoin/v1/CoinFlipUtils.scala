package flipcoin.v1

import scala.io.StdIn.readLine
import scala.util.Random

object CoinFlipUtils {

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
