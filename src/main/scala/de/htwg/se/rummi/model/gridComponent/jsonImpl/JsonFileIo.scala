package de.htwg.se.rummi.model.gridComponent.jsonImpl

import de.htwg.se.rummi.model.Game
import de.htwg.se.rummi.model.gridComponent.GridInterface
import de.htwg.se.sudoku.model.fileIoComponent.FileIoInterface
import play.api.libs.json.{JsValue, Json}

class JsonFileIo extends FileIoInterface {
  override def load: Game = ???

  override def save(grid: Game): String = {
    import java.io._
    val pw = new PrintWriter(new File("grid.json"))
    val json = Json.prettyPrint(gameToJson(grid))
    pw.write(json)
    pw.close
    json
  }

  def gameToJson(game: Game): JsValue = {
    Json.toJson(game)
  }


}
