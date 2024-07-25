package ru.royal_tee.plugins

import com.ucasoft.ktor.simpleCache.SimpleCache
import com.ucasoft.ktor.simpleMemoryCache.memoryCache
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cachingheaders.*
import io.ktor.server.plugins.cors.routing.*
import kotlin.time.Duration.Companion.minutes

fun Application.configureHTTP() {
    install(CORS) {
        allowMethod(HttpMethod.Options)
        allowMethod(HttpMethod.Head)
        allowMethod(HttpMethod.Get)
        anyHost()
    }
    install(SimpleCache) {
        memoryCache {
            invalidateAt = 10.minutes
        }
    }
    install(CachingHeaders) {
        options { call, outgoingContent ->
            CachingOptions(CacheControl.MaxAge(maxAgeSeconds = 86400))
        }
    }
}
