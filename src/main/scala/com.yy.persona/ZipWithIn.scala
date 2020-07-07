package com.yy.persona

import java.util.Arrays

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SparkSession.Builder
import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by cc on 2019/8/1.
  */
object ZipWithIn {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("zip").setMaster("local[*]")
    conf.set("spark.shuffle.consolidateFiles","true")
    val sc = new SparkContext(conf)
    val spark = SparkSession.
      builder().appName("zip").
      master("local[2]").
      config("spark.shuffle.consolidateFiles","true")

    val rdd1: RDD[String] = sc.makeRDD(Seq("A","B","R","D","F"),2)
    val index: RDD[(String, Long)] = rdd1.zipWithIndex()
//    print("index:"+index)
    index.foreach(print(_))
    val map: RDD[(String, Int)] = index.map(p => (p._1,p._2.toInt))
    val map1: RDD[Char] = map.flatMap(p=>p._1)
    map1.foreach(print(_))

    val parallelize: RDD[String] = sc.parallelize(Seq("pandas,a", "i, like, pandas"))
    parallelize.flatMap(p=>p.split(",")(0)).foreach(print(_))
    val a = sc.parallelize(1 to 4)
    a.flatMap(p=>(1 to p)).foreach(println(_))
  }
}
