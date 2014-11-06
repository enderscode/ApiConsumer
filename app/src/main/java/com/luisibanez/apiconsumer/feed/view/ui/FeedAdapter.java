package com.luisibanez.apiconsumer.feed.view.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.luisibanez.apiconsumer.R;
import com.luisibanez.apiconsumer.feed.view.viewmodel.UserViewModel;
import com.luisibanez.apiconsumer.uibase.transformation.TransformationBuilder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FeedAdapter extends BaseAdapter {
    private final Context context;
    private final Picasso picasso;
    private final TransformationBuilder transformationBuilder;
    private List<UserViewModel> feed;

    public FeedAdapter(Context context, List<UserViewModel> feed, Picasso picasso,
                       TransformationBuilder transformationBuilder) {
        this.context = context;
        this.feed = feed;
        this.picasso = picasso;
        this.transformationBuilder = transformationBuilder;
    }

    @Override
    public int getCount() {
        return feed.size();
    }

    @Override
    public Object getItem(int i) {
        return feed.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.user_item, viewGroup, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.user_name);
        ImageView ivAvatar = (ImageView) convertView.findViewById(R.id.user_avatar);

        UserViewModel userViewModel = feed.get(position);

        name.setText(userViewModel.getName());

        if (!userViewModel.getUrlAvatar().isEmpty()) {
            picasso.load(userViewModel.getUrlAvatar())
                    .centerCrop()
                    .fit()
                    .transform(transformationBuilder.createAvatarTransformation())
                    .into(ivAvatar);
        }

        return convertView;
    }
}
