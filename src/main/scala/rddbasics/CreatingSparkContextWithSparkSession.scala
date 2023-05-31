package rddbasics

import org.apache.spark.sql.SparkSession

object CreatingSparkContextWithSparkSession {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder()
      .appName("Creating SparkContext with SparkSesion")
      .master("local")
      .getOrCreate()

    val array = Array(1,2,3,4,5)

    val arrayRDD = sparkSession.sparkContext.parallelize(array, 2)
    arrayRDD.foreach(println)

    val file = "countries_index.csv"
    val fileRDD = sparkSession.sparkContext.textFile(file)
    println("Num of Records: "+ fileRDD.count())
    fileRDD.take(10).foreach(println)
  }

}
