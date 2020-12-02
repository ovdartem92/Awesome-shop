package net.skyscanner.ta.framework.ui.elements;

import org.openqa.selenium.*;

import java.util.List;

public class HighlightedWebElement extends AbstractWebElementDecorator {
    private final WebDriver driver;
    private WebElement element;
    private final int TIMEOUT_IN_MILLISECONDS = 1000;
    private String executorString = "arguments[0].setAttribute('style', 'background: arguments[1]; border: arguments[2];');";

    public HighlightedWebElement(WebElement element, WebDriver driver) {
        this.driver = driver;
        this.element = element;
    }

    private void highlight(final String background) {
        highlight(background, "3px solid red");
    }

    private void highlight(final String background, final String border) {
        for (int i = 0; i < 5; i++) {
            WrapsDriver wrappedElement = (WrapsDriver) element;
            JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();
            js.executeScript(executorString ,element, background, border);
            js.executeScript(executorString, element, "", "");
        }
    }

    // Alternative version using timeout.
    private void highlight(final String background, final String border, int timeout) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(executorString ,element, background, border);
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript(executorString, element, "", "");
    }

    @Override
    public void click() {
        this.highlight("yellow");
        element.click();
    }

    @Override
    public void submit() {
        this.highlight("yellow");
        element.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        this.highlight("yellow");
        element.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        this.highlight("yellow");
        element.clear();
    }

    @Override
    public String getTagName() {
        this.highlight("yellow");
        return element.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        this.highlight("yellow");
        return element.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        this.highlight("yellow");
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        this.highlight("yellow");
        return element.isEnabled();
    }

    @Override
    public String getText() {
        this.highlight("yellow");
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        this.highlight("yellow");
        return element.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        this.highlight("yellow");
        return element.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        this.highlight("yellow");
        return element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        this.highlight("yellow");
        return element.getLocation();
    }

    @Override
    public Dimension getSize() {
        this.highlight("yellow");
        return element.getSize();
    }

    @Override
    public Rectangle getRect() {
        this.highlight("yellow");
        return element.getRect();
    }

    @Override
    public String getCssValue(String s) {
        this.highlight("yellow");
        return element.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        this.highlight("yellow");
        return element.getScreenshotAs(outputType);
    }
}
