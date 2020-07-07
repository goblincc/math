package com.yy.persona

import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by cc on 2019/10/16.
  */
object Object {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[*]").setAppName("tt")
    val sc = new SparkContext(conf)
    val media_source = sc.textFile("data/myTest.txt").map(p=>{
      p.split("\t")(1)
    }).distinct().collect()
    val media_map = scala.collection.mutable.Map[String, Int]()
    for(i <- 0 until media_source.length){
      media_map += (media_source(i) -> i)
    }
    val data = sc.textFile("data/myTest.txt").map(p=>{
      val row = p.split("\t")
      LabeledPoint(row(0).toDouble, Vectors.dense(media_map.get(row(1)).getOrElse().toString.toDouble, row(4).toDouble,row(5).toDouble))
    })

    val Array(train, test) = data.randomSplit(Array(0.6,0.4))

    val model = NaiveBayes.train(train, lambda = 1)
    val predictionAndLabel  = test.map(p => (model.predict(p.features), p.label))
    val accuracy = predictionAndLabel.filter(p => p._1 == p._2).count()/test.count()
    println("准确度:"+accuracy)

    sc.stop()

  }
}
