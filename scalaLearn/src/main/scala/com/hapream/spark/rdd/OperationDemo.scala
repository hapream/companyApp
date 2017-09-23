import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}
import org.junit.{Assert, Before, Test}


/**
  * Map flatMap Filter GroupBy GroupByKey ReduceByKey MapPartitions Sample union join distinct
  * Cosleace
  */
@Test
class OperationDemo extends Assert with Serializable {

  @transient
  var conf: SparkConf = _
  @transient
  var sc: SparkContext = _

  @Before
  def init(): Unit = {
    conf = new SparkConf().setAppName("Test").setMaster("local[2]")
    sc = new SparkContext(conf)
  }

  @Test
  def testMap(): Unit = {
    val x = sc.parallelize(Array("a", "b", "c"))
    val y = x.map(z => (z, 1))
    println(x.collect().mkString(","))
    println(y.collect().mkString(","))
  }


  @Test
  def testFilter(): Unit = {
    val x = sc.parallelize(Array(1, 2, 3))
    val y = x.filter(n => n % 2 == 1)
    println(x.collect().mkString(","))
    println(y.collect().mkString(","))
  }


  @Test
  def testFlatMap(): Unit = {
    val x = sc.parallelize(Array(1, 2, 3))
    val y = x.flatMap(n => Array(n, n * 100, 42))
    println(x.collect().mkString(","))
    println(y.collect().mkString(","))
  }

  @Test
  def testGroupBy(): Unit = {
    val x = sc.parallelize(
      Array("John", "Fred", "Anna", "James"))
    val y = x.groupBy(name => name.charAt(0))
    println(x.collect().mkString(","))
    println(y.collect().mkString(","))
  }

  @Test
  def testGroupByKey(): Unit = {
    val x = sc.parallelize(
      Array(('B', 5), ('B', 4), ('A', 3), ('A', 2), ('A', 1)))
    val y = x.groupByKey()
    println(y.collect().mkString(","))
  }


  @Test
  def testWorldCountReduceAndGroup(): Unit = {
    val words = Array("one", "two", "two", "three", "three", "three")
    val wordPairsRDD = sc.parallelize(words).map((_, 1))
    val wordCountWithReduce = wordPairsRDD.reduceByKey(_ + _)
    wordCountWithReduce.foreach(println)

    val wordCountWithGroup = wordPairsRDD.groupByKey().map(r => (r._1, r._2.sum))
    wordCountWithGroup.foreach(println)
  }

  @Test
  def testMapPartitions(): Unit = {
    val x = sc.parallelize(Array(1, 2, 3), 2)
    def f(i: Iterator[Int]) = {
      (i.sum, 42).productIterator
    }
    val y = x.mapPartitions(f)

    x.foreach(println)
    y.foreach(println)

    // glom() flattens elements on the same partition
    val xOut = x.glom().collect()
    val yOut = y.glom().collect()
  }

  @Test
  def testMapPartitionsWithIndex(): Unit = {
    val x = sc.parallelize(Array(1, 2, 3), 2)
    def f(pritition: Int, i: Iterator[Int]) = {
      (pritition, i.sum).productIterator
    }
    val y = x.mapPartitionsWithIndex(f)
    x.foreach(println)
    y.foreach(println)

    // glom() flattens elements on the same partition
    val xOut = x.glom().collect()
    val yOut = y.glom().collect()
  }

  @Test
  def testSample(): Unit = {
    val x = sc.parallelize(Array(1, 2, 3, 4, 5))
    val y = x.sample(false, 0.4)
    println(y.collect().mkString(","))

  }


  @Test
  def testUnion(): Unit = {
    val x = sc.parallelize(Array(1, 2, 3), 2)
    val y = sc.parallelize(Array(3, 4), 1)
    val z = x.union(y)
    val zOut = z.glom().collect()
  }

  @Test
  def testJoin(): Unit = {
    val x = sc.parallelize(Array(("a", 1), ("b", 2)))
    val y = sc.parallelize(Array(("a", 3), ("a", 4), ("b", 5)))
    val z = x.join(y)
    println(z.collect().mkString(", "))
  }

  @Test
  def testDistinct(): Unit = {
    val x = sc.parallelize(Array(1, 2, 3, 3, 4))
    val y = x.distinct()
    println(y.collect().mkString(", "))
  }

  /**
    * Return a new rdd which is reduced to a smaller number of partitions
    * TODO
    */
  @Test
  def testCoalesce(): Unit = {
    val x = sc.parallelize(Array(1, 2, 3, 4, 5), 3)
    val y = x.coalesce(2)
    val xOut = x.glom().collect()
    val yOut = y.glom().collect()


  }

  /**
    * create a pari RDD, forming one pari for each item in the original RDD
    */
  @Test
  def testKeyBy(): Unit = {
    val x = sc.parallelize(
      Array("John", "Fred", "Anna", "James"))
    val y = x.keyBy(name => name.substring(0, 1))
    println(y.collect().mkString(","))
  }

  @Test
  def testPartitionBY(): Unit = {
    val x = sc.parallelize(Array(('J', "James"), ('F', "Fred"),
      ('A', "Anna"), ('J', "John")), 3)
    val y = x.partitionBy(new Partitioner {
      override def numPartitions: Int = 2

      override def getPartition(key: Any): Int = {
        if (key.asInstanceOf[Char] < 'H') 0 else 1
      }
    })

    val yOut = y.glom().collect()
  }


  @Test
  def testZip(): Unit = {
    val x = sc.parallelize(Array(1, 2, 3))
    val y = x.map(n => n * n)
    val z = x.zip(y)
    println(z.collect().mkString(","))
  }


  @Test
  def testGetNumpartitions(): Unit = {
    val x = sc.parallelize(Array(1, 2, 3), 2)
    val y = x.partitions.size
    val xOut = x.glom().collect()
    println(y)
  }

  @Test
  def testReduce(): Unit = {
    val x = sc.parallelize(Array(1, 2, 3, 4))
    val y = x.reduce((a, b) => a + b)
    println(x.collect().mkString(","))
    println(y)
  }

  /**
    *
    * zeroValue: 初始化的result,  seqOp 和 comOp的返回值
    * seqOp: 分区内的计算
    * comOp: 分区间的计算
    */
  @Test
  def testAggregate(): Unit = {

    def seqOp = (data: (Array[Int], Int), item: Int) =>
      (data._1 :+ item, data._2 + item)

    def comOp = (d1: (Array[Int], Int), d2: (Array[Int], Int)) =>
      (d1._1.union(d2._1), d1._2 + d2._2)

    val x = sc.parallelize(Array(1, 2, 3, 4))
    val y = x.aggregate((Array[Int](), 0))(seqOp, comOp)
    println(y)
  }

  /**
    * standard deviation STDDV
    */
  @Test
  def testMath: Unit = {
    val x = sc.parallelize(Array(2, 4, 1))
    val max = x.max
    println(x.collect().mkString(", "))
    println(max)

    val sum = x.sum()
    println(sum)

    val mean = x.mean()
    println(mean)

    val stddv = x.stdev()
    println(stddv)
  }

  @Test
  def testCountByKey(): Unit = {
    val x = sc.parallelize(Array(('J', "James"), ('F', "Fred"),
      ('A', "Anna"), ('J', "John")))

    val y = x.countByKey()
    println(y)
  }

  //  def printGlomRDD(rdd: RDD[Array[Any]]): Unit = {
  //    rdd.foreach {
  //      iter => {
  //        iter.foreach(print)
  //        println()
  //      }
  //    }
  //  }
}




