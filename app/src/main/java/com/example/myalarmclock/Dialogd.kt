package com.example.myalarmclock

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class TimeAlertDialog : DialogFragment() {
    interface Listener {
        fun getup()
        fun snooze()
    }
    private var listener :Listener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        when (context) {
            is Listener -> listener = context
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setMessage("時間になりました。")
        builder.setPositiveButton("起きる") { dialog, which ->
            listener?.getup()
        }
        builder.setNegativeButton("あと5分") { dialog,which ->
            listener?.snooze()
        }
        return builder.create()
    }
}