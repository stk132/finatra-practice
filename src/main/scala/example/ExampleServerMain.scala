package example

import com.google.inject.Module
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter
import example.modules.MySQLModule

object ExampleServerMain extends ExampleServer

class ExampleServer extends HttpServer {

  override def modules: Seq[Module] = Seq(MySQLModule)
  
  override protected def configureHttp(router: HttpRouter): Unit = {
    router
      .filter[CommonFilters]
      .add[ExampleController]
      .add[ExampleController2]
  }
}