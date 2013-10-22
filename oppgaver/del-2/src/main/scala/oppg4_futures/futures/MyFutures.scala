package oppg4_futures.futures

import scala.concurrent.Future
import scala.concurrent.future
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import oppg4_futures.work.{SumSequence, FactorNumber}

object MyFutures {

  def computeSquare(n: Int): Future[Int] = {
    future {
      n * n
    }
  }

  def computeSquare(f: Future[Int]): Future[Int] = {
      f.map((n:Int) => n * n)
  }

  def findMaxFactor(work: FactorNumber): Future[Long] = {
    future {
      work.perform.max
    }
  }

  def findMaxFactor(work: Future[FactorNumber]): Future[Long] = {
    work.map(w => w.perform.max)
  }

  def computeRiskySumFallbackOnSafeSum(riskyWork: SumSequence, safeWork: SumSequence): Future[Int] = {
    val riskyRes = future { riskyWork.perform }
    val safeRes = future { safeWork.perform }
    riskyRes recoverWith {
      case e: IllegalArgumentException => safeRes
    }
  }

  def findSumOfAllMaxFactors(work: Seq[FactorNumber]): Future[Long] = {
    future {
      work.map(w => w.perform.max).sum
    }
  }

  def findMaxFactorOfAllMaxFactorsInParallel(work: Seq[FactorNumber]): Future[Long] = {
    val futureFactors: Seq[Future[Long]] = work.map(w => future { w.perform.max })
    val result: Future[Seq[Long]] = Future.sequence(futureFactors)
    result.map(s => s.max)
    //Future.fold(futureFactors)(0L)((r, c) => Math.max(r, c))
  }
}

object Examples extends App {

  def futureHelloWorld() = {
    println("Test print before future")
    val s = "hello"
    val f = future {
      Thread.sleep(10)
      s + " future!"
    }
    println("Test print after future")
    f onSuccess { case s => println(s) } //Completely asynchronous
    Await.ready(f, Duration.Inf) //Blocks until the future is ready
  }

  def simpleTransformation() = {
    val f1 = future {
      Thread.sleep(1000)
      println("Original future done")
      1 + 1
    }

    val f2 = f1.map(x => { // Completely asynchronously
      Thread.sleep(1000)
      println("Transformation future done")
      x + 1
    })

    f2 onSuccess { case v => println("Result: " + v) }
    Await.ready(f2, Duration.Inf)
  }

  futureHelloWorld
//  simpleTransformation
}
