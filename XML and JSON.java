package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class MainActivity extends AppCompatActivity {

    TextView xml_contents,json_contents;
    Button parse_xml, parse_json;

    String cname,temp,lat,lon,hum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xml_contents=(TextView) findViewById(R.id.xmlcontents);
        json_contents=(TextView) findViewById(R.id.Json_Contents);
        parse_xml=(Button) findViewById(R.id.Parse_XML);
        parse_json=(Button) findViewById(R.id.Parse_JSON);

        parse_xml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream is = getAssets().open("city.xml");
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(is);
                    NodeList nList=doc.getElementsByTagName("cities");
                    System.out.println(nList.item(0).getNodeName());
                    for(int i=0; i<nList.getLength();i++){
                        Element element2 = (Element) nList.item(i);
                        cname=element2.getElementsByTagName("cname").item(0).getFirstChild().getNodeValue();
                        lat=element2.getElementsByTagName("lat").item(0).getFirstChild().getNodeValue();
                        lon=element2.getElementsByTagName("long").item(0).getFirstChild().getNodeValue();
                        temp=element2.getElementsByTagName("Temp").item(0).getFirstChild().getNodeValue();
                        hum=element2.getElementsByTagName("hum").item(0).getFirstChild().getNodeValue();


                        System.out.println(cname);
                        System.out.println(lat);
                        System.out.println(lon);
                        System.out.println(temp);
                        System.out.println(hum);

                        xml_contents.setText(xml_contents.getText()+"\n"+cname+"\n"+lat+"\n"+lon+"\n"+temp+"\n"+hum);
                    }
                } catch (IOException | ParserConfigurationException | SAXException e) {
                    e.printStackTrace();
                }
            }
        });

        parse_json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream is1 = getAssets().open("city.json");
                    byte[] buffer = new byte[is1.available()];
                    is1.read(buffer);
                    String jsonstring=new String(buffer);
                    JSONObject reader = new JSONObject(jsonstring);
                    JSONObject user1 = reader.getJSONObject("User1");
                    String name = user1.getString("City_name");
                    System.out.println(name);
                    String lat = user1.getString("Latitude");
                    //System.out.println(lat);
                    String lon = user1.getString("Longitude");
                    //System.out.println(lon);
                    String temp = user1.getString("Temperature");
                    //System.out.println(temp);
                    String hum = user1.getString("Humidity");
                    //System.out.println(hum);

                    json_contents.setText(json_contents.getText()+"\n"+name+"\n"+lat+"\n"+lon+"\n"+temp+"\n"+hum);
                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}