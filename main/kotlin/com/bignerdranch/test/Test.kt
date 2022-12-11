private var testVal = "fdsd"


fun main() {
    val s = "hello\r"
    var z = ""
    if(s.contains("\r")){
        for(l in 0 until  s.length-1){
            z = z.plus(s[l])
        }
        println("DONE")
    }
    println("$z Jonny")
//    val player = Player(
//        "Jonny",
//        healthPoints = 300,
//        isBlessed = true,
//        isImmortal = false)
//
//    "${player.name} of ${player.hometown}".run(::print)
//    " ${player.formatHealthStatus()}".run(::println)
//
//    player.printVal()

}