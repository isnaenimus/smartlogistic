package com.telkom.smartlogistic.ui.onboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.telkom.smartlogistic.R
/**
 * Created by Isnaeni on 09/03/2021.
 */
class OnboardingAdapter(private val context: Context) :
        PagerAdapter() {
    private var layoutInflater: LayoutInflater? = null

    private val slideImages = intArrayOf(
            R.drawable.img_background_ob1,
            R.drawable.img_background_ob2,
            R.drawable.img_background_ob3
    )
    private val slideTitleTexts = arrayOf(
            context.getString(R.string.label_onboarding_title_1),
            context.getString(R.string.label_onboarding_title_2),
            context.getString(R.string.label_onboarding_title_3)
    )
    private val slideTexts = arrayOf(
            context.getString(R.string.label_onboarding_text_1),
            context.getString(R.string.label_onboarding_text_2),
            context.getString(R.string.label_onboarding_text_3)
    )

    override fun getCount() = slideImages.size

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view == o
    }

    override fun instantiateItem(constainer: ViewGroup, postion: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater?.inflate(R.layout.slide_layout, constainer, false)
        val background = view?.findViewById<LinearLayout>(R.id.backround_1)
        val slideText = view?.findViewById<TextView>(R.id.text_onboarding)
        val slideTitleText = view?.findViewById<TextView>(R.id.text_title_onboarding)
        background?.setBackgroundResource(slideImages[postion])
        slideText?.text = slideTexts[postion]
        slideTitleText?.text = slideTitleTexts[postion]
        constainer.addView(view)
        return view!!
    }

    override fun destroyItem(
            container: ViewGroup,
            position: Int,
            `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}