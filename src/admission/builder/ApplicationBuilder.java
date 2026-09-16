package admission.builder;

import admission.product.AdmissionApplication;

public class ApplicationBuilder implements BuilderInterface {
    private AdmissionApplication.ApplicationType type;
    private String applicantName;
    private String studentId;

    private AdmissionApplication.DegreeLevel degreeLevel;
    private String major;
    private double gpa;

    // info for international students
    private String passportNumber;
    private String citizenship;
    private String languageTestType;
    private double languageScore;

    // academ mobility
    private String hostUniversity;
    private int mobilitySemesters;
    private boolean isLearningAgreementSigned;

    // vacant grant
    private boolean isApplyingForVacantGrant;
    private boolean hasDisciplinaryRecords;

    @Override
    public ApplicationBuilder setApplicationType(AdmissionApplication.ApplicationType type) {
        this.type = type;
        return this;
    }

    @Override
    public ApplicationBuilder setApplicantName(String applicantName) {
        this.applicantName = applicantName;
        return this;
    }

    @Override
    public ApplicationBuilder setStudentId(String studentId) {
        this.studentId = studentId;
        return this;
    }

    @Override
    public ApplicationBuilder setAcademicInfo(AdmissionApplication.DegreeLevel degreeLevel, String major, double gpa) {
        this.degreeLevel = degreeLevel;
        this.major = major;
        this.gpa = gpa;
        return this;
    }

    @Override
    public ApplicationBuilder setPassport(String passportNumber, String citizenship) {
        this.passportNumber = passportNumber;
        this.citizenship = citizenship;
        return this;
    }

    @Override
    public ApplicationBuilder setLanguageCertificate(String languageTestType, double languageScore) {
        this.languageTestType = languageTestType;
        this.languageScore = languageScore;
        return this;
    }

    @Override
    public ApplicationBuilder setMobilityProgram(String hostUniversity, int mobilitySemesters, boolean isLearningAgreementSigned) {
        this.hostUniversity = hostUniversity;
        this.mobilitySemesters = mobilitySemesters;
        this.isLearningAgreementSigned = isLearningAgreementSigned;
        return this;
    }

    @Override
    public ApplicationBuilder setVacantGrantInfo(boolean isApplyingForVacantGrant, boolean hasDisciplinaryRecords) {
        this.isApplyingForVacantGrant = isApplyingForVacantGrant;
        this.hasDisciplinaryRecords = hasDisciplinaryRecords;
        return this;
    }

    public AdmissionApplication build() {
        if (type == null || applicantName == null) {
            throw new IllegalStateException("Cannot build application: Application type and Applicant name are required.");
        }

        return new AdmissionApplication(
                type, applicantName, studentId, degreeLevel, major, gpa,
                passportNumber, citizenship, languageTestType, languageScore,
                hostUniversity, mobilitySemesters, isLearningAgreementSigned,
                isApplyingForVacantGrant, hasDisciplinaryRecords
        );
    }
}
