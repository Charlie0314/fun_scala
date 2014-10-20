def matchList(xs:List[Int]):Int = xs match{
  case Nil => 0
  case hd :: tl => hd
}

val l1 = List()

val l2 = List(34)

val l3 = List(2,3,4,5,5)

matchList(l1)

matchList(l3)

matchList(l2)

