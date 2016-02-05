package com.example.lijincheng.android_customizedlistview_demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements MessagePipline {
    List<WifiInformation> wifis;
    WifiListAdapter wifiAdapter;
    int position;
    WifiNameModifier wnm;


    @Override
    public void sendMessageByPosition(String message, int position) {
        wifiAdapter.getItem(position).setWifiName(message);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<WifiInformation> getWifis() {
        return wifis;
    }

    public void setWifis(List<WifiInformation> wifis) {
        this.wifis = wifis;
    }


    private void iniData(){
        if(wifis == null) {
            List<WifiInformation> tempWifis = new ArrayList<WifiInformation>();
            for (int i = 0; i < 100; i++) {
                WifiInformation wifi = new WifiInformation("wifi" + i);
                tempWifis.add(wifi);
            }
            wifis = tempWifis;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dummy data creationg
        iniData();

        //create adapter and listview, set wifiadapter to listview
        wifiAdapter = new WifiListAdapter(this, R.layout.listview_custom_item,
                wifis);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(wifiAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //WifiNameModifier is a subclass of DialogFragment
                wnm = new WifiNameModifier();
                wnm.sendMessageByPosition(wifis.get(i).getWifiName(), i);
                Log.i("SelectedPosition", "" + i);
                wnm.show(getFragmentManager(), "Alert");
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
