package ci.komobe.school.application.usecases

import ci.komobe.school.application.commands.RegisterStudentCommand
import ci.komobe.school.application.exceptions.StudentAlreadyExists
import ci.komobe.school.application.repositories.StudentRepository
import ci.komobe.school.core.aggregates.Student

/**
 * Use case for registering a new student.
 *
 * @param studentRepository Repository interface for student operations.
 *
 * @since 2024-07-13
 * @author Moro KONÉ 2024-07-13
 */
class RegisterStudentUseCase(private val studentRepository: StudentRepository) {

    /**
     * Registers a new student based on the provided command.
     *
     * @param studentId The Identified of student
     * @param command The command containing student registration details.
     * @throws StudentAlreadyExists If a student with the specified ID already exists.
     * @throws IllegalArgumentException If any required field is blank or null.
     */
    fun register(studentId: String, command: RegisterStudentCommand) {

        if (studentAlreadyExists(studentId)) {
            throw StudentAlreadyExists(studentId)
        }

        val student = Student.builder(studentId)
            .firstName(command.firstName)
            .lastName(command.lastName)
            .dateOfBirth(command.dateOfBirth)
            .build()

        studentRepository.save(student)
    }


    private fun studentAlreadyExists(studentId: String): Boolean {
        return studentRepository.existsById(studentId)
    }
}