package com.dummy.api.runners;

import com.dummy.api.utils.exceldata.BeforeSuite;
import com.dummy.api.utils.exceldata.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import java.io.IOException;

@RunWith(CustomRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/",
        tags = "@ServiciosApi",
        glue = {
                "com.dummy.api.stepsdefinitions.hook",
                "com.dummy.api.stepsdefinitions"
        },
        publish = true
)
public class Runner {
        @BeforeSuite
        public static void test() throws IOException, InvalidFormatException {
                DataToFeature.overrideFeatureFiles("./src/test/resources/features/");
        }
}
