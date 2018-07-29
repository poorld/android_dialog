package com.teenyda.dialog1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.teenyda.bean.Tip;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button simpleDialog;
    private Button simpleListDialog;
    private Button singleChoiceDialog;
    private Button multiChoiceDialog;
    private Button customAdapterDialog;
    private Button customViewDialog;
    //声明一个AlertDialog构造器
    private AlertDialog.Builder builder;

    private Myadapter adapter;

    private List<Tip> tips;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化控件
        simpleDialog = (Button) findViewById(R.id.btn_simpleDialog);
        simpleListDialog = (Button) findViewById(R.id.btn_simpleListDialog);
        singleChoiceDialog = (Button) findViewById(R.id.btn_singleChoiceDialog);
        multiChoiceDialog = (Button) findViewById(R.id.btn_multiChoiceDialog);
        customAdapterDialog = (Button) findViewById(R.id.btn_customAdapterDialog);
        customViewDialog = (Button) findViewById(R.id.btn_customViewDialog);

        //设置监听事件
        simpleDialog.setOnClickListener(this);
        simpleListDialog.setOnClickListener(this);
        singleChoiceDialog.setOnClickListener(this);
        multiChoiceDialog.setOnClickListener(this);
        customAdapterDialog.setOnClickListener(this);
        customViewDialog.setOnClickListener(this);
    }

    private class Myadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return tips.size();
        }

        @Override
        public Object getItem(int position) {
            return tips.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Tip tip = tips.get(position);
            View view = View.inflate(getApplicationContext(), R.layout.custom_adapter, null);
            ImageView iv = view.findViewById(R.id.iv_icon);
            iv.setImageResource(tip.getImageId());

            TextView tv = view.findViewById(R.id.tv_tip);
            tv.setText(tip.getMessage());
            return view;
        }
    }


    /**
     * 显示基本对话框测试
     * @param v
     */
    public void showDialog(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //标题
        builder.setTitle("提示");
        //图标
        builder.setIcon(R.drawable.icon);
        //下方按钮
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "点击确定按钮", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "点击取消按钮", Toast.LENGTH_SHORT).show();
            }
        });
        //内容
        builder.setMessage("你好啊！");

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_simpleDialog:
                showSimpleDialog(v);
                break;
            case R.id.btn_simpleListDialog:
                showSimpleListDialog(v);
                break;
            case R.id.btn_singleChoiceDialog:
                showSingleChoiceDialog(v);
                    break;
            case R.id.btn_multiChoiceDialog:
                showMultiChoiceDialog(v);
                break;
            case R.id.btn_customAdapterDialog:
                showCustomAdapterDialog(v);
                break;
            case R.id.btn_customViewDialog:
                showCustomViewDialog(v);
                break;
        }
    }

    /**
     * 显示简单的对话框
     * @param v
     */
    private void showSimpleDialog(View v) {
        builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.icon);
        builder.setTitle("提示");
        builder.setMessage("这是一个简单的提示框");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.toast_postive, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.toast_negative, Toast.LENGTH_SHORT).show();
            }
        });
        //设置对话框可取消
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * 显示list对话框
     * @param v
     */
    private void showSimpleListDialog(View v) {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        final String[] items = {"java", "vue.js", "google"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "你点击了" + items[which], Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * 显示单选对话框
     * @param v
     */
    private void showSingleChoiceDialog(View v) {
        builder = new AlertDialog.Builder(this);//使用getApplicationContext()闪退
        builder.setTitle("提示");
        final String[] items = {"java", "vue.js", "google"};
        //第二个参数 checkItem 为默认选中项
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "你点击了" + items[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * 显示多选对话框
     * @param v
     */
    private void showMultiChoiceDialog(View v) {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        final String[] items = {"java", "vue.js", "google"};
        builder.setMultiChoiceItems(items, new boolean[]{false,false,false}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(getApplicationContext(), "你选中了" + items[which], Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "你取消了" + items[which], Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    /**
     * 显示自定义adapter的对话框
     * @param v
     */
    private void showCustomAdapterDialog(View v) {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("tip");
        adapter = new Myadapter();
        tips = new ArrayList<Tip>();
        Tip t1 = new Tip();
        t1.setImageId(R.drawable.icon);
        t1.setMessage("c++");
        tips.add(t1);

        Tip t2 = new Tip();
        t2.setImageId(R.drawable.icon);
        t2.setMessage("c#");
        tips.add(t2);

        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "你点击了" +tips.get(which).getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * 显示自定义的视图对话框
     * @param v
     */
    private void showCustomViewDialog(View v) {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("登录");
        View view = View.inflate(this,R.layout.custom_view,null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
