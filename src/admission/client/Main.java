package admission.client;

import admission.builder.ApplicationBuilder;
import admission.director.AdmissionDirector;
import admission.product.AdmissionApplication;

public class Main {
    public static void main(String[] args) {
        AdmissionDirector director = new AdmissionDirector();
        AdmissionApplication app1 = director.constructInternationalAdmission(new ApplicationBuilder());

        System.out.println("1. International admission");
        System.out.println("Type: " + app1.getType());
        System.out.println("Applicant: " + app1.getApplicantName());
        System.out.println("Degree: " + app1.getDegreeLevel());
        System.out.println("Major: " + app1.getMajor());
        System.out.println("GPA: " + app1.getGpa());
        System.out.println("Passport: " + app1.getPassportNumber() + " (" + app1.getCitizenship() + ")");
        System.out.println("Language: " + app1.getLanguageTestType() + " " + app1.getLanguageScore());
        System.out.println("Status: " + app1.getStatus());

        AdmissionApplication app2 = director.constructAcademicMobility(new ApplicationBuilder());

        System.out.println("\n2. Academic mobility");
        System.out.println("Type: " + app2.getType());
        System.out.println("Applicant: " + app2.getApplicantName());
        System.out.println("Student ID: " + app2.getStudentId());
        System.out.println("Degree: " + app2.getDegreeLevel());
        System.out.println("Major: " + app2.getMajor());
        System.out.println("GPA: " + app2.getGpa());
        System.out.println("Language: " + app2.getLanguageTestType() + " " + app2.getLanguageScore());
        System.out.println("Host University: " + app2.getHostUniversity());
        System.out.println("Semesters: " + app2.getMobilitySemesters());
        System.out.println("Agreement Signed: " + app2.isLearningAgreementSigned());
        System.out.println("Status: " + app2.getStatus());

        AdmissionApplication app3 = director.constructVacantGrant(new ApplicationBuilder());

        System.out.println("\n3. Vacant grant");
        System.out.println("Type: " + app3.getType());
        System.out.println("Applicant: " + app3.getApplicantName());
        System.out.println("Student ID: " + app3.getStudentId());
        System.out.println("Degree: " + app3.getDegreeLevel());
        System.out.println("Major: " + app3.getMajor());
        System.out.println("GPA: " + app3.getGpa());
        System.out.println("Applying for Vacant Grant: " + app3.isApplyingForVacantGrant());
        System.out.println("Has Disciplinary Records: " + app3.hasDisciplinaryRecords());
        System.out.println("Status: " + app3.getStatus());
    }
}
