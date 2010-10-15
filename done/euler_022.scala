
names = ...

def score(c: Char): Int = c.toInt - 'A'.toInt + 1 

def score(s: String): Int = (0 /: s.toList) { (acc,c) => acc + score(c) }

def score(names: List[String]) = 
    (0 /: ("" :: names).zipWithIndex) { (acc,e) => acc + score(e._1) * e._2  }

def euler_22 = score( names.sort( (x,y) => x < y) )

euler_22    //  871198282



def scoreMany_rec(names: List[String]) = {
    def S(idx: Int, lat: List[String]): Int =
        if (lat.isEmpty) 0
        else score(lat.head) * idx + S(idx+1, lat.tail)
    S(1, names)
}

def score_1(s: String): Int = s.toList.map( _.toInt - 'A'.toInt + 1 ).sum

def score_2(s: String): Int = 
    (s.toList foldLeft 0) { (acc,c) => acc + score(c) }

def score_2(names: List[String]) = 
    (("" :: names).zipWithIndex foldLeft 0) { (acc,e) => acc + score(e._1) * e._2  }
