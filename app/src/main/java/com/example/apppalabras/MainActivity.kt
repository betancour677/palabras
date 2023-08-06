package com.example.apppalabras


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apppalabras.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var palabraAdapter: PalabraAdapter
    private val listaPalabras = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        palabraAdapter = PalabraAdapter(listaPalabras) { position ->
            val palabraSeleccionada = listaPalabras[position]
            val editarPalabraFragment = EditarPalabraFragment.newInstance(palabraSeleccionada)
            mostrarFragmento(editarPalabraFragment)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = palabraAdapter

        binding.btnAdd.setOnClickListener {
            listaPalabras.add("Palabra ${listaPalabras.size + 1}")
            palabraAdapter.notifyItemInserted(listaPalabras.size - 1)
        }
    }

    private fun mostrarFragmento(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}

