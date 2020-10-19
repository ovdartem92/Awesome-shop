//
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import page.net.skyscanner.SkyScannerHomePage;
//import service.TestDataReader;
//
//import java.util.ArrayList;
//
//
//public class ChangeCurrencyTest extends CommonConditions {
//    @Test
//    public void checkCurrencyChangeTest() {
//        ArrayList<WebElement> prices = (ArrayList<WebElement>) new SkyScannerHomePage().startFlightsSearch().selectCurrency().getCurrencies();
//        for (WebElement price : prices) {
//            Assert.assertTrue(price.getText().contains(TestDataReader.getTestData("testData.currency").replaceAll(".*[a-zA-Z]\\s\\-\\s", "")),
//                    "Not all prices are in selected currency");
//        }
//    }
//}
