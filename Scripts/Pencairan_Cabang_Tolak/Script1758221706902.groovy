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
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

WebUI.openBrowser('')

WebUI.maximizeWindow()

//Login
WebUI.navigateToUrl(GlobalVariable.baseUrl)

WebUI.setText(findTestObject('Object Repository/Page_PPMDKS/input_Username_login-username'), GlobalVariable.username)

WebUI.setEncryptedText(findTestObject('Object Repository/Page_PPMDKS/input_Password_login-password'), GlobalVariable.password)

WebUI.sendKeys(findTestObject('Object Repository/Page_PPMDKS/input_Password_login-password'), Keys.chord(Keys.ENTER))

WebUI.delay(20)


//Pengajuan Cabang
TestObject menuPenyaluranCabang = new TestObject('menuPenyaluranCabang')
menuPenyaluranCabang.addProperty('xpath', ConditionType.EQUALS, '//span[contains(@class,\'menu-title\') and contains(.,\'Penyaluran Cabang\')]')

WebElement el = WebUiCommonHelper.findWebElement(menuPenyaluranCabang, 10)
JavascriptExecutor js = ((DriverFactory.getWebDriver()) as JavascriptExecutor)

js.executeScript('arguments[0].click();', el)

TestObject submenuPengajuan = new TestObject('submenuPengajuan')
submenuPengajuan.addProperty('xpath', ConditionType.EQUALS, '//li[contains(@class,\'has-sub\') and .//span[normalize-space(text())=\'Penyaluran Cabang\']]//ul//span[normalize-space(text())=\'Pengajuan\']')

WebUI.click(submenuPengajuan)

WebUI.delay(40)

TestObject btnTambahData = new TestObject('dynamic_button_TambahData')
btnTambahData.addProperty('xpath', ConditionType.EQUALS, '//span[contains(text(),\'Tambah Data\')]/parent::button')

WebUI.waitForElementVisible(btnTambahData, 20)
WebUI.waitForElementClickable(btnTambahData, 20)

WebUI.click(btnTambahData)

WebUI.delay(40)

TestObject dropdownPIC = new TestObject('dropdownPIC')
dropdownPIC.addProperty('xpath', ConditionType.EQUALS, '(//div[contains(@class,\'vs__dropdown-toggle\')])[1]')

WebUI.click(dropdownPIC)

WebUI.delay(40)

TestObject inputPIC = new TestObject('inputPIC')
inputPIC.addProperty('xpath', ConditionType.EQUALS, '(//input[@type=\'search\' and contains(@class,\'vs__search\')])[1]')

WebUI.setText(inputPIC, 'Marisca_11')

TestObject optionPIC = new TestObject('optionPIC')
optionPIC.addProperty('xpath', ConditionType.EQUALS, '//li[contains(@class,\'vs__dropdown-option\') and contains(text(),\'Marisca_11\')]')

WebUI.waitForElementVisible(optionPIC, 20)
WebUI.click(optionPIC)

TestObject dropdownLembaga = new TestObject('dropdownLembaga')
dropdownLembaga.addProperty('xpath', ConditionType.EQUALS, '(//div[contains(@class,\'vs__dropdown-toggle\')])[2]')

WebUI.waitForElementClickable(dropdownLembaga, 20)
WebUI.click(dropdownLembaga)

TestObject inputLembaga = new TestObject('inputLembaga')
inputLembaga.addProperty('xpath', ConditionType.EQUALS, '(//input[contains(@class,\'vs__search\')])[2]')

WebUI.waitForElementVisible(inputLembaga, 20)
WebUI.setText(inputLembaga, 'Yayasan_11')

TestObject optionLembaga = new TestObject('optionLembaga')
optionLembaga.addProperty('xpath', ConditionType.EQUALS, '//li[contains(@class,\'vs__dropdown-option\') and normalize-space(text())=\'Yayasan_11\']')

WebUI.waitForElementVisible(optionLembaga, 20)
WebUI.click(optionLembaga)

TestObject namaproposal = new TestObject('namaproposal')
namaproposal.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'nomorProposal\']')

