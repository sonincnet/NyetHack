import java.io.File

fun main() {
//    val rd = File("./src/main/data/file.txt").readText().split("\n")
//    rd.random().run(::println)
//    val ls = listOf()
    val planets = setOf("Mercury", "Venus", "Earth", "Earth")

    planets.run(::println)
    planets.contains("Pluto").run(::println)
    planets.elementAt(2).run(::println)
}

//fun tf(args: String) = args.split('/')