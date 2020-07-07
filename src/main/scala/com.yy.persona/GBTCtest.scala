package com.yy.persona


import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{GBTClassificationModel, GBTClassifier}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, VectorIndexer, StringIndexer}
import org.apache.spark.ml.regression.DecisionTreeRegressionModel
import org.apache.spark.sql.{DataFrame, Row, SparkSession}


/**
  * Created by cc on 2019/8/20.
  */
object GBTCtest {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("cc")
      .master("local[*]")
      .getOrCreate()
    import spark.implicits._
    val data = spark.read.format("libsvm").load("data/mllib/sample_libsvm_data.txt")
    val labelIndex = new StringIndexer()
      .setInputCol("label")
      .setOutputCol("indexLabel")
      .fit(data)

    val featureIndex = new VectorIndexer()
      .setInputCol("features")
      .setOutputCol("indexFeatures")
      .setMaxCategories(4)
      .fit(data)

    val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))

    val gbt = new GBTClassifier()
      .setFeaturesCol("indexFeatures")
      .setLabelCol("indexLabel")
      .setMaxIter(10)

    val labelConverter = new IndexToString()
      .setInputCol("prediction")
      .setOutputCol("predictedLabel")
      .setLabels(labelIndex.labels)

    val pipeline = new Pipeline()
      .setStages(Array(labelIndex, featureIndex, gbt, labelConverter))

    val model = pipeline.fit(trainingData)

    val predictions = model.transform(testData)

//    predictions.select("predictedLabel", "label", "features").show(10,false)

//    val evaluator = new MulticlassClassificationEvaluator()
//      .setLabelCol("indexLabel")
//      .setPredictionCol("prediction")
//      .setMetricName("accuracy")
//    val accuracy = evaluator.evaluate(predictions)
//    println("Test Error = " + (1.0 - accuracy))

    val gbtModel = model.stages(2).asInstanceOf[GBTClassificationModel]
    println("Learned classification GBT model:\n" + gbtModel.toDebugString)

    val weights: Array[Double] = gbtModel.treeWeights
    val trees: Array[DecisionTreeRegressionModel] = gbtModel.trees
    val numTrees: Int = gbtModel.numTrees

    var predictDF = trees(0).transform(testData)
//    predictDF = predictDF.withColumn("score",$"prediction" * weights(0))
    predictDF = predictDF.withColumn("score",$"prediction" * weights(0))
    predictDF.show(5, false)
    weights.foreach(println(_))
    spark.close()

  }
}
