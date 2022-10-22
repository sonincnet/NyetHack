import java.io.File
import java.util.*
import java.net.URL

private var testVal = "fdsd"


fun main() {

    var smt: String = "sdf"
    smt.run(::println)
}

fun rdAPI(){
    val URL1 = URL("https://esi.evetech.net/dev/markets/groups/208")
    URL1.readText().run(::println)

    val URL2 = URL("https://esi.evetech.net/v1/fw/stats/")
    URL2.readText().run(::println)

}