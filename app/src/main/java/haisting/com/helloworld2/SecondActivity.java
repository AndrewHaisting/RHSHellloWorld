package haisting.com.helloworld2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


/*
    HOW I MADE THIS NEW ACTIVITY:
    1) RIGHT CLICK THE JAVA FOLDER
    2) NEW > ACTIVITY > BLANK ACTIVITY
    3) CALL IT WHATEVER YOU WANT
    4) PROFIT?
 */
public class SecondActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //View hookin'
        mTextView = (TextView) findViewById(R.id.second_text_view);
        // Remember when we gave our intent some extras? Lets get them back.
        Bundle bundle = getIntent().getExtras();
        mTextView.setText(bundle.getString(MainActivity.KEY));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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
