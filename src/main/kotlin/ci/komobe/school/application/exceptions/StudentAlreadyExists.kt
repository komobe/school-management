package ci.komobe.school.application.exceptions

/**
 * Exception thrown when attempting to create a student that already exists.
 *
 * @property studentId Identifier of the student that already exists.
 * @constructor Creates a StudentAlreadyExists exception with the provided studentId.
 * @author Moro KONÉ 2024-07-14
 */
data class StudentAlreadyExists(val studentId: String) :
    Exception("Student with id $studentId already exists")