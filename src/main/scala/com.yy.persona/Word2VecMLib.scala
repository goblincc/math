package com.yy.persona

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.feature.{Word2VecModel, Word2Vec}

/**
  * Created by cc on 2019/8/3.
  */
object Word2VecMLib {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Word2VecExample").setMaster("local[*]")
    val sc = new SparkContext(conf)

    // $example on$
    val input = sc.textFile("data/mllib/sample_lda_data.txt").map(line => line.split(" ").toSeq)

    val word2vec = new Word2Vec().setMinCount(2).setNumIterations(10).setVectorSize(3)

    val model = word2vec.fit(input)
    val vectors: Map[String, Array[Float]] = model.getVectors
    val toSeq: Seq[(String, Array[Float])] = vectors.toSeq
    for((key, value) <- vectors){
      println(s"$key:")
      for(i <- 0 until value.length){
        println("     "+value(i))
      }
    }
    println("===============================")
    val synonyms = model.findSynonyms("1", 5)

    for((synonym, cosineSimilarity) <- synonyms) {
      println(s"$synonym $cosineSimilarity")
    }

    // Save and load model
//    model.save(sc, "myModelPath")
//    val sameModel = Word2VecModel.load(sc, "myModelPath")
    // $example off$

    sc.stop()
  }
}
