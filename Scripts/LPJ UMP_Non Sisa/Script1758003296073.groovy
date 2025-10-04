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
import com.kms.katalon.core.webui.common.WebUiCommonHelper

WebUI.openBrowser('')

WebUI.maximizeWindow()

//Login
WebUI.navigateToUrl(GlobalVariable.baseUrl)

WebUI.setText(findTestObject('Object Repository/Page_PPMDKS/input_Username_login-username'), GlobalVariable.username)

WebUI.setEncryptedText(findTestObject('Object Repository/Page_PPMDKS/input_Password_login-password'), GlobalVariable.password)

WebUI.sendKeys(findTestObject('Object Repository/Page_PPMDKS/input_Password_login-password'), Keys.chord(Keys.ENTER))

WebUI.delay(20)


//Pengajuan LPJ UMP
TestObject menuTransaksi = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//a[contains(.,'Transaksi')]")

WebUI.waitForElementClickable(menuTransaksi, 10)
WebUI.click(menuTransaksi)

TestObject menuLPJUMP = new TestObject().addProperty("xpath",com.kms.katalon.core.testobject.ConditionType.EQUALS, "//a[@href='/lpj-ump-operasional']")

WebUI.waitForElementClickable(menuLPJUMP, 10)
WebUI.click(menuLPJUMP)

WebUI.delay(40)

TestObject btnTambah = new TestObject('btnTambah')
btnTambah.addProperty('xpath', ConditionType.EQUALS, '//button[span[normalize-space(text())=\'Tambah Data\']]')

WebUI.waitForElementVisible(btnTambah, 20)
WebUI.click(btnTambah)

TestObject btnRow = new TestObject('btnRow')
btnRow.addProperty("xpath", ConditionType.EQUALS, "(//table//tbody//tr)[1]//button[contains(@class,'btn-success')]")

WebUI.waitForElementVisible(btnRow, 10)
WebUI.click(btnRow)

//Klik field tanggal (button yang membuka datepicker)
TestObject pilihTanggal = new TestObject()
pilihTanggal.addProperty('xpath', ConditionType.EQUALS, '//div[contains(@class,\'b-form-datepicker\')]//button[@type=\'button\']')

WebUI.waitForElementClickable(pilihTanggal, 20)
WebUI.click(pilihTanggal)

//Pilih tanggal
String hari = "3"

TestObject tanggal = new TestObject()
tanggal.addProperty('xpath', ConditionType.EQUALS, "//span[normalize-space()='" + hari + "']")

WebUI.waitForElementClickable(tanggal, 30)
WebUI.click(tanggal)

// Pilih LPJ Non Sisa
TestObject radioNonSisa = new TestObject('radioNonSisa')
radioNonSisa.addProperty("xpath", ConditionType.EQUALS, "//label[contains(.,'LPJ Non Sisa')]")

WebUI.click(radioNonSisa)

TestObject keteranganField = new TestObject()
keteranganField.addProperty("xpath", ConditionType.EQUALS, "//label[normalize-space()='Keterangan']/following::textarea[1]")

WebUI.setText(keteranganField, "lpj ump pengajuan")

TestObject btnSimpan = new TestObject('btn_Simpan')
btnSimpan.addProperty('xpath', ConditionType.EQUALS, '//button[normalize-space(text())=\'Simpan\']')

WebUI.waitForElementClickable(btnSimpan, 10)
WebUI.click(btnSimpan)

TestObject btnSimpanModal = new TestObject('btnSimpanModal')
btnSimpanModal.addProperty("xpath", ConditionType.EQUALS, "//div[@id='modal-simulasi']//button[contains(@class,'btn-success')]")

WebUI.waitForElementVisible(btnSimpanModal, 10)

WebElement element = WebUiCommonHelper.findWebElement(btnSimpanModal, 10)
JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()

js.executeScript("arguments[0].click();", element)

WebUI.delay(40)


//Approval LPJ UMP
TestObject approvalLPJUMP = new TestObject().addProperty("xpath",com.kms.katalon.core.testobject.ConditionType.EQUALS, "//a[@href='/approve-lpj-ump-operasional']")

WebUI.waitForElementClickable(approvalLPJUMP, 10)
WebUI.click(approvalLPJUMP)

TestObject btnRowApp = new TestObject('btnRowApp')
btnRowApp.addProperty("xpath", ConditionType.EQUALS, "(//table//tbody//tr)[1]//button[contains(@class,'btn-success')]")

WebUI.waitForElementVisible(btnRowApp, 10)
WebUI.click(btnRowApp)

TestObject buttonSetujui = new TestObject().addProperty("xpath", com.kms.katalon.core.testobject.ConditionType.EQUALS, "//button[contains(text(),'Setujui')]")
WebUI.click(buttonSetujui)

TestObject textareaCatatan = new TestObject().addProperty("xpath", com.kms.katalon.core.testobject.ConditionType.EQUALS, "//textarea[@id='catatan-input']")

WebUI.waitForElementVisible(textareaCatatan, 10)
WebUI.setText(textareaCatatan, "Setuju")

WebUI.click(findTestObject('Object Repository/Page_PPMDKS/button_Setujui_1'))

WebUI.delay(20)

/*
//Laporan Bagan Akun
TestObject menuPelaporan = new TestObject('menuPelaporan')
menuPelaporan.addProperty('xpath', ConditionType.EQUALS, '//span[contains(@class,\'menu-title\') and contains(.,\'Pelaporan\')]')

WebElement elpelaporan = WebUiCommonHelper.findWebElement(menuPelaporan, 10)

js.executeScript("arguments[0].scrollIntoView(true);", elpelaporan)
js.executeScript("arguments[0].click();", elpelaporan)

TestObject menuLapAkun = new TestObject('menuLapAkun')
menuLapAkun.addProperty('xpath', ConditionType.EQUALS, '//span[contains(@class,\'menu-title\') and contains(.,\'Laporan Akuntansi\')]')

WebElement elakun = WebUiCommonHelper.findWebElement(menuLapAkun, 10)

js.executeScript('arguments[0].click();', elakun)

TestObject submenuBaganAkun = new TestObject('submenuBaganAkun')
submenuBaganAkun.addProperty('xpath', ConditionType.EQUALS, '//li[contains(@class,\'has-sub\') and .//span[normalize-space(text())=\'Laporan Akuntansi\']]//ul//span[normalize-space(text())=\'Bagan Akun\']')

WebUI.waitForElementVisible(submenuBaganAkun, 30)
WebUI.click(submenuBaganAkun)

TestObject dropdownBaganAkun = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@placeholder=\'Pilih Lokasi Outlet\']')

WebUI.click(dropdownBaganAkun)
WebUI.setText(dropdownBaganAkun, 'Kantor Pusat (Konvensional)')

TestObject optionBaganAkun = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//li[contains(@id,\'vs\') and normalize-space()=\'Kantor Pusat (Konvensional)\']')

WebUI.waitForElementVisible(optionBaganAkun, 10)
WebUI.click(optionBaganAkun)

WebUI.click(findTestObject('Object Repository/Page_PPMDKS/button_Filter'))

WebUI.delay(30)*/

WebUI.closeBrowser()