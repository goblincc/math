package com.yy.persona

import org.apache.spark.graphx.util.GraphGenerators
import org.apache.spark.graphx.{Graph, VertexRDD}
import org.apache.spark.sql.SparkSession

/**
  * Created by Administrator on 2019/1/30.
  */
object Aggrate {
  def main(args: Array[String]) {
    val spark = SparkSession.builder().appName("Ag").master("local[2]").getOrCreate()
    val sc = spark.sparkContext
    val graph: Graph[Double, Int] =
      GraphGenerators.logNormalGraph(sc, numVertices = 100).mapVertices((id, _)=>id.toDouble)
    val olderFollowers: VertexRDD[(Int, Double)] = graph.aggregateMessages[(Int, Double)](
      triplet =>{
        if(triplet.srcAttr>triplet.dstAttr){
            triplet.sendToDst(1,triplet.srcAttr)
        }
      },
      (a, b)=>(a._1+b._1, a._2+b._2)
    )
    olderFollowers.foreach(println(_))
    val avgAgeOfOlderFollowers:VertexRDD[Double] =
      olderFollowers.mapValues((id,value) =>
          value match{case(count,totalAge) => totalAge/count})
      avgAgeOfOlderFollowers.collect.foreach(println(_))

    spark.stop()
  }
}
