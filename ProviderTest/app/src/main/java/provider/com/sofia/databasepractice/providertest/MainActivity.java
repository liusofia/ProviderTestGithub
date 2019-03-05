package provider.com.sofia.databasepractice.providertest;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private  String newId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addData = findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跨进程向databasepractice.sofia.com.database.DatabaseProvider添加数据
                //
                Uri uri = Uri.parse("content://databasepractice.sofia.com.database/book");
                ContentValues values = new ContentValues();
                values.put("name","a clash of kings");
                values.put("author","hahaji");
                values.put("pages",1040);
                values.put("price",22.85);
                //要insert添加的数据
                //解析内容URI,告诉向哪一个程序的哪张表添加数据
                Uri newUri = getContentResolver().insert(uri,values);
                newId = newUri.getPathSegments().get(1);
            }
        });
    }
}
