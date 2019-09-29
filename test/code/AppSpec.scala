package code

import org.scalatestplus.play._
import play.api.inject.guice._
import play.api.libs.json._
import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._
import scala.concurrent._

class AppSpec extends PlaySpec with Results {
  val injector = new GuiceApplicationBuilder()
    .injector

  val controller = injector.instanceOf[Controller]

  "list endpoint" must {
    "respond with an empty list of stock" in {
      val result: Future[Result] =
        controller.list().apply(FakeRequest())

      val json: JsValue =
        contentAsJson(result)

      json must equal(Json.arr())
    }
  }
}
