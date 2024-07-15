package ci.komobe.school.core.entities

import java.time.LocalDate

/**
 * Represents an enrollment of a student.
 *
 * @property id Unique identifier for the enrollment.
 * @property studentId Identifier of the student associated with this enrollment.
 * @property enrollmentDate Date when the student was enrolled.
 * @property gradeLevel Grade level of the student at the time of enrollment.
 * @property status Status of the enrollment (active or inactive).
 *
 * @constructor Creates an Enrollment object with the specified properties.
 */
class Enrollment(
    val id: String,
    var studentId: String,
    var enrollmentDate: LocalDate,
    var gradeLevel: Int,
    var status: Status,
) {
    /**
     * Enum representing the status of an enrollment.
     */
    enum class Status {
        ACTIVE, INACTIVE
    }
}