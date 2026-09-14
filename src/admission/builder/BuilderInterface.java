package admission.builder;

import admission.product.AdmissionApplication;

public interface BuilderInterface {
    BuilderInterface setApplicationType(AdmissionApplication.ApplicationType type);
    BuilderInterface setApplicantName(String applicantName);
    BuilderInterface setStudentId(String studentId);
    BuilderInterface setAcademicInfo(AdmissionApplication.DegreeLevel degreeLevel, String major, double gpa);
    BuilderInterface setPassport(String passportNumber, String citizenship);
    BuilderInterface setLanguageCertificate(String languageTestType, double languageScore);
    BuilderInterface setMobilityProgram(String hostUniversity, int mobilitySemesters, boolean isLearningAgreementSigned);
    BuilderInterface setVacantGrantInfo(boolean isApplyingForVacantGrant, boolean hasDisciplinaryRecords);

    AdmissionApplication build();
}
