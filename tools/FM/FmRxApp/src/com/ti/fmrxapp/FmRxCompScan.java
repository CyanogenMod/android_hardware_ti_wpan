/*
 *
 * Copyright 2001-2012 Texas Instruments, Inc. - http://www.ti.com/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ti.fmrxapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.ti.fm.FmRadio;
import com.ti.fm.FmRadioIntent;
import com.ti.fm.IFmConstants;
import android.app.AlertDialog;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.SQLException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.view.Window;
import android.media.AudioManager;
import android.widget.Toast;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
public class FmRxCompScan extends Activity {
    public static final String TAG = "FmRxStopCompScan";
    /** Called when the activity is first created. */
    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Set the layout for this activity
            setContentView(R.layout.fmrxcompscan);

            Button press = (Button)findViewById(R.id.press);

            press.setOnClickListener(new Button.OnClickListener(){
                public void onClick(View v) {
                    Log.i(TAG, "Stop Scan");
                    finish();
                }
            });
        }
}
