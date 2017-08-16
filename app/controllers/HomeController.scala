package controllers

import java.net.URL

import model.Item
import play.api.libs.json.Json
import play.api.libs.ws.WSClient
import play.api.mvc._

import scala.xml.{Elem, XML => xmlreader}

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
class HomeController(ws: WSClient) extends Controller {

  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index() = Action {

    val stream: Elem = xmlreader.load(new URL("https://webnext.fr/epg_cache/programme-tv-rss_2017-08-16.xml"))


    Ok(Json.toJson(datas(stream).filter(i => i.category == "Film"))

    )
  }


  def datas(e: Elem): List[Item] = (e \\ "item").foldLeft(List[Item]())((items, node) => {
    Item.fromXml(node) :: items
  })


  def testVue = Action {
    Ok(Json.toJson("Tout roule")).withHeaders(("Access-Control-Allow-Origin", "*"))
  }

}


