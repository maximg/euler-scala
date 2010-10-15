
import Math._
import scala.collection.mutable._

def fib(m: Long): List[Long] = {
    def F(lat: List[Long]): List[Long] = {
        val next = lat.take(2).sum
        if (next > m) lat
        else F(next :: lat)
    }
    F(List(2,1))
}

val ten17 = BigInt(10).pow(17).toLong

val fibs = fib(ten17)

def z(n: Long): Int = {
    def Z(n: Long, lat: List[Long]): Int = {
        if (n == lat.head) 1
        else Z(
    }
}

def zdorf(n: Long): List[Long] = {
    def ZD(n: Long, lat: List[Long]): List[Long] = {
        if(n == lat.head) List(n)
        else if (n > lat.head) lat.head :: ZD(n - lat.head, lat.tail)
        else ZD(n, lat.tail)
    }
    ZD(n, fibs)
}

def z(n: Long) = zdorf(n).length

sumz(100) == 261

Range(1,1000000).map( zdorf(_).length ).sum == 7894453

def sumz(n: Long) = {
    val fibs = fib(n)
    val afibs = fibs.reverse.toArray
    val sumzz = new HashMap[Long, Long]
    sumzz += (1L -> 0L, 2L -> 1L, 3L -> 2L)
    for(idx <- Range(3, afibs.length)) //{ 
        //println(idx, afibs(idx-1), sumzz(afibs(idx-1)), sumzz(afibs(idx-2)), - afibs(idx-3))
        sumzz += (afibs(idx).toLong -> (afibs(idx-1) + sumzz(afibs(idx-1)) + sumzz(afibs(idx-2)) - afibs(idx-3) ))
        //}
    def SZ(n: Long): Long = {
        if (n == 0) 0
        else
        fibs.find( _ <= n ) match {
            case None => -1
            case Some(x) => 
                if (x == n) sumzz(x) 
                else sumzz(x) + (n-x) + SZ(n - x)
        }
    }
    SZ(n)
}

def sumz1(n: Int) = Range(1,n).map( zdorf(_).length ).sum



