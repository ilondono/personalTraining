package flipcoin.v1

import CoinFlipUtils._

import scala.annotation.tailrec
import scala.util.Random

object CoinFlip extends App {

  val s = GameState(0, 0)
  val r = new Random()
  flipTheCoin(s, r)

  @tailrec
  def flipTheCoin(gameState: GameState, random: Random): Unit = {

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
            flipTheCoin(newState, random)
          }

          case false => {
            val newState = gameState.copy(newNumFlips, gameState.numCorrectGuesses)
            printGameState(printableResult(coinTossResult), newState)
            flipTheCoin(newState, random)
          }

        }
      }

      case _ => {
        printGameOver
        printGameState(gameState)
      }

    }
  }
}
