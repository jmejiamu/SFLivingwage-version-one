package com.sfe.living.SFlivingwage;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "";
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    
    private SwipeRefreshLayout mySwipeRefreshLayout;

    // - Home page webView

    WebView webView;

    // - Global variables - Video Variables

//    Button click;
//    VideoView videoView;
//    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // - Button to play video
//        click =(Button)findViewById(R.id.buttonPlay);
//        videoView = (VideoView)findViewById(R.id.videoView);
//        mediaController = new MediaController(this);
// Menu
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //web view
        webView = (WebView)findViewById(R.id.webViewHomePage);

        WebSettings ws  = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/home.html");

        /*
         * Sets up a SwipeRefreshLayout.OnRefreshListener that is invoked when the user
         * performs a swipe-to-refresh gesture.
         */

        mySwipeRefreshLayout = (SwipeRefreshLayout)this.findViewById(R.id.swiperefresh);

        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Log.i(LOG_TAG, "onRefresh called from SwipeRefreshLayout");

                        // This method performs the actual data-refresh operation.
                        // The method calls setRefreshing(false) when it's finished.
                        webView.reload();
                        mySwipeRefreshLayout.setRefreshing(false);

                    }
                }
        );
    }
    @Override
    public void onPause(){
        super.onPause();
        webView.onPause();
    }
    @Override
    public void onResume(){
        super.onResume();
        webView.onResume();
    }
    // - Play local video
//    public  void videoPlay(View v){
//        String videoPath = "android.resource://com.example.joch_.sanfranciscolivingthewage/"+R.raw.videoplayback;
//        Uri uri = Uri.parse(videoPath);
//        videoView.setVideoURI(uri);
//
//        videoView.setMediaController(mediaController);
//        mediaController.setAnchorView(videoView);
//        videoView.start();
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // -  add functionality to the menu spefically to the about section
    public void aboutInit(MenuItem menuItem){
        Intent aboutUsIntent = new Intent(MainActivity.this, about.class);
        startActivity(aboutUsIntent);
    }

    public void donateInit(MenuItem menuItem){
        Intent donateIntent =  new Intent(MainActivity.this, Donate.class);
        startActivity(donateIntent);
    }
    public void calendarInit(MenuItem menuItem){
        Intent calendarIntent  = new Intent(MainActivity.this, Calendar.class);
        startActivity(calendarIntent);
    }
    public void homeInit(MenuItem menuItem){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }


}
