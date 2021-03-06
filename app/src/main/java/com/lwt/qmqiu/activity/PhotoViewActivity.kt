package com.lwt.qmqiu.activity

import android.os.Bundle
import com.hw.ycshareelement.YcShareElement
import com.hw.ycshareelement.transition.IShareElements
import com.hw.ycshareelement.transition.ShareElementInfo
import com.lwt.qmqiu.R
import com.lwt.qmqiu.adapter.PhotoViewPageAdapter
import com.lwt.qmqiu.bean.PhotoViewData
import kotlinx.android.synthetic.main.activity_photoview.*
import java.util.ArrayList

class PhotoViewActivity:BaseActivity(), PhotoViewPageAdapter.PhotoSingleClick , IShareElements {



    private lateinit var mAdapter:PhotoViewPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        YcShareElement.setEnterTransitions(this, this, true)

        super.onCreate(savedInstanceState)

        //changeStatusColor(R.color.black)

        setContentView(R.layout.activity_photoview)

        var list =intent.getParcelableArrayListExtra<PhotoViewData>("photoViewData")

        var index =intent.getIntExtra("index",0)
        //是否加密
        var real =intent.getBooleanExtra("real",true)

        mAdapter = PhotoViewPageAdapter(this,list,this,real)

        view_pager.adapter = mAdapter

        view_pager.currentItem = getRealIndex(list,index)

        YcShareElement.postStartTransition(this)
    }

    override fun photoViewSingleClick() {

        super.onBackPressed()

    }

    private fun  getRealIndex(list: ArrayList<PhotoViewData>, realIndex: Int):Int{

        list.forEachIndexed { index, photoViewData ->

            if (photoViewData.position == realIndex)
                return index

        }

        return 0

    }

    override fun getShareElements(): Array<ShareElementInfo<PhotoViewData>> {

        val obj=mAdapter.getCurrentObj(view_pager.currentItem)

        return arrayOf(obj)
    }

    override fun finishAfterTransition() {
        YcShareElement.finishAfterTransition(this, this)
        super.finishAfterTransition()
    }


}