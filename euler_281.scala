
import Math._

def divisors(m: Int) = for(i <- 1 to m; if m % i == 0) yield i
    
def fact(n: Long): BigInt = if (n == 0) 1 else BigInt(n) * fact(n-1)

def combs(m: Int, n: Int): BigInt = fact(m * n) / (BigInt(m) pow n)

// k - number of groups of m toppings
def ways4k(k: Int, m: Int): BigInt = {
    var res = combs(k, m)
    for(d <- divisors(k); if d != k) 
        res -= ways4k(d, m)
    res
}    

def f(m: Int, n: Int) = {
    var count: BigInt = 0
    for(d <- divisors(n))
        count = count + ways4k(d, m) / (d*m)
    count
}

var sum: BigInt = 0
for(m <- Range(2,25); n <- Range(1,15); v= f(m,n); if v < (BigInt(10) pow 15)) sum = sum + v