WebUI.setText(namaproposal, 'Proposal cabang2')

TestObject namakegiatan = new TestObject('namakegiatan')
namakegiatan.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'nama_kegiatan\']')

WebUI.setText(namakegiatan, 'Penyaluran cabang2')

TestObject notlpbantuan = new TestObject('notlpbantuan')
notlpbantuan.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'nomor_telepon\']')

WebUI.setText(notlpbantuan, '6787178979')

TestObject tanggalProposal = new TestObject()
tanggalProposal.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'tanggalProposal\']')

WebUI.setText(tanggalProposal, '20-09-2025')

TestObject nilaibantuan = new TestObject('nilaibantuan')
nilaibantuan.addProperty('xpath', ConditionType.EQUALS, '//input[@placeholder=\'Permohonan Nilai Bantuan\']')

WebUI.setText(nilaibantuan, '10,000')

TestObject LokasiBantuan = new TestObject()
LokasiBantuan.addProperty('xpath', ConditionType.EQUALS, '//label[normalize-space()=\'Lokasi Bantuan\']/following::textarea[1]')

WebUI.setText(LokasiBantuan, 'Jl. Cempedak No. 7')

TestObject inputRT = new TestObject('dynamicRT')
inputRT.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'rt\']')

WebUI.waitForElementVisible(inputRT, 20)
WebUI.setText(inputRT, '1')

TestObject inputRW = new TestObject('dynamicRW')
inputRW.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'rw\']')

WebUI.waitForElementVisible(inputRW, 20)
WebUI.setText(inputRW, '5')

TestObject dropdownProvinsi = new TestObject('dropdownProvinsi')
dropdownProvinsi.addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'vs7__combobox\']')

WebUI.click(dropdownProvinsi)

String opsiProvinsi = 'BALI'
TestObject pilihanProvinsi = new TestObject('option_Provinsi')
pilihanProvinsi.addProperty('xpath', ConditionType.EQUALS, ('//li[contains(@id,\'vs7__option\') and normalize-space(text())=\'' + opsiProvinsi) + '\']')

WebUI.click(pilihanProvinsi)

TestObject dropdownKab = new TestObject('dropdownKab')
dropdownKab.addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'vs9__combobox\']')

WebUI.click(dropdownKab)

String opsiKab = 'BANGLI'
TestObject pilihanKab = new TestObject('option_Kab')
pilihanKab.addProperty('xpath', ConditionType.EQUALS, ('//li[contains(@id,\'vs9__option\') and normalize-space(text())=\'' + opsiKab) + '\']')

WebUI.click(pilihanKab)

TestObject dropdownKec = new TestObject('dropdownKec')
dropdownKec.addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'vs8__combobox\']')

WebUI.click(dropdownKec)

String opsiKec = 'BANGLI'
TestObject pilihanKec = new TestObject('option_Kec')
pilihanKec.addProperty('xpath', ConditionType.EQUALS, ('//li[contains(@id,\'vs8__option\') and normalize-space(text())=\'' + opsiKec) + '\']')

WebUI.click(pilihanKec)

TestObject dropdownKel = new TestObject('dropdownKel')
dropdownKel.addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'vs10__combobox\']')

WebUI.click(dropdownKel)

String opsiKel = 'KUBU'
TestObject pilihanKel = new TestObject('option_Kel')
pilihanKel.addProperty('xpath', ConditionType.EQUALS, ('//li[contains(@id,\'vs10__option\') and normalize-space(text())=\'' + opsiKel) + '\']')

WebUI.click(pilihanKel)

TestObject radioJenisKegiatan = new TestObject('radioJenisKegiatan')
radioJenisKegiatan.addProperty('xpath', ConditionType.EQUALS, '//input[@type=\'radio\' and @value=\'Program Kerja\']')

WebUI.waitForElementClickable(radioJenisKegiatan, 20)
WebUI.click(radioJenisKegiatan)

TestObject textareaKeterangan = new TestObject('textareaKeterangan')
textareaKeterangan.addProperty('xpath', ConditionType.EQUALS, '(//textarea)[last()]')

