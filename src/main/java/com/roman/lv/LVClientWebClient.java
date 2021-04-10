package com.roman.lv;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Service
public class LVClientWebClient {
    private static final Logger log = LoggerFactory.getLogger(LVClientWebClient.class);

 /*
 Checks if the item is in stock
  */
    public String inStock(String url) {

        String response ="Not Available";
            ChromeOptions chromeOptions = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", "target/classes/static/chromedriver.exe"); // Setting system properties of FirefoxDriver

            //Proxy proxy = new org.openqa.selenium.Proxy();
            //proxy.setSslProxy("shtek:YvJ9b@uTV9AZ@Xs@us-wa.proxymesh.com:31280");
            // proxy.setHttpProxy("shtek:YvJ9b@uTV9AZ@Xs@us-wa.proxymesh.com:31280");
            // chromeOptions.setCapability("proxy", proxy);
            WebDriver driver = new ChromeDriver(chromeOptions);
            try{
            driver.get(url);
            By by = new By.ByClassName("lv-stock-indicator");
            WebElement webElement = driver.findElement(by);
            response = webElement.getText();
          //  driver.close();
            driver.quit();
        }
        catch(Exception e){
            e.printStackTrace();
            driver.quit();

        }
        return response;
    }
}