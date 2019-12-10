package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.test.espresso.IdlingResource;

import com.baxter.jokeview.JokerFragment;
import com.udacity.gradle.builditbigger.services.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.services.OnEventListener;
import com.udacity.gradle.builditbigger.utils.SimpleIdlingResource;

import static com.baxter.jokeview.JokerFragment.JOKE_ID;


public class MainActivity extends AppCompatActivity {

    // The Idling Resource which will be null in production.
    @Nullable
    private SimpleIdlingResource mIdlingResource;

    /**
     * Only called from test, creates and returns a new {@link IdlingResource}.
     */
    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    // Implement reviewer suggestion from this link https://gist.github.com/cesarferreira/ef70baa8d64f9753b4da
    // Interface handle the callbacks
    public void tellJoke(View view) {
        new EndpointsAsyncTask(
            new OnEventListener<String>() {
                @Override
                public void onPreExecution() {
                    if (mIdlingResource != null) mIdlingResource.setIdleState(false);
                }

                @Override
                public void onPostExecution(String result) {
                    Bundle bundle = new Bundle();
                    bundle.putString(JOKE_ID, result);
                    JokerFragment jokerFragment = new JokerFragment();
                    jokerFragment.setArguments(bundle);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, jokerFragment)
                            .commitAllowingStateLoss();

                    if (mIdlingResource != null) mIdlingResource.setIdleState(true);
                }
            }
        ).execute();
    }

}
