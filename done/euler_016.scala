
def sumdig(n: BigInt) = n.toString.toList.map( (x: Char) => x.toString.toInt).sum

sumdig(BigInt(2).pow(1000)) // 1366