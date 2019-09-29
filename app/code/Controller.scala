package code

import play.api._
import play.api.mvc._
import play.api.libs.Files._
import play.api.libs.json._
import javax.inject.Inject
import scala.xml._

class Controller @Inject() (val controllerComponents: ControllerComponents) extends BaseController {
  var stock: StockDatabase = StockDatabase()

  def list = Action {
    Ok(Json.toJson(stock.items))
  }

  def add = Action(parse.json[Item]) { request =>
    stock = stock.add(request.body)

    Ok(Json.toJson(stock.items))
  }

  def remove(id: Int) = Action { request =>
    stock = stock.remove(id)

    Ok(Json.toJson(stock.items))
  }

  def updateQuality = Action {
    stock = stock.updateQuality

    Ok(Json.toJson(stock.items))
  }
}
