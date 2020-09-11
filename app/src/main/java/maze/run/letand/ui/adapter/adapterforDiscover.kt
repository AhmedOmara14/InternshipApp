package maze.run.letand.ui.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import maze.run.letand.R
import maze.run.letand.pojo.DiscoverItem
import maze.run.letsdevelopit.ui.fragment.HomeFragment
import maze.run.letsdevelopit.ui.fragment.HomeFragmentDirections
import maze.run.letsdevelopit.ui.fragment.ListItemFragment

class adapterforDiscover(val conxt: Context) :
    RecyclerView.Adapter<adapterforDiscover.viewholder>() {

    var list = ArrayList<DiscoverItem>()
    lateinit var fragment1: HomeFragment

    init {
        list = ArrayList()
    }

    fun setlist(data: ArrayList<DiscoverItem>) {
        list = data
    }
    fun setfragment(fragment: HomeFragment) {
        fragment1 = fragment
    }



    inner class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView =itemView.findViewById(R.id.item_name)
        var imageView: CircleImageView =itemView.findViewById(R.id.item_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(
            LayoutInflater.from(conxt)
                .inflate(R.layout.listofdiscover, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {

        holder.textView.text=list.get(position).item.toString()
        Picasso.get().load(list.get(position).image).into(holder.imageView)
        holder.itemView.setOnClickListener {

            var action =
                HomeFragmentDirections.actionHomeFragmentnavToListItemFragment2(list.get(position).item)
            Navigation.findNavController(holder.itemView).navigate(action)

        }


    }

    companion object {
        private const val TAG = "adapterforplaces"
    }
}