package pl.marcinkulwicki.promotionmarket;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.JsonReader;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import pl.marcinkulwicki.promotionmarket.Objects.Product;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




        //Rest Api
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                // All your networking logic
                // should be here

                // Create connection
                HttpsURLConnection myConnection =
                        null;
                try {
                    URL githubEndpoint = new URL("https://api.mlab.com/api/1/databases/market_db/collections/products?apiKey=uFPNHsuN8mzRD1WbqlDf_BaUURGYOVb9");
                    myConnection = (HttpsURLConnection) githubEndpoint.openConnection();

                    myConnection.setRequestProperty("User-Agent", "my-rest-app-v0.1");

                    if (myConnection.getResponseCode() == 200) {
                        // Success
                        // Further processing here
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader =
                                new InputStreamReader(responseBody, "UTF-8");
                        JsonReader jsonReader = new JsonReader(responseBodyReader);

                        List<Product> products = new ArrayList<Product>();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            Product product = JsonObjectReaders.readProduct(jsonReader);
                            products.add(product);
//                            mTextViewApi.setText(product.getName());


                        }
                        jsonReader.endArray();




                        jsonReader.close();
                    } else {
                        // Error handling code goes here
                    }
                    myConnection.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // Stuff that updates the UI
                ((TextView)findViewById(R.id.textViewApi)).setText("hej");

            }
        });


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
}
