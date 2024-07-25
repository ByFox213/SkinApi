package ru.royal_tee

import io.github.cdimascio.dotenv.dotenv
import kotlin.properties.ReadOnlyProperty

val SKINS_DIR by environment("/skins/resource")
val RENDER_DIR by environment("/skins/render")

val HOST by environment("0.0.0.0")
val PORT by environment(1540)

inline fun <reified T : Any> environment(defaultValue: T): ReadOnlyProperty<Any?, T> = ReadOnlyProperty { _, property ->
    dotenv { ignoreIfMissing = true }[property.name] as? T ?: System.getenv(property.name) as? T ?: defaultValue
}