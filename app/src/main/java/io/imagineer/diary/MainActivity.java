package io.imagineer.diary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    // private TextView mTextView;
    private EditText mTitleEditText;
    private EditText mContentEditText;
    private Button mButton;
    private String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mTextView = (TextView) findViewById(R.id.textView);
        mTitleEditText = (EditText) findViewById(R.id.titleEditText);
        mContentEditText = (EditText) findViewById(R.id.contentEditText);
        mButton = (Button) findViewById(R.id.button);

        View.OnClickListener firstOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Realm.init(getApplicationContext());
                Realm realm = Realm.getDefaultInstance();

                realm.beginTransaction();
                final Article article = realm.where(Article.class).equalTo("title", mTitle).findFirst();
                article.deleteFromRealm();
                realm.commitTransaction();

                finish();

                // Article Addition
//                String titleText = mTitleEditText.getText().toString();
//                String contentText = mContentEditText.getText().toString();
//                // mTextView.setText(text);
//                mTitleEditText.setText("");
//                mContentEditText.setText("");
//
//                Realm.init(getApplicationContext());
//                Realm realm = Realm.getDefaultInstance();
//
//                // transaction
//                realm.beginTransaction();
//                Article article = realm.createObject(Article.class);
//                article.setTitle(titleText);
//                article.setContent(contentText);
//                realm.commitTransaction();
            }
        };

        mButton.setOnClickListener(firstOnClickListener);

        // TODO: fix below
        if (savedInstanceState == null) {
//            String text = getIntent().getStringExtra("item");
//            mTextView.setText(text);
            String title = getIntent().getStringExtra("title");
            String content = getIntent().getStringExtra("content");
            mTitle = title;
            mTitleEditText.setText(title);
            mContentEditText.setText(content);
        }
    }
}
