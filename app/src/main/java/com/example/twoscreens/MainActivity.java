 package com.example.twoscreens;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import static com.example.twoscreens.R.*;

 public class MainActivity extends AppCompatActivity {
    private int x;
    private int[] colors = {Color.BLUE, Color.GRAY, Color.CYAN, Color.BLACK,Color.RED, Color.MAGENTA, Color.GREEN};
    int loops;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        x = 0;
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                startOtherActivity();
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startOtherActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }


    public void changeColor(View view) {
        loops = 10;
        changeColorHelper(30, view);
        Log.d("MainActivity", "X: " + String.valueOf(x));
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                switch(colors[(x-1)%7]){
                    case Color.BLUE:
                        Intent intent = new Intent(getApplicationContext(), blue.class);
                        startActivity(intent);
                        break;
                    case Color.GRAY:
                        intent = new Intent(getApplicationContext(), gray.class);
                        startActivity(intent);
                        break;
                    case Color.CYAN:
                        intent = new Intent(getApplicationContext(), cyan.class);
                        startActivity(intent);
                        break;
                    case Color.BLACK:
                        intent = new Intent(getApplicationContext(), black.class);
                        startActivity(intent);
                        break;
                    case Color.RED:
                        intent = new Intent(getApplicationContext(), red.class);
                        startActivity(intent);
                        break;
                    case Color.MAGENTA:
                        intent = new Intent(getApplicationContext(), magenta.class);
                        startActivity(intent);
                        break;
                    case Color.GREEN:
                        intent = new Intent(getApplicationContext(), green.class);
                        startActivity(intent);
                        break;
                    default:
                        Log.d("MainActivity", "COLOR: " + String.valueOf((x-1)%7));
                }
                }
            }, 1000);

    }

    private void changeColorHelper(final int time_ms, View view){
        Button button = (Button) findViewById(R.id.button);
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            public void run() {
//                button.setBackgroundColor(colors[(x++) % 7]);
                View root = (View) findViewById(id.coordinatorLayout);
                root.setBackgroundColor(colors[(x++)%7]);
                if(loops-- > 0) {
                    Log.d("MainActivity", "LOOPS: " + String.valueOf(loops));
                    changeColorHelper((int) (time_ms * 1.07), view);
                }
            }
        }, time_ms);
    }
}