package ir.parsapp.apptest;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class WebRequest {

    public String getWebContent(String url){
        HttpClient client=new DefaultHttpClient();
        HttpGet get=new HttpGet(url);
        try {
            HttpEntity entity=client.execute(get).getEntity();
            return EntityUtils.toString(entity);
        }catch (Exception e){
            Log.e("error",e.getMessage());
        }
        return "";
    }

}
