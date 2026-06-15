package im.manus.lumos.routes

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Route.supportRoute() {
    get("/support") {
        call.respondHtml {
            head {
                title("Suporte - Lumos")
                link(rel = "stylesheet", href = "/static/css/style.css")
                link(rel = "stylesheet", href = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css")
                meta(name = "viewport", content = "width=device-width, initial-scale=1")
            }
            body {
                attributes["data-theme"] = "dark"
                
                main("container mt-5 py-5") {
                    div("row justify-content-center") {
                        div("col-md-8") {
                            h1("fw-bold mb-4") { +"Central de Ajuda" }
                            
                            div("accordion accordion-flush liquid-glass p-3") {
                                id = "faqAccordion"
                                
                                div("accordion-item bg-transparent text-white border-bottom border-secondary") {
                                    h2("accordion-header") {
                                        button(classes = "accordion-button collapsed bg-transparent text-white", type = ButtonType.button) {
                                            attributes["data-bs-toggle"] = "collapse"
                                            attributes["data-bs-target"] = "#faq1"
                                            +"Como adiciono o Lumos ao meu servidor?"
                                        }
                                    }
                                    div("accordion-collapse collapse") {
                                        id = "faq1"
                                        attributes["data-bs-parent"] = "#faqAccordion"
                                        div("accordion-body opacity-75") {
                                            +"Basta clicar no botão 'Adicionar ao Discord' na página inicial e autorizar o bot com as permissões necessárias."
                                        }
                                    }
                                }

                                div("accordion-item bg-transparent text-white") {
                                    h2("accordion-header") {
                                        button(classes = "accordion-button collapsed bg-transparent text-white", type = ButtonType.button) {
                                            attributes["data-bs-toggle"] = "collapse"
                                            attributes["data-bs-target"] = "#faq2"
                                            +"O bot é gratuito?"
                                        }
                                    }
                                    div("accordion-collapse collapse") {
                                        id = "faq2"
                                        attributes["data-bs-parent"] = "#faqAccordion"
                                        div("accordion-body opacity-75") {
                                            +"Sim! A maioria das funções do Lumos são gratuitas. Temos recursos Premium para quem deseja apoiar o projeto."
                                        }
                                    }
                                }
                            }

                            div("mt-5 text-center") {
                                h4 { +"Ainda precisa de ajuda?" }
                                a(href = "https://discord.gg/lumos", classes = "btn btn-lumos mt-3") { +"Entrar no Servidor de Suporte" }
                            }
                        }
                    }
                }
            }
        }
    }
}
