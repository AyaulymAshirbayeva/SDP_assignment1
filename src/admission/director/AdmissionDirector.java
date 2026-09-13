package admission.director;

import admission.builder.ApplicationBuilder;
import admission.product.AdmissionApplication;
import admission.product.AdmissionApplication.DegreeLevel;

public class AdmissionDirector {

    public AdmissionApplication constructInternationalMaster(
            ApplicationBuilder builder
    ) {
        return builder
                .setPersonalDetails("John", "Doe")
                .setAcademicInfo(
                        DegreeLevel.MASTER,
                        "Software Engineering",
                        3.7
                )
                .setInternationalDetails(
                        7.5,
                        "N12345678"
                )
                .build();
    }

    public AdmissionApplication constructAcademicMobilityBachelor(
            ApplicationBuilder builder
    ) {
        return builder
                .setPersonalDetails("Elena", "Rostova")
                .setAcademicInfo(
                        DegreeLevel.BACHELOR,
                        "Computer Science",
                        3.4
                )
                .setInternationalDetails(
                        6.5,
                        "K98765432"
                )
                .setMobilityDetails(
                        "University of Warsaw",
                        1,
                        true
                )
                .build();
    }

    public AdmissionApplication constructVacantGrantApplicant(
            ApplicationBuilder builder
    ) {
        return builder
                .setPersonalDetails(
                        "Arman",
                        "Kassymov"
                )
                .setAcademicInfo(
                        DegreeLevel.BACHELOR,
                        "Data Science",
                        3.9
                )
                .setVacantGrantDetails(
                        "ST2026-991",
                        false
                )
                .build();
    }
}