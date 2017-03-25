package com.example.sushantoberoi.catchyourtrain;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by sushant oberoi on 21-03-2017.
 */
public class PnrStatus extends android.support.v4.app.Fragment implements ImageButton.OnClickListener {
    ImageButton btn;
    Button pnrbtn;
    EditText pnr;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.pnr_status,container,false);
        btn= (ImageButton) v.findViewById(R.id.btnSpeak);
        pnrbtn= (Button) v.findViewById(R.id.pnrbtn);
        pnr= (EditText) v.findViewById(R.id.pnr);
        btn.setOnClickListener(this);
        pnrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                String p=pnr.getText().toString();
                    if(p.isEmpty() || p==null){
                        Toast.makeText(getContext(), "Kindly fill all fields", Toast.LENGTH_LONG).show();
                    }
                    else {
                        String data = "http://api.railwayapi.com/pnr_status/pnr/" + p + "/apikey/" + MainActivity.KEY + "/";

                        URL url = new URL(data);
                        HttpURLConnection ucon = (HttpURLConnection) url.openConnection();
                        InputStreamReader in = new InputStreamReader(ucon.getInputStream());
                        BufferedReader br = new BufferedReader(in);
                        String s;
                        String json = "";
                        while ((s = br.readLine()) != null) {
                            json += s;
                        }
                        Gson gson = new Gson();
                        PnrStatusJson.PassengersBean obj = new PnrStatusJson.PassengersBean();
                        String book_status = obj.getBooking_status();
                        String curr_status = obj.getCurrent_status();
                        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                        alertDialog.setTitle("Alert");
                        alertDialog.setMessage("Your Booking status is: " + book_status + "\n" + "Your current status: " + curr_status);
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                } catch (MalformedURLException e) {
                    Toast.makeText(getActivity(),"Fill all details "+e,Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(getActivity(),"Fill all details "+e,Toast.LENGTH_SHORT).show();
                }

            }
        });
        return v;
    }

    @Override
    public void onClick(View view) {
        promptSpeechInput();
    }
    /**
     * Showing google speech input dialog
     * */
    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("pnr",pnr.getText().toString());
    }
/*
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        pnr.setText(""+savedInstanceState.getCharSequence("pnr"));
    }
*/
    /**
     * Receiving speech input
     * */

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == Activity.RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    pnr.setText(result.get(0));
                }
                break;
            }

        }
    }
}
