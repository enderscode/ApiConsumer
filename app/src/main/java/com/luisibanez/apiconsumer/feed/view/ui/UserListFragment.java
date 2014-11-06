package com.luisibanez.apiconsumer.feed.view.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.luisibanez.apiconsumer.R;
import com.luisibanez.apiconsumer.feed.view.provider.FeedProvider;
import com.luisibanez.apiconsumer.feed.view.ui.callback.RefreshFeedCallback;
import com.luisibanez.apiconsumer.feed.view.viewmodel.FeedViewModel;
import com.luisibanez.apiconsumer.feed.view.viewmodel.UserViewModel;
import com.luisibanez.apiconsumer.uibase.base.BaseFragment;
import com.luisibanez.apiconsumer.uibase.transformation.TransformationBuilder;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

/**
 * A placeholder fragment containing a simple view.
 */
public class UserListFragment extends BaseFragment {


    @Inject
    FeedProvider feedProvider;

    @Inject
    Picasso picasso;
    @Inject
    TransformationBuilder transformationBuilder;
    ListView listviewFeed;
    private FeedViewModel feed;
    private FeedAdapter feedAdapter;


    public UserListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user, container, false);

        mapGUI(rootView);

        hookActionListeners();

        return rootView;
    }

    private void hookActionListeners() {
        listviewFeed.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                refreshData();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        feed = feedProvider.getFeed();

        refreshData();

        feed.populateFeed(populateFeedCallback);


    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void mapGUI(View rootView) {
        listviewFeed = (ListView) rootView.findViewById(R.id.lv_feed);

    }

    private void refreshData() {
        List<UserViewModel> users = feed.getUsers();

        if (feedAdapter == null) {
            feedAdapter = new FeedAdapter(getActivity(), users, picasso, transformationBuilder);
            listviewFeed.setAdapter(feedAdapter);
        } else {
            feedAdapter.notifyDataSetChanged();
        }
    }

    private RefreshFeedCallback populateFeedCallback = new RefreshFeedCallback() {
        @Override
        public void refreshPopulated() {
            refreshData();
        }
    };


}
