package com.chao.createcode;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private ImageView iv_showCode;
	private EditText et_phoneCode;
	private EditText et_phoneNum;
	//��������֤��
	private String realCode;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		et_phoneCode = (EditText) findViewById(R.id.et_phoneCodes);
		Button but_toSetCode = (Button) findViewById(R.id.but_forgetpass_toSetCodes);
		but_toSetCode.setOnClickListener(this);
		iv_showCode = (ImageView) findViewById(R.id.iv_showCode);
		//����֤����ͼƬ����ʽ��ʾ����
		iv_showCode.setImageBitmap(Code.getInstance().createBitmap());
		realCode = Code.getInstance().getCode();
		Log.i("��֤��",realCode);
		iv_showCode.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.iv_showCode:
			iv_showCode.setImageBitmap(Code.getInstance().createBitmap());
			realCode = Code.getInstance().getCode();
			Log.i("��֤��",realCode);
			break;

		case R.id.but_forgetpass_toSetCodes:
			
			String phoneCode = et_phoneCode.getText().toString();
			if(phoneCode.equals(realCode)){
				Toast.makeText(MainActivity.this, phoneCode+"��֤����ȷ", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(MainActivity.this, phoneCode+"��֤�����", Toast.LENGTH_SHORT).show();
			}
			
			break;
		}
		
		
	}


}
