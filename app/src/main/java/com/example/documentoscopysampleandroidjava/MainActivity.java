package com.example.documentoscopysampleandroidjava;

import android.os.Bundle;

import com.clear.studio.csdocs.entries.CSDocumentoscopy;
import com.clear.studio.csdocs.entries.CSDocumentoscopySDK;
import com.clear.studio.csdocs.entries.CSDocumentoscopySDKError;
import com.clear.studio.csdocs.entries.CSDocumentoscopySDKListener;
import com.clear.studio.csdocs.entries.CSDocumentoscopySDKResult;
import com.example.documentoscopysampleandroidjava.databinding.ActivityMainBinding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String TAG = "DocsSDK";

        //Preencha as variáveis abaixo
        String clientId = "";
        String clientSecret = "";
        String identifierId = "";
        //cpf Opcional
        String cpf = "";

        binding.clientId.setText(clientId);
        binding.clientSecret.setText(clientSecret);
        binding.identifierId.setText(identifierId);
        binding.cpf.setText(cpf);

        binding.startSdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.sessionId.setText("");
                String clientId = binding.clientId.getText().toString();
                String clientSecret = binding.clientSecret.getText().toString();
                String identifierId = binding.identifierId.getText().toString();
                String cpf = binding.cpf.getText().toString();

                if(clientId.equals("") && clientSecret.equals("") || identifierId.equals("")) {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                CSDocumentoscopy csDocumentoscopy = new CSDocumentoscopy(clientId, clientSecret, identifierId, cpf);
                CSDocumentoscopySDK.INSTANCE.initialize(getApplication(), csDocumentoscopy, new CSDocumentoscopySDKListener() {
                    @Override
                    public void didOpen() {
                        Log.i(TAG, "SDK Foi Aberto");
                    }

                    @Override
                    public void didTapClose() {
                        Log.i(TAG, "Usuário encerrou manualmente o fluxo");
                    }

                    @Override
                    public void didReceiveError(@NonNull CSDocumentoscopySDKError error) {
                        String errorText = error.getText() + "errorCode: " + error.getErrorCode();
                        binding.sessionId.setText(errorText);
                        Log.i(TAG, "Error: "+errorText);
                    }

                    @Override
                    public void didFinishCapture(@NonNull CSDocumentoscopySDKResult result) {
                        String sessionIdText = "Session Id: " + result.getSessionId();
                        binding.sessionId.setText(sessionIdText);
                        binding.csDocumentoscopySDKDocumentTypeView.setText("CSDocumentoscopySDKDocumentType: " + result.getDocumentType());
                        Log.i(TAG, sessionIdText);
                    }
                });
            }
        });
    }
}