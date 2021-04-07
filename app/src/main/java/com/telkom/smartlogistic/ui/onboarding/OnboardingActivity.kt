package com.telkom.smartlogistic.ui.onboarding

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.telkom.smartlogistic.R
import com.telkom.smartlogistic.databinding.ActivityOnboardingBinding
import com.telkom.smartlogistic.framework.core.base.BaseActivity
import com.telkom.smartlogistic.framework.core.owner.ViewDataBindingOwner
import com.telkom.smartlogistic.framework.util.manager.PrefManager
import com.telkom.smartlogistic.ui.dashboard.DashboardActivity
import com.telkom.smartlogistic.ui.loginorsignup.LoginOrSignUpActivity


/**
 * Created by Isnaeni on 08/03/2021.
 */
class OnboardingActivity : BaseActivity(),
    ViewDataBindingOwner<ActivityOnboardingBinding> {

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, OnboardingActivity::class.java)
            context.startActivity(intent)
            (context as Activity).finish()
        }
    }

    override fun getViewLayoutResId() = R.layout.activity_onboarding
    override lateinit var binding: ActivityOnboardingBinding

    private var onboardingAdapter: OnboardingAdapter? = null
    private var mDots: Array<ImageView?>? = null
    private var mCurrentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setAdapter()
        setListener()
    }

    private fun setAdapter() {
        onboardingAdapter = OnboardingAdapter(this)
        binding.slideView.adapter = onboardingAdapter
        addDotsIndicator(0)
        binding.slideView.addOnPageChangeListener(viewListener)
    }

    private fun setListener() {
        binding.imageNext.setOnClickListener {
            if (mDots?.size!! - 1 == mCurrentPage) {
                goToNextPage()
            } else {
                binding.slideView.currentItem = mCurrentPage + 1
            }
        }
        binding.textSkip.setOnClickListener {
            goToNextPage()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun addDotsIndicator(position: Int) {
        mDots = arrayOfNulls(3)
        binding.dots.removeAllViews()
        for (i in mDots?.indices!!) {

            val ll = LinearLayout(this)
            ll.orientation = LinearLayout.VERTICAL
            val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            layoutParams.setMargins(5, 0, 5, 0)

            mDots!![i] = ImageView(this)
            mDots!![i]?.background = ContextCompat.getDrawable(this, R.drawable.ic_step_bar_inactive)
            binding.dots.addView(mDots!![i], layoutParams)
        }
        if (mDots?.isNotEmpty()!!) {
            mDots!![position]?.background = ContextCompat.getDrawable(this, R.drawable.ic_step_bar_active)
        }
    }
    private var viewListener: ViewPager.OnPageChangeListener = object :
            ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
        ) {
            //ignore
        }

        override fun onPageSelected(position: Int) {
            addDotsIndicator(position)
            mCurrentPage = position
            when (position) {
                0 -> {
                    binding.textSkip.visibility = View.VISIBLE
                    binding.imageBack.visibility = View.GONE
                }
                mDots?.size!! - 1 -> {
                    binding.textSkip.visibility = View.GONE
                    binding.imageBack.visibility = View.VISIBLE
                }
                else -> {
                    binding.textSkip.visibility = View.VISIBLE
                    binding.imageBack.visibility = View.VISIBLE
                }
            }
        }

        override fun onPageScrollStateChanged(state: Int) {
            //ignore
        }
    }

    private fun goToNextPage() {
        PrefManager.ONBOARDING = false
        LoginOrSignUpActivity.startThisActivity(this)
        finish()
    }

}