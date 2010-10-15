
def fact(n: Long): BigInt = if (n == 0) 1 else BigInt(n) * fact(n-1)

def sumdig(n: BigInt) = n.toString.toList.map( (x: Char) => x.toString.toInt).sum

sumdig(fact(100))   // 648