if (WebUI.verifyElementPresent(textareaKeterangan, 5, FailureHandling.OPTIONAL)) {
    WebUI.setText(textareaKeterangan, 'keterangan kegiatan ada di sini')
}

String projectDir = RunConfiguration.getProjectDir()

String filePath = projectDir + GlobalVariable.fileUpload

TestObject uploadFile = new TestObject()
uploadFile.addProperty('xpath', ConditionType.EQUALS, '//input[@type="file"]')

WebUI.uploadFile(uploadFile, filePath)

TestObject simpanBtnPengajuan = new TestObject()
simpanBtnPengajuan.addProperty('xpath', ConditionType.EQUALS, '//button[normalize-space()=\'Simpan\']')

WebUI.click(simpanBtnPengajuan)

TestObject closeBtnPengajuan = new TestObject()
closeBtnPengajuan.addProperty('xpath', ConditionType.EQUALS, '//button[normalize-space()=\'Tutup\']')

WebUI.waitForElementClickable(closeBtnPengajuan, 20)
WebUI.click(closeBtnPengajuan)


//Verifikasi Berkas
TestObject submenuVerifikasiBerkas = new TestObject('submenuVerifikasiBerkas')
submenuVerifikasiBerkas.addProperty('xpath', ConditionType.EQUALS, '//li[contains(@class,\'has-sub\') and .//span[normalize-space(text())=\'Penyaluran Cabang\']]//ul//span[normalize-space(text())=\'Verifikasi Berkas\']')

WebUI.click(submenuVerifikasiBerkas)

WebUI.delay(40)

TestObject btnApproveVerifikasiBerkas = new TestObject('btnApproveVerifikasiBerkas')
btnApproveVerifikasiBerkas.addProperty('xpath', ConditionType.EQUALS, '(//button[@title=\'Approve\' and contains(@class,\'btn-success\')])[1]')

WebUI.waitForElementVisible(btnApproveVerifikasiBerkas, 20)
WebUI.click(btnApproveVerifikasiBerkas)

TestObject buttonTerimaVerifikasiBerkas = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//button[contains(text(),\'Terima\')]')

WebUI.click(buttonTerimaVerifikasiBerkas)

TestObject closeBtnVerifikasiBerkas = new TestObject()
closeBtnVerifikasiBerkas.addProperty('xpath', ConditionType.EQUALS, '//button[normalize-space()=\'Tutup\']')

WebUI.waitForElementVisible(closeBtnVerifikasiBerkas, 20)

WebUI.click(closeBtnVerifikasiBerkas)


//Survey Lokasi
TestObject submenuSurveyLokasi = new TestObject('submenuSurveyLokasi')
submenuSurveyLokasi.addProperty('xpath', ConditionType.EQUALS, '//li[contains(@class,\'has-sub\') and .//span[normalize-space(text())=\'Penyaluran Cabang\']]//ul//span[normalize-space(text())=\'Survey Lokasi\']')

WebUI.click(submenuSurveyLokasi)

WebUI.delay(40)

TestObject btnApproveSurveyLokasi = new TestObject('btnApproveSurveyLokasi')
btnApproveSurveyLokasi.addProperty('xpath', ConditionType.EQUALS, '//button[@title=\'Approve\' and contains(@class,\'btn-success\')]')

WebUI.waitForElementVisible(btnApproveSurveyLokasi, 20)
WebUI.click(btnApproveSurveyLokasi)

TestObject dropdownTujuan = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//label[contains(.,\'Tujuan Pembangunan Berkelanjutan\')]/following::div[contains(@class,\'vs__selected-options\')][1]')

WebUI.click(dropdownTujuan)

TestObject inputSearchTujuan = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//label[contains(.,\'Tujuan Pembangunan Berkelanjutan\')]/following::input[contains(@class,\'vs__search\')][1]')

WebUI.waitForElementVisible(inputSearchTujuan, 20)
WebUI.setText(inputSearchTujuan, 'Tanpa Kelaparan')
WebUI.sendKeys(inputSearchTujuan, Keys.chord(Keys.ENTER))

