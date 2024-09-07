package pages.webpages;

import helpers.container.Context;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.factory.BasePage;

public class DashboardPage extends BasePage {

    public DashboardPage(Context context) {
        super(context);
        PageFactory.initElements(context.getDriver(), this);
    }

    //Hesabim Elements
    @FindBy(xpath = "//a[@data-testid='header-hesabim-btn']")
    private WebElement hesabimMenu;
    @FindBy(xpath = "//a[contains(text(),'Çıkış')]")
    private WebElement cikisButton;

    public void openHesabimMenu(){
        hoverOver(hesabimMenu);
    }

    public void logout(){
        openHesabimMenu();
        click(cikisButton);
    }



}
