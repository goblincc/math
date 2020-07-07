package com.yy.persona

import org.apache.spark.ml.feature.Word2Vec
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * Created by cc on 2019/8/2.
  */
object Word2vec1 {
  def main(args: Array[String]) {
    val spark = SparkSession.builder().appName("w2v").master("local[*]").getOrCreate()
    val documentDF = spark.createDataFrame(Seq(
      "Hi I heard about Spark".split(" "),
      "I wish Java could use case classes".split(" "),
      "Logistic regression models are neat".split(" ")
    ).map(Tuple1.apply)).toDF("text")
    documentDF.show(false)
    // Learn a mapping from words to Vectors.
    val word2Vec = new Word2Vec()
      .setInputCol("text")
      .setOutputCol("result")
      .setVectorSize(4)
      .setMinCount(0)
    val model = word2Vec.fit(documentDF)

    val result = model.transform(documentDF)
    result.select("result").collect().foreach(println)
    // $example off$
    val vectors: DataFrame = model.getVectors
    vectors.show(false)
    val synonyms: DataFrame = model.findSynonyms("I", 3)
    synonyms.show()
    spark.stop()
  }
}
