package com.example.clinica_vitalistech

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clinica_vitalistech.databinding.FragmentPacienteBinding
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson

class PacienteFragment : Fragment(R.layout.fragment_paciente) {

    private var _b: FragmentPacienteBinding? = null
    private val b get() = _b!!

    private val adapter = PacienteAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _b = FragmentPacienteBinding.bind(view)

        b.rvPacientes.layoutManager = LinearLayoutManager(requireContext())
        b.rvPacientes.adapter = adapter

        // Carga datos desde archivo JSON local
        val listaPacientes = loadPacientesFromAssets(requireContext())
        adapter.submit(listaPacientes)

        b.progress.visibility = View.GONE
    }

    private fun loadPacientesFromAssets(context: Context): List<Paciente> {
        val jsonString = context.assets.open("patients.json").bufferedReader().use { it.readText() }
        return Gson().fromJson(jsonString, Array<Paciente>::class.java).toList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _b = null
    }
}
