package com.example.covidtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class affectedCountries extends AppCompatActivity {
    EditText editText1;
    ListView listView;
    SimpleArcLoader simpleArcLoader;
    public static List<CountryModel> countryModelList=new ArrayList<>();
    CountryModel countryModel;
    MyCustomAdapter myCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affected_countries);
        getSupportActionBar().setTitle("Affected Countries");
        editText1=findViewById(R.id.editText1);
        listView=findViewById(R.id.listView1);
        simpleArcLoader=findViewById(R.id.loader);
        fetchData();
     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             Intent intent=new Intent(getApplicationContext(),country_details.class);
             intent.putExtra("position",i);
             startActivity(intent);
         }
     });
        
    }

    private void fetchData() {
        String url="https://corona.lmao.ninja/v2/countries/";
        simpleArcLoader.start();
        StringRequest request=new StringRequest(Request.Method.GET,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        String countryName=jsonObject.getString("country");
                        String cases=jsonObject.getString("cases");
                        String todayCases=jsonObject.getString("todayCases");
                        String todayDeaths=jsonObject.getString("todayDeaths");
                        String deaths=jsonObject.getString("deaths");
                        String recovered=jsonObject.getString("recovered");
                        String active=jsonObject.getString("active");
                        String critical=jsonObject.getString("critical");
                        JSONObject jsonObject1=jsonObject.getJSONObject("countryInfo");
                        String flagUrl=jsonObject1.getString("flag");
                        countryModel=new CountryModel(flagUrl,countryName,cases,deaths,active,recovered,todayCases,todayDeaths,critical);
                        countryModelList.add(countryModel);
                    }
                    myCustomAdapter=new MyCustomAdapter(affectedCountries.this,countryModelList);
                    listView.setAdapter(myCustomAdapter);
                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                } catch (JSONException e) {
                    e.printStackTrace();
                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
                Toast.makeText(affectedCountries.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}