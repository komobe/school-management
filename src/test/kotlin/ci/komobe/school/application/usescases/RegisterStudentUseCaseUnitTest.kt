package ci.komobe.school.application.usescases

import ci.komobe.school.application.usecases.RegisterStudentUseCase
import ci.komobe.school.application.commands.RegisterStudentCommand
import ci.komobe.school.application.repositories.StudentRepository
import ci.komobe.school.extensions.generateUUID
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import java.time.LocalDate
import kotlin.test.Test

/**
 * @author Moro KONÉ 2024-07-13
 */
class RegisterStudentUseCaseUnitTest {

    @Test
    fun `should registry new student`() {
        // Given
        val studentId = String.generateUUID()
        val registerStudentCommand = RegisterStudentCommand(
            firstName = "John",
            lastName = "Doe",
            dateOfBirth = LocalDate.of(1980, 1, 1),
        )

        val studentRepository = mock(StudentRepository::class.java)

        // When
        `when`(studentRepository.existsById(studentId)).thenReturn(false)
        val registerStudentUseCase = RegisterStudentUseCase(studentRepository)
        registerStudentUseCase.register(studentId, registerStudentCommand)

        // Then
        verify(studentRepository).save(any())
    }
}