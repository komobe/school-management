package ci.komobe.school.core.aggregates

import ci.komobe.school.core.Aggregate
import ci.komobe.school.core.entities.Enrollment
import ci.komobe.school.core.exceptions.ValidationException
import java.time.LocalDate
import java.time.Period

const val MIN_AGE_STUDENT = 6

/**
 * Represents a Student entity in the school domain.
 *
 * @property id Unique identifier for the student.
 * @property firstName First name of the student.
 * @property lastName Last name of the student.
 * @property dateOfBirth Birthdate of the student.
 * @property enrollments List of enrollments associated with the student.
 */
class Student(
    private val studentId: String,
    private var firstName: String,
    private var lastName: String,
    private var dateOfBirth: LocalDate,
    private val enrollments: MutableList<Enrollment>
) : Aggregate<String>(studentId) {

    fun firstName(): String = firstName
    fun lastName(): String = lastName
    fun dateOfBirth(): LocalDate = dateOfBirth
    fun enrollments(): List<Enrollment> = enrollments.toList()


    companion object {
        /**
         * Creates a new instance of StudentBuilder for building a Student with the given ID.
         */
        fun builder(studentId: String): StudentBuilder {
            return StudentBuilder(studentId)
        }
    }

    /**
     * Adds a new enrollment to the student's list of enrollments.
     *
     * @param enrollment Enrollment to add.
     * @throws Exception if the enrollment already exists.
     */
    fun addNewEnrollment(enrollment: Enrollment) {
        if (enrollments.contains(enrollment)) {
            throw Exception("Enrollment already exists")
        }

        enrollments.add(enrollment)
    }

    /**
     * Builder class for creating instances of Student.
     *
     * @property id Identifier of the student.
     */
    class StudentBuilder constructor(private val id: String) {
        private val errors: MutableMap<String, String> = mutableMapOf()

        private var firstName: String = ""
        private var lastName: String = ""
        private var dateOfBirth: LocalDate = LocalDate.now()
        private var enrollments: MutableList<Enrollment> = mutableListOf()

        /**
         * Sets the first name of the student.
         *
         * @param firstName First name to set.
         * @return This StudentBuilder instance.
         */
        fun firstName(firstName: String) = apply {
            if (firstName.isBlank()) {
                errors["firstName"] = "First name is required"
            }
            this.firstName = firstName
        }

        /**
         * Sets the last name of the student.
         *
         * @param lastName Last name to set.
         * @return This StudentBuilder instance.
         */
        fun lastName(lastName: String) = apply {
            if (lastName.isBlank()) {
                errors["lastName"] = "Last name is required"
            }
            this.lastName = lastName
        }

        /**
         * Sets the date of birth of the student.
         *
         * @param dateOfBirth Date of birth to set.
         * @return This StudentBuilder instance.
         */
        fun dateOfBirth(dateOfBirth: LocalDate) = apply {
            if (dateOfBirth > LocalDate.now()) {
                errors["dateOfBirth"] = "Date of birth cannot be in the future"
            }

            val age = Period.between(dateOfBirth, LocalDate.now()).years

            if (age < MIN_AGE_STUDENT) {
                errors["dateOfBirth"] = "Student must be at least 6 years old"
            }

            this.dateOfBirth = dateOfBirth
        }

        /**
         * Sets the enrollments associated with the student.
         *
         * @param enrollments List of enrollments to set.
         * @return This StudentBuilder instance.
         */
        fun enrollments(enrollments: List<Enrollment>) = apply {
            this.enrollments = enrollments.toMutableList()
        }

        /**
         * Builds and returns a new instance of Student based on the set properties.
         *
         * @return A new instance of Student.
         * @throws ValidationException if there are validation errors.
         */
        fun build(): Student {

            if (errors.isNotEmpty()) {
                throw ValidationException(errors)
            }

            return Student(id, firstName, lastName, dateOfBirth, enrollments)
        }
    }
}