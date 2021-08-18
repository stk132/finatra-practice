package example.modules

import com.google.inject.{Provides, Singleton}
import com.twitter.finagle.Mysql
import com.twitter.finagle.client.DefaultPool
import com.twitter.finagle.mysql.{Client, Transactions}
import com.twitter.inject.TwitterModule
import com.twitter.util.Duration

import scala.concurrent.duration

object MySQLModule extends TwitterModule{

  type MySQLClient = Client with Transactions
  
  @Singleton
  @Provides
  def provideClient: MySQLClient = {
    Mysql
      .client
      .withCredentials("root", null)
      .withDatabase("hoge")
      .configured(DefaultPool.Param(low = 5, high = 30, bufferSize = 0, idleTime = Duration(5, duration.MINUTES), maxWaiters = Int.MaxValue))
      .newRichClient("127.0.0.1:3306")
  }
}
