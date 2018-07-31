package com.example.pedro.projetoblocoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pedro.projetoblocoandroid.barcode.BarcodeCaptureActivity;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class ScanActivity extends AppCompatActivity {

    private TextView mResultTextView;
    private Button mScanBarcodeButton;
    private final String LOG_TAG = "BARCODE_SCAN";
    private final int BARCODE_READER_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        mResultTextView = findViewById(R.id.txtStatus);

        mScanBarcodeButton = findViewById(R.id.btnScan);

        mScanBarcodeButton.setOnClickListener(scanBarCode);
    }

    private View.OnClickListener scanBarCode = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), BarcodeCaptureActivity.class);
            startActivityForResult(intent, BARCODE_READER_REQUEST_CODE);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BARCODE_READER_REQUEST_CODE){
            if (resultCode == CommonStatusCodes.SUCCESS){
                if (data != null){
                    Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
                    mResultTextView.setText(barcode.displayValue);
                } else {
                    mResultTextView.setText(R.string.no_barcode_captured);
                }
            } else {
                Log.e(String.valueOf(LOG_TAG), String.format(getString(R.string.barcode_error_format),
                        CommonStatusCodes.getStatusCodeString(resultCode)));
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
