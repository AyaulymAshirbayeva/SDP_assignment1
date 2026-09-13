package admission.builder;

import admission.product.AdmissionApplication;
import admission.product.AdmissionApplication.DegreeLevel;

public class ApplicationBuilder {

    private static final double MIN_GPA = 0.0;
    private static final double MAX_GPA = 4.0;
    private static final double MOBILITY_MIN_GPA = 3.0;
    private static final double VACANT_GRANT_MIN_GPA = 3.5;
    private static final double MIN_IELTS_SCORE = 6.0;

    private String firstName;
    private String lastName;
    private DegreeLevel degreeLevel;
    private String major;
    private double gpa;

    private Double ieltsScore;
    private String passportNumber;

    private String hostUniversity;
    private Integer mobilitySemesters;
    private boolean isLearningAgreementSigned;

    private String studentId;
    private boolean hasDisciplinaryRecords;

    public ApplicationBuilder setPersonalDetails(
            String firstName,
            String lastName
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        return this;
    }

    public ApplicationBuilder setAcademicInfo(
            DegreeLevel degreeLevel,
            String major,
            double gpa
    ) {
        this.degreeLevel = degreeLevel;
        this.major = major;
        this.gpa = gpa;
        return this;
    }

    public ApplicationBuilder setInternationalDetails(
            Double ieltsScore,
            String passportNumber
    ) {
        this.ieltsScore = ieltsScore;
        this.passportNumber = passportNumber;
        return this;
    }

    public ApplicationBuilder setMobilityDetails(
            String hostUniversity,
            Integer mobilitySemesters,
            boolean isLearningAgreementSigned
    ) {
        this.hostUniversity = hostUniversity;
        this.mobilitySemesters = mobilitySemesters;
        this.isLearningAgreementSigned = isLearningAgreementSigned;
        return this;
    }

    public ApplicationBuilder setVacantGrantDetails(
            String studentId,
            boolean hasDisciplinaryRecords
    ) {
        this.studentId = studentId;
        this.hasDisciplinaryRecords = hasDisciplinaryRecords;
        return this;
    }

    public ApplicationBuilder setInternalStudentDetails(String studentId) {
        this.studentId = studentId;
        return this;
    }

    public AdmissionApplication build() {
        validateBaseFields();
        validateInternationalRules();
        validateMobilityRules();
        validateVacantGrantRules();

        return new AdmissionApplication(this);
    }

    private void validateBaseFields() {
        if (firstName == null || firstName.isBlank()
                || lastName == null || lastName.isBlank()) {

            throw new IllegalStateException(
                    "First name and last name are required."
            );
        }

        if (degreeLevel == null || major == null || major.isBlank()) {
            throw new IllegalStateException(
                    "Degree level and major are required."
            );
        }

        if (gpa < MIN_GPA || gpa > MAX_GPA) {
            throw new IllegalStateException(
                    "GPA must be between " + MIN_GPA + " and " + MAX_GPA
            );
        }
    }

    private void validateInternationalRules() {
        if (ieltsScore != null && ieltsScore < MIN_IELTS_SCORE) {
            throw new IllegalStateException(
                    "Minimum IELTS score for international programs is "
                            + MIN_IELTS_SCORE
            );
        }

        if (ieltsScore != null
                && (passportNumber == null || passportNumber.isBlank())) {

            throw new IllegalStateException(
                    "Passport number is required when applying with international requirements."
            );
        }
    }

    private void validateMobilityRules() {
        if (hostUniversity != null) {

            if (gpa < MOBILITY_MIN_GPA) {
                throw new IllegalStateException(
                        "Minimum GPA for academic mobility is "
                                + MOBILITY_MIN_GPA
                );
            }

            if (ieltsScore == null || ieltsScore < MIN_IELTS_SCORE) {
                throw new IllegalStateException(
                        "Valid IELTS score (" + MIN_IELTS_SCORE
                                + "+) is required for exchange program."
                );
            }

            if (!isLearningAgreementSigned) {
                throw new IllegalStateException(
                        "Learning Agreement must be signed by the department before submitting mobility application."
                );
            }
        }
    }

    private void validateVacantGrantRules() {
        if (studentId != null) {

            if (gpa < VACANT_GRANT_MIN_GPA) {
                throw new IllegalStateException(
                        "Vacant grant requires minimum GPA of "
                                + VACANT_GRANT_MIN_GPA
                );
            }

            if (hasDisciplinaryRecords) {
                throw new IllegalStateException(
                        "Applicants with disciplinary records cannot apply for vacant grant."
                );
            }
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public DegreeLevel getDegreeLevel() {
        return degreeLevel;
    }

    public String getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }

    public Double getIeltsScore() {
        return ieltsScore;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getHostUniversity() {
        return hostUniversity;
    }

    public Integer getMobilitySemesters() {
        return mobilitySemesters;
    }

    public boolean isLearningAgreementSigned() {
        return isLearningAgreementSigned;
    }

    public String getStudentId() {
        return studentId;
    }

    public boolean hasDisciplinaryRecords() {
        return hasDisciplinaryRecords;
    }
}