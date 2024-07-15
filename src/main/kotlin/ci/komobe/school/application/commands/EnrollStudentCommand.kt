package ci.komobe.school.application.commands

import ci.komobe.school.core.entities.Enrollment
import ci.komobe.school.core.valuesobjects.SchoolYear

/**
 * Data class representing a command to enroll a student.
 *
 * @property studentId Identifier of the student to enroll.
 * @property schoolYear School year in which the student is being enrolled.
 * @property gradeLevel Grade level to assign to the student.
 * @property status Status of the enrollment (ACTIVE or INACTIVE).
 */
data class EnrollStudentCommand(
    val studentId: String,
    val schoolYear: SchoolYear,
    val gradeLevel: Int,
    val status: Enrollment.Status,
)