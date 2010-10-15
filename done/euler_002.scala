
def euler_2 = {
    def sum_fib_even(upto: Int): Int = {
        def S(f2: Int, f1: Int, a: Int): Int = {
            val fn = f1 + f2
            a + (if (fn >= upto) 0
                else             S( fn, f2, if (fn % 2 == 0) fn else 0 ))
        }
        S( 2, 1, 2 )
    }
    sum_fib_even(4000000)
}

def euler_2a = {
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

println(euler_2)