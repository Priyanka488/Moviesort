package com.example.android.newmoves.utilities;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils
{

    private final static String MOVIES_BASE_URL = "https://api.themoviedb.org/3/movie/";

    private final static String API_KEY = "api_key";

    private final static String API_KEY_VALUE = "YOUR OWN API KEY GOES HERE !";
    private final static String LANGUAGE = "language";
    private final static String LANGUAGE_VALUE = "en-US";
    private final static String PAGE = "page";
    private final static String PAGE_VALUE = "1";

    public static URL buildUrl(String githubSearchQuery) {
        Uri builtUri = Uri.parse(MOVIES_BASE_URL).buildUpon()
                .appendPath(githubSearchQuery)
                .appendQueryParameter(API_KEY, API_KEY_VALUE)
                .appendQueryParameter(LANGUAGE, LANGUAGE_VALUE)
                .appendQueryParameter(PAGE, PAGE_VALUE)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
