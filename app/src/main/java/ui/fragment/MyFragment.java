package ui.fragment;


import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.adapters.MyFragAdapter;
import com.admom.mygreendaotest.TotalUserDao;
import com.example.group.teamproject2.R;
import com.example.group.teamproject2.beans.DayUser;
import com.example.group.teamproject2.beans.TotalUser;
import com.example.group.teamproject2.commom.BaseFragment;
import com.example.group.teamproject2.utils.GreenDaoUtils;

import java.util.List;

import persenter.MainPersenter;
import ui.view.MainView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment implements MainView {
    private MainPersenter mPersenter;
    public RecyclerView mRecyclerView;
    private DayUser mDayUser;
    private MyFragAdapter mAdapter;
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 102:
                    List<TotalUser> users= (List<TotalUser>) msg.obj;

//                    mAdapter.notifyDataSetChanged();

                    initAd(users);

                    break;
            }
        }
    };


    private void initAd(List<TotalUser> users) {
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);

        Log.i("TAG", "----------->数据mUser:" +users);
        mAdapter = new MyFragAdapter(getActivity(), users);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected int getLayoutId() {
        mPersenter=new MainPersenter(this);
        return  R.layout.fragment_my;
    }

    @Override
    protected void initView(View ret) {
        mRecyclerView= (RecyclerView) ret.findViewById(R.id.myfragment_recycleView);
    }

    protected void initEvent() {
        GreenDaoUtils.insertData(23,72.5f,65.0f,20,155.0f,true);
    }

    protected void initData() {
        mDayUser=new DayUser();
        mDayUser.setCurrent("2017-1-10");
        mDayUser.setDistance(25.5f);
        mDayUser.setDuration(20.3f);
        mPersenter.showInfo(TotalUserDao.Properties.Id);
    }

    protected void initAdapter() {

    }

    @Override
    public void getUserData(List<TotalUser> users) {
        Log.i("TAG", "----------->这里面是空的吗:" +users.size());
        Log.i("TAG", "----------->不是空的数据是什么:" +users);
        Message msg=Message.obtain();
        msg.what=102;
        msg.obj=users;
        mHandler.sendMessage(msg);
    }

}
