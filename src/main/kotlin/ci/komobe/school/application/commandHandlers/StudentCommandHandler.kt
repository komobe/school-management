package ci.komobe.school.application.commandHandlers

import ci.komobe.school.application.CommandHandler
import ci.komobe.school.application.commands.EnrollStudentCommand
import ci.komobe.school.application.commands.RegisterStudentCommand
import ci.komobe.school.application.repositories.StudentRepository
import ci.komobe.school.application.usecases.EnrollStudentUseCase
import ci.komobe.school.application.usecases.RegisterStudentUseCase
import ci.komobe.school.extensions.generateUUID

/**
 * Handles commands related to student operations.
 *
 * @param studentRepository Repository for accessing and storing student data.
 *
 * @since 2024-07-15
 * @author Moro KONÉ 2024-07-15
 */
class StudentCommandHandler(private val studentRepository: StudentRepository) : CommandHandler {

    /**
     * Registers a new student using the provided command.
     *
     * @param command The command containing student registration details.
     * @return The ID of the newly registered student.
     */
    fun registerStudent(command: RegisterStudentCommand): String {
        val studentId = String.generateUUID()
        val registerStudentUseCase = RegisterStudentUseCase(studentRepository)
        registerStudentUseCase.register(studentId, command)
        return studentId
    }

    /**
     * Enrolls a student into a school year and grade level.
     *
     * @param command The command containing enrollment details.
     */
    fun enrollStudent(command: EnrollStudentCommand) {
        val enrollStudentUseCase = EnrollStudentUseCase(studentRepository)
        enrollStudentUseCase.enroll(command)
    }
}