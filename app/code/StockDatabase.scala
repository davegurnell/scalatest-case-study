package code

case class StockDatabase(items: Map[Int, Item] = Map.empty) {
  def nextId: Int =
    if(items.isEmpty) 0 else items.keySet.max + 1

  def add(item: Item): StockDatabase =
    StockDatabase(items + (nextId -> item))

  def remove(id: Int): StockDatabase =
    StockDatabase(items - id)

  def updateQuality: StockDatabase =
    StockDatabase(items.mapValues(_.updateQuality))
}
