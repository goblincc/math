package com.yy.persona

import org.apache.spark.graphx.{VertexRDD, VertexId, Graph}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

/**
  * Created by Administrator on 2019/1/30.
  */
object MyTest {
  def main(args: Array[String]) {
    val str = Array(1, 4, 5, 6)
    val map = scala.collection.mutable.Map[Int,Int]()
    for(i <- 0 until str.length){
      map += (i -> str(i))
    }
    println(map.get(2).getOrElse())
  }
}
