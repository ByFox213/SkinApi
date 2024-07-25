package ru.royal_tee.plugins

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.royal_tee.RENDER_DIR
import ru.royal_tee.SKINS_DIR
import java.io.File

fun Application.configureRouting() {
    routing {
        staticFiles("/api/skins/resource", File(SKINS_DIR))
        staticFiles("/api/skins/render", File(RENDER_DIR))
        get("/api") {
            call.respondText("""
                By "ByFox" 
                Version: 0.0.2
            """.trimMargin())
        }
    }
}
