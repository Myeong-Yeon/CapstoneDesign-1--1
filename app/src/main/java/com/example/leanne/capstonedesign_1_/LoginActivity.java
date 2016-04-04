package com.example.leanne.capstonedesign_1_;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by imsuyeon on 16. 4. 2..
 */
public class LoginActivity extends Fragment implements View.OnClickListener {
    Button buttonLogin;
    TextView textViewRegister, textViewFindPW;
    EditText editTextID, editTextPW;

    private View mainView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.activity_login, container, false);
        initView(mainView);

        return mainView;
    }

    private void initView(View v) {
        buttonLogin = (Button) v.findViewById(R.id.button_login);
        textViewRegister = (TextView) v.findViewById(R.id.register);
        textViewFindPW = (TextView) v.findViewById(R.id.find_password);
        editTextID = (EditText) v.findViewById(R.id.login_id);
        editTextPW = (EditText) v.findViewById(R.id.login_password);
        buttonLogin.setOnClickListener(this);
        textViewRegister.setOnClickListener(this);
        textViewFindPW.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                String id = editTextID.getText().toString();
                String pw = editTextPW.getText().toString();

                // temp
                String dbID = "root";
                String dbPW = "root";
                // end temp

                if (id.equals("") || pw.equals("")) {
                    Toast.makeText(getActivity(), "아이디 혹은 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (id.equals(dbID) && pw.equals(dbPW)) {
                    Toast.makeText(getActivity(), "로그인 성공!", Toast.LENGTH_SHORT).show();
                    Intent intentHome = new Intent(getActivity(), HomeActivity.class);
                    startActivity(intentHome);
                    getActivity().overridePendingTransition(R.anim.animation_enter_right2left,
                            R.anim.animation_leave_right2left);
                    editTextID.setText("");
                    editTextPW.setText("");
                } else {
                    Toast.makeText(getActivity(), "아이디 혹은 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    editTextID.setText("");
                    editTextPW.setText("");
                }
                break;
        }
    }
}
