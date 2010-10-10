
val keylog = List(
    319, 680, 180, 690, 129, 620, 762, 689, 762, 318, 
    368, 710, 720, 710, 629, 168, 160, 689, 716, 731, 
    736, 729, 316, 729, 729, 710, 769, 290, 719, 680, 
    318, 389, 162, 289, 162, 718, 729, 319, 790, 680, 
    890, 362, 319, 760, 316, 729, 380, 319, 728, 716
);

def breakup(v: Int): List[Pair[Int,Int]] = {
    val (a, b, c) = (v / 100, (v % 100) / 10, v % 10)
    List(  (a, b), (a, c), (b, c) )
}

def breakCode(keylog: List[Int]) = {
    val predc = Array.ofDim[Int](10)
    val succ = Array.ofDim[Int](10)
    for( (x,y) <- keylog.flatMap(i => breakup(i)).toSet ) { succ(x) += 1; predc(y) += 1 }
    Range(0,10)
        .filter( x => predc(x) != 0 || succ(x) != 0 ).toList
        .sort { case (a,b) => predc(a) - succ(a) < predc(b) - succ(b) }
        .map( _.toString ).reduceLeft( (acc,n) => acc + n )
}

def euler_79 = breakCode(keylog)

println(euler_79)
