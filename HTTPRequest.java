package com.vallentinsource;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Author: Vallentin <mail@vallentinsource.com>
 * Website: http://vallentinsource.com
 * Repository: https://github.com/MrVallentin/http_request
 * 
 * Date Created: February 29, 2016
 * Last Modified: February 29, 2016
 */
public class HTTPRequest
{
    public final static String request(String url, String data, String method, final Map<String, String> headers) throws MalformedURLException, IOException
    {
        if (method == null)
            method = "GET";
        
        if (method.equals("GET"))
        {
            if ((data != null) && !data.isEmpty())
            {
                if (url.contains("?"))
                    url = url + "&" + data;
                else
                    url = url + "?" + data;
            }
            
            data = null;
        }
        
        
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        
        // Java doesn't like PATCH requests...
        if (method.equals("PATCH"))
        {
            conn.setRequestMethod("POST");
            
            conn.setRequestProperty("X-HTTP-Method", "PATCH");
            conn.setRequestProperty("X-HTTP-Method-Override", "PATCH");
        }
        else
            conn.setRequestMethod(method.toUpperCase());
        
        conn.setUseCaches(false);
        conn.setDoOutput(true);
        
        
        if (headers != null)
        {
            for (Map.Entry<String, String> entry : headers.entrySet())
            {
                final String key = entry.getKey();
                final String value = entry.getValue();
                
                conn.setRequestProperty(key, value);
            }
        }
        
        
        if (data != null)
        {
            try (DataOutputStream out = new DataOutputStream(conn.getOutputStream()))
            {
                out.writeBytes(data);
                out.close();
            }
        }
        
        
        // final int responseCode = conn.getResponseCode();
        
        
        StringBuilder response = new StringBuilder();
        
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream())))
        {
            String line;
            while ((line = in.readLine()) != null)
            {
                response.append(line);
            }
            
            in.close();
        }
        
        
        conn.disconnect();
        
        
        return response.toString();
    }
    
    public final static String request(final String url, final String data, final String method) throws MalformedURLException, IOException
    {
        return request(url, data, method, null);
    }
    
    public final static String request(final String url, final String data) throws MalformedURLException, IOException
    {
        return request(url, data, "GET");
    }
    
    public final static String request(final String url) throws MalformedURLException, IOException
    {
        return request(url, "");
    }
    
    
    private final static String urlEncodeUTF8(final String str) throws UnsupportedEncodingException
    {
        return URLEncoder.encode(str, "UTF-8");
    }
    
    private final static String urlEncodeUTF8(Map<?, ?> map) throws UnsupportedEncodingException
    {
        StringBuilder sb = new StringBuilder();
        
        for (Map.Entry<?, ?> entry : map.entrySet())
        {
            if (sb.length() > 0)
                sb.append("&");
            
            sb.append(String.format("%s=%s",
                urlEncodeUTF8(entry.getKey().toString()),
                urlEncodeUTF8(entry.getValue().toString())
            ));
        }
        
        return sb.toString();
    }
    
    
    public final static String request(final String url, final Map<String, String> data, String method, final Map<String, String> headers) throws MalformedURLException, IOException
    {
        return request(url, urlEncodeUTF8(data), method, headers);
    }
    
    public final static String request(final String url, final Map<String, String> data, final String method) throws MalformedURLException, IOException
    {
        return request(url, data, method, null);
    }
    
    public final static String request(final String url, final Map<String, String> data) throws MalformedURLException, IOException
    {
        return request(url, data, "GET");
    }
    
    
    
    public final static String get(final String url, final Map<String, String> data, final Map<String, String> headers) throws MalformedURLException, IOException
    {
        return request(url, data, "GET", headers);
    }
    
    public final static String get(final String url, final Map<String, String> data) throws MalformedURLException, IOException
    {
        return get(url, data, null);
    }
    
    
    public final static String get(final String url, final String data, final Map<String, String> headers) throws MalformedURLException, IOException
    {
        return request(url, data, "GET", headers);
    }
    
    public final static String get(final String url, final String data) throws MalformedURLException, IOException
    {
        return get(url, data, null);
    }
    
    public final static String get(final String url) throws MalformedURLException, IOException
    {
        return get(url, "");
    }
    
    
    
    public final static String post(final String url, final Map<String, String> data, final Map<String, String> headers) throws MalformedURLException, IOException
    {
        return request(url, data, "POST", headers);
    }
    
    public final static String post(final String url, final Map<String, String> data) throws MalformedURLException, IOException
    {
        return post(url, data, null);
    }
    
    
    public final static String post(final String url, final String data, final Map<String, String> headers) throws MalformedURLException, IOException
    {
        return request(url, data, "POST", headers);
    }
    
    public final static String post(final String url, final String data) throws MalformedURLException, IOException
    {
        return post(url, data, null);
    }
    
    public final static String post(final String url) throws MalformedURLException, IOException
    {
        return post(url, "");
    }
    
    
    
    public final static String delete(final String url, final Map<String, String> data, final Map<String, String> headers) throws MalformedURLException, IOException
    {
        return request(url, data, "DELETE", headers);
    }
    
    public final static String delete(final String url, final Map<String, String> data) throws MalformedURLException, IOException
    {
        return delete(url, data, null);
    }
    
    
    public final static String delete(final String url, final String data, final Map<String, String> headers) throws MalformedURLException, IOException
    {
        return request(url, data, "DELETE", headers);
    }
    
    public final static String delete(final String url, final String data) throws MalformedURLException, IOException
    {
        return delete(url, data, null);
    }
    
    public final static String delete(final String url) throws MalformedURLException, IOException
    {
        return delete(url, "");
    }
    
    
    
    public final static String put(final String url, final Map<String, String> data, final Map<String, String> headers) throws MalformedURLException, IOException
    {
        return request(url, data, "PUT", headers);
    }
    
    public final static String put(final String url, final Map<String, String> data) throws MalformedURLException, IOException
    {
        return put(url, data, null);
    }
    
    
    public final static String put(final String url, final String data, final Map<String, String> headers) throws MalformedURLException, IOException
    {
        return request(url, data, "PUT", headers);
    }
    
    public final static String put(final String url, final String data) throws MalformedURLException, IOException
    {
        return put(url, data, null);
    }
    
    public final static String put(final String url) throws MalformedURLException, IOException
    {
        return put(url, "");
    }
    
    
    
    public final static String patch(final String url, final Map<String, String> data, final Map<String, String> headers) throws MalformedURLException, IOException
    {
        return request(url, data, "PATCH", headers);
    }
    
    public final static String patch(final String url, final Map<String, String> data) throws MalformedURLException, IOException
    {
        return patch(url, data, null);
    }
    
    
    public final static String patch(final String url, final String data, final Map<String, String> headers) throws MalformedURLException, IOException
    {
        return request(url, data, "PATCH", headers);
    }
    
    public final static String patch(final String url, final String data) throws MalformedURLException, IOException
    {
        return patch(url, data, null);
    }
    
    public final static String patch(final String url) throws MalformedURLException, IOException
    {
        return patch(url, "");
    }
    
    
    
    private HTTPRequest()
    {
        
    }
}
