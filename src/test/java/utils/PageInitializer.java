package utils;

import pages.*;

public class PageInitializer {
    public  static LoginPage loginPage;
    public static DashBoardPage dashBoardPage;
    public static AddEmployeePage addEmployeePage;
    public static PersonalDetailsPage personalDetailsPage;

    public  static HomePage homePage;
    public  static EmployeeListPage employeeListPage;
    public static RecruitmentPage recruitmentPage;

    public static void initPageObjects(){
        loginPage=new LoginPage();
        dashBoardPage=new DashBoardPage();
        addEmployeePage=new AddEmployeePage();
        personalDetailsPage=new PersonalDetailsPage();
        homePage=new HomePage();
        employeeListPage =new EmployeeListPage();
        recruitmentPage =new RecruitmentPage();
    }
}
