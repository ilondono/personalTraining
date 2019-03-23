package functions

import org.scalatest.FunSuite

class FunctionAsParameterTest extends FunSuite {

  val dragonBallCharacters = List("Goku", "Krilin", "Vegetta", "Milk",  "Piccoro", "Bills", "Dende", "Supreme-Kaiosama", "Yamtcha", "KamiSama", "Bulma", "Dendee", "KaioSama", "Yayirobe", "Nappa", "Radix")
  val humans = List("Krilin", "Yamtcha", "Bulma", "Yayirobe", "Milk")
  val gods = List("KamiSama", "KaioSama", "Bills", "Supreme-Kaiosama")
  val nameks = List("Piccoro", "KamiSama", "Dende")
  val saiyans = List("Goku", "Vegetta", "Nappa", "Radix")
  val goku = List("Goku")

  def isHuman(name: String) = {
    humans.contains(name)
  }

  def isNamek(name: String) = {
    nameks.contains(name)
  }

  def isGod(name: String) = {
    gods.contains(name)
  }

  def isSaiyan(name: String) = {
    saiyans.contains(name)
  }

  test("Send userInput function as userInput parameter of another function") {

    assert(FunctionAsParameter.filtrar(isHuman, dragonBallCharacters).toSet == humans.toSet)
    assert(FunctionAsParameter.filtrar(isGod, dragonBallCharacters).toSet == gods.toSet)
    assert(FunctionAsParameter.filtrar(isSaiyan, dragonBallCharacters).toSet == saiyans.toSet)
    assert(FunctionAsParameter.filtrar(isNamek, dragonBallCharacters).toSet == nameks.toSet)
  }

  test("Send userInput function as userInput parameter of userInput TAIL recursive function") {
    assert(FunctionAsParameter.filtrarTailRecursive(dragonBallCharacters, isHuman).toSet == humans.toSet)
    assert(FunctionAsParameter.filtrarTailRecursive(dragonBallCharacters, isGod).toSet == gods.toSet)
    assert(FunctionAsParameter.filtrarTailRecursive(dragonBallCharacters, isSaiyan).toSet == saiyans.toSet)
    assert(FunctionAsParameter.filtrarTailRecursive(dragonBallCharacters, isNamek).toSet == nameks.toSet)
  }
}