TestObject bentukKegiatan = new TestObject('bentukKegiatan')
bentukKegiatan.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'bentuk_kegiatan\']')

WebUI.waitForElementVisible(bentukKegiatan, 20)
WebUI.setText(bentukKegiatan, 'Ikatan Kasih')

TestObject dropdownObjekBantuan = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//label[contains(.,\'Kondisi Objek Bantuan\')]/following::div[contains(@class,\'vs__selected-options\')][1]')

WebUI.click(dropdownObjekBantuan)

TestObject inputSearchObjekBantuan = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//label[contains(.,\'Kondisi Objek Bantuan\')]/following::input[contains(@class,\'vs__search\')][1]')

WebUI.waitForElementVisible(inputSearchObjekBantuan, 20)
WebUI.setText(inputSearchObjekBantuan, 'Layak')
WebUI.sendKeys(inputSearchObjekBantuan, Keys.chord(Keys.ENTER))

WebDriver driver = DriverFactory.getWebDriver()
WebElement elementalamat = driver.findElement(By.xpath('//input[@name=\'checkAlamat\']'))

js.executeScript('arguments[0].click();', elementalamat)

TestObject hasilsurvey = new TestObject()
hasilsurvey.addProperty('xpath', ConditionType.EQUALS, '//label[normalize-space()=\'Hasil Survei\']/following::textarea[1]')

WebUI.setText(hasilsurvey, 'Lanjut Approval')

TestObject dropdownJenisBantuan = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//label[contains(.,\'Jenis Bantuan\')]/following::div[contains(@class,\'vs__selected-options\')][1]')

WebUI.click(dropdownJenisBantuan)

TestObject inputSearchJenisBantuan = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//label[contains(.,\'Jenis Bantuan\')]/following::input[contains(@class,\'vs__search\')][1]')

WebUI.waitForElementVisible(inputSearchJenisBantuan, 20)
WebUI.setText(inputSearchJenisBantuan, 'Tunai')
WebUI.sendKeys(inputSearchJenisBantuan, Keys.chord(Keys.ENTER))

TestObject PerkiraanBantuan = new TestObject('PerkiraanBantuan')
PerkiraanBantuan.addProperty('xpath', ConditionType.EQUALS, '//input[@placeholder=\'Perkiraan Bantuan\']')

WebUI.waitForElementVisible(PerkiraanBantuan, 20)
WebUI.setText(PerkiraanBantuan, '10,000')

TestObject dropdownSatuanUkur = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//label[contains(.,\'Satuan Ukur\')]/following::div[contains(@class,\'vs__selected-options\')][1]')

WebUI.click(dropdownSatuanUkur)

TestObject inputSearchSatuanUkur = new TestObject().addProperty('xpath', ConditionType.EQUALS, '//label[contains(.,\'Satuan Ukur\')]/following::input[contains(@class,\'vs__search\')][1]')

WebUI.waitForElementVisible(inputSearchSatuanUkur, 20)
WebUI.setText(inputSearchSatuanUkur, 'Unit')
WebUI.sendKeys(inputSearchSatuanUkur, Keys.chord(Keys.ENTER))

TestObject RealisasiIndikator = new TestObject('RealisasiIndikator')
RealisasiIndikator.addProperty('xpath', ConditionType.EQUALS, '//input[@placeholder=\'Realisasi Indikator\']')

WebUI.waitForElementVisible(RealisasiIndikator, 20)
WebUI.setText(RealisasiIndikator, '2')

/*//Pilih "Ya"
TestObject radioUMPYa = new TestObject()
radioUMPYa.addProperty('xpath', ConditionType.EQUALS, '(//input[@type=\'radio\' and @name=\'Ya\'])[1]')

WebUI.click(radioUMPYa)*/

//Pilih "Tidak"
TestObject radioUMPTidak = new TestObject()
radioUMPTidak.addProperty("xpath", ConditionType.EQUALS, "(//input[@type='radio' and @name='Tidak'])[1]")

WebUI.click(radioUMPTidak)

