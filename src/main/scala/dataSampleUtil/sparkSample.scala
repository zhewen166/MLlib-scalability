/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// scalastyle:off println
package ml

// $example on$
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.ml.evaluation.RegressionEvaluator
import org.apache.spark.ml.recommendation.ALS
// $example off$
import org.apache.spark.sql.SparkSession

/**
 * An example demonstrating ALS.
 * Run with
 * {{{
 * bin/run-example ml.ALSExample
 * }}}
 */
object sparkSample {

// 原始文件中10976652行数据
  def main(args: Array[String]) {


    val spark = SparkSession
      .builder
      .appName("ALSExample").master("local")
      .getOrCreate()

    // $example on$
    val temp = spark.read.textFile("/home/cz/Hadoop2/spark-all/SparkFaultBench-master/data/mllib/als/sample_movielens_ratings.txt")
           .sample(false,0.1,11)
     println(temp.count())
    println("____________________________________________________________")
    for (elem <- temp.collect()) {println(elem)}
//    println(temp.count)
    spark.stop()


  }
}
// scalastyle:on println

