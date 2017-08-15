package model

import play.api.libs.json.Json

import scala.xml.Node

case class Item(channel: String, title: String, time: String, desc: String, category: String)

object Item {

  def fromXml(node: Node): Item =
    Item((node \ "title").text.split('|')(0).trim, (node \ "title").text.split('|')(2).trim,
      (node \ "title").text.split('|')(1).trim, (node \ "description").text, (node \ "category").text)

  implicit val format = Json.format[Item]


}