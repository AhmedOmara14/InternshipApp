package maze.run.letand.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.liisitem_grid.view.*
import maze.run.letand.R
import maze.run.letand.pojo.ListItem

class AdapterForListItems  (var context: Context) : BaseAdapter() {
    var list = ArrayList<ListItem>()
    init {
        list = ArrayList()

    }
    fun setlist(data: ArrayList<ListItem>) {
        list = data
    }
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
          var view = LayoutInflater.from(parent?.context).inflate(
              R.layout.liisitem_grid,
            null
        )

        view.item_na.text = list[position].name
        Picasso.get().load(list[position].image).into(view.image_item)
        view.item_pric.text = list[position].price.toString()
        view.item_volume.text = list[position].volume

        return view
    }


}


