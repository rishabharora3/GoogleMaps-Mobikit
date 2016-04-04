package com.example.sony.demomaps;

import android.content.Context;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    Marker marker,cmarker,dmarker3,dmarker1,dmarker2,dmarker4,dmarker5,dmarker6,gmarker1,gmarker2,gmarker3,gmarker4;
    Marker nmarker1,nmarker2,nmarker3,nmarker4;
    Marker kmarker1,kmarker2,kmarker3,kmarker4;
    Marker lmarker1,lmarker2,lmarker3,lmarker4;
    Marker bmarker1,bmarker2,bmarker3,bmarker4;
    Marker mmarker1,mmarker2,mmarker3,mmarker4;
    private final LatLng ghaziabad1=new LatLng(28.674519, 77.364635);
    private final LatLng ghaziabad2=new LatLng( 28.675754, 77.442815);
    private final LatLng ghaziabad3=new LatLng(28.638735, 77.361434);
    private final LatLng ghaziabad4=new LatLng(28.643003, 77.361332);
    private final LatLng delhi1=new LatLng(28.681296, 77.320346);
    private final LatLng delhi2=new LatLng( 28.670904, 77.316913);
    private final LatLng delhi3=new LatLng(28.565729, 77.242646 );
    private final LatLng delhi4=new LatLng(28.566973, 77.246799);
    private final LatLng delhi5=new LatLng(28.568068, 77.220112 );
    private final LatLng delhi6=new LatLng(28.551366, 77.251182 );
    private final LatLng noida1=new LatLng(28.546400, 77.387099);
    private final LatLng noida2=new LatLng(28.570306, 77.326628);
    private final LatLng noida3=new LatLng(28.567907, 77.326609);
    private final LatLng noida4=new LatLng(28.570175, 77.326082);
    private final LatLng kolkata1=new LatLng(22.570593, 88.362638);
    private final LatLng kolkata2=new LatLng(22.573526, 88.363509);
    private final LatLng kolkata3=new LatLng(22.566902, 88.355464);
    private final LatLng kolkata4=new LatLng(22.539216, 88.354662);
    private final LatLng lucknow1=new LatLng(26.858564, 80.976441);
    private final LatLng lucknow2=new LatLng(26.870187, 80.997804);
    private final LatLng lucknow3=new LatLng(26.851474, 81.021060);
    private final LatLng lucknow4=new LatLng(26.850144, 80.950011);
    private final LatLng beng1=new LatLng(12.969810, 77.606808);
    private final LatLng beng2=new LatLng(12.935840, 77.616986);
    private final LatLng beng3=new LatLng(12.914810, 77.652245);
    private final LatLng beng4=new LatLng(12.974952, 77.605698);
    private final LatLng mumbai1=new LatLng(19.080148, 72.846157);
    private final LatLng mumbai2=new LatLng(19.075999, 72.840590);
    private final LatLng mumbai3=new LatLng(19.099904, 72.845243);
    private final LatLng mumbai4=new LatLng(19.079940, 72.854869);

    Polyline line;
   // LatLng cl;
   double clat;
    double clong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
    public void onSearch(View view)
    {
       // String ch;
       //String location;
        EditText location_tf=(EditText)findViewById(R.id.TFaddress);
        String location=location_tf.getText().toString();
boolean a;

        a=haveNetworkConnection();

        if(!a)
        {
            Toast.makeText(this, "Please Enable The Internet", Toast.LENGTH_LONG).show();
            return;

        }
       /* if()
        {
            Toast.makeText(this, "Please Enable The Location Services", Toast.LENGTH_LONG).show();
            return;
        }*/
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) && !locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            //All location services are disabled
            Toast.makeText(this, "Please Enable The Location Services", Toast.LENGTH_LONG).show();
            return;
        }
        if (location.trim().equals("")) {
            Toast.makeText(this, "Please Type in Search Bar ", Toast.LENGTH_LONG).show();
            return;
        }

