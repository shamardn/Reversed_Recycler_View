package com.shamardn.reverserecyclerviewinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import com.shamardn.reverserecyclerviewinkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter
    private var items = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainAdapter = MainAdapter(items)

        binding.mainRv.adapter = mainAdapter

        binding.mainEt.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEND){
                val message = binding.mainEt.text.trim()
                if(!message.isBlank()){
                    items.add(message.toString())
                    mainAdapter.notifyDataSetChanged()
                    binding.mainEt.text.clear()
                }
            }
            true
        }
    }


}