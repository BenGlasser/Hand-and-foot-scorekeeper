package com.benglasser.handfootscorekeeper;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;


public class Start extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        registerListener((EditText)findViewById(R.id.inputAcesTwosPoints));
        registerListener((EditText)findViewById(R.id.inputBlackThreePoints));
        registerListener((EditText)findViewById(R.id.inputCleanPoints));
        registerListener((EditText)findViewById(R.id.inputDirtyPoints));
        registerListener((EditText)findViewById(R.id.inputGoingOutPoints));
        registerListener((EditText)findViewById(R.id.inputHighPoints));
        registerListener((EditText)findViewById(R.id.inputJokerPoints));
        registerListener((EditText)findViewById(R.id.inputLowPoints));
        registerListener((EditText)findViewById(R.id.inputMinusPoints));
        registerListener((EditText)findViewById(R.id.inputPlusPoints));
        registerListener((EditText)findViewById(R.id.inputRedThreePoints));
        registerListener((EditText)findViewById(R.id.inputWildPoints));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_reset) {
            reset();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void calculateScore(){
        try {
            ScoreKeeper scoreKeeper = new ScoreKeeper()
                    .addBlackThrees(getInt((TextView) findViewById(R.id.inputBlackThreePoints)))
                    .addAcesAndTwos(getInt((TextView) findViewById(R.id.inputAcesTwosPoints)))
                    .addCleanBooks(getInt((TextView) findViewById(R.id.inputCleanPoints)))
                    .addDirtyBooks(getInt((TextView) findViewById(R.id.inputDirtyPoints)))
                    .addGoingOut(getInt((TextView) findViewById(R.id.inputGoingOutPoints)))
                    .addHighPoints(getInt((TextView) findViewById(R.id.inputHighPoints)))
                    .addJoker(getInt((TextView) findViewById(R.id.inputJokerPoints)))
                    .addLowPoints(getInt((TextView) findViewById(R.id.inputLowPoints)))
                    .addPoints(getInt((TextView) findViewById(R.id.inputPlusPoints)))
                    .addRedThrees(getInt((TextView) findViewById(R.id.inputRedThreePoints)))
                    .addWildBook(getInt((TextView) findViewById(R.id.inputWildPoints)))
                    .subtractPoints(getInt((TextView) findViewById(R.id.inputMinusPoints)));
            TextView t = new TextView(this);
            t=(TextView) findViewById(R.id.outputScoreLabel);
            t.setText(Integer.toString(scoreKeeper.getScore()));
        }
        catch (NumberFormatException e) {
            System.err.println("could not add stuff");
        }
    }

    public void reset(){
        TextView t = new TextView(this);
        t=(TextView) findViewById(R.id.inputAcesTwosPoints);
        t.setText("0");
        t = new TextView(this);
        t=(TextView) findViewById(R.id.inputBlackThreePoints);
        t.setText("0");
        t = new TextView(this);
        t=(TextView) findViewById(R.id.inputCleanPoints);
        t.setText("0");
        t = new TextView(this);
        t=(TextView) findViewById(R.id.inputDirtyPoints);
        t.setText("0");
        t = new TextView(this);
        t=(TextView) findViewById(R.id.inputGoingOutPoints);
        t.setText("0");
        t = new TextView(this);
        t=(TextView) findViewById(R.id.inputHighPoints);
        t.setText("0");
        t = new TextView(this);
        t=(TextView) findViewById(R.id.inputJokerPoints);
        t.setText("0");
        t = new TextView(this);
        t=(TextView) findViewById(R.id.inputLowPoints);
        t.setText("0");
        t = new TextView(this);
        t=(TextView) findViewById(R.id.inputMinusPoints);
        t.setText("0");
        t = new TextView(this);
        t=(TextView) findViewById(R.id.inputPlusPoints);
        t.setText("0");
        t = new TextView(this);
        t=(TextView) findViewById(R.id.inputRedThreePoints);
        t.setText("0");
        t = new TextView(this);
        t=(TextView) findViewById(R.id.inputWildPoints);
        t.setText("0");

        calculateScore();
    }
    private void registerListener(EditText editText) {
        editText.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                System.out.println(actionId);
                calculateScore();
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
                    calculateScore();
                    handled = true;
                }
                return handled;
            }
        });

        editText.setOnFocusChangeListener(new EditText.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus && ((TextView) v).getText().toString().equals("0")) {
                    calculateScore();
                    try {
                        ((TextView) v).setText("");
                    } catch (Exception e) {
                        System.out.println("Could not set text");
                        e.printStackTrace();
                    }
                } else if (!hasFocus && ((TextView) v).getText().toString().equals("")) {
                    ((TextView) v).setText("0");
                }
            }
        });
    }
    private int getInt(TextView v) {
        try {
            return Integer.parseInt(v.getText().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

