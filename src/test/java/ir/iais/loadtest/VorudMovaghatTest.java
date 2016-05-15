package ir.iais.loadtest;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VorudMovaghatTest {
    //private WebDriver driver;
    //private String baseUrl;

    private boolean acceptNextAlert = true;
    //private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {
//        driver = new HtmlUnitDriver(true);
//        baseUrl = "http://172.16.111.113:8080/";
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(invocationCount = 15, threadPoolSize = 15)
    public void testLoginCustoms113() throws Exception {
        StringBuilder verificationErrors = new StringBuilder();
        System.setProperty("webdriver.chrome.driver", "/test-configs/chromedriver");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://172.16.111.113:8080/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // ERROR: Caught exception [ERROR: Unsupported command [setSpeed | 3000 | ]]
        /* BEGINING OF LOGIN */
        try {
            driver.get("http://172.16.111.113:8080/Customs/");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        // ERROR: Caught exception [ERROR: Unsupported command [setSpeed | 150 | ]]
        // ERROR: Caught exception [ERROR: Unsupported command [getEval | window.location.pathname.contains("Login") | ]]
        // ERROR: Caught exception [unknown command [gotoIf]]
        //String profile = driver.findElement(By.cssSelector("a.dropdown-toggle")).getText();
        // ERROR: Caught exception [unknown command [gotoIf]]
        //driver.findElement(By.linkText("خروج")).click();
        // ERROR: Caught exception [unknown command [label]]
        driver.findElement(By.xpath("//input[@wicketpath='loginForm_userId']")).clear();
        driver.findElement(By.xpath("//input[@wicketpath='loginForm_userId']")).sendKeys("0123456789");
        driver.findElement(By.xpath("//input[@wicketpath='loginForm_password']")).clear();
        driver.findElement(By.xpath("//input[@wicketpath='loginForm_password']")).sendKeys("123456Aa");
        driver.findElement(By.cssSelector("button.btn")).click();
        boolean ep = isElementPresent(By.cssSelector("h3[wicketpath$='ajaxIndicatorContainer_pageTitle']"), driver);
        assertTrue(ep);
        /* END OF LOGIN */
        
        /* BEGINING OF VORUD ETELAAT */
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", 
                driver.findElement(By.xpath("//parent::span[text()=\"اپراتور ورود موقت\"]/../../ul/li/a[text()=\"ورود اطلاعات ورود موقت با اظهار قبلی\"]")));
        //driver.findElement(By.xpath("//parent::span[text()=\"اپراتور ورود موقت\"]/../../ul/li/a[text()=\"ورود اطلاعات ورود موقت با اظهار قبلی\"]")).click();
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if ("ورود اطلاعات ورود موقت با اظهار قبلی".equals(driver.findElement(By.cssSelector("h3[wicketpath$='ajaxIndicatorContainer_pageTitle']")).getText())) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        // ERROR: Caught exception [ERROR: Unsupported command [runScript | $("select").removeAttr("style") | ]]
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (isElementPresent(By.cssSelector("input[wicketpath$='panel_content_htmlForm_form_comment']"), driver)) {
                    break;
                }
                //System.err.println(driver.getPageSource());
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        
        driver.getPageSource();
        new Select(driver.findElement(By.cssSelector("select[wicketpath$='content_htmlForm_form_noeSaderat_auto']"))).selectByVisibleText("حمل يکسره");
        new Select(driver.findElement(By.cssSelector("select[wicketpath$='content_htmlForm_form_saderatType_auto']"))).selectByVisibleText("سایر");
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_girande_code']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_girande_code']")).sendKeys("0123456789");
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_hagholAmalKar_code']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_hagholAmalKar_code']")).sendKeys("0123456789");
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_ezharkonande_code']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_ezharkonande_code']")).sendKeys("0123456789");
        new Select(driver.findElement(By.cssSelector("select[wicketpath$='content_htmlForm_form_midCountry_auto']"))).selectByVisibleText("TL( تيمور)");
        new Select(driver.findElement(By.cssSelector("select[wicketpath$='content_htmlForm_form_hoviatVasile_auto']"))).selectByVisibleText("ايراني");
        new Select(driver.findElement(By.cssSelector("select[wicketpath$='content_htmlForm_form_origCountry_auto']"))).selectByVisibleText("TK( توکلائو)");
        new Select(driver.findElement(By.cssSelector("select[wicketpath$='content_htmlForm_form_arzeshType_auto']"))).selectByVisibleText("FCA");
        new Select(driver.findElement(By.cssSelector("select[wicketpath$='content_htmlForm_form_arzType_auto']"))).selectByVisibleText("USD");
        new Select(driver.findElement(By.cssSelector("select[wicketpath$='content_htmlForm_form_pardakhtPanel24_pardakhtType']"))).selectByVisibleText("مبادلات مرزی");
        new Select(driver.findElement(By.cssSelector("select[wicketpath$='content_htmlForm_form_nahveHamlDarMarz_auto']"))).selectByVisibleText("زميني");
        new Select(driver.findElement(By.cssSelector("select[wicketpath$='content_htmlForm_form_gomrokVorudi_auto']"))).selectByVisibleText("منطقه ويژه اقتصادي شهيد رجايي(50100)");
        new Select(driver.findElement(By.cssSelector("select[wicketpath$='content_htmlForm_form_mahalArzyabi_auto']"))).selectByVisibleText("TOTAL");
        // ERROR: Caught exception [ERROR: Unsupported command [getEval | Math.floor(Math.random()*100000000) | ]]
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_شماره ثبت سفارش_item']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_شماره ثبت سفارش_item']")).sendKeys(getRandInt().toString());
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_sabtDate_year']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_sabtDate_year']")).sendKeys("93");
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_sabtDate_month']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_sabtDate_month']")).sendKeys("1");
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_sabtDate_day']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_sabtDate_day']")).sendKeys("1");
        driver.findElement(By.cssSelector("input[wicketpath$='form_kalaPanel_form_kalaInfoContainer_tarefe']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='form_kalaPanel_form_kalaInfoContainer_tarefe']")).sendKeys("09083110");
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_تعداد بسته_item']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_تعداد بسته_item']")).sendKeys("10");
        new Select(driver.findElement(By.cssSelector("select[wicketpath$='kalaPanel_form_kalaInfoContainer_noeBaste_auto']"))).selectByVisibleText("رول");
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_وزن ناخالص_item']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_وزن ناخالص_item']")).sendKeys("100");
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_وزن خالص_item']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_وزن خالص_item']")).sendKeys("10");
        new Select(driver.findElement(By.cssSelector("select[wicketpath$='kalaPanel_form_kalaInfoContainer_brandType_auto']"))).selectByVisibleText("کشورسازنده");
        driver.findElement(By.cssSelector("textarea[wicketpath$='form_kalaPanel_form_kalaInfoContainer_noeKala']")).clear();
        driver.findElement(By.cssSelector("textarea[wicketpath$='form_kalaPanel_form_kalaInfoContainer_noeKala']")).sendKeys("نداردنداردنداردنداردندارد");
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_نام برند_item']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_نام برند_item']")).sendKeys("ندارد");
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_مدل_item']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_مدل_item']")).sendKeys("ندارد");
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_تعداد واحد_item']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_تعداد واحد_item']")).sendKeys("1");
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_ارزش قلمی_item']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_ارزش قلمی_item']")).sendKeys("1");
        new Select(driver.findElement(By.cssSelector("select[wicketpath$='kalaPanel_form_kalaInfoContainer_isNew_auto']"))).selectByVisibleText("نو");
        // ERROR: Caught exception [ERROR: Unsupported command [getEval | storedVars['randint']*storedVars['randint'] | ]]
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_ghabzanbar_shomare']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_ghabzanbar_shomare']")).sendKeys(getRandInt().toString());
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_بیمه_item']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_بیمه_item']")).sendKeys("1");
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_کرایه_item']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='kalaPanel_form_kalaInfoContainer_کرایه_item']")).sendKeys("1");
        new Select(driver.findElement(By.cssSelector("select[wicketpath$='kalaPanel_form_kalaInfoContainer_vahed_auto']"))).selectByVisibleText("عدد");
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_شماره فاکتور_item']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_شماره فاکتور_item']")).sendKeys("11111111");
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_factorDate_day']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_factorDate_day']")).sendKeys("27");
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_factorDate_month']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_factorDate_month']")).sendKeys("1");
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_factorDate_year']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_factorDate_year']")).sendKeys("15");
        driver.findElement(By.cssSelector("input[wicketpath$='panel_content_htmlForm_form_barnameNum']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='panel_content_htmlForm_form_barnameNum']")).sendKeys("1234567");
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_pakingNum_item']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_pakingNum_item']")).sendKeys("88888888");
        driver.findElement(By.cssSelector("input[wicketpath$='panel_content_htmlForm_form_manifestNum']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='panel_content_htmlForm_form_manifestNum']")).sendKeys("1547671652");
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_manifestDate_year']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_manifestDate_year']")).sendKeys("15");
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_manifestDate_month']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_manifestDate_month']")).sendKeys("4");
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_manifestDate_day']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_manifestDate_day']")).sendKeys("26");
        driver.findElement(By.cssSelector("input[wicketpath$='panel_content_htmlForm_form_t01']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='panel_content_htmlForm_form_t01']")).sendKeys("50");
        driver.findElement(By.cssSelector("input[wicketpath$='panel_content_htmlForm_form_t07']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='panel_content_htmlForm_form_t07']")).sendKeys("1");
        driver.findElement(By.cssSelector("input[wicketpath$='panel_content_htmlForm_form_m05']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='panel_content_htmlForm_form_m05']")).sendKeys("0");
        driver.findElement(By.cssSelector("input[wicketpath$='panel_content_htmlForm_form_t08']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='panel_content_htmlForm_form_t08']")).sendKeys("0");
        driver.findElement(By.cssSelector("input[wicketpath$='panel_content_htmlForm_form_m04']")).clear();
        driver.findElement(By.cssSelector("input[wicketpath$='panel_content_htmlForm_form_m04']")).sendKeys("0");
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", 
                driver.findElement(By.cssSelector("input[wicketpath$='content_htmlForm_form_buttonAndKalaTable_ajax-button-sabt']")));
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if ("ثبت کالا با موفقیت انجام شد".equals(driver.findElement(By.cssSelector("span[wicketpath$='content_htmlForm_form_buttonAndKalaTable_finalMessage']")).getText())) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", 
                driver.findElement(By.cssSelector("input[wicketpath$='panel_content_htmlForm_form_ajax-button-sabt']")));
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if (driver.findElement(By.cssSelector("span[wicketpath$='panel_content_htmlForm_form_finalMessage']")).getText().matches("^فرم خوداظهاری شما با شماره سریال [\\s\\S]*ثبت شد\\.$")) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        String serial = driver.findElement(By.cssSelector("span[wicketpath$='panel_content_htmlForm_form_finalMessage']")).getText();
        // ERROR: Caught exception [ERROR: Unsupported command [getEval | storedVars['serial'].replace("فرم خوداظهاری شما با شماره سریال ","") | ]]
        // ERROR: Caught exception [ERROR: Unsupported command [getEval | storedVars['serial'].replace(" ثبت شد.","") | ]]
        /* END OF VORUD ETELAAT */

        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
        // ERROR: Caught exception [unknown command [gotoIf]]
//    driver.get("http://172.16.111.113:8080/Customs/");
//    driver.findElement(By.xpath("//input[@wicketpath='loginForm_userId']")).clear();
//    driver.findElement(By.xpath("//input[@wicketpath='loginForm_userId']")).sendKeys("0123456789");
//    driver.findElement(By.xpath("//input[@wicketpath='loginForm_password']")).clear();
//    driver.findElement(By.xpath("//input[@wicketpath='loginForm_password']")).sendKeys("123456Aa");
//    driver.findElement(By.cssSelector("button.btn")).click();
        // ERROR: Caught exception [unknown command [label]]
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
//        driver.quit();
//        String verificationErrorString = verificationErrors.toString();
//        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
//        }
    }

    private boolean isElementPresent(By by, WebDriver driver) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    private Integer getRandInt() {
        return (int) System.currentTimeMillis() + new Random().nextInt(200);
    }
}
