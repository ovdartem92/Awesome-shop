package ru.awesome.shop.ta.product.services;

import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.SearchResultPage;
import ru.awesome.shop.ta.product.pages.fragments.SearchResultFragment;

import java.util.List;

public class SearchService {
    HomePage homePage = new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage();

    public void openHomePageTypeDataToSearch(String searchData) {
        homePage.open()
                .typeSearchQuery(searchData);
    }

    public void openHomePageTypeDataToSearchClickSearchButton(String searchData) {
        homePage.open()
                .typeSearchQuery(searchData)
                .clickSearchButton();
    }

    public void openHomePageTypeDataToSearchClickSearchButtonSelectCategory(String searchData, String categoryName) {
        homePage.open()
                .typeSearchQuery(searchData)
                .clickSearchButton()
                .selectCategory(categoryName)
                .clickSearchButtonOnSearchResultPage();
    }

    public void openHomePageTypeDataToSearchClickSearchButtonSetDescription(String searchData) {
        homePage.open()
                .typeSearchQuery(searchData)
                .clickSearchButton()
                .setDescriptionCheckbox(true)
                .clickSearchButtonOnSearchResultPage();
    }

    public SearchResultFragment getFirstActualSearchFragment() {
        List<SearchResultFragment> allSearchResults = searchResultPage.getAllSearchResults();
        return allSearchResults.get(0);
    }

    public String getCheckedIncorrectSearchCriteriaMessage() {
        try {
            return searchResultPage.getIncorrectSearchCriteriaMessage();
        } catch (Exception e) {
            return "Search message is not displayed" + e.toString();
        }
    }
}
