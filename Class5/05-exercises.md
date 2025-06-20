
# Maven and JSON exercises

## Exercise 1:
 - Create a Java class Student with properties name (String), age (int), and email (String).
 - Write a Java program to serialize an object of Student class into JSON.
 - Deserialize the JSON back into a Student object.

## Exercise 2:
 - Create StudentWithCourses class to have the same fields as Student class but also include a new field List<String> courses but ignore it during serialization.
 - Customize the serialization of email field to appear as emailAddress in the JSON.
 - Handle null values gracefully during serialization.

## Exercise 3:
- Create StudentWithGrades class to have the same fields as StudentWithCourses class but also include a new field
  Map<String, Double> grades representing course names and their corresponding grades.
- Serialize an object of StudentWithGrades that includes a list of courses and a map of grades.
- Deserialize the JSON back, ensuring the list and map are correctly populated. (print all student fields)

## Exercise 4:
- Create StudentWithBirthday class to have the same fields as Student class but also include a new field birthday
- Create a LocalDateSerializer and LocalDateDeserializer for handling java.time.LocalDate fields in the Student class.
- Add a LocalDate birthDate field to the Student class.
- Serialize and deserialize a Student object, ensuring the birthDate is correctly handled.
