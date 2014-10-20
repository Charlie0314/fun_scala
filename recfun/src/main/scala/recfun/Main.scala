package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = if(c == 0 || r == c) 1 else pascal(c-1,r-1) + pascal(c, r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = chars match{
    case Nil => true
    case List(h, _*) => h match{
      case ')' => false
      case '('  => matchClose(chars.tail,1)
      case _ => balance(chars.tail)
    }

  }

  def matchClose(chars:List[Char],count:Int):Boolean = {
    if(chars.isEmpty && count!= 0) false
    else if(chars.isEmpty && count == 0) true
    else if(count < 0 ) false
    else if(chars.head ==')') matchClose(chars.tail, count - 1)
    else if(chars.head == '(') matchClose(chars.tail, count +1)
    else matchClose(chars.tail , count)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(money == 0) 1
    else if(coins.isEmpty) 0
    else if(money < coins.head) countChange(money,coins.tail)
    else countChange(money - coins.head,coins) + countChange(money,coins.tail)
  }
}
