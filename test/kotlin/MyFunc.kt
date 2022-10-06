import kotlin.math.pow

fun main() {
    var b = "101011"
    var i: Int = binToInt(b)
    println("res: $i")
}

fun binToInt(bin: String): Int{
    var v: Double = 0.0
    var p: Double = 0.0
    for(i in bin.reversed()){
        if(i == '1'){
            v += Math.pow(2.0, p)
        }
        p++
    }
    return v.toInt()
}

fun toPrintShift(argv: Int, deep: Int, side: Char){
    if(side == 'r'){
        for (i in 1..deep){
            var tmp: String  = "0"
            tmp = Integer.toBinaryString(argv.shr(i))
            println("${binToInt(tmp)} $tmp")
        }
    }else if(side == 'l'){
        for (i in 1..deep){
            var tmp: String  = "0"
            tmp = Integer.toBinaryString(argv.shl(i))
            println("${binToInt(tmp)} $tmp")
        }
    }else {
        println("Choice 3rd param 'r'-right or 'l'-left")
    }
}