
def foldr[T](f: (T,T) => T, seed: T, lat: List[T]): T =
    if (lat.isEmpty) seed
    else f( lat.head, foldr( f, seed, lat.tail ) )
 
def unfoldr[T](f: (T) => Option[T], seed: T): List[T] = {
    def U(a: T, lat: List[T]) : List[T] = {
        f(a) match {
            case None => lat
            case Some(v) => U(v, v :: lat)
        }
    }
    U(seed, Nil)
}    

def sumsq(max: Int) = { 
    foldr( (x: Int, acc: Int) => x * x + acc, 0,
        unfoldr((x: Int) => { if (x < max) Some(x+1) else None }, 0) )
}

def sum_progression(from: Int, to: Int, step: Int) = {
    val to_adj = to - (to % step)
    ( from + to_adj ) * (( to_adj - from  ) / step + 1 ) / 2 
}

def euler_6 = {
    val sum_1_100 = sum_progression(1, 100, 1)
    sum_1_100 * sum_1_100 - sumsq(100)
}

println(euler_6)