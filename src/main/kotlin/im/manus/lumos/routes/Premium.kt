package im.manus.lumos.routes

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Route.premiumRoute() {
    get("/premium") {
        call.respondHtml {
            head {
                title("Premium - Lumos")
                link(rel = "stylesheet", href = "/static/css/style.css")
                link(rel = "stylesheet", href = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css")
                meta(name = "viewport", content = "width=device-width, initial-scale=1")
            }
            body {
                attributes["data-theme"] = "dark"
                
                main("container mt-5 py-5") {
                    div("text-center mb-5") {
                        h1("display-4 fw-bold") { +"Lumos " ; span("text-primary") { +"Premium" } }
                        p("lead opacity-75") { +"Apoie o desenvolvimento e desbloqueie recursos exclusivos." }
                    }

                    div("row g-4 justify-content-center") {
                        div("col-md-4") {
                            div("liquid-glass p-5 h-100 text-center border-primary") {
                                h3 { +"Mensal" }
                                h2("my-4") { +"R$ 15,00" }
                                ul("list-unstyled text-start mb-5 opacity-75") {
                                    li("mb-2") { +"✨ Ícone exclusivo no perfil" }
                                    li("mb-2") { +"✨ Multiplicador de XP 2x" }
                                    li("mb-2") { +"✨ Comandos de música premium" }
                                    li("mb-2") { +"✨ Suporte prioritário" }
                                }
                                button(classes = "btn btn-lumos w-100") { +"Assinar com Pix" }
                            }
                        }
                    }

                    div("mt-5 p-4 liquid-glass text-center") {
                        h5 { +"Pagamento via Pix" }
                        p("opacity-75") { +"Ao clicar em assinar, você receberá uma chave Pix para realizar o pagamento. Após a confirmação, seus benefícios serão ativados instantaneamente." }
                        div("bg-white p-3 d-inline-block rounded-3 mb-3") {
                            // Placeholder para QR Code
                            img(src = "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=LumosPremiumPix", classes = "img-fluid") {}
                        }
                        p { code { +"chave-pix-exemplo-lumos@email.com" } }
                    }
                }
            }
        }
    }
}
