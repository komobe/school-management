package ci.komobe.school.application.commands

import java.time.LocalDate

/**
 * Data class representing a command to register a new student.
 *
 * @property firstName First name of the student.
 * @property lastName Last name of the student.
 * @property dateOfBirth Birthdate of the student.
 */
data class RegisterStudentCommand(
    val firstName: String,
    val lastName: String,
    val dateOfBirth: LocalDate,
)