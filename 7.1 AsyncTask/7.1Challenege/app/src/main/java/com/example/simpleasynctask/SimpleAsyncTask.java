package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Integer, String> {

    private WeakReference<TextView> mTextView;

    SimpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);

    }

    @Override
    protected String doInBackground(Void... voids) {
        Random random = new Random();
        int number = random.nextInt(11);
        int milli = number * 400;
        int chunk = milli/100;
        for(int i=0;i<100;i++) {
            try {

                Thread.sleep(chunk);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(chunk*i);
        }

        return "Awake after sleeping for " + milli + " milliseconds";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        mTextView.get().setText("Current Sleep Time is: "+values[0]);
    }
    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }
}
