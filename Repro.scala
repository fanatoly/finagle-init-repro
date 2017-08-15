package repro
import com.twitter.finagle.Http

object Repro {
  def main(args: Array[String]): Unit = {
    val f = Http.Client()
    Http.client.newService("http://google.com:80")

  }
}
