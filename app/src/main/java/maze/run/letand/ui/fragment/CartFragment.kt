package maze.run.letsdevelopit.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_cart.view.*
import maze.run.letand.R
import maze.run.letand.ui.Procced


class CartFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_cart, container, false)

        view.procced.setOnClickListener {
            var intent:Intent= Intent(context,Procced::class.java)
            context?.startActivity(intent)
        }
        view.plus.setOnClickListener {
            var i:Int =Integer.parseInt(view.num.text.toString())
            if (i>0){
                i++
            }
            view.num.text=i.toString()
        }


        view.moins.setOnClickListener {
            var i:Int =Integer.parseInt(view.num.text.toString())
            if (i>1){
                i--
            }
            view.num.text=i.toString()
        }
        return view
    }

}