package com.example.restapitestproject.controller;


import com.example.restapitestproject.model.CustomNameValuePair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class HTTPMethodController {


    public static String postToServerGzip(String url, List<CustomNameValuePair> params) throws IOException {

        String response = "";

        URL postURL = new URL(url);
        HttpURLConnection con = (HttpURLConnection) postURL.openConnection();
        con.setRequestProperty("Accept-Encoding", "gzip");
        con.setConnectTimeout(100 * 1000);
        con.setReadTimeout(300 * 1000);
        con.setRequestMethod("POST");
        con.setDoInput(true);
        con.setDoOutput(true);

        OutputStream os = con.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
        writer.write(generatePOSTParams(params));
        writer.flush();
        writer.close();
        os.close();

        con.connect();

        int status = con.getResponseCode();
        switch (status) {
            case 200:
            case 201:

                Reader reader;
                if ("gzip".equals(con.getContentEncoding())) {
                    reader = new InputStreamReader(new GZIPInputStream(con.getInputStream()));

                } else {
                    reader = new InputStreamReader(con.getInputStream());
                }


                BufferedReader br = new BufferedReader(reader);
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                br.close();

                response = sb.toString();
        }


        return response;
    }

    private static String generatePOSTParams(List<CustomNameValuePair> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (CustomNameValuePair pair : params) {
            if (pair != null) {
                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
            }
        }
        return result.toString();
    }

    public static String postToServerGzipWithToken(String token, String url, List<CustomNameValuePair> params) throws IOException {
        String response = "";

        URL postURL = new URL(url);
        HttpURLConnection con = (HttpURLConnection) postURL.openConnection();
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("ContentType", "application/json");
        con.setRequestProperty("Authorization", "Bearer " + token);
        con.setRequestProperty("Accept-Encoding", "gzip");
        con.setConnectTimeout(20 * 1000);
        con.setReadTimeout(30 * 1000);
        con.setRequestMethod("POST");
        con.setDoInput(true);
        con.setDoOutput(true);

        OutputStream os = con.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
        writer.write(generatePOSTParams(params));
        writer.flush();
        writer.close();
        os.close();

        con.connect();

        int status = con.getResponseCode();
        switch (status) {
            case 200:
            case 201:

                Reader reader;
                if ("gzip".equals(con.getContentEncoding())) {
                    reader = new InputStreamReader(new GZIPInputStream(con.getInputStream()));

                } else {
                    reader = new InputStreamReader(con.getInputStream());
                }


                BufferedReader br = new BufferedReader(reader);
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                br.close();

                response = sb.toString();
        }

        return response;
    }

    public static String getToServerGzipWithToken(String token, String url, List<CustomNameValuePair> params) throws IOException {
        String response = "";

        URL postURL = new URL(url);
        HttpURLConnection con = (HttpURLConnection) postURL.openConnection();
        con.setRequestProperty("Authorization", "Bearer " + token);
        con.setRequestProperty("Accept-Encoding", "gzip");
        con.setConnectTimeout(20 * 1000);
        con.setReadTimeout(30 * 1000);
        con.setRequestMethod("POST");
        con.setDoInput(true);
        con.setDoOutput(true);

        OutputStream os = con.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
        writer.write(generatePOSTParams(params));
        writer.flush();
        writer.close();
        os.close();

        con.connect();

        int status = con.getResponseCode();
        switch (status) {
            case 200:
            case 201:

                Reader reader;
                if ("gzip".equals(con.getContentEncoding())) {
                    reader = new InputStreamReader(new GZIPInputStream(con.getInputStream()));

                } else {
                    reader = new InputStreamReader(con.getInputStream());
                }


                BufferedReader br = new BufferedReader(reader);
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                br.close();

                response = sb.toString();

        }


        return response;
    }

}


