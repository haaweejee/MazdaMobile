package id.haweje.mazdamobile

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListCarsAdapter(private val listCars : ArrayList<CarsModel>) : RecyclerView.Adapter<ListCarsAdapter.ListCarsHolder>(), View.OnClickListener {


    inner class ListCarsHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var imageSelectColor : ImageView  = itemView.findViewById(R.id.img_cars_list)
        var tvName : TextView = itemView.findViewById(R.id.name_cars_list)
        var tvType : TextView = itemView.findViewById(R.id.type_cars_list)
        var tvPrice : TextView = itemView.findViewById(R.id.price_cars_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCarsAdapter.ListCarsHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_cars, parent, false)
        return ListCarsHolder(view)
    }

    override fun onBindViewHolder(holder: ListCarsAdapter.ListCarsHolder, position: Int) {
        val cars = listCars[position]

        holder.imageSelectColor.setImageResource(cars.carRedColors)
        holder.tvName.text = cars.carName
        holder.tvType.text = cars.carType
        holder.tvPrice.text = cars.carPrice

        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Kamu Memilih ${listCars[position].carName}  ${listCars[position].carType} ", Toast.LENGTH_SHORT).show()
            val intentDetail = Intent(holder.itemView.context,DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.CARS_NAME, cars.carName)
            intentDetail.putExtra(DetailActivity.CARS_TYPE, cars.carType)
            intentDetail.putExtra(DetailActivity.CARS_WEBS, cars.carWebs)
            intentDetail.putExtra(DetailActivity.CARS_BACKGROUND, cars.imgBackground)
            intentDetail.putExtra(DetailActivity.CARS_PRICE, cars.carPrice)
            intentDetail.putExtra(DetailActivity.CARS_BROSURE, cars.carBrocuhure)
            intentDetail.putExtra(DetailActivity.CARS_SPEC, cars.carSpecPage)
            intentDetail.putExtra(DetailActivity.CARS_REVIEW, cars.carReview)
            intentDetail.putExtra(DetailActivity.CARS_FEATURE, cars.carFeature)
            intentDetail.putExtra(DetailActivity.CARS_COLORS_RED, cars.carRedColors)
            intentDetail.putExtra(DetailActivity.CARS_COLORS_BLACK, cars.carBlackColors)
            intentDetail.putExtra(DetailActivity.CARS_COLORS_WHITE, cars.carWhiteColors)
            intentDetail.putExtra(DetailActivity.CARS_COLORS_GREY, cars.carGreyColors)
            intentDetail.putExtra(DetailActivity.CARS_TITLE_DESCRIPTION, cars.carTitleDescription)
            intentDetail.putExtra(DetailActivity.CARS_TEXT_DESCRIPTION, cars.carTextDescription)
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int {
        return listCars.size
    }

    override fun onClick(v: View?) {

    }

    private var carsFilter = listOf<CarsModel>()

    fun set(carsFilter: List<CarsModel>){
        this.carsFilter = carsFilter
        notifyDataSetChanged()
    }


}