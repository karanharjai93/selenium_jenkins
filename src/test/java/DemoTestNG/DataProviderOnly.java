package DemoTestNG;

import org.testng.annotations.DataProvider;

public class DataProviderOnly {


    @DataProvider(name = "input-provider")
//    @DataProvider
    public static Object[][] inputData(){

        Object[][] data = new Object[2][3];

        data[0][0] = "Joe";   data[0][1]="Joe@Gmail.com";  data[0][2] = 1;
        data[1][0]="Jane";   data[1][1] ="Jane@Gmail.com"; data[1][2] = 2;

        return data;
    }

}
