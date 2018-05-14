package com.example.johnluscombe.giftletwithfragments;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class RecipientFragment extends ListFragment
                               implements NewRecipientDialogFragment.NewRecipientDialogListener,
                                          SearchView.OnQueryTextListener {

    private Recipient[] mRecipients;
    private RecipientAdapter mRecipientAdapter;
    private String mSearch;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setActionBar(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recipient_layout, container, false);
    }

    @Override
    public void onStop() {
        super.onStop();

        if (mSearch != null && !mSearch.equals("")) {
            SearchRecentSuggestions suggestions = new SearchRecentSuggestions(getContext(),
                    RecentRecipientsSuggestionsProvider.AUTHORITY,
                    RecentRecipientsSuggestionsProvider.MODE);

            suggestions.saveRecentQuery(mSearch, null);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecipients = Recipient.all(getContext());

        mRecipientAdapter = new RecipientAdapter(
                getActivity(), R.layout.list_view_items, mRecipients
        );

        setListAdapter(mRecipientAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        showGifts();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu, menu);
        SearchManager searchManager = (SearchManager)getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView)menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_recipient:
                NewRecipientDialogFragment dialog = new NewRecipientDialogFragment();
                dialog.setTargetFragment(this, 0);
                dialog.show(getFragmentManager(), "New Recipient");
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mRecipientAdapter.getFilter().filter(newText);
        mSearch = newText;

        return true;
    }

    private void setActionBar(Activity activity) {
        ActionBar actionBar = ((AppCompatActivity)activity).getSupportActionBar();
        actionBar.setTitle("Recipients");
    }

    private boolean isDualPane() {
        View horizontalRightFrame = getActivity().findViewById(R.id.horizontal_right_pane);
        return horizontalRightFrame != null && horizontalRightFrame.getVisibility() == View.VISIBLE;
    }

    private void showGifts() {
        GiftFragment giftFragment = new GiftFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        if (isDualPane()) {
            fragmentTransaction.replace(R.id.horizontal_right_pane, giftFragment);
        } else {
            fragmentTransaction.replace(R.id.vertical_and_horizontal_left_pane, giftFragment);
        }

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        mRecipients = Recipient.all(getContext());
        mRecipientAdapter.update();
    }
}
