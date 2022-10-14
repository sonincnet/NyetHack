import java.io.File
import java.util.*
import java.net.URL

fun main() {
    
    val URL1 = URL("https://esi.evetech.net/dev/markets/groups/208")
    URL1.readText().run(::println)

    val URL2 = URL("https://esi.evetech.net/v1/fw/stats/")
    URL2.readText().run(::println)

}