package id.haweje.mazdamobile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.button.MaterialButton
import de.hdodenhof.circleimageview.CircleImageView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val CARS_NAME = "cars_name"
        const val CARS_TYPE = "cars_type"
        const val CARS_PRICE = "cars_price"
        const val CARS_BACKGROUND = "cars_background"
        const val CARS_COLORS_RED = "red_colors"
        const val CARS_COLORS_BLACK = "black_colors"
        const val CARS_COLORS_GREY = "grey_colors"
        const val CARS_COLORS_WHITE = "white_colors"
        const val CARS_TITLE_DESCRIPTION = "title_desc"
        const val CARS_TEXT_DESCRIPTION = "text_desc"
        const val CARS_WEBS = "text_webs"
        const val CARS_BROSURE = "brosure"
        const val CARS_SPEC = "spefication"
        const val CARS_REVIEW = "review"
        const val CARS_FEATURE = "cars_feature"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName: TextView = findViewById(R.id.tvNameDetail)
        val tvType: TextView = findViewById(R.id.tvTypeDetail)
        val tvPrice: TextView = findViewById(R.id.tvPriceDetail)
        val tvTitleDesc: TextView = findViewById(R.id.tvDescriptionTitleDetail)
        val tvTextDesc: TextView = findViewById(R.id.tvDescriptionTextDetail)
        val colorReds: CircleImageView = findViewById(R.id.colorsRed)
        val colorBlack: CircleImageView = findViewById(R.id.colorBlack)
        val colorWhite: CircleImageView = findViewById(R.id.colorWhite)
        val colorGrey: CircleImageView = findViewById(R.id.colorGrey)
        val imageColor: ImageView = findViewById(R.id.imgSelectColors)
        val imageBackground: ImageView = findViewById(R.id.imageBackground)
        val btnBrosure : MaterialButton = findViewById(R.id.btnBrosur)
        val btnWebsite : MaterialButton = findViewById(R.id.btnGoWebs)
        val btnDealaer : MaterialButton = findViewById(R.id.btnDealer)
        val btnSpec : MaterialButton = findViewById(R.id.btnSpec)
        val btnReview : MaterialButton = findViewById(R.id.btnReview)
        val btnFeature : MaterialButton = findViewById(R.id.btnFeature)

        val name = intent.getStringExtra(CARS_NAME)
        val typeCars = intent.getStringExtra(CARS_TYPE)
        val price = intent.getStringExtra(CARS_PRICE)
        val titleDesc = intent.getStringExtra(CARS_TITLE_DESCRIPTION)
        val textDesc = intent.getStringExtra(CARS_TEXT_DESCRIPTION)
        val textWebs = intent.getStringExtra(CARS_WEBS)
        val textBrosur = intent.getStringExtra(CARS_BROSURE)
        val spefication = intent.getStringExtra(CARS_SPEC)
        val feature = intent.getStringExtra(CARS_FEATURE)
        val reviewVideo = intent.getStringExtra(CARS_REVIEW)
        val redColors = intent.getIntExtra(CARS_COLORS_RED, 0)
        val blackColors = intent.getIntExtra(CARS_COLORS_BLACK, 0)
        val greyColors = intent.getIntExtra(CARS_COLORS_GREY, 0)
        val whiteColors = intent.getIntExtra(CARS_COLORS_WHITE, 0)
        val background = intent.getIntExtra(CARS_BACKGROUND,0)

        tvName.text = name
        tvType.text = typeCars
        tvPrice.text = price
        tvTitleDesc.text = titleDesc
        tvTextDesc.text = textDesc
        imageColor.setImageResource(redColors)
        imageBackground.setImageResource(background)

        btnWebsite.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(textWebs)
            startActivity(intent)
        }

        btnBrosure.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(textBrosur)
            startActivity(intent)
        }

        btnSpec.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spefication)
            startActivity(intent)
        }

        btnFeature.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(feature)
            startActivity(intent)
        }

        btnReview.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(reviewVideo)
            startActivity(intent)
        }

        btnDealaer.setOnClickListener {
            val url = "https://www.mazda.co.id/find-a-dealer"
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }




        supportActionBar?.title = "$name $typeCars"
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        colorReds.setOnClickListener {
            imageColor.setImageResource(redColors)
        }

        colorBlack.setOnClickListener {
            imageColor.setImageResource(blackColors)
        }

        colorGrey.setOnClickListener {
            imageColor.setImageResource(greyColors)
        }

        colorWhite.setOnClickListener {
            imageColor.setImageResource(whiteColors)
        }


        lateinit var bottomSheet: BottomSheetBehavior<LinearLayout>
        val btnShowAll: MaterialButton = findViewById(R.id.btnShowDetail)
        val linearLayout: LinearLayout = findViewById(R.id.btm_sheet)
        bottomSheet = BottomSheetBehavior.from(linearLayout)

        bottomSheet.state = BottomSheetBehavior.STATE_HIDDEN

        btnShowAll.setOnClickListener {
            bottomSheet.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detailmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.btnShare ->{
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    val name = intent.getStringExtra(CARS_NAME)
                    val typeCars = intent.getStringExtra(CARS_TYPE)
                    val price = intent.getStringExtra(CARS_PRICE)
                    val webs = intent.getStringExtra(CARS_WEBS)
                    putExtra(Intent.EXTRA_TEXT, "Beli $name $typeCars " +
                            "Harga Mulai Dari $price. Kunjungi $webs Untuk Info lebih lanjut ")
                    type = "text/plain"
                }
                startActivity(shareIntent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }

    override fun onSupportNavigateUp():Boolean{
        onBackPressed()
        return true
    }
}