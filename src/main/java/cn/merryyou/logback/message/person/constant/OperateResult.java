package cn.merryyou.logback.message.person.constant;

import com.baidu.bjf.remoting.protobuf.EnumReadable;

/**
 * Created on 2017/11/25 0025.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public enum OperateResult implements EnumReadable {
    SUCCESS(1), FAILED(0);

    private final int value;

    OperateResult(int value) {
        this.value = value;
    }

    @Override
    public int value() {
        return 0;
    }
}
