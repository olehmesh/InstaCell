package com.olehmesh.instacell.extensions

import android.graphics.Typeface.BOLD
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.text.style.ImageSpan
import android.text.style.StyleSpan
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.text.bold
import androidx.core.text.set
import androidx.databinding.BindingAdapter
import com.olehmesh.instacell.R

@BindingAdapter("setLikesList")
fun AppCompatTextView.setLikesList(likes: List<String>) {

    val likeSpan = SpannableStringBuilder(context.getString(R.string.liked_by))

    val listSpan = SpannableStringBuilder(likes.subList(0, 2).joinToString()).apply {
        setSpan(
            StyleSpan(BOLD),
            0,
            this.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
    val restSpan = TextUtils.concat(
        SpannableString(context.getString(R.string.and)),
        SpannableString((likes.size - 2).toString() + context.getString(R.string.others)).apply {
            setSpan(
                StyleSpan(BOLD),
                0,
                this.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        })
    this.text = TextUtils.concat(likeSpan, listSpan, restSpan)
}


@BindingAdapter("setHashTagsList")
fun AppCompatTextView.setHashTagsList(hashTags: List<String>) {
    if (hashTags.isNotEmpty()) {

        val startHashTagSpan = SpannableStringBuilder(context.getString(R.string.beauty))

        val hashTagSpanLogin = SpannableStringBuilder().bold {
            append(context.getString(R.string.milena_browbar))
        }

        val listUsersSpan =
            SpannableStringBuilder(
                hashTags.subList(0, hashTags.size).joinToString().replace(
                    context.getString(
                        R.string.comma
                    ).toRegex(), ""
                )
            )
                .apply {
                    setSpan(
                        ForegroundColorSpan(
                            ContextCompat.getColor(context, R.color.hash_tags_text_color)
                        ),
                        0,
                        this.length,
                        Spannable.SPAN_EXCLUSIVE_INCLUSIVE
                    )

                    this.insert(15, " ")
                    this[15..16] = ImageSpan(context, R.drawable.ic_heart_span)
                    this.insert(16, " ")
                    this[17..18] = ImageSpan(context, R.drawable.ic_planet_span)
                    this.insert(18, " ")
                    this[19..20] = ImageSpan(context, R.drawable.ic_moon_span)
                    this.insert(20, " ")
                }

        this.text = TextUtils.concat(hashTagSpanLogin, startHashTagSpan, listUsersSpan)

    }
}


