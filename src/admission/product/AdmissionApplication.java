package admission.product;

public class AdmissionApplication {

    public enum ApplicationType {
        INTERNATIONAL_ADMISSION,
        ACADEMIC_MOBILITY,
        VACANT_GRANT
    }

    public enum DegreeLevel {
        BACHELOR,
        MASTER,
        PHD
    }

    private final ApplicationType type;
    private final String applicantName;
    private final String studentId;
    private final DegreeLevel degreeLevel;
    private final String major;
    private final double gpa;

    // international
    private final String passportNumber;
    private final String citizenship;
    private final String languageTestType;
    private final double languageScore;

    // mobility program
    private final String hostUniversity;
    private final int mobilitySemesters;
    private final boolean isLearningAgreementSigned;

    // vacant grant
    private final boolean isApplyingForVacantGrant;
    private final boolean hasDisciplinaryRecords;

    private String status = "SUBMITTED";

    public AdmissionApplication(ApplicationType type, String applicantName, String studentId,
                                DegreeLevel degreeLevel, String major, double gpa,
                                String passportNumber, String citizenship,
                                String languageTestType, double languageScore,
                                String hostUniversity, int mobilitySemesters, boolean isLearningAgreementSigned,
                                boolean isApplyingForVacantGrant, boolean hasDisciplinaryRecords) {
        this.type = type;
        this.applicantName = applicantName;
        this.studentId = studentId;
        this.degreeLevel = degreeLevel;
        this.major = major;
        this.gpa = gpa;
        this.passportNumber = passportNumber;
        this.citizenship = citizenship;
        this.languageTestType = languageTestType;
        this.languageScore = languageScore;
        this.hostUniversity = hostUniversity;
        this.mobilitySemesters = mobilitySemesters;
        this.isLearningAgreementSigned = isLearningAgreementSigned;
        this.isApplyingForVacantGrant = isApplyingForVacantGrant;
        this.hasDisciplinaryRecords = hasDisciplinaryRecords;
    }

    public ApplicationType getType() {
        return type;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public String getStudentId() {
        return studentId;
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

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getLanguageTestType() {
        return languageTestType;
    }

    public double getLanguageScore() {
        return languageScore;
    }

    public String getHostUniversity() {
        return hostUniversity;
    }

    public int getMobilitySemesters() {
        return mobilitySemesters;
    }

    public boolean isLearningAgreementSigned() {
        return isLearningAgreementSigned;
    }

    public boolean isApplyingForVacantGrant() {
        return isApplyingForVacantGrant;
    }

    public boolean hasDisciplinaryRecords() {
        return hasDisciplinaryRecords;
    }

    public String getStatus() {
        return status;
    }
}
