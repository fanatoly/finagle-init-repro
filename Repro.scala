package repro
import com.twitter.finagle.Http

object Repro {
  def main(args: Array[String]): Unit = {
    val f = Http.Client().newService("google.com:80")
// at this point, we've hit this situation:
// main[1] dump this
//  this = {
//     MODULE$: instance of com.twitter.finagle.Http$Client$(id=3318)
//     stack: null
// }
// main[1] where
//   [1] com.twitter.finagle.Http$Client$.stack (Http.scala:147)
//   [2] com.twitter.finagle.Http$Client$.apply$default$1 (Http.scala:164)
//   [3] com.twitter.finagle.Http$.<init> (Http.scala:288)
//   [4] com.twitter.finagle.Http$.<clinit> (null)
//   [5] com.twitter.finagle.Http$Client$.<init> (Http.scala:154)
//   [6] com.twitter.finagle.Http$Client$.<clinit> (null)
// This will NPE for the rest of time
    Http.client.newService("google.com:80")

  }
}
