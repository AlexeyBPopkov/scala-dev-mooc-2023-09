package module1.datacollections.homework

import scala.util.Random

/**
 * В урне 3 белых и 3 черных шара. Из урны дважды вынимают по одному шару, не возвращая их обратно. Найти вероятность появления белого шара.
 */
class BallsExperiment {

  val urn: List[Int] = List.fill(3)(1) ++ List.fill(3)(0)

  def isOneWhite: Boolean = {
    val (ball1, ball2) = Random.shuffle(urn).take(2).splitAt(1)
    ball1.head == 1 || ball2.head == 1
  }
}

object BallsTest {
  def main(args: Array[String]): Unit = {
    val count = 10000
    val listOfExperiments: List[BallsExperiment] = List.fill(count)(new BallsExperiment)
    val countOfPositiveExperiments: Float = listOfExperiments.map(_.isOneWhite).count(_ == true)
    println(countOfPositiveExperiments / count)
  }
}
