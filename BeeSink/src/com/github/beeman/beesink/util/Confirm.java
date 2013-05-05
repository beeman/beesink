package com.github.beeman.beesink.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

public class Confirm {

	private boolean confirmed = false;

	public boolean show(Context ctx, String title, String message, String yes, String no) {


		new AlertDialog.Builder(ctx).setIcon(android.R.drawable.ic_dialog_alert).setTitle(title).setMessage(message)
				.setPositiveButton(yes, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						setConfirmed(true);
					}

				}).setNegativeButton(no, null).show();

		return confirmed;
	}

	private void setConfirmed(boolean b) {
		confirmed = true;
	}

}
