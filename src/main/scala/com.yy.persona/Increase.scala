package com.yy.persona

/**
  * Created by cc on 2019/8/1.
  */
object Increase {
  def main(args: Array[String]) {
    var increase = (x:Int)=>x+1
    val someValues = List(-11, -10, -5, 0, 5, 10)
    var b = someValues.foreach(increase)
    print(b.getClass)
    println()
    var c = someValues.map(increase)
    print(c.getClass)
    println()
    c.foreach((x:Int)=>print(x+" "))
    println()
    c.map((x:Int)=>print(x+" "))
    println()
    val list = List( 4, 5, 2, 8, 9)
    val sortWithList1 = list.sortWith(_ > _) // List(B, F, a, c, g)
    val sortwithList2 = list.sortWith((left, right) => left < right) //List(B, F, a, c, g)

    println(sortWithList1)
    println(sortwithList2)


  }
}
