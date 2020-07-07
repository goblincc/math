package com.yy.hh

/**
  * Created by cc on 2020/5/31.
  */
class Point_L(val xc: Int, val yc: Int) {
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int): Unit ={
    x = x + dx
    y = y + dy
    println ("x 的坐标点 : " + x)
    println ("y 的坐标点 : " + y)
  }

}

class Location(override val xc: Int, override val yc: Int, val zc:Int) extends Point_L(xc, yc){
  var z:Int = zc

  def move(dx: Int, dy: Int, dz: Int) {
    x = x + dx
    y = y + dy
    z = z + dz
    println ("x 的坐标点 : " + x)
    println ("y 的坐标点 : " + y)
    println ("z 的坐标点 : " + z)
  }
}

object Test{
  def main(args:Array[String]): Unit ={
     val loc = new Location(10, 20, 30)
     loc.move(10, 10, 5)

    val sites = Map("runoob" -> "www.runoob.com", "google" -> "www.google.com")

    println("show(sites.get(\"runoob\")) : " + show(sites.get( "runoob")))
    println("show(sites.get(\"baidu\")) : "+show(sites.get( "baidu")) )
    println(sites.get("baidu").getOrElse())
    def show(x: Option[String]) = x match {
      case Some(s) => s
      case None => "?"
    }

  }
}
