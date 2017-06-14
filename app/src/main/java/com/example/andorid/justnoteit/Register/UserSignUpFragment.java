package com.example.andorid.justnoteit.Register;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.andorid.justnoteit.R;
import com.example.andorid.justnoteit.database.userdata.UserLab;
import com.example.andorid.justnoteit.models.UserData;


public class UserSignUpFragment extends Fragment {

    private EditText mUserEmail;
    private EditText mUserPassword;
    private EditText mRetypePassword;
    private Button mSignUpButton;
    private UserData mUserData;




    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.user_sign_up_fragment,container,false);

        mUserData = new UserData();

        mUserEmail = (EditText)v.findViewById(R.id.user_sign_up_email);

        mUserPassword = (EditText)v.findViewById(R.id.user_sign_up_password);

        mRetypePassword = (EditText)v.findViewById(R.id.user_sign_up_reenter_password);

        mSignUpButton = (Button)v.findViewById(R.id.user_register_button);
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                String email = mUserEmail.getText().toString();
                String password = mUserPassword.getText().toString();
                String repass = mRetypePassword.getText().toString();

                if(repass.equals(password)){
                    mUserData.setUserEmail(email);
                    mUserData.setUserPassword(password);
                    createNewUser();
                    Snackbar.make(getView(),"Registered",Snackbar.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),"Password is not matching",Toast.LENGTH_SHORT)
                            .show();
                }


            }
        });



        return v;
    }

    private void createNewUser () {


        mUserData.getUserId();
        mUserData.getUserEmail();
        mUserData.getUserPassword();
        UserLab.get(getActivity()).addUser(mUserData);
    }


}
