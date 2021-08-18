package example

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class ExampleController2 extends Controller{
  get("/hello2") {request: Request =>
    info("hello2")
    "hello2" + request.params.getOrElse("name", "unknown")
  }
}
