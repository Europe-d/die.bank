// todo aufgaben a
var kunden: MutableMap<String, Double> = mutableMapOf(
    "Maxi Papadopoulou" to 230.000,
    "Nikos Mavridis" to 4000.000,
    "Patric Marsino" to 3400.000,
    "Alex Sideris" to 4500.000,
    "Maria Athanasi" to 5600.000,
    "Anna Loukidou" to 2300.000,
    "Petros Kritikakis" to 0.00,
)
var pin: Int = 1234
//todo aufgaben b


fun kontostand(name: String): Double? {

    val konto = kunden[name]

    if (konto != null) return konto
    else {
        println("gibt keine Empfängername")
    }
    return null


}
//todo aufgaben 3

fun neuekonto(name1: String) {


    //kunden.contains(name1)
    if (kunden.containsKey(name1)) {
        println("Bitte geben Sie Ihren richtigen Namen an")
    } else {
        kunden[name1] = 0.00
        println("Vielen Dank Sie haben erfolgreich Neue Konto erstellen")
    }
}

//todo aufgaben 4


fun kontoloeschen() {


    var nameLoeschen = readln()
    try {
        kunden.remove(nameLoeschen)
        println("Vielen dank deine konto wurde gelöscht")

    } catch (ex: Exception) {
        (ex.message)
        println("Bitte geben Sie Ihren richtigen Namen an")
        return kontoloeschen()
    }
}

// todo AUFGABEN 5 MIT AUSZAHLUNG

fun auszahlenVonKonto() {

    println("geben sie bitte Ihre name ein ")
    var nameVonKunden = readln()

    var betragAufKonto = kunden[nameVonKunden]

    if (kunden.keys.contains(nameVonKunden)) {

        if (betragAufKonto != null) {
            if (betragAufKonto > 0.00) {
                println("wie viele Geld möchten Sie auszahlung?")
                var kontoBetrag = readln().toDouble()
                if (betragAufKonto >= kontoBetrag && kontoBetrag < 500.00) {
                    betragAufKonto = betragAufKonto - kontoBetrag

                    println("Der Betrag von $kontoBetrag  wurde abgezogen ")
                } else {
                    println("Sie werden mehr Geld sparen müssen, weil es nicht reicht.")
                }


            } else {
                println("Sie haben keine betrag auf Ihre konto .Auszahlung nicht möglich")
            }
        }
    } else {
        println("Sie haben keine konto bei uns")
    }
}


//todo aufgaben 6

fun einzahlenVonKonto() {


    println("geben sie bitte Ihre name ein ")
    var nameVonKunden = readln()

    var betragAufKonto = kunden[nameVonKunden]

    println("geben sie bitte Ihre pin ein ")
    var pinVonKunden: Int = readln().toInt()


    if (pinVonKunden == pin) {

        if (betragAufKonto != null) {

            println("wie viele Geld möchten Sie einzahlung?")
            var betragEinZahlung = readln().toDouble()
            if (betragEinZahlung < 500.00) {
                betragAufKonto = betragAufKonto + betragEinZahlung
                kunden[nameVonKunden] = betragAufKonto
                println("Der Betrag von $betragEinZahlung  wurde gespeichert $betragAufKonto")
            } else {
                println("Bitte wenige betrag als 500Euro ")
            }

        } else {
            println("Sie haben keine konto auf uns")
        }
    } else {
        println("Das passwort ist falsch ,probieren Sie wieder")
        return einzahlenVonKonto()
    }
}


fun main() {

    println("Empfängername eingeben : ")
    println(kontostand(readln()))

    println(kunden)
    println("Empfängername eingeben für neue konto: ")
    neuekonto(readln())
    println(kunden)
    println("Bitte geben sie die Vollstädingen name von konto was sie löschen möchten")
    kontoloeschen()
    println(kunden)

    auszahlenVonKonto()
    einzahlenVonKonto()
    println(kunden)

}





