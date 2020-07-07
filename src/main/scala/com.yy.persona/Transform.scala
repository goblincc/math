package com.yy.persona

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by cc on 2019/8/2.
  */
object Transform {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("cc").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val spark = SparkSession.builder().appName("cc").master("local[*]").getOrCreate()
    val parallelize: RDD[String] = sc.parallelize(Seq("A,B,1","A,B,2","A,B,3","E,F,1","E,F,2"))
    parallelize.map(p=>{val s = p.split(",")
      ((s(0),s(1)),s(2).toInt)
    }).reduceByKey((a,b)=>{
          a+b
//        if(a > b){
//            b
//        }else{
//            a
//        }
    }).foreach(println(_))

  }
}
