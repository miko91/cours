package com.example.exemple;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	private TextView txtNom;
	private TextView txtMessage;
	private EditText editNom;
	private Button btValider;
	private Button btApp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Programmation des objets graphiques
		this.txtNom = (TextView)findViewById(R.id.idNom);
		this.txtMessage = (TextView)findViewById(R.id.Message);
		this.editNom = (EditText)findViewById(R.id.ideditNom);
		this.btValider = (Button)findViewById(R.id.idValider);
		this.btApp = (Button)findViewById(R.id.About);
		this.txtNom.setText("Votre pr�nom :");
		this.txtMessage.setText("");
		
		// Rendre le bouton clickable
		this.btValider.setOnClickListener(this);
		this.btApp.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.idValider) {
			String prenom = this.editNom.getText().toString();
			this.txtMessage.setText("Bienvenue " + prenom);
		} else if(v.getId() == R.id.About) {
			Intent unIntent = new Intent(this, About.class);
			
			startActivity(unIntent);
		}
	}

}
