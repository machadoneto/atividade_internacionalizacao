package br.unisinos.jeff.atividade_01;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private String lang = "pt-br";
    private Locale locale;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_pt = (Button) findViewById(R.id.bt_pt);
        Button bt_en = (Button) findViewById(R.id.bt_en);
        Button bt_es = (Button) findViewById(R.id.bt_es);

        bt_pt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lang = "pt-br";
                mudarLang(lang);
                Intent intent = getIntent();
                finish();
                overridePendingTransition(0, 0);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        bt_en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lang = "en";
                mudarLang(lang);
                Intent intent = getIntent();
                finish();
                overridePendingTransition(0, 0);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        bt_es.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lang = "es";
                mudarLang(lang);
                Intent intent = getIntent();
                finish();
                overridePendingTransition(0, 0);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

            }
        });

        carregaLocale();

    }

    public void mudarLang(String lang) {
        if (lang.equalsIgnoreCase("")) {
            return;
        }
        locale = new Locale(lang);
        salvarLocale(lang);
        Locale.setDefault(locale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        onRestart();
    }

    public void salvarLocale(String lang)
    {
        String langPref = "Language";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(langPref, lang);
        editor.commit();
    }

    public void carregaLocale()
    {
        String langPref = "Language";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        String language = prefs.getString(langPref, "");
        mudarLang(language);
    }
}
