package futures_example

import scala.util.Random
import scala.concurrent.{ Future, ExecutionContext }
import java.util.concurrent.Executors

object FuturesExample {

  val singleExecutorContext = {
    val es = Executors.newSingleThreadExecutor()
    ExecutionContext.fromExecutorService(es)
  }

  val delay = 1000

  def slowNumber: Int = {
    Thread.sleep(delay)
    val res = Random.nextInt
    println(s"random: $res")
    res
  }

  def slowNumberF: Future[Int] = ???

  def slowNumbersF(n: Int): Future[Seq[Int]] = ???

  def main(args: Array[String]) = {
    println(List.fill(10)(slowNumber).mkString(", "))
  }
}
