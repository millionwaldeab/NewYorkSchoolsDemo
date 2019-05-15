package com.example.a20190514_millionwaldeab_nycschools;

import android.os.Build;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowDialog;

//@Config(manifest=Config.NONE, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private MainActivity mMainActivity;
    private ActivityController<MainActivity> mController;
    @Mock
    Schools mSchools;

    @Before
    public void setUp(){
        mMainActivity = Robolectric.buildActivity(MainActivity.class).create().pause().stop().resume().destroy().get();
        mController = Robolectric.buildActivity(MainActivity.class);
    }

    @After
    public void tearDown(){
        //mMainActivity = null;
    }

    @Test
    public void testDialogDisplayed(){
        /*Precondition*/
        ShadowDialog shadowDialog = new ShadowDialog();

        /*Method under test*/
        mMainActivity.addToDialog(mSchools);

        /*test*/
        Assert.assertNotNull(shadowDialog);
        shadowDialog.show();
    }

    @Test
    public void testPopulateRecyclerView(){
        /*Precondition*/
        int schools = 5;

        /*Method under test*/
        mMainActivity.populateRecyclerView();

        /*test*/
        Assert.assertNotNull(mMainActivity.mSchoolsList);
        Assert.assertEquals(schools, mMainActivity.mSchoolsList.size());
    }
}
