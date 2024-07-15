package ci.komobe.school.application.repositories

import ci.komobe.school.core.aggregates.Student

/**
 * Repository interface for managing operations related to students.
 *
 * @since 2024-07-13
 * @author Moro KONÉ 2024-07-13
 */
interface StudentRepository {

    /**
     * Checks if a student with the given ID exists.
     *
     * @param id Identifier of the student to check.
     * @return true if the student exists, false otherwise.
     */
    fun existsById(id: String): Boolean

    /**
     * Finds a student by their ID.
     *
     * @param studentId The ID of the student to find.
     * @return The found student, or null if no student with the ID exists.
     */
    fun findById(studentId: String): Student?

    /**
     * Saves or updates a student in the repository.
     *
     * @param student The student to save.
     */
    fun save(student: Student)
}