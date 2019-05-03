package io.files

import scala.io.Source
import java.io._

import scala.annotation.tailrec

object ScriptsReading extends App {

  println("Inicia")
  val path = "D:\\\\SuraDllo\\\\ScriptsEML\\\\seeds-db\\\\"
  val pw = new PrintWriter(new File("D:\\\\SuraDllo\\\\ScriptsEML\\\\seeds-db\\\\script-generate.sql"))

  writeFile(pw, path, 1, 93)

  pw.close()

  @tailrec
  def writeFile(printWriter: PrintWriter, filePath: String, count: Int, limit: Int): Unit = {
    (count <= limit) match {
      case true => {
        for (line <- Source.fromFile(filePath + count + ".sql").getLines()) {
          printWriter.write(line + "\n")
        }
        writeFile(printWriter, filePath, count + 1, limit)
      }
      case _ => println("Finalizó en: " + count)
    }
  }
}
