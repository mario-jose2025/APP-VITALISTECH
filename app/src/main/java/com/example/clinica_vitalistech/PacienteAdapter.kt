package com.example.clinica_vitalistech

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import java.text.NumberFormat
import java.util.Locale

class PacienteAdapter(private var items: List<Paciente> = emptyList())
    : RecyclerView.Adapter<PacienteAdapter.VH>() {

    fun submit(list: List<Paciente>) { items = list; notifyDataSetChanged() }

    class VH(v: View) : RecyclerView.ViewHolder(v) {

        val tvCodigo: TextView = v.findViewById(R.id.tvCodigo)

        val tvNombres: TextView = v.findViewById(R.id.tvNombres)

        val tvApellidos: TextView = v.findViewById(R.id.tvApellidos)

        val tvFechanav: TextView = v.findViewById(R.id.tvFechanav)

        val tvDireccion: TextView = v.findViewById(R.id.tvDireccion)

        val tvTelefono: TextView = v.findViewById(R.id.tvTelefono)

        val tvGenero: TextView = v.findViewById(R.id.tvGenero)
    }

    override fun onCreateViewHolder(p: ViewGroup, vt: Int): VH {
        val v = LayoutInflater.from(p.context).inflate(R.layout.item_paciente, p, false)
        return VH(v)
    }

    override fun onBindViewHolder(h: VH, pos: Int) {
        val it = items[pos]
        h.tvCodigo.text = it.Código
        h.tvNombres.text = it.Nombres
        h.tvApellidos.text = it.Apellidos
        h.tvFechanav.text = it.Fecha_nacimiento
        h.tvDireccion.text = it.Direccion
        h.tvTelefono.text = it.Telefono
        h.tvGenero.text = it.Genero
    }

    override fun getItemCount() = items.size
}
