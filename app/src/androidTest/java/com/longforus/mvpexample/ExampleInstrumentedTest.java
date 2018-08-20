package com.longforus.mvpexample;

import android.content.Context;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.longforus.mvpexample.view.LoginActivity;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private ActivityTestRule<LoginActivity> mLoginActivityActivityTestRule= new ActivityTestRule<>(LoginActivity.class);



    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.longforus.mvpexample",appContext.getPackageName());
    }

    @Test
    public void testShow() {
        mLoginActivityActivityTestRule.launchActivity(null);
        onView(withId(R.id.tv)).perform(click());
        SystemClock.sleep(2000);
    }


    @After
    public void release() {
        mLoginActivityActivityTestRule = null;
    }

}
