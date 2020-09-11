package maze.run.letand.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_show_item_of_list.*
import maze.run.letand.R

class ShowItemOfList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_item_of_list)

        var border = intent.extras
        var name1 = border?.get("name").toString()
        var img1 = border?.get("img")
        var des1 = border?.get("des").toString()
        var pri1 = border?.get("price").toString()
        var vol1 = border?.get("vol").toString()
        var det = border?.get("det").toString()


        name.text = name1.toString()
        des.text = des1.toString()
        Picasso.get().load(img1.toString()).into(image_nam)
        details.text = det.toString()
        pri.text = pri1
        vol.text = vol1

        backto.setOnClickListener {
            finish()
        }
    }
}