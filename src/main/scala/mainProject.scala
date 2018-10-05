import scala.io._
import java.io._
import scala.io.Source
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props


object leitor extends App{
    val arquivo = Source.fromFile("src/main/scala/ppar")
    var matrizA = Array.ofDim[Int](1000,1000)
    
    case object EscravoComeceLeitura
    
    class Escravo extends Actor{
        def receive = {
            case EscravoComeceLeitura =>
                println("EscravoA começou a calcular")
                var coluna = 0
                var linha = 0
                var linhaStr = arquivo.getLines().next.mkString.split(" ")
                
                for(line <- arquivo.getLines){
                    while(coluna < 1000){
                        matrizA(coluna)(linha) = linhaStr(coluna).toInt
                        coluna = coluna + 1
                    }
                }
                println(matrizA(999)(0).toString())
                println(matrizA(0)(1).toString())
                println(matrizA(999)(999).toString())
                Thread.sleep(5000)
                sistema.shutdown
                arquivo.close
        }
    }
    
    val sistema = ActorSystem("Sistema")
    val escravo = sistema.actorOf(Props[Escravo], "escravo")
    
    escravo ! EscravoComeceLeitura
}

//object leitor extends Apps{
//    def main(args: Array[String]) : Unit {
//        println("Estou no método main")
//    }
//}