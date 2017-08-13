
import controllers.HomeController
import play.api.ApplicationLoader.Context
import play.api.routing.Router
import play.api.{Application, ApplicationLoader, BuiltInComponentsFromContext}
import router.Routes

class MoviesCrawlerAppLoader extends ApplicationLoader {
  override def load(context: ApplicationLoader.Context): Application = ???
}


class Components(context: Context) extends BuiltInComponentsFromContext(context) {
  override def router: Router = new Routes(httpErrorHandler,new HomeController, new controllers.Assets(httpErrorHandler))
}

