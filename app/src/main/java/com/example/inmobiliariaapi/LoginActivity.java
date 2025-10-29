
package com.example.inmobiliariaapi;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import com.example.inmobiliariaapi.databinding.ActivityLoginBinding;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider; // <-- 1. IMPORT AGREGADO
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

    public class LoginActivity extends AppCompatActivity {

        private AppBarConfiguration mAppBarConfiguration;
        private ActivityLoginBinding binding;
        private LoginViewModel viewModel; // Declara el ViewModel aquí para usarlo en toda la clase

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityLoginBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            // Inicializa el ViewModel
            viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

            // Solicitar permiso en tiempo de ejecución (CORREGIDO)
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Se usa ActivityCompat.requestPermissions para una Activity
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 101);
            }

            setSupportActionBar(binding.toolbar);
            mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_login).build();
            NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.login_nav_host_fragment);
            NavController navController = navHostFragment.getNavController();
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        }

        @Override
        public void onResume() {
            super.onResume();
            // Inicia la detección cuando la actividad es visible (CORREGIDO)
            // Se usa `this` en lugar de `requireContext()`
            viewModel.iniciarDeteccionDeSacudida(this);
        }

        @Override
        public void onPause() {
            super.onPause();
            // Detiene la detección para no consumir batería cuando no está visible
            viewModel.detenerDeteccionDeSacudida();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            return true;
        }

        @Override
        public boolean onSupportNavigateUp() {
            NavController navController = Navigation.findNavController(this, R.id.login_nav_host_fragment);
            return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                    || super.onSupportNavigateUp();
        }
    }


