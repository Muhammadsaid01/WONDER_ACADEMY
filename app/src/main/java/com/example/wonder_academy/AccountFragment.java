package com.example.wonder_academy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class AccountFragment extends Fragment {

    TextView txtUserName, txtEmail;
    Button btnLogout;

    public AccountFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);

        txtUserName = view.findViewById(R.id.txtUserName);
        txtEmail = view.findViewById(R.id.txtEmail);
        btnLogout = view.findViewById(R.id.btnLogout);

        // Login info user
        txtUserName.setText("wonder");
        txtEmail.setText("nms_2811@kangwon.ac.kr");

        // Logout → Welcome
        btnLogout.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Logged out!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getActivity(), Wellcome.class);
            startActivity(intent);
            getActivity().finish();
        });

        return view;
    }
}
