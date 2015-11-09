package com.example.administrator.arraylistwithonclicklistener;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static final int DEFAULT = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);

        final String s3Link="http://www.gsmarena.com/samsung_i9300_galaxy_s_iii-4238.php";
        final String lumiaLink = "http://www.gsmarena.com/nokia_lumia_920-4967.php";
        final String xperiaLink = "http://www.gsmarena.com/sony_xperia_z5-7534.php";

        String[] names = new String[] {"Samsung S3","Lumia 920","Xperia Z5"};


        ChartItems s3 = new ChartItems(R.drawable.s3,"Samsung S3","$350");
        ChartItems Lumia920 = new ChartItems(R.drawable.lumia920,"Lumia 920","$500");
        ChartItems Z5 = new ChartItems(R.drawable.experiaz5,"Xperia Z5","$600");

        final ArrayList<ChartItems> chartItemses = new ArrayList<>();

        chartItemses.add(s3);
        chartItemses.add(Lumia920);
        chartItemses.add(Z5);

        final CustomAdapter customAdapter = new CustomAdapter(this,chartItemses);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "clicked "+i, Toast.LENGTH_SHORT).show();

                ChartItems chartItems = chartItemses.get(i);
                String name = chartItems.itemName;

                customAdapter.notifyDataSetChanged();

                Uri webPage=null;
                if(i==0){
                    webPage = Uri.parse(s3Link);
                }else if(i==1){
                    webPage = Uri.parse(lumiaLink);
                }else if(i==2){
                    webPage = Uri.parse(xperiaLink);
                }
                Intent intent = new Intent(Intent.ACTION_VIEW,webPage);
                startActivity(intent);
            }
        });




    }

    public void addItem(View view){
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        startActivityForResult(intent, DEFAULT);
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
