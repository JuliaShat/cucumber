package Steps;
import Core.DriverFactory;
import Interfaces.IMainPage;
import Pages.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Steps {
    protected final Logger log = LogManager.getLogger(this.getClass());
    MainPage mp = new MainPage();
}