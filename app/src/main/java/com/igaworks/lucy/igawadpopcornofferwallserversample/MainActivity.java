package com.igaworks.lucy.igawadpopcornofferwallserversample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import com.igaworks.IgawCommon;
import com.igaworks.adpopcorn.IgawAdpopcorn;
import com.igaworks.adpopcorn.interfaces.IAdPOPcornEventListener;


public class MainActivity extends ActionBarActivity {


    // Igaworks Common
    String tag = "Igaw";

    // Igaworks Adpopcorn Offerwall
    String usn;
    String encryptUsn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Your Code
        TelephonyManager manager =  (TelephonyManager)getSystemService(MainActivity.this.TELEPHONY_SERVICE);
        usn = manager.getDeviceId().toString();
        usn = usn+"a";
        encryptUsn = Base64.encodeToString(usn.getBytes(), 0);


        // Igaworks Common
        IgawCommon.startApplication(MainActivity.this);
        Log.d(tag, "startApplication ::: MainActivity");

        // Igaworks Adpopcorn Offerwall
        IgawCommon.setUserId(encryptUsn);
        Log.d(tag, "setUserId ::: " + encryptUsn);

        // Igaworks Adpopcorn Offerwall Optional
        IgawAdpopcorn.setEventListener(MainActivity.this, new IAdPOPcornEventListener() {
            @Override
            public void OnClosedOfferWallPage() {
                Log.d(tag, "setEventListener ::: OnClosedOfferWallPage");

                /*
                 * Your Code
                 */

            }
        });

        /*
         * Your Code
         */
    }

      /*
       * Your Code
       */

    // Your Code
    public void openOfferWall(View view){
        Log.d(tag, "openOfferWall ::: Button Click");

        // Igaworks Adpopcorn Offerwall
        IgawAdpopcorn.openOfferWall(MainActivity.this);
        Log.d(tag, "openOfferWall");

        // Igaworks Adpopcorn Offerwall Optional
        IgawAdpopcorn.setSensorLandscapeEnable(MainActivity.this, true);
        Log.d(tag, "setSensorLandscapeEnable");

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Igaworks Common
        IgawCommon.startSession(MainActivity.this);
        Log.d(tag, "startSession ::: MainActivity" );

        /*
         * Your Code
         */
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Igaworks Common
        IgawCommon.endSession();
        Log.d(tag, "endSession ::: MainActivity");

        /*
         * Your Code
         */
    }

}

