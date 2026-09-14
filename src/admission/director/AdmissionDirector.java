package admission.director;

import admission.builder.BuilderInterface;
import admission.product.AdmissionApplication;

public class AdmissionDirector {

    public AdmissionApplication constructInternationalAdmission(BuilderInterface builder) {
        return builder
                .setApplicationType(AdmissionApplication.ApplicationType.INTERNATIONAL_ADMISSION)
                .setApplicantName("James Stephen")
                .setAcademicInfo(AdmissionApplication.DegreeLevel.BACHELOR, "Software Engineering", 3.7)
                .setPassport("N12345678", "USA")
                .setLanguageCertificate("IELTS", 8.0)
                .build();
    }

    public AdmissionApplication constructAcademicMobility(BuilderInterface builder) {
        return builder
                .setApplicationType(AdmissionApplication.ApplicationType.ACADEMIC_MOBILITY)
                .setApplicantName("Elena Rostova")
                .setStudentId("256782")
                .setAcademicInfo(AdmissionApplication.DegreeLevel.BACHELOR, "Computer Science", 3.4)
                .setLanguageCertificate("IELTS", 6.5)
                .setMobilityProgram("University of Warsaw", 1, true)
                .build();
    }

    public AdmissionApplication constructVacantGrant(BuilderInterface builder) {
        return builder
                .setApplicationType(AdmissionApplication.ApplicationType.VACANT_GRANT)
                .setApplicantName("Arman Kassymov")
                .setStudentId("230107")
                .setAcademicInfo(AdmissionApplication.DegreeLevel.BACHELOR, "Data Science", 3.9)
                .setVacantGrantInfo(true, false)
                .build();
    }
}
