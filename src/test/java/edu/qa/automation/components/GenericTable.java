package edu.qa.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.qa.automation.utils.WaitingProcess.setTime;


public class GenericTable {

    private By wrapper;
    private String xpathHeader = "thead//th";
    private String xpathRow = "tr[self::tr/parent::tbody]";
    private String xpathColumn = "td[self::td/parent::tr/parent::tbody and position() mod 2 =1]";

    public GenericTable(By wrapper){
        this.wrapper = wrapper;
    }

    public WebElement findRow(Map<Object, String> criteria){
        setTime(ExpectedConditions.visibilityOfElementLocated(this.wrapper));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".//*[");

        Map<Object, String> childLocators = new HashMap<>();

        for(Map.Entry<Object, String> entry : criteria.entrySet()){
            int index;
            if(entry.getKey() instanceof Integer){
                index= (int)entry.getKey();
            }else{
                index = getHeaderIndex(entry.getKey().toString());
            }
            childLocators.put(entry.getKey(), String.format("%s[%2d][normalize-space(.)='%s']", xpathColumn, index, entry.getValue()));

            System.out.println(childLocators);
        }

        for(Map.Entry<Object, String> entry : childLocators.entrySet()){
            stringBuilder.append(String.format("self::%s//%s and ", xpathRow, entry.getValue()));
        }

        String chain = stringBuilder.toString();
        chain = String.format("%s]", chain.substring(0, chain.length() - 4));


        System.out.println(chain);
        return (WebElement) setTime(ExpectedConditions.presenceOfNestedElementLocatedBy(this.wrapper, By.xpath(chain)));
    }

    private int getHeaderIndex(String value) {
        int index = 0;
        List<WebElement> headers = (List<WebElement>) setTime(ExpectedConditions.presenceOfNestedElementsLocatedBy(this.wrapper, By.xpath(xpathHeader)));
        for(WebElement header: headers){
            System.out.println("-" + header.getText()  +"-");
            if(header.getText().equals(value)){
                return index+1;
            }
            index++;

        }
        return -1;
    }

}
