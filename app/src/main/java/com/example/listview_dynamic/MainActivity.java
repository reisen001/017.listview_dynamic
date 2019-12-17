package com.example.listview_dynamic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       show = (TextView) findViewById(R.id.textView_show);
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<CharSequence> arrAdap = ArrayAdapter.createFromResource(MainActivity.this, R.array.list,  //設定清單內容資訊
                android.R.layout.simple_list_item_single_choice); //設定列表選項格式
        listView.setAdapter(arrAdap); //將設定好的 ArrayAdapter 丟進 ListView
        //lsv_main.setSelector(R.drawable.green); //改變選取項目的背景色為圖片
        //listView.setSelection(2); //ListView 預設會選取第3筆資料
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE); //設定列表選擇模式(單選)
        listView.setOnItemClickListener(listViewRegionOnItemClick);
    }
    private AdapterView.OnItemClickListener listViewRegionOnItemClick
            = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // TODO Auto-generated method stub

            show.setText("你選擇了: " + ((TextView) view).getText());
        }
    };
}
