package ui.view;

import com.example.group.teamproject2.beans.TotalUser;

import java.util.List;

/**
 * Created by Administrator on 2016/12/31.
 */

public interface MainView extends BaseView{
    void getUserData(List<TotalUser> users);
}
