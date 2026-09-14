# University Admission Application System 

## 1. Domain Description
This project implements the **Builder Creational Design Pattern** in Java to manage the construction of complex **University Admission Applications** (`AdmissionApplication`).

The domain covers three distinct application pathways across different academic levels(Bachelor, Masters, Phd):
1. **International Admission:** Requires passport details and official language proficiency certificates (e.g., IELTS/TOEFL).
2. **Academic Mobility:** Designed for exchange students, requiring host university details, duration, and signed Learning Agreements.
3. **Vacant Grant:** Tailored for internal students applying for vacant state educational grants, requiring disciplinary checks and academic standings.

By leveraging the Builder pattern with a Fluent API, the system separates the construction logic of complex application objects from their representations, ensuring clean, step-by-step assembly and immutable product instantiation.

---

## 2. Project Architecture & Components

The application adheres to the classic GoF Builder structure combined with a Fluent API design:

- **Product (`admission.product.AdmissionApplication`):** The complex object being built. Represents an immutable university application with specific academic, personal, and program fields.
- **Builder Interface (`admission.builder.BuilderInterface`):** Defines the step-by-step construction interface, requiring method chaining (Fluent API).
- **Concrete Builder (`admission.builder.ApplicationBuilder`):** Implements `BuilderInterface`, stores temporary construction state, validates state invariants, and builds the final `AdmissionApplication` product.
- **Director (`admission.director.AdmissionDirector`):** Orchestrates predefined build sequences for standard application profiles (*International*, *Academic Mobility*, *Vacant Grant*).
- **Client (`admission.client.Main`):** Demonstrates application construction both via `AdmissionDirector` recipes and through direct Fluent API chaining.

---

## 3. Clean Code Principles Justifications

### Principle 1: Meaningful, Intention-Revealing Names
- **Justification:** Classes, methods, and variables clearly express their domain purpose without ambiguity. Method names explicitly state what attributes are being set rather than using generic names.
- **Code Comparison:**
```java
// BEFORE: Vague and non-descriptive
void buildPart(String s1, String s2, double d);

// AFTER: Intention-revealing parameters and domain terminology
@Override
public ApplicationBuilder setAcademicInfo(AdmissionApplication.DegreeLevel degreeLevel, String major, double gpa) {
    this.degreeLevel = degreeLevel;
    this.major = major;
    this.gpa = gpa;
    return this;
}
```
### Principle 2: Method Chaining (Fluent API)
- **Justification:** Setters return this (the builder instance), allowing client code and the director to chain configuration calls seamlessly, improving readability and reducing code verbosity.
- **Code Comparison:**
```java
// BEFORE: Verbose procedural calls
ApplicationBuilder builder = new ApplicationBuilder();
builder.setApplicationType(ApplicationType.VACANT_GRANT);
builder.setApplicantName("Arman Kassymov");
builder.setStudentId("230107");

// AFTER: Fluent method chaining
AdmissionApplication application = new ApplicationBuilder()
        .setApplicationType(ApplicationType.VACANT_GRANT)
        .setApplicantName("Arman Kassymov")
        .setStudentId("230107")
        .build();
```
### Principle 3: Validated Construction (State Invariant Enforcement)
- **Justification:** The terminal build() method enforces invariants and prevents the instantiation of incomplete or invalid domain objects by throwing an explicit IllegalStateException.
- **Code Comparison:**
```java
// BEFORE: Unvalidated construction producing broken objects
public AdmissionApplication getResult() {
    return new AdmissionApplication(...); // Might contain null required fields
}

// AFTER: Validated terminal build method
public AdmissionApplication build() {
    if (type == null || applicantName == null) {
        throw new IllegalStateException("Cannot build application: Application type and Applicant name are required.");
    }
    return new AdmissionApplication(...);
}
```
### Principle 4: No Magic Strings / Magic Numbers (Strong Typing with Enums)
- **Justification:** String literals and raw numeric indicators for application types and degree levels are replaced with strongly typed Enum structures to avoid runtime typos and ensure compile-time safety. 
- **Code Comparison:**
```java
// BEFORE: Magic strings prone to typos
builder.setType("INTERNATIONAL");
builder.setDegree("BACHELOR");

// AFTER: Strongly-typed Enum constants
builder.setApplicationType(AdmissionApplication.ApplicationType.INTERNATIONAL_ADMISSION);
builder.setAcademicInfo(AdmissionApplication.DegreeLevel.BACHELOR, "Software Engineering", 3.7);
```

### Principle 5: Single Responsibility Principle (SRP)
- **Justification:** Separation of concerns is strictly maintained across dedicated packages. The AdmissionApplication class only holds data, ApplicationBuilder handles mutable construction state and validation, and AdmissionDirector stores standard build recipes.
- **Code Excerpt:**
```java
// admission.director.AdmissionDirector encapsulates construction recipes:
public AdmissionApplication constructInternationalAdmission(BuilderInterface builder) {
    return builder
            .setApplicationType(AdmissionApplication.ApplicationType.INTERNATIONAL_ADMISSION)
            .setApplicantName("James Stephen")
            .setAcademicInfo(AdmissionApplication.DegreeLevel.BACHELOR, "Software Engineering", 3.7)
            .setPassport("N12345678", "USA")
            .setLanguageCertificate("IELTS", 8.0)
            .build();
}
```