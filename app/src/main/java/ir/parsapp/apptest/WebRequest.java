package ir.parsapp.apptest;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class WebRequest {

    public String getWebContent(String url) {
        HttpClient client=new DefaultHttpClient();
        HttpGet get=new HttpGet(url);
        //HttpPost post=new HttpPost(url);
        //List<NameValuePair> data=new ArrayList<>();
        //data.add(new BasicNameValuePair("family","ahmadi"));
        //post.setEntity(new UrlEncodedFormEntity(data, org.apache.http.protocol.HTTP.UTF_8));
        try {
            HttpEntity entity=client.execute(get).getEntity();
            return EntityUtils.toString(entity);
        }catch (Exception e){
            Log.e("error",e.getMessage());
        }
        return "";
    }

}
