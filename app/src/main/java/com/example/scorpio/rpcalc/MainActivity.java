package com.example.scorpio.rpcalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = (EditText) findViewById(R.id.et_name);
        
    }
    /*显式意图：必须指定要激活的组件的完整包名和类名（应用程序之间偶合在一起）
    * 一般激活自己应用的组件的时候 采用显式意图
    * 
    * 隐式意图：只需要指定要动作和数据就可以（只好是应用程序之间没有耦合）
    * 激活别人写的应用 隐式意图，不许关心对方的包名和类名
    * */
    
    public void  enter(View view){
        String name =et_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)){
            Toast.makeText(this,"请输入姓名",Toast.LENGTH_SHORT).show();
            return;
        }
        //意图 砸电视 杀人 冒泡
        Intent intent = new Intent(this,CalcActivity.class);
        intent.putExtra("name",name);
        //显式意图
        //intent.setClassName(getPackageName(),"com.example.scorpio.rpcalc.CalcActivity");//不指定动作，也不指定数据，直接指定要激活的组件
        startActivity(intent);
        //隐式意图
        //intent.setAction(action);
        //intent.setData(data);
    }
}
