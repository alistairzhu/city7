package com.az.city7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

//import com.example.aurora.myweb3j.util.Alice;
//import com.example.aurora.myweb3j.util.Web3jConstants;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.methods.response.EthCoinbase;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    static public Web3j web3j = null;
    static String clientUrl = null;
    static String[] accounts = new String[15];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String TAG = "Return";

        //connect to the ethereum client node
        Start_Connect();
        // show client details
        Web3ClientVersion client = null;
        try {
            client = web3j
                    .web3ClientVersion()
                    .sendAsync()
                    .get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "Connected to " + client.getWeb3ClientVersion() + "\n");


    }



    //when uer clicking the "register" button
    public void onRegister(View view){

        final Intent intent_register = new Intent(getApplicationContext(), CreateActivity.class);
        startActivity(intent_register);

    }


    //connect the moible device to the ethereum client node
    public void Start_Connect() {
        clientUrl = argsToUrl();
        web3j = Web3jFactory.build(new HttpService(clientUrl));
    }


    //connection port and ip
    public String argsToUrl() {
        String ip = "10.0.2.2";//ZT
        String port = "8545";//ZT

        return String.format("http://%s:%s", ip, port);
    }
}
