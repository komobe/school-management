package ci.komobe.school.extensions

import java.util.*

/**
 * Extension function to generate a UUID as a String.
 *
 * @return A randomly generated UUID as a String.
 */
fun String.Companion.generateUUID(): String = UUID.randomUUID().toString()