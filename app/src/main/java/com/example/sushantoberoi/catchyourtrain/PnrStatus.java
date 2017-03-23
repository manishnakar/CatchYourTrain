package com.example.sushantoberoi.catchyourtrain;

import android.app.Activity;
import android.content.ActivityNotFoundException;
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
                // pnr code
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
