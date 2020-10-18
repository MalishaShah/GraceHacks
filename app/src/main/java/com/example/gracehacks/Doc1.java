package com.example.gracehacks;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Doc1 extends AppCompatActivity {
    CalendarView calender;
    TextView date_view;
    Button book;
    int year1, day1, month1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doc1);

        // By ID we can use each component
        // which id is assign in xml file
        // use findViewById() to get the
        // CalendarView and TextView
        calender = (CalendarView)
                findViewById(R.id.calender);
        date_view = (TextView)
                findViewById(R.id.date_view);

        // Add Listener in calendar
        calender
                .setOnDateChangeListener(
                        new CalendarView
                                .OnDateChangeListener() {
                            @Override

                            // In this Listener have one method
                            // and in this method we will
                            // get the value of DAYS, MONTH, YEARS
                            public void onSelectedDayChange(
                                    @NonNull CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth)
                            {

                                // Store the value of date with
                                // format in String type Variable
                                // Add 1 in month because month
                                // index is start with 0
                                String Date
                                        = dayOfMonth + "-"
                                        + (month + 1) + "-" + year;

                                // set this date in TextView for Display
                                year1 = year;
                                month1 = month;
                                day1 = dayOfMonth;
                                date_view.setText(Date);
                            }
                        });

        book = findViewById(R.id.book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Doc1.this,"Booked Meeting on :"+date_view.getText().toString()+"at 6:00pm",Toast.LENGTH_LONG ).show();
                Intent calIn = new Intent(Intent.ACTION_INSERT);
                calIn.setData(CalendarContract.Events.CONTENT_URI);
                calIn.putExtra(CalendarContract.Events.TITLE, "Meeting with Dr. Sanjeev Kumar");
                calIn.putExtra(CalendarContract.Events.EVENT_LOCATION, "Zoom Meeting");
                calIn.putExtra(CalendarContract.Events.DESCRIPTION, "Get a medical opinion online");
                Calendar startTime = Calendar.getInstance();
                startTime.set(year1, month1, day1, 18, 0);
                Calendar endTime = Calendar.getInstance();
                endTime.set(year1, month1, day1, 18,10);
                calIn.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        startTime.getTimeInMillis());
                calIn.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        endTime.getTimeInMillis());
                startActivity(calIn);
            }
        });
    }
}
