package wustor.view;

/**
 * Created by Administrator on 2018/5/11 0011.
 * 这里的V采取泛型的原因在于每个界面需要获取的数据不一样，
 * 所以用泛型加以区分，
 * 当一个界面需要获取的接口很多，
 * 或者得到的数据结果类型不太一致的时候，
 * 这里的泛型就需要用Object来指定，
 * 然后在refreshView中通过数据的类型来判断需要刷新的数据
 */

public interface ViewCallBack<V> {
    /**
     *
     * @param code 数据
     * @param data 数据类型
     */
    void refreshView(int code,V data);
}
