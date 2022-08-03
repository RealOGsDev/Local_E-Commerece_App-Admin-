package devs.redfox.locale_commerceadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import devs.redfox.locale_commerceadmin.adapter.AllOrderAdapter
import devs.redfox.locale_commerceadmin.databinding.ActivityAllOrderBinding
import devs.redfox.locale_commerceadmin.model.AllOrderModel

class AllOrderActivity : AppCompatActivity() {


    private lateinit var list: ArrayList<AllOrderModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_order)

        list = ArrayList()

        val recyclerView = findViewById<RecyclerView>(R.id.rvAllOrder)
        val swipeAdmin = findViewById<SwipeRefreshLayout>(R.id.swipeAdmin)

        val adapter = AllOrderAdapter(list, this)
        Firebase.firestore.collection("allOrders").get().addOnSuccessListener {
            list.clear()
            for (doc in it){
                val data = doc.toObject(AllOrderModel::class.java)
                list.add(data)
                adapter.notifyDataSetChanged()
            }
            adapter.notifyDataSetChanged()
            recyclerView.adapter = adapter
        }

        swipeAdmin.setOnRefreshListener {
            adapter.notifyDataSetChanged()
            Handler().postDelayed(Runnable {
                swipeAdmin.isRefreshing = false
            }, 4000)
        }
    }
}