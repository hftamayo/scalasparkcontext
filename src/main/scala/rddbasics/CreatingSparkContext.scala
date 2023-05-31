package rddbasics

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


object CreatingSparkContext {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("First Spark Application")
    sparkConf.setMaster("local")

    val sc = new SparkContext(sparkConf)

    val array = Array(1,2,3,4,5,6,7,8,9,0)

    val arrayRDD = sc.parallelize(array, 2)

    println("Num of elements in RDD: ", arrayRDD.count())
    arrayRDD.foreach(println)

    val file = "sampleData.csv"
    val fileRDD = sc.textFile(file, 5)
    println("Num of rows in file: " + fileRDD.count())
    println(fileRDD.first())
  }
}
