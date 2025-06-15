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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import groovy.json.JsonSlurper as JsonSlurper

def response = WS.sendRequest(findTestObject('Post Method/Post Login Failed'))

if (WS.verifyResponseStatusCode(response, 400)) {
    KeywordUtil.markPassed('Status Code 400 Sesuai (Bad Request)')

    KeywordUtil.logInfo('Status Code: ' + response.getStatusCode())

    def json = new JsonSlurper().parseText(response.getResponseBodyContent())

    // Verifikasi error message
    if (json.error == 'Missing password') {
        KeywordUtil.markPassed("Pesan error sesuai: $json.error")
    } else {
        KeywordUtil.markFailed("Pesan error tidak sesuai. Dapat: $json.error")
    }
} else {
    KeywordUtil.markFailed('Status Code tidak sesuai (diharapkan 400)')

    KeywordUtil.logInfo('Status Code diterima: ' + response.getStatusCode())
}

