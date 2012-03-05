/*
 * Copyright 2001-2011 Texas Instruments, Inc. - http://www.ti.com/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* Bluetooth SCO App: The app establishes a SCO connection for non-voice call
 *  use case, for eg. Music streaming(mono) on BT SCO link. Also, BT SCO voice record
 *  can also be tested from sound recorder after running this app.
 *
 *  Version: 2.0
 */

package com.ti.bluetoothSCOapp;

import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


public class connect extends Activity {
    private static final String TAG = "BluetoothSCO";
    private static final boolean DEBUG = true;
    private AudioManager mAudioManager = null;
    private Context mContext = null;
    /* Broadcast receiver for the SCO State broadcast intent.*/
        private final BroadcastReceiver mSCOHeadsetAudioState = new BroadcastReceiver() {

        public void onReceive(Context context, Intent intent) {
        //if(DEBUG)
            // Log.e(TAG, " mSCOHeadsetAudioState--->onReceive");

        int state = intent.getIntExtra(AudioManager.EXTRA_SCO_AUDIO_STATE, -1);

        if (state == AudioManager.SCO_AUDIO_STATE_CONNECTED) {
            DisplayToast("BT SCO Music is now enabled. Play song in Media Player");
        } else if (state == AudioManager.SCO_AUDIO_STATE_DISCONNECTED) {
            DisplayToast("BT SCO Music is now disabled");
        }
       }
  };

    // Local Bluetooth adapter
    private BluetoothAdapter mBluetoothAdapter = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Get local Bluetooth adapter
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // If the adapter is null, then Bluetooth is not supported
        if (mBluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth is not available", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        mContext = this;
        IntentFilter newintent = new IntentFilter();
        newintent.addAction(AudioManager.ACTION_SCO_AUDIO_STATE_CHANGED);
        mContext.registerReceiver(mSCOHeadsetAudioState, newintent);

        // Check whether BT is enabled
        if (!mBluetoothAdapter.isEnabled()) {
             Toast.makeText(this, "Bluetooth is not enabled", Toast.LENGTH_LONG).show();
             finish();
             return;
        }

        // get the Audio Service context
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (mAudioManager == null){
                Log.e(TAG, "mAudiomanager is null");
                finish();
                return;
        }
        // Android 2.2 onwards supports BT SCO for non-voice call use case
        // Check the Android version whether it supports or not.
        if(!mAudioManager.isBluetoothScoAvailableOffCall()) {
             Toast.makeText(this, "Platform does not support use of SCO for off call", Toast.LENGTH_LONG).show();
             finish();
             return;
        }

        // Check list of bonded devices
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        // If there are paired devices
        if (pairedDevices.size() > 0) {
           // Loop through paired devices
           for (BluetoothDevice device : pairedDevices) {
             Log.e(TAG, "BT Device :"+device.getName()+ " , BD_ADDR:" + device.getAddress());
           }
           // To do:
           // Need to check from the paired devices which supports BT HF profile
           // and take action based on that.
         } else {
           Toast.makeText(this, "No Paired Headset, Pair and connect to phone audio", Toast.LENGTH_LONG).show();
           finish();
           return;
        }

        // Check whether BT A2DP (media) is connected
        // If yes, ask user to disconnect
        if(mAudioManager.isBluetoothA2dpOn ()){
          Toast.makeText(this, "Disconnect A2DP (media audio) to headset from Bluetooth Settings", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        // Check whether it is connected to phone audio
        // TO DO:
        Toast.makeText(this, "Make sure:Device is connected to Headset & Connected to Phone Audio only!", Toast.LENGTH_LONG).show();

        // Ok everything seems to be fine
        // start now
        CheckBox checkBox = (CheckBox) findViewById(R.id.CheckBox01);

        checkBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox)v).isChecked()) {
                      if(DEBUG)
                        Log.e(TAG, "BTSCOApp: Checkbox Checked ");
                          mAudioManager.setBluetoothScoOn(true);
                          mAudioManager.startBluetoothSco();
                        // OMAP4 has dedicated support for MM playback on BT SCO
                        // so just establish SCO connection and play music in media player
                        // OMAP4 ABE takes care of 44.1 to 8k conversion.

                        // For other platform or omap3, the  user
                        // needs to play mono 8k sample using aplay on shell
                } else {
                        if(DEBUG)
                           Log.e(TAG, "BTSCOApp Checkbox Unchecked ");
                        mAudioManager.setBluetoothScoOn(false);
                        mAudioManager.stopBluetoothSco();
                }
            }
        });
    }

    private void DisplayToast(String msg)
    {
         Toast.makeText(getBaseContext(), msg,
                 Toast.LENGTH_SHORT).show();
    }

}
