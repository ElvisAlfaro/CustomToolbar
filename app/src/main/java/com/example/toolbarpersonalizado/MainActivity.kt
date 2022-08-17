package com.example.toolbarpersonalizado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var tvStatusSignal : TextView
    lateinit var btnBack : ImageView
    lateinit var tvTitleToolbar : TextView
    lateinit var menuGallery : ImageView
    lateinit var menuShare : ImageView

    var onLine = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initListener()
    }

    private fun initViews() {
        tvStatusSignal = findViewById(R.id.tv_status_signal)
        btnBack = findViewById(R.id.btn_back)
        tvTitleToolbar = findViewById(R.id.tv_title_toolbar)
        menuGallery = findViewById(R.id.menu_gallery_toolbar)
        menuShare = findViewById(R.id.menu_share_toolbar)
    }

    private fun initListener() {
        tvStatusSignal.setOnClickListener {
            if (onLine) {
                onLine = false
                tvStatusSignal.setBackgroundResource(android.R.color.holo_green_light)
                tvStatusSignal.setText("Modo OnLine...")
            } else {
                onLine = true
                tvStatusSignal.setBackgroundResource(android.R.color.holo_red_dark)
                tvStatusSignal.setText("Modo OffLine...")
            }
        }

        btnBack.setOnClickListener {
            finish()
        }

        menuGallery.setOnClickListener {
            Snackbar.make(tvStatusSignal, "Opening Gallery...", Snackbar.LENGTH_SHORT).show()
        }

        menuShare.setOnClickListener {
            Snackbar.make(tvStatusSignal, "Sharing Files...", Snackbar.LENGTH_SHORT).show()
        }
    }
}