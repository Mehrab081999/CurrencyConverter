package com.example.practice;

import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.Scanner;

public class NetworkLayer {



     double result;
     String date;


    public double getLatestCurrency(String fromCountryCode, String toCountryCode, float amount)  {

           try {
               String GET_URL = "https://api.exchangerate.host/convert?from=" +fromCountryCode  + "&to=" + toCountryCode+ "&amount=" + amount;

               URL url = new URL(GET_URL);
               HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
               httpsURLConnection.setRequestMethod("GET");
               int responseCode = httpsURLConnection.getResponseCode();

               String inline = "";
               if(responseCode != 200)
                   throw new RuntimeException("HttpResponseCode: " +responseCode);
               else
               {
                   Scanner sc = new Scanner(url.openStream());

                   while(sc.hasNext())
                   {
                       inline += sc.nextLine();
                   }
                   System.out.println("\nJSON data in string format");
                   System.out.println(inline);
                   sc.close();
               }

               JSONObject obj = new JSONObject(inline);
                result = obj.getDouble("result");
                date = obj.getString("date");

               System.out.println("Result= " + result);
               System.out.println("Date= " + date);

           } catch (Exception e) {

               System.out.println(e);
           }

          return result;
    }
}
