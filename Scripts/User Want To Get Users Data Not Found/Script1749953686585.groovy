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

def response = WS.sendRequest(findTestObject('Get Method/Get Single Users Not Found'))

if (WS.verifyResponseStatusCode(response, 404)) {
    KeywordUtil.markPassed('Status Responses Code Sesuai')

    KeywordUtil.logInfo('Status Code: ' + response.getStatusCode())
} else {
    KeywordUtil.markFailed('Status Responses Code Sesuai')

    KeywordUtil.logInfo('Status Code yang Didapatkan: ' + response.getStatusCode())
}

if (response.getResponseBodyContent() != null) {
    KeywordUtil.markPassed('Response Body Tidak Memiliki Value')
} else {
    KeywordUtil.markFailed('Response Body Memiliki Value')
}

if (response.getResponseBodyContent() == '{}') {
    KeywordUtil.markPassed('Data Sudah Sesuai')
} else {
    KeywordUtil.markFailed('Data Tidak Sesuai')
}

