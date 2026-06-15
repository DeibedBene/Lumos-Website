package im.manus.lumos.routes

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Route.dashboardRoute() {
    get("/dashboard/{guildId}") {
        // Aqui haveria uma verificação de login
        call.respondHtml {
            head {
                title("Configuração - Lumos")
                link(rel = "stylesheet", href = "/static/css/style.css")
                link(rel = "stylesheet", href = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css")
                meta(name = "viewport", content = "width=device-width, initial-scale=1")
            }
            body {
                attributes["data-theme"] = "dark"
                
                div("container-fluid") {
                    div("row") {
                        // Sidebar
                        nav("col-md-3 col-lg-2 d-md-block sidebar liquid-glass m-3 p-4") {
                            h4("mb-4") { +"Painel" }
                            ul("nav flex-column") {
                                li("nav-item mb-2") { a(href = "#", classes = "nav-link text-white") { +"Geral" } }
                                li("nav-item mb-2") { a(href = "#", classes = "nav-link text-white") { +"Economia" } }
                                li("nav-item mb-2") { a(href = "#", classes = "nav-link text-white") { +"Níveis (XP)" } }
                                li("nav-item mb-2") { a(href = "#", classes = "nav-link text-white") { +"Logs" } }
                            }
                        }

                        // Main Content
                        main("col-md-8 col-lg-9 ms-sm-auto px-md-4 mt-4") {
                            h2("mb-4") { +"Configurações do Servidor" }
                            
                            div("liquid-glass p-4 mb-4") {
                                h5 { +"Prefixo" }
                                div("input-group mt-3") {
                                    input(type = InputType.text, classes = "form-control bg-transparent text-white border-secondary") {
                                        value = "."
                                    }
                                    button(classes = "btn btn-lumos") { +"Salvar" }
                                }
                            }

                            div("liquid-glass p-4") {
                                h5 { +"Idioma" }
                                select("form-select bg-transparent text-white border-secondary mt-3") {
                                    option { +"Português (PT-BR)" }
                                    option { +"English (EN-US)" }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
