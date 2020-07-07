package com.yy.persona

import org.apache.spark.graphx.{Graph, VertexId}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

/**
  * Created by Administrator on 2019/2/2.
  */
object MyTest2 {
  def main(args: Array[String]) {
    val spark = SparkSession.builder().appName("cc").enableHiveSupport().master("local").getOrCreate()
    val sc = spark.sparkContext
    val file = sc.textFile("./2.txt")
    val edgesRDD: RDD[(VertexId, VertexId)] = file.map { x=>(x.split(",")(0).toLong,x.split(",")(1).toLong) }
    edgesRDD.foreach(println)
//    file.map(line => (line.split(",")(0).toLong,line.split(",")(1).toLong)).foreach(_)
//    val edgesRDD: RDD[(VertexId,
    // VertexId)] = file.map(line => (line.split(",")(0).toLong,line.split(",")(1).toLong))

    val graph = Graph.fromEdgeTuples(edgesRDD, 1)
    val ver = graph.connectedComponents().vertices
    ver.foreach(println)

//    // you can see your graph
//    graph.triplets.foreach(println)
    spark.stop()
  }
}
