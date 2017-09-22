package com.hapream.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
import org.scalatest.{BeforeAndAfter, FlatSpec}

/**
  * Created by zhangyanggang on 2017/9/22.
  */
object WorldCount extends Serializable {

  def count(lines: RDD[String]): RDD[(String, Int)] = {
    lines.flatMap(_.split("\\s+")).map((_, 1)).reduceByKey(_ + _)
  }

}

class WorldCountTests extends FlatSpec with BeforeAndAfter {
  val master = "local[2]"
  @transient
  var sc: SparkContext = _
  it should ("test success") in {
    //其中参数为rdd或者dataframe可以通过通过简单的手动构造即可
    val seq = Seq("the test test1", "the test", "the")
    val rdd = sc.parallelize(seq)
    val wordCounts = WorldCount.count(rdd)
    wordCounts.map(p => {
      p._1 match {
        case "the" =>
          assert(p._2 == 3)
        case "test" =>
          assert(p._2 == 2)
        case "test1" =>
          assert(p._2 == 1)
        case _ =>
          None
      }
    }).foreach(_ => ())
  }
  //这里before和after中分别进行sparkcontext的初始化和结束，如果是SQLContext也可以在这里面初始化
  before {
    val conf = new SparkConf()
      .setAppName("test").setMaster(master)
    sc = new SparkContext(conf)
  }

  after {
    if (sc != null) {
      sc.stop()
    }
  }
}
