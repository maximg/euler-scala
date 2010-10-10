
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

def project_euler_5 = {
    2 * 2 * 2 * 2 * 3 * 3 * 5 * 7 * 11 * 13 * 17 * 19
}

def project_euler_6 = {
    val sum_1_100 = sum_progression(1, 100, 1)
    sum_1_100 * sum_1_100 - sumsq(100)
}

def project_euler_1 = {
    sum_progression(0, 1000, 3) + sum_progression(0, 1000, 5) - sum_progression(0, 1000, 3*5)
}


def project_euler_2 = {
    def sum_fib_even(upto: Int): Int = {
        def S(f2: Int, f1: Int, a: Int): Int = {
            val fn = f1 + f2
            a + (if (fn >= upto) 0
                else            S( fn, f2, if (fn % 2 == 0) fn else 0 ))
        }
        S( 2, 1, 2 )
    }
    sum_fib_even(4000000)
}

def project_euler_2a = {
    def sum_fib_even(upto: Int): Int = {
        def S(f2: Int, f1: Int): Int = {
            val fn = f1 + 4*f2
            if (fn >= upto) f2
            else            f2 + S( fn, f2 ) 
        }
        2 + S( 8, 2 )
    }
    sum_fib_even(4000000)
}
