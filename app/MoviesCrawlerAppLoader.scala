
import controllers.HomeController
import play.api.ApplicationLoader.Context
import play.api.libs.ws.ahc.AhcWSComponents
import play.api.routing.Router
import play.api.{Application, ApplicationLoader, BuiltInComponentsFromContext}
import router.Routes

class MoviesCrawlerAppLoader extends ApplicationLoader {
  override def load(context: ApplicationLoader.Context): Application = new Components(context).application
}


class Components(context: Context) extends BuiltInComponentsFromContext(context) with AhcWSComponents{
  override def router: Router = new Routes(httpErrorHandler,new HomeController(wsClient), new controllers.Assets(httpErrorHandler))
}

