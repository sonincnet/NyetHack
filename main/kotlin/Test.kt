import java.io.File
import java.util.*
import java.net.URL

fun main() {
    val url = URL("https://esi.evetech.net/dev/markets/groups/208")
    url.readText().run(::println)

}