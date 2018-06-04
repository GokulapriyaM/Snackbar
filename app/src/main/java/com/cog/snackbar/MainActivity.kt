package com.cog.snackbar

import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        btn1.setOnClickListener(View.OnClickListener { v -> Snackbar.make(v, "Normal Snackbar", Snackbar.LENGTH_LONG).show() })
        btn2.setOnClickListener(View.OnClickListener { v -> Snackbar.make(v, "Snackbar with Action", Snackbar.LENGTH_LONG).setAction("UNDO") { view -> Snackbar.make(view, "Action!", Snackbar.LENGTH_SHORT).show() }.setActionTextColor(Color.RED).show() })
        btn5.setOnClickListener(View.OnClickListener { v ->
            val mSnackBar = Snackbar.make(v, "TOP SNACKBAR", Snackbar.LENGTH_LONG)
            val view = mSnackBar.view
            val params = view.layoutParams as FrameLayout.LayoutParams
            params.gravity = Gravity.TOP
            view.layoutParams = params
            view.setBackgroundColor(Color.RED)
            val mainTextView = view.findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
            mainTextView.setTextColor(Color.WHITE)
            mSnackBar.show()
        })
        btn4.setOnClickListener(View.OnClickListener { v ->
            val mSnackBar = Snackbar.make(v, "Custom Color", Snackbar.LENGTH_LONG)

            val mainTextView = mSnackBar.view.findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
            val actionTextView = mSnackBar.view.findViewById<View>(android.support.design.R.id.snackbar_action) as TextView

            // To Change Snackbar Color
            mSnackBar.view.setBackgroundColor(Color.WHITE)

            // To Apply Custom Fonts for Message and Action
            val font = Typeface.createFromAsset(assets, "Lato-Regular.ttf")
            // profileJsonmain?.typeface = fontUtility?.regular
            mainTextView.typeface = font
            actionTextView.typeface = font

            // To Change Text Color for Message and Action
            mainTextView.setTextColor(Color.BLACK)
            actionTextView.setTextColor(Color.BLACK)

            mSnackBar.setAction("UNDO") { view -> Snackbar.make(view, "Action!", Snackbar.LENGTH_SHORT).show() }
            mSnackBar.show()
        })
        btn3.setOnClickListener(View.OnClickListener { v ->
            val mSnackBar = Snackbar.make(v, "Snackbar with Custom Gravity", Snackbar.LENGTH_LONG)
            val mainTextView = mSnackBar.view.findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
                mainTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
            else
                mainTextView.gravity = Gravity.CENTER_HORIZONTAL
            mainTextView.gravity = Gravity.CENTER_HORIZONTAL
            mSnackBar.show()
        })

    }

}
