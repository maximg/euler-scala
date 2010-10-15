
val onesAndTeens = Array("one","two","three","four","five","six","seven","eight","nine","ten",
    "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen")
val tens = Array("twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety")
//"hundred"
//"thousand"

def toWords(n: Int): String = { 
    if (n == 0) ""
    else if (Range(1,20).contains(n)) onesAndTeens(n-1)
    else if(Range(20,100).contains(n)) tens(n / 10 - 2) + toWords(n % 10)
    else if(Range(100,1000).contains(n))
        toWords(n / 100) + "hundred" + { if( n % 100 != 0 ) "and" + toWords(n % 100) else "" }
    else if(n == 1000) "one" + "thousand"
    else "no idea"
} 
