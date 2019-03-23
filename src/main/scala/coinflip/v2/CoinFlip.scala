package coinflip.v2

import java.util.Random

import cats.effect.IO
import coinflip.GameState
import coinflip.CoinFlipUtils._

object CoinFlip extends App {

  val r = new Random()
  val s = GameState(0, 0)

  //flipTheCoin(random, s)

  def flipTheCoin(random: Random, state: GameState):IO[Unit] =  for {
    _ <- IO {
      showPrompt
    }
    userInput <- IO {
      getUserInput
    }
    _ <- if (userInput == "H" || userInput == "T") for {
      _               <- IO {println("You said H or T")}
      coinTossResult  = tossCoin(random)
      newNumFlips     = (state.numFlips + 1)
      newGameState    = createNewGameState(userInput, coinTossResult.toString, state, random, newNumFlips)
      _               <- IO {printGameState(printableResult(coinTossResult.toString), newGameState)}
      _               <- flipTheCoin(random, newGameState)
    } yield Unit
    else for {
      _               <- IO {println("Did not enter H or T")}
      _               <- IO {printGameOver}
      _               <- IO{ printGameState(state)}
    } yield Unit
  } yield Unit

  flipTheCoin(r, s).unsafeRunSync()

  private def createNewGameState (userInput: String, coinTossResult: String, gameState: GameState, random: Random, newNumFlips: Int): GameState = {
      if (userInput == coinTossResult) {
      val newNumCorrect = gameState.numCorrectGuesses + 1
      val newGameState = gameState.copy (numFlips = newNumFlips, numCorrectGuesses = newNumCorrect)
      newGameState
    } else {
      val newGameState = gameState.copy (numFlips = newNumFlips)
      newGameState
    }
  }




}
