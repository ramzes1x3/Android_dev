package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	Button signInButton;
	Intent mainActivity2;
	EditText inputUserPassword;
	EditText inputUserEmail;
	String password;
	String email;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		signInButton = findViewById(R.id.signInButton);
		inputUserPassword = findViewById(R.id.inputUserPassword);
		inputUserEmail = findViewById(R.id.inputUserEmail);

		signInButton.setOnClickListener(view -> {
			password = inputUserPassword.getText().toString();
			email = inputUserEmail.getText().toString();

			int emailIndexFound = findEmail(email);
			if (emailIndexFound != -1) {
				if (isPasswordCorrect(emailIndexFound)) {
					mainActivity2 = new Intent(this, MainActivity2.class);
					startActivity(mainActivity2);
				} else {
					Toast.makeText(this, "Incorrect password", Toast.LENGTH_SHORT).show();
				}
			} else {
				Toast.makeText(this, "Incorrect email", Toast.LENGTH_SHORT).show();
			}
		});
	}

	private int findEmail(String emailSearch) {
		String[] emails = getResources().getStringArray(R.array.emails);

		for (int i = 0; i < emails.length; i++) {
			if (emails[i].equals(emailSearch))
				return i;
		}
		return -1;
	}

	private boolean isPasswordCorrect(int emailIndex) {
		String[] passwords = getResources().getStringArray(R.array.passwords);

		return passwords[emailIndex].equals(password);
	}
}