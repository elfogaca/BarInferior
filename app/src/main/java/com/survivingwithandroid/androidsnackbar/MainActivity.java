package com.survivingwithandroid.androidsnackbar;

/*
 * Copyright (C) 2016, Francesco Azzola
 *
 *(http://www.survivingwithandroid.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_4);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        setContentView(R.layout.activity_main);
        View v = (View) findViewById(R.id.main);

        final TextView tv = (TextView) findViewById(R.id.data);

        Button b = (Button) findViewById(R.id.btn);

        //Snackbar.make(v, "Welcome to SwA", Snackbar.).show();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Activate snack bar


                Snackbar bar = Snackbar.make(v, "Bem Vindo ao Sistema ELFO", Snackbar.LENGTH_LONG)
                         .setAction("Dispensado", new View.OnClickListener() {
                             @Override
                             public void onClick(View v) {
                                tv.setText("Você pressionou Dispensar!!");
                             }
                         });

                bar.setActionTextColor(Color.RED);

                TextView tv = (TextView) bar.getView().findViewById(android.support.design.R.id.snackbar_text);
                tv.setTextColor(Color.CYAN);
                bar.show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            TextView content = (TextView) getLayoutInflater().inflate(R.layout.about_view, null);
            content.setMovementMethod(LinkMovementMethod.getInstance());
            content.setText(Html.fromHtml(getString(R.string.about_body)));
            new AlertDialog.Builder(this)
                    .setTitle(R.string.about)
                    .setView(content)
                    .setInverseBackgroundForced(true)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).create().show();
        }
        return super.onOptionsItemSelected(item);
    }
}
