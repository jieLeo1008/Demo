package com.jieleo.databindingdemo;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.jieleo.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Employee employee =new Employee(null, "永杰");
    User mUser =new User("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1502683680760&di=d4b3ac7f2fe49dfb96f4453de9ba80a9&imgtype=0&src=http%3A%2F%2Fimg08.mifile.cn%2Fv1%2FMI_18455B3E4DA706226CF7535A58E875F0267%2FT1oWhvBXdT1RXrhCrK.jpg");
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBinding.setEmployee(employee);

        mBinding.setPresenter(new Presenter());

        mBinding.setUser(mUser);

//        binding.setVariable(BR.employee,employee);
    }


    public class Presenter{

        public void onTextChanged(CharSequence s,int start,int before,int count){

            employee.setFirst_name(s.toString());

            mBinding.setEmployee(employee);

        }

        public void onClick(View view){
            Toast.makeText(MainActivity.this, "点到了", Toast.LENGTH_SHORT).show();
        }



        public void onClickListenerBinding(Employee employee){
            Toast.makeText(MainActivity.this, employee.last_name, Toast.LENGTH_SHORT).show();
        }


    }


}
