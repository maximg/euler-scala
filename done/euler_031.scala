
def coins(max: Int) = { 
    for(coin <- List(200, 100, 50, 20, 10, 5, 2, 1); if coin <= max) 
        yield coin; 
}

def count_all(amount: Int): Int = {
    def C(amount: Int, maxcoin: Int): Int =
        if (amount == 0) 1
        else coins(if(amount < maxcoin) amount else maxcoin).foldLeft(0) { (sum, coin) => sum + C(amount - coin, coin) }
    C(amount, amount)
}

def euler_31 = count_all(200)

println(euler_31)