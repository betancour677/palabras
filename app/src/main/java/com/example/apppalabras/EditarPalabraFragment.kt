package com.example.apppalabras

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apppalabras.databinding.FragmentEditarPalabraBinding

class EditarPalabraFragment : Fragment() {

    private lateinit var binding: FragmentEditarPalabraBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditarPalabraBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener la palabra seleccionada del Bundle
        val palabraSeleccionada = arguments?.getString(ARG_PALABRA)

        // Mostrar la palabra en el EditText para editarla
        binding.editTextPalabra.setText(palabraSeleccionada)

        // Implementar la lógica para guardar la palabra editada
        binding.buttonGuardar.setOnClickListener {
            val palabraEditada = binding.editTextPalabra.text.toString()
            // Aquí puedes guardar la palabra editada en el RecyclerView
            // Por ejemplo, actualizando la lista y notificando al adaptador
            // listaPalabras[position] = palabraEditada
            // palabraAdapter.notifyItemChanged(position)
            requireActivity().onBackPressed() // Volver al RecyclerView después de guardar
        }
    }

    companion object {
        private const val ARG_PALABRA = "palabra"

        fun newInstance(palabra: String): EditarPalabraFragment {
            val fragment = EditarPalabraFragment()
            val args = Bundle()
            args.putString(ARG_PALABRA, palabra)
            fragment.arguments = args
            return fragment
        }
    }
}
