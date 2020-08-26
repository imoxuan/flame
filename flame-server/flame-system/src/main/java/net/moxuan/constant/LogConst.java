package net.moxuan.constant;

/**
 * @author moxuan
 */
public interface LogConst {

    /**
     * 系统日志类型： 登录
     */
    int LOG_TYPE_LOGIN = 1;

    /**
     * 系统日志类型： 操作
     */
    int LOG_TYPE_OPERATION = 2;

    /**
     * 系统日志类型：定时任务
     */
    int LOG_TYPE_CRON_JOB = 3;

    /**
     * 操作类型：添加
     */
    int ACTION_TYPE_ADD = 1;
    /**
     * 操作类型：更新
     */
    int ACTION_TYPE_UPDATE = 2;
    /**
     * 操作类型：删除
     */
    int ACTION_TYPE_DELETE = 3;
    /**
     * 操作类型：查询
     */
    int ACTION_TYPE_QUERY = 4;
    /**
     * 操作类型：导入
     */
    int ACTION_TYPE_IMPORT = 5;
    /**
     * 操作类型：导出
     */
    int ACTION_TYPE_EXPORT = 6;
}
