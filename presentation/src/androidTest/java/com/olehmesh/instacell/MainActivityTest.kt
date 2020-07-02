package com.olehmesh.instacell

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.olehmesh.instacell.MyViewAction.clickChildViewWithId
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
Sorry, I have not practiced testing before, only during this test task and reading theory
 */

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    @Rule
    @JvmField
    // "ActivityScenario.launch" is not working, i used deprecated class
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun clickRecyclerIcons() {

        onView(withId(R.id.recyclerView)).perform(
            scrollToPosition<RecyclerView.ViewHolder>(5),
            actionOnItemAtPosition<RecyclerView.ViewHolder>(
                5,
                clickChildViewWithId(R.id.imgFavorite)
            )
        )

            .check(matches(isDisplayed()))
        onView(withId(R.id.recyclerView)).perform(
            scrollToPosition<RecyclerView.ViewHolder>(10),
            actionOnItemAtPosition<RecyclerView.ViewHolder>(
                10,
                clickChildViewWithId(R.id.imgComment)
            )
        )

            .check(matches(isDisplayed()))


        onView(withId(R.id.recyclerView)).perform(
            scrollToPosition<RecyclerView.ViewHolder>(16),
            actionOnItemAtPosition<RecyclerView.ViewHolder>(
                16,
                clickChildViewWithId(R.id.imgBookmark)
            )
        )

            .check(matches(isDisplayed()))

        onView(withId(R.id.recyclerView)).perform(
            scrollToPosition<RecyclerView.ViewHolder>(25),
            actionOnItemAtPosition<RecyclerView.ViewHolder>(25, clickChildViewWithId(R.id.imgSend))
        )

            .check(matches(isDisplayed()))


    }

}

