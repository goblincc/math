package com.yy.persona

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by cc on 2019/8/4.
  */
object SimpleT {
  def main(args: Array[String]) {
    val list = List(("A",1),("B",2),("C",3),("D",4))
    list.sortWith(_._2>_._2).map(p=>p._1+":"+p._2).take(2).mkString(",").foreach(print(_))

    val conf = new SparkConf().setAppName("zip").setMaster("local[*]")
    conf.set("spark.shuffle.consolidateFiles","true")
    val sc = new SparkContext(conf)
    val spark = SparkSession.
      builder().appName("zip").
      master("local[2]").
      config("spark.shuffle.consolidateFiles","true")

    val parallelize: RDD[(String, Int)] = sc.parallelize(Seq(("A",1),("A",2)))
    val parallelize1: RDD[(String, Int)] = sc.parallelize(Seq(("A",3),("B",4)))
    parallelize.leftOuterJoin(parallelize1).foreach(print(_))

  }
}
