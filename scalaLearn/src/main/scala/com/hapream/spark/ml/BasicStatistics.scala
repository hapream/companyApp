package com.hapream.spark.ml

import org.apache.spark.ml.linalg.{Matrix, Vectors}
//import org.apache.spark.ml.stat.Correlation
import org.apache.spark.sql.Row
import org.junit.{Assert, Test}

/**
  * Created by zhangyanggang on 2017/9/22.
  */
@Test
class BasicStatistics extends Assert {

  @Test
  def testCorrelation(): Unit = {
    val data = Seq(
      Vectors.sparse(4, Seq((0, 1.0), (3, -2.0))),
      Vectors.dense(4.0, 5.0, 0.0, 3.0),
      Vectors.dense(6.0, 7.0, 0.0, 8.0),
      Vectors.sparse(4, Seq((0, 9.0), (3, 1.0)))
    )
//
//    val df = data.map(Tuple1.apply).toDF("features")
//    val Row(coeff1: Matrix) = Correlation.corr(df, "features").head
//    println("Pearson correlation matrix:\n" + coeff1.toString)
//
//    val Row(coeff2: Matrix) = Correlation.corr(df, "features", "spearman").head
//    println("Spearman correlation matrix:\n" + coeff2.toString)
  }

}
