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
    var matrizB = Array.ofDim[Int](1000,1000)
    var matrizBtransposta = Array.ofDim[Int](1000,1000)
    
    case object EscravoComeceLeitura
    
    class EscravoA extends Actor{
        def receive = {
            case EscravoComeceLeitura => //escravoA le o arquivo ppar
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
                Thread.sleep(2000)
                sc.close
                sistema.shutdown
        }
    }
    
    class EscravoB extends Actor{
        def receive = {
            case EscravoComeceLeitura => //escravoB le o arquivo ppar
                val sc = new Scanner(new File("src/main/scala/ppar2"))
                var x, y = 0
                while(sc.hasNextLine()){
                    var linha = sc.nextLine()
                    var valores = linha.split(" ")
                    while(x < 1000){
                        matrizB(x)(y) = valores(x).toInt
                        matrizBtransposta(y)(x) = valores(x).toInt
                        x = x + 1
                    }
                    x = 0
                    y = y + 1
                }
                
                println(matrizB(999)(999))
                println(matrizBtransposta(0)(999))
                
                Thread.sleep(200)
                sc.close
                sistema.shutdown
        }
    }
    
    val sistema = ActorSystem("Sistema")
    val escravoA = sistema.actorOf(Props[EscravoA], "escravoA")
    val escravoB = sistema.actorOf(Props[EscravoB], "escravoB")
    
    escravoA ! EscravoComeceLeitura
    escravoB ! EscravoComeceLeitura
}