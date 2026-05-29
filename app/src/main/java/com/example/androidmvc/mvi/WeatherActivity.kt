package com.example.androidmvc.mvi

import androidx.appcompat.app.AppCompatActivity

class WeatherActivity : AppCompatActivity() {

    // 初始化ViewModel
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        // 监听状态变化，更新UI
        viewModel.weatherState.observe(this, Observer { state ->
            // 更新温度、湿度和天气状况的显示
            temperatureTextView.text = state.temperature.toString()
            humidityTextView.text = state.humidity.toString()
            conditionTextView.text = state.condition
        })

        // 刷新按钮点击事件
        refreshButton.setOnClickListener {
            // 发送刷新数据的意图
            viewModel.processIntent(ViewSE)
        }
    }
}
