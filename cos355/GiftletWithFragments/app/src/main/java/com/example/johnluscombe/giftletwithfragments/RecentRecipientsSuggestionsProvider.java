package com.example.johnluscombe.giftletwithfragments;

import android.content.SearchRecentSuggestionsProvider;

public class RecentRecipientsSuggestionsProvider extends SearchRecentSuggestionsProvider {

    public static final String AUTHORITY = RecentRecipientsSuggestionsProvider.class.getName();
    public static final int MODE = DATABASE_MODE_QUERIES;

    public RecentRecipientsSuggestionsProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }
}
