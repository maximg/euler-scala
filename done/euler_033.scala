
def allCur = {
    for {
        nom     <- Range(1, 9)
        denom   <- Range(nom + 1, 10)
        fact    <- List(3,6,9)
        
        nom1 = nom * 10 + fact
        denom1 = fact * 10 + denom
        
        if nom1 * denom == nom * denom1
    }
    yield ((nom, denom), (nom1, denom1))
}

(1 /: allCur.map( _._1._2 )) { (acc,d) => acc * d }

//  have to reduce nom and denom

// 100


((1,4),(16,64)), 
((1,5),(19,95)), 
((2,5),(26,65)), 
((4,8),(49,98))


(n * 10 + x) * d / n = ( 10 * x + d ) 

10nd + xd = 10nx + dn
9nd = 10nx - xd
x = 9nd / (10n - d)

x = 9 * (nd / (10n - d) ) 

x = 3, 6, 9

nd = 10n - d
2nd = 30n - 3d
nd = 30n - 3d

n = 10n/d - 1

n + 1 = 10 * (n/d)

d = 2,4,5
n = 7,5,3,1



1,4,6
1,5,9
2,5,6
4,8,9

10nd - 9xd = 