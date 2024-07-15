package ci.komobe.school.core

/**
 * Base class for domain aggregates.
 *
 * @param TypeId The type of identifier used for the aggregate.
 * @property id The unique identifier of the aggregate.
 *
 * @since 2024-07-15
 * @author Moro KONÉ 2024-07-15
 */
abstract class Aggregate<TypeId>(protected val id: TypeId) {

    /**
     * Returns the unique identifier of the aggregate.
     */
    fun id(): TypeId = id

    /**
     * Checks equality between aggregates based on their identifiers.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Aggregate<*>) return false

        return id == other.id
    }

    /**
     * Generates a hash code based on the aggregate's identifier.
     */
    override fun hashCode(): Int {
        return id.hashCode()
    }
}
