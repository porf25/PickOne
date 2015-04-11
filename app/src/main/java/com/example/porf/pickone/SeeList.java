package com.example.porf.pickone;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class SeeList extends ActionBarActivity {

    private ArrayList<String> Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_list);

        //get the intent that called this activity
        Intent listActivity = getIntent();

        //get the data that was sent over by the intent
        Lista = listActivity.getStringArrayListExtra("The List");

        ListAdapter ListaAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                Lista);

        ListView theListView = (ListView) findViewById(R.id.listViewItem);

        theListView.setAdapter(ListaAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_see_list, menu);
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

    public void pickOne(View view) {
        if(Lista.size() < 1){
            Toast.makeText(this, "Cannot have a blank List, please go back and add some items", Toast.LENGTH_LONG).show();
        }
        else{
            Random r = new Random();
            int RandomNumber = r.nextInt(Lista.size());
            String winner = "The item chosen at random is " + Lista.get(RandomNumber);

            Toast.makeText(this, winner, Toast.LENGTH_LONG).show();
        }



    }
}
