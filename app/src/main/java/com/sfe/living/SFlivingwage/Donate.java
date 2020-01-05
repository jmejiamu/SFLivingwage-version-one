package com.sfe.living.SFlivingwage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Donate extends AppCompatActivity{
    WebView webView;
//    AppCompatActivity YouTubeBaseActivity
//    private static final String TAG = "Donate";
//
//    YouTubePlayerView youTubePlayerView;
//    Button button;
//    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
//- ALL THE COMMENTED CODE IS FOR
//        Log.d(TAG,"onCreate:Starting");
//            button = (Button)findViewById(R.id.button);
//            youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlayer);
//
//            onInitializedListener = new YouTubePlayer.OnInitializedListener() {
//                @Override
//                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                    Log.d(TAG,"onClick: Done initializing");
//
//                    youTubePlayer.loadVideo("cGSPzVqd4AU");
//                    // - make a get request
//                }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//                Log.d(TAG,"onClick: fail to initializing");
//            }
//        };
//
//        button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG,"onClick: initializing YouTube Player");
//               youTubePlayerView.initialize(YoutubeConfig.getApiApiKey(),onInitializedListener);
////               Log.d(TAG,"onClick: Done initializing");
//            }
//        });

        webView = (WebView) findViewById(R.id.webViewDonation);

        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/donationMoney.html");
    }

    }