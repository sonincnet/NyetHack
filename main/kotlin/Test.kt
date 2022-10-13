import java.io.File
import java.util.*
import java.net.URL

fun main() {
   val wantedURL = "https://esi.evetech.net/v1/fw/stats/"
   URL(wantedURL).readText().run(::println)

}

//fun tf(args: String) = args.split('/')