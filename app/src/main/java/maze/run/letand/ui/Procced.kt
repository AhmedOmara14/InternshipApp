package maze.run.letand.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_procced.*
import maze.run.letand.R

class Procced : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_procced)

        bb.setOnClickListener {
            finish()
        }
    }
}