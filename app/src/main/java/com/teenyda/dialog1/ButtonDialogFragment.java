package com.teenyda.dialog1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Administrator on 2018-07-29.
 */

public class ButtonDialogFragment extends DialogFragment {
    private DialogInterface.OnClickListener positiveCallback;

    private DialogInterface.OnClickListener negativeCallback;

    private String title;

    private String message;

    @Override
    public void show(FragmentManager manager, String tag) {
        show(manager,tag);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("title");
        builder.setMessage("message");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
         builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {

             }
         })  ;
        return super.onCreateDialog(savedInstanceState);
    }
}
