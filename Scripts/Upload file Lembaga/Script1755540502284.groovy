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
import com.kms.katalon.core.testobject.ConditionType

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.baseUrl)

WebUI.setText(findTestObject('Object Repository/Page_PPMDKS/input_Username_login-username'), GlobalVariable.username)

WebUI.setEncryptedText(findTestObject('Object Repository/Page_PPMDKS/input_Password_login-password'), GlobalVariable.password)

WebUI.sendKeys(findTestObject('Object Repository/Page_PPMDKS/input_Password_login-password'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Page_PPMDKS/span_Data Lembaga'))

//Click Tambah Data
TestObject btnTambahData = new TestObject('dynamic_button_TambahData')
btnTambahData.addProperty('xpath', ConditionType.EQUALS, "//span[contains(text(),'Tambah Data')]/parent::button")
WebUI.waitForElementVisible(btnTambahData, 10)
WebUI.waitForElementClickable(btnTambahData, 10)
WebUI.click(btnTambahData)

//Select Jenis Lembaga
TestObject dropdownJenisLembaga = new TestObject('dropdown_JenisLembaga')
dropdownJenisLembaga.addProperty('xpath', ConditionType.EQUALS, "//div[@id='vs5__combobox']")
WebUI.click(dropdownJenisLembaga)
String opsi = "Warga Masyarakat" 
TestObject pilihan = new TestObject('option_JenisLembaga')
pilihan.addProperty('xpath', ConditionType.EQUALS, "//li[contains(@id,'vs5__option') and normalize-space(text())='" + opsi + "']")
WebUI.click(pilihan)

WebUI.setText(findTestObject('Object Repository/Page_PPMDKS/input__nama_lembaga'), 'New Lembaga4')

WebUI.setText(findTestObject('Object Repository/Page_PPMDKS/textarea_Alamat Lembaga_alamat'), 'Alamat new lembaga')

WebUI.setText(findTestObject('Object Repository/Page_PPMDKS/input__rt'), '1')

WebUI.setText(findTestObject('Object Repository/Page_PPMDKS/input__rw'), '2')

//Select Provinsi
TestObject dropdownProvinsiLembaga = new TestObject('dropdownProvinsiLembaga')
dropdownProvinsiLembaga.addProperty('xpath', ConditionType.EQUALS, "//div[@id='vs6__combobox']")
WebUI.click(dropdownProvinsiLembaga)
String opsi1 = "BALI"
TestObject pilihan1 = new TestObject('option_ProvinsiLembaga')
pilihan1.addProperty('xpath', ConditionType.EQUALS, "//li[contains(@id,'vs6__option') and normalize-space(text())='" + opsi1 + "']")
WebUI.click(pilihan1)

//Select Kabupaten/Kota
TestObject dropdownKabLembaga = new TestObject('dropdownKabLembaga')
dropdownKabLembaga.addProperty('xpath', ConditionType.EQUALS, "//div[@id='vs8__combobox']")
WebUI.click(dropdownKabLembaga)
String opsi2 = "BANGLI"
TestObject pilihan2 = new TestObject('option_KabLembaga')
pilihan2.addProperty('xpath', ConditionType.EQUALS, "//li[contains(@id,'vs8__option') and normalize-space(text())='" + opsi2 + "']")
WebUI.click(pilihan2)

//Select Kecamatan
TestObject dropdownKecLembaga = new TestObject('dropdownKecLembaga')
dropdownKecLembaga.addProperty('xpath', ConditionType.EQUALS, "//div[@id='vs7__combobox']")
WebUI.click(dropdownKecLembaga)
String opsi3 = "BANGLI"
TestObject pilihan3 = new TestObject('option_KecLembaga')
pilihan3.addProperty('xpath', ConditionType.EQUALS, "//li[contains(@id,'vs7__option') and normalize-space(text())='" + opsi3 + "']")
WebUI.click(pilihan3)

//Select Desa/Kelurahan
TestObject dropdownKelLembaga = new TestObject('dropdownKelLembaga')
dropdownKelLembaga.addProperty('xpath', ConditionType.EQUALS, "//div[@id='vs9__combobox']")
WebUI.click(dropdownKelLembaga)
String opsi4 = "KUBU"
TestObject pilihan4 = new TestObject('option_KelLembaga')
pilihan4.addProperty('xpath', ConditionType.EQUALS, "//li[contains(@id,'vs9__option') and normalize-space(text())='" + opsi4 + "']")
WebUI.click(pilihan4)

WebUI.setText(findTestObject('Object Repository/Page_PPMDKS/input__nomor_telepon'), '6788787812')

//Upload File Lembaga
TestObject uploadFileInput = new TestObject()
uploadFileInput.addProperty('xpath', ConditionType.EQUALS, '//input[@type=\'file\']')
WebUI.uploadFile(uploadFileInput, '/Users/riscajulinarti/Documents/Pdf test file.pdf')

//Click Save Button
TestObject simpanBtn = new TestObject()
simpanBtn.addProperty('xpath', ConditionType.EQUALS, '//button[normalize-space()=\'Simpan\']')
WebUI.click(simpanBtn)

WebUI.closeBrowser()

