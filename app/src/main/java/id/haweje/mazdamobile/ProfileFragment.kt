package id.haweje.mazdamobile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton


class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_profile, container, false)

        val githubUrl = "https://github.com/hendrawanwib"
        val linkedinUrl = "https://www.linkedin.com/in/haaweejee/"
        val instagramUrl = "https://www.instagram.com/haaweejee/"
        val mazdaUrl = "https://www.mazda.co.id/?q="
        val otoUrl = "https://www.oto.com/"

        val btnGithub : MaterialButton = view.findViewById(R.id.btnGithub)
        val btnLinked : MaterialButton = view.findViewById(R.id.btnLinkedin)
        val btnInsta : MaterialButton = view.findViewById(R.id.btnInsta)
        val btnMazda : MaterialButton = view.findViewById(R.id.btnMazdaIndonesia)
        val btnOto : MaterialButton = view.findViewById(R.id.btnOto)

        btnGithub.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(githubUrl)
            startActivity(intent)
        }

        btnLinked.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(linkedinUrl)
            startActivity(intent)
        }

        btnInsta.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(instagramUrl)
            startActivity(intent)
        }

        btnMazda.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(mazdaUrl)
            startActivity(intent)
        }

        btnOto.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(otoUrl)
            startActivity(intent)
        }
        return view

    }



}