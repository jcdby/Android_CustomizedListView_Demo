package com.example.lijincheng.android_customizedlistview_demo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ce_user on 2016-02-03.
 */
public class WifiNameModifier extends DialogFragment {

    //the adapter that manages the data source, which here is the arraylist of view item.
    WifiListAdapter wifiAdapter = null;
    //The position of the clicked item
    int position = 0;
    EditText et;

    public WifiNameModifier() {
    }

    public void setWifiAdapter(WifiListAdapter wifiAdapter) {
        this.wifiAdapter = wifiAdapter;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public WifiListAdapter getWfifiAdapter() {
        return wifiAdapter;
    }

    public String getSelectedItmeWifiname(){
        return getWfifiAdapter().getItem(this.position).getWifiName();
    }

    public void setSelectedItemWifiName(String newWifiName){
        getWfifiAdapter().getItem(this.position).setWifiName(newWifiName);
    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View diaView = inflater.inflate(R.layout.dialog_custom, null);

        et = (EditText) diaView.findViewById(R.id.dialog_wifiname_input);

        et.setHint(getSelectedItmeWifiname());
        ad.setTitle("Change the wifi name");
        ad.setView(diaView);

        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || (event != null && KeyEvent.KEYCODE_ENTER == event.getKeyCode() && KeyEvent.ACTION_DOWN == event.getAction())) {
                    setSelectedItemWifiName(et.getText().toString());
                }
                return false;
            }
        });


        ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i("new wifi name", et.getText().toString());
                setSelectedItemWifiName(et.getText().toString());
            }
        });
        ad.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });



        return ad.create();
    }


}
