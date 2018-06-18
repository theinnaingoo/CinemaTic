package skylark.intern.book.cinetic.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import skylark.intern.book.cinetic.BookingDetail;
import skylark.intern.book.cinetic.LoginActivity;
import skylark.intern.book.cinetic.Navigation;
import skylark.intern.book.cinetic.R;

import static android.content.Context.MODE_PRIVATE;


public class Login extends Fragment {


     SharedPreferences sp;
    EditText userN,userP;
    String userName,userPassword;
    Boolean isLogin = false;

    TextView register;
    Button login;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        login = view.findViewById(R.id.login);
        register =view.findViewById(R.id.register);

        userN =view.findViewById(R.id.username);
        userP = view.findViewById(R.id.userpassword);
        sp =  getActivity().getSharedPreferences("UserData", MODE_PRIVATE);

        String storedName = sp.getString("userName","no data");
        String storepassword = sp.getString("userpassword","no data");
        Boolean storeIsLogin = sp.getBoolean("isLogin",false);

        if (storeIsLogin.equals(true)){

            Intent i = new Intent(getActivity(), Navigation.class);
            startActivity(i);
        }




        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginActivity.viewPager.setCurrentItem(1);
                LoginActivity.tabLayout.getTabAt(1).select();
                View view1 = LoginActivity.tabLayout.getTabAt(1).getCustomView();

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = userN.getText().toString();
                userPassword = userP.getText().toString();
                isLogin =true;
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("UserData", MODE_PRIVATE).edit();
                editor.putString("userName",userName);
                editor.putString("userPassword",userPassword);
                editor.putBoolean("isLogin",isLogin);
                editor.commit();

                Intent i = new Intent(getActivity(), Navigation.class);
                startActivity(i);
            }
        });

        return view;

    }
}
