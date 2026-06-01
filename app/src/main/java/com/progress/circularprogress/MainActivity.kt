package com.progress.circularprogress

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.anim.circleanim.MyAnim
import com.anim.circleanim.R;
import com.anim.circleanim.Utils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        showWaitDialog()

//        var b = findViewById<MyAnim>(R.id.my_anim)
//        var button = findViewById<Button>(R.id.start_anim)
//
//        button.setOnClickListener {
//
//            b.startAnim()
//        }
    }

    private fun showWaitDialog() {

        val d = Dialog(this)
        d.setContentView(com.progress.circularprogress.R.layout.layout_dialog)

//        d.window?.setLayout(Utils.getScreenWidth(applicationContext)
//            ,(Utils.getScreenHeight(applicationContext)*0.20f).toInt())

        d.create()
        d.show()
    }
}