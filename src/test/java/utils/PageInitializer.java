package utils;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginValidationPage;
import pages.PersonalDetailsPage;

public class PageInitializer {
    public static LoginValidationPage loginValidationPage;
    public static DashboardPage dashboardPage;
    public static AddEmployeePage addEmployeePage;
    public static PersonalDetailsPage personalDetailsPage;

    public static void initializePageObject(){
        loginValidationPage=new LoginValidationPage();
        dashboardPage=new DashboardPage();
        addEmployeePage = new AddEmployeePage();
        personalDetailsPage = new PersonalDetailsPage();
    }

}
