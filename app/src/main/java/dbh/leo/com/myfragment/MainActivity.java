package dbh.leo.com.myfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import dbh.leo.com.myfragment.fragment.AnotherFragment;
import dbh.leo.com.myfragment.fragment.ContentFragment;
import dbh.leo.com.myfragment.fragment.MyDialogFragment;
import dbh.leo.com.myfragment.fragment.TitleFragment;

/**
 * a、如果你Activity中包含自己管理的Fragment的引用，可以通过引用直接访问所有的Fragment的public方法
 * b、如果Activity中未保存任何Fragment的引用，那么没关系，每个Fragment都有一个唯一的TAG或者ID,可以通过getFragmentManager.findFragmentByTag()或者findFragmentById()获得任何Fragment实例，然后进行操作。
 * c、在Fragment中可以通过getActivity得到当前绑定的Activity的实例，然后进行操作。
 */
public class MainActivity extends AppCompatActivity implements TitleFragment.FragmentTitleClickListener,
        ContentFragment.ContentFragmentClickListener, AnotherFragment.AnotherFragmentClickListener, MyDialogFragment.OnLoginCompleteListener {

    private static final String TAG = "MainActivity";
    private TitleFragment titleFragment;
    private ContentFragment contentFragment;
    private AnotherFragment anotherFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, savedInstanceState + "");
        if (savedInstanceState == null) {
            //检查Bundle是否为空，判断MainActivity是否重建
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.id_content, new TitleFragment(), "title");
            transaction.commit();
        }

    }

    @Override
    public void onTitleBtnClick() {
        if (contentFragment == null) {
            contentFragment = new ContentFragment();
            //注册点击事件
            contentFragment.setContentClcikListener(this);
        }
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.id_content, contentFragment, "content");
        transaction.addToBackStack("content");
        transaction.commit();
    }

    @Override
    public void onContentClick() {
        if (anotherFragment == null) {
            anotherFragment = new AnotherFragment();
            //注册点击事件
            anotherFragment.setAnotherClickListener(this);


        }
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transition = manager.beginTransaction();
        //使用hide而不是replace视图将不会重绘
        //当back回来的时候，之前数据将会保留
        transition.hide(contentFragment);
        transition.add(R.id.id_content, anotherFragment, "another");
//        transition.replace(R.id.id_content, anotherFragment, "another");
        transition.addToBackStack("another");
        transition.commit();
    }

    @Override
    public void onAnotherClick() {
        if (anotherFragment == null) {
            anotherFragment = new AnotherFragment();
            //注册点击事件
            anotherFragment.setAnotherClickListener(this);

        }
        Toast.makeText(this, "I am another fragment", Toast.LENGTH_SHORT).show();

//        showDialogFragment();
        showDifferentDialog();
    }

    /**
     * dialogfragment
     */
    private void showDialogFragment() {
        MyDialogFragment nameFragment = new MyDialogFragment();
        nameFragment.show(getSupportFragmentManager(), "loginDialog");
    }

    /**
     * 适配不同大小的屏幕
     * 大屏幕以dialog形式显示（注意此处只能通过重写onCreateView来实现）
     * 小屏幕直接嵌入到当前activity
     */
    private void showDifferentDialog() {
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment nameFragment = new MyDialogFragment();
        boolean isLargeLayout = getResources().getBoolean(R.bool.large_layout);
        if (isLargeLayout) {
            nameFragment.show(manager, "largeLayout");
        } else {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.replace(R.id.framelayout, nameFragment);
            transaction.commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "click in activity ---> settings", Toast.LENGTH_SHORT).show();
                return true;
            default:
//            return true;
                //如果希望fragment自己处理菜单点击事件，此处需要调用super
                return super.onOptionsItemSelected(item);
        }

    }

    /**
     * 登录回调
     *
     * @param name
     * @param password
     */
    @Override
    public void onLoginInputComplete(String name, String password) {
        Toast.makeText(getApplicationContext(), "login completed and username = " + name + ",password = " + password, Toast.LENGTH_SHORT).show();
    }
}
