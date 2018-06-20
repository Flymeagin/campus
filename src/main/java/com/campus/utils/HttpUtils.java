package com.campus.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.Map.*;

public class HttpUtils {

    private static CloseableHttpClient server;
    private static HttpResponse response;
    static{
        server = HttpClients.createDefault();
    }

    public static Map getEntity(String url,Map<String,String> params) {
        Map result = new HashMap();
        HttpPost post = new HttpPost(url);
        post.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36");
        Set<Entry<String, String>> entries = params.entrySet();
        List<NameValuePair> pas = new ArrayList<>();
        for(Entry<String,String> value :entries){
            pas.add(new BasicNameValuePair(value.getKey(),value.getValue()));
        }
        post.setEntity(new UrlEncodedFormEntity(pas,Charset.forName("utf8")));
        try {
            response = server.execute(post);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    ObjectMapper mapper = new ObjectMapper();
                    result = mapper.readValue(EntityUtils.toString(resEntity),Map.class);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
