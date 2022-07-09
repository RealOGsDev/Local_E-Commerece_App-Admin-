package devs.redfox.locale_commerceadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import devs.redfox.locale_commerceadmin.databinding.ActivityAllOrderBinding

class AllOrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAllOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}