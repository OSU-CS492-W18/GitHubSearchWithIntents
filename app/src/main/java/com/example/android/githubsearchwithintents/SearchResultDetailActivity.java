package com.example.android.githubsearchwithintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SearchResultDetailActivity extends AppCompatActivity {

    private TextView mTVSearchResultName;
    private TextView mTVSearchResultStars;
    private TextView mTVSearchResultDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result_detail);

        mTVSearchResultName = (TextView)findViewById(R.id.tv_search_result_name);
        mTVSearchResultStars = (TextView)findViewById(R.id.tv_search_result_stars);
        mTVSearchResultDescription = (TextView)findViewById(R.id.tv_search_result_description);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(GitHubUtils.EXTRA_SEARCH_RESULT)) {
            GitHubUtils.SearchResult searchResult = (GitHubUtils.SearchResult) intent.getSerializableExtra(GitHubUtils.EXTRA_SEARCH_RESULT);
            mTVSearchResultName.setText(searchResult.fullName);
            mTVSearchResultStars.setText(String.valueOf(searchResult.stars));
            mTVSearchResultDescription.setText(searchResult.description);
        }
    }
}
