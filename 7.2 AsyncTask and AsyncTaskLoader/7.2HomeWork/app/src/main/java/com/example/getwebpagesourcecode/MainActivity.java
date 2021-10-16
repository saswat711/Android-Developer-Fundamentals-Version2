package com.example.getwebpagesourcecode;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.example.getwebpagesourcecode.databinding.ActivityMainBinding;

import org.jetbrains.annotations.Nullable;


public class MainActivity extends Activity implements LoaderManager.LoaderCallbacks<String>, AdapterView.OnItemSelectedListener {

    private String mSpinnerValue;
    private EditText mURLEditText;
    private TextView mSourceCodeTextView;
    private static final String QUERY = "queryString";
    private static final String PROTOCOL = "transferProtocol";
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mURLEditText = binding.etUrl;
        mSourceCodeTextView = binding.tvPageSourceCode;

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.http_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = findViewById(R.id.http_spinner);
        if (spinner != null){
            spinner.setOnItemSelectedListener(this);
            spinner.setAdapter(adapter);
        }

        if (getSupportLoaderManager() != null && getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }
    }

    private LoaderManager getSupportLoaderManager() {
        return null;
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle) {
        // TODO: finish work here
        String queryString = "";
        String transferProtocol = "";
        if (bundle != null){
            queryString = bundle.getString(QUERY);
            transferProtocol = bundle.getString(PROTOCOL);
        }
        return new SourceCodeLoader(this, queryString, transferProtocol);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {
        try{
            mSourceCodeTextView.setText(s);
        }
        catch (Exception e){
            e.printStackTrace();
            mSourceCodeTextView.setText(R.string.no_response);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
        // empty method
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mSpinnerValue = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        String[] values = getResources().getStringArray(R.array.http_array);
        mSpinnerValue = values[0];
    }

    public void getSourceCode(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null){
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }

        String queryString = mURLEditText.getText().toString();


        // check connectivity before executing query
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connectivityManager != null){
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected() && (queryString.length() != 0)){
            Bundle queryBundle = new Bundle();
            queryBundle.putString(QUERY, queryString);
            queryBundle.putString(PROTOCOL, mSpinnerValue);
            getSupportLoaderManager().restartLoader(0, queryBundle, this);
            mSourceCodeTextView.setText(R.string.loading);
        }
        else{
            if (queryString.length() == 0){
                Toast.makeText(this, R.string.no_url, Toast.LENGTH_LONG).show();
            }
            else if(!URLUtil.isValidUrl(queryString)){
                Toast.makeText(this, R.string.invalid_url, Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this, R.string.no_connection, Toast.LENGTH_LONG).show();
            }
        }

    }

}
