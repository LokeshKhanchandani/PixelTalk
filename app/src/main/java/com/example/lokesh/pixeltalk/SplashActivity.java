package com.example.lokesh.pixeltalk;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

import java.util.Locale;

public class SplashActivity extends AwesomeSplash {
    TextToSpeech tts;
    String t1="";
    LinearLayout view ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextToSpeech.OnInitListener listener =
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(final int status) {
                        if (status == TextToSpeech.SUCCESS)
                        {
                            Log.d("OnInitListener", "Text to speech engine started successfully.");
                            tts.setLanguage(Locale.US);
                        }
                        else {
                            Log.d("OnInitListener", "Error starting the text to speech engine.");
                        }
                    }
                };
        Log.e("ff","ff");
        tts = new TextToSpeech(this.getApplicationContext(), listener);

    }

    @Override
    public void initSplash(ConfigSplash configSplash) {
        setContentView(R.layout.activity_splash);
        /* you don't have to override every property */
        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.lightIndigio); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(1200); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash.setLogoSplash(R.drawable.ic_launcher3); //or any other drawable
        configSplash.setAnimLogoSplashDuration(1000); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)

        configSplash.setTitleSplash("  ");
        configSplash.setTitleTextColor(R.color.darkIndigo);
        configSplash.setTitleTextSize(50f); //float value
        configSplash.setAnimTitleDuration(750);
        configSplash.setAnimTitleTechnique(Techniques.ZoomIn);
        //configSplash.setTitleFont("fonts/myfont.ttf"); //provide string to your font located in assets/fonts/
    }

    @Override
    public void animationsFinished() {
        finish();
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
}
