package com.leonestudios.puppiesgram;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;
import com.leonestudios.puppiesgram.adapter.PageAdapter;
import com.leonestudios.puppiesgram.pojo.Mascota;
import com.leonestudios.puppiesgram.vista.fragment.MascotaFragment;
import com.leonestudios.puppiesgram.vista.fragment.MascotasFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lstMilista;
    ArrayList<Mascota> mascotas;

    private Toolbar toolbarm;
    private TabLayout tabLayoutm;
    private ViewPager viewPagerm;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarm = (Toolbar) findViewById(R.id.toolbarm);
        tabLayoutm = (TabLayout) findViewById(R.id.tabLayoutm);
        viewPagerm = (ViewPager) findViewById(R.id.viewPagerm);

        setUpViewPager();

        if (toolbarm != null){
            setSupportActionBar(toolbarm);
        }

        lstMilista = (ListView) findViewById(R.id.lstMilista);
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMilista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas));

        sfiMiIndicadorRefresh = (SwipeRefreshLayout) findViewById(R.id.sfiMiIndicadorRefresh);
        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });
    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new MascotasFragment());
        fragments.add(new MascotaFragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPagerm.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments(), behavior()));
        tabLayoutm.setupWithViewPager(viewPagerm);
        tabLayoutm.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);
        tabLayoutm.getTabAt(1).setIcon(R.drawable.ic_baseline_pets_24);
    }

    private int behavior() {
        return 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mFavorito:
                Intent intent = new Intent(MainActivity.this, ListaFavoritos.class);
                intent.putExtra("mymascotas", mascotas);
                startActivity(intent);
                finish();
                break;
            case R.id.mContacto:
                Intent intentc = new Intent(MainActivity.this, ContactoActivity.class);
                startActivity(intentc);
                finish();
                break;
            case R.id.mAbout:
                Intent intenta = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intenta);
                finish();
                break;
            case R.id.mListado:
                Intent intente = new Intent(MainActivity.this, ListadoMascotas.class);
                startActivity(intente);
                finish();
                break;
            case R.id.mNotificaciones:
                Intent intento = new Intent(MainActivity.this, NotificacionActivity.class);
                startActivity(intento);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    public void refrescandoContenido(){
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMilista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas));
        sfiMiIndicadorRefresh.setRefreshing(false);
    }
}