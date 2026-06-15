package im.manus.lumos.routes

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Route.dailyRoute() {
    get("/daily") {
        call.respondHtml {
            head {
                title("Daily - Lumos")
                link(rel = "stylesheet", href = "/static/css/style.css")
                link(rel = "stylesheet", href = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css")
                meta(name = "viewport", content = "width=device-width, initial-scale=1")
            }
            body {
                attributes["data-theme"] = "dark"
                
                main("container mt-5 py-5") {
                    div("row justify-content-center") {
                        div("col-md-6") {
                            div("liquid-glass p-5 text-center") {
                                h1("mb-4") { +"Recompensa Diária" }
                                p("opacity-75 mb-5") { +"Resgate seus Galeões diários para usar no sistema de economia!" }
                                
                                div("mb-5") {
                                    h3("text-primary") { +"💰 112 - 2468 Galeões" }
                                    p("small opacity-50") { +"Disponível a cada 24 horas" }
                                }
                                
                                button(classes = "btn btn-lumos btn-lg w-100") { +"Resgatar Agora" }
                                
                                div("mt-5 d-flex justify-content-center gap-3") {
                                    a(href = "/shop", classes = "btn btn-glass btn-sm") { +"Lojinha" }
                                    a(href = "/profile/settings", classes = "btn btn-glass btn-sm") { +"Configurar Perfil" }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
