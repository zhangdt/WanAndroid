package com.sise.abner.abaselib.ARVAH

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.orhanobut.logger.Logger
import java.lang.reflect.Constructor
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Modifier
import java.lang.reflect.ParameterizedType

/**
 * Created by Abner on 2018/3/17.
 */
abstract class BaseRVAdapter<K, V : BaseViewHolder> : RecyclerView.Adapter<V>() {
    companion object {
        val TAG: String = "BaseRVAdapter"
        val HEADER_VIEW = 0x00000111
        val LOADING_VIEW = 0x00000222
        val FOOTER_VIEW = 0x00000333
        val EMPTY_VIEW = 0x00000555
    }

    var mData: ArrayList<K>? = null
    var layoutId: Int? = null
    internal var _onItemClick: (Int) -> Unit = {}
    internal var _onItemLongClick: (Int) -> Unit = {}
    var mEmptylayoutId: Int? = null
    var mEmptyLayoutView: FrameLayout? = null
    lateinit var mContext:Context
    fun adapterInit(init: BaseRVAdapter<K, V>.() -> Unit): BaseRVAdapter<K, V> {
        init()
        notifyDataSetChanged()
        Log.i(TAG, javaClass.name)
        return this
    }

    fun setEmptyView(emptyLayoutId: Int) {
        this.mEmptylayoutId = emptyLayoutId
        if (mEmptyLayoutView == null) {
            mEmptyLayoutView = FrameLayout(mContext)

        }
    }

     fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): V? {
        var baseViewHoler: V? = null
        when (viewType) {
            HEADER_VIEW -> {

            }
            EMPTY_VIEW -> {
                baseViewHoler = createBaseViewHolder(mEmptyLayoutView as View)
            }
            else -> {
                baseViewHoler = createBaseViewHolder(getViewByLayoutId(this!!.layoutId!!, parent!!))
                onBindViewClickListener(baseViewHoler)
            }
        }

        return baseViewHoler
    }

    //用来绑定Itme的点击事件
    fun onBindViewClickListener(holder: BaseViewHolder) {
        val view = holder.itemView
        if (view == null) {
            return
        }
        view.setOnClickListener {
            _onItemClick(holder.adapterPosition)
        }
        view.setOnLongClickListener {
            _onItemLongClick(holder.adapterPosition)
            return@setOnLongClickListener true
        }
    }

    fun onItemClick(onItemClick: (Int) -> Unit) {
        _onItemClick = onItemClick
    }

    fun onItemLongClick(onItemLongClick: (Int) -> Unit) {
        _onItemLongClick = onItemLongClick
    }


    override fun onBindViewHolder(holder: V, position: Int) {
        if (!isShowEmptyView()) convert(holder, mData!![position])
    }

    //
    fun getViewByLayoutId(layoutId: Int, parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
    }


    override fun getItemCount(): Int {
        Logger.e("BaseRVAdapter", "getItemCount:" + mData)
        var count: Int = 0
        if (isShowEmptyView()) {
            count = 1
        } else if (mData != null && mData!!.size > 0) {
            count = mData!!.size
        }
        return count
    }

    override fun getItemViewType(position: Int): Int {
        if (isShowEmptyView())
            return EMPTY_VIEW
        return super.getItemViewType(position)
    }

    fun isShowEmptyView(): Boolean {
        if (mEmptyLayoutView == null) {
            return false
        }
        if (mData?.size!! > 0) {
            return false
        }
        return true
    }


    /**
     * if you want to use subclass of BaseViewHolder in the adapter,
     * you must override the method to create new ViewHolder.
     *
     * @param view view
     * @return new ViewHolder
     */
    protected fun createBaseViewHolder(view: View): V {
        var temp: Class<*>? = javaClass
        var z: Class<*>? = null
        while (z == null && null != temp) {
            z = getInstancedGenericKClass(temp)
            temp = temp.superclass
        }
        val k: V?
        // 泛型擦除会导致z为null
        if (z == null) {
            k = BaseViewHolder(view) as V
        } else {
            k = createGenericKInstance(z, view)
        }
        return k ?: BaseViewHolder(view) as V
    }

    /**
     * try to create Generic K instance
     *
     * @param z
     * @param view
     * @return
     */
    private fun createGenericKInstance(z: Class<*>, view: View): V? {
        try {
            val constructor: Constructor<*>
            // inner and unstatic class
            if (z.isMemberClass && !Modifier.isStatic(z.modifiers)) {
                constructor = z.getDeclaredConstructor(javaClass, View::class.java)
                constructor.isAccessible = true
                return constructor.newInstance(this, view) as V
            } else {
                constructor = z.getDeclaredConstructor(View::class.java)
                constructor.isAccessible = true
                return constructor.newInstance(view) as V
            }
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }

        return null
    }

    /**
     * get generic parameter K
     *
     * @param z
     * @return
     */
    private fun getInstancedGenericKClass(z: Class<*>): Class<*>? {
        val type = z.genericSuperclass
        if (type is ParameterizedType) {
            val types = type.actualTypeArguments
            for (temp in types) {
                if (temp is Class<*>) {
                    if (BaseViewHolder::class.java.isAssignableFrom(temp)) {
                        return temp
                    }
                } else if (temp is ParameterizedType) {
                    val rawType = temp.rawType
                    if (rawType is Class<*> && BaseViewHolder::class.java.isAssignableFrom(rawType)) {
                        return rawType
                    }
                }
            }
        }
        return null
    }

    abstract fun convert(holder: V, item: K)
}