/*
 * Copyright 2013 Niek Haarman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vis.weather.view;

import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vis.weather.R;
import com.vis.weather.view.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Advice_Activity extends BaseActivity {
	private Button commit;
	@BindView(R.id.body)
	EditText et_body;
	@BindView(R.id.contact)
	EditText et_contact;
	@BindView(R.id.time)
	 TextView  tv_time;
	private Thread thread;
	private String   body, date, contact;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_advice);
		ButterKnife.bind(this);

		Time time = new Time();
		time.setToNow();
		int year = time.year;
		int month = time.month+1;
		int day = time.monthDay;
		int minute = time.minute;
		int hour = time.hour;
		int sec = time.second;
//		date = "当前时间为：" + year + "年 " + month + "月 " + day + "日 " + hour + "时 " + minute + "分 " + sec + "秒";
		date = time.format("%Y-%m-%d %H:%M:%S");
		tv_time.setText(date);

		setToolbar();

	}

	public void onClick(View v) {

		// commit.setEnabled(false);
		// commit.setText("已发送");


		body = et_body.getText().toString().trim();
		contact = et_contact.getText().toString().trim();
		if ( "".equals(body)|| "".equals(contact)) {
			

			Toast.makeText(Advice_Activity.this, "联系方式或内容不能为空！", Toast.LENGTH_SHORT).show();
			return;
		}





		Toast.makeText(Advice_Activity.this, "已发送", Toast.LENGTH_SHORT).show();
		Advice_Activity.this.finish();
	}

}