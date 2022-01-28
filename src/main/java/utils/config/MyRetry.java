package utils.config;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @Author GrayCat.
 * @date 2022/01/14 18:16
 */
public class MyRetry implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 3;//用例失败重新执行3次

    @Override
    public boolean retry(ITestResult result) {
        if ( retryCount < maxRetryCount ){
            retryCount++;
            return true;
        }
        return false;
    }
}
