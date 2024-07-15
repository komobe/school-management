package ci.komobe.school.application.usecases

import ci.komobe.school.application.commands.EnrollStudentCommand
import ci.komobe.school.application.exceptions.StudentNotFound
import ci.komobe.school.application.repositories.StudentRepository
import ci.komobe.school.core.entities.Enrollment
import java.time.LocalDate

/**
 * Use case for enrolling a student.
 *
 * @param studentRepository Repository interface for student operations.
 *
 * @since 2024-07-14
 *  @author Moro KONÉ 2024-07-14
 */
class EnrollStudentUseCase(private val studentRepository: StudentRepository) {

    /**
     * Enrolls a student based on the provided command.
     *
     * @param command The command containing enrollment details.
     * @throws StudentNotFound If no student with the specified ID is found.
     */
    fun enroll(command: EnrollStudentCommand) {
        val studentId = command.studentId
        val student = studentRepository.findById(studentId) ?: throw StudentNotFound(studentId)

        val enrollment = Enrollment(
            id = command.schoolYear.toString(),
            studentId = command.studentId,
            enrollmentDate = LocalDate.now(),
            gradeLevel = command.gradeLevel,
            status = command.status
        )

        student.addNewEnrollment(enrollment)

        studentRepository.save(student)
    }
}