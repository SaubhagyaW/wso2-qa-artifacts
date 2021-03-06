package com.ss150;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreatePriviTemplate {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://10.100.5.66:9443/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreatePriviTemplate() throws Exception {
    driver.get(baseUrl + "/carbon/rssmanager/databasePrivilegeTemplates.jsp?region=region1&item=privilege_groups_submenu");
    driver.findElement(By.linkText("Privilege Templates")).click();
    driver.findElement(By.linkText("Add Database Privilege Template")).click();
    driver.findElement(By.id("privilegeTemplateName")).clear();
    driver.findElement(By.id("privilegeTemplateName")).sendKeys("full");
    driver.findElement(By.id("selectAll")).click();
    driver.findElement(By.cssSelector("input.button")).click();
    driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
    driver.findElement(By.linkText("Add Database Privilege Template")).click();
    driver.findElement(By.id("privilegeTemplateName")).clear();
    driver.findElement(By.id("privilegeTemplateName")).sendKeys("limited");
    driver.findElement(By.id("select_priv")).click();
    driver.findElement(By.id("insert_priv")).click();
    driver.findElement(By.id("update_priv")).click();
    driver.findElement(By.id("delete_priv")).click();
    driver.findElement(By.id("create_priv")).click();
    driver.findElement(By.id("execute_priv")).click();
    driver.findElement(By.cssSelector("input.button")).click();
    driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
