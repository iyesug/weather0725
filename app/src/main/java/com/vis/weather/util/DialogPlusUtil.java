package com.vis.weather.util;

import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.Holder;
import com.orhanobut.dialogplus.ListHolder;
import com.orhanobut.dialogplus.OnCancelListener;
import com.orhanobut.dialogplus.OnClickListener;
import com.orhanobut.dialogplus.OnDismissListener;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.vis.weather.R;
import com.vis.weather.presenter.DialogAdapter;

/**
 * Created by GaoYu on 2016/9/5.
 */
public class DialogPlusUtil {
    private Context context;

    public DialogPlusUtil(Context context) {
        this.context = context;
    }

    public   void showdialog(String[] mTitles,String title){


        DialogAdapter adapter = new DialogAdapter(context, false,mTitles);
        Holder vh=new ListHolder();
        final DialogPlus dialog = DialogPlus.newDialog(context)
                .setContentHolder(vh)
                .setHeader(R.layout.dialog_header)
                .setFooter(R.layout.footer)
                .setCancelable(true)
                .setGravity(Gravity.BOTTOM)
                .setAdapter(adapter)
                .setOnClickListener(clickListener)
                .setOnItemClickListener(itemClickListener)
//                        new OnItemClickListener() {
//                    @Override public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
//                        Log.d("DialogPlus", "onItemClick() called with: " + "item = [" +
//                                item + "], position = [" + position + "]");
//                    }
//                }


                .setOnDismissListener(dismissListener)
                .setExpanded(true)
//        .setContentWidth(800)
                .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                .setOnCancelListener(cancelListener)
                .setOverlayBackgroundResource(android.R.color.transparent)
//        .setContentBackgroundResource(R.drawable.corner_background)
                //                .setOutMostMargin(0, 100, 0, 0)
                .create();

        TextView titleString=(TextView)vh.getHeader().findViewById(R.id.title);
        titleString.setText(title);
        dialog.show();
    }


    OnClickListener clickListener = new OnClickListener() {
        @Override
        public void onClick(DialogPlus dialog, View view) {
//                    switch (view.getId()) {
//                      case R.id.header_container:
////                        Toast.makeText(context, "Header clicked", Toast.LENGTH_LONG).show();
//                        break;
////                      case R.id.like_it_button:
////                        Toast.makeText(context, "We're glad that you like it", Toast.LENGTH_LONG).show();
////                        break;
////                      case R.id.love_it_button:
////                        Toast.makeText(context, "We're glad that you love it", Toast.LENGTH_LONG).show();
////                        break;
////                      case R.id.footer_confirm_button:
////                        Toast.makeText(context, "Confirm button clicked", Toast.LENGTH_LONG).show();
////                        break;
//                      case R.id.footer_close_button:
////                        Toast.makeText(context, "Close button clicked", Toast.LENGTH_LONG).show();
//                        break;
//                    }
                    dialog.dismiss();
        }
    };

    OnItemClickListener itemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
            TextView textView = (TextView) view.findViewById(R.id.text_view);
            String clickedAppName = textView.getText().toString();
                    dialog.dismiss();
            showMessageDialog(clickedAppName, R.string.shortDay);
        }
    };

    OnDismissListener dismissListener = new OnDismissListener() {
        @Override
        public void onDismiss(DialogPlus dialog) {
//                    Toast.makeText(context, "dismiss listener invoked!", Toast.LENGTH_SHORT).show();
        }
    };

    OnCancelListener cancelListener = new OnCancelListener() {
        @Override
        public void onCancel(DialogPlus dialog) {
//                    Toast.makeText(context, "cancel listener invoked!", Toast.LENGTH_SHORT).show();
        }
    };






    public void showMessageDialog(int title, int message) {
        showMessageDialog(context.getText(title), context.getText(message));
    }

    public void showMessageDialog(int title, CharSequence message) {
        showMessageDialog(context.getText(title), message);
    }

    public void showMessageDialog(CharSequence title, int message) {
        showMessageDialog(title, context.getText(message));
    }

    public void showMessageDialog(CharSequence title, CharSequence message) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.know, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}
