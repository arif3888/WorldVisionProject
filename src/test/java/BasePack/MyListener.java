package BasePack;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//Listener is post action

public class MyListener implements ITestListener   //ITestListener is a interface
{

	  public void onStart(ITestContext context) {
		   
		  System.out.println("Test execution is started.......");
		  
		  }
	  
	  
	  public void onTestStart(ITestResult result) {
		  System.out.println("test started...");
		  }
	 
	  public void onTestSuccess(ITestResult result) {
		  System.out.println("test passed..."+result.getMethod() );
		  }
	 
	
	  public void onTestFailure(ITestResult result) {
		  System.out.println("test failed..."+result.getMethod());
		  }
	  
	  public void onTestSkipped(ITestResult result) {
		  System.out.println("test skipped..."+result.getMethod());
		  }
	  
	  public void onFinish(ITestContext context) {
		  System.out.println("test execution is completed...");
		  }
}
