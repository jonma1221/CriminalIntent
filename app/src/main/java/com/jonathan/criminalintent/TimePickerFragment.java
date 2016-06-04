package com.jonathan.criminalintent;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Created by Jonathan on 4/13/2016.
 */
public class TimePickerFragment extends DialogFragment{
    public static final String EXTRA_TIME =
            "com.bignerdranch.android.criminalintent.time";
    private static final String ARG_TIME = "time";

    private TimePicker timePicker;

    public static TimePickerFragment newInstance(Date date){
        Bundle args = new Bundle();
        TimePickerFragment timePicker = new TimePickerFragment();
        args.putSerializable(ARG_TIME,date);
        timePicker.setArguments(args);
        return timePicker;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.time_picker,null);
        Date date = (Date) getArguments().getSerializable(ARG_TIME);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        int minutes = cal.get(Calendar.MINUTE);
        int seconds = cal.get(Calendar.SECOND);
        timePicker = (TimePicker) v.findViewById(R.id.dialog_time);
        timePicker.setCurrentHour(hours);
        timePicker.setCurrentMinute(minutes);
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.time_picker_title)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int hours = timePicker.getCurrentHour();
                                int minutes = timePicker.getCurrentMinute();
                            }
                        })
                .create();
    }

    private void sendResult(int resultCode, Date date) {
        if (getTargetFragment() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_TIME, date);
        getTargetFragment()
                .onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
