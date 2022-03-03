package zio.spark.rdd

import org.apache.spark.rdd.{RDD => UnderlyingRDD}

import zio.spark.internal.Impure.ImpureBox
import zio.spark.internal.codegen.BaseRDD

final case class RDD[T](underlyingRDD: ImpureBox[UnderlyingRDD[T]]) extends BaseRDD(underlyingRDD)

object RDD {
  def apply[T](underlyingRDD: UnderlyingRDD[T]): RDD[T] = new RDD(ImpureBox(underlyingRDD))
}
