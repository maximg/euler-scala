
def isPalindrome(n: Int) = n.toString == n.toString.reverse

def palindromes33 = 
    for(i <- 100 to 999; j <- 100 to 999; if isPalindrome(i*j))
        yield i*j

palindromes33.max