package net.skyscanner.ta.framework.ui.elements;

import org.openqa.selenium.*;

import java.util.List;

public class HighlightedWebElement extends AbstractWebElementDecorator {
    private final WebDriver driver;
    private final WebElement element;
    private final String EXECUTOR_STRING = "arguments[0].setAttribute('style', 'background: arguments[1]; border: arguments[2];');";
    private String backgroundColor;
    private String border;

    public HighlightedWebElement(WebElement element, WebDriver driver) {
        this.driver = driver;
        this.element = element;
        this.backgroundColor = "yellow";
        this.border = "3px solid red";
    }

    public HighlightedWebElement(WebElement element, WebDriver driver, final String backgroundColor, final String border) {
        this.driver = driver;
        this.element = element;
        this.backgroundColor = backgroundColor;
        this.border = border;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    private void highlight() {
        highlight(backgroundColor, border);
    }

    private void highlight(final String backgroundColor, final String border) {
        for (int i = 0; i < 5; i++) {
            WrapsDriver wrappedElement = (WrapsDriver) driver;
            JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();
            js.executeScript(EXECUTOR_STRING, element, backgroundColor, border);
            js.executeScript(EXECUTOR_STRING, element, "", "");
        }
    }

    // Alternative version using timeout.
    private void highlight(final String backgroundColor, final String border, int timeout) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(EXECUTOR_STRING, element, backgroundColor, border);
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript(EXECUTOR_STRING, element, "", "");
    }

    @Override
    public void click() {
        this.highlight();
        element.click();
    }

    @Override
    public void submit() {
        this.highlight();
        element.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        this.highlight();
        element.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        this.highlight();
        element.clear();
    }

    @Override
    public String getTagName() {
        this.highlight();
        return element.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        this.highlight();
        return element.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        this.highlight();
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        this.highlight();
        return element.isEnabled();
    }

    @Override
    public String getText() {
        this.highlight();
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        this.highlight();
        return element.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        this.highlight();
        return element.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        this.highlight();
        return element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        this.highlight();
        return element.getLocation();
    }

    @Override
    public Dimension getSize() {
        this.highlight();
        return element.getSize();
    }

    @Override
    public Rectangle getRect() {
        this.highlight();
        return element.getRect();
    }

    @Override
    public String getCssValue(String s) {
        this.highlight();
        return element.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        this.highlight();
        return element.getScreenshotAs(outputType);
    }
}
