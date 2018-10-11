package com.az.city7;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class CreateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        // create new private/public key pair
        final ECKeyPair[] keyPair = {null};
        try {
            keyPair[0] = Keys.createEcKeyPair();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            Log.e(ERROR,"No Such Algorithm Exception");
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            Log.e(ERROR,"No Such Provider Exception");
        }

    }


}
