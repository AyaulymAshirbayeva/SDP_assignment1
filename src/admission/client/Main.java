package admission.client;

import admission.builder.ApplicationBuilder;
import admission.director.AdmissionDirector;
import admission.product.AdmissionApplication;

public class Main {

    public static void main(String[] args) {

        AdmissionDirector director = new AdmissionDirector();

        System.out.println("==================================================");
        System.out.println("1. DEMO: Building via Director (Predefined Scenarios)");
        System.out.println("==================================================");

        AdmissionApplication intlApp =
                director.constructInternationalMaster(
                        new ApplicationBuilder()
                );

        System.out.println(intlApp);

        AdmissionApplication mobilityApp =
                director.constructAcademicMobilityBachelor(
                        new ApplicationBuilder()
                );

        System.out.println(mobilityApp);

        AdmissionApplication grantApp =
                director.constructVacantGrantApplicant(
                        new ApplicationBuilder()
                );

        System.out.println(grantApp);

        System.out.println("==================================================");
        System.out.println("2. DEMO: Custom Building via Builder directly");
        System.out.println("==================================================");

        AdmissionApplication customPhd =
                new ApplicationBuilder()
                        .setPersonalDetails(
                                "Aisulu",
                                "Saparova"
                        )
                        .setAcademicInfo(
                                AdmissionApplication.DegreeLevel.PHD,
                                "Cybersecurity",
                                3.85
                        )
                        .setInternationalDetails(
                                8.0,
                                "K87654321"
                        )
                        .build();

        System.out.println(customPhd);

        System.out.println("==================================================");
        System.out.println("3. DEMO: Validated Construction (Clean Code Test)");
        System.out.println("==================================================");

        try {

            System.out.println(
                    "Attempting to apply for vacant grant with GPA 3.2 " +
                            "(Min required: 3.5)..."
            );

            AdmissionApplication invalidGrantApp =
                    new ApplicationBuilder()
                            .setPersonalDetails(
                                    "Dias",
                                    "Nurlybek"
                            )
                            .setInternalStudentDetails(
                                    "ST2024-0012"
                            )
                            .setAcademicInfo(
                                    AdmissionApplication.DegreeLevel.BACHELOR,
                                    "Software Engineering",
                                    3.2
                            )
                            .setVacantGrantDetails(
                                    "ST2024-0012",
                                    false
                            )
                            .build();

        } catch (IllegalStateException e) {

            System.out.println(
                    "SUCCESSFULLY CAUGHT VALIDATION ERROR: "
                            + e.getMessage()
            );
        }
    }
}