a=haveNetworkConnection();
        if(!a)
        {
            Toast.makeText(this, "Please Enable The Internet", Toast.LENGTH_LONG).show();
             return;

        }
     //   if(mMap.setMyLocationEnabled(false))
       // {
         //   Toast.makeText(this, "Please Enable the Location Option", Toast.LENGTH_LONG).show();
           // return;
        //}

        /*if(ch.equals("Noida"))
            location="Noida";
        else if(ch.equals("Delhi"))
            location="Delhi";
        else if(ch.equals("Kolkata"))
            location="Kolkata";
        else if(ch.equals("Mumbai"))
            location="Mumbai";
        else if(ch.equals("Bengaluru"))
            location="Bengaluru";
        else
        location="Gurgaon";

*/




 //   Toast.makeText(getApplicationContext(),"Please type in search bar",Toast.LENGTH_LONG).show();

        List<Address> addressList=null;
        if(location!=null || !location.equals(""))
        {
            Geocoder geocoder=new Geocoder(this);
            try {
               addressList= geocoder.getFromLocationName(location, 1);

            } catch (IOException e) {
                e.printStackTrace();
            }
            Address address=addressList.get(0);
            LatLng latLng=new LatLng(address.getLatitude(),address.getLongitude());
            if(marker!=null)
            {
                marker.remove();
                cmarker.remove();
            }
           MarkerOptions options=new MarkerOptions()
                   .title("Marker")
                   .position(latLng)
                   .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
            marker= mMap.addMarker(options);
            clat=mMap.getMyLocation().getLatitude();
            clong=mMap.getMyLocation().getLongitude();
            LatLng coordinate = new LatLng(clat, clong);
           cmarker= mMap.addMarker(new MarkerOptions().position(coordinate).title("current location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        if(location.equalsIgnoreCase("Delhi"))
        {marker.remove();
            if(gmarker1!=null)
            {
                gmarker1.remove();
                gmarker2.remove();
                gmarker3.remove();
                gmarker4.remove();
            }
            if(nmarker1!=null)
            {
                nmarker1.remove();
                nmarker2.remove();
                nmarker3.remove();
                nmarker4.remove();
            }
            if(kmarker1!=null)
            {
                kmarker1.remove();
                kmarker2.remove();
                kmarker3.remove();
                kmarker4.remove();
            }
            if(mmarker1!=null)
            {
                mmarker1.remove();
                mmarker2.remove();
                mmarker3.remove();
                mmarker4.remove();
            }
            if(lmarker1!=null)
            {
                lmarker1.remove();
                lmarker2.remove();
                lmarker3.remove();
                lmarker4.remove();
            }
            if(bmarker1!=null)
            {
                bmarker1.remove();
                bmarker2.remove();
                bmarker3.remove();
                bmarker4.remove();
            }
            dmarker1=mMap.addMarker(new MarkerOptions().position(delhi1).title("Shop no 4 \n"+ "Pocket H, Dilshad Garden\n").snippet("09717794275"));
           dmarker2= mMap.addMarker(new MarkerOptions().position(delhi2).title("Shop No:4, Ajnara Complex, Block C, Vivek Vihar\n" ).snippet("09999370137"));
           dmarker3= mMap.addMarker(new MarkerOptions().position(delhi3).title("Go Mobile \n" +
                   "K-100 B, Lajpat Nagar, Delhi, Jal Vihar Road, Lajpat Nagar II\n").snippet("098715 24401"));
            dmarker4=mMap.addMarker(new MarkerOptions().position(delhi4).title("Samsung Smartphone Cafe \n" +
                    "Veer Savarkar Marg, Lajpat Nagar II\n").snippet("011 4227 0050"));
            dmarker5= mMap.addMarker(new MarkerOptions().position(delhi5).title("Invitation Electronics \n" +
                    "E-17, Main Market, South Extension II\n").snippet("011 4164 4566"));
            dmarker6= mMap.addMarker(new MarkerOptions().position(delhi6).title("Spice Hotspot \n" +
                    "Gedore House, Nehru Place\n").snippet("095600 99637"));
        }
            else if(location.equalsIgnoreCase("Ghaziabad"))
        {marker.remove();
            if(dmarker1!=null)
            {
                dmarker1.remove();
                dmarker2.remove();
                dmarker3.remove();
                dmarker4.remove();
                dmarker5.remove();
                dmarker6.remove();


            }
            if(nmarker1!=null) {
                nmarker1.remove();
                nmarker2.remove();
                nmarker3.remove();
                nmarker4.remove();
            }
            if(kmarker1!=null)
            {
                kmarker1.remove();
                kmarker2.remove();
                kmarker3.remove();
                kmarker4.remove();
            }
            if(mmarker1!=null)
            {
                mmarker1.remove();
                mmarker2.remove();
                mmarker3.remove();
                mmarker4.remove();
            }
            if(lmarker1!=null)
            {
                lmarker1.remove();
                lmarker2.remove();
                lmarker3.remove();
                lmarker4.remove();
            }
            if(bmarker1!=null)
            {
                bmarker1.remove();
                bmarker2.remove();
                bmarker3.remove();
                bmarker4.remove();
            }
            gmarker1=mMap.addMarker(new MarkerOptions().position(ghaziabad1).title("B9, Shop No 5, Meenal Apartment, Shalimar Garden, Extension 2, Near Lohia Park, Sahibabad"));
            gmarker2=mMap.addMarker(new MarkerOptions().position(ghaziabad2).title("TFone Mobile Store\n" +
                    "C-24 Shop No-G9 RDC Raj Nagar, Ashok Marg, Sector 10, Raj Nagar\n").snippet("0120 411 4330"));
            gmarker3=mMap.addMarker(new MarkerOptions().position(ghaziabad3).title("Croma, Aditya Mega City, Vaibhav Khand, Indirapuram\n").snippet("1800 258 3636"));
            gmarker4=mMap.addMarker(new MarkerOptions().position(ghaziabad4).title("Vijay Sales,Dr Sushila Naiyar Marg, Ahinsa Khand-1\n").snippet("0120 455 2346"));
        }
            else if(location.equalsIgnoreCase("Noida"))
        {marker.remove();
            if(dmarker1!=null)
            {
                dmarker1.remove();
                dmarker2.remove();
                dmarker3.remove();
                dmarker4.remove();
                dmarker5.remove();
                dmarker6.remove();

            }
            if(gmarker1!=null) {
                gmarker1.remove();
                gmarker2.remove();
                gmarker3.remove();
                gmarker4.remove();
            }
            if(kmarker1!=null)
            {
                kmarker1.remove();
                kmarker2.remove();
                kmarker3.remove();
                kmarker4.remove();
            }
            if(mmarker1!=null)
            {
                mmarker1.remove();
                mmarker2.remove();
                mmarker3.remove();
                mmarker4.remove();
            }
            if(lmarker1!=null)
            {
                lmarker1.remove();
                lmarker2.remove();
                lmarker3.remove();
                lmarker4.remove();
            }
            if(bmarker1!=null)
            {
                bmarker1.remove();
                bmarker2.remove();
                bmarker3.remove();
                bmarker4.remove();
            }
            nmarker1=mMap.addMarker(new MarkerOptions().position(noida1).title("The Mobile Store\n" +
                    "Dadri Main Rd, Bhangel, Salarpur Khadar, Sector 102, Noida, Uttar Pradesh\n").snippet("1860 267 6767"));
            nmarker2=mMap.addMarker(new MarkerOptions().position(noida2).title("Electro World Communication Solutions, G - 1, Savitri Market, Sector - 18\n").snippet("0120 640 1145"));
            nmarker3=mMap.addMarker(new MarkerOptions().position(noida3).title("Blackberry Store,Unit No. 148 & 149, The Great India Place, 1st Floor, Ashok Marg, Sector 38A\n").snippet("088003 44345"));
            nmarker4=mMap.addMarker(new MarkerOptions().position(noida4).title("Honey Telecom,Shop No.G-8, Ground Floor Near Metro Station Gate No.2, Savitri Market, Captain Vijyant Thapar Marg, S Block, Sector 18\n").snippet("0120 422 7758"));
        }

        else if(location.equalsIgnoreCase("Kolkata"))
        {
            marker.remove();
            if(dmarker1!=null)
            {
                dmarker1.remove();
                dmarker2.remove();
                dmarker3.remove();
                dmarker4.remove();
                dmarker5.remove();
                dmarker6.remove();

            }
            if(gmarker1!=null) {
                gmarker1.remove();
                gmarker2.remove();
                gmarker3.remove();
                gmarker4.remove();
            }
            if(nmarker1!=null)
            {
                nmarker1.remove();
                nmarker2.remove();
                nmarker3.remove();
                nmarker4.remove();
            }
            if(mmarker1!=null)
            {
                mmarker1.remove();
                mmarker2.remove();
                mmarker3.remove();
                mmarker4.remove();
            }
            if(lmarker1!=null)
            {
                lmarker1.remove();
                lmarker2.remove();
                lmarker3.remove();
                lmarker4.remove();
            }
            if(bmarker1!=null)
            {
                bmarker1.remove();
                bmarker2.remove();
                bmarker3.remove();
                bmarker4.remove();
            }
            kmarker1=mMap.addMarker(new MarkerOptions().position(kolkata1).title("The MobileStore 6, Chittaranjan Avenue, Chandni Chowk\n").snippet("1860 267 6767"));
            kmarker2=mMap.addMarker(new MarkerOptions().position(kolkata2).title("Galaxzee,9b, Beadon Street, Beadon Street\n").snippet("033 2241 8768"));
            kmarker3=mMap.addMarker(new MarkerOptions().position(kolkata3).title("E Zone E-Mall, 2nd Floor, 6 Chittaranjan Avenue,, Chandni Chowk\n").snippet("093394 80976"));
            kmarker4=mMap.addMarker(new MarkerOptions().position(kolkata4).title("Agarwal Communication 11/1,Ideal Plaza, Shop No.008, Sarat Bose Rd, Sreepally, Ballygunge\n").snippet("033 4003 6660"));
        }
            else if(location.equalsIgnoreCase("Lucknow"))
        {
            marker.remove();
            if(dmarker1!=null)
            {
                dmarker1.remove();
                dmarker2.remove();
                dmarker3.remove();
                dmarker4.remove();
                dmarker5.remove();
                dmarker6.remove();

            }
            if(gmarker1!=null) {
                gmarker1.remove();
                gmarker2.remove();
                gmarker3.remove();
                gmarker4.remove();
            }
            if(nmarker1!=null)
            {
                nmarker1.remove();
                nmarker2.remove();
                nmarker3.remove();
                nmarker4.remove();
            }
            if(mmarker1!=null)
            {
                mmarker1.remove();
                mmarker2.remove();
                mmarker3.remove();
                mmarker4.remove();
            }
            if(kmarker1!=null)
            {
                kmarker1.remove();
                kmarker2.remove();
                kmarker3.remove();
                kmarker4.remove();
            }
            if(bmarker1!=null)
            {
                bmarker1.remove();
                bmarker2.remove();
                bmarker3.remove();
                bmarker4.remove();
            }

            lmarker1=mMap.addMarker(new MarkerOptions().position(lucknow1).title("Jumbo Electronics 3rd A Level-1, Upper Ground Floor, Fun Republic Mall, Lohia Path, Nehru Enclave, Gomati Nagar\n").snippet("096959 18918"));
            lmarker2=mMap.addMarker(new MarkerOptions().position(lucknow2).title("Reliance Digital Retail Ltd,TC-54 and 55A, West End Mall, Vibhuti Khand, Gomati Nagar\n").snippet("522 491 6100"));
            lmarker3=mMap.addMarker(new MarkerOptions().position(lucknow3).title("Modern Mobiles ,B-208 209,Sahara Plaza,Patrakarpuram, Gomti Nagar\n").snippet("098390 12020"));
            lmarker4=mMap.addMarker(new MarkerOptions().position(lucknow4).title("The MobileStore,Plot No. 16/CP 105, Sector-16, Indira Nagar, Munshi Pulia\n").snippet("093356 25414"));
        }

        else if(location.equalsIgnoreCase("Bengaluru") || location.equalsIgnoreCase("Bangalore"))
        {
            marker.remove();
            if(dmarker1!=null)
            {
                dmarker1.remove();
                dmarker2.remove();
                dmarker3.remove();
                dmarker4.remove();
                dmarker5.remove();
                dmarker6.remove();

            }
            if(gmarker1!=null) {
                gmarker1.remove();
                gmarker2.remove();
                gmarker3.remove();
                gmarker4.remove();
            }
            if(nmarker1!=null)
            {
                nmarker1.remove();
                nmarker2.remove();
                nmarker3.remove();
                nmarker4.remove();
            }
            if(mmarker1!=null)
            {
                mmarker1.remove();
                mmarker2.remove();
                mmarker3.remove();
                mmarker4.remove();
            }
            if(kmarker1!=null)
            {
                kmarker1.remove();
                kmarker2.remove();
                kmarker3.remove();
                kmarker4.remove();
            }
            if(lmarker1!=null)
            {
                lmarker1.remove();
                lmarker2.remove();
                lmarker3.remove();
                lmarker4.remove();
            }

            bmarker1=mMap.addMarker(new MarkerOptions().position(beng1).title("Samsung Smart Cafe,Building No. 74, Sumeru Towers, Brigade Road\n").snippet("095389 00702"));
            bmarker2=mMap.addMarker(new MarkerOptions().position(beng2).title("The Phone Store,Shop No. 2, Mehmood Plaza,, #167 KBH Colony, 17th C Main Rd, KHB Block Koramangala\n").snippet("080 2552 6766"));
            bmarker3=mMap.addMarker(new MarkerOptions().position(beng3).title("Quick Connect,Main Road, Brigade Road\n").snippet("080 2258 6767"));
            bmarker4=mMap.addMarker(new MarkerOptions().position(beng4).title("Waves Telecom,No.3, Church Street, Shanthala Nagar, Ashok Nagar\n").snippet("09916663883"));
        }
        else if(location.equalsIgnoreCase("Mumbai"))
        {
            marker.remove();
            if(dmarker1!=null)
            {
                dmarker1.remove();
                dmarker2.remove();
                dmarker3.remove();
                dmarker4.remove();
                dmarker5.remove();
                dmarker6.remove();

            }
            if(gmarker1!=null) {
                gmarker1.remove();
                gmarker2.remove();
                gmarker3.remove();
                gmarker4.remove();
            }
            if(nmarker1!=null)
            {
                nmarker1.remove();
                nmarker2.remove();
                nmarker3.remove();
                nmarker4.remove();
            }
            if(bmarker1!=null)
            {
                bmarker1.remove();
                bmarker2.remove();
                bmarker3.remove();
                bmarker4.remove();
            }
            if(kmarker1!=null)
            {
                kmarker1.remove();
                kmarker2.remove();
                kmarker3.remove();
                kmarker4.remove();
            }
            if(lmarker1!=null)
            {
                lmarker1.remove();
                lmarker2.remove();
                lmarker3.remove();
                lmarker4.remove();
            }

            mmarker1=mMap.addMarker(new MarkerOptions().position(mumbai1).title("Vijay Electronics,Jawaharlal Nehru Rd, Santacruz East\n").snippet("022 6678 3885"));
            mmarker2=mMap.addMarker(new MarkerOptions().position(mumbai2).title("Vodafone Store,S V Rd, Santacruz West\n").snippet("098200 98200"));
            mmarker3=mMap.addMarker(new MarkerOptions().position(mumbai3).title("Milan Electronics,39/48 A, Syamkmal Agarwal Market, Monghibai Rd, Vile Parle East, Vile Parle\n").snippet("022 2616 1007"));
            mmarker4=mMap.addMarker(new MarkerOptions().position(mumbai4).title("Vijay Sales ,18, Prime Centre, Near Standard Chartered Bank, S V Road, Santacruz West\n").snippet("022 2649 1393"));
        }


          // drawLine();
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        }

    }

    /*private void drawLine() {
        PolylineOptions options=new PolylineOptions()
.add(marker.getPosition())
.add(cmarker.getPosition())
                .color(Color.BLACK)
                .width(5)
                .visible(true)
                .geodesic(true)
               ;
        if(line!=null)
            line.remove();
      line=  mMap.addPolyline(options);

       // alert("polyline is "+lengthInMeters+" long");


    }*/
  /*  public void  check() {
       if(( (EditText)findViewById(R.id.TFaddress)).getText().toString() == "")
        {
            Toast.makeText(getApplicationContext(), "Please type in search bar", Toast.LENGTH_LONG).show();
            return;


        }
    }*/
   /* public void onZoom(View view)
    {
        if(view.getId()==R.id.Bzoomin)
        {
            mMap.animateCamera(CameraUpdateFactory.zoomIn() );
        }
        if(view.getId()==R.id.Bzoomout)
        {
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }
*/

    public void changeType(View view)
    {
        if(mMap.getMapType()==GoogleMap.MAP_TYPE_NORMAL)
        {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }
        else
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }


    private void setUpMap() {
       // mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
       mMap.setMyLocationEnabled(true);
    /*    clat=mMap.getMyLocation().getLatitude();
        clong=mMap.getMyLocation().getLongitude();
        LatLng coordinate = new LatLng(clat, clong);*/
    //
    //mMap.addMarker(new MarkerOptions().position(new LatLng(mMap.getMyLocation().getLatitude(),mMap.getMyLocation().getLongitude())).title("Current Location"));
    }
}
