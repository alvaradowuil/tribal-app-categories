package com.alvarado.tribaljob.presentation.acitivities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alvarado.tribaljob.R
import com.alvarado.tribaljob.presentation.viewmodel.states.MainStateResult
import com.alvarado.tribaljob.databinding.ActivityMainBinding
import com.alvarado.tribaljob.presentation.adapters.CategoriesAdapter
import com.alvarado.tribaljob.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setObservers()
        viewModel.getCategories()
    }

    private fun setObservers() {
        viewModel.state.observe(this) { state ->

            viewBinding.progressBar.visibility = View.GONE

            checkResult(state)
        }
    }

    private fun checkResult(state: MainStateResult) {
        when (state) {
            is MainStateResult.Success -> viewBinding.categoriesRecyclerView.apply {
                adapter = CategoriesAdapter(state.data)
            }
            is MainStateResult.Error -> Toast.makeText(applicationContext, state.message, Toast.LENGTH_SHORT).show()
            else -> {}
        }
    }
}