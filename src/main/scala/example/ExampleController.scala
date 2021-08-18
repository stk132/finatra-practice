package example

import com.google.inject.Inject
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import example.modules.MySQLModule.MySQLClient

class ExampleController @Inject()(client: MySQLClient) extends Controller{

  get("/hello") {request: Request =>
    info("hello")
    "hello" + request.params.getOrElse("name", "unknown")
  }
  
  get("/mysql") {request: Request =>
    info("mysql")
    client.select("select 5*25 as `num`") {r => r.getLong("num").getOrElse(0L)}
  }
}
