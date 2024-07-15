package ci.komobe.school.core

/**
 * Functional interface representing a builder that constructs an object of type T.
 *
 * @author Moro KONÉ 2024-07-14
 */
internal fun interface Builder<T> {
    /**
     * Builds and returns an object of type T.
     */
    fun build(): T
}