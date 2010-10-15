
def findPrime(n: Int) = {
    def P(primes: List[Int]): Int = {
        if(primes.length == n) primes.head
        else {
            def isPrime(n: Int) = !primes.exists( n % _ == 0 ) 
            var cand = primes.head + 2
            while(!isPrime(cand))
                cand += 2
            P(cand :: primes)
        }
    }
    P(List(3,2))
}

findPrime(10001)    // 104743