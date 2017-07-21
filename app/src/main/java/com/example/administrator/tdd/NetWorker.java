package com.example.administrator.tdd;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class NetWorker {
    Context context;

    public NetWorker(Context context) {
        this.context = context;
    }

    public String doNetWork(){
        try {
            URL url = new URL("http://localhost:3000");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
            return br.readLine()+context.getString(R.string.app_name);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

}
