package org.dalol.expandablerecyclerlist;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 10/29/2016
 */
public class MainController {

    private final Activity mActivity;

    public MainController(Activity activity) {
        mActivity = activity;
    }

    public void showAbout() {
        AlertDialog dialog = new AlertDialog.Builder(mActivity)
                .setTitle("About Developer")
                .setMessage("Filippo Engidashet")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(true)
                .create();
        dialog.show();
    }
}
