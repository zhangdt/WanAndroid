package com.sise.abner.abaselib.net;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 线程调度管理类
 */
public class RxSchedulers {

    /**
     * <Pre>
     *      切换线程,并处理异常
     *      针对后台进行了统一适配处理
     * </Pre>
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<WanAndroidBaseResp<T>, T> responseTransform() {
        return new ObservableTransformer<WanAndroidBaseResp<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<WanAndroidBaseResp<T>> upstream) {
                return upstream
//                        .onErrorResumeNext(new ErrorHandleFunction<>())
                        .flatMap(new Function<WanAndroidBaseResp<T>, ObservableSource<T>>() {
                            @Override
                            public ObservableSource<T> apply(WanAndroidBaseResp<T> t) throws Exception {
                                if (t.getErrorCode() == 0) {
                                    return Observable.just(t.getData());
                                }
                                return Observable.error(new Exception(t.getErrorMsg()));
                            }
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
    /**
     * 子线程到主线程的切换
     *
     * @param <T> 传递的实体类
     * @return
     */
    public static <T> ObservableTransformer<T, T> ioMain() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 切入到子线程中
     *
     * @param <T> 传递的实体类
     * @return
     */
    public static <T> ObservableTransformer<T, T> io() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream.observeOn(Schedulers.io());
            }
        };
    }

}
