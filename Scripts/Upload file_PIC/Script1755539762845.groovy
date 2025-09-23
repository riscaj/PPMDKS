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
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.baseUrl)

WebUI.setText(findTestObject('Object Repository/Page_PPMDKS/input_Username_login-username'), GlobalVariable.username)

WebUI.setEncryptedText(findTestObject('Object Repository/Page_PPMDKS/input_Password_login-password'), GlobalVariable.password)

WebUI.sendKeys(findTestObject('Object Repository/Page_PPMDKS/input_Password_login-password'), Keys.chord(Keys.ENTER))

WebUI.delay(20)

TestObject btnDataPIC = new TestObject()
btnDataPIC.addProperty('xpath', ConditionType.EQUALS, "//a[@href='/data-pic' and contains(.,'Data PIC')]")

WebUI.click(btnDataPIC)

WebUI.delay(35)

//Click Tambah Data
TestObject btnTambahData = new TestObject('dynamic_button_TambahData')
btnTambahData.addProperty('xpath', ConditionType.EQUALS, '//span[contains(text(),\'Tambah Data\')]/parent::button')

WebUI.waitForElementVisible(btnTambahData, 10)
WebUI.waitForElementClickable(btnTambahData, 10)
WebUI.click(btnTambahData)

TestObject inputNIK = new TestObject('inputNIK')
inputNIK.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'nomor_ktp\']')

WebUI.waitForElementVisible(inputNIK, 10)
WebUI.setText(inputNIK, '3277676877008015')

TestObject searchBtn = new TestObject('searchBtn')
searchBtn.addProperty('xpath', ConditionType.EQUALS, '//button[@class=\'btn btn-outline-primary\']')
WebUI.click(searchBtn)

TestObject tempatlahir = new TestObject('tempatlahir')
tempatlahir.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'tempat_lahir\']')

WebUI.waitForElementVisible(tempatlahir, 10)
WebUI.setText(tempatlahir, 'Jakarta')

TestObject namalengkap = new TestObject('namalengkap')
namalengkap.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'nama_lengkap\']')

WebUI.waitForElementVisible(namalengkap, 10)
WebUI.setText(namalengkap, 'Marisca JL3')

TestObject tanggalLahir = new TestObject()
tanggalLahir.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'tanggal_lahir\']')

WebUI.setText(tanggalLahir, '12-01-1998')

TestObject dropdownStatusPIC = new TestObject('dropdownStatusPIC')
dropdownStatusPIC.addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'vs5__combobox\']')

WebUI.click(dropdownStatusPIC)

String opsi = 'Belum Kawin'
TestObject pilihan = new TestObject('option_StatusPIC')
pilihan.addProperty('xpath', ConditionType.EQUALS, ('//li[contains(@id,\'vs5__option\') and normalize-space(text())=\'' + opsi) + '\']')

WebUI.click(pilihan)

TestObject namaibu = new TestObject('namaibu')
namaibu.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'nama_ibu\']')

WebUI.waitForElementVisible(namaibu, 10)
WebUI.setText(namaibu, 'Ibuku')

TestObject pekerjaan = new TestObject('pekerjaan')
pekerjaan.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'pekerjaan\']')

WebUI.waitForElementVisible(pekerjaan, 10)
WebUI.setText(pekerjaan, 'Pegawai')

TestObject kewarganegaraan = new TestObject('kewarganegaraan')
kewarganegaraan.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'kewarganegaraan\']')

WebUI.waitForElementVisible(kewarganegaraan, 10)
WebUI.setText(kewarganegaraan, 'WNI')

//Pilih "Laki-laki"
//TestObject radioLaki = new TestObject()
//radioLaki.addProperty("xpath", ConditionType.EQUALS, "//label[contains(normalize-space(.),'Laki-laki')]")

//WebUI.click(radioLaki)

//Pilih "Perempuan"
TestObject radioPerempuan = new TestObject()
radioPerempuan.addProperty("xpath", ConditionType.EQUALS, "//label[contains(normalize-space(.),'Perempuan')]")

WebUI.click(radioPerempuan)

TestObject dropdownAgamaPIC = new TestObject('dropdownAgamaPIC')
dropdownAgamaPIC.addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'vs6__combobox\']')

WebUI.click(dropdownAgamaPIC)

String opsi1 = 'Islam'
TestObject pilihan1 = new TestObject('option_AgamaPIC')
pilihan1.addProperty('xpath', ConditionType.EQUALS, ('//li[contains(@id,\'vs6__option\') and normalize-space(text())=\'' + opsi1) + '\']')

