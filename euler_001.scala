
def sum_progression(from: Int, to: Int, step: Int) = {
    val to_adj = to - (to % step)
    ( from + to_adj ) * (( to_adj - from  ) / step + 1 ) / 2 
}

def euler_1 = 
    sum_progression(0, 1000, 3) + sum_progression(0, 1000, 5) - sum_progression(0, 1000, 3*5)
    
println(euler_1)
