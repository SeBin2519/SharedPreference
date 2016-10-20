package kr.hs.emirim.sebin2519.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editName,editAge;
    SharedPreferences sp; //앱의 셋팅(설정)

    @Override
    protected void onCreate(Bundle savedInstanceState) { //액티비티가 처음 실행될때 호출
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName=(EditText)findViewById(R.id.edit_name);
        editAge=(EditText)findViewById(R.id.edit_age);
        sp=getSharedPreferences("appInfo", Context.MODE_PRIVATE);//파일이름,모드
    }

    @Override
    protected void onResume() { //액티비티가 다시 실행될때(나타날때) 호출
        super.onResume();
        String name=sp.getString("name","");//있으면 name, 없으면 default string 반환
        String age=sp.getString("age","");
        editName.setText(name);
        editAge.setText(age);
    }

    @Override
    protected void onStop() { //액티비티가 화면이 바뀔때 호출 ==>마지막으로 입려된 값 저장
        super.onStop();
        SharedPreferences.Editor edit= sp.edit();//에디터의 참조값을 반환
        edit.putString("name",editName.getText().toString());//입력된 값을 key로 저장
        edit.putString("age",editAge.getText().toString());
        edit.commit();//적용시키기 => 실제로 저장
    }
}
