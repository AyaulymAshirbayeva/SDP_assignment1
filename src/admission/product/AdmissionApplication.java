package admission.product;

import admission.builder.ApplicationBuilder;

public class AdmissionApplication {

    public enum DegreeLevel {
        BACHELOR,
        MASTER,
        PHD
    }

    private final String firstName;
    private final String lastName;
    private final DegreeLevel degreeLevel;
    private final String major;
    private final double gpa;

    private final String studentId;

    // International
    private final Double ieltsScore;
    private final String passportNumber;

    // Academic Mobility
    private final String hostUniversity;
    private final Integer mobilitySemesters;
    private final boolean isLearningAgreementSigned;

    // Vacant Grant
    private final boolean hasDisciplinaryRecords;

    public AdmissionApplication(ApplicationBuilder builder) {
        this.firstName = builder.getFirstName();
        this.lastName = builder.getLastName();
        this.degreeLevel = builder.getDegreeLevel();
        this.major = builder.getMajor();
        this.gpa = builder.getGpa();
        this.studentId = builder.getStudentId();
        this.ieltsScore = builder.getIeltsScore();
        this.passportNumber = builder.getPassportNumber();
        this.hostUniversity = builder.getHostUniversity();
        this.mobilitySemesters = builder.getMobilitySemesters();
        this.isLearningAgreementSigned = builder.isLearningAgreementSigned();
        this.hasDisciplinaryRecords = builder.hasDisciplinaryRecords();
    }

    @Override
    public String toString() {
        return "AdmissionApplication {\n" +
                "  Name: " + firstName + " " + lastName +
                (studentId != null ? " (ID: " + studentId + ")" : "") + "\n" +
                "  Degree: " + degreeLevel +
                " | Major: " + major +
                " | GPA: " + gpa + "\n" +
                (ieltsScore != null
                        ? "  IELTS: " + ieltsScore +
                        " | Passport: " + passportNumber + "\n"
                        : "") +
                (hostUniversity != null
                        ? "  Mobility Host: " + hostUniversity +
                        " (" + mobilitySemesters +
                        " sem) | Learning Agreement: " +
                        isLearningAgreementSigned + "\n"
                        : "") +
                (hasDisciplinaryRecords
                        ? "  Disciplinary Warning: YES\n"
                        : "") +
                '}';
    }
}