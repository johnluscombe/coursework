package com.example.johnluscombe.giftletwithfragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class GiftFragment extends ListFragment
                          implements NewGiftDialogFragment.NewGiftDialogListener {

    private Gift[] mGifts;
    private GiftAdapter mGiftAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.gift_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mGifts = Gift.all(getContext());

        mGiftAdapter = new GiftAdapter(
                getActivity(), R.layout.list_view_items, mGifts
        );

        setListAdapter(mGiftAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        setActionBar(getActivity());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        showDetails();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        menu.add(0, 1, 0, "Add Gift")
                .setIcon(R.drawable.plus)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                NewGiftDialogFragment dialog = new NewGiftDialogFragment();
                dialog.setTargetFragment(this, 0);
                dialog.show(getFragmentManager(), "New Gift");
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("Recipients");
    }

    private void setActionBar(Activity activity) {
        ActionBar actionBar = ((AppCompatActivity)activity).getSupportActionBar();
        actionBar.setTitle("Gifts");
    }

    private boolean isDualPane() {
        View horizontalRightFrame = getActivity().findViewById(R.id.horizontal_right_pane);
        return horizontalRightFrame != null && horizontalRightFrame.getVisibility() == View.VISIBLE;
    }

    private void showDetails() {
        GiftFragment giftFragment = new GiftFragment();
        DetailsFragment detailsFragment = new DetailsFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        if (isDualPane()) {
            fragmentTransaction.remove(this);
            fragmentTransaction.replace(R.id.vertical_and_horizontal_left_pane, giftFragment);
            fragmentTransaction.replace(R.id.horizontal_right_pane, detailsFragment);
        } else {
            fragmentTransaction.replace(R.id.vertical_and_horizontal_left_pane, detailsFragment);
        }

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        mGifts = Gift.all(getContext());
        mGiftAdapter.update();
    }
}
