package com.vis.weather.table;

import android.os.Bundle;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.inqbarna.tablefixheaders.TableFixHeaders;
import com.vis.weather.R;
import com.vis.weather.presenter.GetOnlineData;

public class QuanzhouCityTableActivity extends StyleTableActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        ButterKnife.bind(this);
        TextView title = setToolbar();
        title.setText("泉州气象");

        tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
        tableFixHeaders.setAdapter(new MyAdapter(QuanzhouCityTableActivity.this));


        GetOnlineData.getOnline7Day(observerDaily, null, station);
        GetOnlineData.getStationList(observerList, "12", null);

    }

}
