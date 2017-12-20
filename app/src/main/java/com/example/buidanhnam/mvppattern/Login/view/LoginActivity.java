/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.example.buidanhnam.mvppattern.Login.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.buidanhnam.mvppattern.Login.LoginInteractorImpl;
import com.example.buidanhnam.mvppattern.Login.presenter.LoginPresenter;
import com.example.buidanhnam.mvppattern.Login.presenter.LoginPresenterImpl;
import com.example.buidanhnam.mvppattern.MainActivity;
import com.example.buidanhnam.mvppattern.R;


public class LoginActivity extends Activity implements LoginView, View.OnClickListener {

    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.edt_username);
        password = (EditText) findViewById(R.id.edt_pass);
        findViewById(R.id.btn_login).setOnClickListener(this);

        presenter = new LoginPresenterImpl(this,new LoginInteractorImpl());
    }

    @Override protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }


    @Override public void setUsernameError() {
        username.setError("Error ");
    }

    @Override public void setPasswordError() {
        password.setError("Error ");
    }

    @Override public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override public void onClick(View v) {
        presenter.checklogin(username.getText().toString(), password.getText().toString());
    }
}
