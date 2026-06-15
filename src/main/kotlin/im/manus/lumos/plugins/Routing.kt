package im.manus.lumos.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.html.*
import kotlinx.html.*
import im.manus.lumos.routes.*

fun Application.configureRouting() {
    routing {
        staticResources("/static", "static")
        
        get("/") {
            call.respondHtml {
                head {
                    title("Lumos - Ilumine seu Servidor")
                    link(rel = "stylesheet", href = "/static/css/style.css")
                    link(rel = "stylesheet", href = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css")
                    script(src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js") {}
                    meta(name = "viewport", content = "width=device-width, initial-scale=1")
                }
                body {
                    attributes["data-theme"] = "dark"
                    
                    nav("navbar navbar-expand-lg navbar-lumos") {
                        div("container") {
                            a(href = "/", classes = "navbar-brand fw-bold text-white") { +"Lumos" }
                            button(classes = "navbar-toggler", type = ButtonType.button) {
                                attributes["data-bs-toggle"] = "collapse"
                                attributes["data-bs-target"] = "#navbarNav"
                                span("navbar-toggler-icon") {}
                            }
                            div("collapse navbar-collapse") {
                                id = "navbarNav"
                                ul("navbar-nav ms-auto") {
                                    li("nav-item") { a(classes = "nav-link text-white", href = "/") { +"Início" } }
                                    li("nav-item") { a(classes = "nav-link text-white", href = "/commands") { +"Comandos" } }
                                    li("nav-item") { a(classes = "nav-link text-white", href = "/premium") { +"Premium" } }
                                    li("nav-item") { a(classes = "nav-link text-white", href = "/support") { +"Suporte" } }
                                    li("nav-item") { a(classes = "nav-link text-white", href = "/daily") { +"Daily" } }
                                    li("nav-item") { 
                                        a(classes = "btn btn-lumos ms-lg-3", href = "/login") { +"Login com Discord" }
                                    }
                                }
                            }
                        }
                    }
                    
                    main("container mt-5 pt-5") {
                        div("row align-items-center min-vh-75") {
                            div("col-lg-6 animate-fade-in") {
                                h1("display-3 fw-bold mb-4") {
                                    +"Ilumine seu servidor com o "
                                    span(classes = "text-primary") { +"Lumos" }
                                }
                                p("lead mb-5 opacity-75") {
                                    +"O bot multifuncional mais completo e elegante para sua comunidade no Discord. Economia, Moderação, Diversão e muito mais."
                                }
                                div("d-flex gap-3 flex-wrap") {
                                    button(classes = "btn btn-lumos btn-lg") { +"Adicionar ao Discord" }
                                    a(href = "/commands", classes = "btn btn-glass btn-lg") { +"Ver Comandos" }
                                }
                            }
                            div("col-lg-6 d-none d-lg-block") {
                                div("liquid-glass p-5 text-center") {
                                    img(src = "https://cdn.discordapp.com/embed/avatars/0.png", classes = "rounded-circle mb-4 shadow-lg") {
                                        width = "200"
                                    }
                                    h2 { +"Lumos Bot" }
                                    p("opacity-75") { +"Pronto para brilhar no seu servidor!" }
                                }
                            }
                        }
                    }
                    
                    footer("mt-5 py-5 border-top border-secondary") {
                        div("container text-center opacity-50") {
                            p { +"© 2026 Lumos Project. Todos os direitos reservados." }
                        }
                    }
                    
                    script(src = "/static/js/main.js") {}
                }
            }
        }
        
        commandsRoute()
        premiumRoute()
        supportRoute()
        dailyRoute()
        dashboardRoute()
    }
}
