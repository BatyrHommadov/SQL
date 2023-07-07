package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import utils.Constants;
import utils.DbUtils;
import utils.ExcelReader;
import utils.WebDriverUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends WebDriverUtils {

    String employeeId;
    String empFirstName;
    String empLastName;

    @And("User clicks PIM")
    public void userClicksPIM() {

        // webDriver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
        dashBoardPage.pimBtn.click();
    }

    @And("User clicks addEmployee")
    public void userClicksAddEmployee() {

        // webDriver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
        dashBoardPage.addEmployee.click();

    }

    @And("User enters {string} in firstName field")
    public void userEntersInFirstNameField(String arg0) {
        empFirstName = arg0;
        //   webDriver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(arg0);
        addEmployeePage.firstName.sendKeys(arg0);

    }

    @And("User enters {string} in lastName field")
    public void userEntersInLastNameField(String arg0) {
        empLastName=arg0;
        //    webDriver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(arg0);
        addEmployeePage.lastName.sendKeys(arg0);
    }

    @And("User clicks on the save button")
    public void userClicksOnTheSaveButton() {
        // webDriver.findElement(By.xpath("//input[@id='btnSave']")).click();
        addEmployeePage.saveBtn.click();
    }

    @Then("User verifies employee is added")
    public void userVerifiesEmployeeIsAdded() {
        String query = "select * from hs_hr_employee where employee_id='" + employeeId+"'";
        List<Map<String, String>> empData = DbUtils.fetch(query);
        String dbFirstname=empData.get(0).get("emp_firstname");
        String dbLastname=empData.get(0).get("emp_lastname");

        Assert.assertEquals("Firstname from front end does not match firstname from database",empFirstName,dbFirstname);
        Assert.assertEquals("LastName from front end does not match firstname from database",dbLastname,dbLastname);

    }

    @And("User Enters {string} {string} {string}")
    public void userEnters(String arg0, String arg1, String arg2) {
        //   webDriver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(arg0);
        //   webDriver.findElement(By.xpath("//input[@id='middleName']")).sendKeys(arg1);
        //   webDriver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(arg2);
        addEmployeePage.firstName.sendKeys(arg0);
        addEmployeePage.middleName.sendKeys(arg1);
        addEmployeePage.lastName.sendKeys(arg2);

    }


    @When("User clicks add Multiple Employees and verifies employee is added")
    public void user_clicks_add_multiple_employees_and_verifies_employee_is_added(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> listMap = dataTable.asMaps();
        for (Map<String, String> map : listMap) {
           /* webDriver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
            webDriver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
            //get the value from the map and send it to the webpage
            webDriver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(map.get("firstName"));
            webDriver.findElement(By.xpath("//input[@id='middleName']")).sendKeys(map.get("middleName"));
            webDriver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(map.get("lastName"));
            webDriver.findElement(By.xpath("//input[@id='btnSave']")).click();*/

            /*dashBoardPage.pimBtn.click();
            dashBoardPage.addEmployee.click();
            addEmployeePage.firstName.sendKeys(map.get("firstName"));
            addEmployeePage.middleName.sendKeys(map.get("middleName"));
            addEmployeePage.lastName.sendKeys(map.get("lastName"));
            addEmployeePage.saveBtn.click();*/

            addBasicEmpData(map);

        }
        closeWebDriver();
    }

    private static void addBasicEmpData(Map<String, String> map) {
        dashBoardPage.pimBtn.click();
        dashBoardPage.addEmployee.click();
        addEmployeePage.firstName.sendKeys(map.get("firstName"));
        addEmployeePage.middleName.sendKeys(map.get("middleName"));
        addEmployeePage.lastName.sendKeys(map.get("lastName"));
        addEmployeePage.saveBtn.click();
    }


    @When("user Enters multiple employees from excel")
    public void user_enters_multiple_employees_from_excel() throws IOException, InterruptedException {

        List<Map<String, String>> excelData = ExcelReader.read(Constants.EXCEL_FILE_PATH, "Sheet1");

        for (Map<String, String> map : excelData) {
            addBasicEmpData(map);
            Thread.sleep(1000);
            employeeListPage.editBtn.click();
            employeeListPage.dlNumber.sendKeys(map.get("dlNumber"));
            employeeListPage.leDate.clear();
            employeeListPage.leDate.sendKeys(map.get("LicenseExpiryDate"));
            Thread.sleep(1000);
            Select select = new Select(employeeListPage.empNationality);
            select.selectByIndex(5);
            Thread.sleep(1000);
            employeeListPage.editBtn.click();

        }
        webDriver.close();

    }

    @And("user saves the employee id")
    public void userSavesTheEmployeeId() {
        employeeId = addEmployeePage.employeeId.getAttribute("value");
    }
}
