package awesome.shop.tests.cucumber.steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.awesome.shop.ta.product.pages.SearchResultPage;
import ru.awesome.shop.ta.product.pages.fragments.SearchFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchResultFragment;
import ru.awesome.shop.ta.product.services.NavigationService;
import ru.awesome.shop.ta.product.services.SearchService;

import java.util.ArrayList;
import java.util.List;

public class SearchSteps {
    SearchFragment searchFragment = new SearchFragment();
    SearchResultPage searchResultPage = new SearchResultPage();

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String listOfStringListsType(String cell) {
        return cell;
    }

    @Given("^I have opened home page$")
    public void openHomePage() {
        NavigationService service = new NavigationService();
        service.navigateToHomePage();
    }

    @When("^I search for \"(.*)\" product$")
    public void search(String searchCriteria) {
        searchFragment.typeSearchQuery(listOfStringListsType(searchCriteria));
        searchFragment.clickSearchButton();
    }

    @When("^I perform basic search of \"(.*)\" product$")
    public void performBasicSearch(String searchCriteria) {
        SearchService searchService = new SearchService();
        searchService.performBasicSearch(searchCriteria);
    }

    @When("^I type \"(.*)\" search query$")
    public void typeSearchQuery(String searchCriteria) {
        searchFragment.typeSearchQuery(searchCriteria);
    }

    @When("^I press Enter$")
    public void pressEnter() {
        searchFragment.performSearchByPressingEnter();
    }

    @When("^I select “iMac” category$")
    public void selectIMacCategory() {
        searchResultPage.setIMacCategory();
    }

    @When("^I enable search in product descriptions$")
    public void enableProductDescriptions() {
        searchResultPage.setDescriptionCheckbox(true);
    }

    @When("^I click advanced search button$")
    public void clickAdvancedSearchButton() {
        searchResultPage.clickSearchButtonOnSearchResultPage();
    }

    @Then("^\"(.*)\" product should be found$")
    public void checkSearchResultProduct(String expectedResultProduct) {
        List<SearchResultFragment> searchResults = searchResultPage.getAllSearchResults();
        List<String> productNames = new ArrayList<>();
        for (SearchResultFragment searchResult : searchResults) {
            productNames.add(searchResult.getName());
        }
        Assert.assertEquals(productNames.get(0), expectedResultProduct,
                expectedResultProduct + " wasn't found in search result.");
    }

    @Then("^I should see incorrect search message \"(.*)\"$")
    public void verifySearchMessage(String expectedResultMessage) {
        Assert.assertEquals(searchResultPage.getIncorrectSearchCriteriaMessage(), expectedResultMessage,
                expectedResultMessage + " isn't displayed");
    }
}
