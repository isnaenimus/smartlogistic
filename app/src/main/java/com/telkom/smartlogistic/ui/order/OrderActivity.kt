package com.telkom.smartlogistic.ui.order

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.DatePicker
import android.widget.EditText
import androidx.core.content.ContentProviderCompat.requireContext
import com.telkom.smartlogistic.R
import com.telkom.smartlogistic.base.BaseBottomNavigationActivity
import com.telkom.smartlogistic.databinding.ActivityOrderBinding
import com.telkom.smartlogistic.framework.core.owner.ViewDataBindingOwner
import com.telkom.smartlogistic.framework.core.owner.ViewModelOwner
import com.telkom.smartlogistic.ui.onboarding.OnboardingActivity
import com.telkom.smartlogistic.ui.order.adapters.SearchPagerAdapter
import com.telkom.smartlogistic.ui.order.fragments.NewSearchFragment
import com.telkom.smartlogistic.ui.order.fragments.SavedSearchFragment
import kotlinx.android.synthetic.main.activity_order.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class OrderActivity : BaseBottomNavigationActivity(),
        OrderView,
        ViewModelOwner<OrderViewModel>,
        ViewDataBindingOwner<ActivityOrderBinding> {

    override lateinit var binding: ActivityOrderBinding
    override val viewModel: OrderViewModel by viewModel()
    override fun getViewLayoutResId() = R.layout.activity_order

    private var pagerAdapter: SearchPagerAdapter? = null
    private var etLoadingDate: EditText? = null
    private var cal = Calendar.getInstance()

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, OrderActivity::class.java)
            context.startActivity(intent)
            (context as Activity).finish()
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action === MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(ev.getRawX().toInt(), ev.getRawY().toInt())) {
                    v.clearFocus()
                    val imm: InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0)
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        etLoadingDate!!.setText(sdf.format(cal.getTime()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        etLoadingDate = this.et_loading_date

        val ports = arrayOf("Pelabuhan Merak", "Pelabuhan Kalimas", "Pelabuhan Sunda Kelapa", "Pelabuhan Bakauheni")
        val portsAdapter = ArrayAdapter<String>(this, R.layout.item_port, R.id.tv_port_name, ports)

        tv_sender_port.setAdapter(portsAdapter)
        tv_sender_port.threshold = 1

        tv_receiver_port.setAdapter(portsAdapter)
        tv_receiver_port.threshold = 1

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

        etLoadingDate!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                DatePickerDialog(this@OrderActivity,
                        dateSetListener,
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })

        setPagerAdapter()
    }

    private fun setPagerAdapter() {
        pagerAdapter = SearchPagerAdapter(supportFragmentManager).apply {
            addFragment(
                    NewSearchFragment(),
                    getString(R.string.title_new_search)
            )
            addFragment(
                    SavedSearchFragment(),
                    getString(R.string.title_saved_search)
            )
        }
        binding.searchPager.apply {
            adapter = pagerAdapter
            binding.searchTabs.also {
                it.setupWithViewPager(this)
                it.getTabAt(0)?.select()
            }
        }
    }

    override fun getBottomNavigationMenuItemId(): Int {
        return R.id.navigation_order
    }

    override fun onClick(view: View) {
        OnboardingActivity.startThisActivity(this)
        finish()
    }
}