package com.sise.abner.abaselib.base

import android.app.Activity
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.util.SparseArray
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 * Created by Abner on 2017/9/20.
 */
abstract class ABaseActivity : AppCompatActivity(), LifecycleRegistryOwner {


    protected lateinit var ex: Bundle
    protected lateinit var mContext: Activity
    protected val fm: FragmentManager = supportFragmentManager
    protected var currentFragment: Fragment? = null
    protected  var disposables:SparseArray<Disposable> = SparseArray()

    private val mRegistry = LifecycleRegistry(this)
    protected var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    override fun getLifecycle(): LifecycleRegistry {
        return mRegistry
    }


    /**
     * 添加事件监听处理到 事件管理类
     *
     * @param disposable 上流事件
     */
    protected fun addSubscription(disposable: Disposable) {

        compositeDisposable?.let {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable?.add(disposable)
    }

    /**
     *  添加事件监听处理到 事件管理类
     */
    protected fun addSubscription(disposable: Disposable,tag:Int) {

        compositeDisposable?.let {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable?.add(disposable)
        disposables.put(tag,disposable)
    }

    /**
     * RxJava取消注册，避免内存泄露
     * 取消以后就只能重新新建一个了
     */
    protected fun onUnsubscribe() {
        if (compositeDisposable != null) {
            // Using clear will clear all, but can accept new disposable
            compositeDisposable?.clear()
            // Using dispose will clear all and set isDisposed = true, so it will not accept any new disposable
            compositeDisposable?.dispose()
            compositeDisposable = null
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        onUnsubscribe()
    }

    override fun onPause() {
        super.onPause()
//        onUnsubscribe()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
        if (getLayout()!=0)
            setContentView(getLayout())
        mContext = this
//        ex = getIntent().getExtras()
        initViewModel()
        initFragment()
        initView(savedInstanceState)

    }

    /**
     * 初始化布局
     */
    abstract fun initView(savedInstanceState: Bundle?)

    /**
     * 初始化ViewModel
     */
    abstract fun initViewModel()

    abstract fun getLayout(): Int


    fun gotoActivity(clz: Class<Any>) {
        gotoActivity(clz, false)
    }

    fun gotoActivity(clz: Class<Any>, isCloseCurrentActivity: Boolean) {
        gotoActivity(clz, isCloseCurrentActivity, null)
    }

    fun gotoActivity(clz: Class<Any>, isCloseCurrentActivity: Boolean, ex: Bundle?) {
        val intent = Intent(this, clz)
        if (ex != null) intent.putExtras(ex)
        startActivity(intent)
        if (isCloseCurrentActivity) {
            finish()
        }
    }


    //布局中Fragment的ID
    protected fun getFragmentContentId(): Int{
        return 0
    }

    protected abstract fun initFragment()

    protected fun showFragment(fragment: ABaseFragment, position: Int) {
        this.showFragment(fragment, position, null)
    }

    protected fun showFragment(fragment: ABaseFragment, position: Int, bundle: Bundle?) {
        val transaction = fm.beginTransaction()
        //Fragment添加
        if (!fragment.isAdded) {
            fragment.arguments = bundle
            transaction.add(getFragmentContentId(), fragment, position.toString() + "")
        }
        if (currentFragment == null)
            currentFragment = fragment
        //通过tag进行过渡动画滑动判断
        //        if (Integer.parseInt(currentFragment.getTag()) >= Integer.parseInt(fragment.getTag())) {
        //            transaction.setCustomAnimations(R.anim.fragment_push_left_in, R.anim.fragment_push_right_out);
        //        } else {
        //            transaction.setCustomAnimations(R.anim.fragment_push_right_in, R.anim.fragment_push_left_out);
        //        }
        currentFragment?.let {
//            transaction.hide(currentFragment).show(fragment)
        }
        transaction.commit()
        currentFragment = fragment

    }

    protected fun showFragment(fragment: Fragment, position: Int, bundle: Bundle?) {
        val transaction = fm.beginTransaction()
        //Fragment添加
        if (!fragment.isAdded) {
            fragment.arguments = bundle
            transaction.add(getFragmentContentId(), fragment, position.toString() + "")
        }
        if (currentFragment == null)
            currentFragment = fragment
        //通过tag进行过渡动画滑动判断
        //        if (Integer.parseInt(currentFragment.getTag()) >= Integer.parseInt(fragment.getTag())) {
        //            transaction.setCustomAnimations(R.anim.fragment_push_left_in, R.anim.fragment_push_right_out);
        //        } else {
        //            transaction.setCustomAnimations(R.anim.fragment_push_right_in, R.anim.fragment_push_left_out);
        //        }
        currentFragment?.let {
//            transaction.hide(currentFragment).show(fragment)
        }
        transaction.commit()
        currentFragment = fragment

    }


    protected fun addFragment(fragment: ABaseFragment) {

    }

    protected fun removeFragment(fragment: ABaseFragment) {

    }

    /**
     * @author Abner
     * *create at 2017/6/27
     * @Params [fragment, contentId, bundle]
     * @retrun void
     * * 跳转下一个fragment
     */
    protected fun gotoFragment(fragment: ABaseFragment, bundle: Bundle) {
        fragment.arguments = bundle
        val ft = fm.beginTransaction()
        ft.replace(getFragmentContentId(), fragment)
        ft.commit()
    }


    override fun finish() {
        super.finish()
        ActivityCollector.removeActivity(this)
    }

    fun hideSoftInput(et:EditText)
    {
        val imm = et.context.getSystemService(
                Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(
                    et.applicationWindowToken, 0)
        }
    }

}