package ci.komobe.school.application.exceptions

/**
 * Exception thrown when attempting to find a student that does not exist.
 *
 * @param studentId Identifier of the student that was not found.
 * @author Moro KONÉ 2024-07-14
 */
data class StudentNotFound(val studentId: String) :
    RuntimeException("Student with ID $studentId not found")