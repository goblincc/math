package com.yy.persona

import org.apache.spark.graphx.{GraphLoader, VertexRDD}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Administrator on 2019/1/29.
  */
object T {
  /**
    * 数据列表的笛卡尔乘积：{1,2,3,4}=>{(1,2),(1,3),(1,4),(2,3),(2,4),(3,4）}
    *
    * @param input
    * @return
    */
  def ciculate(input:List[Long]):Set[String]={
    var result = Set[String]()
    input.foreach(x=>{
      input.foreach(y=>{
        if(x<y){
          result += s"${x}&${y}"
  }else if(x>y){
          result += s"${y}&${x}"
  }
      })
    })
    return result;
  }
  def twoDegree()={
    val conf = new SparkConf().setMaster("local").setAppName("graph")
    val sc = new SparkContext(conf)
    val graph = GraphLoader.edgeListFile(sc,"./followers.txt")

    val relate: VertexRDD[List[Long]] = graph.aggregateMessages[List[Long]](
      triplet=>{
        triplet.sendToDst(List(triplet.srcId))
//        triplet.sendToSrc(List(triplet.srcId))
      },
      (a,b)=>(a++b)
    )
//      .filter(x=>x._2.length>1)
    relate.foreach(println(_))
    val re = relate.flatMap(
      x=>{
      for(temp <- ciculate(x._2))yield (temp,x._1) }
    )
//      .reduceByKey(_+_)
      .groupByKey()
    re.foreach(println(_))
  }
  def main(args: Array[String]): Unit = {
    twoDegree()
  }

}
