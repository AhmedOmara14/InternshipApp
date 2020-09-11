package maze.run.letsdevelopit.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_home.view.*
import maze.run.letand.R
import maze.run.letand.pojo.DiscoverItem
import maze.run.letand.ui.adapter.adapterforDiscover


class HomeFragment : Fragment() {
    private lateinit var adapterfordiscover: adapterforDiscover
    lateinit var discoverItem:ArrayList<DiscoverItem>

    fun HomeFragment(): HomeFragment? {
        return HomeFragment()
    }

    fun newInstance(): HomeFragment? {
        return HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_home, container, false)
 return view
    }

    companion object {
        private const val TAG = "HomeFragment"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.open.setOnClickListener {
           val drawerLayout: DrawerLayout =view.findViewById(R.id.drawer_layout)
            val navView: NavigationView = view.findViewById(R.id.nav)
            Log.d(TAG, "onCreateView: pppp")
           drawerLayout.openDrawer(navView)
        }

        discoverItem= ArrayList()
        discoverItem.add(DiscoverItem(R.drawable.shampoo, "Shampoo"))
        discoverItem.add(DiscoverItem(R.drawable.oil, "Oil"))
        discoverItem.add(DiscoverItem(R.drawable.biscuit, "Biscuit"))
        discoverItem.add(DiscoverItem(R.drawable.shampoo, "Shampoo"))
        view.rec_discover.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapterfordiscover= context?.let { adapterforDiscover(it) }!!
        adapterfordiscover.setlist(discoverItem)
        adapterfordiscover.setfragment(this)
        view.rec_discover.adapter=adapterfordiscover



    }
    fun get11(textview:TextView){
        val simpleFragmentB: ListItemFragment = ListItemFragment().newInstance()!!
        fragmentManager
            ?.beginTransaction() //      .addSharedElement(imageView, ViewCompat.getTransitionName(imageView))
            ?.addSharedElement(textview, ViewCompat.getTransitionName(textview)!!)
            ?.addToBackStack(TAG)
            ?.replace(R.id.content, simpleFragmentB)
            ?.commit()
    }

 }


