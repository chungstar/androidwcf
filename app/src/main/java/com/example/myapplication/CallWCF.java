package com.example.myapplication;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.os.StrictMode;
import  org.ksoap2.serialization.SoapPrimitive;

public class CallWCF {
    static String ns = "http://tempuri.org/";
    static String methodname ="RegReq";
    static String methodname1 ="LoginReq";
    static String methodname2 ="UnregReq";
    static String methodname3 ="LogoutReq";
    static String soapaction = "http://tempuri.org/IService/RegReq";
    static String soapaction1 = "http://tempuri.org/IService/LoginReq";
    static String soapaction2 = "http://tempuri.org/IService/UnregReq";
    static String soapaction3 = "http://tempuri.org/IService/LogoutReq";
    static String url = "http://192.168.0.58/HJRASSVC/Service.svc";
    public String RegReq(String id,String pw,String name){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            SoapObject request = new SoapObject(ns, methodname);
            request.addProperty("id", id);
            request.addProperty("pw", pw);
            request.addProperty("name", name);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);

            HttpTransportSE hts = new HttpTransportSE(url);
            hts.call(soapaction, envelope);

            SoapPrimitive result = (SoapPrimitive) envelope.getResponse();
            return String.valueOf(result);
        }
        catch (Exception e) {
            return "예외"+e.getMessage();
        }
    }
    public String LoginReq(String id,String pw){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            SoapObject request = new SoapObject(ns, methodname1);
            request.addProperty("id", id);
            request.addProperty("pw", pw);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);

            HttpTransportSE hts = new HttpTransportSE(url);
            hts.call(soapaction1, envelope);

            SoapPrimitive result = (SoapPrimitive) envelope.getResponse();
            return String.valueOf(result);
        }
        catch (Exception e) {
            return "예외"+e.getMessage();
        }
    }
    public String UnregReq(String id,String pw){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            SoapObject request = new SoapObject(ns, methodname2);
            request.addProperty("id", id);
            request.addProperty("pw", pw);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);

            HttpTransportSE hts = new HttpTransportSE(url);
            hts.call(soapaction2, envelope);

            //SoapPrimitive result = (SoapPrimitive) envelope.getResponse();
            //return String.valueOf(result);
            return "아마 탈퇴 된 듯?";
        }
        catch (Exception e) {
            return "예외"+e.getMessage();
        }
    }
    public String LogoutReq(String id,String pw){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            SoapObject request = new SoapObject(ns, methodname3);
            request.addProperty("id", id);
            request.addProperty("pw", pw);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);

            HttpTransportSE hts = new HttpTransportSE(url);
            hts.call(soapaction3, envelope);

            //SoapPrimitive result = (SoapPrimitive) envelope.getResponse();
            //return String.valueOf(result);
            return "아마 로그아웃 된 듯?";
        }
        catch (Exception e) {
            return "예외"+e.getMessage();
        }
    }
}