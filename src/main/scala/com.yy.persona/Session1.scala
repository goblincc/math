package com.yy.persona

/**
  * Created by cc on 2019/2/5.
  */
object Session1 {
  def fun(a: Int*) ={
    a.foreach{x => print(x)}
  }
  val f = (a:Int, b:Int) => {
    a+b
  }

  def main(args: Array[String]) {
//    fun(1,2,3)
//    print(f(1,2))

    val list = List("hello cc", "java python", "hh scala")

    val result: List[Array[String]] = list.map(x => x.split(" "))

    result.foreach(arr => {
      arr.foreach(x => println(x))
    })

    val flatMap: List[String] = list.flatMap(x => {x.split(" ")})
      flatMap.foreach(x=>{print(x)})

    for(x <- 1 to 10){
      print(x)
    }

    }

}
