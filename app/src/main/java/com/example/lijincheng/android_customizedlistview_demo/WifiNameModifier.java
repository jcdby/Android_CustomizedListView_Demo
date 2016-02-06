package com.example.lijincheng.android_customizedlistview_demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
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
public class WifiNameModifier extends DialogFragment  {

    //the adapter that manages the data source, which here is the arraylist of view item.

    //The position of the clicked item
    int position = 0;
    MessagePipline sListener;
    String message = "";

    public void setMessage(String message) {
        this.message = message;
    }

    public void sendMessageByPosition(String message, int position) {
        this.message = message;
        this.position = position;
    }

    public String getMessage() {
        return message;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            sListener = (MessagePipline) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "must implement Message Pipe line");
        }
    }

    public WifiNameModifier() {
    }



    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        //set customized dialog view
        View diaView = inflater.inflate(R.layout.dialog_custom, null);

        //get the EditText from the customized dialog view
        final EditText et = (EditText) diaView.findViewById(R.id.dialog_wifiname_input);

        et.setHint(getMessage());
        ad.setTitle("Change the wifi name");
        ad.setView(diaView);

        //set an Editor Action listener in case that users use their keyboard key,
        //like enter key, to return their texts.The normal scenario(usage) for the this dialog is
        //that users input a new wifi name on the editor text view,and use the "OK" key to return
        //the new value.But some times, users may click keyboard enter key to do that action.
        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || (event != null && KeyEvent.KEYCODE_ENTER == event.getKeyCode() && KeyEvent.ACTION_DOWN == event.getAction())) {

                    sListener.sendMessageByPosition(v.getText().toString(), getPosition());

                    Log.i("ActionID", "true");
                }

                return false;
            }
        });



        ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i("new wifi name", et.getText().toString());


                sListener.sendMessageByPosition(et.getText().toString(), getPosition());

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
