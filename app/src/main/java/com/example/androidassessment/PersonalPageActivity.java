package com.example.androidassessment;

import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;


public class PersonalPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalpage);

        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewTemperature = findViewById(R.id.textViewTemperature);
        TextView textViewSymptoms = findViewById(R.id.textViewSymptoms);
        TextView textViewContactHistory = findViewById(R.id.textViewContactHistory);
        TextView textViewMedicalInstitutions = findViewById(R.id.textViewMedicalInstitutions);
        TextView textViewPreventionHandbook = findViewById(R.id.textViewPreventionHandbook);
        TextView textViewSymptomsAlert = findViewById(R.id.textViewSymptomsAlert);
        TextView textViewHealthConsultation = findViewById(R.id.textViewHealthConsultation);

        // Set initial personal information
        textViewName.setText("John Doe");
        textViewTemperature.setText("37.5°C");
        textViewSymptoms.setText("Cough, Fever");
        textViewContactHistory.setText("No recent contacts");

        // Set click listener
        textViewMedicalInstitutions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Operations that handle inquiries from medical institutions
                Toast.makeText(PersonalPageActivity.this, "Click on the medical institution to check", Toast.LENGTH_SHORT).show();

                //Start Google Maps and pass the location information of the medical institution as the destination
                String location = "https://wolper.com.au/"; //
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(location));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                // Check if the device has the Google Maps app installed
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                // Start Google Maps if the device has the Google Maps app installed
                if (isIntentSafe) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(PersonalPageActivity.this, "Google Maps app not found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        textViewPreventionHandbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handling of Handbooks for Epidemic Prevention
                Toast.makeText(PersonalPageActivity.this, "Click on the Epidemic Prevention Manual", Toast.LENGTH_SHORT).show();

                // Start a WebView Activity to load the hospital's epidemic prevention advice webpage
                String url ="https://msf.org.au/issue/covid-19-coronavirus-disease?gad=1&gclid=CjwKCAjwx_eiBhBGEiwA15gLNzEVVhQtlCDHuTT30ML4b3vkto6FlAx0Jb9a0_W-3zoYyXJK1p6MdBoCbUkQAvD_BwE&gclsrc=aw.ds";
                Intent webIntent = new Intent(PersonalPageActivity.this, WebViewActivity.class);
                webIntent.putExtra("url", url);
                startActivity(webIntent);
            }
        });

        textViewSymptomsAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Handling Operations with Unusual Symptoms
                Toast.makeText(PersonalPageActivity.this, "Clicked abnormal symptoms", Toast.LENGTH_SHORT).show();

                // Start the dialing Intent, using the hospital's contact number as the dialing number
                String phoneNumber = "02 9328 6079";
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(dialIntent);
            }
        });

        textViewHealthConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Operations that handle health inquiries
                Toast.makeText(PersonalPageActivity.this, "clicked health advice", Toast.LENGTH_SHORT).show();

                String consultationNumber ="04 9687 3121";
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + consultationNumber));
                startActivity(callIntent);
            }
        });

    }
}


