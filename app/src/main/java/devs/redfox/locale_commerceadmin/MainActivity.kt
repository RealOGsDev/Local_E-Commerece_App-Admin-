package devs.redfox.locale_commerceadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import devs.redfox.locale_commerceadmin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = resources.getColor(R.color.statusbar)
    }
}