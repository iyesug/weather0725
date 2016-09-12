package com.vis.weather.util;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
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

import java.util.List;

/**
 * Created by GaoYu on 2016/9/5.
 */
public class DialogPlusUtil {
    private Context context;
    private int gravity=Gravity.BOTTOM;
    public DialogPlusUtil(Context context) {
        this.context = context;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public   void showdialog(List  mTitles, String title){

        DialogAdapter adapter = new DialogAdapter(context, false,mTitles);
        Holder vh=new ListHolder();
        final DialogPlus dialog = DialogPlus.newDialog(context)
                .setContentHolder(vh)
                .setHeader(R.layout.dialog_header)
                .setFooter(R.layout.footer)
                .setCancelable(true)
                .setGravity(gravity)
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
            showButtomDialog(clickedAppName, R.string.shortDay);
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
        mCameraDialog = new Dialog(context, R.style.Dialog);
        View root =mCameraDialog.getCurrentFocus();
        mAnimatorSet=new AnimatorSet();
        int mDuration = 500;
        mAnimatorSet.playTogether(
                ObjectAnimator.ofFloat(root, "rotationX", -390, 0).setDuration(mDuration/2*3),
                ObjectAnimator.ofFloat(root, "rotationY", -390, 0).setDuration(mDuration/5*6),
                ObjectAnimator.ofFloat(root, "rotation", 1080,720,360,0).setDuration(mDuration/4*5),
                ObjectAnimator.ofFloat(root, "alpha", 0, 1).setDuration(mDuration*3/2),
                ObjectAnimator.ofFloat(root, "scaleX", 0.1f, 0.5f, 1).setDuration(mDuration/4*7),
                ObjectAnimator.ofFloat(root,"scaleY",0.1f,0.5f,1).setDuration(mDuration/7*9)
        );
        mCameraDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {

                mAnimatorSet.start();


            }
        });
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
    AnimatorSet mAnimatorSet;
    Dialog mCameraDialog;
    public void showButtomDialog(CharSequence title, int message) {
        mCameraDialog = new Dialog(context, R.style.Dialog);
        LinearLayout root = (LinearLayout) LayoutInflater.from(context).inflate(
                R.layout.dialog_buttom, null);
        TextView tv_title= (TextView) root.findViewById(R.id.btn_open_camera);
        TextView tv_content= (TextView) root.findViewById(R.id.btn_choose_img);
        tv_title.setOnClickListener(btnlistener);
        tv_content.setOnClickListener(btnlistener);
        tv_title.setText(title);
        tv_content.setText(context.getText(message));
//        root.findViewById(R.id.btn_cancel).setOnClickListener(btnlistener);
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialogWindow.setWindowAnimations(R.style.dialogstyle); // 添加动画
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = -20; // 新位置Y坐标
        lp.width = (int) context.getResources().getDisplayMetrics().widthPixels; // 宽度
//      lp.height = WindowManager.LayoutParams.WRAP_CONTENT; // 高度
//      lp.alpha = 9f; // 透明度
        root.measure(0, 0);
//        lp.height = root.getMeasuredHeight();
        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
         mAnimatorSet=new AnimatorSet();
        int mDuration = 500;
        mAnimatorSet.playTogether(
                ObjectAnimator.ofFloat(root, "rotationX", -390, 0).setDuration(mDuration/2*3),
                ObjectAnimator.ofFloat(root, "rotationY", -390, 0).setDuration(mDuration/5*6),
                ObjectAnimator.ofFloat(root, "rotation", 1080,720,360,0).setDuration(mDuration/4*5),
                ObjectAnimator.ofFloat(root, "alpha", 0, 1).setDuration(mDuration*3/2),
                ObjectAnimator.ofFloat(root, "scaleX", 0.1f, 0.5f, 1).setDuration(mDuration/4*7),
                ObjectAnimator.ofFloat(root,"scaleY",0.1f,0.5f,1).setDuration(mDuration/7*9)
        );
        mCameraDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {

                mAnimatorSet.start();


            }
        });
        mCameraDialog.show();

    }
    private View.OnClickListener btnlistener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_open_camera: // 打开照相机
                    if (mCameraDialog != null) {
                        mCameraDialog.dismiss();
                    }
                    break;
                // 打开相册
                case R.id.btn_choose_img:
                    if (mCameraDialog != null) {
                        mCameraDialog.dismiss();
                    }
                    break;
//                // 取消
//                case R.id.btn_cancel:
//
//                    break;
            }
        }
    };
}
