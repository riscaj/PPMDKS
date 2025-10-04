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


//Pengajuan Transaksi Kas
TestObject menuTransaksi = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//a[contains(.,'Transaksi')]")

WebUI.click(menuTransaksi)

TestObject transaksiKas = new TestObject()
transaksiKas.addProperty('xpath', ConditionType.EQUALS, '//a[@href=\'/transaksi-kas\']')

WebUI.click(transaksiKas)

WebUI.delay(40)

TestObject btnTambah = new TestObject('btnTambah')
btnTambah.addProperty('xpath', ConditionType.EQUALS, '//button[span[normalize-space(text())=\'Tambah Data\']]')

WebUI.waitForElementVisible(btnTambah, 20)
WebUI.scrollToElement(btnTambah, 5)

WebElement element = WebUI.findWebElement(btnTambah, 10)
JavascriptExecutor js = ((DriverFactory.getWebDriver()) as JavascriptExecutor)

js.executeScript('arguments[0].click();', element)

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

//Input jenis
TestObject inputSearch = new TestObject('inputSearchDropdown')
inputSearch.addProperty('xpath', ConditionType.EQUALS, '//input[contains(@class,\'vs__search\')]')

WebUI.waitForElementVisible(inputSearch, 10)
WebUI.click(inputSearch)
WebUI.setText(inputSearch, 'PEMBAYARAN UMP - PUSAT')

TestObject option = new TestObject('dropdownOption')
option.addProperty('xpath', ConditionType.EQUALS, '//li[contains(normalize-space(.),\'PEMBAYARAN UMP - PUSAT\')]')

WebUI.waitForElementVisible(option, 10)
WebUI.click(option)

WebUI.setText(findTestObject('Object Repository/Page_PPMDKS/input__number'), '10,000')

//Input keterangan
TestObject fieldKeterangan = new TestObject()
fieldKeterangan.addProperty('xpath', ConditionType.EQUALS, '//textarea[@name=\'keterangan\']')

WebUI.waitForElementVisible(fieldKeterangan, 20)
WebUI.setText(fieldKeterangan, 'tes kas')

//Simpan transaksi kas
TestObject btnSimpan = new TestObject('btn_Simpan')
btnSimpan.addProperty('xpath', ConditionType.EQUALS, '//button[normalize-space(text())=\'Simpan\']')

WebUI.waitForElementClickable(btnSimpan, 10)
WebUI.click(btnSimpan)


//Approve approval transaksi kas
TestObject menuApproval = new TestObject().addProperty("xpath",com.kms.katalon.core.testobject.ConditionType.EQUALS, "//a[@href='/approve-transaksi-kas']")

WebUI.waitForElementClickable(menuApproval, 10)
WebUI.click(menuApproval)

WebUI.delay(40)

TestObject btnApproveRow1 = new TestObject('btnApproveRow1')
btnApproveRow1.addProperty("xpath", ConditionType.EQUALS, "(//table//tbody//tr)[1]//button[contains(@class,'btn-success')]")

WebUI.waitForElementVisible(btnApproveRow1, 10)
WebUI.click(btnApproveRow1)

TestObject buttonSetujui = new TestObject().addProperty("xpath", com.kms.katalon.core.testobject.ConditionType.EQUALS, "//button[contains(text(),'Setujui')]")

WebUI.click(buttonSetujui)

TestObject textareaCatatan = new TestObject().addProperty("xpath", com.kms.katalon.core.testobject.ConditionType.EQUALS, "//textarea[@id='catatan-input']")

WebUI.waitForElementVisible(textareaCatatan, 10)
WebUI.setText(textareaCatatan, "Ok")

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