TestObject simpanBtnSurveyLokasi = new TestObject()
simpanBtnSurveyLokasi.addProperty('xpath', ConditionType.EQUALS, '//button[normalize-space()=\'Simpan\']')

WebUI.click(simpanBtnSurveyLokasi)

TestObject closeBtnSurveyLokasi = new TestObject()
closeBtnSurveyLokasi.addProperty('xpath', ConditionType.EQUALS, '//button[normalize-space()=\'Tutup\']')

WebUI.click(closeBtnSurveyLokasi)


//Rekomendasi
TestObject submenuRekomendasi = new TestObject('submenuRekomendasi')
submenuRekomendasi.addProperty('xpath', ConditionType.EQUALS, '//li[contains(@class,\'has-sub\') and .//span[normalize-space(text())=\'Penyaluran Cabang\']]//ul//span[normalize-space(text())=\'Rekomendasi\']')

WebUI.click(submenuRekomendasi)

WebUI.delay(40)

TestObject btnApproveRekomendasi = new TestObject('btnApproveRekomendasi')
btnApproveRekomendasi.addProperty('xpath', ConditionType.EQUALS, '//button[@title=\'approve\' and contains(@class,\'btn-primary\')]')

WebUI.waitForElementVisible(btnApproveRekomendasi, 20)
WebUI.click(btnApproveRekomendasi)

TestObject buttonTerimaRekomendasi = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//button[contains(text(),\'Terima\')]')

WebUI.click(buttonTerimaRekomendasi)


//Approval Deputi Bisnis
TestObject submenuApprovalDeputiBisnis = new TestObject('submenuApprovalDeputiBisnis')
submenuApprovalDeputiBisnis.addProperty('xpath', ConditionType.EQUALS, '//li[contains(@class,\'has-sub\') and .//span[normalize-space(text())=\'Penyaluran Cabang\']]//ul//span[normalize-space(text())=\'Approval Deputi Bisnis\']')

WebUI.click(submenuApprovalDeputiBisnis)

WebUI.delay(40)

TestObject btnApproveDeputiBisnis = new TestObject('btnApproveDeputiBisnis')
btnApproveDeputiBisnis.addProperty('xpath', ConditionType.EQUALS, '//button[@title=\'approve\' and contains(@class,\'btn-primary\')]')

WebUI.waitForElementVisible(btnApproveDeputiBisnis, 20)
WebUI.click(btnApproveDeputiBisnis)

TestObject ketApp = new TestObject()
ketApp.addProperty('xpath', ConditionType.EQUALS, '//textarea[@placeholder=\'Keterangan\']')

WebUI.setText(ketApp, 'Approved Approval')

TestObject buttonTerimaDeputiBisnis = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//button[contains(text(),\'Terima\')]')

WebUI.click(buttonTerimaDeputiBisnis)

TestObject closeBtnDeputiBisnis = new TestObject()
closeBtnDeputiBisnis.addProperty('xpath', ConditionType.EQUALS, '//button[normalize-space()=\'Tutup\']')

WebUI.click(closeBtnDeputiBisnis)


//Permohonan Dana
TestObject submenuPermohonanDana = new TestObject('submenuPermohonanDana')
submenuPermohonanDana.addProperty('xpath', ConditionType.EQUALS, '//li[contains(@class,\'has-sub\') and .//span[normalize-space(text())=\'Penyaluran Cabang\']]//ul//span[normalize-space(text())=\'Permohonan Dana\']')

WebUI.click(submenuPermohonanDana)

WebUI.delay(40)

TestObject btnApprovePermohonanDana = new TestObject('btnApprovePermohonanDana')
btnApprovePermohonanDana.addProperty('xpath', ConditionType.EQUALS, '//button[@title=\'approve\' and contains(@class,\'btn-primary\')]')

WebUI.waitForElementVisible(btnApprovePermohonanDana, 20)
WebUI.click(btnApprovePermohonanDana)

TestObject buttonTerimaPermohonanDana = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//button[contains(text(),\'Terima\')]')

WebUI.click(buttonTerimaPermohonanDana)


