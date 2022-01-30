package test_klov;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.mongodb.MongoClientURI;
import org.testng.annotations.Test;

public class TestKlov {
    @Test
    public void testKlov()
    {
        ExtentKlovReporter klov = new ExtentKlovReporter("test_klov_server", "test_klov");
        klov.initMongoDbConnection(new MongoClientURI("mongodb://user:password@localhost:57017"));
        klov.initKlovServerConnection("http://localhost:6780");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(klov);
        ExtentTest extentTest = extent.createTest("first Test", "sample description");
        extentTest.info("Info Message");
        extentTest.pass("Success");

    }
}
