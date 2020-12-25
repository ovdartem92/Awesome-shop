package ru.awesome.shop.ta.product.services;

import ru.awesome.shop.ta.framework.exceptions.IncorrectSearchCriteriaException;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.SearchResultPage;
import ru.awesome.shop.ta.product.pages.fragments.SearchResultFragment;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    HomePage homePage = new HomePage();

    public String[] searchWithoutClickingTheSearchButton(String searchData) {
        homePage.open();
        homePage.typeSearchQuery(searchData);
        SearchResultPage searchResultPage = new SearchResultPage();
        List<SearchResultFragment> searchResults = searchResultPage.getAllSearchResults();
        List<String> productNames = new ArrayList<>();
        for (SearchResultFragment searchResult : searchResults) {
            productNames.add(searchResult.getName());
        }
        return productNames.toArray(String[]::new);
    }

    public String[] search(String searchCriteria) {
        return search(searchCriteria, false, false);
    }

    public String[] search(String searchCriteria, boolean isSearchInProductDescriptionsEnabled, boolean isSearchInSubcategoriesEnabled) {
        homePage.open();
        homePage.typeSearchQuery(searchCriteria);
        SearchResultPage searchResultPage = homePage.clickSearchButton();
        if (searchResultPage.hasErrorMessage()) {
            throw new IncorrectSearchCriteriaException("Search failed: " + searchResultPage.getIncorrectSearchCriteriaMessage());
        }
        if (isSearchInProductDescriptionsEnabled) {
            searchResultPage.setDescriptionCheckbox(true);
            searchResultPage.clickSearchButtonOnSearchResultPage();
        }
        if (isSearchInSubcategoriesEnabled) {
            searchResultPage.setIMacCategory();
            searchResultPage.clickSearchButtonOnSearchResultPage();
        }
        List<SearchResultFragment> searchResults = searchResultPage.getAllSearchResults();
        List<String> productNames = new ArrayList<>();
        for (SearchResultFragment searchResult : searchResults) {
            productNames.add(searchResult.getName());
        }
        return productNames.toArray(String[]::new);
    }
}
