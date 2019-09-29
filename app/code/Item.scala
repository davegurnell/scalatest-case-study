package code

import play.api.libs.json._

case class Item(name: String, sellIn: Int, quality: Int) {
  import Item._

  def updateQuality: Item =
    name match {
      case AgedBrie =>
        this.decSellIn().incQuality(1)

      case Sulfuras =>
        this

      case BackstagePasses if sellIn < 1 =>
        this.decSellIn().setQuality(0)

      case BackstagePasses =>
        val change = if(sellIn <= 5) 3 else if(sellIn <= 10) 2 else 1
        this.decSellIn().incQuality(change)

      case _ =>
        this.decSellIn().decQuality(if(sellIn < 1) 2 else 1)
    }

  private def incQuality(amount: Int): Item =
    copy(quality = math.min(maxQuality, math.max(minQuality, quality + amount)))

  private def decQuality(amt: Int): Item =
    incQuality(-amt)

  private def setQuality(quality: Int): Item =
    copy(quality = quality)

  private def decSellIn(): Item =
    copy(sellIn = sellIn - 1)
}

object Item {
  val minQuality = 0
  val maxQuality = 50

  val AgedBrie        = "Aged Brie"
  val Sulfuras        = "Sulfuras, Hand of Ragnaros"
  val BackstagePasses = "Backstage passes to a TAFKAL80ETC concert"

  implicit val format: OFormat[Item] =
    Json.format
}
