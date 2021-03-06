package com.sise.abner.abaselib.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * Created by Abner on 2017/9/20.
 */
abstract class ABaseFragment : Fragment() {
    protected lateinit var mView: View
    protected lateinit var mContext: Context
    protected lateinit var fm: FragmentManager
    protected var isFragmentVisible: Boolean = false
    private var isPrepared: Boolean = false
    private var isLoadData:Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel(savedInstanceState)
    }

    override fun onCreateView(@NonNull inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(getLayout(), container, false)
        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mContext = this.activity!!
        initView(arguments)
        isPrepared = true
        loadData()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            isFragmentVisible = true
            loadData()
            onVisible()
        } else {
            isFragmentVisible = false
//            onInvisible()
        }
    }

    private fun loadData(){
        if (isFragmentVisible && !isLoadData && isPrepared)
        {
            onLoadData()
            isLoadData = true
        }
    }

    abstract fun onLoadData()

    abstract fun onVisible()


    fun gotoActivity(clz: Class<Any>) {
        gotoActivity(clz, false)
    }

    fun gotoActivity(clz: Class<Any>, isCloseCurrentActivity: Boolean) {
        gotoActivity(clz, isCloseCurrentActivity, null)
    }

    fun gotoActivity(clz: Class<Any>, isCloseCurrentActivity: Boolean, ex: Bundle?) {
        val intent = Intent(this.activity, clz)
        if (ex != null) intent.putExtras(ex)
        startActivity(intent)
        if (isCloseCurrentActivity) {
            this.activity?.finish()
        }
    }


    fun gotoFragment(fragment: ABaseFragment, contentId: Int, bundle: Bundle) {
        if (fm == null) {
            fm = fragmentManager!!
        }
        fragment.arguments = bundle
        val ft = fm.beginTransaction()
        ft.replace(contentId, fragment)
        ft.commit()
    }

    /**
     * 初始化布局
     */
    protected abstract fun initView(args: Bundle?)

    /**
     * 初始化ViewModel
     */
    protected abstract fun initViewModel(savedInstanceState: Bundle?)

    protected abstract fun getLayout(): Int
}