//Pengiriman Dana
TestObject submenuPengirimanDana = new TestObject('submenuPermohonanDana')
submenuPengirimanDana.addProperty('xpath', ConditionType.EQUALS, '//li[contains(@class,\'has-sub\') and .//span[normalize-space(text())=\'Penyaluran Cabang\']]//ul//span[normalize-space(text())=\'Pengiriman Dana\']')

WebUI.click(submenuPengirimanDana)

WebUI.delay(40)

TestObject btnApprovePengrimanDana = new TestObject('btnApprovePengrimanDana')
btnApprovePengrimanDana.addProperty('xpath', ConditionType.EQUALS, '//button[@title=\'approve\' and contains(@class,\'btn-primary\')]')

WebUI.waitForElementVisible(btnApprovePengrimanDana, 20)
WebUI.click(btnApprovePengrimanDana)

TestObject buttonTerimaPengrimanDana = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//button[contains(text(),\'Terima\')]')

WebUI.click(buttonTerimaPengrimanDana)

TestObject btnSimpanPengirimanDana = new TestObject('btnSimpanPengirimanDana')
btnSimpanPengirimanDana.addProperty('xpath', ConditionType.EQUALS, '//button[contains(@class,\'btn-success\') and @type=\'submit\']')

WebUI.click(findTestObject('Object Repository/Page_PPMDKS/span_Simpan'))


/*//UMP
TestObject submenuUMP = new TestObject('submenuUMP')
submenuUMP.addProperty('xpath', ConditionType.EQUALS, '//li[contains(@class,\'has-sub\') and .//span[normalize-space(text())=\'Penyaluran Cabang\']]//ul//span[normalize-space(text())=\'UMP\']')

WebUI.click(submenuUMP)

WebUI.delay(40)

TestObject btnUMP = new TestObject('btnUMP')
btnUMP.addProperty('xpath', ConditionType.EQUALS, '//button[@title=\'approve\' and contains(@class,\'btn-primary\')]')

WebUI.waitForElementVisible(btnUMP, 10)
WebUI.click(btnUMP)

TestObject btnSimpanUMP = new TestObject().addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//button[contains(text(),\'Simpan\')]')

WebUI.click(btnSimpanUMP)

WebUI.click(findTestObject('Object Repository/Page_PPMDKS/span_Simpan'))*/


//Pencairan
TestObject submenuPencairan = new TestObject('submenuPencairan')
submenuPencairan.addProperty('xpath', ConditionType.EQUALS, '//li[contains(@class,\'has-sub\') and .//span[normalize-space(text())=\'Penyaluran Cabang\']]//ul//span[normalize-space(text())=\'Pencairan\']')

WebUI.click(submenuPencairan)

WebUI.delay(40)

TestObject btnRejectPencairan = new TestObject('btnRejectPencairan')
btnRejectPencairan.addProperty('xpath', ConditionType.EQUALS, '//button[@title=\'reject\' and contains(@class,\'btn-danger\')]')

WebUI.waitForElementVisible(btnRejectPencairan, 20)
WebUI.click(btnRejectPencairan)

TestObject txtCatatanReject = new TestObject("txtCatatanReject")
txtCatatanReject.addProperty("xpath", ConditionType.EQUALS, "//textarea[@placeholder='Masukkan catatan pembatalan']")

WebUI.waitForElementVisible(txtCatatanReject, 20) 
WebUI.scrollToElement(txtCatatanReject, 5)
WebUI.setText(txtCatatanReject, "Tidak sesuai")

TestObject btnSimpanReject = new TestObject('btnSimpanReject')
btnSimpanReject.addProperty('xpath', ConditionType.EQUALS, "//button[@type='submit' and contains(@class,'btn-success') and .//span[normalize-space()='Simpan']]")

WebUI.waitForElementClickable(btnSimpanReject, 20)

WebElement elementReject = Helper.findWebElement(btnSimpanReject, 20)

js.executeScript("arguments[0].scrollIntoView(true);", elementReject)
js.executeScript("arguments[0].click();", elementReject)

WebUI.delay(20)

WebUI.closeBrowser()