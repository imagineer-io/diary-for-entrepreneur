package io.imagineer.diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // final String[] sampleArray = {"hello", "this", "is", "test"};
        Article[] articles = {
                new Article("title1", "content1"),
                new Article("title2", "content2"),
                new Article("title3", "content3"),
        };

        mListView = (ListView) findViewById(R.id.listView);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, sampleArray);
        CustomAdapter adapter = new CustomAdapter(
                this,
                R.layout.list_row,
                new ArrayList<Article>(Arrays.asList(articles)));

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                // TODO: fix intent extra
                // intent.putExtra("item", sampleArray[position]);
                startActivity(intent);
            }
        });
    }
}
