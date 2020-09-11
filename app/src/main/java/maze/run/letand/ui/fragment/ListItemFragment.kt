package maze.run.letsdevelopit.ui.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_list_item.view.*
import maze.run.letand.R
import maze.run.letand.pojo.ListItem
import maze.run.letand.ui.ShowItemOfList
import maze.run.letand.ui.adapter.AdapterForListItems


class ListItemFragment : Fragment() {
  lateinit var adapterForListItems:AdapterForListItems
   lateinit var listItems: ArrayList<ListItem>

    fun ListItemFragment(): ListItemFragment? {
        return ListItemFragment()
    }

    fun newInstance(): ListItemFragment? {
        return ListItemFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElementEnterTransition =
                TransitionInflater.from(context).inflateTransition(android.R.transition.slide_left)
        }
        var view = inflater.inflate(R.layout.fragment_list_item, container, false)
        val listItemFragmentArgs: ListItemFragmentArgs by navArgs()

        var item=listItemFragmentArgs.itemnam.toString()

        view.back.setOnClickListener {
            findNavController().navigate(R.id.action_listItemFragment_to_homeFragmentnav)
        }


        listItems= ArrayList()
        view.item_list.text=item.toString()
        if (item.toString().equals("Shampoo")) {
            listItems.add(
                ListItem(
                    "Head & Shoudler",
                    R.drawable.headershoulder,
                    "1L",
                    250.0,
                    "Head & Shoulders is America's #1 dandruff shampoo brand. Hair products range from shampoos, 2-in-1, conditioners to treatments - to get 100% flake free hair.",
                    "Head & Shoulders is America's #1 dandruff shampoo brand. Hair products range from shampoos, 2-in-1, conditioners to treatments - to get 100% flake free hair"
                )
            )

            listItems.add(
                ListItem(
                    "sunsilk",
                    R.drawable.sunsilk3,
                    "1L",
                    300.0,
                    "Head & Shoulders is America's #1 dandruff shampoo brand. Hair products range from shampoos, 2-in-1, conditioners to treatments - to get 100% flake free hair.",
                    "Head & Shoulders is America's #1 dandruff shampoo brand. Hair products range from shampoos, 2-in-1, conditioners to treatments - to get 100% flake free hair"
                )
            )


            listItems.add(
                ListItem(
                    "sunsilk",
                    R.drawable.sunsilk4,
                    "1L",
                    20.0,
                    "Head & Shoulders is America's #1 dandruff shampoo brand. Hair products range from shampoos, 2-in-1, conditioners to treatments - to get 100% flake free hair.",
                    "Head & Shoulders is America's #1 dandruff shampoo brand. Hair products range from shampoos, 2-in-1, conditioners to treatments - to get 100% flake free hair"
                )
            )

            listItems.add(
                ListItem(
                    "sunsilk",
                    R.drawable.sunsilk3,
                    "1.5L",
                    110.0,
                    "Head & Shoulders is America's #1 dandruff shampoo brand. Hair products range from shampoos, 2-in-1, conditioners to treatments - to get 100% flake free hair.",
                    "Head & Shoulders is America's #1 dandruff shampoo brand. Hair products range from shampoos, 2-in-1, conditioners to treatments - to get 100% flake free hair"
                )
            )

            listItems.add(
                ListItem(
                    "sunsilk",
                    R.drawable.sunsilk4,
                    "2L",
                    300.0,
                    "Head & Shoulders is America's #1 dandruff shampoo brand. Hair products range from shampoos, 2-in-1, conditioners to treatments - to get 100% flake free hair.",
                    "Head & Shoulders is America's #1 dandruff shampoo brand. Hair products range from shampoos, 2-in-1, conditioners to treatments - to get 100% flake free hair"
                )
            )
        }
        adapterForListItems= context?.let { AdapterForListItems(it) }!!
        adapterForListItems.setlist(listItems)

        view.mainGrid.adapter = adapterForListItems

        view.mainGrid.setOnItemClickListener(AdapterView.OnItemClickListener { parent, v, position, id -> // Send intent to SingleViewActivity

            Log.d(Companion.TAG, "onCreateView: " + listItems[position].name)
            Log.d(Companion.TAG, "onCreateView: " + listItems[position].Des)

            var intent: Intent = Intent(context, ShowItemOfList::class.java)
            intent.putExtra("name", listItems[position].name)
            intent.putExtra("img", listItems[position].image)
            intent.putExtra("des", listItems[position].Des)
            intent.putExtra("price", listItems[position].price)
            intent.putExtra("vol", listItems[position].volume)
            intent.putExtra("det", listItems[position].Details)

            requireContext().startActivity(intent)
        })


        return view
}


    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    companion object {
        private const val TAG = "ListItemFragment"
    }

}