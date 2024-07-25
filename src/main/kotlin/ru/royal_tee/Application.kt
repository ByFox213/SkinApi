package ru.royal_tee

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import ru.royal_tee.plugins.*

fun main() {
    embeddedServer(Netty, port = PORT, host = HOST, module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureLogging()
    configureHTTP()
    configureRouting()
}
