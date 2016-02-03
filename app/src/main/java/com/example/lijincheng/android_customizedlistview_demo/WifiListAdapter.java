package com.example.lijincheng.android_customizedlistview_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lijincheng on 2/2/16.
 */
public class WifiListAdapter extends ArrayAdapter<WifiInformation> {
    List<WifiInformation> wifis;

    public WifiListAdapter(Context context, int resource,  List<WifiInformation> wifis) {
        super(context, resource, wifis);
        this.wifis = wifis;
    }

    @Override
    public int getPosition(WifiInformation item) {
        return super.getPosition(item);
    }


    @Override
    public WifiInformation getItem(int position) {
        return super.getItem(position);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.listview_custom_item, parent, false);
        }

        WifiInformation wifiInformation = wifis.get(position);

        ImageView wifiimg = (ImageView)convertView.findViewById(R.id.wifiImg);
        wifiimg.setImageResource(R.drawable.wifi);

        TextView wifiName = (TextView) convertView.findViewById(R.id.wifiName);
        wifiName.setText(wifiInformation.getWifiName());

        TextView wifiSecufity = (TextView) convertView.findViewById(R.id.security);
        wifiSecufity.setText("WPA2");

        ImageView wifiLock = (ImageView) convertView.findViewById(R.id.lockImg);
        wifiLock.setImageResource(R.drawable.lock);


        return convertView;

    }



}
