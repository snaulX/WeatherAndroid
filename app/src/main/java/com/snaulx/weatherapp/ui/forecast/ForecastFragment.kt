package com.snaulx.weatherapp.ui.forecast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.snaulx.weatherapp.api.OpenWeather
import com.snaulx.weatherapp.databinding.FragmentForecastBinding
import retrofit2.Retrofit

class ForecastFragment : Fragment() {

    private var _binding: FragmentForecastBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build()
        val weatherService = retrofit.create(OpenWeather::class.java)

        val homeViewModel =
            ViewModelProvider(this).get(ForecastViewModel::class.java)

        _binding = FragmentForecastBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}