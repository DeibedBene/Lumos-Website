package im.manus.lumos.routes

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Route.commandsRoute() {
    get("/commands") {
        call.respondHtml {
            head {
                title("Comandos - Lumos")
                link(rel = "stylesheet", href = "/static/css/style.css")
                link(rel = "stylesheet", href = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css")
                meta(name = "viewport", content = "width=device-width, initial-scale=1")
            }
            body {
                attributes["data-theme"] = "dark"
                
                // Navbar Reutilizável (Idealmente seria um template)
                nav("navbar navbar-expand-lg navbar-lumos") {
                    div("container") {
                        a(href = "/", classes = "navbar-brand fw-bold text-white") { +"Lumos" }
                        div("collapse navbar-collapse") {
                            ul("navbar-nav ms-auto") {
                                li("nav-item") { a(classes = "nav-link text-white", href = "/") { +"Início" } }
                                li("nav-item") { a(classes = "nav-link active text-white", href = "/commands") { +"Comandos" } }
                                li("nav-item") { a(classes = "nav-link text-white", href = "/premium") { +"Premium" } }
                            }
                        }
                    }
                }

                main("container mt-5") {
                    h2("display-5 fw-bold mb-5 text-center") { +"Nossos Comandos" }
                    
                    div("row g-4") {
                        val categories = listOf("Moderação", "Diversão", "Utilidades", "Economia")
                        categories.forEach { category ->
                            div("col-md-6 col-lg-3") {
                                div("liquid-glass p-4 h-100 text-center") {
                                    h4("mb-3") { +category }
                                    p("opacity-75") { +"Explore todos os comandos de $category." }
                                    button(classes = "btn btn-glass mt-3 w-100") { +"Ver Lista" }
                                }
                            }
                        }
                    }

                    div("mt-5 pt-5") {
                        table("table table-borderless text-white liquid-glass p-4") {
                            thead {
                                tr {
                                    th { +"Comando" }
                                    th { +"Descrição" }
                                    th { +"Uso" }
                                }
                            }
                            tbody {
                                tr {
                                    td { code { +".ping" } }
                                    td { +"Verifica a latência do bot." }
                                    td { +".ping" }
                                }
                                tr {
                                    td { code { +".ban" } }
                                    td { +"Bane um usuário do servidor." }
                                    td { +".ban @user [motivo]" }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
