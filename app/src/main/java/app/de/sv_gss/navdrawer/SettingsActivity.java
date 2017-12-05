package app.de.sv_gss.navdrawer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class SettingsActivity extends PreferenceActivity
        implements Preference.OnPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        Preference aktienlistePref = findPreference(getString(R.string.preference_aktienliste_key));
        aktienlistePref.setOnPreferenceChangeListener(this);

        // onPreferenceChange sofort aufrufen mit der in SharedPreferences gespeicherten Aktienliste
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String gespeicherteAktienliste = sharedPrefs.getString(aktienlistePref.getKey(), "");
        onPreferenceChange(aktienlistePref, gespeicherteAktienliste);

    }

    @Override

    public boolean onPreferenceChange(Preference preference, Object value) {

        preference.setSummary(value.toString());

        return true;
    }
}
