package ru.awesome.shop.ta.product.services;

import ru.awesome.shop.ta.framework.exceptions.IncorrectSearchCriteriaException;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.SearchResultPage;
import ru.awesome.shop.ta.product.pages.fragments.SearchFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchResultFragment;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    HomePage homePage = new HomePage();

    public List<String> performBasicSearch(String searchCriteria) {
        SearchFragment searchFragment = homePage.getSearchFragment();
        searchFragment.typeSearchQuery(searchCriteria);
        SearchResultPage searchResultPage = searchFragment.clickSearchButton();
        if (searchResultPage.hasErrorMessage()) {
            throw new IncorrectSearchCriteriaException("Search failed: "
                    + searchResultPage.getIncorrectSearchCriteriaMessage());
        }
        List<SearchResultFragment> searchResults = searchResultPage.getAllSearchResults();
        List<String> productNames = new ArrayList<>();
        for (SearchResultFragment searchResult : searchResults) {
            productNames.add(searchResult.getName());
        }
        return productNames;
    }

    public List<String> performAdvancedSearch(String searchCriteria) {
        return performAdvancedSearch(searchCriteria, false, false);
    }

    public List<String> performAdvancedSearch(String searchCriteria, boolean isSearchInProductDescriptionsEnabled, boolean isSearchInSubcategoriesEnabled) {
        SearchFragment searchFragment = homePage.getSearchFragment();
        searchFragment.typeSearchQuery(searchCriteria);
        SearchResultPage searchResultPage = searchFragment.clickSearchButton();
        if (isSearchInProductDescriptionsEnabled) {
            searchResultPage.setDescriptionCheckbox(true);
        }
        if (isSearchInSubcategoriesEnabled) {
            searchResultPage.setIMacCategory();
        }
        searchResultPage.clickSearchButton();
        if (searchResultPage.hasErrorMessage()) {
            throw new IncorrectSearchCriteriaException("Search failed: "
                    + searchResultPage.getIncorrectSearchCriteriaMessage());
        }
        List<SearchResultFragment> searchResults = searchResultPage.getAllSearchResults();
        List<String> productNames = new ArrayList<>();
        for (SearchResultFragment searchResult : searchResults) {
            productNames.add(searchResult.getName());
        }
        return productNames;
    }
}
