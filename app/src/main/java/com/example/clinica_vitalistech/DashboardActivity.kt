package com.example.clinica_vitalistech

import android.content.Intent
import android.widget.Button
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate


class DashboardActivity : AppCompatActivity() {

    private lateinit var pieChartSexo: PieChart
    private lateinit var barChartMedicos: BarChart
    private lateinit var lineChartMeses: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        val btnVolver = findViewById<Button>(R.id.btnVolverMenu)
        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish() // opcional: para cerrar el DashboardActivity
        }

        // Ajuste para padding de sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_dashboard)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar gráficos
        pieChartSexo = findViewById(R.id.pieChartSexo)
        barChartMedicos = findViewById(R.id.barChartMedicos)
        lineChartMeses = findViewById(R.id.lineChartMeses)

        // Cargar datos estáticos
        cargarGraficoSexo()
        cargarGraficoMedicos()
        cargarGraficoPacientesPorMes()
    }

    private fun cargarGraficoSexo() {
        val mujeres = 40
        val varones = 60

        val entries = listOf(
            PieEntry(mujeres.toFloat(), "Mujeres"),
            PieEntry(varones.toFloat(), "Varones")
        )

        val dataSet = PieDataSet(entries, "")
        dataSet.colors = listOf(Color.parseColor("#FF6384"), Color.parseColor("#36A2EB"))
        dataSet.sliceSpace = 4f
        dataSet.valueTextColor = Color.WHITE
        dataSet.valueTextSize = 16f

        val data = PieData(dataSet)

        pieChartSexo.data = data
        pieChartSexo.setUsePercentValues(true)
        pieChartSexo.description.isEnabled = false
        pieChartSexo.centerText = "Pacientes"
        pieChartSexo.setEntryLabelColor(Color.BLACK)
        pieChartSexo.setEntryLabelTextSize(14f)
        pieChartSexo.animateY(1000)
        pieChartSexo.invalidate()
    }

    private fun cargarGraficoMedicos() {
        val datos = listOf(
            BarEntry(0f, 20f),
            BarEntry(1f, 32f),
            BarEntry(2f, 15f),
            BarEntry(3f, 24f)
        )

        val etiquetas = listOf("Pérez", "Gómez", "Ruiz", "Martínez")

        val dataSet = BarDataSet(datos, "")
        dataSet.colors = ColorTemplate.COLORFUL_COLORS.toList()
        dataSet.valueTextColor = Color.BLACK
        dataSet.valueTextSize = 14f

        val data = BarData(dataSet)

        barChartMedicos.data = data
        barChartMedicos.description.isEnabled = false
        barChartMedicos.setFitBars(true)
        barChartMedicos.animateY(1000)

        val xAxis = barChartMedicos.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(etiquetas)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.granularity = 1f
        xAxis.labelRotationAngle = -15f

        barChartMedicos.axisRight.isEnabled = false
        barChartMedicos.invalidate()
    }

    private fun cargarGraficoPacientesPorMes() {
        val pacientesPorMes = listOf(120, 145, 132, 160, 180, 175, 200, 220, 210, 195, 185, 170)
        val meses = listOf(
            "Ene", "Feb", "Mar", "Abr", "May", "Jun",
            "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"
        )

        val entries = pacientesPorMes.mapIndexed { index, valor ->
            Entry(index.toFloat(), valor.toFloat())
        }

        val dataSet = LineDataSet(entries, "Pacientes")
        dataSet.color = Color.parseColor("#42A5F5")
        dataSet.circleRadius = 5f
        dataSet.setCircleColor(Color.parseColor("#1E88E5"))
        dataSet.valueTextSize = 12f
        dataSet.lineWidth = 3f

        val data = LineData(dataSet)

        lineChartMeses.data = data
        lineChartMeses.description.isEnabled = false
        lineChartMeses.animateX(1000)
        lineChartMeses.axisRight.isEnabled = false

        val xAxis = lineChartMeses.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(meses)
        xAxis.granularity = 1f
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)

        lineChartMeses.invalidate()
    }
}

