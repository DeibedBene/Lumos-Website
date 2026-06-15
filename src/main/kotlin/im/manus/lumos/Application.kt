package im.manus.lumos

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.http.content.*
import io.ktor.server.sessions.*
import io.ktor.server.auth.*
import im.manus.lumos.plugins.*
import io.github.cdimascio.dotenv.dotenv

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val dotenv = dotenv {
        ignoreIfMissing = true
    }
    
    install(ContentNegotiation) {
        json()
    }
    
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause" , status = HttpStatusCode.InternalServerError)
        }
    }
    
    install(Sessions) {
        cookie<UserSession>("LUMOS_SESSION") {
            cookie.path = "/"
            cookie.maxAgeInSeconds = 60 * 60 * 24 * 7 // 1 week
        }
    }
    
    configureRouting()
}

data class UserSession(val userId: String, val username: String, val avatar: String?) : Principal
