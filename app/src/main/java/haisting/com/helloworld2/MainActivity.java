package haisting.com.helloworld2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText mEditText;
    private Button mNextActivityButton;
    private Button mButton;
    private TextView mTextView;

    // We use this key when we are sending stuff from one activity to another
    // (think MAP)

    public static final String KEY = "disBeDaKeyMan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // You will see code like this in every single onCreate of every single activity
        // I call it view hookin'
        // Remember, the R.id.<whatever> comes from our xml id attributes.
        mButton = (Button) findViewById(R.id.button);
        mTextView = (TextView) findViewById(R.id.textView);
        mNextActivityButton = (Button) findViewById(R.id.next_activity_button);
        mEditText = (EditText) findViewById(R.id.edit_text);

        // Here we set click listeners so stuff can happen when we click our buttons
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mTextView.getText() + "!");
            }
        });

        mNextActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intents are used to go to and from different activities.
                // Whenever you construct an intent, you give it two parameters-
                // Where you ARE, and where you are GOING
                //   (MainActivity.this)           (SecondActivity.class)
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                // What if you need to send info to the next activity?
                // Use a bundle. A bundle is basically a map.
                // You can but keys and values into a bundle and attach the bundle to an intent.
                // Once you are at your receiving activity, you can retrieve the bundle.
                // We want the string from the edit text in our next activity.
                intent.putExtra(KEY,mEditText.getText().toString());
                // We've got the intent all packaged up, now lets send it to Android and let the OS do the work.
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
