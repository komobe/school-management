package ci.komobe.school.core.valuesobjects

import java.time.Year

/**
 * Represents a school year with a start year and an end year.
 *
 * @property start The start year of the school year.
 * @property end The end year of the school year.
 * @constructor Creates an instance of SchoolYear with the specified start and end years.
 *
 * @author Moro KONÉ 2024-07-13
 * @since 2024-07-13
 */
data class SchoolYear (val start: Year, val end: Year) : Comparable<SchoolYear> {

    companion object {
        fun of(start: Int, end: Int): SchoolYear = SchoolYear(Year.of(start), Year.of(end))
    }

    override fun compareTo(other: SchoolYear): Int {
        return start.compareTo(other.start)
    }

    override fun toString(): String {
        return "$start - $end"
    }
}