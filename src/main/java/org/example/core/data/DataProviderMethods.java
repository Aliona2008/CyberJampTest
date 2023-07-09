package org.example.core.data;

import org.testng.annotations.DataProvider;

public class DataProviderMethods {
    @DataProvider
    public Object[][] dataForCreateAccountTest(){
        return  new Object[][] {
                {"", "", "", "", ""},
                {"", "test-last-name", "iva@gmail.com", "7492t*9S", "123"},
                {"test-first-name", "", "bds", "12345678", ""},
                {"test-first-name", "test-last-name", "nfh@gmail.com", "7451St$7", "603tB43"}
        };
    }
}
