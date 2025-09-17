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

TestObject menuTransaksi = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//a[contains(.,'Transaksi')]")
WebUI.waitForElementClickable(menuTransaksi, 10)
WebUI.click(menuTransaksi)

TestObject menuLPJUMP = new TestObject().addProperty("xpath",com.kms.katalon.core.testobject.ConditionType.EQUALS, "//a[@href='/lpj-ump-operasional']")

WebUI.waitForElementClickable(menuLPJUMP, 10)
WebUI.click(menuLPJUMP)

WebUI.delay(30)

//Pengajuan LPJ UMP
TestObject btnTambah = new TestObject('btnTambah')
btnTambah.addProperty('xpath', ConditionType.EQUALS, '//button[span[normalize-space(text())=\'Tambah Data\']]')

WebUI.waitForElementVisible(btnTambah, 20)
WebUI.click(btnTambah)

//WebElement element = WebUI.findWebElement(btnTambah, 10)
//JavascriptExecutor js = ((DriverFactory.getWebDriver()) as JavascriptExecutor)
//js.executeScript('arguments[0].click();', element)

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
TestObject tanggal = new TestObject()
tanggal.addProperty('xpath', ConditionType.EQUALS, '//span[normalize-space()=\'17\']')

WebUI.waitForElementClickable(tanggal, 20)
WebUI.click(tanggal)

// Pilih LPJ Sisa
TestObject radioSisa = new TestObject('radioSisa')
radioSisa.addProperty("xpath", ConditionType.EQUALS, "//label[contains(.,'LPJ Sisa')]")

WebUI.click(radioSisa)

TestObject inputNominalLPJ = new TestObject('inputNominalLPJ')
inputNominalLPJ.addProperty("xpath", ConditionType.EQUALS, "//label[contains(.,'Nominal LPJ')]/following::input[1]")

WebUI.waitForElementVisible(inputNominalLPJ, 10)
WebUI.setText(inputNominalLPJ, "500")

TestObject keteranganField = new TestObject()
keteranganField.addProperty("xpath", ConditionType.EQUALS, "//label[normalize-space()='Keterangan']/following::textarea[1]")
WebUI.setText(keteranganField, "lpj ump pengajuan")

TestObject btnSimpan = new TestObject('btn_Simpan')
btnSimpan.addProperty('xpath', ConditionType.EQUALS, '//button[normalize-space(text())=\'Simpan\']')

WebUI.waitForElementClickable(btnSimpan, 10)
WebUI.click(btnSimpan)

// Definisikan button Simpan di modal
TestObject btnSimpanModal = new TestObject('btnSimpanModal')
btnSimpanModal.addProperty("xpath", ConditionType.EQUALS,
	"//div[@id='modal-simulasi']//button[contains(@class,'btn-success')]")

// Tunggu modal muncul
WebUI.waitForElementVisible(btnSimpanModal, 10)

// Kadang tombol ketutup span, jadi pakai JS click biar pasti
WebElement element = WebUiCommonHelper.findWebElement(btnSimpanModal, 10)
JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
js.executeScript("arguments[0].click();", element)

WebUI.delay(30)

//Approval LPJ UMP
TestObject approvalLPJUMP = new TestObject().addProperty("xpath",com.kms.katalon.core.testobject.ConditionType.EQUALS, "//a[@href='/approve-lpj-ump-operasional']")

WebUI.waitForElementClickable(approvalLPJUMP, 10)
WebUI.click(approvalLPJUMP)

TestObject btnRowApp = new TestObject('btnRowApp')
btnRowApp.addProperty("xpath", ConditionType.EQUALS, "(//table//tbody//tr)[1]//button[contains(@class,'btn button-small-success mr-1 btn-success btn-sm')]")

WebUI.waitForElementVisible(btnRowApp, 10)
WebUI.click(btnRowApp)

TestObject buttonSetujui = new TestObject().addProperty("xpath", com.kms.katalon.core.testobject.ConditionType.EQUALS, "//button[contains(text(),'Setujui')]")
WebUI.click(buttonSetujui)

TestObject textareaCatatan = new TestObject().addProperty("xpath", com.kms.katalon.core.testobject.ConditionType.EQUALS, "//textarea[@id='catatan-input']")

WebUI.waitForElementVisible(textareaCatatan, 10)
WebUI.setText(textareaCatatan, "Setuju")

WebUI.click(findTestObject('Object Repository/Page_PPMDKS/button_Setujui_1'))

//Laporan Bagan Akun
TestObject menuPelaporan = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//a[contains(.,'Pelaporan')]")
WebUI.click(menuPelaporan)

TestObject menuLapAkutansi = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//a[contains(.,'Laporan Akuntansi')]")
WebUI.click(menuLapAkutansi)

TestObject baganAkun = new TestObject()
baganAkun.addProperty('xpath', ConditionType.EQUALS, '//a[@href=\'/bagan-akun\']')

WebUI.click(baganAkun)

WebUI.click(findTestObject('Object Repository/Page_PPMDKS/section_Filters              Kantor Pusat (_f88181'))

WebUI.click(findTestObject('Object Repository/Page_PPMDKS/svg_Konsolidasi_mr-0 mr-sm-50 feather feath_dfdde7'))

WebUI.closeBrowser()

