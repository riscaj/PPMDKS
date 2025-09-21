import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.common.WebUiCommonHelper as Helper

WebUI.openBrowser('')

WebUI.maximizeWindow()

//Login
WebUI.navigateToUrl(GlobalVariable.baseUrl)

WebUI.setText(findTestObject('Object Repository/Page_PPMDKS/input_Username_login-username'), GlobalVariable.username)

WebUI.setEncryptedText(findTestObject('Object Repository/Page_PPMDKS/input_Password_login-password'), GlobalVariable.password)

WebUI.sendKeys(findTestObject('Object Repository/Page_PPMDKS/input_Password_login-password'), Keys.chord(Keys.ENTER))

WebUI.delay(30)

//Pengajuan Cabang
TestObject menuPenyaluranCabang = new TestObject('menuPenyaluranCabang')

menuPenyaluranCabang.addProperty('xpath', ConditionType.EQUALS, '//span[contains(@class,\'menu-title\') and contains(.,\'Penyaluran Cabang\')]')

WebElement el = WebUiCommonHelper.findWebElement(menuPenyaluranCabang, 10)

JavascriptExecutor js = ((DriverFactory.getWebDriver()) as JavascriptExecutor)

js.executeScript('arguments[0].click();', el)

//Pencairan
TestObject submenuPencairan = new TestObject('submenuPencairan')

submenuPencairan.addProperty('xpath', ConditionType.EQUALS, '//li[contains(@class,\'has-sub\') and .//span[normalize-space(text())=\'Penyaluran Cabang\']]//ul//span[normalize-space(text())=\'Pencairan\']')

WebUI.click(submenuPencairan)

WebUI.delay(20)

TestObject btnRejectPencairan = new TestObject('btnRejectPencairan')

btnRejectPencairan.addProperty('xpath', ConditionType.EQUALS, '//button[@title=\'reject\' and contains(@class,\'btn-danger\')]')

WebUI.waitForElementVisible(btnRejectPencairan, 10)

WebUI.click(btnRejectPencairan)

TestObject btnSimpanReject = new TestObject('btnSimpanReject')
btnSimpanReject.addProperty('xpath', ConditionType.EQUALS, "//button[@type='submit' and contains(@class,'btn-success')]")

WebElement elementReject = Helper.findWebElement(btnSimpanReject, 10)
js.executeScript("arguments[0].click();", elementReject)

WebUI.closeBrowser()