WebUI.click(pilihan1)

TestObject alamatField = new TestObject()
alamatField.addProperty("xpath", ConditionType.EQUALS, "//label[normalize-space()='Alamat']/following::textarea[1]")

WebUI.setText(alamatField, "Jl. Kenanga No. 7")

//Input RT
TestObject inputRT = new TestObject('dynamicRT')
inputRT.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'rt\']')

WebUI.waitForElementVisible(inputRT, 10)
WebUI.setText(inputRT, '1')

//Input RW
TestObject inputRW = new TestObject('dynamicRW')
inputRW.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'rw\']')

WebUI.waitForElementVisible(inputRW, 10)
WebUI.setText(inputRW, '5')

//Select Provinsi
TestObject dropdownProvinsiPIC = new TestObject('dropdownProvinsiPIC')
dropdownProvinsiPIC.addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'vs7__combobox\']')

WebUI.click(dropdownProvinsiPIC)

String opsi2 = 'BALI'
TestObject pilihan2 = new TestObject('option_ProvinsiPIC')
pilihan2.addProperty('xpath', ConditionType.EQUALS, ('//li[contains(@id,\'vs7__option\') and normalize-space(text())=\'' + opsi2) + '\']')

WebUI.click(pilihan2)

//Select Kabupaten/Kota
TestObject dropdownKabPIC = new TestObject('dropdownKabPIC')
dropdownKabPIC.addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'vs9__combobox\']')

WebUI.click(dropdownKabPIC)

String opsi3 = 'BANGLI'
TestObject pilihan3 = new TestObject('option_KabPIC')
pilihan3.addProperty('xpath', ConditionType.EQUALS, ('//li[contains(@id,\'vs9__option\') and normalize-space(text())=\'' + opsi3) + '\']')

WebUI.click(pilihan3)

//Select Kecamatan
TestObject dropdownKecPIC = new TestObject('dropdownKecPIC')
dropdownKecPIC.addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'vs8__combobox\']')

WebUI.click(dropdownKecPIC)

String opsi4 = 'BANGLI'
TestObject pilihan4 = new TestObject('option_KecPIC')
pilihan4.addProperty('xpath', ConditionType.EQUALS, ('//li[contains(@id,\'vs8__option\') and normalize-space(text())=\'' + opsi4) + '\']')

WebUI.click(pilihan4)

//Select Desa/Kelurahan
TestObject dropdownKelPIC = new TestObject('dropdownKelPIC')
dropdownKelPIC.addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'vs10__combobox\']')

WebUI.click(dropdownKelPIC)

String opsi5 = 'KUBU'
TestObject pilihan5 = new TestObject('option_KelPIC')
pilihan5.addProperty('xpath', ConditionType.EQUALS, ('//li[contains(@id,\'vs10__option\') and normalize-space(text())=\'' + opsi5) + '\']')

WebUI.click(pilihan5)

//Select Pendidikan Terakhir
TestObject dropdownPendlPIC = new TestObject('dropdownPendlPIC')
dropdownPendlPIC.addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'vs11__combobox\']')

WebUI.click(dropdownPendlPIC)

String opsi6 = 'S1'
TestObject pilihan6 = new TestObject('option_PendPIC')
pilihan6.addProperty('xpath', ConditionType.EQUALS, ('//li[contains(@id,\'vs11__option\') and normalize-space(text())=\'' + opsi6) + '\']')

WebUI.click(pilihan6)

//Input Nomor Telepon
TestObject inputNoTlp = new TestObject('dynamicNoTlp')
inputNoTlp.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'nomor_telepon\']')

WebUI.waitForElementVisible(inputNoTlp, 10)
WebUI.setText(inputNoTlp, '652167868712')

//Upload File
String projectDir = RunConfiguration.getProjectDir()

String filePathKTP = projectDir + GlobalVariable.fileKTP

TestObject uploadFileKTP = new TestObject()
uploadFileKTP.addProperty('xpath', ConditionType.EQUALS, '//input[@type="file"]')

WebUI.uploadFile(uploadFileKTP, filePathKTP)

//Click Save Button
TestObject simpanBtn = new TestObject()
simpanBtn.addProperty('xpath', ConditionType.EQUALS, '//button[normalize-space()=\'Simpan\']')

WebUI.click(simpanBtn)
WebUI.click(findTestObject('Object Repository/Page_PPMDKS/button_Simpan'))

WebUI.delay(10)

WebUI.closeBrowser()