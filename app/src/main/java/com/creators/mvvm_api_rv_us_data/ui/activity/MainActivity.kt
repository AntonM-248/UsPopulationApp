package com.creators.mvvm_api_rv_us_data.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.creators.mvvm_api_rv_us_data.R
import com.creators.mvvm_api_rv_us_data.databinding.ActivityMainBinding
import com.creators.mvvm_api_rv_us_data.ui.adapter.PopulationAdapter
import com.creators.mvvm_api_rv_us_data.ui.view_model.PopulationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val TAG = "Main Activity"

    private val viewModel: PopulationViewModel by viewModels()

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PopulationAdapter(emptyList())
        val censusRv = binding.censusData
        val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        censusRv.addItemDecoration(dividerItemDecoration)
        censusRv.layoutManager = LinearLayoutManager(this)
        censusRv.adapter = adapter
        viewModel.populationData.observe(this) { data ->
            Log.d(TAG, data.toString())
            adapter.updateData(data)
        }
        viewModel.getPopulationData()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}