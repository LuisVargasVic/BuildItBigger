package com.udacity.gradle.builditbigger;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingResource;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anyOf;

// Annotation to specify AndroidJUnitRunner class as the default test runner
@RunWith(AndroidJUnit4.class)
public class NonEmptyTest {

    private static final String TAG = NonEmptyTest.class.getSimpleName();
    private IdlingResource mIdlingResource;

    // Rule that provides functional testing of a single activity
    @Rule
    public final ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    // Registers any resource that needs to be synchronized with Espresso before the test is run.
    @Before
    public void registerIdlingResource() {
        mIdlingResource = mActivityTestRule.getActivity().getIdlingResource();
        // To prove that the test fails, omit this call:
        Espresso.registerIdlingResources(mIdlingResource);
        onView(withId(R.id.tell)).perform(click());
    }

    // Test Async task that retrieves a non-empty string
    @Test
    public void verifyJoke() {
        onView(withId(R.id.joke)).check(matches(
                anyOf(
                        withText("Why is Cinderella bad at soccer?\n" + "Because she’s always running away from the ball!"),
                        withText("Why did the picture go to prison?\n" + "Because it was framed!"),
                        withText("Where do cows go on Friday nights?\n" + "They go to the moo-vies!"),
                        withText("What did one eye say to the other eye?\n" + "Between us, something smells!"),
                        withText("Why do bicycles fall over?\n" + "Because they’re two-tired!"),
                        withText("Knock, knock!\n" + "Who’s there?\n" + "Hatch.\n" + "Hatch who?\n" + "Bless you!"),
                        withText("What does a rain cloud wear under her dress?\n" + "Thunderwear!")
                )
        ));

    }

    // Remember to unregister resources when not needed to avoid malfunction.
    @After
    public void unregisterIdlingResource() {
        if (mIdlingResource != null) {
            Espresso.unregisterIdlingResources(mIdlingResource);
        }
    }
}
