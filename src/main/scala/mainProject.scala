import scala.io._
import java.io._
import scala.io.Source
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import java.util.Scanner
import java.io.File;

object leitor extends App{
    var matrizA = Array.ofDim[Int](1000,1000)
    
    case object EscravoComeceLeitura
    
    class Escravo extends Actor{
        def receive = {
            case EscravoComeceLeitura => //escravo1 le o arquivo ppar
                val sc = new Scanner(new File("src/main/scala/ppar"))
                var x, y = 0
                while(sc.hasNextLine()){
                    var linha = sc.nextLine()
                    var valores = linha.split(" ")
                    while(x < 1000){
                        matrizA(x)(y) = valores(x).toInt
                        x = x + 1
                    }
                    x = 0
                    y = y + 1
                }
                sc.close
                sistema.shutdown
        }
    }
    
    val sistema = ActorSystem("Sistema")
    val escravo = sistema.actorOf(Props[Escravo], "escravo")
    
    escravo ! EscravoComeceLeitura
}