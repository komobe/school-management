package ci.komobe.school.application.usescases

import ci.komobe.school.application.commands.EnrollStudentCommand
import ci.komobe.school.application.repositories.StudentRepository
import ci.komobe.school.application.usecases.EnrollStudentUseCase
import ci.komobe.school.core.aggregates.Student
import ci.komobe.school.core.entities.Enrollment
import ci.komobe.school.core.valuesobjects.SchoolYear
import ci.komobe.school.extensions.generateUUID
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import java.time.LocalDate

class EnrollUnitTest {

    @Test
    fun `should enroll student`() {
        // Given
        val studentId = String.generateUUID()
        val student = Student
            .builder(studentId)
            .firstName("John")
            .lastName("Doe")
            .dateOfBirth(LocalDate.of(1990, 1, 1))
            .build()

        val enrollStudentCommand = EnrollStudentCommand(
            studentId,
            gradeLevel = 10,
            status = Enrollment.Status.ACTIVE,
            schoolYear = SchoolYear.of(2010, 2011)
        )

        val studentRepository = mock<StudentRepository>()

        // When
        Mockito.`when`(studentRepository.findById(studentId)).thenReturn(student)

        val enrollStudentUseCase = EnrollStudentUseCase(studentRepository)
        enrollStudentUseCase.enroll(enrollStudentCommand)

        // Then
        verify(studentRepository).save(any())

        // Additional verification for enrollment details
        val capturedEnrollment = student.enrollments()[0]
        assert(enrollStudentCommand.schoolYear.toString() == capturedEnrollment.id)
        assert(capturedEnrollment.gradeLevel == enrollStudentCommand.gradeLevel)
        assert(capturedEnrollment.status == enrollStudentCommand.status)
    }
}
