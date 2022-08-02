package devs.redfox.locale_commerceadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import devs.redfox.locale_commerceadmin.adapter.AllOrderAdapter
import devs.redfox.locale_commerceadmin.databinding.ActivityAllOrderBinding
import devs.redfox.locale_commerceadmin.model.AllOrderModel

class AllOrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAllOrderBinding
    private lateinit var list: ArrayList<AllOrderModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()
        val adapter = AllOrderAdapter(list, this)
        Firebase.firestore.collection("allOrders").get().addOnSuccessListener {
            list.clear()
            for (doc in it){
                val data = doc.toObject(AllOrderModel::class.java)
                list.add(data)
            }
        }

        adapter.notifyDataSetChanged()
        binding.rvAllOrder.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}