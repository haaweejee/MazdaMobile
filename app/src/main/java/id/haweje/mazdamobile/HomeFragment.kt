package id.haweje.mazdamobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var rvCars: RecyclerView
    private var list: ArrayList<CarsModel> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        rvCars = view.findViewById(R.id.rvItemCars)
        rvCars.setHasFixedSize(true)
        rvCars.layoutManager = LinearLayoutManager(view.context)
        val listCarsAdapter = ListCarsAdapter(list)
        rvCars.adapter = listCarsAdapter
        list.addAll(CarsData.listData)

        return view
        }
    }


