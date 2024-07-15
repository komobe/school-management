package ci.komobe.school.core.exceptions

/**
 * Exception thrown when validation errors occur.
 *
 * @property errors Map containing validation errors, where keys are field names and values are error messages.
 * @constructor Creates a ValidationException with the provided errors map.
 *
 * @since 2024-07-14
 * @author Moro KONÉ 2024-07-14
 */
class ValidationException(private val errors: Map<String, String>) : RuntimeException() {
    override val message: String
        get() = errors.entries.joinToString(", ") { "${it.key}: ${it.value}" }
}